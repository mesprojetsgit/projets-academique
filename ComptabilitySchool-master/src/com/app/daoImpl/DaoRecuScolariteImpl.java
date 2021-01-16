package com.app.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.connection.SingletonConnection;
import com.app.dao.IDaoRecuScolarite;
import com.app.metier.entites.RecuScolarite;

public class DaoRecuScolariteImpl implements IDaoRecuScolarite {

	@Override
	public void create(RecuScolarite admin) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO recuscolarite(nomEleve,id_paiementScolarite,id_eleve)VALUES(?,?,?)");
			ps.setString(1, admin.getNomEleve());
			ps.setInt(2, admin.getId_paiementScolarite());
			ps.setInt(2, admin.getId_eleve());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public RecuScolarite read(int id ) {
		Connection conn = SingletonConnection.getConnection();
		RecuScolarite admin = new RecuScolarite();
		
	    try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  recuscolarite WHERE id = ?");
			ps.setInt(1, id);
			ResultSet ad  = ps.executeQuery();
			if(ad.next()) {
				
				admin.setNomEleve(ad.getString("nomEleve"));
				admin.setId_paiementScolarite(ad.getInt("id_paiementScolarite"));
				admin.setId_eleve(ad.getInt("id_eleve"));

				ps.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return admin;
	}

	@Override
	public void update(RecuScolarite admin) {
Connection conn = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE recuscolarite SET nomEleve = ?,id_paiementScolarite = ?,id_eleve = ?  WHERE id = ?");
			ps.setString(1, admin.getNomEleve());
			ps.setInt(2, admin.getId_paiementScolarite());
			ps.setInt(3, admin.getId_eleve());
			ps.setInt(4, admin.getId());
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
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM recuscolarite WHERE id= ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

	}

	@Override
	public List<RecuScolarite> readByName(String name) {
		Connection conn = SingletonConnection.getConnection();
		
		List<RecuScolarite>administrateurs = new ArrayList<RecuScolarite>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  recuscolarite WHERE nomEleve = ? ");
			ps.setString(1,name);
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				RecuScolarite admin = new RecuScolarite();
				admin.setNomEleve(ad.getString("nomEleve"));
				admin.setId_paiementScolarite(ad.getInt("id_paiementScolarite"));
				admin.setId_paiementScolarite(ad.getInt("id_eleve"));

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
	public List<RecuScolarite> read() {
    Connection conn = SingletonConnection.getConnection();
		
		List<RecuScolarite>administrateurs = new ArrayList<RecuScolarite>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  recuscolarite ");
		
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				RecuScolarite admin = new RecuScolarite();
				admin.setNomEleve(ad.getString("nomEleve"));
				admin.setId_paiementScolarite(ad.getInt("id_paiementScolarite"));
				admin.setId_paiementScolarite(ad.getInt("id_eleve"));

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
	public List<RecuScolarite> readByPaiementId(int id) {
     Connection conn = SingletonConnection.getConnection();
		
		List<RecuScolarite>administrateurs = new ArrayList<RecuScolarite>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  recuscolarite WHERE id_paiementScolarite = ? ");
			ps.setInt(1,id);
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				RecuScolarite admin = new RecuScolarite();
				admin.setNomEleve(ad.getString("nomEleve"));
				admin.setId_paiementScolarite(ad.getInt("id_paiementScolarite"));
				admin.setId_paiementScolarite(ad.getInt("id_eleve"));

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
	public List<RecuScolarite> readByEleveId(int id) {
	     Connection conn = SingletonConnection.getConnection();
			
			List<RecuScolarite>administrateurs = new ArrayList<RecuScolarite>();
			try {
				PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  recuscolarite WHERE id_eleve = ? ");
				ps.setInt(1,id);
				ResultSet ad  = ps.executeQuery();	
				
				while(ad.next()) {
					
					RecuScolarite admin = new RecuScolarite();
					admin.setNomEleve(ad.getString("nomEleve"));
					admin.setId_paiementScolarite(ad.getInt("id_paiementScolarite"));
					admin.setId_paiementScolarite(ad.getInt("id_eleve"));

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
