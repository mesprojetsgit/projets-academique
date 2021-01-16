package com.app.dao;

import java.util.List;

import com.app.metier.entites.PaiementProfesseur;
import com.app.metier.entites.Professeur;

public interface IDaoPaiementProfesseur {
	
	
	public void create (PaiementProfesseur admin );
	public void update(PaiementProfesseur admin);
    public void delete(int id);
    public PaiementProfesseur read(int id);
    public PaiementProfesseur read(Professeur prof);
    public List<PaiementProfesseur>readByName(String name);
    public List<PaiementProfesseur>read();
    public List<PaiementProfesseur> readByTri(String name);
    public List<PaiementProfesseur>readByProf(Professeur prof);
    public double total();
}
