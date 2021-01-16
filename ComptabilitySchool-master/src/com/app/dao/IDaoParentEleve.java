package com.app.dao;

import java.util.List;

import com.app.metier.entites.ParentEleve;

public interface IDaoParentEleve {
	public void create (ParentEleve admin );
	public ParentEleve read(int id);
	public void update(ParentEleve admin);
    public void delete(int id);
    public List<ParentEleve>readByName(String name);
    public List<ParentEleve>read();
}
