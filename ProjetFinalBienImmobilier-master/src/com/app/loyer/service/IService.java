package com.app.loyer.service;

import com.appli.modele.Administrateur;
import com.appli.modele.Authentification;
import com.appli.modele.BienImmobilier;
import com.appli.modele.Gestionnaire;
import com.appli.modele.Locataire;
import com.appli.modele.PaiementLoyer;
import com.sun.jersey.api.client.ClientResponse;

public interface IService {
		
    /* 
     * action de l administrateur	
     */
	
	//creation,modification,suppresion,liste  administrateur
	public ClientResponse ajouterAdministrateur(Administrateur admin);
	public ClientResponse supprimerAdministrateur(Integer id);
    public ClientResponse modifierAdministrateur(Administrateur admin);
    public ClientResponse rechercherAdministrateur(Integer id);
    public ClientResponse listeAdministrateur();
    
	//creation,modification,suppresion,liste  gestionnaire
	public ClientResponse ajouterGestionnaire(Gestionnaire admin);
	public ClientResponse supprimerGestionnaire(Integer id);
    public ClientResponse modifierGestionnaire(Gestionnaire admin);
    public ClientResponse rechercherGestionnaire(Integer id);
    public ClientResponse listeGestionnaire();
    
	//creation,modification,desactivation,liste  bien immobilier
	public ClientResponse ajouterBienImmobilier(BienImmobilier admin);
	public ClientResponse ajouterBienImmobilierDesactive(BienImmobilier admin);
	public ClientResponse aloueBienImmobilier(BienImmobilier admin);
	public ClientResponse supprimeBienImmobilierDesactive(Integer id);
	public ClientResponse supprimerBienImmobilier(Integer id);
	public ClientResponse desactiverBienImmobilier(Integer id);
    public ClientResponse modifierBienImmobilier(BienImmobilier admin);
    public ClientResponse rechercherBienImmobilier(Integer id);
    public ClientResponse rechercherBienImmobilierAloue(Integer id);
    public ClientResponse listeImmobilier();
    public ClientResponse listeImmobilierDesactive();
    public ClientResponse listeImmobilierAloue();
    
    //creation acces admin
    
	public ClientResponse affecterAccesAdmin(Authentification auth);
	public ClientResponse supprimerAccesAdmin(Integer id);
    public ClientResponse modifierAccesAdmin(Authentification id);
    public ClientResponse rechercherAccesAdmin(Integer id);
    public ClientResponse listeAccesAdmin();
    
    
    //creation authentification
    
   	public ClientResponse affecterAuthentification(Authentification auth);
   	public ClientResponse supprimerAuthentification(Integer id);
    public ClientResponse modifierAuthentification(Authentification id);
    public ClientResponse rechercherAuthentification(Integer id);
    public ClientResponse listeAuthentification();
    
    
    /* 
     * action du gestionnaire	
     */
    public ClientResponse affecterBienALocataire(Integer idBienImmobilier,Locataire locataire);
    public ClientResponse consulterLocataire();
    public ClientResponse enregistrerPaiement(Integer idLocataire,PaiementLoyer payer);
    public ClientResponse modifierPaiement(PaiementLoyer payer);
    public ClientResponse supprimerPaiement(Integer id);
    public ClientResponse libererBienImmobilier(Integer id);
    public ClientResponse consulterPaiement();
    public ClientResponse rechercherPaiement(Integer id);
    public ClientResponse rechercherLocataire(Integer id);
    public ClientResponse supprimerLocataire(Integer id);
    
    
   
    
}
