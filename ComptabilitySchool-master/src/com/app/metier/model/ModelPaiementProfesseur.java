package com.app.metier.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.app.metier.entites.PaiementProfesseur;
import com.app.metier.entites.PaiementScolarite;
import com.app.metier.service.Service;

public class ModelPaiementProfesseur extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	private final String[] entetes = {
			"Id", "Nom", "Prenom", "Classe", "Matiere", "Montant", "type", "nombre heure", 
			 "prix horaire", "montant total", "mois", "mode paiement", "date paiement"
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
			 return depenses.get(rowIndex).getId();
			

		case 1:
			return depenses.get(rowIndex).getNom();
			
		case 2:
			
			return depenses.get(rowIndex).getPrenom();


		case 3:
			return depenses.get(rowIndex).getNomClasse();
			
		case 4:
			
			return depenses.get(rowIndex).getNomMatiere();
			
        case 5:
        	
        	return depenses.get(rowIndex).getSalaire();
        	
        case 6:
			
        	return depenses.get(rowIndex).getType();
			
        case 7:
        	
        	return depenses.get(rowIndex).getNombreHeure();
      
        case 8:
        	return depenses.get(rowIndex).getPrixParHeure();
        	
		case 9:
			
			
			return depenses.get(rowIndex).getMontantTotal();

        case 10:
        	
        	return depenses.get(rowIndex).getMois();
        case 11:
			
        	
        	return depenses.get(rowIndex).getModePaiement();
			
        case 12:
			
			
        	return depenses.get(rowIndex).getDateDePaiement();
			
        
      
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
				case 9:
					return String.class;

				case 10:
					return String.class;

				case 11:
					return String.class;

				case 12:
					return String.class;
					

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
