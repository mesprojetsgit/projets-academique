package com.app.metier.entites;

public  class Professeur extends Employer {
	protected String experience;
	private String type;
	private Double montant;
	private String nomClasse;
	private String nomMatiere;
	private String matricule;
	private int id;
	
	public Professeur() {
		super();
	}

	
	public Professeur(String nom, String prenom, String email, String genre, String numeroTel, String addresse,
			 String numeroCINB, String dateRecrutement, String dateArret,String experience, String type, Double montant, String nomClasse, String nomMatiere,String matricule
			) {
		super(nom, prenom, email, genre, numeroTel, addresse, numeroCINB, dateRecrutement,
				dateArret);
		this.experience = experience;
		this.type = type;
		this.montant = montant;
		this.nomClasse = nomClasse;
		this.nomMatiere = nomMatiere;
		this.matricule=matricule;
	
	}


	public Professeur(String nom, String prenom, String email, String genre, String numeroTel, String addresse,
			 String numeroCINB, String dateRecrutement, String dateArret,String experience, String type, Double montant, String nomClasse, String nomMatiere,String matricule,
			 int id) {
		super(nom, prenom, email, genre, numeroTel, addresse, numeroCINB, dateRecrutement,
				dateArret);
		this.experience = experience;
		this.type = type;
		this.montant = montant;
		this.nomClasse = nomClasse;
		this.nomMatiere = nomMatiere;
		this.id = id;
		this.matricule=matricule;
	}


	public String getMatricule() {
		return matricule;
	}


	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}


	public String getExperience() {
		return experience;
	}


	public void setExperience(String experience) {
		this.experience = experience;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Double getMontant() {
		return montant;
	}


	public void setMontant(Double montant) {
		this.montant = montant;
	}


	public String getNomClasse() {
		return nomClasse;
	}


	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}


	public String getNomMatiere() {
		return nomMatiere;
	}


	public void setNomMatiere(String nomMatiere) {
		this.nomMatiere = nomMatiere;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	
	
}
