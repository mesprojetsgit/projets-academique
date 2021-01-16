package com.app.dao;

import java.util.List;

import com.app.metier.entites.HoraireTotal;

public interface IDaoHoraireTotal {
	
	public void create (HoraireTotal admin );
	public HoraireTotal read(int id);
	public void update(HoraireTotal admin);
    public void delete(int id);
    public List<HoraireTotal>readByName(String name);
    public List<HoraireTotal>readByMatiereId(int id);
    public List<HoraireTotal>read();

}
