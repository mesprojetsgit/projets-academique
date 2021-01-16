package com.appli.modele;

public abstract class  Personne {

	
	//ATTRIBUT
	protected String nom;
	protected String prenom;
	protected String telephone;
	protected String email;
	protected String genre;
	protected int id;
    
	public Personne() {
		
	}
	
	public Personne(String nom, String prenom, String telephone, String email,String genre) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;;
		this.genre = genre;
	}

	//CONSTRUCTEUR
	public Personne(int id,String nom, String prenom, String telephone, String email,String genre) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;
		this.genre = genre;
		this.id=id;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	//GETTERS AND SETTERS
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


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone + ", email=" + email+
				 ", genre=" + genre + ", id=" + id + "]";
	}
	
	
	
	
	
}
