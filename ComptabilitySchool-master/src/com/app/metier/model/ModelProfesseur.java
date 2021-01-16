package com.app.metier.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.app.daoImpl.DaoClasseImpl;
import com.app.daoImpl.DaoMatiereImpl;
import com.app.metier.entites.Professeur;

public class ModelProfesseur extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
	private final String[] entetes = {
			"Id", "Nom", "Prenom","Type", "Classe", "Matiere","Matricule"
	};
	private List<Professeur> depenses;
	
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
			
			return depenses.get(rowIndex).getNom();


		case 2:
			
			return depenses.get(rowIndex).getPrenom();
			
			
         case 3:
			
			return depenses.get(rowIndex).getType();
			
		case 4:
			
			
			return depenses.get(rowIndex).getNomClasse();

        case 5:
			
			return depenses.get(rowIndex).getNomMatiere();

         case 6:
			
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

			case 3:
				return String.class;

			case 2:
				return String.class;

			case 4:
				return String.class;

			case 5:return String.class;
				
			case 6:return String.class;
			default:
				return Object.class;
			}
	}

		public List<Professeur> getDepenses() {
			return depenses;
		}

		public void setDepenses(List<Professeur> depenses) {
			this.depenses = depenses;
		}


	

}
