package com.app.metier.entites;

import java.io.Serializable;

public class ParentEleve extends Personne implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id ;
	
	public ParentEleve() {
		super();
	}

	public ParentEleve(String nom, String prenom,String email,String sexe, String numeroTel,String addresse,String numeroCINB,String numeroMatricule, int id) {
		super(nom, prenom, email, sexe, numeroTel, addresse, numeroCINB);
		this.id = id;
	}
	
	public ParentEleve(String nom, String prenom,String email,String sexe, String numeroTel,String addresse,String numeroCINB,String numeroMatricule) {
		super(nom, prenom, email, sexe, numeroTel, addresse, numeroCINB);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	
}
