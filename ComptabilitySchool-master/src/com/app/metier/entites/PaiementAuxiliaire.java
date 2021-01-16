package com.app.metier.entites;

public class PaiementAuxiliaire {
	
	private String matricule;
	private String nom;
	private String prenom;
	private String classe;
	private String status;
	private Double montant;
	private String description;
	private String commentaire;
	private int id ;
	
	public PaiementAuxiliaire() {
		super();
	}

	public PaiementAuxiliaire(String matricule, String nom, String prenom, String classe, String status, Double montant,
			String description, String commentaire) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.classe = classe;
		this.status = status;
		this.montant = montant;
		this.description = description;
		this.commentaire = commentaire;
	}

	public PaiementAuxiliaire(String matricule, String nom, String prenom, String classe, String status, Double montant,
			String description, String commentaire, int id) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.classe = classe;
		this.status = status;
		this.montant = montant;
		this.description = description;
		this.commentaire = commentaire;
		this.id = id;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
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

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
