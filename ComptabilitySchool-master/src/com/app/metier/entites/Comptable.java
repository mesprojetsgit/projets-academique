package com.app.metier.entites;

import java.io.Serializable;

public class Comptable extends Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	 
	public Comptable() {
		super();
		
	}

	public Comptable(String nom, String prenom, String email, String sexe, String numeroTel, String addresse,
			 String numeroCINB ,String login,
			String password, int id) {
		super(nom, prenom, email, sexe, numeroTel, addresse, numeroCINB, 
				login, password);
		this.id = id;
	}



	public Comptable(String nom, String prenom, String email, String sexe, String numeroTel, String addresse,
			 String numeroCINB, String login,
			String password) {
		super(nom, prenom, email, sexe, numeroTel, addresse, numeroCINB, 
				login, password);
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	

}
