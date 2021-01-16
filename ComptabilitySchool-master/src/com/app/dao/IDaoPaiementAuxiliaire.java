package com.app.dao;

import java.util.List;

import com.app.metier.entites.PaiementAuxiliaire;

public interface IDaoPaiementAuxiliaire {
	
	public void create (PaiementAuxiliaire admin );
	public void update(PaiementAuxiliaire admin);
    public void delete(int id);
    public PaiementAuxiliaire read(int id);
    public List<PaiementAuxiliaire>read();

}
