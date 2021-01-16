package com.app.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.connection.SingletonConnection;
import com.app.dao.IDaoPoste;
import com.app.metier.entites.Poste;

public class DaoPosteImpl implements IDaoPoste {

	@Override
	public void create(Poste admin) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO poste(nom,description,id_personnel)VALUES(?,?,?)");
			ps.setString(1, admin.getNom());
			ps.setString(2, admin.getDescription());
			ps.setLong(3, admin.getId_personnel());
			
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Poste read(int id) {
		Connection conn = SingletonConnection.getConnection();
		Poste admin = new Poste();
	
		
	    try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  poste WHERE id = ?");
			ps.setInt(1, id);
			ResultSet ad  = ps.executeQuery();
			if(ad.next()) {
				
				admin.setNom(ad.getString("nom"));
				admin.setDescription(ad.getString("description"));
				admin.setId_personnel(ad.getLong("id_personnel"));

				
				ps.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return admin;
	}

	@Override
	public void update(Poste admin) {
Connection conn = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE poste SET nom = ?,description = ?,id_personnel = ?  WHERE id = ?");
			ps.setString(1, admin.getNom());
			ps.setString(2, admin.getDescription());
			ps.setLong(3, admin.getId_personnel());
			ps.setLong(3, admin.getId());
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
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM poste WHERE id= ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

	}

	@Override
	public List<Poste> readByName(String name) {
		Connection conn = SingletonConnection.getConnection();
	
		
		List<Poste>administrateurs = new ArrayList<Poste>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  poste WHERE nom = ? OR prenom = ?");
			ps.setString(1,name);
			ps.setString(2,name);
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				Poste admin = new Poste();
				admin.setNom(ad.getString("nom"));
				admin.setDescription(ad.getString("description"));
				admin.setId_personnel(ad.getLong("id_personnel"));
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
	public List<Poste> readByPersonelId(int id) {
    Connection conn = SingletonConnection.getConnection();
	
		
		List<Poste>administrateurs = new ArrayList<Poste>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  poste ");
			
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				Poste admin = new Poste();
				admin.setNom(ad.getString("nom"));
				admin.setDescription(ad.getString("description"));
				admin.setId_personnel(ad.getLong("id_personnel"));
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
	public List<Poste> read() {
    Connection conn = SingletonConnection.getConnection();
	
		
		List<Poste>administrateurs = new ArrayList<Poste>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  poste ");
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				Poste admin = new Poste();
				admin.setNom(ad.getString("nom"));
				admin.setDescription(ad.getString("description"));
				admin.setId_personnel(ad.getLong("id_personnel"));
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
