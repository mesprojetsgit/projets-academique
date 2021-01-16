package com.appli.modele;

public class Studio extends BienImmobilier {

	public Studio(int id,String adresse,double loyer, int nnombreDePiece, String detail,String typeLoyer,String typeBien) {
		super(id,adresse,loyer, nnombreDePiece, detail,typeLoyer,typeBien);
	}

	
	public Studio(String adresse,double loyer, int nnombreDePiece, String detail,String typeLoyer,String typeBien) {
		super(adresse,loyer, nnombreDePiece, detail,typeLoyer,typeBien);
	}
}
