package com.app.dao;

import java.util.List;

import com.app.metier.entites.RecuScolarite;

public interface IDaoRecuScolarite {
	
	public void create (RecuScolarite admin );
	public  RecuScolarite read(int id ) ;
	public void update(RecuScolarite admin);
    public void delete(int id);
    public List<RecuScolarite>read();
    public List<RecuScolarite>readByName(String name);
    public List<RecuScolarite>readByPaiementId(int id);
    public List<RecuScolarite>readByEleveId(int id);
}
