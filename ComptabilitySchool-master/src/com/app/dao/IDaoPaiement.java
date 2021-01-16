package com.app.dao;

import java.util.List;

import com.app.metier.entites.Paiement;

public interface IDaoPaiement {
	
	public void create (Paiement admin );
	public Paiement read(int id);
	public void update(Paiement admin);
    public void delete(int id);
    public List<Paiement>readByName(String name);
    public List<Paiement>readByEmployerId(int id);
    public List<Paiement>read();
}
