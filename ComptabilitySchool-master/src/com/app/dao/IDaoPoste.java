package com.app.dao;

import java.util.List;

import com.app.metier.entites.Poste;

public interface IDaoPoste {
	public void create (Poste admin );
	public Poste read(int id);
	public void update(Poste admin);
    public void delete(int id);
    public List<Poste>readByName(String name);
    public List<Poste>readByPersonelId(int id);
    public List<Poste>read();
}
