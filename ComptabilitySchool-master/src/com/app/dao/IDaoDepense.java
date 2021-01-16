package com.app.dao;

import java.util.List;

import com.app.metier.entites.Depense;

public interface IDaoDepense {
	
	public void create (Depense admin );
	public Depense read(int id);
	public void update(Depense admin);
    public void delete(int id);
    public List<Depense> getAll ( );
    public List<Depense>readByName(String mois);
    public List<Depense>trieBy(String mois);
    public double sommeMontant();
}
