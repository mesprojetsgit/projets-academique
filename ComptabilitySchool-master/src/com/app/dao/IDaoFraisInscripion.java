package com.app.dao;

import java.util.List;

import com.app.metier.entites.FraisInscription;

public interface IDaoFraisInscripion {
	
	public void create (FraisInscription admin );
	public FraisInscription read(int id);
	public void update(FraisInscription admin);
    public void delete(int id);
    public List<FraisInscription>readByName(String name);
    public List<FraisInscription>readByTri(String name);
    public List<FraisInscription> read();
    public double total();
}
