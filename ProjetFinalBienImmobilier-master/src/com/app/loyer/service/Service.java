/**
 * 
 */
package com.app.loyer.service;

import com.appli.dao.DaoAdministrateur;
import com.appli.dao.DaoAuthentification;
import com.appli.dao.DaoBienImmobilier;
import com.appli.dao.DaoBienImmobilierAloues;
import com.appli.dao.DaoBienImmobilierDesactives;
import com.appli.dao.DaoEspaceAdmin;
import com.appli.dao.DaoGestionnaire;
import com.appli.dao.DaoLocataire;
import com.appli.dao.DaoLocationCourtTerme;
import com.appli.dao.DaoLocationLongTerme;
import com.appli.dao.DaoPayerLoyer;
import com.appli.dao.IDao;
import com.appli.modele.Administrateur;
import com.appli.modele.Authentification;
import com.appli.modele.BienImmobilier;
import com.appli.modele.Gestionnaire;
import com.appli.modele.Locataire;
import com.appli.modele.PaiementLoyer;
import com.sun.jersey.api.client.ClientResponse;

/**
 * @author OUEDRAOGO
 *
 */
public class Service implements IService {
	
	public static final String RESOURCE_URI = "http://localhost/rest-api-loyer-application/public/api";
	@SuppressWarnings({ "rawtypes", "unused" })
	private IDao daoAdmin,daoAuth,doBienImmobilier,daoGestionnaire,daoLocataire,daoLocationCourtTerme,daoLocationLongTerme,
	daoPayerLoyer,doBienImmobilieDesactiver,doBienImmobilieAloues,daoAccesAdmin;

	
	public Service() {
		daoAdmin = new DaoAdministrateur(RESOURCE_URI);
		daoAuth = new DaoAuthentification(RESOURCE_URI);
		daoAccesAdmin = new DaoEspaceAdmin(RESOURCE_URI);
		doBienImmobilier = new DaoBienImmobilier(RESOURCE_URI);
		doBienImmobilieDesactiver = new DaoBienImmobilierDesactives(RESOURCE_URI);
		doBienImmobilieAloues = new DaoBienImmobilierAloues(RESOURCE_URI);
		daoGestionnaire = new DaoGestionnaire(RESOURCE_URI);
		daoLocataire = new DaoLocataire(RESOURCE_URI);
		daoLocationCourtTerme = new DaoLocationCourtTerme(RESOURCE_URI);
		daoLocationLongTerme = new DaoLocationLongTerme(RESOURCE_URI);
		daoPayerLoyer = new DaoPayerLoyer(RESOURCE_URI);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ClientResponse ajouterAdministrateur(Administrateur admin) {
		
		ClientResponse clientResponse = daoAdmin.post(admin);		
		return clientResponse;
	}

	@Override
	public ClientResponse supprimerAdministrateur(Integer id) {
		
		ClientResponse clientResponse = daoAdmin.delete(id);
		daoAccesAdmin.delete(id);
		return clientResponse;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ClientResponse modifierAdministrateur(Administrateur id) {
		
		ClientResponse clientResponse = daoAdmin.put(id);		
		return clientResponse;
	}

	@Override
	public ClientResponse rechercherAdministrateur(Integer id) {
		
		ClientResponse clientResponse = daoAdmin.get(id);		
		return clientResponse;
	}

	@Override
	public ClientResponse listeAdministrateur() {
		
		ClientResponse clientResponse = daoAdmin.get();		
		return clientResponse;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ClientResponse ajouterGestionnaire(Gestionnaire admin) {
		
		ClientResponse clientResponse = daoGestionnaire.post(admin);		
		return clientResponse;
	}

	@Override
	public ClientResponse supprimerGestionnaire(Integer id) {
	
		ClientResponse clientResponse = daoGestionnaire.delete(id);	
		daoAuth.delete(id);
		return clientResponse;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ClientResponse modifierGestionnaire(Gestionnaire id) {
		
		ClientResponse clientResponse = daoGestionnaire.put(id);		
		return clientResponse;
	}

	@Override
	public ClientResponse rechercherGestionnaire(Integer id) {
		
		ClientResponse clientResponse = daoGestionnaire.get(id);		
		return clientResponse;
	}

	@Override
	public ClientResponse listeGestionnaire() {
		
		ClientResponse clientResponse = daoGestionnaire.get();		
		return clientResponse;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ClientResponse ajouterBienImmobilier(BienImmobilier admin) {
		
		ClientResponse clientResponse = doBienImmobilier.post(admin);		
		return clientResponse;
	}

	@Override
	public ClientResponse desactiverBienImmobilier(Integer id) {
		
		ClientResponse clientResponse = doBienImmobilier.delete(id);		
		return clientResponse;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ClientResponse modifierBienImmobilier(BienImmobilier id) {
		
		ClientResponse clientResponse = doBienImmobilier.put(id);		
		return clientResponse;
	}

	@Override
	public ClientResponse rechercherBienImmobilier(Integer id) {
		
		ClientResponse clientResponse = doBienImmobilier.get(id);		
		return clientResponse;
	}

	@Override
	public ClientResponse listeImmobilier() {
		
		ClientResponse clientResponse = doBienImmobilier.get();		
		return clientResponse;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ClientResponse affecterBienALocataire(Integer idBienImmobilier, Locataire locataire) {
		
		locataire.setId(idBienImmobilier);
		ClientResponse clientResponse = daoLocataire.post(locataire);		
		return clientResponse;
	}

	@Override
	public ClientResponse consulterLocataire() {
		
		ClientResponse clientResponse = daoLocataire.get();		
		return clientResponse;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ClientResponse enregistrerPaiement(Integer idLocataire, PaiementLoyer payer) {
		
		payer.setIdLocataire(idLocataire);
		ClientResponse clientResponse = daoPayerLoyer.post(payer);		
		return clientResponse;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ClientResponse modifierPaiement(PaiementLoyer payer) {
		
		ClientResponse clientResponse = daoPayerLoyer.put(payer);		
		return clientResponse;
	}

	@Override
	public ClientResponse supprimerPaiement(Integer id) {
	
		ClientResponse clientResponse = daoPayerLoyer.delete(id);		
		return clientResponse;
	}

	@Override
	public ClientResponse libererBienImmobilier(Integer id) {
		ClientResponse clientResponse = doBienImmobilieAloues.delete(id);		
		return clientResponse;
	}

	//TODO
	@Override
	public ClientResponse consulterPaiement() {
		// TODO Auto-generated method stub
		ClientResponse clientResponse = daoPayerLoyer.get();		
		return clientResponse;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ClientResponse affecterAuthentification(Authentification auth) {
		// TODO Auto-generated method stub
		ClientResponse clientResponse = daoAuth.post(auth);		
		return clientResponse;
	}

	@Override
	public ClientResponse supprimerAuthentification(Integer id) {
		// TODO Auto-generated method stub
		ClientResponse clientResponse = daoAuth.delete(id);		
		return clientResponse;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ClientResponse modifierAuthentification(Authentification id) {
		// TODO Auto-generated method stub
		ClientResponse clientResponse = daoAuth.put(id);		
		return clientResponse;
	}

	@Override
	public ClientResponse rechercherAuthentification(Integer id) {
		// TODO Auto-generated method stub
		ClientResponse clientResponse = daoAuth.get(id);		
		return clientResponse;
	}

	@Override
	public ClientResponse listeAuthentification() {
		// TODO Auto-generated method stub
		ClientResponse clientResponse = daoAuth.get();		
		return clientResponse;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ClientResponse affecterAccesAdmin(Authentification auth) {
		// TODO Auto-generated method stub
		ClientResponse clientResponse = daoAccesAdmin.post(auth);		
		return clientResponse;
	}

	@Override
	public ClientResponse supprimerAccesAdmin(Integer id) {
		// TODO Auto-generated method stub
		ClientResponse clientResponse = daoAccesAdmin.delete(id);		
		return clientResponse;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ClientResponse modifierAccesAdmin(Authentification id) {
		// TODO Auto-generated method stub
		ClientResponse clientResponse = daoAccesAdmin.put(id);		
		return clientResponse;
	}

	@Override
	public ClientResponse rechercherAccesAdmin(Integer id) {
		// TODO Auto-generated method stub
		ClientResponse clientResponse = daoAccesAdmin.get(id);		
		return clientResponse;
	}

	@Override
	public ClientResponse listeAccesAdmin() {
		// TODO Auto-generated method stub
		ClientResponse clientResponse = daoAccesAdmin.get();		
		return clientResponse;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ClientResponse ajouterBienImmobilierDesactive(BienImmobilier admin) {
		// TODO Auto-generated method stub
		ClientResponse clientResponse = doBienImmobilieDesactiver.post(admin);		
		return clientResponse;
	}

	@Override
	public ClientResponse supprimeBienImmobilierDesactive(Integer id) {
		// TODO Auto-generated method stub
		ClientResponse clientResponse = doBienImmobilieDesactiver.delete(id);		
		return clientResponse;
	}

	@Override
	public ClientResponse listeImmobilierDesactive() {
		// TODO Auto-generated method stub
		ClientResponse clientResponse = doBienImmobilieDesactiver.get();		
		return clientResponse;
	}

	@Override
	public ClientResponse supprimerBienImmobilier(Integer id) {
		ClientResponse clientResponse = doBienImmobilier.delete(id);		
		return clientResponse;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ClientResponse aloueBienImmobilier(BienImmobilier admin) {
		ClientResponse clientResponse = doBienImmobilieAloues.post(admin);		
		return clientResponse;
	}

	@Override
	public ClientResponse supprimerLocataire(Integer id) {
		ClientResponse clientResponse = daoLocataire.delete(id);		
		return clientResponse;
	}

	@Override
	public ClientResponse listeImmobilierAloue() {
	
		ClientResponse clientResponse = doBienImmobilieAloues.get();		
		return clientResponse;
	}

	@Override
	public ClientResponse rechercherBienImmobilierAloue(Integer id) {
		// TODO Auto-generated method stub
		ClientResponse clientResponse = doBienImmobilieAloues.get(id);		
		return clientResponse;
	}

	@Override
	public ClientResponse rechercherPaiement(Integer id) {

		ClientResponse clientResponse = daoPayerLoyer.get(id);		
		return clientResponse;
	}

	@Override
	public ClientResponse rechercherLocataire(Integer id) {
		ClientResponse clientResponse = daoLocataire.get(id);		
		return clientResponse;
	}

}
