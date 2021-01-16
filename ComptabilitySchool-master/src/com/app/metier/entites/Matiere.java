package com.app.metier.entites;

import java.io.Serializable;

public class Matiere implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nom;
	private Double prixHoraire;
	private int id_professeur;
	private int id_classe;
	private int id;
	
	public Matiere() {
		super();
	}

	public Matiere(String nom, Double prixHoraire, int id_professeur, int id_classe) {
		super();
		this.nom = nom;
		this.prixHoraire = prixHoraire;
		this.id_professeur = id_professeur;
		this.id_classe = id_classe;
	}

	public Matiere(String nom, Double prixHoraire, int id_professeur, int id_classe, int id) {
		super();
		this.nom = nom;
		this.prixHoraire = prixHoraire;
		this.id_professeur = id_professeur;
		this.id_classe = id_classe;
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Double getPrixHoraire() {
		return prixHoraire;
	}

	public void setPrixHoraire(Double prixHoraire) {
		this.prixHoraire = prixHoraire;
	}

	public int getId_professeur() {
		return id_professeur;
	}

	public void setId_professeur(int id_professeur) {
		this.id_professeur = id_professeur;
	}

	public int getId_classe() {
		return id_classe;
	}

	public void setId_classe(int id_classe) {
		this.id_classe = id_classe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
