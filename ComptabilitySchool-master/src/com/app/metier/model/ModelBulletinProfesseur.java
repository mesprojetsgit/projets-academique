package com.app.metier.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.app.metier.entites.PaiementProfesseur;

public class ModelBulletinProfesseur extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	private final String[] entetes = {
			"Montant", "Date", "Mois", "Nombre d'heure", "Prix/Heure", "Mode de paiement"
	};
	private List<PaiementProfesseur> depenses;
	
	@Override
	public int getColumnCount() {
		return entetes.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return depenses.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {

		case 0:
			 return depenses.get(rowIndex).getMontantTotal();
			

		case 1:
			return depenses.get(rowIndex).getDateDePaiement();
			
		case 2:
			
			return depenses.get(rowIndex).getMois();


		case 3:
			return depenses.get(rowIndex).getNombreHeure();
			
		case 4:
			
			return depenses.get(rowIndex).getPrixParHeure();
			
        case 5:
        	
        	return depenses.get(rowIndex).getModePaiement();
        	
       
      
		default:
			throw new IllegalArgumentException();
		}
	}
		
	

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				switch (columnIndex) {

				case 0:return Double.class;
				case 1:
					return String.class;

				case 3:
					return String.class;

				case 2:
					return String.class;

				case 4:
					return String.class;
					
					
				case 5:return String.class;
			
				default:
					return Object.class;
				}

	}

		public List<PaiementProfesseur> getDepenses() {
			return depenses;
		}

		public void setDepenses(List<PaiementProfesseur> depenses) {
			this.depenses = depenses;
		}

	


}
