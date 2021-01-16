package com.app.metier.entites;

public  class Personne {
	
	protected String nom;
	protected String prenom;
	protected String email;
	protected String sexe ;
	protected String numeroTel;
	protected String addresse;
	protected String numeroCINB;
	
	
	
	public Personne() {
		super();
	}

	public Personne(String nom, String prenom, String email, String sexe, String numeroTel, String addresse, String numeroCINB) {
			
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.sexe = sexe;
		this.numeroTel = numeroTel;
		this.addresse = addresse;
		this.numeroCINB = numeroCINB;

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

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
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

	
	
	
	
	

}
