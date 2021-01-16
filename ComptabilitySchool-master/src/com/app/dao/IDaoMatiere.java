package com.app.dao;

import java.util.List;

import com.app.metier.entites.Matiere;

public interface IDaoMatiere {

	public void create (Matiere admin );
	public void update(Matiere admin);
    public void delete(int id);
    public Matiere read(int id);
    public List<Matiere>readByName(String name);
    public List<Matiere>read();
}
