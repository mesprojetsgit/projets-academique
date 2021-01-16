package com.app.metier.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.app.metier.entites.FraisInscription;
import com.app.metier.entites.PaiementEmployer;

@SuppressWarnings("serial")
public class ModelFraisInscription extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private final String[] entetes = {
			"Id", "Montant", "Date", "Matricule", "Nom", "Prenom", "Classe", "Mode de paiement"
	};
	private List<FraisInscription> depenses;
	
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
			return depenses.get(rowIndex).getMontant();
			
		case 2:
			
			return depenses.get(rowIndex).getDate();


		case 3:
			return depenses.get(rowIndex).getMatricule();
			
		case 4:
			
			return depenses.get(rowIndex).getNom();
			
        case 5:
        	
        	return depenses.get(rowIndex).getPrenom();
        	
        case 6:
			
        	return depenses.get(rowIndex).getClasse();
			
        case 7:
        	
        	return depenses.get(rowIndex).getModeDePaiement();
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
				case 6:
					return String.class;
				case 7:
					return String.class;
				default:
					return Object.class;
				}

	}

		public List<FraisInscription> getDepenses() {
			return depenses;
		}

		public void setDepenses(List<FraisInscription> depenses) {
			this.depenses = depenses;
		}

	

}
