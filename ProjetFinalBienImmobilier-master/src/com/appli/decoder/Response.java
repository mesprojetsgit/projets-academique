package com.appli.decoder;

import java.util.List;

import com.appli.modele.Administrateur;
import com.appli.modele.Authentification;
import com.appli.modele.BienImmobilier;
import com.appli.modele.Gestionnaire;
import com.appli.modele.Locataire;
import com.appli.modele.LocationCourtTerme;
import com.appli.modele.LocationLongTerme;
import com.appli.modele.PaiementLoyer;


public class Response {
	
	private String code;
	private String status;
	private String message;
	private Administrateur administrateur;
	private List<Administrateur> administrateurs;
	
	private Gestionnaire gestionnaire;
	private List<Gestionnaire> gestionnaires;
	
	private Authentification authentification;
	private List<Authentification> authentifications;
	
	private BienImmobilier bienImmobilier;
	private List<BienImmobilier> bienImmobiliers;
	
	private Locataire locataire;
	private List<Locataire> locataires;
	
	private PaiementLoyer paiementLoyer;
	private List<PaiementLoyer> paiementLoyers;
	
	private LocationLongTerme locationLongTerme;
	private List<LocationLongTerme> locationLongTermes;
	
	private LocationCourtTerme locationCourtTerme;
	private List<LocationCourtTerme> locationCourtTermes;
	
	
	public Response() {}
	
	
	public Response(String code, String message, Administrateur administrateur, List<Administrateur> administrateurs,Gestionnaire gestionaire,List<Gestionnaire> gestionaires,Authentification authentificattion,List<Authentification> authentificattions,
			BienImmobilier bienImmobilier,List<BienImmobilier> bienImmobiliers,Locataire locataire, List<Locataire> locataires,PaiementLoyer paiementLoyer,List<PaiementLoyer> paiementLoyers,LocationLongTerme locationLongTerme,
			List<LocationLongTerme> locationLongTermes,LocationCourtTerme locationCourtTerme,List<LocationCourtTerme> locationCourtTermes) {
		this.code = code;
		this.message = message;
		this.administrateur = administrateur;
		this.administrateurs = administrateurs;
		this.gestionnaire = gestionaire;
		this.gestionnaires = gestionaires;
		this.authentification = authentificattion;
		this.authentifications = authentificattions;
		this.bienImmobilier = bienImmobilier;
		this.bienImmobiliers = bienImmobiliers;
		this.locataire = locataire;
		this.locataires = locataires;
		this.paiementLoyer = paiementLoyer;
		this.paiementLoyers = paiementLoyers;
		this.locationLongTerme = locationLongTerme;
		this.locationLongTermes = locationLongTermes;
		this.locationCourtTerme = locationCourtTerme;
	}
	

	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}


	public Administrateur getAdministrateur() {
		return administrateur;
	}


	public void setAdministrateur(Administrateur administrateur) {
		this.administrateur = administrateur;
	}


	public List<Administrateur> getAdministrateurs() {
		return administrateurs;
	}


	public void setAdministrateurs(List<Administrateur> administrateurs) {
		this.administrateurs = administrateurs;
	}


	public Gestionnaire getGestionnaire() {
		return gestionnaire;
	}


	public void setGestionnaire(Gestionnaire gestionnaire) {
		this.gestionnaire = gestionnaire;
	}


	public List<Gestionnaire> getGestionnaires() {
		return gestionnaires;
	}


	public void setGestionnaires(List<Gestionnaire> gestionnaires) {
		this.gestionnaires = gestionnaires;
	}


	public Authentification getAuthentification() {
		return authentification;
	}


	public void setAuthentification(Authentification authentification) {
		this.authentification = authentification;
	}


	public List<Authentification> getAuthentifications() {
		return authentifications;
	}


	public void setAuthentifications(List<Authentification> authentifications) {
		this.authentifications = authentifications;
	}


	public BienImmobilier getBienImmobilier() {
		return bienImmobilier;
	}


	public void setBienImmobilier(BienImmobilier bienImmobilier) {
		this.bienImmobilier = bienImmobilier;
	}


	public List<BienImmobilier> getBienImmobiliers() {
		return bienImmobiliers;
	}


	public void setBienImmobiliers(List<BienImmobilier> bienImmobiliers) {
		this.bienImmobiliers = bienImmobiliers;
	}


	public Locataire getLocataire() {
		return locataire;
	}


	public void setLocataire(Locataire locataire) {
		this.locataire = locataire;
	}


	public List<Locataire> getLocataires() {
		return locataires;
	}


	public void setLocataires(List<Locataire> locataires) {
		this.locataires = locataires;
	}


	public PaiementLoyer getPaiementLoyer() {
		return paiementLoyer;
	}


	public void setPaiementLoyer(PaiementLoyer paiementLoyer) {
		this.paiementLoyer = paiementLoyer;
	}


	public List<PaiementLoyer> getPaiementLoyers() {
		return paiementLoyers;
	}


	public void setPaiementLoyers(List<PaiementLoyer> paiementLoyers) {
		this.paiementLoyers = paiementLoyers;
	}


	public LocationLongTerme getLocationLongTerme() {
		return locationLongTerme;
	}


	public void setLocationLongTerme(LocationLongTerme locationLongTerme) {
		this.locationLongTerme = locationLongTerme;
	}


	public List<LocationLongTerme> getLocationLongTermes() {
		return locationLongTermes;
	}


	public void setLocationLongTermes(List<LocationLongTerme> locationLongTermes) {
		this.locationLongTermes = locationLongTermes;
	}


	public LocationCourtTerme getLocationCourtTerme() {
		return locationCourtTerme;
	}


	public void setLocationCourtTerme(LocationCourtTerme locationCourtTerme) {
		this.locationCourtTerme = locationCourtTerme;
	}


	public List<LocationCourtTerme> getLocationCourtTermes() {
		return locationCourtTermes;
	}


	public void setLocationCourtTermes(List<LocationCourtTerme> locationCourtTermes) {
		this.locationCourtTermes = locationCourtTermes;
	}


	public List<BienImmobilier> getBienImmobiliersAloues() {
		// TODO Auto-generated method stub
		return bienImmobiliers;
	}


	public List<BienImmobilier> getBienImmobiliersDesactives() {
		// TODO Auto-generated method stub
		return bienImmobiliers;
	}


	

	
}
