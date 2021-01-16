package com.app.metier.entites;

public class PaiementEmployer {
	
	//"Id", "Montant", "Date", "Poste", "Nom", "Prenom", "Mode de paiement"
	
	private int id;
	private double montant;
	private String date;
	private String mois;
	private String poste;
	private String nom;
	private String prenom;
	private String modeDePaiement;
	
	public PaiementEmployer() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	public PaiementEmployer(double montant, String date, String mois,String poste, String nom, String prenom,
			String modeDePaiement) {
		super();
		this.montant = montant;
		this.date = date;
		this.mois  = mois;
		this.poste = poste;
		this.nom = nom;
		this.prenom = prenom;
		this.modeDePaiement = modeDePaiement;
	}

	public PaiementEmployer(double montant, String date, String mois,String poste, String nom, String prenom,
			String modeDePaiement,int id) {
		super();
		this.id = id;
		this.montant = montant;
		this.date = date;
		this.mois  = mois;
		this.poste = poste;
		this.nom = nom;
		this.prenom = prenom;
		this.modeDePaiement = modeDePaiement;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getMois() {
		return mois;
	}

	public void setMois(String mois) {
		this.mois = mois;
	}

	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getModeDePaiement() {
		return modeDePaiement;
	}
	public void setModeDePaiement(String modeDePaiement) {
		this.modeDePaiement = modeDePaiement;
	}

}
