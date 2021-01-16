package com.app.controleur;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.Executable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.app.interfaces.accueil.Accueil;
import com.app.interfaces.accueil.ChangerMotDePasse;
import com.app.interfaces.administrateur.IDetailEleve;
import com.app.interfaces.comptable.IBulletinDeSalaireEmployer;
import com.app.interfaces.comptable.IBulletinDeSalaireProfesseur;
import com.app.interfaces.comptable.IComptabilite;
import com.app.interfaces.comptable.IDepense;
import com.app.interfaces.comptable.IFraisInscription;
import com.app.interfaces.comptable.IPaiementAuxiliaire;
import com.app.interfaces.comptable.IPaiementEmployer;
import com.app.interfaces.comptable.IPaiementProfesseur;
import com.app.interfaces.comptable.IPaiementScolarite;
import com.app.interfaces.comptable.IVersementBancaire;
import com.app.interfaces.recus.IRecuFraisInscription;
import com.app.interfaces.recus.IRecuPaiementAuxiliaire;
import com.app.interfaces.recus.IRecuPaiementEmployer;
import com.app.interfaces.recus.IRecuPaiementProfesseur;
import com.app.interfaces.recus.IRecuPaiementScolarite;
import com.app.metier.entites.Comptable;
import com.app.metier.entites.Depense;
import com.app.metier.entites.Eleve;
import com.app.metier.entites.FraisInscription;
import com.app.metier.entites.PaiementAuxiliaire;
import com.app.metier.entites.PaiementEmployer;
import com.app.metier.entites.PaiementProfesseur;
import com.app.metier.entites.PaiementScolarite;
import com.app.metier.entites.Personnel;
import com.app.metier.entites.Professeur;
import com.app.metier.entites.Resume;
import com.app.metier.entites.Versement;
import com.app.metier.model.ModelBulletinEmployer;
import com.app.metier.model.ModelBulletinProfesseur;
import com.app.metier.model.ModelDepense;
import com.app.metier.model.ModelEleve;
import com.app.metier.model.ModelEleveListe;
import com.app.metier.model.ModelEmployer;
import com.app.metier.model.ModelFraisInscription;
import com.app.metier.model.ModelPaiementAuxiliaire;
import com.app.metier.model.ModelPaiementEmployer;
import com.app.metier.model.ModelPaiementProfesseur;
import com.app.metier.model.ModelPaiementScolarite;
import com.app.metier.model.ModelProfesseur;
import com.app.metier.model.ModelResume;
import com.app.metier.model.ModelVersement;
import com.app.metier.service.IService;
import com.app.metier.service.Service;

public class Controleur {
	
	private IPaiementAuxiliaire iPaiementAuxiliaire;
	private IComptabilite iComptabilite ;
	private IVersementBancaire iVersement;
	private IDepense iDepense;
	private IDetailEleve iDetailEleve;
	private IBulletinDeSalaireProfesseur iBulletinProfesseur;
	private IBulletinDeSalaireEmployer iBulletinEmployer;
	private IFraisInscription iFraisInscription;
	private IPaiementScolarite iPaiementScolarite;
	private IPaiementProfesseur iPaiementProfesseur;
	private IPaiementEmployer iPaiementEmployer;
	private ModelDepense modelDepense ;
	private ModelPaiementScolarite modelPaiementScolarite ;
	private ModelPaiementProfesseur modelPaiementProfesseur ;
	private ModelPaiementEmployer modelPaiementEmployer ;
	private ModelPaiementAuxiliaire modelPaiementAuxiliaire ;
	private ModelEleve modelEleve ;
	private ModelFraisInscription modelFraisInscription ;
	private ModelVersement modelVersement ;
	private ModelEleveListe modelEleveListe ;
	private ModelProfesseur modelProf ;
	private ModelResume modelResume ;
	private ModelBulletinProfesseur modelBulletinProf;
	private ModelBulletinEmployer modelBulletinEmployer;
	private ModelEmployer modelEmployer ;
	private IService service;
	private  Date  aujourdhui = new Date();
	private SimpleDateFormat formater = new SimpleDateFormat("dd MMM yyyy");
	private boolean running = false;
	List<Depense>depenses = new ArrayList<Depense>();
	private Comptable comptable;
	DecimalFormat groupeddecimalFormat = new DecimalFormat("###,###.###");
	
		
public Controleur(Comptable comptable) {
	        groupeddecimalFormat.setGroupingSize(3);
	         this.comptable=comptable;
	        iPaiementAuxiliaire = new IPaiementAuxiliaire();
	        iDetailEleve = new IDetailEleve();
	        iBulletinEmployer = new IBulletinDeSalaireEmployer();
	        iBulletinProfesseur = new IBulletinDeSalaireProfesseur();
	        iFraisInscription = new IFraisInscription();
			iPaiementScolarite = new IPaiementScolarite();
			iPaiementProfesseur = new IPaiementProfesseur();
			iPaiementEmployer = new IPaiementEmployer();
			iComptabilite = new IComptabilite();
			iDepense = new IDepense();
			iVersement = new IVersementBancaire();
			service = new Service();
			modelDepense = new ModelDepense();
			modelEleve = new ModelEleve();
			modelEleveListe = new ModelEleveListe();
			modelProf = new ModelProfesseur();
			modelEmployer = new ModelEmployer();
			modelPaiementScolarite = new ModelPaiementScolarite();
			modelPaiementProfesseur = new ModelPaiementProfesseur();
			modelPaiementEmployer = new ModelPaiementEmployer();
			modelPaiementAuxiliaire = new ModelPaiementAuxiliaire();
			modelFraisInscription = new ModelFraisInscription();
			modelVersement = new ModelVersement();
			modelResume = new ModelResume();
			modelBulletinProf = new ModelBulletinProfesseur();
			modelBulletinEmployer = new ModelBulletinEmployer();
			service.triParClasseMatiere(iComptabilite.recupererComboBoxProf());
			traitementDepense();
			updateTableDepense(service.afficherListeDepense());
			updateTableListeEleveListe(service.afficherListeEleve());
			updateTableListeEleve(service.afficherListeEleve());
		 	updateTablePaiementEmployer(service.afficherListePaiementEmployer());
			updateTablePaiementScolarite(service.afficherListePaiementScolarite());
			updateTablePaiementProfesseur(service.afficherListePaiementProfesseur());
			updateTableListeProfesseur(service.afficherListeProfesseur());
		    updateTableListeEmployer(service.afficherListePersonnel());
		    updateTableFraisInscription(service.afficherListeFraisScolarite());
		    updateTableVersement(service.afficherListeVersement());
		    updateTableBulletinProfesseur(service.afficherListePaiementProfesseur());
		    updateTableResume(service.afficherListeResume());
		    updateTableBulletinEmployer(service.afficherListePaiementEmployer());
		    updateTablePaiementAuxiliaire(service.afficherListePaiementAuxiliaire());
			traitementComptabilite();
			traitementPaiementScolarite() ;
			traitementPaiementProfesseur() ;
			traitementProfesseur();
			traitementEmployer();
			traitementIncription();
			traitementVersement();
			 traitement();
			 
			 //action connection
			 actionConnection();
			iComptabilite.setTextField_totalVErsementBancaire(String.valueOf( groupeddecimalFormat.format(service.TotalVersement()) +" FCFA"));
			iComptabilite.setTextField_total_Resume_PaiementProfesseur(String.valueOf( groupeddecimalFormat.format(iComptabilite.recupererSommeResume()) +" FCFA"));
			
			
		}
		
		
		//FONCTIONS DE MISE A JOUR DES TABLES
	   private void updateTableBulletinEmployer(List<PaiementEmployer>depenses) {
	    // TODO Auto-generated method stub
	    modelBulletinEmployer.setDepenses(depenses);
	    iBulletinEmployer.chargerModelBulletinEmployer(modelBulletinEmployer);
	    }		
	   private void updateTablePaiementAuxiliaire(List<PaiementAuxiliaire>depenses) {
		    // TODO Auto-generated method stub
		    modelPaiementAuxiliaire.setDepenses(depenses);
		    iComptabilite.chargerModelPaiementAuxiliaire(modelPaiementAuxiliaire);
		    }

		private void updateTableBulletinProfesseur(List<PaiementProfesseur>depenses) {
	    // TODO Auto-generated method stub
	    modelBulletinProf.setDepenses(depenses);
	    iBulletinProfesseur.chargerModelBulletinProfesseur(modelBulletinProf);
	    }

	   private void updateTableVersement(List<Versement>depenses) {
	    // TODO Auto-generated method stub
	    modelVersement.setDepenses(depenses);
	    iComptabilite.chargerModelVersement(modelVersement);
		iComptabilite.setTextField_totalVErsementBancaire(String.valueOf( groupeddecimalFormat.format(service.TotalVersement()) +" FCFA"));
	    }

       private void updateTableFraisInscription(List<FraisInscription>depenses) {
	    // TODO Auto-generated method stub
	    modelFraisInscription.setDepenses(depenses);
	    iComptabilite.chargerModelFraisInscription(modelFraisInscription);
        }

       private void updateTableDepense(List<Depense>depenses) {
			// TODO Auto-generated method stub
			modelDepense.setDepenses(depenses);
			iComptabilite.chargerModelDepense(modelDepense);
			iComptabilite.setTextField_MontantTotalDepense(String.valueOf(groupeddecimalFormat.format(iComptabilite.totalTable()))+" FCFA");
		}
       

		private void updateTableResume(List<Resume>depenses) {
			// TODO Auto-generated method stub
			modelResume.setDepenses(depenses);
			iComptabilite.chargerModelResume(modelResume);
		}
		
		private void updateTablePaiementProfesseur(List<PaiementProfesseur>depenses) {
			// TODO Auto-generated method stub
			modelPaiementProfesseur.setDepenses(depenses);
			iComptabilite.chargerModelPaiementProfesseur(modelPaiementProfesseur);;
		}
		
		
		private void updateTablePaiementEmployer(List<PaiementEmployer>depenses) {
			// TODO Auto-generated method stub
		    modelPaiementEmployer.setDepenses(depenses);
			iComptabilite.chargerModelPaiementEmployer(modelPaiementEmployer);;
		}
		
		
		private void updateTablePaiementScolarite(List<PaiementScolarite>depenses) {
			// TODO Auto-generated method stub
			modelPaiementScolarite.setDepenses(depenses);
			iComptabilite.chargerModelPaiementScolarite(modelPaiementScolarite);;
		}
		
		
		private void updateTableListeEleveListe(List<Eleve>depenses) {
			// TODO Auto-generated method stub
			modelEleveListe.setDepenses(depenses);
			iComptabilite.chargerModelListeEleveInscription(modelEleveListe);
		}
		
		
		private void updateTableListeEleve(List<Eleve>depenses) {
			// TODO Auto-generated method stub
			modelEleve.setDepenses(depenses);
			iComptabilite.chargerModelEleve(modelEleve);
		}
		
		private void updateTableListeProfesseur(List<Professeur>depenses) {
			// TODO Auto-generated method stub
			modelProf.setDepenses(depenses);
			iComptabilite.chargerModelProfesseur(modelProf);
		}
		
		private void updateTableListeEmployer(List<Personnel>depenses) {
			// TODO Auto-generated method stub
			modelEmployer.setDepenses(depenses);
			iComptabilite.chargerModelEmployer(modelEmployer);
		}
		
		
		//GESTION PAIEMENTAUXILIAIRE
		private void traitement() {
			
		iComptabilite.addListenerButtonPayerAuxiliaire(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				try {
					iPaiementAuxiliaire.setButtonValider("Valider");
					Eleve eleve = service.recupererEleve(iComptabilite.recupererIdPaiement());
					iPaiementAuxiliaire.chargerTableEditeur(eleve);
					iPaiementAuxiliaire.afficher();
					
				}catch (Exception ex) {
					 exception();
				}
			
				
			}
		});
		
		iPaiementAuxiliaire.validerListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				PaiementAuxiliaire aux = iPaiementAuxiliaire.recupererPaiementAuxiliaire();
				
				
				
				if(iPaiementAuxiliaire.getButtonValider().equals("Valider")) {
					
					
					service.ajouterPaiementAuxiliaire(aux);
					updateTablePaiementAuxiliaire(service.afficherListePaiementAuxiliaire());
					iPaiementAuxiliaire.effacer();
					iPaiementAuxiliaire.quitter();
					iComptabilite.confirmationInformationSupprimerEnregistrer("enregistrement effectué");
				}else{
					
					aux.setId(iComptabilite.recupererIdPaiementAuxiliaire());
					service.modifierPaiementAuxiliaire(aux);
					updateTablePaiementAuxiliaire(service.afficherListePaiementAuxiliaire());
					iPaiementAuxiliaire.effacer();
					iPaiementAuxiliaire.quitter();
					iComptabilite.confirmationInformationSupprimerEnregistrer("modification effectuée");

				}
				
			}
		});
		
		iPaiementAuxiliaire.fermerListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				iPaiementAuxiliaire.quitter();
			}
		});
		
		iComptabilite.addListenerButtonModifierPaiementAuxiliaire( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					iPaiementAuxiliaire.setButtonValider("Changer");
					PaiementAuxiliaire paiement = service.recuperPaiementAuxiliairet(iComptabilite.recupererIdPaiementAuxiliaire());
					iPaiementAuxiliaire.modifierPaiementProf(paiement);
					iPaiementAuxiliaire.afficher();
				}catch (Exception ex) {
					exception();
				}
				
				
			}
		});
		
		iComptabilite.addListenerButtonSupprimerPaiementAuxiliaire( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id =0;
		      	try {
    					id =iComptabilite.recupererIdPaiementAuxiliaire();
    					
    				}catch (Exception ex) {
    					 exception();
    				}
                
                	if((id != 0)&&(id != -1)) {
                	
                int choix = iComptabilite.confirmerSupprimerAjouter("Supprimer");
                if(choix == JOptionPane.OK_OPTION) {
                	service.supprimerPaiementAuxiliaire(id);
                	
                }
                	}
				
				updateTablePaiementAuxiliaire(service.afficherListePaiementAuxiliaire());
                
			}
		});
		
		iComptabilite.addListenerButtonRecuPaiementAuxiliaire( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					IRecuPaiementAuxiliaire iAu = new IRecuPaiementAuxiliaire(service.recuperPaiementAuxiliairet(iComptabilite.recupererIdPaiementAuxiliaire()));
					iAu.run();
					
				}catch (Exception ex) {
					exception();
				}
				
			}
		});
		
		}
		
		
		//GESTION VERSEMENT
		
		private void traitementVersement() {
			
			iComptabilite.addListenerButtonSupprimerVersement( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int monId = 0;
					  
		                
		               
		                	try {
								monId =iComptabilite.recupererIdListeVersement();
								
								
							}catch (Exception ex) {
								exception();
							}
		                	
		                	if((monId != 0)&&(monId != -1)) {
		                		int choix = iComptabilite.confirmerSupprimerAjouter("Supprimer");
		                		 if(choix == JOptionPane.OK_OPTION) {
		                			 
		                			 service.supprimerVersement(monId);
										updateTableVersement(service.afficherListeVersement());	 
		                		
		                	}
		                	
		                	
		                }
					}
					
			});
			
			
			iVersement.annulerListener( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					iVersement.quitter();
					updateTableVersement(service.afficherListeVersement());	
					
				}
			});
			iComptabilite.addListenerButtonAjouterVersement( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				iVersement.setDate(formater.format(aujourdhui));
			    iVersement.effacer();
				iVersement.setButtonValider("Valider");
				iVersement.afficher();				}
			});
			
			iVersement.validerListener( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					try {
						 Versement versement = iVersement.recupererPaiementVersement();
						 

							if (iVersement.getButtonValider().equals("Valider")) {
								 service.ajouterVersement(versement);
								 iVersement.effacer();
								 iVersement.quitter();
								 iComptabilite.confirmationInformationSupprimerEnregistrer("enregistrement effectué");
								 iVersement.afficher();
							}else {
								versement.setId(iComptabilite.recupererIdListeVersement());
		                        service.modifierVersement(versement);
		                        iVersement.effacer();
								iVersement.quitter();
								iComptabilite.confirmationInformationSupprimerEnregistrer("modification effectué");
 
							}
								
							updateTableVersement(service.afficherListeVersement());	
						
					}catch (Exception ex) {
						
					}
					
				}
					
				
			});
			
			iComptabilite.addListenerButtonMenuVersement( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					updateTableVersement(service.afficherListeVersement());
					
				}
			});
			
			
			iComptabilite.addListenerButtonModifierVersement( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					iVersement.setButtonValider("Changer");
					try {
						Versement versement = service.recuperVersement(iComptabilite.recupererIdListeVersement());
						 iVersement.modifierPaiementVersement(versement);
						iVersement.afficher();
					}catch (Exception ex) {
						
						exception();
					}
					
					
				}
			});
			
		}
		
		
		
		//GESTION INTERFACE INSCRIPTION
		
		private void traitementIncription() {
			
		iComptabilite.addListenerButtonRecuFraisInscription( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		      try {

					IRecuFraisInscription iFrais = new IRecuFraisInscription(service.recupererFraisScolarite(iComptabilite.recupererIdListeFraisInscription()));
					iFrais.run();
		      }catch (Exception ex) {
				exception();
			}
				
			}
		});	
		iComptabilite.addListenerButtonTrieFraisInscription( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			updateTableFraisInscription(service.rechercheTriFraisScolarite(iComptabilite.recupererComboTriFraisInscription()));
				
			}
		});	
		
		iComptabilite.addListenerButtonModifierFraisInscription( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					FraisInscription frais = service.recupererFraisScolarite(iComptabilite.recupererIdListeFraisInscription());
					
					iFraisInscription.modifierPaiementProf(frais);
					
					iFraisInscription.afficher();
					
				}catch (Exception ex) {
					// TODO: handle exception
					exception();
				}
				
			}
				
		});
		
			
		iComptabilite.addListenerButtonSpprimerFraisInscription( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				 
				 int monId = 0;
	                
	                	try {
	                		monId=iComptabilite.recupererIdListeFraisInscription();
	    					
	    					
	    				}catch (Exception ex) {
	    					exception();
	    				}
	                	
	                	
	                	if((monId != 0)&&(monId != -1)) {
	                		
	                	int choix = iComptabilite.confirmerSupprimerAjouter("Supprimer");
	                	if(choix == JOptionPane.OK_OPTION) {
	                		
	                		service.supprimerFraisScolarite(monId);
	    					updateTableFraisInscription(service.afficherListeFraisScolarite());
	                	}
	                	
	                }
				
				
			}
		});	
		
		iComptabilite.addListenerButtonMenuInscription( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateTableFraisInscription(service.afficherListeFraisScolarite());
			}
		});	
		iComptabilite.addListenerButtonRechercherfraisInscription( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				List<FraisInscription> frais =service.rechercheFraisScolaritetParNom(iComptabilite.getTextField_rechercheFraisInscription());
				if(frais.isEmpty()) {
					iComptabilite.confirmationInformationSupprimerEnregistrer("introuvable");
					iComptabilite.setTextField_rechercheFraisInscription(null);
				}else {
					updateTableFraisInscription(frais);
				}
				
			}
		});
			
		iFraisInscription.validerListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					FraisInscription frais = iFraisInscription.recupererFraisInscription();
					
					if (iFraisInscription.getButtonValider().equals("Valider")) {
					 frais.setId(iComptabilite.recupererIdEleveListeInscription());
					 service.ajouterFraisScolarite(frais);
					 iFraisInscription.effacer();
					 iFraisInscription.quitter();
					iComptabilite.confirmationInformationSupprimerEnregistrer("enregistrement effectué");

					}else {
						
					 frais.setId(iComptabilite.recupererIdListeFraisInscription());
					 
					 service.modifierFraisScolarite(frais);
					 iFraisInscription.effacer();
					 iFraisInscription.quitter();
					 iComptabilite.confirmationInformationSupprimerEnregistrer("modification effectuée");

					}
					
					updateTableFraisInscription(service.afficherListeFraisScolarite());
					
				}catch (Exception ex) {
					// TODO: handle exception
				}
			
			}
		});	
		
		iFraisInscription.annulerListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				iFraisInscription.quitter();
				iFraisInscription.effacer();
				
			}
		});
		
		
		iComptabilite.addListenerButtonAjouterFraisInscription( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					iFraisInscription.setDatePaiement(formater.format(aujourdhui));
					iFraisInscription.chargerTableEditeur(service.recupererEleve(iComptabilite.recupererIdEleveListeInscription()));
					iFraisInscription.afficher();
					
				}catch (Exception ex) {
					exception();
				}
				
				
			}
		});	
			
		iComptabilite.addListenerButtonRechercherEleveInscription( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Eleve>eleves = service.rechercheParNomOuPrenom(iComptabilite.getTextField_recherche_listeEleve_FraisInscription());
				
				if(eleves.isEmpty()) {
					iComptabilite.confirmationInformationSupprimerEnregistrer("introuvable");
					iComptabilite.setTextField_recherche_listeEleve_FraisInscription(null);
				}else {
					updateTableListeEleveListe(eleves);
				}
				
				
			}
		});
			
			iComptabilite.addListenerButtonMenuInscription( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					updateTableListeEleveListe(service.afficherListeEleve());
				}
			});		
			
			
		iComptabilite.addListenerButtonTrieEleveInscription( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				updateTableListeEleveListe(service.rechercherTriEleveInscription(iComptabilite.recupererComboTriEleveInscription()));
			}
		});
					
					
	}
		
		
		
		//GESTION INTERFACE EMPLOYER
		
				private void traitementEmployer() {
				
					iComptabilite.addListenerButtonRecuPaiementEmployer( new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							try {
								IRecuPaiementEmployer iEmployer = new IRecuPaiementEmployer(service.recupererPaiementEmployer(iComptabilite.recupererIdPaiementEmployer()));
								iEmployer.run();
								
							}catch (Exception ex) {
								exception();
							}
							
						}
					});
				iBulletinEmployer.addListenerButtonFermer( new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						iBulletinEmployer.fermer();
						
					}
				});
				iComptabilite.addListenerButtonBulletinEmployer( new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
					try {
						Personnel employer = iComptabilite.recupererEmplyerDeLaListeEmployer();
						iBulletinEmployer.chargerTableEditeurEmployer(employer);
						updateTableBulletinEmployer(service.afficherListePaiementEmployerParEmployer(employer));
						iBulletinEmployer.affiche();
					}catch (Exception ex) {
						exception();
					}
					
					}
				});
					
				iComptabilite.addListenerButtonTriEmployer( new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
				    updateTableListeEmployer(service.rechercherParTri(iComptabilite.recupererComboTriEmployer()));
					}
				});
					
				iComptabilite.addListenerButtonRechercherEmployer( new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
					List<Personnel>personnes =service.recherchePersonnelParNom(iComptabilite.getTextField_rechercheEmployer_listeEmployer());
                   
					if(personnes.isEmpty()) {
						iComptabilite.confirmationInformationSupprimerEnregistrer("introuvable");
						iComptabilite.setTextField_rechercheEmployer_listeEmployer(null);
					}else {
						updateTableListeEmployer(personnes);
					}
					
					}
				});	
				
					
				iComptabilite.addListenerButtonTriPaiementEmployer( new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						updateTablePaiementEmployer(service.recherchePaiementEmployerParTri(iComptabilite.recupererComboTriPaiementEmployer()));
						
					}
				});
				iComptabilite.addListenerButtonRechercherPaiementEmployer( new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						List<PaiementEmployer>employes = service.recherchePaiementEmployerParNomPrenom(iComptabilite.getTextField_recherchePaiementEmployer());
						if(employes.isEmpty()) {
							iComptabilite.confirmationInformationSupprimerEnregistrer("introuvable");
							iComptabilite.setTextField_recherchePaiementEmployer(null);
						}else {
							updateTablePaiementEmployer(employes);
						}
						
					}
				});
					
				iComptabilite.addListenerButtonSpprimerPaiementEmployer( new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						 int monId = 0;
						 
			                
			                	try {
			                		monId = iComptabilite.recupererIdPaiementEmployer();
									
								}catch (Exception ex) {
									exception();
								}
			                	if((monId != 0)&&(monId != -1)) {
			                		int choix = iComptabilite.confirmerSupprimerAjouter("Supprimer");
			                		if(choix == JOptionPane.OK_OPTION) {
			                			
			                			service.supprimerPaiementEmployer(monId);
										updateTablePaiementEmployer(service.afficherListePaiementEmployer());
			                	}
							}
						
						
					}
						
				});	
					
				iComptabilite.addListenerButtonModifierPaiementEmployer( new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						try {
							PaiementEmployer empl = service.recupererPaiementEmployer(iComptabilite.recupererIdPaiementEmployer());
							
							iPaiementEmployer.modifierPaiementEmployer(empl);
							
							iPaiementEmployer.afficher();
						}catch (Exception ex) {
							exception();
						}
						
						
					}
				});
					
				iComptabilite.addListenerButtonMenuEmployer( new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						updateTableListeEmployer(service.afficherListePersonnel());
						updateTablePaiementEmployer(service.afficherListePaiementEmployer());
					}
				});
				
				
				
				iComptabilite.addListenerButtonPayerEmployer( new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						try {
							Personnel employer = service.recupererPersonnel(iComptabilite.recupererIdEmployer());
							iPaiementEmployer.chargerTableEditeur(employer);
							iPaiementEmployer.setDate_Paiement(formater.format(aujourdhui));
							iPaiementEmployer.afficher();
							
							
						}catch (Exception ex) {
							exception();
						}
						
					}
				});
				
				
				iPaiementEmployer.payerListener( new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						 
						try {
							PaiementEmployer employer = iPaiementEmployer.recupererPaiementEmployer();
							
							if(iPaiementEmployer.getBtn_Payer().equals("Payer")) {
								
								employer.setId(iComptabilite.recupererIdEmployer());
								service.ajouterPaiementEmployer(employer);
								iPaiementEmployer.effacer();
								iPaiementEmployer.quitter();
								iComptabilite.confirmationInformationSupprimerEnregistrer("payement effectué");

							}else {
								employer.setId(iComptabilite.recupererIdPaiementEmployer());
					            service.modifierPaiementEmployer(employer);
					        	iPaiementEmployer.effacer();
					        	iPaiementEmployer.quitter();
								iComptabilite.confirmationInformationSupprimerEnregistrer("modification payement effectué");

							}
							updateTablePaiementEmployer(service.afficherListePaiementEmployer());
							
							
						}catch (Exception ex) {
							// TODO: handle exception
						}
						
					}
				});
				
				iPaiementEmployer.annulerListener( new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						updateTablePaiementEmployer(service.afficherListePaiementEmployer());
						iPaiementEmployer.quitter();
					}
				});
					
				}
		
		
		
		//GESTION INTERFACE PROFESSEUR
		
		private void traitementProfesseur() {
			
			iComptabilite.addListenerButtonRecuPaiementProfesseur( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						IRecuPaiementProfesseur iProf = new IRecuPaiementProfesseur(iComptabilite.recupererResumePaiementProfesseur());
						iProf.run();
						
					}catch (Exception ex) {
						exception();
					}
					
					
				}
			});
			iComptabilite.addListenerButtonBulletinProfesseur( new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					try {
						Professeur prof = iComptabilite.recupererProfesseurDeLaListeProfesseur();
	                	 iBulletinProfesseur.chargerTableEditeur(service.recupererPaiementProfesseur(prof));
	 					updateTableBulletinProfesseur(service.recherchePaiementProfesseurParProfesseur(prof));
	 					iBulletinProfesseur.affiche(); 	
					}catch (Exception ex) {
						exception();
					}
				     
	                 
					
				}
			});
			
			iBulletinProfesseur.addListenerButtonFermer( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				
					iBulletinProfesseur.fermer();
					
				}
			});
			iComptabilite.addListenerButtonLancerTriProf(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					updateTableListeProfesseur(service.triParClasseMatiere(iComptabilite.recupererComboBoxProf()));
                    }
			});
			
			
			iComptabilite.addListenerButtonMenuProf( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					updateTableListeProfesseur(service.afficherListeProfesseur());
				}
			});
			
			iComptabilite.addListenerButtonLancerRechercheProf( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					List<Professeur>profs = service.rechercheProfesseurParNom(iComptabilite.getTextField_rechercheProfesseur());
					
					if(profs.isEmpty()) {
						iComptabilite.confirmationInformationSupprimerEnregistrer("introuvable");
						iComptabilite.setTextField_rechercheProfesseur(null);
					}else {
						updateTableListeProfesseur(profs);
					}
					
					
					
				}
			});
			
			
			
			
		}
		
		
		
		//FONCTION DE TRAITEMENTS DE L'INTERFACE  PAIEMENTPROFESSEUR
		private void traitementPaiementProfesseur() {
			
			
			iComptabilite.addListenerButtonModifierPaiementProf( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						PaiementProfesseur paiement = service.recupererPaiementProfesseur(iComptabilite.recupererIdPaiementProfesseur());
						iPaiementProfesseur.modifierPaiementProf(paiement);
						
						iPaiementProfesseur.afficher();
						
					}catch (Exception ex) {
						exception();
						
					}
					
					
				}
			});
			
			
			iComptabilite.addListenerButtonSupprimerPaiementProf(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					 int monId = 0;
		               
							try {
								monId =iComptabilite.recupererIdPaiementProfesseur();
								
								
							}catch (Exception ex) {
								exception();
							}
							if((monId != 0)&&(monId != -1)) {
		                		int choix = iComptabilite.confirmerSupprimerAjouter("Supprimer");
		                		if(choix == JOptionPane.OK_OPTION) {
		                			service.supprimerPaiementProfesseur(monId);
									updateTablePaiementProfesseur(service.afficherListePaiementProfesseur());
		                			
		                		}
							}
						}
					
			});
			
			iComptabilite.addListenerButtonLancerRecherchePaiementProf(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					List<PaiementProfesseur>profs = service.recherchePaiementProfesseurParNomPrenom(iComptabilite.getTextField_PaiementProfesseur_RechercheProfesseur());
					if(profs.isEmpty()) {
						iComptabilite.confirmationInformationSupprimerEnregistrer("introuvable");
                        iComptabilite.setTextField_PaiementProfesseur_RechercheProfesseur(null);
					}else {
						updateTablePaiementProfesseur(profs);	
					}
					
				}
			});;
			
			iPaiementProfesseur.calculerSomme( new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent e) {
					
					int tempon =(int) ((JSpinner)e.getSource()).getValue();
					
		iPaiementProfesseur.setTextPane_MontantTotalSalaire(String.valueOf(tempon*iPaiementProfesseur.getPrixParHeure()));
				    }
					
				});
			
			iPaiementProfesseur.payerListener( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					try {
						PaiementProfesseur prof = iPaiementProfesseur.recupererPaiementProf();
						
						if(iPaiementProfesseur.getBtn_Payer().equals("Payer")) {
							prof.setId(iComptabilite.recupererIdProfesseur());
							service.ajouterPaiementProfesseur(prof);
							iPaiementProfesseur.effacer();
							iPaiementProfesseur.quitter();
							iComptabilite.confirmationInformationSupprimerEnregistrer("payement effectué");
						}else {
							prof.setId(iComptabilite.recupererIdPaiementProfesseur());
							service.modifierPaiementProfesseur(prof);
							iPaiementProfesseur.effacer();
							iPaiementProfesseur.quitter();
							iComptabilite.confirmationInformationSupprimerEnregistrer("modification payement effectué");
						}
						
						updateTablePaiementProfesseur(service.afficherListePaiementProfesseur());
						
						
					}catch (Exception ex) {
						// TODO: handle exception
					}
					
					
				}
			});
			
			
			iPaiementProfesseur.annulerListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					updateTablePaiementProfesseur(service.afficherListePaiementProfesseur());
					iPaiementProfesseur.quitter();
				}
			});
			
			
			
		}
		
		//FONCTION DE TRAITEMENTS DE L'INTERFACE  PAIEMENTSCOLARITE

		private void traitementPaiementScolarite() {
			
        iComptabilite.addListenerNouveauPaiement( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						iPaiementScolarite.setButtonValider("Valider");
						iPaiementScolarite.setDatePaiement(formater.format(aujourdhui));
						Eleve eleve = service.recupererEleve(iComptabilite.recupererIdPaiement());
						iPaiementScolarite.chargerEleve(eleve);
						iPaiementScolarite.afficher();
					}catch (Exception ex) {
						exception();
					}
					
					
				}
			});
        iComptabilite.addListenerButtonModifierScolarite( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						PaiementScolarite empl = service.recupererPaiementScolarite(iComptabilite.recupererIdPaiementScolarite());
						
						iPaiementScolarite.modifierPaiementScolarite(empl);
						
						iPaiementScolarite.afficher();
						
					}catch (Exception b) {
                        exception();
					}
					
					
					
				}
			});
			
	 iComptabilite.addListenerButtonSupprimerScolarite( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
	                int monId = 0;

	    				try {
	    					monId = iComptabilite.recupererIdPaiementScolarite();
	    					
	    					
	    				}catch (Exception ex) {
	    					exception();
	    				}
	    				
	    				
	    				if((monId != 0)&&(monId != -1)) {
	                		int choix = iComptabilite.confirmerSupprimerAjouter("Supprimer");
	                		if(choix == JOptionPane.OK_OPTION) {
	                			
	                			service.supprimerPaiementScolarite(monId);
		    					updateTablePaiementScolarite(service.afficherListePaiementScolarite());
	                		}
	    				
	    			}
				
			}
				
				
		});
				
		   iComptabilite.addListenerButtonTrieEleveScolarite( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
			List<Eleve>eleves =service.triListeEleveScolariteParNom(iComptabilite.recupererComboBoxTriEleveScolarite());
			
			if(eleves.isEmpty()) {
				iComptabilite.confirmationInformationSupprimerEnregistrer("introuvable");

			}else {
				
				updateTableListeEleve(eleves);
			}
			
				
			}
		});
			
			
	    iComptabilite.addListenerButtonPayerRecuScolarite( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						IRecuPaiementScolarite iRecu =new IRecuPaiementScolarite(service.recupererPaiementScolarite(iComptabilite.recupererIdPaiementScolarite()));
						iRecu.run();
					}catch (Exception ex) {
						exception();
					}
					
					
				}
			});
			iDetailEleve.annulerListener( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					iDetailEleve.fermer();
					
				}
			});
			iComptabilite.addListenerButtonDetailsEleve( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					try {
						Eleve eleve = service.recupererEleve(iComptabilite.recupererIdPaiement());
						iDetailEleve.chargerInfos(eleve);
						iDetailEleve.run();
						
					}catch (Exception ex) {
						exception();
					}
					
				}
			});
			
			iPaiementScolarite.validerListener( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						
					
						
						PaiementScolarite aux = iPaiementScolarite.recupererPaiementScolarite();
						
						
						
						if(iPaiementScolarite.getButtonValider().equals("Valider")) {
							
							
							service.ajouterPaiementScolarite(aux);
							service.miseAJourTrancheEleve(Integer.valueOf(iPaiementScolarite.getTranche()),iPaiementScolarite.montantMontantTotal(),iComptabilite.recupererIdPaiement());
							updateTablePaiementScolarite(service.afficherListePaiementScolarite());
							updateTableListeEleve(service.afficherListeEleve());
							iPaiementScolarite.quitter();
							iPaiementScolarite.effacer();
							iComptabilite.confirmationInformationSupprimerEnregistrer("enregistrement effectué");
						}else{
							
							aux.setId(iComptabilite.recupererIdPaiementScolarite());
							service.modifierPaiementScolarite(aux);
							updateTablePaiementScolarite(service.afficherListePaiementScolarite());	
							updateTableListeEleve(service.afficherListeEleve());
							iPaiementScolarite.quitter();
							iPaiementScolarite.effacer();
							iComptabilite.confirmationInformationSupprimerEnregistrer("modification effectuée");
						}
						
	
					}catch (Exception ex) {
						 
					}
						
			
					
					}
			});
			
			
			
			iPaiementScolarite.annulerListener( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {

					iPaiementScolarite.quitter();
				}
			});
			
			
		}
		
		//FONCTION DE TRAITEMENTS DE L'INTERFACE  DEPENSES
		private void traitementDepense() {
			
			 iComptabilite.addListenerButtonAjouter(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							 iDepense.setDatePaiement(formater.format(aujourdhui));
								onClickButtonAjouter();
							
						}catch (Exception ex) {
							exception();
						}
					   
						
					}

					private void onClickButtonAjouter() {
						iDepense.setButtonValider("Valider");
						iDepense.afficher();
						iDepense.effacer();
					}
				});
				  	
		
       iComptabilite.addListenerButtonModifier(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					
					try {
						iDepense.setButtonValider("Changer");
						
	                    int index = iComptabilite.recupererIdListeDepense();
						
						Depense depense = service.recuperDepense(index);
						iDepense.modifierDepense(depense);
						iDepense.afficher();	
						
					}catch (Exception ex) {
						exception();
					}
							
						
				}
			});
			
			 iComptabilite.addListenerButtonSupprimer(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				
					 
					int index = 0;
					

							try {
								index =iComptabilite.recupererId();
								
								
							}catch (Exception ex) {
								exception();
							}
							if ((index != 0)&&(index != -1)) {
								 int choix = iComptabilite.confirmerSupprimerAjouter("Supprimer");
					                
					                if(choix == JOptionPane.OK_OPTION) {
					                	
					                	service.supprimerDepense(index);
										updateTableDepense(service.afficherListeDepense());
							}
							
						}
					
				}
					
					
			});
			  
			
			  iComptabilite.addListenerButtonDepense(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					onClickButtonMenuDepense();
				}

				private void onClickButtonMenuDepense() {
					// TODO Auto-generated method stub
					updateTableDepense(service.afficherListeDepense());
					
				}

				
			   });
			  
			  
			iDepense.annulerListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					iDepense.quitter();
					updateTableDepense(service.afficherListeDepense());
					
				}
			});
			
			iDepense.validerListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					

					try {
						Depense depense = iDepense.recupererDepense();
						if (iDepense.getButtonValider().equals("Valider")) {
						service.ajouterDepense(depense);
						iDepense.effacer();
						iDepense.quitter();
						iComptabilite.confirmationInformationSupprimerEnregistrer("enregistrement effectué");
						iDepense.afficher();
						
		                }else {
							
						    	depense.setId(iComptabilite.recupererIdListeDepense());
								service.modifierDepense(depense);
								iDepense.effacer();
								iDepense.quitter();
								iComptabilite.confirmationInformationSupprimerEnregistrer("modification effectuée");
								
							}

				    updateTableDepense(service.afficherListeDepense());
						
					}catch (Exception ex) {
						// TODO: handle exception
					}
						
				}
						
			});
			
			
			
			
		}
		



		
		//FONCTION DE TRAITEMENTS DE L'INTERFACE  COMPTABILITES EN GENERALE
		private void traitementComptabilite() {
			
	   
			iComptabilite.addListenerButtonPayerProf( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
					
					Professeur prof = service.recupererProfesseur(iComptabilite.recupererIdProfesseur());
		    		iPaiementProfesseur.chargerTableEditeur(prof);
					iPaiementProfesseur.setDatePaiement(formater.format(aujourdhui));
					iPaiementProfesseur.afficher();
						
					}catch (Exception ex) {
						
					exception();
				   }
				}
			});;
			
			
			iComptabilite.addListenerButtonTriRecu( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					if (iComptabilite.recupererClasse().equals("Toutes")) {
						List<PaiementScolarite>paiements =service.afficherListePaiementScolarite();
						if(paiements.isEmpty()) {
							iComptabilite.confirmationInformationSupprimerEnregistrer("introuvable");
						}else {
							updateTablePaiementScolarite(paiements);
						}
						
					}else {
						List<PaiementScolarite>paiements =service.recherchePaiementScolariteParTri(iComptabilite.recupererClasse());
						if(paiements.isEmpty()) {
							iComptabilite.confirmationInformationSupprimerEnregistrer("introuvable");
						}else {
							updateTablePaiementScolarite(paiements);
						}
					

					}
				}
			});
			
			iComptabilite.addListenerButtonTriPaiementProf( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					List<PaiementProfesseur>paiements =service.recherchePaiementProfesseurParTri(iComptabilite.recupererComboBoxPaiementProf());
					if(paiements.isEmpty()) {
						iComptabilite.confirmationInformationSupprimerEnregistrer("introuvable");
					}else {
						updateTablePaiementProfesseur(paiements);					}
					
					
				}
			});
			iComptabilite.addListenerButtonTrierProfesseur( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					List<Professeur>profs = service.triParClasseMatiere(iComptabilite.recupererComboBoxProf());
					if(profs.isEmpty()) {
						iComptabilite.confirmationInformationSupprimerEnregistrer("introuvable");

					}else {
						updateTableListeProfesseur(profs);
					}
					
				}
			});
			
			
			
			iComptabilite.addListenerButtonRechercherEleve( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					onClickButtonRechercherEleve();
					
				}

				private void onClickButtonRechercherEleve() {
					
					List<Eleve>eleves = service.rechercheParNomOuPrenom(iComptabilite.getTextFieldRechercherEleve());
					
					if(eleves.isEmpty()) {
						
						iComptabilite.confirmationInformationSupprimerEnregistrer("introuvable");
						iComptabilite.setTextFieldRechercherEleve(null);

					}else {
						updateTableListeEleve(eleves);
						
					}
					
					
				}
			});
			
			
             iComptabilite.addListenerButtonRechercherRecu( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					onClickButtonRechercherEleve();
					
				}

				private void onClickButtonRechercherEleve() {
					List<PaiementScolarite> paiements =service.recherchePaiementScolariteParNomPrenom(iComptabilite.getTextFieldRechercherRecu());
					if(paiements.isEmpty()) {
						iComptabilite.confirmationInformationSupprimerEnregistrer("introuvable");
						iComptabilite.setTextFieldRechercherRecu(null);
					}else {
						updateTablePaiementScolarite(paiements);
					}
					
					
					
				}
			});
			
			
			iComptabilite.addListenerButtonMois(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					
					depenses =service.rechercherParNom(iComptabilite.recupererMois());
					
				}
			});
			
			iComptabilite.addListenerButtonRechercher(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
			
					modelDepense.setDepenses(depenses);
					boolean resultat = iComptabilite.estVide(modelDepense);
					
					if(resultat) {
						iComptabilite.confirmationInformationSupprimerEnregistrer("introuvable");
						updateTableDepense(service.afficherListeDepense());
						
					}else {
						iComptabilite.chargerModelDepense(modelDepense);
					}
					
					iComptabilite.setTextField_MontantTotalDepense(String.valueOf(iComptabilite.totalTable()));
				}
			});
			
			
			  iComptabilite.addListenerButtonScolarite(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					onClickButtonMenuScolarite();
					
				}

				private void onClickButtonMenuScolarite() {
					
					updateTableListeEleve(service.afficherListeEleve());
					updateTablePaiementScolarite(service.afficherListePaiementScolarite());
					iComptabilite.setTextFieldRechercherEleve(null);
				}
			});
			  
			 
			  
		iComptabilite.addListenerButtonMenuProf(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateTablePaiementProfesseur(service.afficherListePaiementProfesseur());
			}
		});
			 
		}
		
	 public void demarerIComptabilite() {
		 
		 iComptabilite.afficherMenuDepense();
	 }
	 
	  public void actionConnection() {
		  iComptabilite.addModifierMdpListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ChangerMotDePasse ch =new ChangerMotDePasse(comptable,null);
					ch.run();
					
				}
			});
		  iComptabilite.addDeconectionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Accueil acceuil =new Accueil();
					int msg=iComptabilite.showMessageConfirmation("Déconnection","Voulez-vous vous déconnecter?" );
					if(msg==0) {
						iComptabilite.close();
				    acceuil.run();
					}
				}
			});
		   if(comptable!=null) {
			   iComptabilite.setNomPrenomUser(comptable.getNom()+" "+comptable.getPrenom());
		   }

	   }
	 
	 private void exception() {
		 
 		Thread clignotant = new Thread ( new Runnable () {
 			
 			@Override
 			public void run() {
 				running = true;
 				
 				while ( running ) {					
 					try {
 						iComptabilite.setLabelInformationColor(Color.red);
 						iComptabilite.setLabelInformation("Veuillez Cliquer Sur Une Ligne Du Tableau");
 						Thread.sleep(3000);
 						iComptabilite.setLabelInformation(null);
 						running=false;
 					} catch (InterruptedException e) {}
 				}
 				
 			}			
 		});
 		clignotant.start();
 	}

}
