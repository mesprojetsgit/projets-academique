package com.app.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.connection.SingletonConnection;
import com.app.dao.IDaoHoraireTotal;
import com.app.metier.entites.HoraireTotal;

public class DaoHoraireTotalImpl implements IDaoHoraireTotal {

	@Override
	public void create(HoraireTotal admin) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO horairetotal(nombreHoraire,periodeHoraire,id_matiere)VALUES(?,?,?)");
			ps.setDouble(1, admin.getNombreHoraire());
			ps.setString(2, admin.getPeriodeHoraire());
			ps.setLong(3, admin.getId_matiere());
			
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public HoraireTotal read(int id) {
		Connection conn = SingletonConnection.getConnection();
		HoraireTotal admin = new HoraireTotal();
	
		
	    try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  horairetotal WHERE id = ?");
			ps.setInt(1, id);
			ResultSet ad  = ps.executeQuery();
			if(ad.next()) {
				
				admin.setNombreHoraire(ad.getLong("nombreHoraire"));
				admin.setPeriodeHoraire(ad.getString("periodeHoraire"));
				admin.setId_matiere(ad.getLong("id_matiere"));

				
				ps.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return admin;
	}

	@Override
	public void update(HoraireTotal admin) {
Connection conn = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE horairetotal SET nombreHoraire = ?,periodeHoraire = ?,id_matiere = ?  WHERE id = ?");
			ps.setDouble(1, admin.getNombreHoraire());
			ps.setString(2, admin.getPeriodeHoraire());
			ps.setLong(3, admin.getId_matiere());
			ps.setLong(4, admin.getId());

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
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM horairetotal WHERE id= ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

	}

	@Override
	public List<HoraireTotal> readByName(String name) {
		Connection conn = SingletonConnection.getConnection();
	
		
		List<HoraireTotal>administrateurs = new ArrayList<HoraireTotal>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  horairetotal WHERE nom = ? OR prenom = ?");
			ps.setString(1,name);
			ps.setString(2,name);
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				HoraireTotal admin = new HoraireTotal();
				admin.setNombreHoraire(ad.getLong("nombreHoraire"));
				admin.setPeriodeHoraire(ad.getString("periodeHoraire"));
				admin.setId_matiere(ad.getLong("id_matiere"));

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
	public List<HoraireTotal> readByMatiereId(int id) {
	Connection conn = SingletonConnection.getConnection();
	
		
		List<HoraireTotal>administrateurs = new ArrayList<HoraireTotal>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  horairetotal WHERE id_matiere = ?");
			ps.setInt(1,id);

			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				HoraireTotal admin = new HoraireTotal();
				admin.setNombreHoraire(ad.getLong("nombreHoraire"));
				admin.setPeriodeHoraire(ad.getString("periodeHoraire"));
				admin.setId_matiere(ad.getLong("id_matiere"));

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
	public List<HoraireTotal> read() {
	Connection conn = SingletonConnection.getConnection();
	
		
		List<HoraireTotal>administrateurs = new ArrayList<HoraireTotal>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  horairetotal");
			
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				HoraireTotal admin = new HoraireTotal();
				admin.setNombreHoraire(ad.getLong("nombreHoraire"));
				admin.setPeriodeHoraire(ad.getString("periodeHoraire"));
				admin.setId_matiere(ad.getLong("id_matiere"));

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
