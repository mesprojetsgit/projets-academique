package com.appli.dao;

import javax.ws.rs.core.MediaType;

import com.appli.modele.Gestionnaire;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;

public class DaoGestionnaire implements IDao<Gestionnaire> {

	private WebResource webResource;

	public DaoGestionnaire(String uri) {
		Client client = Client.create();
		webResource = client.resource(uri);
	}

	@Override
	public ClientResponse get(Integer id) {
		// TODO Auto-generated method stub
		WebResource webResource = this.webResource.path("/gestionnaire/" + id);
		return get(webResource);
	}

	@Override
	public ClientResponse get() {
		// TODO Auto-generated method stub
		WebResource webResource = this.webResource.path("/gestionnaires");
		return get(webResource);
	}

	@Override
	public ClientResponse delete(Integer id) {
		// TODO Auto-generated method stub
		WebResource webResource = this.webResource.path("/gestionnaire/" + id);		
		Builder builder = getBuilder (webResource);
		
		// Invocation de la méthode DELETE HTTP
		ClientResponse clientResponse = builder.delete(ClientResponse.class);
				
		return clientResponse;
	}

	@Override
	public ClientResponse post(Gestionnaire t) {
		// TODO Auto-generated method stub
		
		// Set params
		WebResource webResource = addQueryParam (t);
		webResource = this.webResource.path("/gestionnaire");
		Builder builder = getBuilder (webResource);
		
		// Invocation de la méthode POST HTTP
		ClientResponse clientResponse = builder.post(ClientResponse.class);
				
		return clientResponse;
	}

	@Override
	public ClientResponse put(Gestionnaire admin) {
		
		WebResource webResource = addQueryParam (admin);
		webResource = this.webResource.path("/gestionnaire/" + String.valueOf(admin.getId()));
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
    
     private WebResource addQueryParam (Gestionnaire admin) {		
		
		// Enrichissement de la requête
		webResource = webResource.queryParam("nom", admin.getNom());
		webResource = webResource.queryParam("prenom",admin.getPrenom() );
		webResource = webResource.queryParam("telephone", admin.getTelephone());
		webResource = webResource.queryParam("email", admin.getEmail());
		webResource = webResource.queryParam("naissance",admin.getNaissance() );
		webResource = webResource.queryParam("genre",admin.getGenre() );
		
		return webResource;
	}
	
	private Builder getBuilder (WebResource webResource) {
		Builder builder = webResource.accept(MediaType.APPLICATION_JSON).header("content-type", MediaType.APPLICATION_JSON); 
		return builder;
	}


}
