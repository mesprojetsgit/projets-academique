package com.app.metier.entites;

public class Resume {
	
	private String nom;
	private String prenom;
	private Double montant;
	private String type;
	private String mois;
	private String matricule;
	
	public Resume() {
		super();
	}

	public Resume(String nom, String prenom, Double montant, String type, String mois, String matricule) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.montant = montant;
		this.type = type;
		this.mois = mois;
		this.matricule = matricule;
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

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMois() {
		return mois;
	}

	public void setMois(String mois) {
		this.mois = mois;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	

}
