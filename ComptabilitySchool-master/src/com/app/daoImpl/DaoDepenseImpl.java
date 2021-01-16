package com.app.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.connection.SingletonConnection;
import com.app.dao.IDaoDepense;
import com.app.metier.entites.Depense;

public class DaoDepenseImpl implements IDaoDepense {

	@Override
	public void create(Depense admin) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO depense(montant,date,modePaiement,anneeScolaire,motif)VALUES(?,?,?,?,?)");
			ps.setDouble(1, admin.getMontant());
			ps.setString(2, admin.getDate());
			ps.setString(3, admin.getModePaiement());
			ps.setString(4, admin.getAnneeScolaire());
			ps.setString(5, admin.getMotif());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Depense read(int id) {
		Connection conn = SingletonConnection.getConnection();
		Depense admin = new Depense();
	
		
	    try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  depense WHERE id = ? ");
			ps.setInt(1, id);
			ResultSet ad  = ps.executeQuery();
			if(ad.next()) {
				
				admin.setId(ad.getInt("id"));
				admin.setMontant(ad.getDouble("montant"));
				admin.setDate(ad.getString("date"));
				admin.setModePaiement(ad.getString("modePaiement"));
				admin.setAnneeScolaire(ad.getString("anneeScolaire"));
				admin.setMotif(ad.getString("motif"));
				ps.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return admin;
	}

	@Override
	public void update(Depense admin) {
    Connection conn = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE depense SET montant = ?,date = ?,modePaiement = ?,anneeScolaire = ?,motif = ? WHERE id = ? ");
			ps.setDouble(1, admin.getMontant());
			ps.setString(2, admin.getDate());
			ps.setString(3, admin.getModePaiement());
			ps.setString(4, admin.getAnneeScolaire());
			ps.setString(5, admin.getMotif());
			ps.setInt(6, admin.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Override
	public void delete(int id){
		Connection conn = SingletonConnection.getConnection();
		try {
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM depense WHERE id= ? ");
			ps.setInt(1, id);
			ps.executeUpdate();
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

	}

	@Override
	public List<Depense> readByName(String name) {
		Connection conn = SingletonConnection.getConnection();
	
		
		List<Depense>administrateurs = new ArrayList<Depense>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  depense ");
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				String mois = ad.getString("date");
				
				if(mois.contains(name)) {
				
				Depense admin = new Depense();
				admin.setMontant(ad.getDouble("montant"));
				admin.setDate(ad.getString("date"));
				admin.setModePaiement(ad.getString("modePaiement"));
				admin.setAnneeScolaire(ad.getString("anneeScolaire"));
				admin.setMotif(ad.getString("motif"));
				admin.setId(ad.getInt("id"));
			    administrateurs.add(admin);
			    
				}else if(name.equals("tout")) {
					Depense admin = new Depense();
					admin.setMontant(ad.getDouble("montant"));
					admin.setDate(ad.getString("date"));
					admin.setModePaiement(ad.getString("modePaiement"));
					admin.setAnneeScolaire(ad.getString("anneeScolaire"));
					admin.setMotif(ad.getString("motif"));
					admin.setId(ad.getInt("id"));
				    administrateurs.add(admin);	
				}
					
			}
		    ps.close();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return administrateurs;
	}

	@Override
	public List<Depense> getAll() {
     Connection conn = SingletonConnection.getConnection();
	
		
		List<Depense>administrateurs = new ArrayList<Depense>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  depense ORDER BY date");
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				Depense admin = new Depense();
				admin.setId(ad.getInt("id"));
				admin.setMontant(ad.getDouble("montant"));
				admin.setDate(ad.getString("date"));
				admin.setModePaiement(ad.getString("modePaiement"));
				admin.setAnneeScolaire(ad.getString("anneeScolaire"));
				admin.setMotif(ad.getString("motif"));
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
	public List<Depense> trieBy(String mois) {
    Connection conn = SingletonConnection.getConnection();
	
		
		List<Depense>administrateurs = new ArrayList<Depense>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  depense ORDER BY date");
			
						
				
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				Depense admin = new Depense();
				admin.setId(ad.getInt("id"));
				admin.setMontant(ad.getDouble("montant"));
				admin.setDate(ad.getString("date"));
				admin.setModePaiement(ad.getString("modePaiement"));
				admin.setAnneeScolaire(ad.getString("anneeScolaire"));
				admin.setMotif(ad.getString("motif"));
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
	public double sommeMontant() {
		Connection conn = SingletonConnection.getConnection();
		double somme=0;
	
		
	    try {
			PreparedStatement ps = conn.prepareStatement("SELECT SUM(montant) AS prix_total FROM  depense");
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
