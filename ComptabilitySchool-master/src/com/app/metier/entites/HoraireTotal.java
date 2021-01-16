package com.app.metier.entites;

import java.io.Serializable;

public class HoraireTotal implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long nombreHoraire;
	private String periodeHoraire;
	private Long id ;
	private Long id_matiere ;
	
	public HoraireTotal() {
		super();
	}

	public HoraireTotal(Long nombreHoraire, String periodeHoraire, Long id_matiere) {
		super();
		this.nombreHoraire = nombreHoraire;
		this.periodeHoraire = periodeHoraire;
		this.id_matiere = id_matiere;
	}

	public HoraireTotal(Long nombreHoraire, String periodeHoraire, Long id, Long id_matiere) {
		super();
		this.nombreHoraire = nombreHoraire;
		this.periodeHoraire = periodeHoraire;
		this.id = id;
		this.id_matiere = id_matiere;
	}

	public Long getNombreHoraire() {
		return nombreHoraire;
	}

	public void setNombreHoraire(Long nombreHoraire) {
		this.nombreHoraire = nombreHoraire;
	}

	public String getPeriodeHoraire() {
		return periodeHoraire;
	}

	public void setPeriodeHoraire(String periodeHoraire) {
		this.periodeHoraire = periodeHoraire;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_matiere() {
		return id_matiere;
	}

	public void setId_matiere(Long id_matiere) {
		this.id_matiere = id_matiere;
	}

	
}
