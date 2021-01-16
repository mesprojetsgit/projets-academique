package com.appli.modele;

public abstract class Location {

	
	//ATTRIBUTS
	protected double coutLocation;
	protected String typeLocation;
	protected int id;
	
	
	//CONSTRUCTEUR
	public Location(int id,double coutLocation,String typeLocation) {
		super();
		this.coutLocation = coutLocation;
		this.typeLocation = typeLocation;
		this.id=id;
	}
	
	public Location(double coutLocation,String typeLocation) {
		super();
		this.coutLocation = coutLocation;
		this.typeLocation = typeLocation;
	}
	
	
	//GETTERS AND SETTERS
	public double getCoutLocation() {
		return coutLocation;
	}
	public void setCoutLocation(double coutLocation) {
		this.coutLocation = coutLocation;
	}
	public String getTypeLocation() {
		return typeLocation;
	}
	public void setTypeLocation(String typeLocation) {
		this.typeLocation = typeLocation;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

}
