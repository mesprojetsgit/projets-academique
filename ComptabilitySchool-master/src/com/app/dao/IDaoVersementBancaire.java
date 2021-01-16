package com.app.dao;

import java.util.List;

import com.app.metier.entites.Versement;

public interface IDaoVersementBancaire {
	
	public void create (Versement admin );
	public Versement read(int id);
	public void update(Versement admin);
    public void delete(int id);
    public List<Versement>readByName(String name);
    public List<Versement>readByTri(String name);
    public List<Versement> read();

}
