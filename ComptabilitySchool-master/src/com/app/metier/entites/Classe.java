package com.app.metier.entites;

import java.io.Serializable;

public class Classe implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nom;
	private String anneeScolaire;
	private int id_matiere ;
	private int id;
	
	public Classe() {
		super();
	}

	public Classe(String nom, String anneeScolaire, int id_matiere, int id) {
		super();
		this.nom = nom;
		this.anneeScolaire = anneeScolaire;
		this.id_matiere = id_matiere;
		this.id = id;
	}

	public Classe(String nom, String anneeScolaire, int id_matiere) {
		super();
		this.nom = nom;
		this.anneeScolaire = anneeScolaire;
		this.id_matiere = id_matiere;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAnneeScolaire() {
		return anneeScolaire;
	}

	public void setAnneeScolaire(String anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}

	public int getId_matiere() {
		return id_matiere;
	}

	public void setId_matiere(int id_matiere) {
		this.id_matiere = id_matiere;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

		

}
