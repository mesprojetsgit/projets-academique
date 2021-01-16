package com.app.metier.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.app.metier.entites.Personnel;
import com.app.metier.entites.Versement;

@SuppressWarnings("serial")
public class ModelVersement extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private final String[] entetes = {
			"Id", "Date", "Montant", "Num\u00E9ro de compte", "Solde du compte"
	};
	private List<Versement> depenses;
	
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
			 return depenses.get(rowIndex).getId();
			
		case 1:
			
			return depenses.get(rowIndex).getDate();


		case 2:
			
			return depenses.get(rowIndex).getMontant();
			
			
         case 3:
			
			return depenses.get(rowIndex).getNumeroCompte();

         case 4:
 			
 			return depenses.get(rowIndex).getSoldeCompte();
		

		default:
			throw new IllegalArgumentException();
		}
	}
		
		
		@Override
		public Class<?> getColumnClass(int columnIndex) {
			switch (columnIndex) {

			case 0:return String.class;
			case 1:
				return String.class;

			case 3:
				return String.class;

			case 2:
				return String.class;
				
			case 4:
				return String.class;
				
			default:
				return Object.class;
			}
	}

		public List<Versement> getDepenses() {
			return depenses;
		}

		public void setDepenses(List<Versement> depenses) {
			this.depenses = depenses;
		}


	

}
