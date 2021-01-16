package com.app.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.connection.SingletonConnection;
import com.app.dao.IDaoPaiement;
import com.app.metier.entites.Paiement;

public class DaoPaiementImpl implements IDaoPaiement {

	@Override
	public void create(Paiement admin) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO paiement(date,mois,modePaiement,montant,id_employer)VALUES(?,?,?,?,?)");
			ps.setString(1, admin.getDate());
			ps.setString(2, admin.getMois());
			ps.setString(3, admin.getModePaiement());
			ps.setDouble(4, admin.getMontant());
			ps.setLong(4, admin.getId_employer());
			
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Paiement read(int id) {
		Connection conn = SingletonConnection.getConnection();
		Paiement admin = new Paiement();
		
	    try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  paiement WHERE id = ?");
			ps.setInt(1, id);
			ResultSet ad  = ps.executeQuery();
			if(ad.next()) {
				
				admin.setDate(ad.getString("date"));
				admin.setMois(ad.getString("mois"));
				admin.setModePaiement(ad.getString("modePaiement"));
				admin.setMontant(ad.getDouble("montant"));
				admin.setId_employer(ad.getInt("id_empployer"));
				
				ps.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return admin;
	}

	@Override
	public void update(Paiement admin) {
Connection conn = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE paiement SET date = ?,mois = ?,modePaiement = ?,montant = ? ,id_employer = ? WHERE id = ?");
			ps.setString(1,admin.getDate());
			ps.setString(2,admin.getMois());
			ps.setString(3,admin.getModePaiement());
			ps.setDouble(4,admin.getMontant());
			ps.setInt(5, admin.getId_employer());
			ps.setInt(6, admin.getId());

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
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM paiement WHERE id= ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

	}

	@Override
	public List<Paiement> readByName(String name) {
		Connection conn = SingletonConnection.getConnection();
		List<Paiement>administrateurs = new ArrayList<Paiement>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  paiement WHERE nom = ? OR prenom = ?");
			ps.setString(1,name);
			ps.setString(2,name);
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				Paiement admin = new Paiement();
				admin.setDate(ad.getString("date"));
				admin.setMois(ad.getString("mois"));
				admin.setModePaiement(ad.getString("modePaiement"));
				admin.setMontant(ad.getDouble("montant"));
			    admin.setId_employer(ad.getInt("id_employer"));
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
	public List<Paiement> readByEmployerId(int id) {
		Connection conn = SingletonConnection.getConnection();
		List<Paiement>administrateurs = new ArrayList<Paiement>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  paiement WHERE id_employer =?");
			ps.setInt(1,id);
			
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				Paiement admin = new Paiement();
				admin.setDate(ad.getString("date"));
				admin.setMois(ad.getString("mois"));
				admin.setModePaiement(ad.getString("modePaiement"));
				admin.setMontant(ad.getDouble("montant"));
			    admin.setId_employer(ad.getInt("id_employer"));
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
	public List<Paiement> read() {
		Connection conn = SingletonConnection.getConnection();
		List<Paiement>administrateurs = new ArrayList<Paiement>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  paiement");
			
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				Paiement admin = new Paiement();
				admin.setDate(ad.getString("date"));
				admin.setMois(ad.getString("mois"));
				admin.setModePaiement(ad.getString("modePaiement"));
				admin.setMontant(ad.getDouble("montant"));
			    admin.setId_employer(ad.getInt("id_employer"));
			    administrateurs.add(admin);
					
			}
		    ps.close();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return administrateurs;
	}
	}


