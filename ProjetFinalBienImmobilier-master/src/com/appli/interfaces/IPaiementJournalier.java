package com.appli.interfaces;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import java.awt.Cursor;



public class IPaiementJournalier extends IPaiement {
	private JButton btn_modifierPaiement;
	private JButton btn_payer_3_Tranche;
	private JButton btn_payer_2_Tranche;
	private JButton btn_payer_1_Tranche;
	private JDateChooser dateChooser_datePaiement;
	private JButton btn_annulerPaiement;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tablePaiementJournalier;
	DefaultTableModel tableModel = new DefaultTableModel();
	private Integer id;
	private JButton btnQuitter;
	
	
	
	public IPaiementJournalier(Integer id) {
		this.id=id;
		component();
	}
		
		@SuppressWarnings("serial")
		public void component() {
		JLabel lblPaiementtJournaluiers = new JLabel("Paiement Journalier");
		lblPaiementtJournaluiers.setToolTipText("Vous \u00EAtes dans un paiement journalier !");
		lblPaiementtJournaluiers.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPaiementtJournaluiers.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaiementtJournaluiers.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPaiementtJournaluiers.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblPaiementtJournaluiers.setBounds(10, 490, 234, 44);
		getContentPane().add(lblPaiementtJournaluiers);
		
		JLabel label_coutLoyer = new JLabel("");
		label_coutLoyer.setToolTipText("Montant \u00E0 payer");
		label_coutLoyer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_coutLoyer.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_coutLoyer.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		label_coutLoyer.setBounds(509, 113, 326, 68);
		getContentPane().add(label_coutLoyer);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_1.setBounds(509, 192, 326, 264);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
	    dateChooser_datePaiement = new JDateChooser();
	    dateChooser_datePaiement.setToolTipText("S\u00E9lectionnez la date du paiement !");
	    dateChooser_datePaiement.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    dateChooser_datePaiement.getCalendarButton().setToolTipText("S\u00E9lectionnez la date du paiement !");
		dateChooser_datePaiement.setBounds(148, 11, 168, 31);
		panel_1.add(dateChooser_datePaiement);
		
		JLabel lblDateDePaiement = new JLabel("Date de paiement :");
		lblDateDePaiement.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDateDePaiement.setBounds(10, 11, 128, 31);
		panel_1.add(lblDateDePaiement);
		
	    btn_annulerPaiement = new JButton("Annuler");
	    btn_annulerPaiement.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btn_annulerPaiement.setToolTipText("Annuler action !");
		btn_annulerPaiement.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_annulerPaiement.setBounds(10, 230, 306, 23);
		panel_1.add(btn_annulerPaiement);
		
	    btn_modifierPaiement = new JButton("Modifier paiement");
	    btn_modifierPaiement.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btn_modifierPaiement.setToolTipText("Modifier le paiement ");
		btn_modifierPaiement.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_modifierPaiement.setBounds(10, 196, 306, 23);
		panel_1.add(btn_modifierPaiement);
		
	    btn_payer_3_Tranche = new JButton("Payer 3e tranche");
	    btn_payer_3_Tranche.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btn_payer_3_Tranche.setToolTipText("Payer la troisi\u00E8me tranche !");
		btn_payer_3_Tranche.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_payer_3_Tranche.setBounds(10, 162, 306, 23);
		panel_1.add(btn_payer_3_Tranche);
		
	    btn_payer_2_Tranche = new JButton("Payer 2e tranche");
	    btn_payer_2_Tranche.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btn_payer_2_Tranche.setToolTipText("Payer la deuxi\u00E8me tranche !");
		btn_payer_2_Tranche.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_payer_2_Tranche.setBounds(10, 128, 306, 23);
		panel_1.add(btn_payer_2_Tranche);
		
	    btn_payer_1_Tranche = new JButton("Payer 1ere tranche");
	    btn_payer_1_Tranche.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btn_payer_1_Tranche.setToolTipText("Payer la premi\u00E8re tranche !");
		btn_payer_1_Tranche.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_payer_1_Tranche.setBounds(10, 94, 306, 23);
		panel_1.add(btn_payer_1_Tranche);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scrollPane.setToolTipText("Les paiements du locataire");
		scrollPane.setBounds(24, 113, 475, 345);
		getContentPane().add(scrollPane);
		
		tablePaiementJournalier = new JTable();
		tablePaiementJournalier.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "DATE", "MONTANT"
			}
		) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(tablePaiementJournalier);
		tablePaiementJournalier.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		
		btnQuitter = new JButton("Quitter");
		btnQuitter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQuitter.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnQuitter.setBounds(730, 490, 116, 44);
		getContentPane().add(btnQuitter);
	}
    public void setId(Integer id) {
    	this.id=id;
    }
	
    public Integer getId() {
    	return this.id;
    }
	public String getDate() {
		return ((JTextField)dateChooser_datePaiement.getDateEditor().getUiComponent()).getText();
	}
	
	public void setTranche1(boolean b) {
		btn_payer_1_Tranche.setEnabled(b);
	}
	public void setTranche2(boolean b) {
		btn_payer_2_Tranche.setEnabled(b);
	}
	public void setTranche3(boolean b) {
		btn_payer_3_Tranche.setEnabled(b);
	}
	
	
	public void addTablePayerMousseListener(MouseAdapter mousseListener) {
		tablePaiementJournalier.addMouseListener(mousseListener);
		}
	public void addPayer1Listener(ActionListener actionListener) {
			// TODO Auto-generated method stub
			btn_payer_1_Tranche.addActionListener(actionListener);	
	}
	  
	  public void addPayer2Listener(ActionListener actionListener) {
			// TODO Auto-generated method stub
		  btn_payer_2_Tranche.addActionListener(actionListener);	
	}  
	  public void addPayer3Listener(ActionListener actionListener) {
			// TODO Auto-generated method stub
		  btn_payer_3_Tranche.addActionListener(actionListener);	
    }
	  
	 public void addModifierListener(ActionListener actionListener) {
			// TODO Auto-generated method stub
			btn_modifierPaiement.addActionListener(actionListener);	
	}
	 
	public void addAnnulerListener(ActionListener actionListener) {
			// TODO Auto-generated method stub
			btn_annulerPaiement.addActionListener(actionListener);	
	}
	public int selectRowTablePayer() {
		// TODO Auto-generated method stub
		return tablePaiementJournalier.getSelectedRow();
	}
	
	public void  addRowPayer(String[] line) {
		tableModel =(DefaultTableModel) tablePaiementJournalier.getModel();
		tableModel.addRow(line);
	}
	
	public String tableListePayerCol1() {
		tableModel =(DefaultTableModel) tablePaiementJournalier.getModel();
		return (String) tableModel.getValueAt(selectRowTablePayer(), 0);
	}
	public String tableListePayerCol2() {
		tableModel =(DefaultTableModel) tablePaiementJournalier.getModel();
		return (String) tableModel.getValueAt(selectRowTablePayer(), 1);
	}

	public String tableListePayerCol3() {
		tableModel =(DefaultTableModel) tablePaiementJournalier.getModel();
		return (String) tableModel.getValueAt(selectRowTablePayer(), 2);
	}
	

	public void actualiserTablePaiement() {
		tableModel =(DefaultTableModel) tablePaiementJournalier.getModel();
		int counter=0;
		counter=tableModel.getRowCount();
		while(counter!=0) {
			tableModel.removeRow(0);
		    counter--;
		}
		
	}
   public void run() {
	   setVisible(true);
   }

public void showMessage(String msg) {
	JOptionPane.showMessageDialog(null, msg);
	
}


public int showMessageConfirmation(String title,String message) {
	int retour = JOptionPane.showConfirmDialog(this,
             message, 
             title,
             JOptionPane.OK_CANCEL_OPTION);
	
	return retour;
}
public void fermerFenetre() {
	dispose();
}


public void addQuiterListener(ActionListener actionListener) {
	// TODO Auto-generated method stub
	btnQuitter.addActionListener(actionListener);	
}



}
