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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.ClientResponse;

public class ResponseDecoder {
	private Response response;
	private ObjectMapper decoder;
	
	public void setClientResponse (ClientResponse clientResponse) throws JsonMappingException, JsonProcessingException {
		String json = clientResponse.getEntity(String.class);
		response = decoder.readValue(json, Response.class);
	}
	
	public ResponseDecoder(ClientResponse clientResponse) throws JsonMappingException, JsonProcessingException {
		decoder = new ObjectMapper();
		setClientResponse (clientResponse);
	}
	
//administrateur
	public Administrateur getAdministrateur() {
		return response.getAdministrateur();
	}

	public List<Administrateur> getAdministrateurs() {
		return response.getAdministrateurs();
	}


	//gestionnaire
	public Gestionnaire getGestionnaire() {
		return response.getGestionnaire();
	}


	public List<Gestionnaire> getGestionnaires() {
		return response.getGestionnaires();
	}




//authentification
	public Authentification getAuthentificattion() {
		return response.getAuthentification();
	}

	public List<Authentification> getAuthentifications() {
		return response.getAuthentifications();
	}

	
	//bien immobilier

	public BienImmobilier getBienImmobilier() {
		return response.getBienImmobilier();
	}


	public List<BienImmobilier> getBienImmobiliers() {
		return response.getBienImmobiliers();
	}


	public List<BienImmobilier> getBienImmobiliersDesactives() {
		return response.getBienImmobiliersDesactives();
	}

	public List<BienImmobilier> getBienImmobiliersAloues() {
		return response.getBienImmobiliersAloues();
	}

	//locataire
	public Locataire getLocataire() {
		return response.getLocataire();
	}


	public List<Locataire> getLocataires() {
		return response.getLocataires();
	}


    //payer loyer
	public PaiementLoyer getPaiementLoyer() {
		return response.getPaiementLoyer();
	}


	public List<PaiementLoyer> getPaiementLoyers() {
		return response.getPaiementLoyers();
	}

    
	//location long terme
	public LocationLongTerme getLocationLongTerme() {
		return response.getLocationLongTerme();
	}



	public List<LocationLongTerme> getLocationLongTermes() {
		return response.getLocationLongTermes();
	}


	//location court terme

	public LocationCourtTerme getLocationCourtTerme() {
		return response.getLocationCourtTerme();
	}
	public  List<LocationCourtTerme> getLocationCourtTermes() {
		return response.getLocationCourtTermes();
	}
	
	//message de retour
	
	public String getMessage () {
		return response.getMessage();
	}
	
	//le code d'action sur le api
	public Integer getCode () {
		return Integer.valueOf(response.getCode());
	}
	
	//le status du l action sur le api
	public String getStatus () {
		return response.getStatus();
	}
}
