package com.app.metier.entites;

public class FraisInscription {
	private String nom;
	private String prenom;
	private String classe;
	private String matricule;
	
	private String anneeScolaire;
	private String date;
	private double montant;
	private String modeDePaiement;

	private int id;

	public FraisInscription() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public FraisInscription(String nom, String prenom, String classe, String matricule, String anneeScolaire,
			String date, double montant, String modeDePaiement) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.classe = classe;
		this.matricule = matricule;
		this.anneeScolaire = anneeScolaire;
		this.date = date;
		this.montant = montant;
		this.modeDePaiement = modeDePaiement;
	}
	

	public FraisInscription(String nom, String prenom, String classe, String matricule, String anneeScolaire,
			String date, double montant, String modeDePaiement, int id) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.classe = classe;
		this.matricule = matricule;
		this.anneeScolaire = anneeScolaire;
		this.date = date;
		this.montant = montant;
		this.modeDePaiement = modeDePaiement;
		this.id = id;
	}



	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getAnneeScolaire() {
		return anneeScolaire;
	}

	public void setAnneeScolaire(String anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getModeDePaiement() {
		return modeDePaiement;
	}

	public void setModeDePaiement(String modeDePaiement) {
		this.modeDePaiement = modeDePaiement;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
