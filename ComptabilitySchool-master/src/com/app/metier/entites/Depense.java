package com.app.metier.entites;

import java.io.Serializable;

public class Depense implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Double montant;
	private String date;
	private String modePaiement;
	private String anneeScolaire;
	private String motif;
	private int id;
	
	public Depense() {
		super();
	}

	public Depense(Double montant, String date, String modePaiement, String anneeScolaire, String motif) {
		super();
		this.montant = montant;
		this.date = date;
		this.modePaiement = modePaiement;
		this.anneeScolaire = anneeScolaire;
		this.motif = motif;
	}

	public Depense(Double montant, String date, String modePaiement, String anneeScolaire, String motif, int id) {
		super();
		this.montant = montant;
		this.date = date;
		this.modePaiement = modePaiement;
		this.anneeScolaire = anneeScolaire;
		this.motif = motif;
		this.id = id;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getModePaiement() {
		return modePaiement;
	}

	public void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
	}

	public String getAnneeScolaire() {
		return anneeScolaire;
	}

	public void setAnneeScolaire(String anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
	
	
}
