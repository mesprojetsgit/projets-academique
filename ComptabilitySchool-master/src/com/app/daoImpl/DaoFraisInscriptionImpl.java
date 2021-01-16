package com.app.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.connection.SingletonConnection;
import com.app.dao.IDaoFraisInscripion;
import com.app.metier.entites.FraisInscription;


public class DaoFraisInscriptionImpl implements IDaoFraisInscripion {
	
	
	@Override
	public void create(FraisInscription admin) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO fraisinscription(nom,prenom,classe,matricule,anneeScolaire,date,montant,modeDePaiement)"
					+ " VALUES(?,?,?,?,?,?,?,?)");
			ps.setString(1, admin.getNom());
			ps.setString(2, admin.getPrenom());
			ps.setString(3, admin.getClasse());
			ps.setString(4, admin.getMatricule());
			ps.setString(5, admin.getAnneeScolaire());
			ps.setString(6, admin.getDate());
			ps.setDouble(7, admin.getMontant());
			ps.setString(8, admin.getModeDePaiement());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public FraisInscription read(int id) {
		Connection conn = SingletonConnection.getConnection();
		FraisInscription admin = new FraisInscription();
		
	    try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  fraisinscription WHERE id = ?");
			ps.setInt(1, id);
			ResultSet ad  = ps.executeQuery();
			if(ad.next()) {

				admin.setNom(ad.getString("nom"));
				admin.setPrenom(ad.getString("prenom"));
				admin.setClasse(ad.getString("classe"));
				admin.setMatricule(ad.getString("matricule"));
				admin.setAnneeScolaire(ad.getString("anneeScolaire"));
				admin.setDate(ad.getString("date"));
				admin.setMontant(ad.getDouble("montant"));
				admin.setModeDePaiement(ad.getString("modeDePaiement"));
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
	public void update(FraisInscription admin) {
         Connection conn = SingletonConnection.getConnection();
       //nom ; prenom; classe; matricule;anneeScolaire;date;montant;modeDePaiement;id;
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE fraisinscription SET nom = ?,prenom = ? ,classe = ? ,matricule = ? ,anneeScolaire = ? ,date = ?,montant = ? ,modeDePaiement = ? WHERE id = ?");
			ps.setString(1, admin.getNom());
			ps.setString(2, admin.getPrenom());
			ps.setString(3, admin.getClasse());
			ps.setString(4, admin.getMatricule());
			ps.setString(5, admin.getAnneeScolaire());
			ps.setString(6, admin.getDate());
			ps.setDouble(7, admin.getMontant());
			ps.setString(8, admin.getModeDePaiement());
			ps.setInt(9, admin.getId());
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
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM fraisinscription WHERE id= ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

	}

	@Override
	public List<FraisInscription> readByName(String name) {
		Connection conn = SingletonConnection.getConnection();
		List<FraisInscription>administrateurs = new ArrayList<FraisInscription>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  fraisinscription WHERE nom = ? OR prenom = ?");
			ps.setString(1,name);
			ps.setString(2,name);
			ResultSet ad  = ps.executeQuery();	
			//nom ; prenom; classe; matricule;anneeScolaire;date;montant;modeDePaiement;id;
			while(ad.next()) {
				
				FraisInscription admin = new FraisInscription();
				
				admin.setNom(ad.getString("nom"));
				admin.setPrenom(ad.getString("prenom"));
				admin.setClasse(ad.getString("classe"));
				admin.setMatricule(ad.getString("matricule"));
				admin.setAnneeScolaire(ad.getString("anneeScolaire"));
				admin.setDate(ad.getString("date"));
				admin.setMontant(ad.getDouble("montant"));
				admin.setModeDePaiement(ad.getString("modeDePaiement"));
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
	public List<FraisInscription> read() {
		List<FraisInscription>administrateurs = new ArrayList<FraisInscription>();
		Connection conn = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  fraisinscription ");
		
	
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				FraisInscription admin = new FraisInscription();
			    
			    admin.setNom(ad.getString("nom"));
				admin.setPrenom(ad.getString("prenom"));
				admin.setClasse(ad.getString("classe"));
				admin.setMatricule(ad.getString("matricule"));
				admin.setAnneeScolaire(ad.getString("anneeScolaire"));
				admin.setDate(ad.getString("date"));
				admin.setMontant(ad.getDouble("montant"));
				admin.setModeDePaiement(ad.getString("modeDePaiement"));
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
	public List<FraisInscription> readByTri(String name) {
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps = null;
		List<FraisInscription>administrateurs = new ArrayList<FraisInscription>();
		try {
			
			switch (name) {
			
			
			case "nom":ps = conn.prepareStatement("SELECT * FROM fraisinscription ORDER BY nom  ");
				
				break;

            case "date":ps = conn.prepareStatement("SELECT * FROM fraisinscription ORDER BY date ");
				
				break;
             case "classe":ps = conn.prepareStatement("SELECT * FROM fraisinscription ORDER BY classe  ");
	
	             break;
			default:
				break;
				
			}
			
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				
					FraisInscription admin = new FraisInscription();
					
			        admin.setNom(ad.getString("nom"));
					admin.setPrenom(ad.getString("prenom"));
					admin.setClasse(ad.getString("classe"));
					admin.setMatricule(ad.getString("matricule"));
					admin.setAnneeScolaire(ad.getString("anneeScolaire"));
					admin.setDate(ad.getString("date"));
					admin.setMontant(ad.getDouble("montant"));
					admin.setModeDePaiement(ad.getString("modeDePaiement"));
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
	public double total() {
		Connection conn = SingletonConnection.getConnection();
		double somme=0;
	
		
	    try {
			PreparedStatement ps = conn.prepareStatement("SELECT SUM(montant) AS prix_total FROM  fraisinscription");
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
