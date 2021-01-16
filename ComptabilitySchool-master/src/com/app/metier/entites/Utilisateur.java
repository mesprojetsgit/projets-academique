package com.app.metier.entites;

public abstract class Utilisateur extends Personne {

   protected String login;
   protected String password;
   
public Utilisateur(String nom, String prenom, String email, String sexe, String numeroTel, String addresse,
		String numeroCINB, String login,
		String password) {
	super(nom, prenom, email, sexe, numeroTel, addresse, numeroCINB);
	this.login = login;
	this.password = password;
}

public Utilisateur() {

}

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
   
   
   

}
