package com.app.metier.entites;

public class Versement {

	
	private int id ;
	private String date ;
	private Double montant;
	private String numeroCompte;
	private Double SoldeCompte;
	
	public Versement() {
		super();
	}

	public Versement(String date, Double montant, String numeroCompte, Double soldeCompte) {
		super();
		this.date = date;
		this.montant = montant;
		this.numeroCompte = numeroCompte;
		SoldeCompte = soldeCompte;
	}

	public Versement(int id, String date, Double montant, String numeroCompte, Double soldeCompte) {
		super();
		this.id = id;
		this.date = date;
		this.montant = montant;
		this.numeroCompte = numeroCompte;
		SoldeCompte = soldeCompte;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public String getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public Double getSoldeCompte() {
		return SoldeCompte;
	}

	public void setSoldeCompte(Double soldeCompte) {
		SoldeCompte = soldeCompte;
	}
	
	
	
	
	
}
