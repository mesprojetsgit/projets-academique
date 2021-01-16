package com.app.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.connection.SingletonConnection;
import com.app.dao.IDaoProffesseur;
import com.app.metier.entites.Eleve;
import com.app.metier.entites.Professeur;

public class DaoProfesseurImpl implements IDaoProffesseur {
	
	@Override
	public void create(Professeur admin) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO professeur(nom,prenom,nomClasse,nomMatiere,email,sexe,numeroTel,addresse,numeroCINB,dateRecrutement,dateArret,experience,type,montant,matricule)"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, admin.getNom());
			ps.setString(2, admin.getPrenom());
			ps.setString(3, admin.getNomClasse());
			ps.setString(4, admin.getNomMatiere());
			ps.setString(5, admin.getEmail());
			ps.setString(6, admin.getGenre());
			ps.setString(7, admin.getNumeroTel());
			ps.setString(8, admin.getAddresse());
			ps.setString(9, admin.getNumeroCINB());
			ps.setString(10, admin.getDateRecrutement());
			ps.setString(11, admin.getDateArret());
			ps.setString(12, admin.getExperience());
			ps.setString(13, admin.getType());
			ps.setDouble(14, admin.getMontant());
			ps.setString(15, admin.getMatricule());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Professeur read(int id) {
		Connection conn = SingletonConnection.getConnection();
		Professeur admin = new Professeur();
		
	    try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  professeur WHERE id = ?");
			ps.setInt(1, id);
			ResultSet ad  = ps.executeQuery();
			if(ad.next()) {
				
				admin.setNom(ad.getString("nom"));
				admin.setPrenom(ad.getString("prenom"));
				admin.setNomClasse(ad.getString("nomClasse"));
				admin.setNomMatiere(ad.getString("nomMatiere"));
				admin.setEmail(ad.getString("email"));
				admin.setGenre(ad.getString("sexe"));
				admin.setNumeroTel(ad.getString("numeroTel"));
				admin.setAddresse(ad.getString("addresse"));
				admin.setNumeroCINB(ad.getString("numeroCINB"));
				admin.setDateRecrutement(ad.getString("dateRecrutement"));
				admin.setDateArret(ad.getString("dateArret"));
				admin.setExperience(ad.getString("experience"));
				admin.setType(ad.getString("type"));
				admin.setMontant(ad.getDouble("montant"));
				admin.setMatricule(ad.getString("matricule"));
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
	public void update(Professeur admin) {
Connection conn = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE professeur SET nom = ?,prenom = ?,nomClasse = ?,nomMatiere = ?,email = ?,sexe = ?,numeroTel = ?,addresse = ?,numeroCINB = ?,dateRecrutement = ?,dateArret = ? ,experience = ? ,type = ?,montant = ?,matricule = ? WHERE id = ?");
			ps.setString(1, admin.getNom());
			ps.setString(2, admin.getPrenom());
			ps.setString(3, admin.getNomClasse());
			ps.setString(4, admin.getNomMatiere());
			ps.setString(5, admin.getEmail());
			ps.setString(6, admin.getGenre());
			ps.setString(7, admin.getNumeroTel());
			ps.setString(8, admin.getAddresse());
			
			ps.setString(9, admin.getNumeroCINB());
			ps.setString(10, admin.getDateRecrutement());
			ps.setString(11, admin.getDateArret());
			ps.setString(12, admin.getExperience());
			ps.setString(13, admin.getType());
			ps.setDouble(14, admin.getMontant());
			ps.setString(15, admin.getMatricule());
			
			ps.setInt(16, admin.getId());

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
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM professeur WHERE id= ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	public List<Professeur> readByName(String name) {
		List<Professeur>administrateurs = new ArrayList<Professeur>();
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  professeur WHERE nom = ? OR prenom = ?");
			ps.setString(1,name);
			ps.setString(2,name);
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				Professeur admin = new Professeur();
				admin.setNom(ad.getString("nom"));
				admin.setPrenom(ad.getString("prenom"));
				admin.setNomClasse(ad.getString("nomClasse"));
				admin.setNomMatiere(ad.getString("nomMatiere"));
				admin.setEmail(ad.getString("email"));
				admin.setGenre(ad.getString("sexe"));
				admin.setNumeroTel(ad.getString("numeroTel"));
				admin.setAddresse(ad.getString("addresse"));
				admin.setNumeroCINB(ad.getString("numeroCINB"));
				admin.setDateRecrutement(ad.getString("dateRecrutement"));
				admin.setDateArret(ad.getString("dateArret"));
				admin.setExperience(ad.getString("experience"));
				admin.setType(ad.getString("type"));
				admin.setMontant(ad.getDouble("montant"));
				admin.setMatricule(ad.getString("matricule"));
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
	public List<Professeur> read() {
		List<Professeur>administrateurs = new ArrayList<Professeur>();
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  professeur ");
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				Professeur admin = new Professeur();
				admin.setNom(ad.getString("nom"));
				admin.setPrenom(ad.getString("prenom"));
				admin.setNomClasse(ad.getString("nomClasse"));
				admin.setNomMatiere(ad.getString("nomMatiere"));
				admin.setEmail(ad.getString("email"));
				admin.setGenre(ad.getString("sexe"));
				admin.setNumeroTel(ad.getString("numeroTel"));
				admin.setAddresse(ad.getString("addresse"));
				admin.setNumeroCINB(ad.getString("numeroCINB"));
				admin.setDateRecrutement(ad.getString("dateRecrutement"));
				admin.setDateArret(ad.getString("dateArret"));
				admin.setExperience(ad.getString("experience"));
				admin.setType(ad.getString("type"));
				admin.setMontant(ad.getDouble("montant"));
				admin.setMatricule(ad.getString("matricule"));
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
	public List<Professeur> readTriByNomClasse(String nom) {
		List<Professeur>administrateurs = new ArrayList<Professeur>();
		Connection conn = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM professeur ORDER BY nomClasse  ");
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				Professeur admin = new Professeur();
				admin.setNom(ad.getString("nom"));
				admin.setPrenom(ad.getString("prenom"));
				admin.setNomClasse(ad.getString("nomClasse"));
				admin.setNomMatiere(ad.getString("nomMatiere"));
				admin.setEmail(ad.getString("email"));
				admin.setGenre(ad.getString("sexe"));
				admin.setNumeroTel(ad.getString("numeroTel"));
				admin.setAddresse(ad.getString("addresse"));
				admin.setNumeroCINB(ad.getString("numeroCINB"));
				admin.setDateRecrutement(ad.getString("dateRecrutement"));
				admin.setDateArret(ad.getString("dateArret"));
				admin.setExperience(ad.getString("experience"));
				admin.setType(ad.getString("type"));
				admin.setMontant(ad.getDouble("montant"));
				admin.setMatricule(ad.getString("matricule"));
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
	public List<Professeur> readTriByNomMatiere(String nom) {
		List<Professeur>administrateurs = new ArrayList<Professeur>();
		Connection conn = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM professeur ORDER BY nomMatiere  ");
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				Professeur admin = new Professeur();
				admin.setNom(ad.getString("nom"));
				admin.setPrenom(ad.getString("prenom"));
				admin.setNomClasse(ad.getString("nomClasse"));
				admin.setNomMatiere(ad.getString("nomMatiere"));
				admin.setEmail(ad.getString("email"));
				admin.setGenre(ad.getString("sexe"));
				admin.setNumeroTel(ad.getString("numeroTel"));
				admin.setAddresse(ad.getString("addresse"));
				admin.setNumeroCINB(ad.getString("numeroCINB"));
				admin.setDateRecrutement(ad.getString("dateRecrutement"));
				admin.setDateArret(ad.getString("dateArret"));
				admin.setExperience(ad.getString("experience"));
				admin.setType(ad.getString("type"));
				admin.setMontant(ad.getDouble("montant"));
				admin.setMatricule(ad.getString("matricule"));
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
	public Professeur read(String nom, String prenom, String nomClasse, String nomMatiere, String type) {
		Connection conn = SingletonConnection.getConnection();
		Professeur admin = new Professeur();
		
	    try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  professeur WHERE nom = ? AND prenom = ? AND nomClasse = ? AND nomMatiere = ? AND type = ?");
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ps.setString(3, nomClasse);
			ps.setString(4, nomMatiere);
			ps.setString(5, type);
			ResultSet ad  = ps.executeQuery();
			if(ad.next()) {
				
				admin.setNom(ad.getString("nom"));
				admin.setPrenom(ad.getString("prenom"));
				admin.setNomClasse(ad.getString("nomClasse"));
				admin.setNomMatiere(ad.getString("nomMatiere"));
				admin.setEmail(ad.getString("email"));
				admin.setGenre(ad.getString("sexe"));
				admin.setNumeroTel(ad.getString("numeroTel"));
				admin.setAddresse(ad.getString("addresse"));
				admin.setNumeroCINB(ad.getString("numeroCINB"));
				admin.setDateRecrutement(ad.getString("dateRecrutement"));
				admin.setDateArret(ad.getString("dateArret"));
				admin.setExperience(ad.getString("experience"));
				admin.setType(ad.getString("type"));
				admin.setMontant(ad.getDouble("montant"));
				admin.setMatricule(ad.getString("matricule"));
				
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
