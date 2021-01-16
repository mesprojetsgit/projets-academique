package com.app.dao;

import java.util.List;

import com.app.metier.entites.PaiementScolarite;

public interface IDaoPaiementScolarite {

	public void create (PaiementScolarite admin );
	public PaiementScolarite read(int id);
	public void update(PaiementScolarite admin);
    public void delete(int id);
    public List<PaiementScolarite>readByName(String name);
    public List<PaiementScolarite>readByTri(String name);
    public List<PaiementScolarite> read();
    public List<PaiementScolarite> trieBy(String name);
    public double total();
}
