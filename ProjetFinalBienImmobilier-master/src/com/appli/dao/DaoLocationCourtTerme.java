package com.appli.dao;

import javax.ws.rs.core.MediaType;

import com.appli.modele.LocationCourtTerme;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;

public class DaoLocationCourtTerme implements IDao<LocationCourtTerme> {

	private WebResource webResource;

	public DaoLocationCourtTerme(String uri) {
		Client client = Client.create();
		webResource = client.resource(uri);
	}

	@Override
	public ClientResponse get(Integer id) {
		// TODO Auto-generated method stub
		WebResource webResource = this.webResource.path("/location/" + id);
		return get(webResource);
	}

	@Override
	public ClientResponse get() {
		// TODO Auto-generated method stub
		WebResource webResource = this.webResource.path("/locations");
		return get(webResource);
	}

	@Override
	public ClientResponse delete(Integer id) {
		// TODO Auto-generated method stub
		WebResource webResource = this.webResource.path("/location/" + id);		
		Builder builder = getBuilder (webResource);
		
		// Invocation de la méthode DELETE HTTP
		ClientResponse clientResponse = builder.delete(ClientResponse.class);
				
		return clientResponse;
	}

	@Override
	public ClientResponse post(LocationCourtTerme t) {
		// TODO Auto-generated method stub
		
		// Set params
		WebResource webResource = addQueryParam (t);
		webResource = this.webResource.path("/location");
		Builder builder = getBuilder (webResource);
		
		// Invocation de la méthode POST HTTP
		ClientResponse clientResponse = builder.post(ClientResponse.class);
				
		return clientResponse;
	}

	@Override
	public ClientResponse put(LocationCourtTerme t) {
		
		WebResource webResource = addQueryParam (t);
		webResource = this.webResource.path("/location/" + String.valueOf(t.getId()));
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
    
     private WebResource addQueryParam (LocationCourtTerme location) {		
		
		// Enrichissement de la requête
		webResource = webResource.queryParam("coutLocation", String.valueOf(location.getCoutLocation()));
		webResource = webResource.queryParam("typeLocation",location.getTypeLocation() );
		webResource = webResource.queryParam("nombreDeJour",String.valueOf(location.getNombreDeJour()) );

		return webResource;
	}
	
	private Builder getBuilder (WebResource webResource) {
		Builder builder = webResource.accept(MediaType.APPLICATION_JSON).header("content-type", MediaType.APPLICATION_JSON); 
		return builder;
	}

}
