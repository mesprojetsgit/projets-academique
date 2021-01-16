package com.app.metier.entites;

import java.io.Serializable;

public class RecuScolarite implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private String nomEleve;
	private int id_paiementScolarite;
	private int id_eleve;
	private int id;
	
	public RecuScolarite() {
		super();
	}

	public RecuScolarite(String nomEleve, int id_paiementScolarite, int id_eleve) {
		super();
		this.nomEleve = nomEleve;
		this.id_paiementScolarite = id_paiementScolarite;
		this.id_eleve = id_eleve;
	}

	public RecuScolarite(String nomEleve, int id_paiementScolarite, int id_eleve, int id) {
		super();
		this.nomEleve = nomEleve;
		this.id_paiementScolarite = id_paiementScolarite;
		this.id_eleve = id_eleve;
		this.id = id;
	}

	public String getNomEleve() {
		return nomEleve;
	}

	public void setNomEleve(String nomEleve) {
		this.nomEleve = nomEleve;
	}

	public int getId_paiementScolarite() {
		return id_paiementScolarite;
	}

	public void setId_paiementScolarite(int id_paiementScolarite) {
		this.id_paiementScolarite = id_paiementScolarite;
	}

	public int getId_eleve() {
		return id_eleve;
	}

	public void setId_eleve(int id_eleve) {
		this.id_eleve = id_eleve;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	

}
