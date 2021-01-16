package com.app.metier.entites;

public class Eleve {
	
	private String nom;
	private String prenom;
	private String sexe ;
	private String numeroMatricule;
	private Double tranche1,tranche2,tranche3;
	private String status;
	private String classe;
	private String nomTuteur,prenomTuteur,adresseTuteur,telTuteur;
	private String telEleve,naissance;
	private double scolarite;
	private int id;
	
	public Eleve() {
		super();
	}

	public Eleve(String nom, String prenom, String sexe, String numeroMatricule, Double tranche1, Double tranche2,
			Double tranche3, String status, String classe,String nomTuteur ,String prenomTuteur,String adresseTuteur,
			String telTuteur,String telEleve,String naissance,double scolarite) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.numeroMatricule = numeroMatricule;
		this.tranche1 = tranche1;
		this.tranche2 = tranche2;
		this.tranche3 = tranche3;
		this.status = status;
		this.classe = classe;
		this.nomTuteur=nomTuteur;
		this.prenomTuteur=prenomTuteur;
		this.adresseTuteur=adresseTuteur;
		this.telTuteur=telTuteur;
		this.telEleve=telEleve;
		this.naissance=naissance;
		this.scolarite=scolarite;
	}

	public Eleve(String nom, String prenom, String sexe, String numeroMatricule, Double tranche1, Double tranche2,
			Double tranche3, String status, String classe,String nomTuteur ,String prenomTuteur,
			String adresseTuteur,String telTuteur,String telEleve,String naissance,double scolarite, int id) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.numeroMatricule = numeroMatricule;
		this.tranche1 = tranche1;
		this.tranche2 = tranche2;
		this.tranche3 = tranche3;
		this.status = status;
		this.classe = classe;
		this.nomTuteur=nomTuteur;
		this.prenomTuteur=prenomTuteur;
		this.adresseTuteur=adresseTuteur;
		this.telTuteur=telTuteur;
		this.telEleve=telEleve;
		this.naissance=naissance;
		this.scolarite=scolarite;
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

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getNumeroMatricule() {
		return numeroMatricule;
	}

	public void setNumeroMatricule(String numeroMatricule) {
		this.numeroMatricule = numeroMatricule;
	}

	public Double getTranche1() {
		return tranche1;
	}

	public void setTranche1(Double tanche1) {
		this.tranche1 = tanche1;
	}

	public Double getTranche2() {
		return tranche2;
	}

	public void setTranche2(Double tranche2) {
		this.tranche2 = tranche2;
	}

	public Double getTranche3() {
		return tranche3;
	}

	public void setTranche3(Double tranche3) {
		this.tranche3 = tranche3;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getNomTuteur() {
		return nomTuteur;
	}

	public void setNomTuteur(String nomTuteur) {
		this.nomTuteur = nomTuteur;
	}

	public String getPrenomTuteur() {
		return prenomTuteur;
	}

	public void setPrenomTuteur(String prenomTuteur) {
		this.prenomTuteur = prenomTuteur;
	}

	public String getAdresseTuteur() {
		return adresseTuteur;
	}

	public void setAdresseTuteur(String adresseTuteur) {
		this.adresseTuteur = adresseTuteur;
	}

	public String getTelTuteur() {
		return telTuteur;
	}

	public void setTelTuteur(String telTuteur) {
		this.telTuteur = telTuteur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTelEleve() {
		return telEleve;
	}

	public void setTelEleve(String telEleve) {
		this.telEleve = telEleve;
	}

	public String getNaissance() {
		return naissance;
	}

	public void setNaissance(String naissance) {
		this.naissance = naissance;
	}

	public double getScolarite() {
		return scolarite;
	}

	public void setScolarite(double scolarite) {
		this.scolarite = scolarite;
	}
	
	

}
