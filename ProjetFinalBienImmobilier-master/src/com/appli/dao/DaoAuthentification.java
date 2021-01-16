package com.appli.dao;

import javax.ws.rs.core.MediaType;

import com.appli.modele.Authentification;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;

public class DaoAuthentification implements IDao<Authentification> {
	private WebResource webResource;

	public DaoAuthentification(String uri) {
		Client client = Client.create();
		webResource = client.resource(uri);
	}
	@Override
	public ClientResponse get(Integer id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		WebResource webResource = this.webResource.path("/authentification/" + id);
	    return get(webResource);
	}

	@Override
	public ClientResponse get() {
		// TODO Auto-generated method stub
		WebResource webResource = this.webResource.path("/authentifications");
		return get(webResource);
	}

	@Override
	public ClientResponse delete(Integer id) {
		// TODO Auto-generated method stub
		WebResource webResource = this.webResource.path("/authentification/" + id);		
		Builder builder = getBuilder (webResource);
		
		// Invocation de la méthode DELETE HTTP
		ClientResponse clientResponse = builder.delete(ClientResponse.class);
				
		return clientResponse;
	}

	@Override
	public ClientResponse post(Authentification t) {
		// TODO Auto-generated method stub
		WebResource webResource = addQueryParam (t);
		webResource = this.webResource.path("/authentification");
		Builder builder = getBuilder (webResource);
		
		// Invocation de la méthode POST HTTP
		ClientResponse clientResponse = builder.post(ClientResponse.class);
				
		return clientResponse;
	}

	@Override
	public ClientResponse put(Authentification t) {
		// TODO Auto-generated method stub
		WebResource webResource = addQueryParam (t);
		webResource = this.webResource.path("/authentification/" + String.valueOf(t.getId()));
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
    
     private WebResource addQueryParam (Authentification auth) {		
		
		// Enrichissement de la requête
    	webResource = webResource.queryParam("id", ""+auth.getId());
		webResource = webResource.queryParam("login", auth.getLogin());
		webResource = webResource.queryParam("password",auth.getPassword());
		webResource = webResource.queryParam("status", ""+auth.getStatus());

		return webResource;
	}
	
	private Builder getBuilder (WebResource webResource) {
		Builder builder = webResource.accept(MediaType.APPLICATION_JSON).header("content-type", MediaType.APPLICATION_JSON); 
		return builder;
	}

}
