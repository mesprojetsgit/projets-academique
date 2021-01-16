package com.app.dao;

import java.util.List;

import com.app.metier.entites.Administrateur;

public interface IDaoAdministrateur {
	
	public void create (Administrateur admin );
	public Administrateur read(int id);
	public void update(Administrateur admin);
    public void delete(int id);
    public List<Administrateur>readByName(String name);
    public List<Administrateur>read();
    public List<Administrateur>readByLoginPassword(String login,String password);
}
