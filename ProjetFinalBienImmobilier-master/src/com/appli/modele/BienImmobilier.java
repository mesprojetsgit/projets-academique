package com.appli.modele;

public  class BienImmobilier {
	
	
	//ATTRIBUTS
	protected String addresse;
	protected double loyer ;
	protected int nombreDePiece;
	protected String detail;
	protected int id;
	protected String typeLoyer;
	protected String typeBien;
	
	//CONSTRUCTEUR
	public BienImmobilier(int id,String addresse,double loyer, int nombreDePiece, String detail,String typeLoyer, String typeBien) {
		super();
		this.id=id;
		this.addresse = addresse;
		this.loyer = loyer;
		this.nombreDePiece = nombreDePiece;
		this.detail = detail;
		this.typeLoyer = typeLoyer;
		this.typeBien=typeBien;
	}
	
	public BienImmobilier(String addresse,double loyer, int nombreDePiece, String detail,String typeLoyer,String typeBien) {
		super();
		this.addresse = addresse;
		this.loyer = loyer;
		this.nombreDePiece = nombreDePiece;
		this.detail = detail;
		this.typeLoyer = typeLoyer;
		this.typeBien=typeBien;
	}
	
	public BienImmobilier() {}
	
	//	GETTERS AND SETTERS
	public String getAddresse() {
		return addresse;
	}
	public void setAddresse(String adresse) {
		this.addresse = adresse;
	}
	
	public double getLoyer() {
		return loyer;
	}
	public void setLoyer(double loyer) {
		this.loyer = loyer;
	}
	public int getNombreDePiece() {
		return nombreDePiece;
	}
	public void setNombreDePiece(int nnombreDePiece) {
		this.nombreDePiece = nnombreDePiece;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTypeLoyer() {
		return typeLoyer;
	}


	public void setTypeLoyer(String typeLoyer) {
		this.typeLoyer = typeLoyer;
	}

	public String getTypeBien() {
		return typeBien;
	}

	public void setTypeBien(String typeBien) {
		this.typeBien = typeBien;
	}

	@Override
	public String toString() {
		return "BienImmobilier [addresse=" + addresse + ", loyer=" + loyer + ", nnombreDePiece=" + nombreDePiece
				+ ", detail=" + detail + ", id=" + id + ", typeLoyer=" + typeLoyer + ", typeBien=" + typeBien + "]";
	}
	
	
	
	
	 

}
