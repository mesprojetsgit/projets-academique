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



public class IPaiementMensuel extends IPaiement {
	private JButton btn_annulerPaiement;
	private JButton btn_modifierPaiement;
	private JButton btn_payer;

	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tablePaiementMensuel;
	DefaultTableModel tableModel = new DefaultTableModel();
	private Integer id;
	private double montant;
	private JDateChooser dateChooser_datePaiement;
	private JButton btnQuitter;
	
	public IPaiementMensuel(Integer id,double montant) {
		this.id=id;
		this.montant=montant;
		component();
	}
	
	
	@SuppressWarnings("serial")
	public void component() {
		JLabel lblPaiementMensuel = new JLabel("Paiement Mensuel");
		lblPaiementMensuel.setToolTipText("Vous \u00EAtes dans un paiement mensuel !");
		lblPaiementMensuel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPaiementMensuel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaiementMensuel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPaiementMensuel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblPaiementMensuel.setBounds(10, 490, 234, 44);
		getContentPane().add(lblPaiementMensuel);
		
		JLabel label_coutLoyer = new JLabel("");
		label_coutLoyer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_coutLoyer.setToolTipText("Montant \u00E0 payer !");
		label_coutLoyer.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_coutLoyer.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		label_coutLoyer.setBounds(527, 110, 307, 75);
		getContentPane().add(label_coutLoyer);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_1.setBounds(527, 196, 307, 262);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		dateChooser_datePaiement = new JDateChooser();
		dateChooser_datePaiement.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooser_datePaiement.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooser_datePaiement.setToolTipText("S\u00E9lectionnez la date du paiement !");
		dateChooser_datePaiement.getCalendarButton().setToolTipText("S\u00E9lectionnez la date du paiement !");
		dateChooser_datePaiement.setBounds(164, 11, 133, 32);
		panel_1.add(dateChooser_datePaiement);
		
		JLabel lblDateDePaiement = new JLabel("Date de paiement :");
		lblDateDePaiement.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDateDePaiement.setBounds(10, 11, 133, 32);
		panel_1.add(lblDateDePaiement);
		
	    btn_annulerPaiement = new JButton("Annuler");
	    btn_annulerPaiement.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btn_annulerPaiement.setToolTipText("Annuler action !");
		btn_annulerPaiement.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_annulerPaiement.setBounds(10, 219, 287, 32);
		panel_1.add(btn_annulerPaiement);
		
		 btn_modifierPaiement = new JButton("Modifier");
		 btn_modifierPaiement.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 btn_modifierPaiement.setToolTipText("Modifier un paiement !");
		btn_modifierPaiement.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_modifierPaiement.setBounds(10, 176, 287, 32);
		panel_1.add(btn_modifierPaiement);
		
	    btn_payer = new JButton("Payer");
	    btn_payer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btn_payer.setToolTipText("Effectuer un paiement !");
		btn_payer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_payer.setBounds(10, 133, 287, 32);
		panel_1.add(btn_payer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scrollPane.setToolTipText("Les paiements du locataire !");
		scrollPane.setBounds(22, 113, 495, 345);
		getContentPane().add(scrollPane);
		
		tablePaiementMensuel = new JTable();
		tablePaiementMensuel.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "DATE PAIEMENT", "MONTANT"
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
		tablePaiementMensuel.getColumnModel().getColumn(1).setPreferredWidth(100);
		scrollPane.setViewportView(tablePaiementMensuel);
		tablePaiementMensuel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		
	    btnQuitter = new JButton("Quitter");
		btnQuitter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQuitter.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnQuitter.setBounds(731, 490, 115, 44);
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
		
		

		public double getMontant() {
			return montant;
		}


		public void setMontant(double montant) {
			this.montant = montant;
		}


		public void addTablePayerMousseListener(MouseAdapter mousseListener) {
			tablePaiementMensuel.addMouseListener(mousseListener);
			}
		public void addPayerListener(ActionListener actionListener) {
				// TODO Auto-generated method stub
				btn_payer.addActionListener(actionListener);	
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
			return tablePaiementMensuel.getSelectedRow();
		}
		
		public void  addRowPayer(String[] line) {
			tableModel =(DefaultTableModel) tablePaiementMensuel.getModel();
			tableModel.addRow(line);
		}
		
		public String tableListePayerCol1() {
			tableModel =(DefaultTableModel) tablePaiementMensuel.getModel();
			return (String) tableModel.getValueAt(selectRowTablePayer(), 0);
		}
		public String tableListePayerCol2() {
			tableModel =(DefaultTableModel) tablePaiementMensuel.getModel();
			return (String) tableModel.getValueAt(selectRowTablePayer(), 1);
		}

		public String tableListePayerCol3() {
			tableModel =(DefaultTableModel) tablePaiementMensuel.getModel();
			return (String) tableModel.getValueAt(selectRowTablePayer(), 2);
		}
		

		public void actualiserPayer() {
			tableModel =(DefaultTableModel) tablePaiementMensuel.getModel();
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
