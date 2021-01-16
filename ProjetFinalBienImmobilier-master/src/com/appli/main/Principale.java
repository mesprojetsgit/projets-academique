package com.appli.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.app.loyer.service.IService;
import com.app.loyer.service.Service;
import com.appli.controlleur.Controleur;
import com.appli.decoder.ResponseDecoder;
import com.appli.interfaces.Accueil;
import com.appli.interfaces.IAdministrateur;
import com.appli.interfaces.IGestionnaire;
import com.appli.interfaces.IPaiementJournalier;
import com.appli.interfaces.IPaiementMensuel;
import com.appli.modele.Authentification;
import com.appli.modele.BienImmobilier;
import com.appli.modele.Locataire;
import com.appli.modele.PaiementLoyer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sun.jersey.api.client.ClientResponse;

public class Principale {
		private IService service;
		
		public static void main(String[] args) {
//			Principale principale= new Principale();
//		//	Gestionnaire admin= new Gestionnaire();
//			double date=principale.getDaysBetweenDates("10 mars 2020","15 avril 2020");
//			//principale.seConnecter() ;
//			System.out.println(date);
			IAdministrateur admin =new IAdministrateur();
			IGestionnaire gestionnaire = new IGestionnaire();
			Accueil acceuil = new Accueil();
			IPaiementJournalier paieJ=new IPaiementJournalier(0);
			IPaiementMensuel paieM = new IPaiementMensuel(0,0);
			Controleur controleur =new Controleur(acceuil,admin,gestionnaire,paieJ,paieM);
			controleur.run();
			

		}
		

		public  void seConnecter() {
			service=new Service();
	    	ClientResponse response = service.listeAuthentification();	
	    	@SuppressWarnings("unused")
			Authentification admin=null;
			
			try {
				ResponseDecoder decoder = new ResponseDecoder(response);
				Integer code = decoder.getCode();
				List<Authentification> authen = decoder.getAuthentifications();
				if (code == 200) {
					
					
				for(Authentification aut:authen) {
					System.out.println(aut);
				}
				
					
				} 
			} catch (JsonProcessingException e) {			
				System.err.println("Error Class : " + e.getClass() + "\nError Message : " + e.getMessage());
			}	
		
	    }
		
		
		public  void put() {
			service=new Service();	
	    	@SuppressWarnings("unused")
			BienImmobilier admin=new BienImmobilier("seweke",55.0,2,"papa gg","Journalier","studio");
	    	@SuppressWarnings("unused")
			Locataire locataire = new Locataire(4,"akissi","delta","7555","@","M","55B","12/03/20","20/10/20","ER");
	    	PaiementLoyer payer=new PaiementLoyer(3,"today",5000);
	    	//ClientResponse response = service.supprimerLocataire(4);
	    	ClientResponse response =service.enregistrerPaiement(3, payer);
	    	
			try {
				ResponseDecoder decoder = new ResponseDecoder(response);
				Integer code = decoder.getCode();
				//BienImmobilier leBien=decoder.getBienImmobilier();
				if (code == 200) {
					System.out.println("ok");
				} else {
					String message = decoder.getMessage();
					System.out.println(message);
				}
			} catch (JsonProcessingException e) {			
				System.err.println("Error Class : " + e.getClass() + "\nError Message : " + e.getMessage());
			}	
		
	    }
		
		 public  double getDaysBetweenDates(String theEarlierDate, String theLaterDate) {
			   
			   SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
		       Date Date1=null;
		       Date Date2=null;
			try {
				Date1 = formatter.parse(theEarlierDate);
			    Date2 =formatter.parse(theLaterDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		       
				double result = Double.POSITIVE_INFINITY;
				if (theEarlierDate != null && theLaterDate != null) {
					final long MILLISECONDS_PER_DAY = 1000 * 60 * 60 * 24;
					Calendar aCal = Calendar.getInstance();
					aCal.setTime(Date1);
					long aFromOffset = aCal.get(Calendar.DST_OFFSET);
					aCal.setTime(Date2);
					long aToOffset = aCal.get(Calendar.DST_OFFSET);
					long aDayDiffInMili = (Date2.getTime() + aToOffset) - (Date1.getTime() + aFromOffset);
					result = ((double) aDayDiffInMili / MILLISECONDS_PER_DAY);
				}
				return result;
			}
		   
	}



