package com.appli.dao;

import com.sun.jersey.api.client.ClientResponse;


public interface IDao <T> {

	// GET ALL
	public ClientResponse get(Integer id);

	// GET
	public ClientResponse get();

	// DELETE
	public ClientResponse delete(Integer id);

	// POST
	public ClientResponse post(T t);

	// PUT
	public ClientResponse put(T t);
}
