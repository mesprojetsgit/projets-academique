package com.app.metier.entites;

public class Personnel extends Employer{


	private Double salaire;
	private int id;
	private String poste;
	
	public Personnel() {
		super();
	}

	public Personnel(String nom, String prenom, String email, String genre, String numeroTel, String addresse,
			 String numeroCINB, String dateRecrutement, String dateArret, Double salaire,String poste) {
		super(nom, prenom, email, genre, numeroTel, addresse, numeroCINB, dateRecrutement,
				dateArret);
		this.salaire = salaire;
		this.poste=poste;
		// TODO Auto-generated constructor stub
	}
	
	public Personnel(String nom, String prenom, String email, String genre, String numeroTel, String addresse,
			 String numeroCINB, String dateRecrutement, String dateArret, Double salaire,String poste,int id) {
		super(nom, prenom, email, genre, numeroTel, addresse, numeroCINB, dateRecrutement,
				dateArret);
		this.salaire = salaire;
		this.poste=poste;
		this.id = id;
		// TODO Auto-generated constructor stub
	}

	

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public Double getSalaire() {
		return salaire;
	}

	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
    
}
