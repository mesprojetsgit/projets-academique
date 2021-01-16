package com.app.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.connection.SingletonConnection;
import com.app.dao.IDaoComptable;
import com.app.metier.entites.Comptable;

public class DaoComptableImpl implements IDaoComptable {

	public void create (Comptable admin ) {
		
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO comptable(nom,prenom,email,sexe,numeroTel,addresse,numeroCINB,login,password)VALUES(?,?,?,?,?,?,?,?,?)");
			ps.setString(1, admin.getNom());
			ps.setString(2, admin.getPrenom());
			ps.setString(3, admin.getEmail());
			ps.setString(4, admin.getSexe());
			ps.setString(5, admin.getNumeroTel());
			ps.setString(6, admin.getAddresse());
			ps.setString(7, admin.getNumeroCINB());
			ps.setString(8, admin.getLogin());
			ps.setString(9, admin.getPassword());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public Comptable read(int id) {
		Connection conn = SingletonConnection.getConnection();
		Comptable admin = new Comptable();
		
	    try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  comptable WHERE id = ?");
			ps.setInt(1, id);
			ResultSet ad  = ps.executeQuery();
			if(ad.next()) {
				
				admin.setNom(ad.getString("nom"));
				admin.setPrenom(ad.getString("prenom"));
				admin.setEmail(ad.getString("email"));
				admin.setSexe(ad.getString("sexe"));
				admin.setNumeroTel(ad.getString("numeroTel"));
				admin.setAddresse(ad.getString("addresse"));
				admin.setNumeroCINB(ad.getString("numeroCINB"));
				admin.setLogin(ad.getString("login"));
				admin.setPassword(ad.getString("password"));
				
			
				ps.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return admin;
	}

	public void update(Comptable admin) {
		
		Connection conn = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE comptable SET nom = ?,prenom = ?,email = ?,sexe = ?,numeroTel = ?,addresse = ?,numeroCINB = ?,login = ?,password = ? WHERE id = ?");
			ps.setString(1,admin.getNom());
			ps.setString(2,admin.getPrenom());
			ps.setString(3,admin.getEmail());
			ps.setString(4,admin.getSexe());
			ps.setString(5,admin.getNumeroTel());
			ps.setString(6,admin.getAddresse());
			ps.setString(7,admin.getNumeroTel());
			ps.setString(8,admin.getLogin());
			ps.setString(9,admin.getPassword());
			ps.setInt(10, admin.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void delete(int id) {
		
		Connection conn = SingletonConnection.getConnection();
		try {
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM comptable WHERE id= ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

	}

	public List<Comptable> readByName(String name) {
		List<Comptable>administrateurs = new ArrayList<Comptable>();
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  comptable WHERE nom = ? OR prenom = ?");
			ps.setString(1,name);
			ps.setString(2,name);
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				Comptable admin = new Comptable();
			admin.setNom(ad.getString("nom"));
			admin.setPrenom(ad.getString("prenom"));
			admin.setEmail(ad.getString("email"));
			admin.setSexe(ad.getString("sexe"));
			admin.setNumeroTel(ad.getString("numeroTel"));
			admin.setAddresse(ad.getString("addresse"));
			admin.setNumeroCINB(ad.getString("numeroCINB"));
			admin.setLogin(ad.getString("login"));
			admin.setPassword(ad.getString("password"));
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
	public List<Comptable> read() {
		List<Comptable>administrateurs = new ArrayList<Comptable>();
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  comptable");
	
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
			Comptable admin = new Comptable();
			admin.setNom(ad.getString("nom"));
			admin.setPrenom(ad.getString("prenom"));
			admin.setEmail(ad.getString("email"));
			admin.setSexe(ad.getString("sexe"));
			admin.setNumeroTel(ad.getString("numeroTel"));
			admin.setAddresse(ad.getString("addresse"));
			admin.setNumeroCINB(ad.getString("numeroCINB"));
			admin.setLogin(ad.getString("login"));
			admin.setPassword(ad.getString("password"));
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
	public List<Comptable> readByLoginPassword(String login, String password) {
		List<Comptable>administrateurs = new ArrayList<Comptable>();
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  comptable WHERE login = ? AND password = ?");
			ps.setString(1,login);
			ps.setString(2,password);
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				Comptable admin = new Comptable();
			admin.setNom(ad.getString("nom"));
			admin.setPrenom(ad.getString("prenom"));
			admin.setEmail(ad.getString("email"));
			admin.setSexe(ad.getString("sexe"));
			admin.setNumeroTel(ad.getString("numeroTel"));
			admin.setAddresse(ad.getString("addresse"));
			admin.setNumeroCINB(ad.getString("numeroCINB"));
			admin.setLogin(ad.getString("login"));
			admin.setPassword(ad.getString("password"));
			admin.setId(ad.getInt("id"));
			administrateurs.add(admin);
					
			}
		    ps.close();
			
			} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return administrateurs;
	}

}
