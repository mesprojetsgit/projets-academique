package com.app.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.connection.SingletonConnection;
import com.app.dao.IDaoClasse;
import com.app.metier.entites.Classe;

public class DaoClasseImpl implements IDaoClasse {

	@Override
	public void create(Classe admin) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO classe(nom,anneeScolaire,id_matiere)VALUES(?,?,?)");
			ps.setString(1, admin.getNom());
			ps.setString(2, admin.getAnneeScolaire());
			ps.setInt(3, admin.getId_matiere());
			ps.setInt(4, admin.getId());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Classe read(int id) {
		Connection conn = SingletonConnection.getConnection();
		Classe admin = new Classe();
	
		
	    try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  classe WHERE id = ? ");
			ps.setInt(1, id);
			ResultSet ad  = ps.executeQuery();
			if(ad.next()) {
				
				admin.setNom(ad.getString("nom"));
				admin.setAnneeScolaire(ad.getString("anneeScolaire"));
				admin.setId_matiere(ad.getInt("id_matiere"));
				
				
				ps.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return admin;
	}

	@Override
	public void update(Classe admin) {
    Connection conn = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE classe SET nom = ?,anneeScolaire = ? ,id_matiere= ?  WHERE id = ? ");
			ps.setString(1, admin.getNom());
			ps.setString(2, admin.getAnneeScolaire());
			ps.setInt(3, admin.getId_matiere());
			ps.setInt(4, admin.getId());
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
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM classe WHERE id= ? ");
			ps.setInt(1, id);
			ps.executeUpdate();
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

	}

	@Override
	public List<Classe> readByName(String name) {
		Connection conn = SingletonConnection.getConnection();
	
		
		List<Classe>administrateurs = new ArrayList<Classe>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  classe WHERE nom = ? OR prenom = ?");
			ps.setString(1,name);
			ps.setString(2,name);
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				Classe admin = new Classe();
				admin.setNom(ad.getString("nom"));
				admin.setAnneeScolaire(ad.getString("anneeScolaire"));
				admin.setId_matiere(ad.getInt("id_matiere"));
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
	public List<Classe> readByMatiereId(int id) {
    Connection conn = SingletonConnection.getConnection();
	
		
		List<Classe>administrateurs = new ArrayList<Classe>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  classe WHERE id_matiere = ?");
			ps.setInt(1,id);
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				Classe admin = new Classe();
				admin.setNom(ad.getString("nom"));
				admin.setAnneeScolaire(ad.getString("anneeScolaire"));
				admin.setId_matiere(ad.getInt("id_matiere"));
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
	public List<Classe> read() {
		   Connection conn = SingletonConnection.getConnection();
			
			
			List<Classe>administrateurs = new ArrayList<Classe>();
			try {
				PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  classe");
		
				ResultSet ad  = ps.executeQuery();	
				
				while(ad.next()) {
					
					Classe admin = new Classe();
					admin.setNom(ad.getString("nom"));
					admin.setAnneeScolaire(ad.getString("anneeScolaire"));
					admin.setId_matiere(ad.getInt("id_matiere"));
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
