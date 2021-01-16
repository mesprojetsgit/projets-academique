package com.appli.dao;

import javax.ws.rs.core.MediaType;

import com.appli.modele.BienImmobilier;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;

public class DaoBienImmobilierAloues implements IDao<BienImmobilier> {

	private WebResource webResource;

	public DaoBienImmobilierAloues(String uri) {
		Client client = Client.create();
		webResource = client.resource(uri);
	}
	@Override
	public ClientResponse get(Integer id) {
		// TODO Auto-generated method stub
		WebResource webResource = this.webResource.path("/immobilierAloue/" + id);
		return get(webResource);
	}

	@Override
	public ClientResponse get() {
		// TODO Auto-generated method stub
		WebResource webResource = this.webResource.path("/immobiliersAloues");
		return get(webResource);
	}

	@Override
	public ClientResponse delete(Integer id) {
		// TODO Auto-generated method stub
		WebResource webResource = this.webResource.path("/immobilierAloue/"+id);
		Builder builder = getBuilder (webResource);
	
		ClientResponse clientResponse = builder.delete(ClientResponse.class);
		return clientResponse;
	}

	@Override
	public ClientResponse post(BienImmobilier t) {
		// TODO Auto-generated method stub
		WebResource webResource = addQueryParam (t);
		webResource = this.webResource.path("/immobilierAloue");
		Builder builder = getBuilder (webResource);
		
		// Invocation de la m�thode POST HTTP
		ClientResponse clientResponse = builder.post(ClientResponse.class);
				
		return clientResponse;
	}

	@Override
	public ClientResponse put(BienImmobilier t) {
		// TODO Auto-generated method stub
		return null;
	}
	
private ClientResponse get (WebResource webResource) {
		
		Builder builder = getBuilder (webResource);

		// Invocation de la m�thode GET HTTP
		ClientResponse clientResponse = builder.get(ClientResponse.class);

		return clientResponse;
	}
    
     private WebResource addQueryParam (BienImmobilier immo) {		
		
		// Enrichissement de la requ�te
    	webResource = webResource.queryParam("id",""+immo.getId());
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
