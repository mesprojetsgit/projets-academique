package com.app.dao;

import java.util.List;

import com.app.metier.entites.Classe;

public interface IDaoClasse {
	
	public void create (Classe  admin );
	public Classe  read(int id);
	public void update(Classe  admin);
    public void delete(int id);
    public List<Classe >readByName(String name);
    public List<Classe >readByMatiereId(int id);
    public List<Classe >read();
}
