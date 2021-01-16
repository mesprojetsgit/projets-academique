package com.appli.modele;

public class LocationLongTerme extends Location {
	//ATTRIBUTS
		private double caution ;
	    private int nbrMoisCaution;
		//CONSTRUCTEUR
		public LocationLongTerme(int id,double coutLocation, String typeLocation, double caution) {
			super(id,coutLocation, typeLocation);
			
			this.caution = caution;
		}
		
		public LocationLongTerme(double coutLocation, String typeLocation, double caution) {
			super(coutLocation, typeLocation);
			
			this.caution = caution;
		}
		
		public double getCaution() {
			return caution;
		}
		public void setCaution(double caution) {
			this.caution = caution;
		}
		public int getNbrMoisCaution() {
			return nbrMoisCaution;
		}
		public void setNbrMoisCaution(int nbrMoisCaution) {
			this.nbrMoisCaution = nbrMoisCaution;
		}

		
		
		//GETTERS AND SETTERS
	
		
	

}
