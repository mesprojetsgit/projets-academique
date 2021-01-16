package com.app.metier.service;

import java.util.ArrayList;
import java.util.List;

import com.app.dao.IDaoAdministrateur;
import com.app.dao.IDaoClasse;
import com.app.dao.IDaoComptable;
import com.app.dao.IDaoDepense;
import com.app.dao.IDaoEleve;
import com.app.dao.IDaoFraisInscripion;
import com.app.dao.IDaoHoraireTotal;
import com.app.dao.IDaoPaiement;
import com.app.dao.IDaoPaiementAuxiliaire;
import com.app.dao.IDaoPaiementEmployer;
import com.app.dao.IDaoPaiementProfesseur;
import com.app.dao.IDaoPaiementScolarite;
import com.app.dao.IDaoPersonnel;
import com.app.dao.IDaoPoste;
import com.app.dao.IDaoProffesseur;
import com.app.dao.IDaoResume;
import com.app.dao.IDaoVersement;
import com.app.daoImpl.DaoAdministrateurImpl;
import com.app.daoImpl.DaoClasseImpl;
import com.app.daoImpl.DaoComptableImpl;
import com.app.daoImpl.DaoDepenseImpl;
import com.app.daoImpl.DaoEleveImpl;
import com.app.daoImpl.DaoFraisInscriptionImpl;
import com.app.daoImpl.DaoHoraireTotalImpl;
import com.app.daoImpl.DaoPaiementAuxiliaire;
import com.app.daoImpl.DaoPaiementEmployer;
import com.app.daoImpl.DaoPaiementImpl;
import com.app.daoImpl.DaoPaiementProfesseurImpl;
import com.app.daoImpl.DaoPaiementScolarite;
import com.app.daoImpl.DaoPersonnelImpl;
import com.app.daoImpl.DaoPosteImpl;
import com.app.daoImpl.DaoProfesseurImpl;
import com.app.daoImpl.DaoResume;
import com.app.daoImpl.DaoVersementImpl;
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

public class Service implements IService {
	
	private IDaoDepense daoDepense = new DaoDepenseImpl();
	private IDaoEleve daoEleve = new DaoEleveImpl();
	private IDaoProffesseur daoProfesseur = new DaoProfesseurImpl();
	private IDaoComptable daoCompt = new DaoComptableImpl();
    private IDaoHoraireTotal daoHoraire = new DaoHoraireTotalImpl();
    private IDaoPaiement daoPaiement = new DaoPaiementImpl();
    private IDaoPaiementScolarite daoScalarite = new DaoPaiementScolarite();
    private IDaoPaiementProfesseur daoPaiementProfesseur = new DaoPaiementProfesseurImpl();
    private IDaoPaiementEmployer daoPaiementEmployer = new DaoPaiementEmployer();

    private IDaoClasse daoClasse = new DaoClasseImpl();
    private IDaoAdministrateur daoAdmin = new DaoAdministrateurImpl();
    private IDaoPersonnel daoPersonnel = new DaoPersonnelImpl();
    private IDaoPoste daoPoste = new DaoPosteImpl();
    private IDaoResume daoResume = new DaoResume();
    private IDaoVersement daoVersement = new DaoVersementImpl() ;
    private IDaoPaiementAuxiliaire daoPaiementAuxiliaire = new DaoPaiementAuxiliaire() ;
    private IDaoFraisInscripion daoFraisInscription = new DaoFraisInscriptionImpl();
    
    
	@Override
	public void ajouterDepense(Depense depense) {
		// TODO Auto-generated method stub
		daoDepense.create(depense);

	}

	@Override
	public void supprimerDepense(int id) {
		// TODO Auto-generated method stub
		daoDepense.delete(id);

	}

	@Override
	public List<Depense> afficherListeDepense() {
		// TODO Auto-generated method stub
		return daoDepense.getAll();
	}

	@Override
	public List<Depense> rechercherParNom(String name) {
		// TODO Auto-generated method stub
		return daoDepense.readByName(name);
	}

	@Override
	public void modifierDepense(Depense depense) {
		// TODO Auto-generated method stub
		daoDepense.update(depense);
	}

	@Override
	public Depense recuperDepense(int id) {
		// TODO Auto-generated method stub
		return daoDepense.read(id);
	}

	
	public List<Eleve> afficherListeEleve() {
		// TODO Auto-generated method stub
		return daoEleve.read();
	}

	@Override
	public void modifierEleve(Eleve eleve) {
		daoEleve.update(eleve);
		
	}

	@Override
	public Eleve recupererEleve(int id) {
		return daoEleve.read(id);
	}

	@Override
	public void supprimerEleve(int id) {
		daoEleve.delete(id);
		
	}

	@Override
	public List<Eleve> rechercheParNomOuPrenom(String nom) {
		// TODO Auto-generated method stub
		return daoEleve.readByName(nom);
	}

	@Override
	public void ajouterComptable(Comptable comptable) {
		daoCompt.create(comptable);
		
	}

	@Override
	public void modifierComptable(Comptable comptable) {
		daoCompt.update(comptable);
		
	}

	@Override
	public Comptable recupererComptable(int id) {
		return daoCompt.read(id);
	}

	@Override
	public List<Comptable> afficherListeComptable() {
		return daoCompt.read();
	}

	@Override
	public void supprimerComptable(int id) {
		daoCompt.delete(id);
		
	}

	@Override
	public List<Comptable> rechercheComptableParNomPrenom(String nom) {
		return daoCompt.readByName(nom);
	}

	@Override
	public void ajouterHoraire(HoraireTotal horaire) {
		daoHoraire.create(horaire);
		
	}

	@Override
	public void modifierHoraire(HoraireTotal horaire) {
		daoHoraire.equals(horaire);
		
	}

       @Override
	public List<Resume> afficherListeResume() {
		// TODO Auto-generated method stub
		return daoResume.read();
	}

	@Override
	public HoraireTotal recupererHoraire(int id) {
		return daoHoraire.read(id);
	}

	@Override
	public List<HoraireTotal> afficherListeHoraire() {
		
		return daoHoraire.read();
	}

	@Override
	public void supprimerHoraire(int id) {
		daoHoraire.delete(id);
		
	}

	@Override
	public List<HoraireTotal> rechercheHoraireParIdMatiere(int id) {
	
		return daoHoraire.readByMatiereId(id);
	}

	@Override
	public void ajouterAdmin(Administrateur admin) {
		daoAdmin.create(admin);
		
	}

	@Override
	public void modifierAdmin(Administrateur horaire) {
		daoAdmin.update(horaire);
		
	}

	@Override
	public Administrateur recupererAdmin(int id) {
		return daoAdmin.read(id);
	}

	@Override
	public List<Administrateur> afficherListeAdmin() {
		
		return daoAdmin.read();
	}

	@Override
	public void supprimerAdmin(int id) {
		daoAdmin.delete(id);
		
	}

	@Override
	public List<Administrateur> rechercheAdmineParNom(String nom) {
	
		return daoAdmin.readByName(nom);
	}

	@Override
	public void ajouterPaiement(Paiement paiement) {
		daoPaiement.create(paiement);
		
	}

	@Override
	public void modifierPaiement(Paiement horaire) {
		daoPaiement.update(horaire);
		
	}

	@Override
	public Paiement recupererPaiement(int id) {
		
		return daoPaiement.read(id);
	}

	@Override
	public List<Paiement> afficherListePaiement() {
		
		return daoPaiement.read();
	}

	@Override
	public void supprimerPaiement(int id) {
		daoPaiement.delete(id);
		
	}

	@Override
	public List<Paiement> recherchePaiementParNom(String nom) {

		return daoPaiement.readByName(nom);
	}

	@Override
	public void ajouterPaiementScolarite(PaiementScolarite paiement) {
		daoScalarite.create(paiement);
		
	}

	@Override
	public void modifierPaiementScolarite(PaiementScolarite horaire) {
		daoScalarite.update(horaire);
		
	}

@Override
	public void miseAJourTrancheEleve(int tranche, Double montant, int id) {
		daoEleve.update(tranche, montant, id);
		
	}

	@Override
	public PaiementScolarite recupererPaiementScolarite(int id) {
		
		return daoScalarite.read(id);
	}

	

	@Override
	public void supprimerPaiementScolarite(int id) {
		daoScalarite.delete(id);
		
	}
	
	

	@Override
	public List<PaiementScolarite> recherchePaiementScolariteParNomPrenom(String nom) {
		
		return daoScalarite.readByName(nom);
	}


	

	@Override
	public void ajouterPersonnel(Personnel paiement) {
		daoPersonnel.create(paiement);
		
	}

	@Override
	public void modifierPersonnel(Personnel horaire) {
		daoPersonnel.update(horaire);
		
	}

	@Override
	public Personnel recupererPersonnel(int id) {
	
		return daoPersonnel.read(id);
	}

	@Override
	public List<Personnel> afficherListePersonnel() {
		return daoPersonnel.read();
	}

	@Override
	public void supprimerPersonnel(int id) {
		daoPersonnel.delete(id);
		
	}

	@Override
	public List<Personnel> recherchePersonnelParNom(String nom) {

		return daoPersonnel.readByName(nom);
	}

	@Override
	public void ajouterPoste(Poste paiement) {
		daoPoste.create(paiement);
		
	}

	@Override
	public void modifierPoste(Poste horaire) {
		daoPoste.update(horaire);
		
	}

	@Override
	public Poste recupererPoste(int id) {
		
		return daoPoste.read(id);
	}

	@Override
	public List<Poste> afficherListePoste() {
	
		return daoPoste.read();
	}

	@Override
	public void supprimerPostel(int id) {
		daoPoste.delete(id);
		
	}

	@Override
	public List<Poste> recherchePosteParNom(String nom) {
		
		return daoPoste.readByName(nom);
	}

	

	@Override
	public void ajouterClasse(Classe paiement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierClasse(Classe horaire) {
		daoClasse.create(horaire);
		
	}

	@Override
	public Classe recupererClasse(int id) {
		return daoClasse.read(id);
	}

	@Override
	public List<Classe> afficherListeClasse() {
		return daoClasse.read();
	}

	@Override
	public void supprimerClasse(int id) {
		daoClasse.delete(id);
		
	}
	

	@Override
	public List<Classe> rechercheClasseParNom(String nom) {
		return daoClasse.readByName(nom);
	}

	@Override
	public List<Classe> rechercheClasseParIdMatiere(int id) {
		
		return daoClasse.readByMatiereId(id);
	}
	

	public Classe nomClasse(int id) {
		// TODO Auto-generated method stub
		return daoClasse.read(id);
	}

	@Override
	public List<PaiementScolarite> afficherListePaiementScolarite() {
		// TODO Auto-generated method stub
		return daoScalarite.read();
	}

	@Override
	public List<PaiementScolarite> recherchePaiementScolariteParTri(String nom) {
		// TODO Auto-generated method stub
		return daoScalarite.readByTri(nom);
	}

	@Override
	public void ajouterProfesseur(Professeur paiement) {
		 daoProfesseur.create(paiement);
		
	}

	@Override
	public void modifierProfesseur(Professeur horaire) {
		daoProfesseur.update(horaire);
	}

	@Override
	public Professeur recupererProfesseur(int id) {
		// TODO Auto-generated method stub
		return daoProfesseur.read(id);
	}

	@Override
	public List<Professeur> afficherListeProfesseur() {
		// TODO Auto-generated method stub
		return daoProfesseur.read();
	}

	@Override
	public void supprimerProfesseur(int id) {
	      daoProfesseur.delete(id);
		
	}

	@Override
	public List<Professeur> rechercheProfesseurParNom(String nom) {
		// TODO Auto-generated method stub
		return daoProfesseur.readByName(nom);
	}

	@Override
	public List<Professeur> triParClasseMatiere(String nom) {
		List<Professeur> profs = new ArrayList<Professeur>();
		
		if (nom.equals("classe")) {
			profs= daoProfesseur.readTriByNomClasse(nom);
		}else if (nom.equals("matiere")) {
			profs = daoProfesseur.readTriByNomMatiere(nom);
		}
		 return profs;
	}

	@Override
	public void ajouterPaiementProfesseur(PaiementProfesseur paiement) {
		daoPaiementProfesseur.create(paiement);
		
	}

	@Override
	public void modifierPaiementProfesseur(PaiementProfesseur horaire) {
		daoPaiementProfesseur.update(horaire);
		
	}

	@Override
	public PaiementProfesseur recupererPaiementProfesseur(int id) {
		return daoPaiementProfesseur.read(id);
	}

	@Override
	public List<PaiementProfesseur> afficherListePaiementProfesseur() {
		return daoPaiementProfesseur.read();
	}

	@Override
	public void supprimerPaiementProfesseur(int id) {
		daoPaiementProfesseur.delete(id);
		
	}

	@Override
	public List<PaiementProfesseur> recherchePaiementProfesseurParNomPrenom(String nom) {
		return daoPaiementProfesseur.readByName(nom);
	}

	@Override
	public List<PaiementProfesseur> recherchePaiementProfesseurParTri(String nom) {
		return daoPaiementProfesseur.readByTri(nom);
	}

	@Override
	public void ajouterPaiementEmployer(PaiementEmployer paiement) {
		daoPaiementEmployer.create(paiement);
		
	}

	@Override
	public void modifierPaiementEmployer(PaiementEmployer horaire) {
		daoPaiementEmployer.update(horaire);
		
	}

	@Override
	public PaiementEmployer recupererPaiementEmployer(int id) {
		// TODO Auto-generated method stub
		return daoPaiementEmployer.read(id);
	}

	@Override
	public List<PaiementEmployer> afficherListePaiementEmployer() {
		// TODO Auto-generated method stub
		return daoPaiementEmployer.read();
	}

	@Override
	public void supprimerPaiementEmployer(int id) {
		daoPaiementEmployer.delete(id);
	}

	@Override
	public List<PaiementEmployer> recherchePaiementEmployerParNomPrenom(String nom) {
		// TODO Auto-generated method stub
		return daoPaiementEmployer.readByName(nom);
	}

	@Override
	public List<PaiementEmployer> recherchePaiementEmployerParTri(String nom) {
		// TODO Auto-generated method stub
		return daoPaiementEmployer.readByTri(nom);
	}
	public void ajouterEleve(Eleve eleve) {
		daoEleve.create(eleve);
		
	}

	

	@Override
	public void ajouterFraisScolarite(FraisInscription paiement) {
		daoFraisInscription.create(paiement);
		
	}

	@Override
	public void modifierFraisScolarite(FraisInscription horaire) {
		daoFraisInscription.update(horaire);
		
	}

	@Override
	public FraisInscription recupererFraisScolarite(int id) {
		// TODO Auto-generated method stub
		return daoFraisInscription.read(id);
	}

	@Override
	public List<FraisInscription> afficherListeFraisScolarite() {
		// TODO Auto-generated method stub
		return daoFraisInscription.read();
	}

	@Override
	public void supprimerFraisScolarite(int id) {
		// TODO Auto-generated method stub
		daoFraisInscription.delete(id);
	}

	@Override
	public List<FraisInscription> rechercheFraisScolaritetParNom(String nom) {
		// TODO Auto-generated method stub
		return daoFraisInscription.readByName(nom);
	}

	@Override
	public List<Eleve> triListeEleveScolariteParNom(String nom) {
		
		if(nom.equals("croissant")) {
			return daoEleve.readByASCName(nom);
			
		}
			
		else {
			return daoEleve.readByDESCName(nom);
		  }
	}

	@Override
	public List<Personnel> rechercherParTri(String nom) {
		// TODO Auto-generated method stub
		return daoPersonnel.readTri(nom);
	}

	@Override
	public void ajouterVersement(Versement depense) {
		
		daoVersement.create(depense);
		
	}

	@Override
	public void modifierVersement(Versement depense) {
		daoVersement.update(depense);
		
	}

	@Override
	public Versement recuperVersement(int id) {
		// TODO Auto-generated method stub
		return daoVersement.read(id);
	}

	@Override
	public void supprimerVersement(int id) {
		daoVersement.delete(id);		
	}

	@Override
	public List<Versement> rechercherVersementParNom(String name) {
		// TODO Auto-generated method stub
		return daoVersement.readByName(name);
	}

	@Override
	public List<Versement> afficherListeVersement() {
		// TODO Auto-generated method stub
		return daoVersement.read();
	}

	@Override
	public List<Eleve> rechercherTriEleveInscription(String nom) {
		// TODO Auto-generated method stub
		return daoEleve.readByTri(nom);
	}

	@Override
	public List<FraisInscription> rechercheTriFraisScolarite(String nom) {
		// TODO Auto-generated method stub
		return daoFraisInscription.readByTri(nom);
	}

	@Override
	public List<PaiementProfesseur> recherchePaiementProfesseurParProfesseur(Professeur nom) {
		// TODO Auto-generated method stub
		return daoPaiementProfesseur.readByProf(nom);
	}

	@Override
	public Professeur recupererProfesseur(String nom, String prenom, String nomClasse,
			String nomMatiere, String type) {
		// TODO Auto-generated method stub
		return daoProfesseur.read(nom, prenom, nomClasse, nomMatiere, type);
	}

	@Override
	public PaiementProfesseur recupererPaiementProfesseur(Professeur nom) {
		// TODO Auto-generated method stub
		return daoPaiementProfesseur.read(nom);
	}

	@Override
	public List<Comptable> rechercheComptableParLoginMdp(String login, String password) {
		return daoCompt.readByLoginPassword(login, password);
	}

	@Override
	public List<Administrateur> rechercheAdmineParLoginMdp(String login, String password) {
		return daoAdmin.readByLoginPassword(login, password);
	}

	@Override
	public List<PaiementScolarite> recherchePaiementScolariteParTriBy(String nom) {
		// TODO Auto-generated method stub
		return daoScalarite.trieBy(nom);
	}

	@Override
	public List<FraisInscription> rechercheTriByFraisScolarite(String nom) {
		
		return daoFraisInscription.readByTri(nom);
	}

	@Override
	public void ajouterPaiementAuxiliaire(PaiementAuxiliaire depense) {
		daoPaiementAuxiliaire.create(depense);
		
	}

	@Override
	public void modifierPaiementAuxiliaire(PaiementAuxiliaire depense) {
		daoPaiementAuxiliaire.update(depense);
		
	}

	@Override
	public PaiementAuxiliaire recuperPaiementAuxiliairet(int id) {
		// TODO Auto-generated method stub
		return daoPaiementAuxiliaire.read(id);
	}

	@Override
	public void supprimerPaiementAuxiliaire(int id) {
		daoPaiementAuxiliaire.delete(id);
		
	}

	@Override
	public List<PaiementAuxiliaire> afficherListePaiementAuxiliaire() {
		// TODO Auto-generated method stub
		return daoPaiementAuxiliaire.read();
	}
public double recupererSomme() {
		
		return daoDepense.sommeMontant();
	}

	@Override
	public double TotalVersement() {
		// TODO Auto-generated method stub
		return daoVersement.total();
	}

	@Override
	public double TotalScolarite() {
		// TODO Auto-generated method stub
		return daoScalarite.total();
	}

	@Override
	public double TotalPaieProf() {
		// TODO Auto-generated method stub
		return daoPaiementProfesseur.total();
	}

	@Override
	public double TotalPaieEmploye() {
		// TODO Auto-generated method stub
		return daoPaiementEmployer.total();
	}

	@Override
	public double TotalFraisInscription() {
		// TODO Auto-generated method stub
		return daoFraisInscription.total();
	}

	@Override
	public List<PaiementEmployer> afficherListePaiementEmployerParEmployer(Personnel horaire) {
		// TODO Auto-generated method stub
		return daoPaiementEmployer.readByEmployer(horaire);
	}
	
}
