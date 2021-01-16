package com.app.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.connection.SingletonConnection;
import com.app.dao.IDaoPaiementAuxiliaire;
import com.app.metier.entites.PaiementAuxiliaire;

public class DaoPaiementAuxiliaire implements IDaoPaiementAuxiliaire {

	@Override
	public void create(PaiementAuxiliaire admin) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO paiementauxiliaire(matricule,nom,prenom,classe,statut,montant,description,commentaire)"
					+ "VALUES(?,?,?,?,?,?,?,?)");
			ps.setString(1, admin.getMatricule());
			ps.setString(2, admin.getNom());
			ps.setString(3, admin.getPrenom());
			ps.setString(4, admin.getClasse());
			ps.setString(5, admin.getStatus());
			ps.setDouble(6, admin.getMontant());
			ps.setString(7, admin.getDescription());
			ps.setString(8, admin.getCommentaire());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public PaiementAuxiliaire read(int id) {
		Connection conn = SingletonConnection.getConnection();
		PaiementAuxiliaire admin = new PaiementAuxiliaire();
		
	    try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  paiementauxiliaire WHERE id = ?");
			ps.setInt(1, id);
			ResultSet ad  = ps.executeQuery();
			if(ad.next()) {
				
				admin.setMatricule(ad.getString("matricule"));
				admin.setNom(ad.getString("nom"));
				admin.setPrenom(ad.getString("prenom"));
				admin.setClasse(ad.getString("classe"));
				admin.setStatus(ad.getString("statut"));
				admin.setMontant(ad.getDouble("montant"));
			    admin.setDescription(ad.getString("description"));
				admin.setCommentaire(ad.getString("commentaire"));
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
	public void update(PaiementAuxiliaire admin) {
Connection conn = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE paiementauxiliaire SET matricule = ?,nom = ?,prenom = ? ,classe = ?,statut = ?,montant = ?,description = ?,commentaire = ?  WHERE id = ?");
			ps.setString(1, admin.getMatricule());
			ps.setString(2, admin.getNom());
			ps.setString(3, admin.getPrenom());
			ps.setString(4, admin.getClasse());
			ps.setString(5, admin.getStatus());
			ps.setDouble(6, admin.getMontant());
			ps.setString(7, admin.getDescription());
			ps.setString(8, admin.getCommentaire());
			ps.setInt(9, admin.getId());

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
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM paiementauxiliaire WHERE id= ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	@Override
	public List<PaiementAuxiliaire> read() {
		List<PaiementAuxiliaire>administrateurs = new ArrayList<PaiementAuxiliaire>();
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  paiementauxiliaire ");
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				PaiementAuxiliaire admin = new PaiementAuxiliaire();
				admin.setMatricule(ad.getString("matricule"));
				admin.setNom(ad.getString("nom"));
				admin.setPrenom(ad.getString("prenom"));
				admin.setClasse(ad.getString("classe"));
				admin.setStatus(ad.getString("statut"));
				admin.setMontant(ad.getDouble("montant"));
			    admin.setDescription(ad.getString("description"));
				admin.setCommentaire(ad.getString("commentaire"));
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
