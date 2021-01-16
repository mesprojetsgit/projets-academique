package com.app.metier.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.app.metier.entites.PaiementAuxiliaire;
import com.app.metier.entites.PaiementProfesseur;

public class ModelPaiementAuxiliaire extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private final String[] entetes = {
			"Id", "Matricule", "Nom", "Prenom", "Classe", "Statut", "Montant", "Description", "Commentaire"
	};
	private List<PaiementAuxiliaire> depenses;
	
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
			return depenses.get(rowIndex).getMatricule();
			
		case 2:
			
			return depenses.get(rowIndex).getNom();


		case 3:
			return depenses.get(rowIndex).getPrenom();
			
		case 4:
			
			return depenses.get(rowIndex).getClasse();
			
        case 5:
        	
        	return depenses.get(rowIndex).getStatus();
        	
        case 6:
			
        	return depenses.get(rowIndex).getMontant();
			
        case 7:
        	
        	return depenses.get(rowIndex).getDescription();
      
        case 8:
        	return depenses.get(rowIndex).getCommentaire();
        	
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
				case 8:return String.class;
				default:
					return Object.class;
				}

	}

		public List<PaiementAuxiliaire> getDepenses() {
			return depenses;
		}

		public void setDepenses(List<PaiementAuxiliaire> depenses) {
			this.depenses = depenses;
		}

	

}
