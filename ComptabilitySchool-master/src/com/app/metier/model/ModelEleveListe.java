package com.app.metier.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.app.metier.entites.Eleve;

public class ModelEleveListe extends AbstractTableModel {

	
	private static final long serialVersionUID = 1L;
	private final String[] entetes = {
			"Id", "Matricule", "Nom", "Prenom", "Classe", "Genre", "Statut"
	};
	private List<Eleve> depenses;
	
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
			return depenses.get(rowIndex).getNumeroMatricule();
			
		case 2:
			
			return depenses.get(rowIndex).getNom();


		case 3:
			
			return depenses.get(rowIndex).getPrenom();
		case 4:
			
			
			return depenses.get(rowIndex).getClasse();

        case 5:
			
			return depenses.get(rowIndex).getSexe();
        
         case 6:
	
      	return depenses.get(rowIndex).getStatus();

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

			case 5:
				return String.class;
				
			case 6:
				return String.class;
				
			default:
				return Object.class;
			}
	}

		public List<Eleve> getDepenses() {
			return depenses;
		}

		public void setDepenses(List<Eleve> depenses) {
			this.depenses = depenses;
		}


	
	
	
}
