package com.app.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.connection.SingletonConnection;
import com.app.dao.IDaoVersement;
import com.app.metier.entites.Poste;
import com.app.metier.entites.Versement;

public class DaoVersementImpl implements IDaoVersement {

	@Override
	public void create(Versement admin) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO versement(date,montant,numeroCompte,soldeCompte)VALUES(?,?,?,?)");
			ps.setString(1, admin.getDate());
			ps.setDouble(2, admin.getMontant());
			ps.setString(3, admin.getNumeroCompte());
			ps.setDouble(4, admin.getSoldeCompte());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Versement read(int id) {
		Connection conn = SingletonConnection.getConnection();
		Versement admin = new Versement();
	
		
	    try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  versement WHERE id = ?");
			ps.setInt(1, id);
			ResultSet ad  = ps.executeQuery();
			if(ad.next()) {
				
				admin.setDate(ad.getString("date"));
				admin.setMontant(ad.getDouble("montant"));
				admin.setNumeroCompte(ad.getString("numeroCompte"));
				admin.setSoldeCompte(ad.getDouble("soldeCompte"));
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
	public void update(Versement admin) {
    Connection conn = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE versement SET date = ?,montant = ?,numeroCompte = ? ,soldeCompte = ?  WHERE id = ?");
			ps.setString(1, admin.getDate());
			ps.setDouble(2, admin.getMontant());
			ps.setString(3, admin.getNumeroCompte());
			ps.setDouble(4, admin.getSoldeCompte());
            ps.setInt(5, admin.getId());
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
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM versement WHERE id= ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

	}

	@Override
	public List<Versement> readByName(String name) {
		Connection conn = SingletonConnection.getConnection();
	
		
		List<Versement>administrateurs = new ArrayList<Versement>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  poste WHERE nom = ? OR prenom = ?");
			ps.setString(1,name);
			ps.setString(2,name);
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				Versement admin = new Versement();
				admin.setDate(ad.getString("date"));
				admin.setMontant(ad.getDouble("montant"));
				admin.setNumeroCompte(ad.getString("numeroCompte"));
				admin.setSoldeCompte(ad.getDouble("soldeCompte"));
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
	public List<Versement> read() {
    Connection conn = SingletonConnection.getConnection();
	
		
		List<Versement>administrateurs = new ArrayList<Versement>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  versement ORDER BY date");
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				Versement admin = new Versement();
				admin.setDate(ad.getString("date"));
				admin.setMontant(ad.getDouble("montant"));
				admin.setNumeroCompte(ad.getString("numeroCompte"));
				admin.setSoldeCompte(ad.getDouble("soldeCompte"));
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
	public List<Versement> readByMatiereId(int id) {
		
Connection conn = SingletonConnection.getConnection();
	
		
		List<Versement>administrateurs = new ArrayList<Versement>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  versement WHERE id = ?");
			ps.setInt(1,id);
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				Versement admin = new Versement();
				admin.setDate(ad.getString("date"));
				admin.setMontant(ad.getDouble("montant"));
				admin.setNumeroCompte(ad.getString("numeroCompte"));
				admin.setSoldeCompte(ad.getDouble("soldeCompte"));
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
			PreparedStatement ps = conn.prepareStatement("SELECT SUM(montant) AS prix_total FROM  versement");
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


