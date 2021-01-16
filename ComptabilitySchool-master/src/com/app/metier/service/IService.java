package com.app.metier.service;

import java.util.List;

import com.app.metier.entites.Administrateur;
import com.app.metier.entites.Classe;
import com.app.metier.entites.Comptable;
import com.app.metier.entites.Depense;
import com.app.metier.entites.Eleve;
import com.app.metier.entites.FraisInscription;
import com.app.metier.entites.HoraireTotal;
import com.app.metier.entites.Paiement;
import com.app.metier.entites.PaiementAuxiliaire;
import com.app.metier.entites.PaiementEmployer;
import com.app.metier.entites.PaiementProfesseur;
import com.app.metier.entites.PaiementScolarite;
import com.app.metier.entites.Personnel;
import com.app.metier.entites.Poste;
import com.app.metier.entites.Professeur;
import com.app.metier.entites.Resume;
import com.app.metier.entites.Versement;

public interface IService {
	
	//GESTION COMPTABILITE
	
	//PAIEMENTAUXILIAIRE
		public void ajouterPaiementAuxiliaire(PaiementAuxiliaire depense);
		public void modifierPaiementAuxiliaire(PaiementAuxiliaire depense);
		public PaiementAuxiliaire recuperPaiementAuxiliairet(int id);
		public void supprimerPaiementAuxiliaire(int id);
		public List<PaiementAuxiliaire> afficherListePaiementAuxiliaire();
	
	
	//RESUME
	public List<Resume> afficherListeResume();

	//VERSEMENT
	public void ajouterVersement(Versement depense);
	public void modifierVersement(Versement depense);
	public Versement recuperVersement(int id);
	public void supprimerVersement(int id);
	public List<Versement> rechercherVersementParNom(String name);
	public List<Versement> afficherListeVersement();
	public double TotalVersement();
		
	    //DEPENSES
	public void ajouterDepense(Depense depense);
	public void modifierDepense(Depense depense);
	public Depense recuperDepense(int id);
	public void supprimerDepense(int id);
	public List<Depense> rechercherParNom(String name);
	public List<Depense> afficherListeDepense();
	public double recupererSomme();
	    //ELEVE
        public void ajouterEleve(Eleve eleve);
	public List<Eleve> afficherListeEleve();
	public void  modifierEleve(Eleve eleve);
	public Eleve recupererEleve(int id);
	public void supprimerEleve(int id);
public void miseAJourTrancheEleve(int tranche,Double montant,int id);
	public List<Eleve> rechercheParNomOuPrenom(String nom);
	public List<Eleve> rechercherTriEleveInscription(String nom);
	public List<Eleve> triListeEleveScolariteParNom(String nom) ;
	
	// Comptable
	public void ajouterComptable(Comptable comptable);
	public void modifierComptable(Comptable comptable);
	public Comptable recupererComptable(int id);
	public List<Comptable> afficherListeComptable();
	public void supprimerComptable(int id);
	public List<Comptable> rechercheComptableParNomPrenom(String nom);
	public List<Comptable> rechercheComptableParLoginMdp(String login,String password);
	
	//Gestion Horaire
	public void ajouterHoraire(HoraireTotal horaire);
	public void modifierHoraire(HoraireTotal horaire);
	public HoraireTotal recupererHoraire(int id);
	public List<HoraireTotal> afficherListeHoraire();
	public void supprimerHoraire(int id);
	public List<HoraireTotal> rechercheHoraireParIdMatiere(int id);
	
	//Gestion Admin
	public void ajouterAdmin(Administrateur admin);
	public void modifierAdmin(Administrateur horaire);
	public Administrateur recupererAdmin(int id);
	public List<Administrateur> afficherListeAdmin();
	public void supprimerAdmin(int id);
	public List<Administrateur> rechercheAdmineParNom(String nom);
	public List<Administrateur> rechercheAdmineParLoginMdp(String login,String password);
	
	//Gestion paiement
	public void ajouterPaiement(Paiement paiement);
	public void modifierPaiement(Paiement horaire);
	public Paiement recupererPaiement(int id);
	public List<Paiement> afficherListePaiement();
	public void supprimerPaiement(int id);
	public List<Paiement> recherchePaiementParNom(String nom);
	
	//Gestion paiement scolarite
	public void ajouterPaiementScolarite(PaiementScolarite paiement);
	public void modifierPaiementScolarite(PaiementScolarite horaire);
	public PaiementScolarite recupererPaiementScolarite(int id);
	public List<PaiementScolarite> afficherListePaiementScolarite();
	public void supprimerPaiementScolarite(int id);
	public List<PaiementScolarite> recherchePaiementScolariteParNomPrenom(String nom);
	public List<PaiementScolarite> recherchePaiementScolariteParTri(String nom);
	public List<PaiementScolarite> recherchePaiementScolariteParTriBy(String nom);
	public double TotalScolarite();
	//Gestion paiement professeur
	public void ajouterPaiementProfesseur(PaiementProfesseur paiement);
	public void modifierPaiementProfesseur(PaiementProfesseur horaire);
	public PaiementProfesseur recupererPaiementProfesseur(int id);
	public PaiementProfesseur recupererPaiementProfesseur(Professeur nom);
	public List<PaiementProfesseur> afficherListePaiementProfesseur();
	public void supprimerPaiementProfesseur(int id);
	public List<PaiementProfesseur> recherchePaiementProfesseurParNomPrenom(String nom);
	public List<PaiementProfesseur> recherchePaiementProfesseurParTri(String nom);
	public List<PaiementProfesseur> recherchePaiementProfesseurParProfesseur(Professeur nom);
	public double TotalPaieProf();

			//Gestion paiement employer
	public void ajouterPaiementEmployer(PaiementEmployer paiement);
	public void modifierPaiementEmployer(PaiementEmployer horaire);
	public PaiementEmployer recupererPaiementEmployer(int id);
	public List<PaiementEmployer> afficherListePaiementEmployer();
	public List<PaiementEmployer> afficherListePaiementEmployerParEmployer(Personnel horaire);
	public void supprimerPaiementEmployer(int id);
	public List<PaiementEmployer> recherchePaiementEmployerParNomPrenom(String nom);
	public List<PaiementEmployer> recherchePaiementEmployerParTri(String nom);
	public double TotalPaieEmploye();
				
	
	
	   //Gestion professeur
		public void ajouterProfesseur(Professeur paiement);
		public void modifierProfesseur(Professeur horaire);
		public Professeur recupererProfesseur(int id);
		public List<Professeur> afficherListeProfesseur();
		public void supprimerProfesseur(int id);
		public List<Professeur> rechercheProfesseurParNom(String nom);
		public List<Professeur> triParClasseMatiere(String nom);
		public Professeur recupererProfesseur(String nom,String prenom,String nomClasse,String nomMatiere,String type);

		
	
	//Gestion personnel 
	public void ajouterPersonnel(Personnel paiement);
	public void modifierPersonnel(Personnel horaire);
	public Personnel recupererPersonnel(int id);
	public List<Personnel> afficherListePersonnel();
	public void supprimerPersonnel(int id);
	public List<Personnel> recherchePersonnelParNom(String nom);
	public List<Personnel> rechercherParTri(String nom);
	   
	
	//Gestion poste 
	public void ajouterPoste(Poste paiement);
	public void modifierPoste(Poste horaire);
	public Poste recupererPoste(int id);
	public List<Poste> afficherListePoste();
	public void supprimerPostel(int id);
	public List<Poste> recherchePosteParNom(String nom);
	
	
	//Gestion classe 
	public void ajouterClasse(Classe paiement);
	public void modifierClasse(Classe horaire);
	public Classe recupererClasse(int id);
	public List<Classe> afficherListeClasse();
	public void supprimerClasse(int id);
	public List<Classe> rechercheClasseParNom(String nom);
	public List<Classe> rechercheClasseParIdMatiere(int id);
	public Classe nomClasse(int id);
	
	
	 //frais inscription 
	public void ajouterFraisScolarite(FraisInscription paiement);
	public void modifierFraisScolarite(FraisInscription horaire);
	public FraisInscription recupererFraisScolarite(int id);
	public List<FraisInscription> afficherListeFraisScolarite();
	public void supprimerFraisScolarite(int id);
	public List<FraisInscription> rechercheFraisScolaritetParNom(String nom);
	public List<FraisInscription> rechercheTriFraisScolarite(String nom);
	public List<FraisInscription> rechercheTriByFraisScolarite(String nom);
	public double TotalFraisInscription();
	//connection
	
	

}
