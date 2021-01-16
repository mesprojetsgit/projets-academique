package com.appli.modele;

public class Administrateur extends Personne {

	
	private String  naissance;
	public Administrateur(int id, String nom, String prenom, String telephone, String email, String naissance, String genre) {
		super(id,nom,prenom,telephone,email,genre);
		// TODO Auto-generated constructor stub
		this.naissance=naissance;
	}
	
	public Administrateur( String nom, String prenom, String telephone, String email, String naissance, String genre) {
		super(nom,prenom,telephone,email,genre);
		// TODO Auto-generated constructor stub
		this.naissance=naissance;
	}

	public Administrateur() {
		
	}
	
	public String getNaissance() {
		return naissance;
	}


	public void setNaissance(String naissance) {
		this.naissance = naissance;
	}

}
