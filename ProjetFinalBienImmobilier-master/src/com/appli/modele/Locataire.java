package com.appli.modele;

public class Locataire extends Personne {
	
	//ATTRIBUTS
	private String numeroPieceId ;
	private String dateDebutContrat ;
	private String dateFinContrat ;
	private String status ;
	
	//CONSTRUCTEUR
	
	public Locataire() {}
	
	
	public Locataire(int id,String nom, String prenom, String telephone, String email, String genre,String numeroPieceId,
			String dateDebutContrat,String dateFinContrat, String status  ) {
		super(id,nom, prenom, telephone, email, genre);
		 
		this.numeroPieceId = numeroPieceId ;
		this.dateFinContrat = dateFinContrat;
		this.dateDebutContrat = dateDebutContrat;
		this.status  = status;
	}

	public Locataire(String nom, String prenom, String telephone, String email, String genre,String numeroPieceId,
			String dateDebutContrat ,String dateFinContrat, String status) {
		super(nom, prenom, telephone, email, genre);
		 
		this.numeroPieceId = numeroPieceId ;
		this.dateFinContrat = dateFinContrat;
		this.dateDebutContrat = dateDebutContrat;
		this.status  = status;
	}
	
	
	//GETTERS AND SETTERS
	public String getNumeroPieceId() {
		return numeroPieceId;
	}

	public void setNumeroPieceId(String numeroPieceId) {
		this.numeroPieceId = numeroPieceId;
	}

	public String getDateDebutContrat() {
		return dateDebutContrat;
	}

	public void setDateDebutContrat(String dateDebutContrat) {
		this.dateDebutContrat = dateDebutContrat;
	}

	public String getDateFinContrat() {
		return dateFinContrat;
	}

	public void setDateFinContrat(String dateFinContrat) {
		this.dateFinContrat = dateFinContrat;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		super.toString();
		return "Locataire [numeroPieceId=" + numeroPieceId + ", dateDebutContrat=" + dateDebutContrat
				+ ", dateFinContrat=" + dateFinContrat + ", status=" + status + "]";
	}


	

}
