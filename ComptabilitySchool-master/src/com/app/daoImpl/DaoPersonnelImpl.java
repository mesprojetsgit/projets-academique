package com.app.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.connection.SingletonConnection;
import com.app.dao.IDaoPersonnel;
import com.app.metier.entites.Personnel;
import com.app.metier.entites.Professeur;

public class DaoPersonnelImpl implements IDaoPersonnel {

	@Override
	public void create(Personnel admin) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO personnel(nom,prenom,email,sexe,numeroTel,addresse,numeroCINB,dateRecrutement,dateArret,salaire,poste)"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, admin.getNom());
			ps.setString(2, admin.getPrenom());
			ps.setString(3, admin.getEmail());
			ps.setString(4, admin.getGenre());
			ps.setString(5, admin.getNumeroTel());
			ps.setString(6, admin.getAddresse());
			ps.setString(7, admin.getNumeroCINB());
			ps.setString(8, admin.getDateRecrutement());
			ps.setString(9, admin.getDateArret());
			ps.setDouble(10, admin.getSalaire());
			ps.setString(11, admin.getPoste());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Personnel read(int id) {
		Connection conn = SingletonConnection.getConnection();
		Personnel admin = new Personnel();
		
	    try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  personnel WHERE id = ?");
			ps.setInt(1, id);
			ResultSet ad  = ps.executeQuery();
			if(ad.next()) {
				
				admin.setNom(ad.getString("nom"));
				admin.setPrenom(ad.getString("prenom"));
				admin.setEmail(ad.getString("email"));
				admin.setGenre(ad.getString("sexe"));
				admin.setNumeroTel(ad.getString("numeroTel"));
				admin.setAddresse(ad.getString("addresse"));
				admin.setNumeroCINB(ad.getString("numeroCINB"));
				admin.setDateRecrutement(ad.getString("dateRecrutement"));
				admin.setDateArret(ad.getString("dateArret"));
				admin.setSalaire(ad.getDouble("salaire"));
				admin.setPoste(ad.getString("poste"));
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
	public void update(Personnel admin) {
Connection conn = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE personnel SET nom = ?,prenom = ?,email = ?,sexe = ?,numeroTel = ?,addresse = ?,numeroCINB = ?,dateRecrutement = ?,dateArret = ? ,salaire = ?,poste=? WHERE id = ?");
			ps.setString(1, admin.getNom());
			ps.setString(2, admin.getPrenom());
			ps.setString(3, admin.getEmail());
			ps.setString(4, admin.getGenre());
			ps.setString(5, admin.getNumeroTel());
			ps.setString(6, admin.getAddresse());
			ps.setString(7, admin.getNumeroCINB());
			ps.setString(8, admin.getDateRecrutement());
			ps.setString(9, admin.getDateArret());
			ps.setDouble(10, admin.getSalaire());
			ps.setString(11, admin.getPoste());
			ps.setInt(12, admin.getId());

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
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM personnel WHERE id= ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	public List<Personnel> readByName(String name) {
		List<Personnel>administrateurs = new ArrayList<Personnel>();
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  personnel WHERE nom = ? OR prenom = ?");
			ps.setString(1,name);
			ps.setString(2,name);
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				Personnel admin = new Personnel();
				admin.setNom(ad.getString("nom"));
				admin.setPrenom(ad.getString("prenom"));
				admin.setEmail(ad.getString("email"));
				admin.setGenre(ad.getString("sexe"));
				admin.setNumeroTel(ad.getString("numeroTel"));
				admin.setAddresse(ad.getString("addresse"));
				admin.setNumeroCINB(ad.getString("numeroCINB"));
				admin.setDateRecrutement(ad.getString("dateRecrutement"));
				admin.setDateArret(ad.getString("dateArret"));
				admin.setSalaire(ad.getDouble("salaire"));	
				admin.setPoste(ad.getString("poste"));
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
	public List<Personnel> read() {
		List<Personnel>administrateurs = new ArrayList<Personnel>();
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  personnel ");
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				Personnel admin = new Personnel();
				admin.setNom(ad.getString("nom"));
				admin.setPrenom(ad.getString("prenom"));
				admin.setEmail(ad.getString("email"));
				admin.setGenre(ad.getString("sexe"));
				admin.setNumeroTel(ad.getString("numeroTel"));
				admin.setAddresse(ad.getString("addresse"));
				admin.setNumeroCINB(ad.getString("numeroCINB"));
				admin.setDateRecrutement(ad.getString("dateRecrutement"));
				admin.setDateArret(ad.getString("dateArret"));
				admin.setSalaire(ad.getDouble("salaire"));	
				admin.setPoste(ad.getString("poste"));
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
	public List<Personnel> readTri(String name) {
		List<Personnel>administrateurs = new ArrayList<Personnel>();
		PreparedStatement ps =null;
		Connection conn = SingletonConnection.getConnection();
		try {
			
			if (name.equals("nom")) {
				ps = conn.prepareStatement("SELECT * FROM personnel ORDER BY nom");

			}else if (name.equals("prenom")) {
				ps = conn.prepareStatement("SELECT * FROM personnel ORDER BY prenom");
			}
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				Personnel admin = new Personnel();
				admin.setNom(ad.getString("nom"));
				admin.setPrenom(ad.getString("prenom"));
				admin.setEmail(ad.getString("email"));
				admin.setGenre(ad.getString("sexe"));
				admin.setNumeroTel(ad.getString("numeroTel"));
				admin.setAddresse(ad.getString("addresse"));
				admin.setNumeroCINB(ad.getString("numeroCINB"));
				admin.setDateRecrutement(ad.getString("dateRecrutement"));
				admin.setDateArret(ad.getString("dateArret"));
				admin.setSalaire(ad.getDouble("salaire"));	
				admin.setPoste(ad.getString("poste"));
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
	public Personnel read(String nom, String prenom, String poste) {
		Connection conn = SingletonConnection.getConnection();
		Personnel admin = new Personnel();
		
	    try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  personnel WHERE nom = ? AND prenom = ? AND poste = ?");
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ps.setString(3, poste);
			ResultSet ad  = ps.executeQuery();
			if(ad.next()) {
				
				admin.setNom(ad.getString("nom"));
				admin.setPrenom(ad.getString("prenom"));
				admin.setEmail(ad.getString("email"));
				admin.setGenre(ad.getString("sexe"));
				admin.setNumeroTel(ad.getString("numeroTel"));
				admin.setAddresse(ad.getString("addresse"));
				admin.setNumeroCINB(ad.getString("numeroCINB"));
				admin.setDateRecrutement(ad.getString("dateRecrutement"));
				admin.setDateArret(ad.getString("dateArret"));
				admin.setSalaire(ad.getDouble("salaire"));
				admin.setPoste(ad.getString("poste"));
				admin.setId(ad.getInt("id"));
				ps.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return admin;

	}

}
