package com.app.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.connection.SingletonConnection;
import com.app.dao.IDaoPaiementScolarite;
import com.app.metier.entites.Eleve;
import com.app.metier.entites.PaiementScolarite;

public class DaoPaiementScolarite implements IDaoPaiementScolarite {

	@Override
	public void create(PaiementScolarite admin) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO paiementscolarite(numeroPaiement,nomClasse,nom, prenom,libele,numeroRecu,anneeScolarite,numeroMatricule,date,montantScolarite,"
					+ "montantTranche,numeroTranche,observation,modePaiement)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, admin.getNumeroPaiement());
			ps.setString(2, admin.getNomClasse());
			ps.setString(3, admin.getNom());
			ps.setString(4, admin.getPrenom());
			ps.setString(5, admin.getLibele());
			ps.setString(6, admin.getNumeroRecu());
			ps.setString(7, admin.getAnneeScolarite());
			ps.setString(8, admin.getNumeroMatricule());
			ps.setString(9, admin.getDate());
			ps.setDouble(10, admin.getMontantScolarite());
			ps.setDouble(11, admin.getMontantTranche());
			ps.setDouble(12, admin.getNumeroTranche());
			ps.setString(13, admin.getObservation());
			ps.setString(14, admin.getModePaiement());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public PaiementScolarite read(int id) {
		Connection conn = SingletonConnection.getConnection();
		PaiementScolarite admin = new PaiementScolarite();
		
	    try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  paiementscolarite WHERE id = ?");
			ps.setInt(1, id);
			ResultSet ad  = ps.executeQuery();
			if(ad.next()) {
				
				admin.setNumeroPaiement(ad.getInt("numeroPaiement"));
				admin.setNomClasse(ad.getString("nomClasse"));
				admin.setNom(ad.getString("nom"));
				admin.setPrenom(ad.getString("prenom"));
				admin.setLibele(ad.getString("libele"));
				admin.setNumeroRecu(ad.getString("numeroRecu"));
				admin.setAnneeScolarite(ad.getString("anneeScolarite"));
				admin.setNumeroMatricule(ad.getString("numeroMatricule"));
				admin.setDate(ad.getString("date"));
				admin.setMontantScolarite(ad.getDouble("montantScolarite"));
				admin.setMontantTranche(ad.getDouble("montantTranche"));
				admin.setNumeroTranche(ad.getInt("numeroTranche"));
				admin.setObservation(ad.getString("observation"));
				admin.setModePaiement(ad.getString("modePaiement"));
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
	public void update(PaiementScolarite admin) {
Connection conn = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE paiementscolarite SET numeroPaiement = ?,nomClasse = ?,nom = ? ,prenom  = ?,libele  = ?,numeroRecu  = ?,anneeScolarite  = ?,numeroMatricule = ?,date  = ?,montantScolarite  = ? ,montantTranche  = ?,numeroTranche  = ?,observation  = ?,modePaiement  = ?  WHERE id = ?");
			ps.setInt(1, admin.getNumeroPaiement());
			ps.setString(2, admin.getNomClasse());
			ps.setString(3, admin.getNom());
			ps.setString(4, admin.getPrenom());
			ps.setString(5, admin.getLibele());
			ps.setString(6, admin.getNumeroRecu());
			ps.setString(7, admin.getAnneeScolarite());
			ps.setString(8, admin.getNumeroMatricule());
			ps.setString(9, admin.getDate());
			ps.setDouble(10, admin.getMontantScolarite());
			ps.setDouble(11, admin.getMontantTranche());
			ps.setDouble(12, admin.getNumeroTranche());
			ps.setString(13, admin.getObservation());
			ps.setString(14, admin.getModePaiement());
			ps.setInt(15, admin.getId());
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
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM paiementscolarite WHERE id= ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

	}

	@Override
	public List<PaiementScolarite> readByName(String name) {
		Connection conn = SingletonConnection.getConnection();
		List<PaiementScolarite>administrateurs = new ArrayList<PaiementScolarite>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  paiementscolarite WHERE nom = ? OR prenom = ?");
			ps.setString(1,name);
			ps.setString(2,name);
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				PaiementScolarite admin = new PaiementScolarite();
				admin.setNumeroPaiement(ad.getInt("numeroPaiement"));
				admin.setNomClasse(ad.getString("nomClasse"));
				admin.setNom(ad.getString("nom"));
				admin.setPrenom(ad.getString("prenom"));
				admin.setLibele(ad.getString("libele"));
				admin.setNumeroRecu(ad.getString("numeroRecu"));
				admin.setAnneeScolarite(ad.getString("anneeScolarite"));
				admin.setNumeroMatricule(ad.getString("numeroMatricule"));
				admin.setDate(ad.getString("date"));
				admin.setMontantScolarite(ad.getDouble("montantScolarite"));
				admin.setMontantTranche(ad.getDouble("montantTranche"));
				admin.setNumeroTranche(ad.getInt("numeroTranche"));
				admin.setObservation(ad.getString("observation"));
				admin.setModePaiement(ad.getString("modePaiement"));
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
	public List<PaiementScolarite> read() {
		List<PaiementScolarite>administrateurs = new ArrayList<PaiementScolarite>();
		Connection conn = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  paiementscolarite ");
		
	
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				PaiementScolarite admin = new PaiementScolarite();
				admin.setNumeroPaiement(ad.getInt("numeroPaiement"));
				admin.setNomClasse(ad.getString("nomClasse"));
				admin.setNom(ad.getString("nom"));
				admin.setPrenom(ad.getString("prenom"));
				admin.setLibele(ad.getString("libele"));
				admin.setNumeroRecu(ad.getString("numeroRecu"));
				admin.setAnneeScolarite(ad.getString("anneeScolarite"));
				admin.setNumeroMatricule(ad.getString("numeroMatricule"));
				admin.setDate(ad.getString("date"));
				admin.setMontantScolarite(ad.getDouble("montantScolarite"));
				admin.setMontantTranche(ad.getDouble("montantTranche"));
				admin.setNumeroTranche(ad.getInt("numeroTranche"));
				admin.setObservation(ad.getString("observation"));
				admin.setModePaiement(ad.getString("modePaiement"));
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
	public List<PaiementScolarite> readByTri(String name) {
		Connection conn = SingletonConnection.getConnection();
		List<PaiementScolarite>administrateurs = new ArrayList<PaiementScolarite>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  paiementscolarite ");
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
              String classe = ad.getString("nomClasse");
				
				if(classe.equals(name)) {
				
				PaiementScolarite admin = new PaiementScolarite();
				admin.setNumeroPaiement(ad.getInt("numeroPaiement"));
				admin.setNomClasse(ad.getString("nomClasse"));
				admin.setNom(ad.getString("nom"));
				admin.setPrenom(ad.getString("prenom"));
				admin.setLibele(ad.getString("libele"));
				admin.setNumeroRecu(ad.getString("numeroRecu"));
				admin.setAnneeScolarite(ad.getString("anneeScolarite"));
				admin.setNumeroMatricule(ad.getString("numeroMatricule"));
				admin.setDate(ad.getString("date"));
				admin.setMontantScolarite(ad.getDouble("montantScolarite"));
				admin.setMontantTranche(ad.getDouble("montantTranche"));
				admin.setNumeroTranche(ad.getInt("numeroTranche"));
				admin.setObservation(ad.getString("observation"));
				admin.setModePaiement(ad.getString("modePaiement"));
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
	public List<PaiementScolarite> trieBy(String name) {
		List<PaiementScolarite>administrateurs = new ArrayList<PaiementScolarite>();
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps = null;
		try {
			
            switch (name) {
			
			case "nom":	ps = conn.prepareStatement("SELECT * FROM paiementscolarite ORDER BY nom");

				
				break;
            case "prenom":	ps = conn.prepareStatement("SELECT * FROM paiementscolarite ORDER BY prenom");

				
				break;
				
            case "date": ps = conn.prepareStatement("SELECT * FROM paiementscolarite ORDER BY date");

	
	            break;

			default:
				break;
			}
	
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				PaiementScolarite admin = new PaiementScolarite();
				admin.setNumeroPaiement(ad.getInt("numeroPaiement"));
				admin.setNomClasse(ad.getString("nomClasse"));
				admin.setNom(ad.getString("nom"));
				admin.setPrenom(ad.getString("prenom"));
				admin.setLibele(ad.getString("libele"));
				admin.setNumeroRecu(ad.getString("numeroRecu"));
				admin.setAnneeScolarite(ad.getString("anneeScolarite"));
				admin.setNumeroMatricule(ad.getString("numeroMatricule"));
				admin.setDate(ad.getString("date"));
				admin.setMontantScolarite(ad.getDouble("montantScolarite"));
				admin.setMontantTranche(ad.getDouble("montantTranche"));
				admin.setNumeroTranche(ad.getInt("numeroTranche"));
				admin.setObservation(ad.getString("observation"));
				admin.setModePaiement(ad.getString("modePaiement"));
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
	public double total() {
		Connection conn = SingletonConnection.getConnection();
		double somme=0;
	
		
	    try {
			PreparedStatement ps = conn.prepareStatement("SELECT SUM(montantTranche) AS prix_total FROM  paiementscolarite");
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
