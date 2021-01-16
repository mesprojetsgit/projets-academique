package com.app.dao;

import java.util.List;

import com.app.metier.entites.PaiementEmployer;
import com.app.metier.entites.Personnel;

public interface IDaoPaiementEmployer {
	
	public void create (PaiementEmployer admin );
	public PaiementEmployer read(int id);
	public void update(PaiementEmployer admin);
    public void delete(int id);
    public List<PaiementEmployer>readByName(String name);
    public List<PaiementEmployer>readByEmployer(Personnel name);
    public List<PaiementEmployer>readByTri(String name);
    public List<PaiementEmployer> read();
    public double total();
}
