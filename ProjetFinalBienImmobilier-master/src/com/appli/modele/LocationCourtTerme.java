package com.appli.modele;

public class LocationCourtTerme extends Location {
	
	
	//ATTRIBUTS
	private int nombreDeJour;
	
	
	
	//CONSTRUCTEUR
	public LocationCourtTerme(int id,double coutLocation,String typeLocation,int nombreDeJour) {
		super(id,coutLocation, typeLocation);
		this.nombreDeJour= nombreDeJour;
		
	}

	public LocationCourtTerme(double coutLocation,String typeLocation,int nombreDeJour) {
		super(coutLocation, typeLocation);
		this.nombreDeJour= nombreDeJour;
		
	}

	public int getNombreDeJour() {
		return nombreDeJour;
	}



	public void setNombreDeJour(int nombreDeJour) {
		this.nombreDeJour = nombreDeJour;
	}
	
	
	//GETTERS AND SETTERS

	

}
