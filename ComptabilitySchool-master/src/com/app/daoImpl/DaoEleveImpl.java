package com.app.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.connection.SingletonConnection;
import com.app.dao.IDaoEleve;
import com.app.metier.entites.Eleve;

public class DaoEleveImpl implements IDaoEleve {

	@Override
	public void create(Eleve  admin) {
		Connection conn = SingletonConnection.getConnection();
		
		
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO eleve(nom,prenom,sexe,numeroMatricule,tranche1,tranche2,tranche3,status,classe,nomTuteur,prenomTuteur,adresseTuteur,telTuteur,telEleve,naissance,scolarite)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, admin.getNom());
			ps.setString(2, admin.getPrenom());
			ps.setString(3, admin.getSexe());
			ps.setString(4, admin.getNumeroMatricule());
			ps.setDouble(5, admin.getTranche1());
			ps.setDouble(6, admin.getTranche2());
			ps.setDouble(7, admin.getTranche3());
			ps.setString(8, admin.getStatus());
			ps.setString(9, admin.getClasse());
			ps.setString(10, admin.getNomTuteur());
			ps.setString(11, admin.getPrenomTuteur());
			ps.setString(12, admin.getAdresseTuteur());
			ps.setString(13, admin.getTelTuteur());
			ps.setString(14, admin.getTelEleve());
			ps.setString(15, admin.getNaissance());
			ps.setDouble(16,admin.getScolarite());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

	@Override
	public void update(Eleve admin) {
Connection conn = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE eleve SET nom = ?,prenom = ?,sexe  = ?,numeroMatricule = ?,tranche1 = ?,tranche2 = ?,tranche3 = ?,status = ?,classe = ?,nomTuteur = ?,prenomTuteur = ?,adresseTuteur = ?,telTuteur = ?,telEleve =?,naissance= ?,scolarite=? WHERE  id= ? ");
			ps.setString(1,admin.getNom());
			ps.setString(2,admin.getPrenom());
			ps.setString(3,admin.getSexe());
			ps.setString(4,admin.getNumeroMatricule());
			ps.setDouble(5,admin.getTranche1());
			ps.setDouble(6,admin.getTranche2());
			ps.setDouble(7,admin.getTranche3());
			ps.setString(8,admin.getStatus());
			ps.setString(9, admin.getClasse());
			ps.setString(10, admin.getNomTuteur());
			ps.setString(11, admin.getPrenomTuteur());
			ps.setString(12, admin.getAdresseTuteur());
			ps.setString(13, admin.getTelTuteur());
			ps.setString(14, admin.getTelEleve());
			ps.setString(15, admin.getNaissance());
			ps.setDouble(16,admin.getScolarite());
			ps.setInt(17, admin.getId());
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
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM eleve WHERE  id= ? ");
			ps.setInt(1, id);
			ps.executeUpdate();
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	public List<Eleve> readByName(String name) {
		List<Eleve>administrateurs = new ArrayList<Eleve>();
		Connection conn = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  eleve WHERE nom = ? OR prenom = ?");
			ps.setString(1,name);
			ps.setString(2,name);
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
			Eleve admin = new Eleve();
			admin.setNom(ad.getString("nom"));
			admin.setPrenom(ad.getString("prenom"));
			admin.setSexe(ad.getString("sexe"));
			admin.setNumeroMatricule(ad.getString("numeroMatricule"));
			admin.setStatus(ad.getString("status"));
			admin.setTranche1(ad.getDouble("tranche1"));
			admin.setTranche2(ad.getDouble("tranche2"));
			admin.setTranche3(ad.getDouble("tranche3"));
			admin.setClasse(ad.getString("classe"));
			admin.setNomTuteur(ad.getString("nomTuteur"));
			admin.setPrenomTuteur(ad.getString("prenomTuteur"));
			admin.setAdresseTuteur(ad.getString("adresseTuteur"));
			admin.setTelTuteur(ad.getString("telTuteur"));
			admin.setTelEleve(ad.getString("telEleve"));
			admin.setNaissance(ad.getString("naissance"));
			admin.setScolarite(ad.getDouble("scolarite"));
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
	public Eleve read( int id) {
			Connection conn = SingletonConnection.getConnection();
			Eleve admin = new Eleve();
		
		    try {
				PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  eleve WHERE id = ?");
				ps.setInt(1, id);
				ResultSet ad  = ps.executeQuery();
				if(ad.next()) {
					
					admin.setNom(ad.getString("nom"));
					admin.setPrenom(ad.getString("prenom"));
					admin.setSexe(ad.getString("sexe"));
					admin.setNumeroMatricule(ad.getString("numeroMatricule"));
					admin.setStatus(ad.getString("status"));
					admin.setTranche1(ad.getDouble("tranche1"));
					admin.setTranche2(ad.getDouble("tranche2"));
					admin.setTranche3(ad.getDouble("tranche3"));
					admin.setClasse(ad.getString("classe"));
					admin.setNomTuteur(ad.getString("nomTuteur"));
					admin.setPrenomTuteur(ad.getString("prenomTuteur"));
					admin.setAdresseTuteur(ad.getString("adresseTuteur"));
					admin.setTelTuteur(ad.getString("telTuteur"));
					admin.setTelEleve(ad.getString("telEleve"));
					admin.setNaissance(ad.getString("naissance"));
					admin.setScolarite(ad.getDouble("scolarite"));
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
	public List<Eleve> readByClasseId(int id) {
		List<Eleve>administrateurs = new ArrayList<Eleve>();
		Connection conn = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  eleve WHERE id_classe = ? ");
			ps.setInt(1,id);
	
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
			Eleve admin = new Eleve();
			admin.setNom(ad.getString("nom"));
			admin.setPrenom(ad.getString("prenom"));
			admin.setSexe(ad.getString("sexe"));
			admin.setNumeroMatricule(ad.getString("numeroMatricule"));
			admin.setStatus(ad.getString("status"));
			admin.setTranche1(ad.getDouble("tranche1"));
			admin.setTranche2(ad.getDouble("tranche2"));
			admin.setTranche3(ad.getDouble("tranche3"));
			admin.setClasse(ad.getString("classe"));
			admin.setNomTuteur(ad.getString("nomTuteur"));
			admin.setPrenomTuteur(ad.getString("prenomTuteur"));
			admin.setAdresseTuteur(ad.getString("adresseTuteur"));
			admin.setTelTuteur(ad.getString("telTuteur"));
			admin.setTelEleve(ad.getString("telEleve"));
			admin.setNaissance(ad.getString("naissance"));
			admin.setScolarite(ad.getDouble("scolarite"));
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
	public List<Eleve> read() {
		List<Eleve>administrateurs = new ArrayList<Eleve>();
		Connection conn = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  * FROM  eleve ");
		
	
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
			Eleve admin = new Eleve();
			admin.setNom(ad.getString("nom"));
			admin.setPrenom(ad.getString("prenom"));
			admin.setSexe(ad.getString("sexe"));
			admin.setNumeroMatricule(ad.getString("numeroMatricule"));
			admin.setStatus(ad.getString("status"));
			admin.setTranche1(ad.getDouble("tranche1"));
			admin.setTranche2(ad.getDouble("tranche2"));
			admin.setTranche3(ad.getDouble("tranche3"));
			admin.setClasse(ad.getString("classe"));
			admin.setNomTuteur(ad.getString("nomTuteur"));
			admin.setPrenomTuteur(ad.getString("prenomTuteur"));
			admin.setAdresseTuteur(ad.getString("adresseTuteur"));
			admin.setTelTuteur(ad.getString("telTuteur"));
			admin.setTelEleve(ad.getString("telEleve"));
			admin.setNaissance(ad.getString("naissance"));
			admin.setScolarite(ad.getDouble("scolarite"));
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
	public List<Eleve> readByASCName(String nom) {
		List<Eleve>administrateurs = new ArrayList<Eleve>();
		Connection conn = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM eleve ORDER BY nom ASC ");
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
			Eleve admin = new Eleve();
			admin.setNom(ad.getString("nom"));
			admin.setPrenom(ad.getString("prenom"));
			admin.setSexe(ad.getString("sexe"));
			admin.setNumeroMatricule(ad.getString("numeroMatricule"));
			admin.setStatus(ad.getString("status"));
			admin.setTranche1(ad.getDouble("tranche1"));
			admin.setTranche2(ad.getDouble("tranche2"));
			admin.setTranche3(ad.getDouble("tranche3"));
			admin.setClasse(ad.getString("classe"));
			admin.setNomTuteur(ad.getString("nomTuteur"));
			admin.setPrenomTuteur(ad.getString("prenomTuteur"));
			admin.setAdresseTuteur(ad.getString("adresseTuteur"));
			admin.setTelTuteur(ad.getString("telTuteur"));
			admin.setTelEleve(ad.getString("telEleve"));
			admin.setNaissance(ad.getString("naissance"));
			admin.setScolarite(ad.getDouble("scolarite"));
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
	public List<Eleve> readByDESCName(String nom) {
		List<Eleve>administrateurs = new ArrayList<Eleve>();
		Connection conn = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM eleve ORDER BY nom DESC ");
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
			Eleve admin = new Eleve();
			admin.setNom(ad.getString("nom"));
			admin.setPrenom(ad.getString("prenom"));
			admin.setSexe(ad.getString("sexe"));
			admin.setNumeroMatricule(ad.getString("numeroMatricule"));
			admin.setStatus(ad.getString("status"));
			admin.setTranche1(ad.getDouble("tranche1"));
			admin.setTranche2(ad.getDouble("tranche2"));
			admin.setTranche3(ad.getDouble("tranche3"));
			admin.setClasse(ad.getString("classe"));
			admin.setNomTuteur(ad.getString("nomTuteur"));
			admin.setPrenomTuteur(ad.getString("prenomTuteur"));
			admin.setAdresseTuteur(ad.getString("adresseTuteur"));
			admin.setTelTuteur(ad.getString("telTuteur"));
			admin.setTelEleve(ad.getString("telEleve"));
			admin.setNaissance(ad.getString("naissance"));
			admin.setScolarite(ad.getDouble("scolarite"));
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
	public List<Eleve> readByTri(String nom) {
		List<Eleve>administrateurs = new ArrayList<Eleve>();
		PreparedStatement ps = null;
		Connection conn = SingletonConnection.getConnection();
		
		try {
			
			switch (nom) {
			case "nom":ps = conn.prepareStatement("SELECT * FROM eleve ORDER BY nom  ");
				
				break;

            case "prenom":ps = conn.prepareStatement("SELECT * FROM eleve ORDER BY prenom  ");
				
				break;
             case "classe":ps = conn.prepareStatement("SELECT * FROM eleve ORDER BY classe  ");
	
	             break;
			default:
				break;
		}
			
			
			ResultSet ad  = ps.executeQuery();	
			
			while(ad.next()) {
				
			Eleve admin = new Eleve();
			admin.setNom(ad.getString("nom"));
			admin.setPrenom(ad.getString("prenom"));
			admin.setSexe(ad.getString("sexe"));
			admin.setNumeroMatricule(ad.getString("numeroMatricule"));
			admin.setStatus(ad.getString("status"));
			admin.setTranche1(ad.getDouble("tranche1"));
			admin.setTranche2(ad.getDouble("tranche2"));
			admin.setTranche3(ad.getDouble("tranche3"));
			admin.setClasse(ad.getString("classe"));
			admin.setNomTuteur(ad.getString("nomTuteur"));
			admin.setPrenomTuteur(ad.getString("prenomTuteur"));
			admin.setAdresseTuteur(ad.getString("adresseTuteur"));
			admin.setTelTuteur(ad.getString("telTuteur"));
			admin.setTelEleve(ad.getString("telEleve"));
			admin.setNaissance(ad.getString("naissance"));
			admin.setScolarite(ad.getDouble("scolarite"));
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
	public void update(int tranche, Double montant, int id) {
			 Connection conn = SingletonConnection.getConnection();
			 PreparedStatement ps = null;
				
				try {
					
					switch (tranche) {
					
					case 1: ps = conn.prepareStatement("UPDATE eleve SET tranche1 = ?  WHERE  id= ? ");
					        ps.setDouble(1,montant);
						
						break;
						
	                case 2: ps = conn.prepareStatement("UPDATE eleve SET tranche2 = ?  WHERE  id= ? ");
	                        ps.setDouble(1,montant);
						break;
						
	                case 3: ps = conn.prepareStatement("UPDATE eleve SET tranche3 = ?  WHERE  id= ? ");
	                        ps.setDouble(1,montant);
	                    	break;
					default:
						break;
					}
					
					ps.setInt(2, id);
					ps.executeUpdate();
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			
		}
	}




