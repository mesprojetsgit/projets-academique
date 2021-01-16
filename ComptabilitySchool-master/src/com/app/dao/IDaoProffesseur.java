package com.app.dao;

import java.util.List;

import com.app.metier.entites.Professeur;

public interface IDaoProffesseur {
	
	public void create (Professeur admin );
	public Professeur read(int id);
	public Professeur read(String nom,String prenom,String nomClasse,String nomMatiere,String type);
	public void update(Professeur admin);
    public void delete(int id);
    public List<Professeur>readByName(String name);
    public List<Professeur>readTriByNomClasse(String name);
    public List<Professeur>readTriByNomMatiere(String name);
    public List<Professeur>read();
    

}
