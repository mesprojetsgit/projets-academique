package com.app.metier.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.app.metier.entites.PaiementProfesseur;
import com.app.metier.entites.PaiementScolarite;

public class ModelPaiementScolarite extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private final String[] entetes = {
					"Id", "Montant", "Date", "Recu N\u00B0", "Matricule", 
					"Nom", "Prenom", "Classe", "Annee scolaire", "Mode de paiement", 
					"Scolarite",  "Tranche", "Observation", "Libelle", "Paiement N\u00B0"
	};
	private List<PaiementScolarite> depenses;
	
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
			return depenses.get(rowIndex).getMontantTranche();
			
		case 2:
			
			return depenses.get(rowIndex).getDate();


		case 3:
			return depenses.get(rowIndex).getNumeroRecu();
			
		case 4:
			
			return depenses.get(rowIndex).getNumeroMatricule();
			
        case 5:
        	return depenses.get(rowIndex).getNom();

        	
        case 6:
			
        	return depenses.get(rowIndex).getPrenom();
			
        case 7:
        	return depenses.get(rowIndex).getNomClasse();
			
      
        case 8:
			
        	return depenses.get(rowIndex).getAnneeScolarite();
		case 9:
			
			return depenses.get(rowIndex).getModePaiement();
			

        case 10:
        	return depenses.get(rowIndex).getMontantScolarite();
        	
			
        case 11:
        	return depenses.get(rowIndex).getNumeroTranche();
        	
        case 12:
			
        	return depenses.get(rowIndex).getObservation();
			
			
        case 13:
			
        	return depenses.get(rowIndex).getLibele();
			
       case 14:
			
			return depenses.get(rowIndex).getNumeroPaiement();
      
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
					
					
				case 13:return String.class;
				case 14:
					return String.class;

				default:
					return Object.class;
				}

	}

		public List<PaiementScolarite> getDepenses() {
			return depenses;
		}

		public void setDepenses(List<PaiementScolarite> depenses) {
			this.depenses = depenses;
		}

	


}
