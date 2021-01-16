package com.app.metier.entites;

import java.io.Serializable;

public class Poste implements Serializable {

	private static final long serialVersionUID = 1L;
    private String nom;
    private String description;
    private Long id_personnel;
    private Long id;
    
	public Poste() {
		super();
	}

	public Poste(String nom, String description, Long id_personnel) {
		super();
		this.nom = nom;
		this.description = description;
		this.id_personnel = id_personnel;
	}

	public Poste(String nom, String description, Long id_personnel, Long id) {
		super();
		this.nom = nom;
		this.description = description;
		this.id_personnel = id_personnel;
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId_personnel() {
		return id_personnel;
	}

	public void setId_personnel(Long id_personnel) {
		this.id_personnel = id_personnel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	    
}
