package com.app.dao;

import java.util.List;

import com.app.metier.entites.Eleve;

public interface IDaoEleve {
	
	public void create (Eleve admin );
	public Eleve read(int id);
	public void update(Eleve admin);
	public void update(int tranche , Double montant,int id);
	public void delete(int id);
    public List<Eleve>readByName(String name);
    public List<Eleve>readByClasseId(int id);
    public List<Eleve>readByASCName(String nom);
    public List<Eleve>readByDESCName(String nom);
    public List<Eleve>readByTri(String nom);
    public List<Eleve>read();
}
