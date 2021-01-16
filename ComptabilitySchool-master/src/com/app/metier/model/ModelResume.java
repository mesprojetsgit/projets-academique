package com.app.metier.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.app.metier.entites.Eleve;
import com.app.metier.entites.PaiementProfesseur;
import com.app.metier.entites.Resume;

public class ModelResume extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	private final String[] entetes = {
	    "Nom", "Prenom", "Montant", "Type", "Mois","Matricule"
	};
	private List<Resume> depenses;
	
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
			 return depenses.get(rowIndex).getNom();
			

		case 1:
			return depenses.get(rowIndex).getPrenom();
			
		case 2:
			
			return depenses.get(rowIndex).getMontant();


		case 3:
			
			return depenses.get(rowIndex).getType();
		case 4:
			
			
			return depenses.get(rowIndex).getMois();
			
        case 5:
			
			
			return depenses.get(rowIndex).getMatricule();

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

			case 2:
				return String.class;

			case 3:
				return String.class;

			case 4:
				return String.class;

				
			default:
				return Object.class;
			}
	}

		public List<Resume> getDepenses() {
			return depenses;
		}

		public void setDepenses(List<Resume> depenses) {
			this.depenses = depenses;
		}


	
}
