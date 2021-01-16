package com.app.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.connection.SingletonConnection;
import com.app.dao.IDaoPaiementProfesseur;
import com.app.metier.entites.PaiementProfesseur;
import com.app.metier.entites.Professeur;

public class DaoPaiementProfesseurImpl implements IDaoPaiementProfesseur {

	@Override
	public void create(PaiementProfesseur admin) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO paiementprofesseur(nom,prenom,nomClasse,nomMatiere,type,salaire,nombreHeure,prixParHeure,montantTotal,mois,modePaiement,dateDePaiement,matricule)"
					+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, admin.getNom());
			ps.setString(2, admin.getPrenom());
			ps.setString(3, admin.getNomClasse());
			ps.setString(4, admin.getNomMatiere());
			ps.setString(5, admin.getType());
			ps.setDouble(6, admin.getSalaire());
			ps.setInt(7, admin.getNombreHeure());
			ps.setDouble(8, admin.getPrixParHeure());
			ps.setDouble(9, admin.getMontantTotal());
			ps.setString(10, admin.getMois());
			ps.setString(11, admin.getModePaiement());
			ps.setString(12, admin.getDateDePaiement());
			ps.setString(13, admin.getMatricule());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public PaiementProfesseur read(int id) {
		Connection conn = SingletonConnection.getConnection();
		PaiementProfesseur admin = new PaiementProfesseur();
		
	    try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  paiementprofesseur WHERE id = ?");
			ps.setInt(1, id);
			ResultSet ad  = ps.executeQuery();
			if(ad.next()) {

				admin.setNom(ad.getString("nom"));
				admin.setPrenom(ad.getString("prenom"));
				admin.setNomClasse(ad.getString("nomClasse"));
				admin.setNomMatiere(ad.getString("nomMatiere"));
				admin.setType(ad.getString("type"));
				admin.setNombreHeure(ad.getInt("nombreHeure"));
				admin.setPrixParHeure(ad.getDouble("prixParHeure"));
				admin.setMontantTotal(ad.getDouble("montantTotal"));
				admin.setSalaire(ad.getDouble("salaire"));
				admin.setMois(ad.getString("mois"));
				admin.setModePaiement(ad.getString("modePaiement"));
				admin.setDateDePaiement(ad.getString("dateDePaiement"));
				admin.setMatricule(ad.getString("matricule"));
				admin.setId(ad.getInt("id"));
				ps.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return admin;
	}

	@Override
	public void update(PaiementProfesseur admin) {
         Connection conn = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE paiementprofesseur SET nom = ?,prenom = ? ,nomClasse = ? ,nomMatiere = ? ,type = ? ,salaire = ?,nombreHeure = ? ,prixParHeure = ?,montantTotal = ? ,mois = ?,modePaiement = ?,dateDePaiement = ? ,matricule = ? WHERE id = ?");
			ps.setString(1, admin.getNom());
			ps.setString(2, admin.getPrenom());
			ps.setString(3, admin.getNomClasse());
			ps.setString(4, admin.getNomMatiere());
			ps.setString(5, admin.getType());
			ps.setDouble(6, admin.getSalaire());
			ps.setInt(7, admin.getNombreHeure());
			ps.setDouble(8, admin.getPrixParHeure());
			ps.setDouble(9, admin.getMontantTotal());
			ps.setString(10, admin.getMois());
			ps.setString(11, admin.getModePaiement());
			ps.setString(12, admin.getDateDePaiement());
			ps.setString(13, admin.getMatricule());
			ps.setInt(14, admin.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Override
	public void delete(int id) {
		Connection conn = SingletonConnection.getConnection();
		try {
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM paiementprofesseur WHERE id= ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

	}

	@Override
	public List<PaiementProfesseur> readByName(String name) {
		Connection conn = SingletonConnection.getConnection();
		List<PaiementProfesseur>administrateurs = new ArrayList<PaiementProfesseur>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  paiementprofesseur WHERE nom = ? OR prenom = ?");
			ps.setString(1,name);
			ps.setString(2,name);
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				PaiementProfesseur admin = new PaiementProfesseur();
				admin.setNom(ad.getString("nom"));
				admin.setPrenom(ad.getString("prenom"));
				admin.setNomClasse(ad.getString("nomClasse"));
				admin.setNomMatiere(ad.getString("nomMatiere"));
				admin.setType(ad.getString("type"));
				admin.setNombreHeure(ad.getInt("nombreHeure"));
				admin.setPrixParHeure(ad.getDouble("prixParHeure"));
				admin.setMontantTotal(ad.getDouble("montantTotal"));
				admin.setSalaire(ad.getDouble("salaire"));
				admin.setMois(ad.getString("mois"));
				admin.setModePaiement(ad.getString("modePaiement"));
				admin.setDateDePaiement(ad.getString("dateDePaiement"));
				admin.setMatricule(ad.getString("matricule"));
				admin.setId(ad.getInt("id"));
			    administrateurs.add(admin);
					
			}
		    ps.close();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return administrateurs;
	}
	
	
	@Override
	public List<PaiementProfesseur> read() {
		List<PaiementProfesseur>administrateurs = new ArrayList<PaiementProfesseur>();
		Connection conn = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  paiementprofesseur ");
		
	
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				PaiementProfesseur admin = new PaiementProfesseur();
				admin.setNom(ad.getString("nom"));
				admin.setPrenom(ad.getString("prenom"));
				admin.setNomClasse(ad.getString("nomClasse"));
				admin.setNomMatiere(ad.getString("nomMatiere"));
				admin.setType(ad.getString("type"));
				admin.setNombreHeure(ad.getInt("nombreHeure"));
				admin.setPrixParHeure(ad.getDouble("prixParHeure"));
				admin.setMontantTotal(ad.getDouble("montantTotal"));
				admin.setSalaire(ad.getDouble("salaire"));
				admin.setMois(ad.getString("mois"));
				admin.setModePaiement(ad.getString("modePaiement"));
				admin.setDateDePaiement(ad.getString("dateDePaiement"));
				admin.setMatricule(ad.getString("matricule"));
				admin.setId(ad.getInt("id"));
			    administrateurs.add(admin);
					
			}
		    ps.close();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return administrateurs;
	}

	@Override
	public List<PaiementProfesseur> readByTri(String name) {
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps=null;
		List<PaiementProfesseur>administrateurs = new ArrayList<PaiementProfesseur>();
		try {
			if (name.equals("type")) {
				ps = conn.prepareStatement("SELECT  * FROM  paiementprofesseur ORDER BY type");
			}else if (name.equals("mois")) {
				ps = conn.prepareStatement("SELECT  * FROM  paiementprofesseur ORDER BY mois");
			}else if (name.equals("classe")) {
				ps = conn.prepareStatement("SELECT  * FROM  paiementprofesseur ORDER BY nomClasse");
			}
			 
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
					PaiementProfesseur admin = new PaiementProfesseur();
					admin.setNom(ad.getString("nom"));
					admin.setPrenom(ad.getString("prenom"));
					admin.setNomClasse(ad.getString("nomClasse"));
					admin.setNomMatiere(ad.getString("nomMatiere"));
					admin.setType(ad.getString("type"));
					admin.setNombreHeure(ad.getInt("nombreHeure"));
					admin.setPrixParHeure(ad.getDouble("prixParHeure"));
					admin.setMontantTotal(ad.getDouble("montantTotal"));
					admin.setSalaire(ad.getDouble("salaire"));
					admin.setMois(ad.getString("mois"));
					admin.setModePaiement(ad.getString("modePaiement"));
					admin.setDateDePaiement(ad.getString("dateDePaiement"));
					admin.setMatricule(ad.getString("matricule"));
					admin.setId(ad.getInt("id"));
			        administrateurs.add(admin);
			}
		    ps.close();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return administrateurs;
	}

	@Override
	public List<PaiementProfesseur> readByProf(Professeur prof) {
		Connection conn = SingletonConnection.getConnection();
		List<PaiementProfesseur>administrateurs = new ArrayList<PaiementProfesseur>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  paiementprofesseur WHERE nom = ? AND prenom = ? AND type = ? AND nomClasse = ? AND nomMatiere = ?");
			ps.setString(1,prof.getNom());
			ps.setString(2,prof.getPrenom());
			ps.setString(3,prof.getType());
			ps.setString(4,prof.getNomClasse());
			ps.setString(5,prof.getNomMatiere());
	
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				PaiementProfesseur admin = new PaiementProfesseur();
				admin.setNom(ad.getString("nom"));
				admin.setPrenom(ad.getString("prenom"));
				admin.setNomClasse(ad.getString("nomClasse"));
				admin.setNomMatiere(ad.getString("nomMatiere"));
				admin.setType(ad.getString("type"));
				admin.setNombreHeure(ad.getInt("nombreHeure"));
				admin.setPrixParHeure(ad.getDouble("prixParHeure"));
				admin.setMontantTotal(ad.getDouble("montantTotal"));
				admin.setSalaire(ad.getDouble("salaire"));
				admin.setMois(ad.getString("mois"));
				admin.setModePaiement(ad.getString("modePaiement"));
				admin.setDateDePaiement(ad.getString("dateDePaiement"));
				admin.setMatricule(ad.getString("matricule"));
				admin.setId(ad.getInt("id"));
			    administrateurs.add(admin);
					
			}
		    ps.close();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return administrateurs;
	}

	@Override
	public PaiementProfesseur read(Professeur prof) {
		Connection conn = SingletonConnection.getConnection();
		PaiementProfesseur admin = new PaiementProfesseur();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  paiementprofesseur WHERE nom = ? AND prenom = ? AND type = ? AND nomClasse = ? AND nomMatiere = ?");
			ps.setString(1,prof.getNom());
			ps.setString(2,prof.getPrenom());
			ps.setString(3,prof.getType());
			ps.setString(4,prof.getNomClasse());
			ps.setString(5,prof.getNomMatiere());
	
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				admin.setNom(ad.getString("nom"));
				admin.setPrenom(ad.getString("prenom"));
				admin.setNomClasse(ad.getString("nomClasse"));
				admin.setNomMatiere(ad.getString("nomMatiere"));
				admin.setType(ad.getString("type"));
				admin.setNombreHeure(ad.getInt("nombreHeure"));
				admin.setPrixParHeure(ad.getDouble("prixParHeure"));
				admin.setMontantTotal(ad.getDouble("montantTotal"));
				admin.setSalaire(ad.getDouble("salaire"));
				admin.setMois(ad.getString("mois"));
				admin.setModePaiement(ad.getString("modePaiement"));
				admin.setDateDePaiement(ad.getString("dateDePaiement"));
				admin.setMatricule(ad.getString("matricule"));
				admin.setId(ad.getInt("id"));
					
			}
		    ps.close();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return admin;
	}
	public double total() {
		Connection conn = SingletonConnection.getConnection();
		double somme=0;
	
		
	    try {
			PreparedStatement ps = conn.prepareStatement("SELECT SUM(montantTotal) AS prix_total FROM  paiementprofesseur");
			ResultSet ad  = ps.executeQuery();
			if(ad.next()) {
				somme=ad.getDouble("prix_total");
				ps.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return somme;
	}
}
