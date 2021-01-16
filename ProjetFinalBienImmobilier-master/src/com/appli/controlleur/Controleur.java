package com.appli.controlleur;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.app.exception.NullAuthentificationDataException;
import com.app.exception.NullBienImmobilierExeption;
import com.app.exception.NullIdDataExeption;
import com.app.exception.NullPaiementDataExeption;
import com.app.exception.NullUserDataExecption;
import com.app.loyer.service.IService;
import com.app.loyer.service.Service;
import com.appli.decoder.ResponseDecoder;
import com.appli.interfaces.Accueil;
import com.appli.interfaces.IAdministrateur;
import com.appli.interfaces.IGestionnaire;
import com.appli.interfaces.IPaiementJournalier;
import com.appli.interfaces.IPaiementMensuel;
import com.appli.modele.Administrateur;
import com.appli.modele.Authentification;
import com.appli.modele.BienImmobilier;
import com.appli.modele.Gestionnaire;
import com.appli.modele.Locataire;
import com.appli.modele.PaiementLoyer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sun.jersey.api.client.ClientResponse;


public class Controleur {
    private Accueil vueAcceuil;
    private IAdministrateur vueAdmin;
    private IService service;
    private Integer id=0,id_du_bien=0,id_bien_active=0,id_bien_desactive=0,idLocataire=0,id_loyer=0;
    private double montant=0;
    private BienImmobilier bienDesactiveActive=null;
    private String typeImmobilier=null,date=null;
    private IGestionnaire vueGestionnaire;
    private IPaiementJournalier vuePayerJournalier;
    private IPaiementMensuel vuePayerMensuelle;
    
	public Controleur(Accueil vueAcceuil,IAdministrateur vueAdmin,IGestionnaire vueGestionnaire,
			IPaiementJournalier vuePayerJournalier,IPaiementMensuel vuePayerMensuelle) {
		this.vueAcceuil=vueAcceuil;
		this.vueAdmin= vueAdmin;
		this.vueGestionnaire=vueGestionnaire;
		this.vuePayerJournalier=vuePayerJournalier;
		this.vuePayerMensuelle=vuePayerMensuelle;
		service=new Service();
		Date Get_Date = new Date ();
		vueAdmin.setDateNaissance(Get_Date);
		administrateurs();
		gestionnaire() ;
		paiement();
	}
	
	
	
	//liste des methode concernant la fenetre de l admin
	private void administrateurs() {
		addConnecterListener();
		addAnnulerListener();
		addAjouterUserListener();
		addAfficherUserAuChoix();
		addModifierUserListener();
		addSupprimerUserListener();
		addTableUserMousseListener();
		addAnnulerUserListener();
		addQuiterPageAdminListener();
		addQuiterPageGestionnaireListener();
		addAnnulerListener();
		//affichage dans les tableaux
		visualiserGestionnaire();
		visualiserListeAdmin();
		visualiserListeGestionnaire();
		
		//bien immobilier
		visualiserBien();
		addAjouterBienListener();
		addDesactiverBienListener();
		addActiverBienListener();
		addModifierBienListener();
		addTableBienrMousseListener();
		addTableBienActifMousseListener();
		addAnnulerBienListener();
		visualiserBienActif();
		visualiserBienDesactive();
		addTableBienDesactiveMousseListener();
		
	}
	
	



	//liste des methodes de la fenetre du gestionnaire
	private void gestionnaire() {
		addAffecterLocataireListener();
		//addListeBiensListener();
		addListeLocataireListener();
		addLibererBienListener();
		addVoirPaiementListener();
		addTableBienLocataireMousseListener();
		addTableBienAloueMousseListener();
		//affichage des les tableaux
		visualiserBienLocataire();
		visualiserBienAloueLocataire();
		visualiserLocataire();
		visualiserBienGestionnaire();
		actualiserStatistique();
		addAnnulerAjoutLocataireListener();
	}
	
	//listes des methodes concernant la fenetre des paiements
	public void paiement() {
		visualiserPayeJournalier();
		addPayerTranche2();
		addPayerTranche3();
		addModifierPayerJournalier();
		addModifierPayerMensuel();
		addAnnulerJournalier();
		addAnnulerMensuel();
		addQuiterPageJournalierListener();
		addQuiterPageMensuelleListener();
		vuePayerJournalier.setTranche1(false);
		addTablePaiementJournalierMousseListener();
		addTablePaiementMensuelMousseListener();
		addPayerMensuelListener();
		actualiserPaiementJournalier();
	
	}
	
	


	//*************************************LISTENERS DE LA PAGE DES PAIEMENTS LOYERS**************************************//
	//
	//
	//*******************************************************************************************************************//
	
	private void addAnnulerJournalier() {
		
		
	}



	private void addAnnulerMensuel() {
		
		
	}
   
	private void addQuiterPageJournalierListener() {
		 vuePayerJournalier.addQuiterListener(
					
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							int value;
							value=vuePayerJournalier.showMessageConfirmation("Retour Page D'acceuille", "Voulez Vous Quitter cette page??");
							if(value==0) {
							vueAdmin.fermerFenetre();
							vueGestionnaire.run();
							}
						}
							
					});
		
	}

  
	private void addQuiterPageMensuelleListener() {
		 vuePayerMensuelle.addQuiterListener(
					
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							int value;
							value=vuePayerMensuelle.showMessageConfirmation("Retour Page D'acceuille", "Voulez Vous Quitter cette page??");
							if(value==0) {
								vuePayerMensuelle.fermerFenetre();
							vueGestionnaire.run();
							}
						}
							
					});
		
	}
	
	
	private void addModifierPayerMensuel() {
		vuePayerMensuelle.addModifierListener(
				
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						PaiementLoyer payer = new PaiementLoyer(id_loyer,vuePayerMensuelle.getId(),date,montant);
						modifierPaiement(payer);
						vuePayerMensuelle.actualiserPayer();
						visualiserPayeMensuelle();
						
					}
						
				});
		
		
	}



	private void addModifierPayerJournalier() {
    vuePayerJournalier.addModifierListener(
				
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						PaiementLoyer payer = new PaiementLoyer(id_loyer,vuePayerJournalier.getId(),date,montant);
						modifierPaiement(payer);
						vuePayerJournalier.actualiserTablePaiement();
						visualiserPayeJournalier();
						
						
					}
						
				});
		
		
	}

	
	private void addTablePaiementMensuelMousseListener() {
		vuePayerMensuelle.addTablePayerMousseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				id_loyer=Integer.parseInt(vuePayerMensuelle.tableListePayerCol1());
				montant=Double.parseDouble(vuePayerMensuelle.tableListePayerCol3());
				date=vuePayerMensuelle.tableListePayerCol2();
			}
		});
		
	}

	private void addTablePaiementJournalierMousseListener() {
		vuePayerJournalier.addTablePayerMousseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				id_loyer=Integer.parseInt(vuePayerJournalier.tableListePayerCol1());
				montant=Double.parseDouble(vuePayerJournalier.tableListePayerCol3());
				date=vuePayerJournalier.tableListePayerCol2();
			}
		});
		
	}

	
	private void addPayerMensuelListener() {
		
		vuePayerMensuelle.addPayerListener(
				
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						int value;
						value=vuePayerMensuelle.showMessageConfirmation("Payer Loyer", "Voulez-Vous Payer Le Loyer??");
						
						try {
							if(value==0) {
								payerLoyerMensuel();
								vuePayerMensuelle.actualiserPayer();
								visualiserPayeMensuelle();
							}
						} catch (NullPaiementDataExeption e1) {
							
							vuePayerMensuelle.showMessage(e1.getMessage());
						}
						
				}
						
		});
		
	}

	private void addPayerTranche2() {
	    vuePayerJournalier.addPayer2Listener(
					
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							try {
								payerLoyerJournalier();
								vuePayerJournalier.actualiserTablePaiement();
								actualiserPaiementJournalier();
								vuePayerJournalier.actualiserTablePaiement();
								visualiserPayeJournalier();
							} catch (NullPaiementDataExeption e1) {
								vuePayerJournalier.showMessage(e1.getMessage());
							}
					}
							
			});
			
	}
	
	private void addPayerTranche3() {
	    vuePayerJournalier.addPayer3Listener(
					
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							try {
								payerLoyerJournalier();
								actualiserPaiementJournalier();
								vuePayerJournalier.actualiserTablePaiement();
								visualiserPayeJournalier();
							} catch (NullPaiementDataExeption e1) {
								vuePayerJournalier.showMessage(e1.getMessage());
							}
							
					}
							
			});
			
	}
	

	
//**********************************LISTENERS DE LA PAGE DU GESTIONNAIRE****************************************//
//
//
//**************************************************************************************************************//	
	
	
	
	//table bien aloue
	private void addTableBienAloueMousseListener() {
		vueGestionnaire.addTableListeBienAloueMousseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {

				id_du_bien=Integer.parseInt(vueGestionnaire.tableListeBienAloueCol1());
				
			
			}
		});
	}
   
	//table ajouter locataire
	private void addTableBienLocataireMousseListener() {
		vueGestionnaire.addTableAjoutLocationMousseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {

				idLocataire=Integer.parseInt(vueGestionnaire.tableAjoutLocataireCol1());
				typeImmobilier =vueGestionnaire.tableAjoutLocataireCol6();
			    montant = Double.parseDouble(vueGestionnaire.tableAjoutLocataireCol3());
			    actualiserStatistique();
			}
		});
	
		
	}
    // voir paiement
	private void addVoirPaiementListener() {
    vueGestionnaire.addVoirPaiementListener(
				
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
					if(idLocataire!=0 && vueGestionnaire.selectRowTableListeLocataire()>=0 ) {
						vuePayerJournalier.setId(idLocataire);
						vuePayerMensuelle.setId(idLocataire);
						vuePayerMensuelle.setMontant(renvoiTypeLoyer(idLocataire).getLoyer());
						
						if(renvoiTypeLoyer(idLocataire).getTypeLoyer().toUpperCase ().equals("JOURNALIER")) {
							actualiserPaiementJournalier();
							vuePayerJournalier.run();
							
							vuePayerJournalier.actualiserTablePaiement();
							visualiserPayeJournalier();
							//paiement();
						}else if(renvoiTypeLoyer(idLocataire).getTypeLoyer().toUpperCase ().equals("MENSUELLE")){
							vuePayerMensuelle.run();
							vuePayerMensuelle.actualiserPayer();
							visualiserPayeMensuelle();
						}
						
					}
						
					}
						
				});
		
		
	}
    //liberer bien
	private void addLibererBienListener() {
		
		vueGestionnaire.addLibererBienListener(
				
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
					int value;
					value=vueGestionnaire.showMessageConfirmation("Liberer Bien", "Voulez vous Liberer le bien Immobilier??");
					
					try {
						if(value==0) {
							vueGestionnaire.colorerChampVide();
							libererBien();
							vueGestionnaire.actualiserTableBienLocataire();
							vueGestionnaire.actualiserTableBienAloue();
							vueGestionnaire.actualiserTableLocataire();
							vueGestionnaire.actualiserTableBienGestionnaire();
							visualiserBienLocataire();
							visualiserBienAloueLocataire();
							visualiserBienGestionnaire();
							visualiserLocataire();
							actualiserStatistique();
						}
					} catch (NullIdDataExeption e1) {
						// TODO Auto-generated catch block
						 vueGestionnaire.showMessage(e1.getMessage());
					}
					
						
					}
						
				});
		
	}
	
    //table des locataires
	private void addListeLocataireListener() {
		vueGestionnaire.addTableListeLocataireMousseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				idLocataire=Integer.parseInt(vueGestionnaire.tableListeLocataireCol1());
			}
		});
		
	}
	
	
	//annuler bien a locataire
		private void addAnnulerAjoutLocataireListener() {

	        vueGestionnaire.addAnnulerAjoutCompteListener(
					
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							
							vueGestionnaire.colorerBlanche();
							
						   }
						}
	
						);
		}	
						
						
    //affecter bien a locataire
	private void addAffecterLocataireListener() {

        vueGestionnaire.addAffecterBienListener(
				
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						int value;
						value=vueGestionnaire.showMessageConfirmation("Affectation de Biens", "Voulez Vous affecter ce Bien Immobilier??");
						
						
						try {
							if(value==0) {
								vueGestionnaire.colorerChampVide();
								affecterBien();
								vueGestionnaire.actualiserTableBienLocataire();
								vueGestionnaire.actualiserTableBienAloue();
								vueGestionnaire.actualiserTableLocataire();
								vueGestionnaire.actualiserTableBienGestionnaire();
								visualiserBienLocataire();
								visualiserBienAloueLocataire();
								visualiserBienGestionnaire();
								visualiserLocataire();
								actualiserStatistique();
							}
						} catch (NullIdDataExeption e1) {
							
							vueGestionnaire.showMessage(e1.getMessage());
						}
						
						
					}
						
				});
		
	}

	//**************************************LISTENERS DE LA PAGE DES USERS (BIENS IMMOBILIERS)************************************************//
	//
	//
	//*******************************************************************************************************************************//
	
	
	//listener bien immobilier actives
	private void addTableBienActifMousseListener() {
		vueAdmin.addTableGereBienActifMousseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				id_bien_active=Integer.parseInt(vueAdmin.tableBienActifCol1());
         		String add =vueAdmin.tableBienActifCol2();
         		double somm = Double.parseDouble(vueAdmin.tableBienActifCol3());
         		int nb = Integer.parseInt(vueAdmin.tableBienActifCol4());
         		String detail = vueAdmin.tableBienActifCol5();
         		String typeLoyer = vueAdmin.tableBienActifCol6();
         		String typeBien = vueAdmin.tableBienActifCol7();
			
				bienDesactiveActive= new BienImmobilier(id_bien_active,add,somm,nb,detail,typeLoyer,typeBien);

			}
		});
		
	}


	//listener table bien desactives
	private void addTableBienDesactiveMousseListener() {
		vueAdmin.addTableGereBienDesactiveMousseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				id_bien_desactive=Integer.parseInt(vueAdmin.tableBienDesactiveCol1());
         		String add =vueAdmin.tableBienDesactiveCol2();
         		double somm = Double.parseDouble(vueAdmin.tableBienDesactiveCol3());
         		int nb = Integer.parseInt(vueAdmin.tableBienDesactiveCol4());
         		String detail = vueAdmin.tableBienDesactiveCol5();
         		String typeLoyer = vueAdmin.tableBienDesactiveCol6();
         		String typeBien = vueAdmin.tableBienDesactiveCol7();
			
				bienDesactiveActive= new BienImmobilier(id_bien_active,add,somm,nb,detail,typeLoyer,typeBien);
			

			}
		});
		
	}
	
	//listener table des Biens immobilier
	private void addTableBienrMousseListener() {
		vueAdmin.addTableGereBienMousseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
//				Date date2;
			   id_du_bien=Integer.parseInt(vueAdmin.tableBienCol1());

				vueAdmin.setAddresseBien(vueAdmin.tableBienCol2());
				vueAdmin.setLoyer(Double.parseDouble(vueAdmin.tableBienCol3()));
				vueAdmin.setNbPiece(Integer.parseInt(vueAdmin.tableBienCol4()));
				vueAdmin.setDetailBien(vueAdmin.tableBienCol5());

			}
		});
		
	}

//listener modifier bien immobilier
	private void addModifierBienListener() {
		
          vueAdmin.addModifierBienListener(
				
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						int value;
						value=vueAdmin.showMessageConfirmation("Modification de Bien", "Voulez Vous Modifier ce Bien Immobilier??");
						
						try {
							if(value==0) {
								ModifierBien();
								vueAdmin.actualiserTableBien();
								visualiserPayeJournalier();
								
							}
						} catch (NullBienImmobilierExeption e1) {
							
							vueAdmin.showMessage(e1.getMessage());
						}
						
						
					}
						
				});
		
	}

//listener activer bien
	private void addActiverBienListener() {
		  vueAdmin.addActiverBienListener(
					
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							
							
							if(vueAdmin.tailleCompteTableDesActive() == 0) {
								
								vueAdmin.showMessage("la table est vide!!");
								
							}else {
								
								
								int value;
								try {
									
									value=vueAdmin.showMessageConfirmation("Activation de Immobilier", "Voulez Vous Activer ce Bien Immobilier??");
									if(value==0) {
										activerBien();
										visualiserBien();
										visualiserBienActif();
										visualiserBienDesactive();	
									}
								} catch (NullIdDataExeption e1) {
									
									vueAdmin.showMessage(e1.getMessage());
								}

								
							}
														//vueAdmin.actualiserTableBien();
									
							
						}
							
					});
		
	}
  
	//listener desactiver bien

	private void addDesactiverBienListener() {
		
        vueAdmin.addDesactiverBienListener(
				
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						if(vueAdmin.tailleCompteTableBienActive() == 0) {
							vueAdmin.showMessage("TABLE EST  VIDE !!!");
							
						}else {
							int value;
							value=vueAdmin.showMessageConfirmation("Desactivation de bien", "Voulez Vous desactiver Ce Bien Immobilier??");
							
							try {
								if(value==0) {
									desactiverBien();
									visualiserBien();
									visualiserBienActif();
									visualiserBienDesactive();			
								}
							} catch (NullIdDataExeption e1) {
								
								vueAdmin.showMessage(e1.getMessage());
							}

							
						}
												//vueAdmin.actualiserTableBien();
						
					}
						
				});
		
	}

 //listener ajouter bien
	private void addAjouterBienListener() {
		vueAdmin.addCreerBienListener(
				
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						int value;
						
						try {
							value=vueAdmin.showMessageConfirmation("Creation de Bien", "Voulez-Vous Creer Ce Bien Immobilier??");
							if(value==0) {
							ajouterBien();
							vueAdmin.actualiserTableBien();
							visualiserBien();
							 visualiserBienActif();
							}
						} catch (NullBienImmobilierExeption e1) {
							vueAdmin.showMessage(e1.getMessage());
						}
						
					}
						
				});
		
	}
	
	
	public void addAnnulerBienListener() {
              vueAdmin.addAnnulerBienListener(
				
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						vueAdmin.setAddresseBien(null);
						vueAdmin.setLoyer(0);
						vueAdmin.setNbPiece(0);
						vueAdmin.setDetailBien(null);
						vueAdmin.colorerBlancheBI();
					}
						
				});
	}

//***************************************LISTENERS DE LA PAGE DES USERS(UTILISATEURS)**********************************************//
//
//
//************************************************************************************************************************//	
	//listener supprimer User
	
	public void addAnnulerUserListener() {
        vueAdmin.addAnnulerCompteListener(
			
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					vueAdmin.colorerBlanche();
					vueAdmin.setNom(null);
					vueAdmin.setPrenom(null);
					vueAdmin.setTelephone(null);;
					vueAdmin.setDateNaissance(null);
					vueAdmin.setEmail(null);
					
				}
					
			});
         }
	
	private void addQuiterPageAdminListener() {
		 vueAdmin.addQuiterListener(
					
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							int value;
							value=vueAdmin.showMessageConfirmation("Deconnexion", "Voulez Vous Deconnecter de l'Application Immobilier??");
							if(value==0) {
							vueAdmin.fermerFenetre();
							}
						}
							
					});
		
	}
	
	private void addQuiterPageGestionnaireListener() {
		 vueGestionnaire.addQuiterListener(
					
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							int value;
							value=vueGestionnaire.showMessageConfirmation("Deconnexion", "Voulez Vous Deconnecter de l'Application Immobilier??");
							if(value==0) {
								vueGestionnaire.fermerFenetre();
							}
						}
							
					});
		
	}
	
	private void addSupprimerUserListener() {
		   vueAdmin.addSupprimerCompteListener(
					
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							
							if (vueAdmin.tailleCompteTableCompte() == 0) {
								
								vueAdmin.showMessage("la table est vide !!!");
							}else {
								
								
								
								int value;
								value=vueAdmin.showMessageConfirmation("SupprimerImmobilier", "Voulez Vous Supprimer Cet Immobilier??");
								if(value==0) {
									supprimerUser();
									vueAdmin.actualiserTableUser();
									if(vueAdmin.getUtilisateur().equals("Gestionnaire")) {
										visualiserGestionnaire();
									}else {
										visualiserAdmin();
									}
								}
								
							}
							
							
						}
							
					});
		
	}


	//listener table User
	private void addTableUserMousseListener() {

		vueAdmin.addTableGereCompteMousseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
//					Date date2;
				   id=Integer.parseInt(vueAdmin.tableUserCol1());
//					try {
//						date2 = new SimpleDateFormat("dd-MM-yyyy").parse(vueAdmin.tableUserCol3());
//						vueAdmin.setDateNaissance(date2);
//					} catch (ParseException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
					vueAdmin.setNom(vueAdmin.tableUserCol2());
					vueAdmin.setPrenom(vueAdmin.tableUserCol3());
					
					vueAdmin.setEmail(vueAdmin.tableUserCol5());
					vueAdmin.setTelephone(vueAdmin.tableUserCol6());
					if(vueAdmin.tableUserCol6().toUpperCase ()=="MASCULIN" || vueAdmin.tableUserCol6().toUpperCase ()=="M" ) {
						vueAdmin.setSexe(0);
					}
					else {
						vueAdmin.setSexe(1);
					}
					
					
				}
			});
		
		
	}
     
	//listener modifier user
	private void addModifierUserListener() {
		
      vueAdmin.addModifierCompteListener(
				
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						int value;
						value=vueAdmin.showMessageConfirmation("Modifier Utilisateur", "Voulez-Vous Modifier Cet Utilisateur??");
						
						try {
							if(value==0) {
							ModifierUser();
							}
						} catch (NullUserDataExecption e1) {
							vueAdmin.showMessage(e1.getMessage());
						}
						
					}	
				});
		
	}
                
	
	
	//afficher la liste des utilisateur selon le type choisi
	private void addAfficherUserAuChoix() {
		vueAdmin.addTableListeUserMousseListener(
				
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(vueAdmin.getUtilisateurId()==0) {
							vueAdmin.actualiserTableUser();

							visualiserGestionnaire();
						}else {
							vueAdmin.actualiserTableUser();

							visualiserAdmin();
						}
					}
						
				});
	}

	
	//listener ajouter user
	private void addAjouterUserListener() {
			vueAdmin.addCreerCompteListener(
					
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					
					int value;
					value=vueAdmin.showMessageConfirmation("Creation Utilisateur", "Voulez-Vous Ajouter Cet Utilisateur??");
					
					try {
						if(value==0) {
							ajouterUser();
						}
					} catch (NullUserDataExecption e1) {
						vueAdmin.showMessage(e1.getMessage());
					}
					
					
					//visualiserAdmin();
				   }		
					
			});
			
		
		
	}
	



	//***********************************LISTENERS DE LA PAGE D' ACCEUILLE *****************************************//
   //
   //	
   //****************************************************************************************************************//	
	
	private void addAnnulerListener() {
		vueAcceuil.addAnnulerListener(new ActionListener() {
				
					@Override
					public void actionPerformed(ActionEvent e) {
						vueAcceuil.SetLogin(null);
						vueAcceuil.SetPassword(null);
				    	vueAcceuil.colorerBlanche();
				    	
					}
					
		});
		
	}

	private void addConnecterListener() {
		vueAcceuil.addSeConnecterListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Authentification authentification;
				try {
					authentification = seConnecter();
					if(authentification!=null) {
						if(authentification.getStatus()!=1) {
							vueAcceuil.fermerFenetre();
							vueAdmin.run();
						}else {							
							vueGestionnaire.run();
							vueAcceuil.fermerFenetre();
						}
					}else {
						
						vueAdmin.showMessage("Mot de passe ou Login Incorrect!!!!");
						
					}
					
				} catch (NullAuthentificationDataException e1) {
					vueAdmin.showMessage(e1.getMessage());
				}
				
			}
			
        });
	}
	
	//controle d' acces a l'application
	   private Authentification seConnecter() throws NullAuthentificationDataException {
	   
	    	ClientResponse response = service.listeAuthentification();	
	    	Authentification authentification=null;
	    	
	    	if(vueAcceuil.getLogin().isEmpty() || vueAcceuil.getPassword().isEmpty() ) {
	    		vueAcceuil.colorerChamp("P");
		    	vueAcceuil.colorerChamp("L");
	    		throw new NullAuthentificationDataException("des champs ne sont pas renseignes");
	    	}
			
			try {
				ResponseDecoder decoder = new ResponseDecoder(response);
				List<Authentification> authen = decoder.getAuthentifications();
				Integer code = decoder.getCode();
				if (code == 200) {	
					if(authen!=null) {
					for(Authentification user:authen) {
						if(user.getLogin().equals(vueAcceuil.getLogin()) && user.getPassword().equals(vueAcceuil.getPassword()) ){
							authentification=new Authentification(vueAcceuil.getLogin(),vueAcceuil.getPassword(),user.getStatus());		
							break;
						}
						
					}
					}
					
				} 
			} catch (JsonProcessingException e) {			
				System.err.println("Error Class : " + e.getClass() + "\nError Message : " + e.getMessage());
			}	
			
			return authentification;
	    }
	   
	   
		
//****************************************METHODES DES USERS*****************************************///
//
//
//****************************************************************************************************//	   
	   
	   
	   
	
	//avoir la liste des administrateurs dans la table ajouter User
	public void visualiserAdmin() {
		
		ClientResponse response = service.listeAdministrateur();	
		
		try {
			ResponseDecoder decoder = new ResponseDecoder(response);
			Integer code = decoder.getCode();
			vueAdmin.actualiserTableUser();

			if (code == 200) {
				List<Administrateur> admin = decoder.getAdministrateurs();
				if(admin!=null) {
					for(Administrateur user:admin) {
						String[] ligne =new String[] {""+user.getId(),user.getNom(),user.getPrenom(),user.getNaissance(),user.getEmail(),user.getTelephone(),user.getGenre()};
						vueAdmin.addRowUser(ligne);
					}
				}else {
					vueAdmin.showMessage("Aucun Administrateur trouve dans la table");
				}
				
			} 

		} catch (JsonProcessingException e) {			
			vueAdmin.showMessage("erreur message: "+e.getMessage());
		}	
		
		
	}
	
	
	//avoir la liste des administrateurs uniquement
	
	public void visualiserListeAdmin() {
		//liste gestionnaires
		
				
		ClientResponse response = service.listeAdministrateur();	
		
		try {
			ResponseDecoder decoder = new ResponseDecoder(response);
			Integer code = decoder.getCode();
			//vueAdmin.actualiserTableUser();

			if (code == 200) {
				List<Administrateur> admin = decoder.getAdministrateurs();
				if(admin!=null) {
					for(Administrateur user:admin) {
						String[] ligne =new String[] {""+user.getId(),user.getNom(),user.getPrenom(),user.getNaissance(),user.getEmail(),user.getTelephone(),user.getGenre()};
						vueAdmin.addRowAdmin(ligne);
					}
				}else {
					vueAdmin.showMessage("Aucun Administrateur trouve dans la table");
				}
				
			}

		} catch (JsonProcessingException e) {			
			vueAdmin.showMessage("erreur message: "+e.getMessage());
		}	
		
		
	}
	
	
//avoir la liste des gestionnaires dans la table ajouter user
	public void visualiserGestionnaire() {
		
		ClientResponse response = service.listeGestionnaire();
		
		try {
			ResponseDecoder decoder = new ResponseDecoder(response);
			Integer code = decoder.getCode();
			//vueAdmin.actualiserTableUser();

			if (code == 200) {
				List<Gestionnaire> admin = decoder.getGestionnaires();
				if(admin!=null) {
					for(Gestionnaire user:admin) {
						String[] ligne =new String[] {""+user.getId(),user.getNom(),user.getPrenom(),user.getNaissance(),user.getEmail(),user.getTelephone(),user.getGenre()};
						vueAdmin.addRowUser(ligne);
					}
				}else {
					vueAdmin.showMessage("Aucun Gestionnaire trouve dans la table");
				}
				
			} 
		} catch (JsonProcessingException e) {			
			vueAdmin.showMessage("erreur message: "+e.getMessage());
		}	
		
		
	}
	
	
//avoir la liste des gestionnaire uniquement	
   public void visualiserListeGestionnaire() {
		
		ClientResponse response = service.listeGestionnaire();	
		
		try {
			ResponseDecoder decoder = new ResponseDecoder(response);
			Integer code = decoder.getCode();

			if (code == 200) {
				List<Gestionnaire> admin = decoder.getGestionnaires();
				if(admin!=null) {
					for(Gestionnaire user:admin) {
						String[] ligne =new String[] {""+user.getId(),user.getNom(),user.getPrenom(),user.getNaissance(),user.getEmail(),user.getTelephone(),user.getGenre()};
						vueAdmin.addRowGestionnaire(ligne);
					}
				}else {
					vueAdmin.showMessage("Aucun Gestionnaire trouve dans la table");
				}
				
			} 

		} catch (JsonProcessingException e) {			
			vueAdmin.showMessage("erreur message: "+e.getMessage());
		}	
		
		
	}
	
	
    
    //ajouter utilisateur dans la liste
   private void ajouterUser() throws NullUserDataExecption{
	   
    	ClientResponse response=null;
    	Integer id1=0,id2=0;
    	Authentification authentification=null;
    	
    	if(vueAdmin.getNom().isEmpty() || vueAdmin.getPrenom().isEmpty() ||vueAdmin.getTelephone().isEmpty()|| vueAdmin.getEmail().isEmpty()) {
    		vueAdmin.colorerChampVide();
    		throw new NullUserDataExecption("les champs ne sont pas renseignes");
    		
    	}
    	
    	if(vueAdmin.getUtilisateur().equals("Administrateur")) {
    		Administrateur admin= new Administrateur(vueAdmin.getNom(),vueAdmin.getPrenom(),vueAdmin.getTelephone(),vueAdmin.getEmail(),vueAdmin.getDateNaissance(),vueAdmin.getSexe());
    		response = service.ajouterAdministrateur(admin);
    		authentification=new Authentification(0,vueAdmin.getEmail(),vueAdmin.getEmail(),1);
    		id2=idAdmin();
    		vueAdmin.actualiserTableUser();
    		visualiserAdmin();
    	}

    	else if(vueAdmin.getUtilisateur().equals("Gestionnaire")) {
    		Gestionnaire admin= new Gestionnaire(vueAdmin.getNom(),vueAdmin.getPrenom(),vueAdmin.getTelephone(),vueAdmin.getEmail(),vueAdmin.getDateNaissance(),vueAdmin.getSexe());
    		response = service.ajouterGestionnaire(admin);
    		authentification=new Authentification(0,vueAdmin.getEmail(),vueAdmin.getEmail(),0);
    		id1=idGestionnaire();
    		
    		vueAdmin.actualiserTableUser();
    		visualiserGestionnaire() ;
    	}
		
		try {
			ResponseDecoder decoder = new ResponseDecoder(response);
			@SuppressWarnings("unused")
			ClientResponse reponse=null;
			Integer code = decoder.getCode();
			if (code == 200) {
				if(id1!=0) {
					authentification.setId(id1);
				    reponse= service.affecterAuthentification(authentification);
				    vueAdmin.showMessage("ok gestionnaire");
				}
				if(id2!=0) {
					authentification.setId(id2);
				    reponse = service.affecterAccesAdmin(authentification);
				    vueAdmin.showMessage("ok admin");
				}
	    	  
		      
			} 
		} catch (JsonProcessingException e) {			
			vueAdmin.showMessage(e.getMessage());
		}	
		
	
    }
    
    //le retour du dernier id de l admin
   private Integer idAdmin() {
    	   
    	ClientResponse response = service.listeAdministrateur();	
    	Administrateur admin=null;
		
		try {
			ResponseDecoder decoder = new ResponseDecoder(response);
			Integer code = decoder.getCode();
			if (code == 200) {
				List<Administrateur> authen = decoder.getAdministrateurs();
				if(authen!=null) {
					for(Administrateur user:authen) {
						admin=user;
					}
				}
				
			} 
		} catch (JsonProcessingException e) {			
			vueAdmin.showMessage(e.getMessage());
		}	
		
		return admin.getId();
    }
    
    //le id du dernier gestionnaire dans la liste
   private Integer idGestionnaire() {
 	   
    	ClientResponse response = service.listeGestionnaire();	
    	Gestionnaire admin=null;
		
		try {
			ResponseDecoder decoder = new ResponseDecoder(response);
			Integer code = decoder.getCode();
			if (code == 200) {
				List<Gestionnaire> authen = decoder.getGestionnaires();
				if(authen!=null) {
				for(Gestionnaire user:authen) {
					admin=user;
				}
				}
				
			} 
		} catch (JsonProcessingException e) {			
			vueAdmin.showMessage("ERROR SERVER:"+e.getMessage());
		}	
		
		return admin.getId();
    }
	
    
    //modifier utilisateur
   public void ModifierUser() throws NullUserDataExecption {
    	ClientResponse response=null;
    	if(vueAdmin.getNom().isEmpty() || vueAdmin.getPrenom().isEmpty() ||vueAdmin.getTelephone().isEmpty()|| vueAdmin.getEmail().isEmpty()) {
    		vueAdmin.colorerChampVide();
    		throw new NullUserDataExecption("les champs ne sont pas renseignes");
    	}

    	if(vueAdmin.getUtilisateur().equals("Administrateur") && vueAdmin.selectRowTableUser()>=0) {
    		
    		Administrateur admin= new Administrateur(id,vueAdmin.getNom(),vueAdmin.getPrenom(),vueAdmin.getTelephone(),vueAdmin.getEmail(),vueAdmin.getDateNaissance(),vueAdmin.getSexe());
    		response = service.modifierAdministrateur(admin);
    		
    		vueAdmin.actualiserTableUser();
    		visualiserAdmin();
    	}

    	else if(vueAdmin.getUtilisateur().equals("Gestionnaire")  && vueAdmin.selectRowTableUser()>=0) {

    		Gestionnaire admin= new Gestionnaire(id,vueAdmin.getNom(),vueAdmin.getPrenom(),vueAdmin.getTelephone(),vueAdmin.getEmail(),vueAdmin.getDateNaissance(),vueAdmin.getSexe());
    		response = service.modifierGestionnaire(admin);
    		
    		vueAdmin.actualiserTableUser();
    		visualiserAdmin();
    	}
		
		try {
			ResponseDecoder decoder = new ResponseDecoder(response);
			Integer code = decoder.getCode();
			if (code == 200) {
			
		      vueAdmin.showMessage("Utilisateur modifie avec success!!!!!!!!!");
			} 
		} catch (JsonProcessingException e) {			
			vueAdmin.showMessage("ERROR SERVER:"+e.getMessage());
		}	
    }
    
    public void supprimerUser() {
    	ClientResponse response=null;

    	if(vueAdmin.getUtilisateur().equals("Administrateur") && vueAdmin.selectRowTableUser()>=0) {
    		
    		
    		response = service.supprimerAdministrateur(id);
    	}

    	else if(vueAdmin.getUtilisateur().equals("Gestionnaire")  && vueAdmin.selectRowTableUser()>=0) {

    		
    		response = service.supprimerGestionnaire(id);
    	}
		
		try {
			ResponseDecoder decoder = new ResponseDecoder(response);
			Integer code = decoder.getCode();
			if (code == 200) {
			
		      vueAdmin.showMessage("Utilisateur Supprimer  avec success!!!!!!!!!");
			} 
		} catch (JsonProcessingException e) {			
			vueAdmin.showMessage("ERROR SERVER:"+e.getMessage());
		}	
    }
    
    
    //*********************************************METHODES DES BIEN IMMOBILIERS******************************************************//
   //
   //
  //********************************************************************************************************************//  
    
    //ajouter bien immobilier
    
    private void ajouterBien() throws NullBienImmobilierExeption {
    	ClientResponse response=null;
    	if(vueAdmin.getAddresseBien().isEmpty() || vueAdmin.getDetailBien().isEmpty()) {
    		vueAdmin.colorerChampVideBien();
    		throw new NullBienImmobilierExeption("les champs ne sont pas renseignes");
    	}
    	BienImmobilier admin= new BienImmobilier(vueAdmin.getAddresseBien(),vueAdmin.getLoyer(),vueAdmin.getNbPiece(),vueAdmin.getDetailBien(),vueAdmin.getTypeLocation(),vueAdmin.getTypeBien());
    	response = service.ajouterBienImmobilier(admin);
      	
		
	try {
			ResponseDecoder decoder = new ResponseDecoder(response);
			Integer code = decoder.getCode();
			if (code == 200) {
			
	    	  vueAdmin.showMessage("Bien Immobilier Ajoute Avec Succes!!!!");
		      
			} 
		} catch (JsonProcessingException e) {	
			vueAdmin.showMessage("ERROR SERVER:"+e.getMessage());
		}	
		
	
    }
    
    
//voir la liste des bien immobilier ajoutes    
    
public void visualiserBien() {
		
		ClientResponse response = service.listeImmobilier();
		
		
		try {
			ResponseDecoder decoder = new ResponseDecoder(response);
			Integer code = decoder.getCode();
			vueAdmin.actualiserTableBien();

			if (code == 200) {
				List<BienImmobilier> admin = decoder.getBienImmobiliers();
				if(admin!=null) {
				for(BienImmobilier user:admin) {
					String[] ligne =new String[] {""+user.getId(),user.getAddresse(),""+user.getLoyer(),""+user.getNombreDePiece(),user.getDetail(),user.getTypeLoyer(),user.getTypeBien()};
					vueAdmin.addRowBien(ligne);
				}
				}else {
					vueAdmin.showMessage("Aucun Bien Immobilier trouve dans la table");
				}
				
			} 

		} catch (JsonProcessingException e) {			
			vueAdmin.showMessage("erreur server: "+e.getMessage());
		}	
		
		
	}


//modifier bien immobilier ajoute
public void ModifierBien() throws NullBienImmobilierExeption{
	ClientResponse response=null;
	
	if(vueAdmin.getAddresseBien().isEmpty() || vueAdmin.getDetailBien().isEmpty()) {
		vueAdmin.colorerChampVideBien();
		throw new NullBienImmobilierExeption("des champs ne sont pas renseignes");
	}
	if( vueAdmin.selectRowTableBien()>=0) {
		
		BienImmobilier admin= new BienImmobilier(id_du_bien,vueAdmin.getAddresseBien(),vueAdmin.getLoyer(),vueAdmin.getNbPiece(),vueAdmin.getDetailBien(),vueAdmin.getTypeLocation(),vueAdmin.getTypeBien());
		response = service.modifierBienImmobilier(admin);
	}
	
	try {
		ResponseDecoder decoder = new ResponseDecoder(response);
		Integer code = decoder.getCode();
		if (code == 200) {
		
	      vueAdmin.showMessage("Utilisateur modifie avec success!!!!!!!!!");
		} 
	} catch (JsonProcessingException e) {			
		vueAdmin.showMessage("ERROR SERVER:"+e.getMessage());
	}	
   }

  //desactiver bien immobilier
  private void  desactiverBien()  throws NullIdDataExeption{
	  
	  ClientResponse response=null,reponse=null;

        if(id_bien_active>0 && bienDesactiveActive!=null &&  vueAdmin.selectRowTableBienActive()>=0) {
  		response = service.desactiverBienImmobilier(id_bien_active);
  	    reponse = service.ajouterBienImmobilierDesactive(bienDesactiveActive);
        }else {
        	throw new NullIdDataExeption("Aucun bien immobilier Selectionne!!!");
        }
  
		try {
			ResponseDecoder decoder = new ResponseDecoder(response);
			ResponseDecoder decode = new ResponseDecoder(reponse);
			Integer code = decoder.getCode();
			Integer code2 = decode.getCode();
			if (code == 200 && code2==200) {
			
		      vueAdmin.showMessage("Bien immobilier  desactive  avec success!!!!!!!!!");
			} 
		} catch (JsonProcessingException e) {			
			vueAdmin.showMessage("ERROR SERVER:"+e.getMessage());
		}	
     }
    
  //reactiver bien immobilier desactive
  private void  activerBien() throws NullIdDataExeption {
	  
	  ClientResponse response=null,reponse=null;

        if(id_bien_desactive>0 && bienDesactiveActive!=null &&  vueAdmin.selectRowTableBiendesactive()>=0) {
  		response = service.supprimeBienImmobilierDesactive(id_bien_desactive);
  	    reponse = service.ajouterBienImmobilier(bienDesactiveActive);
        }else {
        	throw new NullIdDataExeption("Aucun bien immobilier Selectionne!!!");
        }
  
		try {
			ResponseDecoder decoder = new ResponseDecoder(response);
			ResponseDecoder decode = new ResponseDecoder(reponse);
			Integer code = decoder.getCode();
			Integer code2 = decode.getCode();
			if (code == 200 && code2==200) {
			
		      vueAdmin.showMessage("Bien immobilier  reactive  avec success!!!!!!!!!");
			} 
		} catch (JsonProcessingException e) {			
			vueAdmin.showMessage("ERROR SERVER:"+e.getMessage());
		}	
     }
    
  
  //visualiser la liste des bien immobilier active
  public void visualiserBienActif() {
		
		ClientResponse response = service.listeImmobilier();
		
		
		try {
			ResponseDecoder decoder = new ResponseDecoder(response);
			Integer code = decoder.getCode();
			vueAdmin.actualiserTableBienActif();

			if (code == 200) {
				List<BienImmobilier> admin = decoder.getBienImmobiliers();
				if(admin!=null) {
				for(BienImmobilier user:admin) {
					String[] ligne =new String[] {""+user.getId(),user.getAddresse(),""+user.getLoyer(),""+user.getNombreDePiece(),user.getDetail(),user.getTypeLoyer(),user.getTypeBien()};
					vueAdmin.addRowBienActif(ligne);
				}
				}
				
			} 

		} catch (JsonProcessingException e) {			
			vueAdmin.showMessage("erreur server: "+e.getMessage());
		}	
		
		
	}
  
  //visualiser bien immobilier desactive
  public void visualiserBienDesactive() {
		
		ClientResponse response = service.listeImmobilierDesactive();
		
		
		try {
			ResponseDecoder decoder = new ResponseDecoder(response);
			Integer code = decoder.getCode();
			vueAdmin.actualiserTableBienDesactive();

			if (code == 200) {
				List<BienImmobilier> admin = decoder.getBienImmobiliers();
				if(admin!=null) {
				for(BienImmobilier user:admin) {
					String[] ligne =new String[] {""+user.getId(),user.getAddresse(),""+user.getLoyer(),""+user.getNombreDePiece(),user.getDetail(),user.getTypeLoyer(),user.getTypeBien()};
					vueAdmin.addRowBienDesactive(ligne);
				}
				}
			} 

		} catch (JsonProcessingException e) {			
			vueAdmin.showMessage("erreur serveur: "+e.getMessage());
		}	
		
		
	}
  
  
  //**************************************************METHODES DU GESTIONNAIRE********************************************************//
  //
  //
  //**********************************************************************************************************************************//
 
  
  public void visualiserBienLocataire() {
		
		ClientResponse response = service.listeImmobilier();
		
		
		try {
			ResponseDecoder decoder = new ResponseDecoder(response);
			Integer code = decoder.getCode();
			//vueGestionnaire.actualiserTableBienLocataire();

			if (code == 200) {
				List<BienImmobilier> admin = decoder.getBienImmobiliers();
				if(admin!=null) {
				for(BienImmobilier user:admin) {
					String[] ligne =new String[] {""+user.getId(),user.getAddresse(),""+user.getLoyer(),""+user.getNombreDePiece(),user.getDetail(),user.getTypeLoyer(),user.getTypeBien()};
					vueGestionnaire.addRowBienLocateur(ligne);
				}
				}
				
			} else {
//				vueGestionnaire.showMessage("erreur code: "+code);
//
//				String message = decoder.getMessage();
//				vueGestionnaire.showMessage("erreur message: "+message);
			}

		} catch (JsonProcessingException e) {			
			vueGestionnaire.showMessage("erreur serveur: "+e.getMessage());
		}	
		
		
	}
  
  
  public void visualiserBienGestionnaire() {
		
		ClientResponse response = service.listeImmobilier();
		
		
		try {
			ResponseDecoder decoder = new ResponseDecoder(response);
			Integer code = decoder.getCode();
			//vueGestionnaire.actualiserTableBienLocataire();

			if (code == 200) {
				List<BienImmobilier> admin = decoder.getBienImmobiliers();
				if(admin!=null) {
				for(BienImmobilier user:admin) {
					String[] ligne =new String[] {""+user.getId(),user.getAddresse(),""+user.getLoyer(),""+user.getNombreDePiece(),user.getDetail(),user.getTypeLoyer(),user.getTypeBien()};
					vueGestionnaire.addRowListeBien(ligne);
				}
				}
				
			} 
		} catch (JsonProcessingException e) {			
			vueGestionnaire.showMessage("erreur serveur: "+e.getMessage());
		}	
		
		
	}
  
  public void visualiserBienAloueLocataire() {
		
		ClientResponse response = service.listeImmobilierAloue();
		
		
		try {
			ResponseDecoder decoder = new ResponseDecoder(response);
			Integer code = decoder.getCode();
			//vueGestionnaire.actualiserTableBienLocataire();

			if (code == 200) {
				List<BienImmobilier> admin = decoder.getBienImmobiliers();
				if(admin!=null) {
				for(BienImmobilier user:admin) {
					String[] ligne =new String[] {""+user.getId(),user.getAddresse(),""+user.getLoyer(),""+user.getNombreDePiece(),user.getDetail(),user.getTypeLoyer(),user.getTypeBien()};
					vueGestionnaire.addRowBienAloue(ligne);
				}
				}
				
			} else {
//				vueGestionnaire.showMessage("erreur code: "+code);
//
//				String message = decoder.getMessage();
//				vueGestionnaire.showMessage("erreur message: "+message);
			}

		} catch (JsonProcessingException e) {			
			vueGestionnaire.showMessage("erreur serveur: "+e.getMessage());
		}	
		
		
	}

  
  public void visualiserLocataire() {
		
		ClientResponse response = service.consulterLocataire();
		
		
		try {
			ResponseDecoder decoder = new ResponseDecoder(response);
			Integer code = decoder.getCode();
			//vueGestionnaire.actualiserTableBienLocataire();

			if (code == 200) {
				List<Locataire> admin = decoder.getLocataires();
				if(admin!=null) {
				for(Locataire user:admin) {
					String[] ligne =new String[] {""+user.getId(),user.getNom(),""+user.getPrenom(),user.getNumeroPieceId(),user.getTelephone(),user.getEmail(),
							user.getGenre(),user.getDateDebutContrat(),user.getDateFinContrat(),user.getStatus()};
					vueGestionnaire.addRowListeLocateur(ligne);
				}
				}
				
			} else {
//				vueGestionnaire.showMessage("erreur code: "+code);
//
//				String message = decoder.getMessage();
//				vueGestionnaire.showMessage("erreur message: "+message);
			}

		} catch (JsonProcessingException e) {			
			vueGestionnaire.showMessage("erreur serveur: "+e.getMessage());
		}	
		
		
	}

  
  
  public void affecterBien() throws NullIdDataExeption {
	  double nbJr= getDaysBetweenDates(vueGestionnaire.getDateDebut(),vueGestionnaire.getDateFin());
	  ClientResponse response=null;
	  if(idLocataire!=0 && vueGestionnaire.selectRowTableAjouterLocataire()>=0 && nbJr>=0) {
		  Locataire locataire = new Locataire(idLocataire,vueGestionnaire.getNom(),vueGestionnaire.getPrenom(),vueGestionnaire.getTelephone(),vueGestionnaire.getEmail(),
			  vueGestionnaire.getSexe(),vueGestionnaire.getReferencePiece(),vueGestionnaire.getDateDebut(),vueGestionnaire.getDateFin(),"ER");
	   response = service.affecterBienALocataire(idLocataire, locataire);
	
	  }
	  else {
      	throw new NullIdDataExeption("Aucun bien immobilier Selectionne ou les dates de contrat erronee!!!");
      }
	  //vueGestionnaire.actualiserTableBienLocataire();	
	
	  Date date = new Date();
	  SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
	  PaiementLoyer loyer=new PaiementLoyer(idLocataire,formatter.format(date).toString(),montant);
	  ClientResponse reponse =service.rechercherBienImmobilier(idLocataire);
		try {
			ResponseDecoder decoder = new ResponseDecoder(response);
			ResponseDecoder decode = new ResponseDecoder(reponse);
			Integer code = decoder.getCode();
			BienImmobilier leBien=decode.getBienImmobilier();
			if (code == 200) {	
			   service.supprimerBienImmobilier(idLocataire);
			   service.aloueBienImmobilier(leBien);
			   if(typeImmobilier.toUpperCase ().equals("JOURNALIER")) {
				   if(nbJr<=30) {
					   loyer.setMontantPayer(montant*nbJr);
				   }else if(nbJr>30) {
					   loyer.setMontantPayer(montant*nbJr/3);
				   }
				   
				   service.enregistrerPaiement(idLocataire, loyer);
			   }else if(typeImmobilier.toUpperCase ().equals("MENSUELLE")) {
				   service.enregistrerPaiement(idLocataire, loyer);
			   }
				vueGestionnaire.showMessage(" Bien Immobilier affecte avec success!!");
							
			} 

		} catch (JsonProcessingException e) {			
			vueGestionnaire.showMessage("erreur serveur: "+e.getMessage());
		}	
		
  }
  
 public void libererBien() throws NullIdDataExeption {
	  
	  ClientResponse response=service.rechercherBienImmobilierAloue(id_du_bien);
     if((id_du_bien==0) || (vueGestionnaire.selectRowTableListeBienAloue()<0)) {
    	 
    	 throw new NullIdDataExeption("Aucun bien immobilier Selectionne!!!");
     }
		try {
			ResponseDecoder decoder = new ResponseDecoder(response);
			Integer code = decoder.getCode();
			BienImmobilier leBien=decoder.getBienImmobilier();
			if (code == 200) {	
			   service.libererBienImmobilier(id_du_bien);
			   service.ajouterBienImmobilier(leBien);
			   service.supprimerLocataire(id_du_bien);
			   libererPaiement(id_du_bien);
				vueGestionnaire.showMessage(" Bien Immobilier libere avec success!!");
							
			} 

		} catch (JsonProcessingException e) {			
			vueGestionnaire.showMessage("erreur serveur: "+e.getMessage());
		}	
		
  }
  
  private void libererPaiement(Integer id) {
	  ClientResponse response = service.consulterPaiement();
		
		
		try {
			ResponseDecoder decoder = new ResponseDecoder(response);
			Integer code = decoder.getCode();
			//vueGestionnaire.actualiserTableBienLocataire();

			if (code == 200) {
				List<PaiementLoyer> admin = decoder.getPaiementLoyers();
				if(admin!=null) {
				for(PaiementLoyer user:admin) {
					if(user.getIdLocataire()==id) {
						service.supprimerPaiement(user.getId());
					}
				}
				}else {
					vueGestionnaire.showMessage("Aucun Bien Immobilier trouve dans la table");
				}
				
			} else {
//				vueGestionnaire.showMessage("erreur code: "+code);
//
//				String message = decoder.getMessage();
//				vueGestionnaire.showMessage("erreur message: "+message);
			}

		} catch (JsonProcessingException e) {			
			vueGestionnaire.showMessage("erreur serveur: "+e.getMessage());
		}	
  }
  
  
  
  //************************************METHODES DES FENETRES PAIEMENTS*********************************///
 //
 // 
 // *****************************************************************************************************//
  
  
  
  public void visualiserPayeJournalier() {
		
		ClientResponse response = service.consulterPaiement();
		
		
		try {
			ResponseDecoder decoder = new ResponseDecoder(response);
			Integer code = decoder.getCode();
			//vueGestionnaire.actualiserTableBienLocataire();

			if (code == 200) {
				List<PaiementLoyer> admin = decoder.getPaiementLoyers();
				if(admin!=null) {
				for(PaiementLoyer user:admin) {
					if(user.getIdLocataire()==vuePayerJournalier.getId()) {
					String[] ligne =new String[] {""+user.getId(),user.getPeriode(),""+user.getMontantPayer()};		
					vuePayerJournalier.addRowPayer(ligne);
					}
				}
				}else {
					vuePayerJournalier.showMessage("Aucun payement trouve dans la table");
				}
				
			}

		} catch (JsonProcessingException e) {			
			vuePayerJournalier.showMessage("erreur serveur: "+e.getMessage());
		}	
  
  }
  
  public void visualiserPayeMensuelle() {
		
		ClientResponse response = service.consulterPaiement();
		
		
		try {
			ResponseDecoder decoder = new ResponseDecoder(response);
			Integer code = decoder.getCode();
			//vueGestionnaire.actualiserTableBienLocataire();

			if (code == 200) {
				List<PaiementLoyer> admin = decoder.getPaiementLoyers();
				if(admin!=null) {
				for(PaiementLoyer user:admin) {
					if(user.getIdLocataire()==vuePayerMensuelle.getId()) {
					String[] ligne =new String[] {""+user.getId(),user.getPeriode(),""+user.getMontantPayer()};		
					vuePayerMensuelle.addRowPayer(ligne);
					}
				}
				}else {
					vuePayerMensuelle.showMessage("Aucun payement trouve dans la table");
				}
				
			}

		} catch (JsonProcessingException e) {			
			vuePayerJournalier.showMessage("erreur serveur: "+e.getMessage());
		}	

     }
  //type de bien immobilier
   private BienImmobilier renvoiTypeLoyer(Integer id) {
	   ClientResponse response=service.rechercherBienImmobilierAloue(id);
	   BienImmobilier payer=null;
		try {
			ResponseDecoder decoder = new ResponseDecoder(response);
			Integer code = decoder.getCode();
			BienImmobilier leBien=decoder.getBienImmobilier();
			if (code == 200) {	
			  payer=leBien;
							
			} 

		} catch (JsonProcessingException e) {			
			vueGestionnaire.showMessage("erreur message: "+e.getMessage());
		}	
		
		return payer;
   }
   
 //payer un loyer
   public void payerLoyerMensuel() throws NullPaiementDataExeption{
	   
	   if(vuePayerMensuelle.getDate().isEmpty()) {
	    	 throw new NullPaiementDataExeption("le champ n 'est pas renseigne!!!");
	     }
	   PaiementLoyer payer=new PaiementLoyer(idLocataire,vuePayerMensuelle.getDate(),vuePayerMensuelle.getMontant());
	   ClientResponse response = service.enregistrerPaiement(idLocataire, payer);
	  
		
		try {
			ResponseDecoder decoder = new ResponseDecoder(response);
			Integer code = decoder.getCode();
			//vueGestionnaire.actualiserTableBienLocataire();

			if (code == 200) {
						
				vuePayerMensuelle.showMessage("Loyer paye avec succes!!!!");
			}

		} catch (JsonProcessingException e) {			
			vuePayerMensuelle.showMessage("erreur serveur: "+e.getMessage());
		}	
   }
   
public void payerLoyerJournalier() throws NullPaiementDataExeption{
	   
	   @SuppressWarnings("unused")
	double nbJour=0;
	   if(vuePayerJournalier.getDate().isEmpty()) {
	    	 throw new NullPaiementDataExeption("le champ n 'est pas renseigne!!!");
	     }
 
	   PaiementLoyer payer=new PaiementLoyer(idLocataire,vuePayerJournalier.getDate(),montantLoyer()*nombreJour()/3);
	   ClientResponse response =service.enregistrerPaiement(idLocataire, payer);
		try {
			ResponseDecoder decoder = new ResponseDecoder(response);
			Integer code = decoder.getCode();

			if (code == 200) {
						
				vuePayerJournalier.showMessage("Loyer paye avec succes!!!!");
			}

		} catch (JsonProcessingException e) {			
			vuePayerJournalier.showMessage("erreur serveur: "+e.getMessage());
		}	
   }

   public double montantLoyer() {
	   ClientResponse response = service.rechercherBienImmobilierAloue(idLocataire);
	   double loyer=0;
	   try {
			ResponseDecoder decoder = new ResponseDecoder(response);
			Integer code = decoder.getCode();
			
			BienImmobilier bien =decoder.getBienImmobilier();
			 

			if ((code == 200)) {
						
				loyer=bien.getLoyer();
			}

		} catch (JsonProcessingException e) {			
			vuePayerJournalier.showMessage("erreur serveur: "+e.getMessage());
		}	
	   
	   return loyer;
   }
   
   
   public double nombreJour() {
	   ClientResponse response = service.rechercherLocataire(idLocataire);
	   double jour=0;
	   try {
			ResponseDecoder decoder = new ResponseDecoder(response);
			Integer code = decoder.getCode();
			
			Locataire locataire=decoder.getLocataire();
			 

			if ((code == 200)) {
						
				jour=getDaysBetweenDates(locataire.getDateDebutContrat(),locataire.getDateFinContrat());
			}

		} catch (JsonProcessingException e) {			
			vuePayerJournalier.showMessage("erreur serveur: "+e.getMessage());
		}	
	   
	   return jour;
   }
   
   //actualiser la table le payement journalier

   public void actualiserPaiementJournalier() {
	   ClientResponse response = service.consulterPaiement();
		int somme=0;
		double montant=0;
		double total=nombreJour()*montantLoyer();
		try {
			ResponseDecoder decoder = new ResponseDecoder(response);
			Integer code = decoder.getCode();
			//vueGestionnaire.actualiserTableBienLocataire();

			if (code == 200) {
				List<PaiementLoyer> admin = decoder.getPaiementLoyers();
				if(admin!=null) {
				for(PaiementLoyer user:admin) {
					if(user.getIdLocataire()==vuePayerJournalier.getId()) {
					  somme++;
					  montant=user.getMontantPayer();
					}
				}
				
				}
			}

		} catch (JsonProcessingException e) {			
			vuePayerJournalier.showMessage("erreur serveur: "+e.getMessage());
		}	
		
		if(somme==2 && total>montant) {
			vuePayerJournalier.setTranche2(false);
		}
		if(somme==3 && total>montant) {
			vuePayerJournalier.setTranche3(false);
		}
		if(somme==1 && total==montant) {
			vuePayerJournalier.setTranche2(false);
			vuePayerJournalier.setTranche3(false);
		}
		
   }
   
   public void modifierPaiement(PaiementLoyer payer) {
	   service.modifierPaiement(payer);
	   
   }
   
   
   
   public  double getDaysBetweenDates(String theEarlierDate, String theLaterDate) {
	   
	   SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
       Date Date1=null;
       Date Date2=null;
	try {
		Date1 = formatter.parse(theEarlierDate);
	    Date2 =formatter.parse(theLaterDate);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       
		double result = Double.POSITIVE_INFINITY;
		if (theEarlierDate != null && theLaterDate != null) {
			final long MILLISECONDS_PER_DAY = 1000 * 60 * 60 * 24;
			Calendar aCal = Calendar.getInstance();
			aCal.setTime(Date1);
			long aFromOffset = aCal.get(Calendar.DST_OFFSET);
			aCal.setTime(Date2);
			long aToOffset = aCal.get(Calendar.DST_OFFSET);
			long aDayDiffInMili = (Date2.getTime() + aToOffset) - (Date1.getTime() + aFromOffset);
			result = ((double) aDayDiffInMili / MILLISECONDS_PER_DAY);
		}
		return result;
	}
   
 //***************************************METHODE DE LA STATISTIQUE**********************************************//
   //
   //
   //************************************************************************************************************************//	
  
   public int nombreBienAloue() {
	   ClientResponse response = service.listeImmobilierAloue();
		int nombre=0;
		
		try {
			ResponseDecoder decoder = new ResponseDecoder(response);
			Integer code = decoder.getCode();
			//vueGestionnaire.actualiserTableBienLocataire();

			if (code == 200) {
				List<BienImmobilier> admin = decoder.getBienImmobiliers();
				if(admin!=null) {
				for(@SuppressWarnings("unused") BienImmobilier user:admin) {
					nombre++;
					}
				
				}else {
					vuePayerMensuelle.showMessage("Aucun payement trouve dans la table");
				}
				
			}

		} catch (JsonProcessingException e) {			
			vuePayerJournalier.showMessage("erreur serveur: "+e.getMessage());
		}	
		
		return nombre;
   }
   
   public int nombreLocataireEnRegleOuPas(String status) {
	   ClientResponse response = service.consulterLocataire();
		int nombre=0;
		
		try {
			ResponseDecoder decoder = new ResponseDecoder(response);
			Integer code = decoder.getCode();
			//vueGestionnaire.actualiserTableBienLocataire();

			if (code == 200) {
				List<Locataire> admin = decoder.getLocataires();
				if(admin!=null) {
				for(Locataire user:admin) {
					if(user.getStatus().equals(status))
					nombre++;
					}
				
				}else {
					vuePayerMensuelle.showMessage("Aucun payement trouve dans la table");
				}
				
			}

		} catch (JsonProcessingException e) {			
			vuePayerJournalier.showMessage("erreur serveur: "+e.getMessage());
		}	
		
		return nombre;
   }
   
   
   public void actualiserStatistique() {
	   vueGestionnaire.setNombreAloue(nombreBienAloue());
	   vueGestionnaire.setLocataireEnRegle(nombreLocataireEnRegleOuPas("ER"));
	   vueGestionnaire.setLocataireNonEnRegle(nombreLocataireEnRegleOuPas("NER"));
   }
   
   
    public void run() {
    	vueAcceuil.run();
    }
}
