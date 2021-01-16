package com.appli.modele;

public class Authentification {

	
	//ATTRIBUTS
	private int id;
	private String login;
	private String password;
	private int status;
	
	
	//CONSTRUCTEUR
	public Authentification(int id,String login, String password, int status) {
		super();
		this.login = login;
		this.password = password;
		this.status = status;
		this.id=id;
	}
	
	public Authentification(String login, String password, int status) {
		super();
		this.login = login;
		this.password = password;
		this.status = status;
	}
	
	public Authentification() {}
	
	//GETTERS AND SETTERS 
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Authentification [id=" + id + ", login=" + login + ", password=" + password + ", status=" + status
				+ "]";
	}
	
	
}
