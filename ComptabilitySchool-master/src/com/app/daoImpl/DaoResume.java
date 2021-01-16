package com.app.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.connection.SingletonConnection;
import com.app.dao.IDaoPaiementProfesseur;
import com.app.dao.IDaoResume;
import com.app.metier.entites.PaiementProfesseur;
import com.app.metier.entites.Resume;

public class DaoResume implements IDaoResume {

	
	@Override
	public List<Resume> read() {

		
		List<Resume>administrateurs = new ArrayList<Resume>();
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT nom, prenom ,SUM(montantTotal) AS montant,type,mois,matricule FROM paiementprofesseur GROUP BY nom , prenom,type,mois,matricule");
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
				Resume admin = new Resume();
				admin.setNom(ad.getString("nom"));
				admin.setPrenom(ad.getString("prenom"));
				admin.setMontant(ad.getDouble("montant"));
				admin.setType(ad.getString("type"));
				admin.setMois(ad.getString("mois"));
				admin.setMatricule(ad.getString("matricule"));
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
