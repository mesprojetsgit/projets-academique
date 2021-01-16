package com.app.metier.entites;

public class PaiementScolarite {

	private int numeroPaiement;
	private String nomClasse;
	private String nom;
	private String prenom;
	private String libele;
	private String numeroRecu;
	private String anneeScolarite;
	private String numeroMatricule;
	private String date;
	private Double montantScolarite;
	private Double montantTranche;
	private int numeroTranche;
	private String observation;
	private String modePaiement;
	private int id;
	
	public PaiementScolarite() {
		super();
	}

	public PaiementScolarite(int numeroPaiement, String nomClasse, String nom, String prenom, String libele,
			String numeroRecu, String anneeScolarite, String numeroMatricule, String date, Double montantScolarite,
			Double montantTranche, int numeroTranche, String observation, String modePaiement) {
		super();
		this.numeroPaiement = numeroPaiement;
		this.nomClasse = nomClasse;
		this.nom = nom;
		this.prenom = prenom;
		this.libele = libele;
		this.numeroRecu = numeroRecu;
		this.anneeScolarite = anneeScolarite;
		this.numeroMatricule = numeroMatricule;
		this.date = date;
		this.montantScolarite = montantScolarite;
		this.montantTranche = montantTranche;
		this.numeroTranche = numeroTranche;
		this.observation = observation;
		this.modePaiement = modePaiement;
	}

	public PaiementScolarite(int numeroPaiement, String nomClasse, String nom, String prenom, String libele,
			String numeroRecu, String anneeScolarite, String numeroMatricule, String date, Double montantScolarite,
			Double montantTranche, int numeroTranche, String observation, String modePaiement, int id) {
		super();
		this.numeroPaiement = numeroPaiement;
		this.nomClasse = nomClasse;
		this.nom = nom;
		this.prenom = prenom;
		this.libele = libele;
		this.numeroRecu = numeroRecu;
		this.anneeScolarite = anneeScolarite;
		this.numeroMatricule = numeroMatricule;
		this.date = date;
		this.montantScolarite = montantScolarite;
		this.montantTranche = montantTranche;
		this.numeroTranche = numeroTranche;
		this.observation = observation;
		this.modePaiement = modePaiement;
		this.id = id;
	}

	public int getNumeroPaiement() {
		return numeroPaiement;
	}

	public void setNumeroPaiement(int numeroPaiement) {
		this.numeroPaiement = numeroPaiement;
	}

	public String getNomClasse() {
		return nomClasse;
	}

	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
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

	public String getLibele() {
		return libele;
	}

	public void setLibele(String libele) {
		this.libele = libele;
	}

	public String getNumeroRecu() {
		return numeroRecu;
	}

	public void setNumeroRecu(String numeroRecu) {
		this.numeroRecu = numeroRecu;
	}

	public String getAnneeScolarite() {
		return anneeScolarite;
	}

	public void setAnneeScolarite(String anneeScolarite) {
		this.anneeScolarite = anneeScolarite;
	}

	public String getNumeroMatricule() {
		return numeroMatricule;
	}

	public void setNumeroMatricule(String numeroMatricule) {
		this.numeroMatricule = numeroMatricule;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getMontantScolarite() {
		return montantScolarite;
	}

	public void setMontantScolarite(Double montantScolarite) {
		this.montantScolarite = montantScolarite;
	}

	public Double getMontantTranche() {
		return montantTranche;
	}

	public void setMontantTranche(Double montantTranche) {
		this.montantTranche = montantTranche;
	}

	public int getNumeroTranche() {
		return numeroTranche;
	}

	public void setNumeroTranche(int numeroTranche) {
		this.numeroTranche = numeroTranche;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getModePaiement() {
		return modePaiement;
	}

	public void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
}
