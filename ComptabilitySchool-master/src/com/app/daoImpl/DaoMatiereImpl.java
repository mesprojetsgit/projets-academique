package com.app.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.connection.SingletonConnection;
import com.app.dao.IDaoMatiere;
import com.app.metier.entites.Matiere;

public class DaoMatiereImpl implements IDaoMatiere {
	
	@Override
	public void create(Matiere admin) {

	Connection conn = SingletonConnection.getConnection();
	try {
		PreparedStatement ps = conn.prepareStatement("INSERT INTO matiere(nom,prixHoraire,id_classe,id_professeur)VALUES(?,?,?,?)");
		ps.setString(1, admin.getNom());
		ps.setDouble(2, admin.getPrixHoraire());
		ps.setInt(3, admin.getId_classe());
		ps.setInt(4, admin.getId_professeur());
		ps.executeUpdate();
		ps.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}


@Override
public void update(Matiere admin) {
Connection conn = SingletonConnection.getConnection();
	
	try {
		PreparedStatement ps = conn.prepareStatement("UPDATE matiere SET nom = ?,prixHoraire = ?,id_classe = ?,id_professeur = ? WHERE id = ?");
		ps.setString(1,admin.getNom());
		ps.setDouble(2,admin.getPrixHoraire());
		ps.setInt(3, admin.getId_classe());
		ps.setInt(4, admin.getId_professeur());
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
		
		PreparedStatement ps = conn.prepareStatement("DELETE FROM matiere WHERE id= ?");
		ps.setInt(1, id);
		ps.executeUpdate();
		
		ps.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		

}

@Override
public List<Matiere> readByName(String name) {
	Connection conn = SingletonConnection.getConnection();
	List<Matiere>administrateurs = new ArrayList<Matiere>();
	try {
		PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  matiere WHERE nom = ? OR prenom = ?");
		ps.setString(1,name);
		ps.setString(2,name);
		ResultSet ad  = ps.executeQuery();	
		
		while(ad.next()) {
			
			Matiere admin = new Matiere();
			admin.setNom(ad.getString("nom"));
			admin.setPrixHoraire(ad.getDouble("prixHoraire"));
			admin.setId_classe(ad.getInt("id_classe"));
			admin.setId_professeur(ad.getInt("id_professeur"));
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
public Matiere read(int id) {
	Connection conn = SingletonConnection.getConnection();
	Matiere admin = new Matiere();

    try {
		PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  matiere WHERE id = ?");
		ps.setInt(1, id);
		ResultSet ad  = ps.executeQuery();
		if(ad.next()) {
			
			admin.setNom(ad.getString("nom"));
			admin.setPrixHoraire(ad.getDouble("prixHoraire"));
			admin.setId_classe(ad.getInt("id_classe"));
			admin.setId_professeur(ad.getInt("id_professeur"));
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
public List<Matiere> read() {
	Connection conn = SingletonConnection.getConnection();
	List<Matiere>administrateurs = new ArrayList<Matiere>();
	try {
		PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  matiere ");

		ResultSet ad  = ps.executeQuery();	
		
		while(ad.next()) {
			
			Matiere admin = new Matiere();
			admin.setNom(ad.getString("nom"));
			admin.setPrixHoraire(ad.getDouble("prixHoraire"));
			admin.setId_classe(ad.getInt("id_classe"));
			admin.setId_professeur(ad.getInt("id_professeur"));
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
	
}


	


