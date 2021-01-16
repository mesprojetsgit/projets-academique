package com.app.interfaces.comptable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.app.metier.entites.Depense;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class IDepense extends JDialog {

	
	private final JPanel contentPanel = new JPanel();
	private JSpinner spinner_Montant;
	private JDateChooser date_Depense;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_ModeDePaiement;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_AnneeScolaire;
	private JTextPane textPane_Motif;
	private JButton btn_Valider;
	private JButton btn_Annuler;
	/**
	 * Create the dialog.
	 */
	public IDepense() {
		initComponent();
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initComponent() {
		
		
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("D\u00E9penses");
		setMaximumSize(new Dimension(320, 325));
		setMinimumSize(new Dimension(320, 325));
		setBounds(100, 100, 309, 397);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(222, 184, 135));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Montant : ");
		lblNewLabel.setBounds(10, 72, 111, 20);
		contentPanel.add(lblNewLabel);
		
		spinner_Montant = new JSpinner();
		spinner_Montant.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(5)));
		spinner_Montant.setBounds(133, 72, 149, 20);
		contentPanel.add(spinner_Montant);

		date_Depense = new JDateChooser();
		date_Depense.setBounds(133, 104, 149, 20);
		contentPanel.add(date_Depense);
        
		String mode[]={"Liquide","Cheque", "Virement bancaire", "Transfert d'argent"};        
		comboBox_ModeDePaiement = new JComboBox(mode);
		comboBox_ModeDePaiement.setBounds(133, 136, 149, 20);
		contentPanel.add(comboBox_ModeDePaiement);

		String annee[]={"2010/2011"};        
		comboBox_AnneeScolaire = new JComboBox(annee);
		comboBox_AnneeScolaire.setBounds(133, 168, 149, 20);
		contentPanel.add(comboBox_AnneeScolaire);

		JLabel lblNewLabel_1 = new JLabel("Mode de paiement : ");
		lblNewLabel_1.setBounds(10, 136, 119, 20);
		contentPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Ann\u00E9e scolaire : ");
		lblNewLabel_2.setBounds(10, 168, 111, 20);
		contentPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Date : ");
		lblNewLabel_3.setBounds(10, 103, 111, 21);
		contentPanel.add(lblNewLabel_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 224, 272, 72);
		contentPanel.add(scrollPane);

		textPane_Motif = new JTextPane();
		scrollPane.setViewportView(textPane_Motif);
		textPane_Motif.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));

		JLabel lblNewLabel_4 = new JLabel("Motif : ");
		lblNewLabel_4.setBounds(10, 208, 56, 14);
		contentPanel.add(lblNewLabel_4);

		btn_Valider = new JButton("Valider");
		btn_Valider.setIcon(new ImageIcon(IComptabilite.class.getResource("/checked.png")));
		btn_Valider.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Valider.setBackground(new Color(205, 133, 63));
		btn_Valider.setBounds(10, 316, 128, 33);
		contentPanel.add(btn_Valider);

		btn_Annuler = new JButton("Fermer");
		btn_Annuler.setIcon(new ImageIcon(IComptabilite.class.getResource("/cancel.png")));
		btn_Annuler.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Annuler.setBackground(new Color(205, 133, 63));
		btn_Annuler.setBounds(154, 316, 128, 33);
		contentPanel.add(btn_Annuler);
		
		JLabel lblDpense = new JLabel("D\u00E9pense");
		lblDpense.setHorizontalAlignment(SwingConstants.CENTER);
		lblDpense.setFont(new Font("Eras Medium ITC", Font.PLAIN, 20));
		lblDpense.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
		lblDpense.setBounds(10, 11, 272, 40);
		contentPanel.add(lblDpense);
		
	}

	public double getMontant() {
	
		return ((Double)spinner_Montant.getValue()).doubleValue();
	}
	
	public String getModePaiement() {
		return (String) comboBox_ModeDePaiement.getSelectedItem();
	}
	public String getAnneeScolaire() {
		return (String) comboBox_AnneeScolaire.getSelectedItem();
	}
	
	public String getMotif() {
		return textPane_Motif.getText();
	}
	public String getDateDepense() {
		return ((JTextField)date_Depense.getDateEditor().getUiComponent()).getText();
	}

	 public void setDatePaiement(String date) {
		 java.util.Date date2;
			try {
				date2 = new SimpleDateFormat("dd MMM yyyy").parse(date);
				this.date_Depense.setDate(date2);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	   
}
	
	public void setModePaiement(String p) {
		comboBox_ModeDePaiement.setSelectedItem(p);
	}
	public void setAnneeScolaire(String annee) {
		comboBox_AnneeScolaire.setSelectedItem(annee);
	}
	
	public void setMotif(String motif) {
		textPane_Motif.setText(motif);
	}
	public void setMontant(double montant) {
		spinner_Montant.setValue(montant);
	}
	
	public String getButtonValider() {
		return btn_Valider.getText();
	}
	public void setButtonValider(String btn_Valider) {
		this.btn_Valider.setText(btn_Valider);
	}
	public void validerListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		btn_Valider.addActionListener(actionListener);	
	}
	
	public void annulerListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		btn_Annuler.addActionListener(actionListener);	
	}
	
	
	public void afficher() {
		this.setVisible(true);
		
	}
	
	public void quitter() {
		this.dispose();
	}
	
	public void effacer() {
		
		this.setMontant(0);
		this.setMotif(null);
		this.spinner_Montant.setValue(0);
		this.setModePaiement(null);
		this.setAnneeScolaire(null);
		
	}

      public void modifierDepense(Depense depense) {
    	this.setButtonValider("changer"); 
    	this.setMontant(depense.getMontant());
		this.setMotif(depense.getMotif());
		this.spinner_Montant.setValue(depense.getMontant());;
		this.setAnneeScolaire(depense.getAnneeScolaire());
		this.setDatePaiement(depense.getDate());	
		this.setModePaiement(depense.getModePaiement());
		
	}
      
    
      
      public Depense recupererDepense() {
    	  
    	  Depense depense =  new Depense();
    	  depense.setAnneeScolaire(this.getAnneeScolaire());
    	  depense.setDate(this.getDateDepense());
    	  depense.setModePaiement(this.getModePaiement());
    	  depense.setMontant(this.getMontant());;
    	  depense.setMotif(this.getMotif());
  		  return depense;
  	      }
	
   
     }
	

