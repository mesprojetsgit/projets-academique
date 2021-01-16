package com.app.metier.entites;

import java.io.Serializable;

public class Paiement implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String date;
	private String mois ;
	private String modePaiement;
	private Double montant ;
	private int id_employer;
	private int id;
	
	public Paiement() {
		super();
	}

	public Paiement(String date, String mois, String modePaiement, Double montant, int id_employer) {
		super();
		this.date = date;
		this.mois = mois;
		this.modePaiement = modePaiement;
		this.montant = montant;
		this.id_employer = id_employer;
	}

	public Paiement(String date, String mois, String modePaiement, Double montant, int id_employer, int id) {
		super();
		this.date = date;
		this.mois = mois;
		this.modePaiement = modePaiement;
		this.montant = montant;
		this.id_employer = id_employer;
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMois() {
		return mois;
	}

	public void setMois(String mois) {
		this.mois = mois;
	}

	public String getModePaiement() {
		return modePaiement;
	}

	public void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public int getId_employer() {
		return id_employer;
	}

	public void setId_employer(int id_employer) {
		this.id_employer = id_employer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

}
