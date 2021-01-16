package com.app.controleur;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.app.interfaces.accueil.Accueil;
import com.app.interfaces.accueil.ChangerMotDePasse;
import com.app.interfaces.administrateur.IAdministrateur;
import com.app.interfaces.administrateur.IDetailEleve;
import com.app.interfaces.administrateur.IEleve;
import com.app.interfaces.administrateur.IEmployer;
import com.app.interfaces.administrateur.IProfesseur;
import com.app.interfaces.administrateur.IUtilisateur;
import com.app.interfaces.comptable.IComptabilite;
import com.app.interfaces.comptable.IDepense;
import com.app.interfaces.comptable.IPaiementScolarite;
import com.app.metier.entites.Administrateur;
import com.app.metier.entites.Comptable;
import com.app.metier.entites.Depense;
import com.app.metier.entites.Eleve;
import com.app.metier.entites.FraisInscription;
import com.app.metier.entites.PaiementEmployer;
import com.app.metier.entites.PaiementProfesseur;
import com.app.metier.entites.PaiementScolarite;
import com.app.metier.entites.Personnel;
import com.app.metier.entites.Professeur;
import com.app.metier.entites.Versement;
import com.app.metier.model.ModelDepense;
import com.app.metier.model.ModelEleve;
import com.app.metier.model.ModelPaiementScolarite;
import com.app.metier.service.IService;
import com.app.metier.service.Service;


public class ControleurAdmin {
	
	private IComptabilite iComptabilite ;
	private IDepense iDepense;
	private ModelDepense modelDepense ;
	private ModelPaiementScolarite modelPaiementScolarite ;
	private ModelEleve modelEleve ;
	private IAdministrateur iAdmin;
	private IUtilisateur iUser;
	private IEmployer iEmployer;
	private IProfesseur iProf;
	private IService service;
	private int id=0;
	private Administrateur adminUpdate=null;
	private Personnel employerGlobal=null;
	private IEleve iEleve;
	private IDetailEleve iDetailEleve;
	private Date aujourdhui;
	private SimpleDateFormat formater ;
    private boolean running=false;
	Comptable comptabelUpdate=null; 
	List<Depense>depenses = new ArrayList<Depense>();
	private Administrateur admin;
	DecimalFormat groupeddecimalFormat = new DecimalFormat("###,###.###");

		
    public ControleurAdmin(Administrateur admin) {
    	    groupeddecimalFormat.setGroupingSize(3);
    	    this.admin=admin;
    	    iDetailEleve = new IDetailEleve();
    	    formater = new SimpleDateFormat("dd MMM yyyy");
    	    aujourdhui = new Date();
    	    iProf = new IProfesseur();
    	    iEleve = new IEleve();
    	    iEmployer = new IEmployer();
	        iAdmin= new IAdministrateur();
	        iUser = new IUtilisateur();
			iComptabilite = new IComptabilite();
			iDepense = new IDepense();
			service = new Service();
			modelDepense = new ModelDepense();
			modelEleve = new ModelEleve();
			modelPaiementScolarite = new ModelPaiementScolarite();
			
			traitementDepense();
			updateTableDepense(service.afficherListeDepense());
			updateTableListeEleve(service.afficherListeEleve());
			updateTablePaiementScolarite(service.afficherListePaiementScolarite());
		
			
			//administrateur
			listerComptable();
			listerAdmin();
			gestionAdmin();
			addTableUserMousseListener();
			//employe
			listerEmployer();
			addTableEmployerMousseListener();
			gestionEmployer();
			listerPaiementEmployer();
			
			//eleve
			addTableEleveMousseListener();
			listerEleve();
			gestionEleve();
			//versement
			
			listerVersement();
			
			//depense
			listerDepense();
			//paiement prof
			listerPaiementProf();
			//scolarite
			
			listerPaiementScolarite();
			//frais inscription
			listerFraisInscription();
			//prof
			addTableProfMousseListener() ;
			listerProf();
			gestionProf() ;
			//detail eleve
			listerDetailEleve();
			//trie
			gestionTrie();
			//connection 
			actionConnection() ;
		}
		
		
		//FONCTIONS DE MISE A JOUR DES TABLES
		
		private void updateTableDepense(List<Depense>depenses) {
			// TODO Auto-generated method stub
			modelDepense.setDepenses(depenses);
			iComptabilite.chargerModelDepense(modelDepense);
			iComptabilite.setTextField_MontantTotalDepense(String.valueOf(iComptabilite.totalTable()));
		}
		
		
		
		private void updateTablePaiementScolarite(List<PaiementScolarite>depenses) {
			// TODO Auto-generated method stub
			modelPaiementScolarite.setDepenses(depenses);
			iComptabilite.chargerModelPaiementScolarite(modelPaiementScolarite);;
		}
		
		
		private void updateTableListeEleve(List<Eleve>depenses) {
			// TODO Auto-generated method stub
			modelEleve.setDepenses(depenses);
			iComptabilite.chargerModelEleve(modelEleve);
		}
		
		
		
		

			
			
	
		
		
		
		//FONCTION DE TRAITEMENTS DE L'INTERFACE  DEPENSES
		private void traitementDepense() {
			
			
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
				onClickButtonValider();
				iDepense.effacer();
				
					
				}

				private void onClickButtonValider() {
					
					Depense depense = new Depense();
					depense.setAnneeScolaire(iDepense.getAnneeScolaire());
					depense.setDate(iDepense.getDateDepense());
					depense.setModePaiement(iDepense.getModePaiement());
					depense.setMontant(iDepense.getMontant());
					depense.setMotif(iDepense.getMotif());
					service.ajouterDepense(depense);
					
					updateTableDepense(service.afficherListeDepense());
					
				}
			});
			
			
			
			
		}
		



		
		//administrateur
		
		public void listerAdmin() {
			List<Administrateur> admin = service.afficherListeAdmin();
			if(admin!=null) {
				for(Administrateur user:admin) {
					String[] ligne =new String[] {""+user.getId(),user.getNom(),user.getPrenom(),user.getSexe(),user.getLogin(),user.getPassword(),user.getNumeroTel(),user.getEmail(),user.getAddresse(),user.getNumeroCINB(),};
					iAdmin.addRowAdmin(ligne);
				}
			}
		}
		public void ajouterAdmin() {
			id=0;
			Administrateur admin =new Administrateur(iUser.getNom(),iUser.getPrenom(),iUser.getMail(),iUser.getGenre(),iUser.getTel(),iUser.getAdresse(),iUser.getCnib(),iUser.getLogin(),iUser.getPasword1());
			service.ajouterAdmin(admin);
		}
		
         public void modifierAdmin() {
        	 adminUpdate =new Administrateur(iUser.getNom(),iUser.getPrenom(),iUser.getMail(),iUser.getGenre(),iUser.getTel(),iUser.getAdresse(),iUser.getCnib(),iUser.getLogin(),iUser.getPasword1(),id);
			service.modifierAdmin(adminUpdate);
		}
		
        public void modifierComptable(){
        	 comptabelUpdate = new Comptable(iUser.getNom(),iUser.getPrenom(),iUser.getMail(),iUser.getGenre(),iUser.getTel(),iUser.getAdresse(),iUser.getCnib(),iUser.getLogin(),iUser.getPasword1(),id);
        	 service.modifierComptable(comptabelUpdate);
         }
         
		public void listerComptable() {
			List<Comptable> admin = service.afficherListeComptable();
			if(admin!=null) {
				for(Comptable user:admin) {
					
					String[] ligne =new String[] {""+user.getId(),user.getNom(),user.getPrenom(),user.getSexe(),""+user.getLogin(),user.getPassword(),user.getNumeroTel(),user.getAddresse(),user.getNumeroCINB(),user.getEmail()};
					iAdmin.addRowComptable(ligne);
				}
			}
		}
		
       public void ajouterComptable() {
    	   id=0;
			
			Comptable admin =new Comptable(iUser.getNom(),iUser.getPrenom(),iUser.getMail(),iUser.getGenre(),iUser.getTel(),iUser.getAdresse(),iUser.getCnib(),iUser.getLogin(),iUser.getPasword1());
			service.ajouterComptable(admin);
			viderComptable();
		}
		
       public void viderComptable() {
    		iUser.setNom("");
			iUser.setPrenom("");
			iUser.setGenre("");
			iUser.setMail("");
			iUser.setTel("");
		    iUser.setAdresse("");
		    iUser.setCnib("");
			iUser.setLogin("");
			iUser.setPasword1("");
			iUser.setPasword2("");
       }
       
       
	   public void gestionAdmin() {
		   
		   
		   iAdmin.addComptableListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					viderComptable();
					id=0;
					iUser.run();
					iUser.setTypeUser("");
					iUser.setTypeUser("Comptable");
				}
			});
		   iAdmin.addAdminListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					viderComptable();
					id=0;
					iUser.run();
					iUser.setTypeUser("");
					iUser.setTypeUser("Administrateur");
				}
			});
		   iAdmin.updateAdminListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(iAdmin.selectRowAdmin()>=0) {
					iUser.run();
					iUser.setTypeUser("");
					iUser.setTypeUser("Administrateur");
					}else {
						exception();
					}
				}
			});
		   iAdmin.updateComptableListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(iAdmin.selectRowComptable()>=0) {
					iUser.run();
					iUser.setTypeUser("");
					iUser.setTypeUser("Comptable");
					}else {
						exception();
					}
				}
			});
		   iAdmin.supprimerComptableListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					

					if(iAdmin.selectRowComptable()>=0) {
						int value=iAdmin.showMessageConfirmation("Confirmation suppression", "Voulez vous Liberer le comptable??");
						if(value==0) {
							service.supprimerComptable(id);
							iAdmin.actualiserComptabilite();
							listerComptable();
							iAdmin.aProposActionPerformed(null, "Comptable supprimé avec succès !");
						}
					}else {
						exception();
					}
					
				}
			});
		   iAdmin.supprimerAdminListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					if(iAdmin.selectRowAdmin()>=0) {
						int value=iAdmin.showMessageConfirmation("Confirmation suppression", "Voulez vous Liberer l'administrateur??");
						if(value==0) {
							service.supprimerAdmin(id);
							iAdmin.actualiserAdministrateur();
							listerAdmin();
							iAdmin.aProposActionPerformed(null, "Administrateur supprimé avec succès !");
							
						}
					}else {
						exception();
					}
				}
			});
		   iUser.annulerListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					iUser.annuler();
				
				}
			});
		   iUser.validerListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(iUser.getPasword1().equals(iUser.getPasword2())) {
						if(iUser.getTypeUser().equals("Comptable")) {
							if(id==0) {
								ajouterComptable();
								viderComptable();
								iAdmin.actualiserComptabilite();
								listerComptable();
								iAdmin.aProposActionPerformed(null, "Comptable ajouté avec succès");
							}else {
								modifierComptable();
								iUser.annuler();
								viderComptable();
								iAdmin.actualiserComptabilite();
								listerComptable();
								iAdmin.aProposActionPerformed(null, "Comptable modifié avec succès");
							
							}
							
						
					}else if(iUser.getTypeUser().equals("Administrateur")) {
						if(id==0) {
							ajouterAdmin();
							viderComptable();
							iAdmin.actualiserAdministrateur();
							listerAdmin();
							iAdmin.aProposActionPerformed(null, "Administrateur ajouté avec succès");
							}else {
								modifierAdmin();
								iUser.annuler();
								viderComptable();
								iAdmin.actualiserAdministrateur();
								listerAdmin();
								iAdmin.aProposActionPerformed(null, "Administrateur modifié avec succès");
							}
							
					}
					
					}else {
						iUser.showMessage("Mot de passe incorrect!!!");
						iUser.setPasword1("");
						iUser.setPasword2("");
					}
				}
			});
	   }
		
		
		
		
		//listener table User
		private void addTableUserMousseListener() {

			iAdmin.addTableAdminMousseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
     				    id=Integer.parseInt(iAdmin.tAdminCol1());
						Administrateur ad=service.recupererAdmin(id);
						iUser.setNom(ad.getNom());
						iUser.setPrenom(ad.getPrenom());						
						iUser.setMail(ad.getEmail());
						iUser.setTel(ad.getNumeroTel());
						iUser.setGenre(ad.getSexe());
						iUser.setLogin(ad.getLogin());
						iUser.setPasword1(ad.getPassword());
						iUser.setPasword2(ad.getPassword());
						iUser.setAdresse(ad.getAddresse());
						iUser.setCnib(ad.getNumeroCINB());
						
					}
				});
				
				iAdmin.addTableComptableMousseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
	 				    id=Integer.parseInt(iAdmin.tComptCol1());
	 				    Comptable compt=service.recupererComptable(id);
						iUser.setNom(compt.getNom());
						iUser.setPrenom(compt.getPrenom());						
						iUser.setMail(compt.getEmail());
						iUser.setTel(compt.getNumeroTel());
						iUser.setGenre(compt.getSexe());
						iUser.setLogin(compt.getLogin());
						iUser.setPasword1(compt.getPassword());
						iUser.setPasword2(compt.getPassword());
						iUser.setAdresse(compt.getAddresse());
						iUser.setCnib(compt.getNumeroCINB());
	
					}
				});
		}
		
		
		
		//employe


	   public void gestionEmployer() {
		   
		   
		   iAdmin.addEmployeListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					id=0;
					effacerChampEmplyoyer();
					iEmployer.setDateFin(formater.format(aujourdhui));
					iEmployer.setDateRecru(formater.format(aujourdhui));
					
					iEmployer.run();
				}
			});
		  
		   
		   iAdmin.updateEmployeListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(iAdmin.selectRowEmployer()>=0) {
						iEmployer.run();
					}else {
						exception();
					}
				}
			});
		  
		   iAdmin.supprimerEmployeListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					if(iAdmin.selectRowEmployer()>=0) {
						int value=iAdmin.showMessageConfirmation("Confirmation suppression", "Voulez vous Liberer l'employé??");
						if(value==0) {
							service.supprimerPersonnel(id);
							iAdmin.actualiserEmployer();
							listerEmployer();
							iAdmin.aProposActionPerformed(null, "Employé suprimé avec succès");
						}
					}else {
						exception();
					}
				}
			});
		   iEmployer.validerListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
						if(id==0) {
							ajouterEmployer();
							iAdmin.actualiserEmployer();
							effacerChampEmplyoyer();
							listerEmployer();
							iAdmin.aProposActionPerformed(null, "Employé ajouté avec succès");
							
						}else {
							modifierEmployer();
							iEmployer.annuler();
							iAdmin.actualiserEmployer();
							effacerChampEmplyoyer();
							listerEmployer();
							iAdmin.aProposActionPerformed(null, "Employé modifié avec succès");
							
						}
						;
					
					}
					
				
			});
		   iEmployer.annulerListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					iEmployer.annuler();
					}
					
				
			});
	   }
		
		
		
		
//		//listener table User
		private void addTableEmployerMousseListener() {

			iAdmin.addTableEmployerMousseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						
     				    id=Integer.parseInt(iAdmin.tEmployeCol1());
     				    iEmployer.setNom(iAdmin.tEmployeCol2());
     				    iEmployer.setPrenom(iAdmin.tEmployeCol3());
						
     				   iEmployer.setMail(iAdmin.tEmployeCol8());
     				   iEmployer.setAdresse(iAdmin.tEmployeCol9());
     				   iEmployer.setTel(iAdmin.tEmployeCol7());
					
			
						iEmployer.setPoste(iAdmin.tEmployeCol5());
						iEmployer.setAdresse(iAdmin.tEmployeCol7());
						iEmployer.setCnib(iAdmin.tEmployeCol10());
						iEmployer.setDateRecru(iAdmin.tEmployeCol11());
						iEmployer.setDateFin(iAdmin.tEmployeCol12());
						iEmployer.setSalaire(Double.parseDouble(iAdmin.tEmployeCol6()));
						
						
					}
				});
				
				
		}
	
		public void effacerChampEmplyoyer() {
			iEmployer.setNom("");
			iEmployer.setPrenom("");
			iEmployer.setGenre("");
			iEmployer.setMail("");
			iEmployer.setAdresse("");
			iEmployer.setTel("");
			iEmployer.setPoste("");
			iEmployer.setAdresse("");
			iEmployer.setCnib("");
			iEmployer.setDateRecru(formater.format(aujourdhui));
			iEmployer.setDateFin(formater.format(aujourdhui));
			iEmployer.setSalaire(0.0);
		}
		
		public void listerEmployer() {
			List<Personnel> admin = service.afficherListePersonnel();
			if(admin!=null) {
				for(Personnel user:admin) {
					String[] ligne =new String[] {""+user.getId(),user.getNom(),user.getPrenom(),user.getGenre(),user.getPoste(),""+user.getSalaire(),user.getNumeroTel(),user.getEmail(),user.getAddresse(),user.getNumeroCINB(),user.getDateRecrutement(),user.getDateArret()};
					iAdmin.addRowEmployer(ligne);
				}
			}
		}
		
		public void ajouterEmployer() {
			id=0;
			
			Personnel admin =new Personnel(iEmployer.getNom(),iEmployer.getPrenom(),iEmployer.getMail(),iEmployer.getGenre()
					,iEmployer.getTel(),iEmployer.getAdresse(),iEmployer.getCnib(),iEmployer.getDateRecru(),iEmployer.getDatFin(),iEmployer.getSalaire(),iEmployer.getPoste());
			service.ajouterPersonnel(admin);
		}
		
		
		
		
		
         public void modifierEmployer() {
        	 employerGlobal = new Personnel(iEmployer.getNom(),iEmployer.getPrenom(),iEmployer.getMail(),iEmployer.getGenre()
						,iEmployer.getTel(),iEmployer.getAdresse(),iEmployer.getCnib(),iEmployer.getDateRecru(),iEmployer.getDatFin(),iEmployer.getSalaire(),iEmployer.getPoste(),id);
			
			service.modifierPersonnel(employerGlobal);
		}
		
		
 		//eleve


  	   public void gestionEleve() {
  		   
  		   
  		   iAdmin.addEleveListener(new ActionListener() {
  				
  				@Override
  				public void actionPerformed(ActionEvent e) {
  					viderEleve();
  					iEleve.setDateChooser_naissanceEleve(formater.format(aujourdhui));
  					id=0;
  					iEleve.run();
  				}
  			});
  		  
  		   
  		   iAdmin.updateEleveListener(new ActionListener() {
  				
  				@Override
  				public void actionPerformed(ActionEvent e) {
  					if(iAdmin.selectRowEleve()>=0) {
  						iEleve.run();
  					}else {
  						exception();
  					}
  					
  				}
  			});
  		  
  		 iAdmin.supprimerEleveListener(new ActionListener() {
  				
  				@Override
  				public void actionPerformed(ActionEvent e) {
  					
  					if((iAdmin.selectRowEleve()>=0)) {
  						int value=iAdmin.showMessageConfirmation("Confirmation suppression", "Voulez vous Liberer l'élève??");
  						if(value==0) {
  							service.supprimerEleve(id);
  							iAdmin.actualiserEleve();
  							listerEleve();
  							iAdmin.aProposActionPerformed(null, "Elève supprimé");
  						}
  					}else {
  						exception();
  					}
  				}
  			});
  		   iEleve.validerListener(new ActionListener() {
  				
  				@Override
  				public void actionPerformed(ActionEvent e) {
  					
  						if(id==0) {
  							ajouterEleve();
  							viderEleve();
  	  						iAdmin.actualiserEleve();
  	  						listerEleve();
  							iAdmin.aProposActionPerformed(null, "Elève ajouté");
  						}else {
  							modifierEleve();
  							iEleve.annuler();
  							viderEleve();
  	  						iAdmin.actualiserEleve();
  	  						listerEleve();
  							iAdmin.aProposActionPerformed(null, "Elève modifié");
  						}
  						
  					
  					}
  					
  				
  			});
  		  iEleve.annulerListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					iEleve.annuler();
					
				}
			});
  	   }
  		
  		
  		
  		
//table eleve
  		private void addTableEleveMousseListener() {

  			iAdmin.addTableEleveMousseListener(new MouseAdapter() {
  					public void mouseClicked(MouseEvent arg0) {
  						
  						Eleve eleve =null;
       				    id=Integer.parseInt(iAdmin.tEleveCol1());
       				    
                        eleve=service.recupererEleve(id);
                        
                        iEleve.setTextField_nomEleve(eleve.getNom());
            		    iEleve.setTextField_prenomEleve(eleve.getPrenom());
            		    iEleve.setGenre("");
            			iEleve.setGenre(eleve.getSexe());
            		    iEleve.setTextField_adresseParentEleve(eleve.getAdresseTuteur());;
            		    iEleve.setTextField_prenomParentEleve(eleve.getPrenomTuteur());
            		    iEleve.setTextField_telephoneEleve(eleve.getTelEleve());
            		    iEleve.setTextField_NomParentEleve(eleve.getNomTuteur());
            		    iEleve.setTextField_numMatriculeEleve(eleve.getNumeroMatricule());
            		    iEleve.setTextField_telephoneParentEleve(eleve.getTelTuteur());
            		    
            		    iEleve.setStatus(eleve.getStatus());
            		    iEleve.setScolarite(eleve.getScolarite());
            		    iEleve.setClasse(eleve.getClasse());
            		    iEleve.setDateChooser_naissanceEleve(eleve.getNaissance());
  					}
  				});	
  				
  		    }
  	   public void viderEleve() {
  		    iEleve.setTextField_nomEleve("");
		    iEleve.setTextField_prenomEleve("");
			
		    iEleve.setTextField_adresseParentEleve("");;
		    iEleve.setTextField_prenomParentEleve("");
		    iEleve.setTextField_telephoneEleve("");
		    iEleve.setTextField_NomParentEleve("");
		    iEleve.setTextField_numMatriculeEleve("");
		    iEleve.setTextField_telephoneParentEleve("");
		    
		    iEleve.setStatus("");
		    iEleve.setScolarite(0);
		    iEleve.setClasse("");
		    iEleve.setDateChooser_naissanceEleve(formater.format(aujourdhui));
  	   }
  		
  		public void listerEleve() {
  			List<Eleve> admin = service.afficherListeEleve();
  			if(admin!=null) {
  				for(Eleve user:admin) {

  					String[] ligne =new String[] {""+user.getId(),user.getNumeroMatricule(),user.getNom(),user.getPrenom(),user.getClasse(),user.getSexe(),user.getTelEleve(),user.getStatus(),};
  					iAdmin.addRowEleve(ligne);
  				}
  			}
  		}
  		
  		public void ajouterEleve() {
  			id=0;
  			
  			Eleve admin =new Eleve(iEleve.getTextField_nomEleve(),iEleve.getTextField_prenomEleve(),iEleve.getGenre()
  					,iEleve.getTextField_numMatriculeEleve(),0.0,0.0,0.0,iEleve.getStatus(),iEleve.getClasse(),iEleve.getTextField_NomParentEleve(),iEleve.getTextField_prenomParentEleve(),
  					iEleve.getTextField_adresseParentEleve(),iEleve.getTextField_telephoneParentEleve(),iEleve.getTextField_telephoneEleve(),iEleve.getDateChooser_naissanceEleve(),iEleve.getScolarite());
  			service.ajouterEleve(admin);
  		}
  		

           public void modifierEleve() {
        	   
        	   Eleve eleve = service.recupererEleve(id);
        	   eleve.setNaissance(formater.format(aujourdhui));
  			service.modifierEleve(eleve);
  		}
           
   		//professeur


      	   public void gestionProf() {
      		   
      		   
      		   iAdmin.addProfListener(new ActionListener() {
      				
      				@Override
      				public void actionPerformed(ActionEvent e) {
      					id=0;
      					viderChampProf();
      					iProf.setDateArretProfesseur(formater.format(aujourdhui));
      					iProf.setDateRecrutementProfesseur(formater.format(aujourdhui));
      					iProf.setEtatSalairePermanent(false);
	    				iProf.setEtatSalaireVacataire(true);
	    				iProf.setVacataire(true);
	 				    iProf.setPermanent_permanent(false);
      					iProf.run();
      				}
      			});
      		  
      		   
      		   iAdmin.updateProfListener(new ActionListener() {
      				
      				@Override
      				public void actionPerformed(ActionEvent e) {
      					
      					if(iAdmin.selectRowProf()>=0) {
      						iProf.run();
      					}else {
      						exception();
      					}
      				}
      			});
      		  
      		 iAdmin.supprimerProfListener(new ActionListener() {
      				
      				@Override
      				public void actionPerformed(ActionEvent e) {
      					
      					if(iAdmin.selectRowProf()>=0) {
      						int value=iAdmin.showMessageConfirmation("Confirmation suppression", "Voulez vous Liberer le professeur??");
      						if(value==0) {
      							service.supprimerProfesseur(id);
      							iAdmin.actualiserProfesseur();
      							listerProf();
      							iAdmin.aProposActionPerformed(null, "Professeur supprimé avec succès");
      						}
      					}else {
      						exception();
      					}
      				}
      			});
      		   iProf.validerListener(new ActionListener() {
      				
      				@Override
      				public void actionPerformed(ActionEvent e) {
      					
      						if(id==0) {
      							ajouterProf();
      							viderChampProf();
          						iAdmin.actualiserProfesseur();
          						listerProf();
      							iAdmin.aProposActionPerformed(null, "Professeur ajouté avec succès");
      						}else {
      							modifierProf();
      							iProf.annuler();
      							viderChampProf();
          						iAdmin.actualiserProfesseur();
          						listerProf();
      							iAdmin.aProposActionPerformed(null, "Professeur modifié avec succès");
      						}
      						
      					
      					}
      					
      				
      			});
      		 iProf.annulerListener(new ActionListener() {
   				
   				@Override
   				public void actionPerformed(ActionEvent e) {
   					iProf.annuler();
   				}	
   				
   			      });
      		    iProf.chxVacataireListener(new ActionListener() {
    				
    				@Override
    				public void actionPerformed(ActionEvent e) {
    					
    					iProf.setPermanent_permanent(false);
    					iProf.setEtatSalairePermanent(false);
    					iProf.setEtatSalaireVacataire(true);
    					
    					}
    					
    				
    			});
      		  iProf.chxPermanentListener(new ActionListener() {
  				
  				@Override
  				public void actionPerformed(ActionEvent e) {
  					
  					iProf.setVacataire(false);
  					iProf.setEtatSalaireVacataire(false);
  					iProf.setEtatSalairePermanent(true);
					
  					
  					}
  					
  				
  			});
      	   }
      		
      		
      		
      		
//      		//listener table User
      		private void addTableProfMousseListener() {

      			iAdmin.addTableProfMousseListener(new MouseAdapter() {
      					public void mouseClicked(MouseEvent arg0) {
      						Professeur prof=null;
      						boolean vacataire=false;
      						boolean permanent=true;
      						double m=0.0,h=0.0;
      						if(iAdmin.tProfCol6().equals("Vacataire")) {
      							vacataire=true;
      							permanent=false;
      							iProf.setEtatSalairePermanent(false);
      	    					iProf.setEtatSalaireVacataire(true);
      							h=Double.parseDouble(iAdmin.tProfCol12());
      							m=0.0;
      						}else {
      							vacataire=false;
      							permanent=true;
      							iProf.setEtatSalairePermanent(true);
      							iProf.setEtatSalaireVacataire(false);
      							m=Double.parseDouble(iAdmin.tProfCol12());
      							h=0.0;
      						}
           				    id=Integer.parseInt(iAdmin.tProfCol1());
           				    
           				    prof=service.recupererProfesseur(id);
           				    iProf.setNomProfesseur(prof.getNom());
           				    iProf.setPrenomProfesseur(prof.getPrenom());
           				    iProf.setGenre("");
           				    iProf.setGenre(prof.getGenre());
           				    iProf.setVacataire(vacataire);
           				    iProf.setPermanent_permanent(permanent);
           				    iProf.setClasse(prof.getNomClasse());
           				    iProf.setMatiere(prof.getNomMatiere());
           				    iProf.setTelephoneProfesseur(prof.getNumeroTel());
           				    iProf.setEmailProfesseur(prof.getEmail());
           				    iProf.setAnneeExperience(Integer.parseInt(prof.getExperience()));
           				    iProf.setSalaireHoraire(h);
           				    iProf.setSalaireMensuel(m);
           				    iProf.setAdresseProfesseur(prof.getAddresse());
           				    iProf.setNumCarteIdentiteProfesseur(prof.getNumeroCINB()); 
           				    iProf.setDateRecrutementProfesseur(prof.getDateRecrutement());
           				    iProf.setDateArretProfesseur(prof.getDateArret());
           				    iProf.setMatricule(prof.getMatricule());
           				    
      						
      					}
      				});	
      				
      		    }
      	    public void viderChampProf() {
      	    	    iProf.setNomProfesseur("");
				    iProf.setPrenomProfesseur("");
				  
				    iProf.setVacataire(true);
				    iProf.setPermanent_permanent(false);
				    iProf.setClasse("");
				    iProf.setMatiere("");
				    iProf.setTelephoneProfesseur("");
				    iProf.setEmailProfesseur("");
				    iProf.setAnneeExperience(0);
				    iProf.setSalaireHoraire(0.0);
				    iProf.setSalaireMensuel(0.0);
				    iProf.setAdresseProfesseur("");
				    iProf.setNumCarteIdentiteProfesseur(""); 
				    iProf.setDateRecrutementProfesseur(formater.format(aujourdhui));
				    iProf.setDateArretProfesseur(formater.format(aujourdhui));
				    iProf.setMatricule("");
				    
      	    }
      		
      		public void listerProf() {
      			List<Professeur> admin = service.afficherListeProfesseur();
      			if(admin!=null) {
      				for(Professeur user:admin) {

      					String[] ligne =new String[] {""+user.getId(),user.getMatricule(),user.getNom(),user.getPrenom(),user.getGenre(),
      							user.getType(),user.getNomClasse(),user.getNomMatiere(),user.getNumeroTel(),
      							user.getEmail(),user.getExperience(),""+user.getMontant(),user.getAddresse(),user.getNumeroCINB(),user.getDateRecrutement(),user.getDateArret()};
      					iAdmin.addRowProf(ligne);
      				}
      			}
      		}
      		
      		public void ajouterProf() {
      			
      			id=0;
      			String type="";
      			double montant=0.0;
      			if(iProf.getVacataire()) {
      				type="Vacataire";
      				montant=iProf.getSalaireHoraire();
      			}else {
      				type="Permanent";
      				montant=iProf.getSalaireMensuel();
      			}
      			
      			Professeur admin =new Professeur(iProf.getNomProfesseur(),iProf.getPrenomProfesseur(),iProf.getEmailProfesseur(),iProf.getGenre(),
      					iProf.getTelephoneProfesseur(),iProf.getAdresseProfesseur(),iProf.getNumCarteIdentiteProfesseur(),iProf.getDateRecrutementProfesseur(),
      					iProf.getDateArretProfesseur(),""+iProf.getAnneeExperience(),type,montant,iProf.getClasse(),iProf.getMatiere(),iProf.getMatricule());
      					
      					
      			service.ajouterProfesseur(admin);
      		}
      		

               public void modifierProf() {
            	   Professeur prof = service.recupererProfesseur(id);
            	   String type="";
            	   double salaire=0;
        			if(iProf.getVacataire()) {
        				type="Vacataire";
        				salaire=iProf.getSalaireHoraire();
        			}else {
        				type="Permanent";
        				iProf.setEtatSalairePermanent(true);
   					    iProf.setEtatSalaireVacataire(false);
   					    salaire=iProf.getSalaireMensuel();
        			}
        			
            	   
            	  
            	   Professeur eleve = new Professeur(iProf.getNomProfesseur(),iProf.getPrenomProfesseur(),iProf.getEmailProfesseur(),iProf.getGenre(),
         					iProf.getTelephoneProfesseur(),iProf.getAdresseProfesseur(),iProf.getNumCarteIdentiteProfesseur(),iProf.getDateRecrutementProfesseur(),
          					iProf.getDateArretProfesseur(),""+iProf.getAnneeExperience(),type,salaire,iProf.getClasse(),iProf.getMatiere(),iProf.getMatricule(),id);
      			
      			service.modifierProfesseur(eleve);
      		}
           
      //versement
      public void listerVersement() {
    	  generalListeVersement(service.afficherListeVersement());
  	  		
       }
    public void generalListeVersement(List<Versement> admin) {
    	iAdmin.actualiserVersement();
    	iAdmin.setTotalVersement(""+groupeddecimalFormat.format(service.TotalVersement())+"  FCFA");
    	if(admin!=null) {
			for(Versement user:admin) {
				String[] ligne =new String[] {user.getDate(),""+user.getMontant(),""+user.getNumeroCompte(),""+user.getSoldeCompte()};
				iAdmin.addRowVersement(ligne);
			}
		}
    }
		
	//depense
      public void listerDepense() {
    	  
    	  generalListeDepense(service.afficherListeDepense());
    	
      }
      public void generalListeDepense(List<Depense> admin) {
    	  iAdmin.actualiserDepense();
    	  iAdmin.setTotalDepense(""+groupeddecimalFormat.format(service.recupererSomme())+"  FCFA");
    	  if(admin!=null) {
				for(Depense user:admin) {
					String[] ligne =new String[] {""+user.getMontant(),user.getDate(),""+user.getModePaiement(),user.getAnneeScolaire(),user.getMotif()};
					iAdmin.addRowDepense(ligne);
				}
			}
      }
      
      //paiement scolarite
      public void listerPaiementScolarite() {
    	  
    	  generalListeScolarite(service.afficherListePaiementScolarite());

  			
        }
      public void generalListeScolarite(List<PaiementScolarite> admin) {
    	  iAdmin.actualiserPaiementScolariter();
    	  iAdmin.setTotalScolarite(""+groupeddecimalFormat.format(service.TotalScolarite())+"  FCFA");
    	  if(admin!=null) {
				
				for(PaiementScolarite user:admin) {
					String[] ligne =new String[] {user.getDate(),""+user.getNumeroRecu(),""+user.getNumeroPaiement(),""+user.getMontantScolarite(),user.getNumeroMatricule(),user.getNom(),user.getPrenom(),"sexe",user.getModePaiement()};
					iAdmin.addRowPaiementScolarite(ligne);
				}
			}
      }
      
      //paiement prof
      public void listerPaiementProf() {
    	  
    	  generalListePaiementProf(service.afficherListePaiementProfesseur() );
      	
  			
        }
      public void generalListePaiementProf(List<PaiementProfesseur> admin) {
    	  iAdmin.actualiserPaiementProfesseur();
    	  iAdmin.setTotalPaieProf(""+groupeddecimalFormat.format(service.TotalPaieProf())+"  FCFA");
    	  if(admin!=null) {
				for(PaiementProfesseur user:admin) {
					String[] ligne =new String[] {""+user.getMontantTotal(),user.getDateDePaiement(),user.getNom(),user.getPrenom(),user.getNomClasse(),user.getNomMatiere(),user.getModePaiement()};
					iAdmin.addRowPaiementProf(ligne);
				}
    	  }
    	  
      }
      //paiement employer

      public void listerPaiementEmployer() {
      	generalListePaiementEmploye(service.afficherListePaiementEmployer());
      	
        }
      public void generalListePaiementEmploye(List<PaiementEmployer> admin) {
    	  iAdmin.actualiserPaiementEmployer();
    	  iAdmin.setTotalPaieEmploye(""+groupeddecimalFormat.format(service.TotalPaieEmploye())+"  FCFA");
    	  if(admin!=null) {
				for(PaiementEmployer user:admin) {
					String[] ligne =new String[] {""+user.getMontant(),user.getDate(),user.getNom(),user.getPrenom(),""+user.getPoste(),user.getModeDePaiement()};
					iAdmin.addRowPaiementEmployer(ligne);
				}
			}
    	  
      }
 
      //frais inscription
   public void listerFraisInscription() {
	  
      generalListeInscription(service.afficherListeFraisScolarite());
   }
   public void generalListeInscription(List<FraisInscription> admin) {
	   iAdmin.actualiserFraisDeScolarite();
	   iAdmin.setTotalInscription(""+groupeddecimalFormat.format(service.TotalFraisInscription())+"  FCFA");
 	 if(admin!=null) {
		   
 		  for(FraisInscription user:admin) {
 		
 			String[] ligne =new String[] {""+user.getMontant(),user.getDate(),user.getMatricule(),user.getNom(),user.getPrenom(),user.getClasse(),"sexe",user.getModeDePaiement()};
 			iAdmin.addRowFraisScolarite(ligne);
 	    }
 	}
 	  
   }
   
   
   public void gestionTrie() {
	   
	   iAdmin.addValiderProfListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(iAdmin.getTriePProf().equals("tous")) {
						listerPaiementProf();
					}else {
					List <PaiementProfesseur> prof=service.recherchePaiementProfesseurParTri(iAdmin.getTriePProf());
					generalListePaiementProf(prof);
					}
				}
					
				
			});
	   iAdmin.addValiderInscriptionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(iAdmin.getTriePInscription().equals("tous")) {
					listerFraisInscription();
				}else {
				List <FraisInscription> prof=service.rechercheTriByFraisScolarite(iAdmin.getTriePInscription());
				generalListeInscription(prof);
				}
			}
				
			
		});
	   iAdmin.addValiderEmployeListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(iAdmin.getTriePEmployer().equals("tous")) {
					listerEmployer();
				}else {
				List <PaiementEmployer> prof=service.recherchePaiementEmployerParTri(iAdmin.getTriePEmployer());
				generalListePaiementEmploye(prof);
				}
			}
				
			
		});
	   iAdmin.addValiderScolariteListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(iAdmin.getTrieScolarite().equals("tous")) {
					listerPaiementScolarite();
				}else {
				List <PaiementScolarite> prof=service.recherchePaiementScolariteParTriBy(iAdmin.getTrieScolarite());
				generalListeScolarite(prof);
				}
			}
				
			
		});
   }
      
   //detail eleve
   public void listerDetailEleve() {
	   iAdmin.detailEleveListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
				//	iDetailEleve.setScolarite(liste.getScolarite());
					if(iAdmin.selectRowEleve()>=0) {
						Eleve liste= service.recupererEleve(id);
						
						iDetailEleve.setTextField_nomEleve(liste.getNom());
						iDetailEleve.setTextField_prenomEleve(liste.getPrenom());
						iDetailEleve.setTextField_genreEleve(liste.getSexe());
						iDetailEleve.setTextField_numMatriculeEleve(liste.getNumeroMatricule());
						iDetailEleve.setTextField_adresseParentEleve(liste.getAdresseTuteur());
						iDetailEleve.setTextField_NomParentEleve(liste.getNomTuteur());
						iDetailEleve.setTextField_prenomParentEleve(liste.getPrenomTuteur());
						iDetailEleve.setTextField_telephoneParentEleve(liste.getTelTuteur());
						iDetailEleve.setClasse(liste.getClasse());
						iDetailEleve.setStatus(liste.getStatus());
						iDetailEleve.setTextField_tranche_1(""+liste.getTranche1());
						iDetailEleve.setTextField_tranche_2(""+liste.getTranche2());
						iDetailEleve.setTextField_tranche_3(""+liste.getTranche3());
						iDetailEleve.setDateChooser_naissanceEleve(liste.getNaissance());
						iDetailEleve.setTextField_telephoneEleve(liste.getTelEleve());
					iDetailEleve.run();
					}else {
						exception();
					}
				}
			});
	       iDetailEleve.annulerListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				iDetailEleve.fermer();
				
			}
		});
	   
	   }
   
   
   public void actionConnection() {
	   iAdmin.addModifierMdpListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangerMotDePasse ch =new ChangerMotDePasse(null,admin);
				ch.run();
				
			}
		});
	   iAdmin.addDeconectionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Accueil acceuil =new Accueil();
				int msg=iAdmin.showMessageConfirmation("Déconnection","Voulez-vous vous déconnecter?" );
				if(msg==0) {
				iAdmin.close();
			    acceuil.run();
				}
			}
		});
	   if(admin!=null) {
		   iAdmin.setNomPrenomUser(admin.getNom()+" "+admin.getPrenom());
		   iAdmin.setNomPrenomUserSurveillance(admin.getNom()+" "+admin.getPrenom());
	   }
   }
    
        private void exception() {
    		Thread clignotant = new Thread ( new Runnable () {
    			@Override
    			public void run() {
    				running = true;
    				
    				while ( running ) {					
    					try {
    						iAdmin.setCouleur(Color.red);
    						iAdmin.setMessage("Veuillez Cliquer Sur Une Ligne Du Tableau");
    						Thread.sleep(3000);
    						
    						iAdmin.setMessage("");
    						running=false;
    					} catch (InterruptedException e) {}
    				}
    				
    			}			
    		});
    		clignotant.start();
    	}
		
	 public void run() {
		 
		 iAdmin.afficher();
	 }

}
