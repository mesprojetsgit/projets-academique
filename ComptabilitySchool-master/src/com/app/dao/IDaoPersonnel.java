package com.app.dao;

import java.util.List;

import com.app.metier.entites.Personnel;
import com.app.metier.entites.Professeur;

public interface IDaoPersonnel {

	public void create (Personnel admin );
	public Personnel read(int id);
	public Personnel read(String nom , String prenom, String poste);
	public void update(Personnel admin);
    public void delete(int id);
    public List<Personnel>readByName(String name);
    public List<Personnel>read();
    public List<Personnel> readTri(String name);
}