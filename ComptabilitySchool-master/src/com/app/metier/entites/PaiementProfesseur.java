package com.app.metier.entites;

public class PaiementProfesseur {
	
	private String nom;
	private String prenom;
	private String nomClasse;
	private String nomMatiere;
	private String type;
	private Double salaire;
	private int nombreHeure;
	private Double prixParHeure;
	private Double montantTotal;
	private String mois;
	private String modePaiement;
	private String dateDePaiement;
	private String matricule;
	private int id;
	
	public PaiementProfesseur() {
		super();
	}

	public PaiementProfesseur(String nom, String prenom, String nomClasse, String nomMatiere, String type,
			Double salaire, int nombreHeure, Double prixParHeure, Double montantTotal, String mois, String modePaiement,
			String dateDePaiement, String matricule) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.nomClasse = nomClasse;
		this.nomMatiere = nomMatiere;
		this.type = type;
		this.salaire = salaire;
		this.nombreHeure = nombreHeure;
		this.prixParHeure = prixParHeure;
		this.montantTotal = montantTotal;
		this.mois = mois;
		this.modePaiement = modePaiement;
		this.dateDePaiement = dateDePaiement;
		this.matricule = matricule;
	}

	public PaiementProfesseur(String nom, String prenom, String nomClasse, String nomMatiere, String type,
			Double salaire, int nombreHeure, Double prixParHeure, Double montantTotal, String mois, String modePaiement,
			String dateDePaiement, String matricule, int id) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.nomClasse = nomClasse;
		this.nomMatiere = nomMatiere;
		this.type = type;
		this.salaire = salaire;
		this.nombreHeure = nombreHeure;
		this.prixParHeure = prixParHeure;
		this.montantTotal = montantTotal;
		this.mois = mois;
		this.modePaiement = modePaiement;
		this.dateDePaiement = dateDePaiement;
		this.matricule = matricule;
		this.id = id;
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

	public String getNomClasse() {
		return nomClasse;
	}

	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}

	public String getNomMatiere() {
		return nomMatiere;
	}

	public void setNomMatiere(String nomMatiere) {
		this.nomMatiere = nomMatiere;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getSalaire() {
		return salaire;
	}

	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}

	public int getNombreHeure() {
		return nombreHeure;
	}

	public void setNombreHeure(int nombreHeure) {
		this.nombreHeure = nombreHeure;
	}

	public Double getPrixParHeure() {
		return prixParHeure;
	}

	public void setPrixParHeure(Double prixParHeure) {
		this.prixParHeure = prixParHeure;
	}

	public Double getMontantTotal() {
		return montantTotal;
	}

	public void setMontantTotal(Double montantTotal) {
		this.montantTotal = montantTotal;
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

	public String getDateDePaiement() {
		return dateDePaiement;
	}

	public void setDateDePaiement(String dateDePaiement) {
		this.dateDePaiement = dateDePaiement;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
