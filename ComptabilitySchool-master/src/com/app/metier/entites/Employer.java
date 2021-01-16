package com.app.metier.entites;

public abstract class Employer{

	protected String nom;
	protected String prenom;
	protected String email;
	protected String genre ;
	protected String numeroTel;
	protected String addresse;
	protected String dateNaissance;
	protected String nationalite;
	protected String numeroCINB;
	protected String dateRecrutement;
	protected String dateArret;
	
	public Employer() {
		super();
	}

	public Employer(String nom, String prenom, String email, String genre, String numeroTel, String addresse,
			 String numeroCINB, String dateRecrutement, String dateArret) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.genre = genre;
		this.numeroTel = numeroTel;
		this.addresse = addresse;
		this.numeroCINB = numeroCINB;
		this.dateRecrutement = dateRecrutement;
		this.dateArret = dateArret;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}



	public String getNumeroCINB() {
		return numeroCINB;
	}

	public void setNumeroCINB(String numeroCINB) {
		this.numeroCINB = numeroCINB;
	}

	public String getDateRecrutement() {
		return dateRecrutement;
	}

	public void setDateRecrutement(String dateRecrutement) {
		this.dateRecrutement = dateRecrutement;
	}

	public String getDateArret() {
		return dateArret;
	}

	public void setDateArret(String dateArret) {
		this.dateArret = dateArret;
	}
	
	
	
	
	
	
	
}
