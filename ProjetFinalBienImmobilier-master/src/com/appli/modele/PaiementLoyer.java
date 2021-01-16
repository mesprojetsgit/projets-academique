package com.appli.modele;

public class PaiementLoyer {
	
	
	
	//ATTRIBUTS
	private String periode ;
	private double montantPayer;
	private int id;
	private int idLocataire;
	
	
	//CONSTRUCTEUR
	public PaiementLoyer(int id,int idLocataire,String periode, double montantPayer) {
		super();
		this.periode = periode;
		this.montantPayer = montantPayer;
		this.idLocataire=idLocataire;
		this.id=id;
	}
	
	public PaiementLoyer(int idLocataire,String periode, double montantPayer) {
		super();
		this.idLocataire=idLocataire;
		this.periode = periode;
		this.montantPayer = montantPayer;
		
	}
	
	public PaiementLoyer() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	//GETTERS AND SETTERS
    
	public double getMontantPayer() {
		return montantPayer;
	}
	public String getPeriode() {
		return periode;
	}

	public void setPeriode(String periode) {
		this.periode = periode;
	}

	public void setMontantPayer(double montantPayer) {
		this.montantPayer = montantPayer;
	}

	public int getIdLocataire() {
		return idLocataire;
	}

	public void setIdLocataire(int idLocataire) {
		this.idLocataire = idLocataire;
	}
	
	
	

}
