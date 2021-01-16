package com.appli.dao;

import javax.ws.rs.core.MediaType;

import com.appli.modele.BienImmobilier;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;

public class DaoBienImmobilier implements IDao<BienImmobilier> {

	private WebResource webResource;

	public DaoBienImmobilier(String uri) {
		Client client = Client.create();
		webResource = client.resource(uri);
	}

	@Override
	public ClientResponse get(Integer id) {
		// TODO Auto-generated method stub
		WebResource webResource = this.webResource.path("/immobilier/" + id);
		return get(webResource);
	}

	@Override
	public ClientResponse get() {
		// TODO Auto-generated method stub
		WebResource webResource = this.webResource.path("/immobiliers");
		return get(webResource);
	}

	@Override
	public ClientResponse delete(Integer id) {
		// TODO Auto-generated method stub
		WebResource webResource = this.webResource.path("/immobilier/" + id);		
		Builder builder = getBuilder (webResource);
		
		// Invocation de la méthode DELETE HTTP
		ClientResponse clientResponse = builder.delete(ClientResponse.class);
				
		return clientResponse;
	}

	@Override
	public ClientResponse post(BienImmobilier t) {
		// TODO Auto-generated method stub
		
		// Set params
		WebResource webResource = addQueryParam (t);
		webResource = this.webResource.path("/immobilier");
		Builder builder = getBuilder (webResource);
		
		// Invocation de la méthode POST HTTP
		ClientResponse clientResponse = builder.post(ClientResponse.class);
				
		return clientResponse;
	}

	@Override
	public ClientResponse put(BienImmobilier admin) {
		
		WebResource webResource = addQueryParam (admin);
		webResource = this.webResource.path("/immobilier/" + String.valueOf(admin.getId()));
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
    
     private WebResource addQueryParam (BienImmobilier immo) {		
		
		// Enrichissement de la requête
		webResource = webResource.queryParam("addresse",immo.getAddresse());
		webResource = webResource.queryParam("loyer",""+immo.getLoyer() );
		webResource = webResource.queryParam("nombreDePiece",""+immo.getNombreDePiece());
		webResource = webResource.queryParam("detail",immo.getDetail());
		webResource = webResource.queryParam("typeLoyer",immo.getTypeLoyer());
		webResource = webResource.queryParam("typeBien",immo.getTypeBien());
		
		return webResource;
	}
	
	private Builder getBuilder (WebResource webResource) {
		Builder builder = webResource.accept(MediaType.APPLICATION_JSON).header("content-type", MediaType.APPLICATION_JSON); 
		return builder;
	}

}
