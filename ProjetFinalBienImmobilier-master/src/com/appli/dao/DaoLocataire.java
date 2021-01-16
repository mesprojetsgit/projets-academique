package com.appli.dao;

import javax.ws.rs.core.MediaType;

import com.appli.modele.Locataire;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;

public class DaoLocataire implements IDao<Locataire> {

	private WebResource webResource;

	public DaoLocataire(String uri) {
		Client client = Client.create();
		webResource = client.resource(uri);
	}

	@Override
	public ClientResponse get(Integer id) {
		// TODO Auto-generated method stub
		WebResource webResource = this.webResource.path("/locataire/" + id);
		return get(webResource);
	}

	@Override
	public ClientResponse get() {
		// TODO Auto-generated method stub
		WebResource webResource = this.webResource.path("/locataires");
		return get(webResource);
	}

	@Override
	public ClientResponse delete(Integer id) {
		// TODO Auto-generated method stub
		WebResource webResource = this.webResource.path("/locataire/" + id);		
		Builder builder = getBuilder (webResource);
		
		// Invocation de la méthode DELETE HTTP
		ClientResponse clientResponse = builder.delete(ClientResponse.class);
				
		return clientResponse;
	}

	@Override
	public ClientResponse post(Locataire t) {
		// TODO Auto-generated method stub
		
		// Set params
		WebResource webResource = addQueryParam (t);
		webResource = this.webResource.path("/locataire");
		Builder builder = getBuilder (webResource);
		
		// Invocation de la méthode POST HTTP
		ClientResponse clientResponse = builder.post(ClientResponse.class);
				
		return clientResponse;
	}

	@Override
	public ClientResponse put(Locataire location) {
		
		WebResource webResource = addQueryParam (location);
		webResource = this.webResource.path("/locataire/" + String.valueOf(location.getId()));
		Builder builder = getBuilder (webResource);
		
		// Invocation de la méthode POST HTTP
		ClientResponse clientResponse = builder.put(ClientResponse.class);
				
		return clientResponse;
	}
	
	private ClientResponse get (WebResource webResource) {
		
		Builder builder = getBuilder (webResource);

		// Invocation de la méthode GET HTTP
		ClientResponse clientResponse = builder.get(ClientResponse.class);

		return clientResponse;
	}
    
     private WebResource addQueryParam (Locataire location) {		
		
		// Enrichissement de la requête
    	webResource = webResource.queryParam("id",""+location.getId());
		webResource = webResource.queryParam("nom", location.getNom());
		webResource = webResource.queryParam("prenom",location.getPrenom() );
		webResource = webResource.queryParam("telephone", location.getTelephone());
		webResource = webResource.queryParam("email", location.getEmail());
		webResource = webResource.queryParam("genre",location.getGenre());
		webResource = webResource.queryParam("numeroPieceId",location.getNumeroPieceId());
		webResource = webResource.queryParam("dateDebutContrat",location.getDateDebutContrat());
		webResource = webResource.queryParam("dateFinContrat",location.getDateFinContrat());
		webResource = webResource.queryParam("status",location.getStatus());
		return webResource;
	}
	
	private Builder getBuilder (WebResource webResource) {
		Builder builder = webResource.accept(MediaType.APPLICATION_JSON).header("content-type", MediaType.APPLICATION_JSON); 
		return builder;
	}


}
