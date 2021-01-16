package com.appli.modele;

public abstract class Utilisateur {
	
	
	//ATTRIBUTS
	protected String adresse;
	protected int id;
	protected String nom;
	protected String prenom;
	protected String telephone;
	protected String email;
	
	//CONSTRUCTEUR
	public Utilisateur(int id,String nom, String prenom, String telephone, String email) {
		super();
		this.id=id;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;
	}
	
	public Utilisateur(String nom, String prenom, String telephone, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;
	}
	public Utilisateur() {}
	
	//SETTERS AND GETTES 
	
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
}
