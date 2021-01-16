package com.app.dao;

import java.util.List;

import com.app.metier.entites.Administrateur;
import com.app.metier.entites.Comptable;

public interface IDaoComptable {
	public void create (Comptable admin );
	public Comptable read(int id);
	public void update(Comptable admin);
    public void delete(int id);
    public List<Comptable>readByName(String name);
    public List<Comptable>read();
    public List<Comptable>readByLoginPassword(String login,String password);
}
