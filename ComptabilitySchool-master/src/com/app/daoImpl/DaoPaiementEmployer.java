package com.app.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.connection.SingletonConnection;
import com.app.dao.IDaoPaiementEmployer;
import com.app.metier.entites.PaiementEmployer;
import com.app.metier.entites.Personnel;

public class DaoPaiementEmployer implements IDaoPaiementEmployer {
	@Override
	public void create(PaiementEmployer admin) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO paiementemployer(montant,date,mois,poste,nom,prenom,modeDePaiement)"
					+ " VALUES(?,?,?,?,?,?,?)");
			ps.setDouble(1, admin.getMontant());
			ps.setString(2, admin.getDate());
			ps.setString(3, admin.getMois());
			ps.setString(4, admin.getPoste());
			ps.setString(5, admin.getNom());
			ps.setString(6, admin.getPrenom());
			ps.setString(7, admin.getModeDePaiement());

			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public PaiementEmployer read(int id) {
		Connection conn = SingletonConnection.getConnection();
		PaiementEmployer admin = new PaiementEmployer();
		
	    try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  paiementemployer WHERE id = ?");
			ps.setInt(1, id);
			ResultSet ad  = ps.executeQuery();
			if(ad.next()) {

				admin.setNom(ad.getString("nom"));
				admin.setPrenom(ad.getString("prenom"));
				admin.setPoste(ad.getString("poste"));
				admin.setMois(ad.getString("mois"));
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
	public void update(PaiementEmployer admin) {
         Connection conn = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE paiementemployer SET montant  = ?,date  = ?,mois = ?,poste  = ?,nom  = ?,prenom  = ?,modeDePaiement = ? WHERE id = ?");
			ps.setDouble(1, admin.getMontant());
			ps.setString(2, admin.getDate());
			ps.setString(3, admin.getMois());
			ps.setString(4, admin.getPoste());
			ps.setString(5, admin.getNom());
			ps.setString(6, admin.getPrenom());
			ps.setString(7, admin.getModeDePaiement());
			ps.setInt(8, admin.getId());
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
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM paiementemployer WHERE id= ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

	}

	@Override
	public List<PaiementEmployer> readByName(String name) {
		Connection conn = SingletonConnection.getConnection();
		List<PaiementEmployer>administrateurs = new ArrayList<PaiementEmployer>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  paiementemployer WHERE nom = ? OR prenom = ?");
			ps.setString(1,name);
			ps.setString(2,name);
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				PaiementEmployer admin = new PaiementEmployer();
				admin.setNom(ad.getString("nom"));
				admin.setPrenom(ad.getString("prenom"));
				admin.setPoste(ad.getString("poste"));
				admin.setMois(ad.getString("mois"));
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
	public List<PaiementEmployer> read() {
		List<PaiementEmployer>administrateurs = new ArrayList<PaiementEmployer>();
		Connection conn = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  paiementemployer ");
		
	
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				PaiementEmployer admin = new PaiementEmployer();
				admin.setNom(ad.getString("nom"));
				admin.setPrenom(ad.getString("prenom"));
				admin.setPoste(ad.getString("poste"));
				admin.setMois(ad.getString("mois"));
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
	public List<PaiementEmployer> readByTri(String name) {
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps = null;
		List<PaiementEmployer>administrateurs = new ArrayList<PaiementEmployer>();
		try {
			
			
			switch (name) {
			
			case "nom":	ps = conn.prepareStatement("SELECT * FROM paiementemployer ORDER BY nom");

				
				break;
            case "prenom":	ps = conn.prepareStatement("SELECT * FROM paiementemployer ORDER BY prenom");

				
				break;
				
            case "mois": ps = conn.prepareStatement("SELECT * FROM paiementemployer ORDER BY mois");

	
	            break;

			default:
				break;
			}
			
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				
					PaiementEmployer admin = new PaiementEmployer();
					admin.setNom(ad.getString("nom"));
					admin.setPrenom(ad.getString("prenom"));
					admin.setPoste(ad.getString("poste"));
					admin.setMois(ad.getString("mois"));
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
	public List<PaiementEmployer> readByEmployer(Personnel name) {
		Connection conn = SingletonConnection.getConnection();
		List<PaiementEmployer>administrateurs = new ArrayList<PaiementEmployer>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  paiementemployer WHERE nom = ? AND prenom = ? AND poste = ?");
			ps.setString(1,name.getNom());
			ps.setString(2,name.getPrenom());
			ps.setString(3,name.getPoste());
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				PaiementEmployer admin = new PaiementEmployer();
				admin.setNom(ad.getString("nom"));
				admin.setPrenom(ad.getString("prenom"));
				admin.setPoste(ad.getString("poste"));
				admin.setMois(ad.getString("mois"));
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
			PreparedStatement ps = conn.prepareStatement("SELECT SUM(montant) AS prix_total FROM  paiementemployer");
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
