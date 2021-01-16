package com.app.interfaces.comptable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.app.metier.entites.Versement;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class IVersementBancaire extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JDateChooser date_Versement;
	private JSpinner spinner_Montant;
	private JSpinner spinner_SoldeCompte;
	private JTextField text_CompteBancaire;
	private JButton btn_Valider;
	private JButton btn_Annuler;
	private JLabel lblVersementBancaire;
	private JPanel panel;

	public IVersementBancaire() {
		initComponent();
	}
	private void initComponent(){
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("Versement bancaire");
		setAlwaysOnTop(true);
		setBounds(100, 100, 353, 307);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(222, 184, 135));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			btn_Valider = new JButton("Valider");
			btn_Valider.setIcon(new ImageIcon(IComptabilite.class.getResource("/checked.png")));
			btn_Valider.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btn_Valider.setBackground(new Color(205, 133, 63));
			btn_Valider.setBounds(10, 224, 139, 36);
			contentPanel.add(btn_Valider);
		}
		{
			btn_Annuler = new JButton("Fermer");
			btn_Annuler.setIcon(new ImageIcon(IComptabilite.class.getResource("/cancel.png")));
			btn_Annuler.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btn_Annuler.setBackground(new Color(205, 133, 63));
			btn_Annuler.setBounds(188, 224, 145, 36);
			contentPanel.add(btn_Annuler);
		}
		
		lblVersementBancaire = new JLabel("Versement bancaire");
		lblVersementBancaire.setHorizontalAlignment(SwingConstants.CENTER);
		lblVersementBancaire.setFont(new Font("Eras Medium ITC", Font.PLAIN, 26));
		lblVersementBancaire.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
		lblVersementBancaire.setBounds(10, 11, 323, 40);
		contentPanel.add(lblVersementBancaire);
		
		panel = new JPanel();
		panel.setBackground(new Color(210, 180, 140));
		panel.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
		panel.setBounds(10, 62, 323, 151);
		contentPanel.add(panel);
		panel.setLayout(null);
		
				JLabel lblNewLabel = new JLabel("Date : ");
				lblNewLabel.setBounds(10, 11, 303, 20);
				panel.add(lblNewLabel);
				
						date_Versement = new JDateChooser();
						date_Versement.setBounds(147, 11, 166, 20);
						panel.add(date_Versement);
						
								JLabel lblNewLabel_1 = new JLabel("Montant : ");
								lblNewLabel_1.setBounds(10, 55, 303, 14);
								panel.add(lblNewLabel_1);
								
										spinner_Montant = new JSpinner();
										spinner_Montant.setBounds(147, 52, 166, 20);
										panel.add(spinner_Montant);
										spinner_Montant.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(5)));
										
												JLabel lblNewLabel_2 = new JLabel("Solde du compte : ");
												lblNewLabel_2.setBounds(10, 86, 303, 14);
												panel.add(lblNewLabel_2);
												
														spinner_SoldeCompte = new JSpinner();
														spinner_SoldeCompte.setBounds(147, 83, 166, 20);
														panel.add(spinner_SoldeCompte);
														spinner_SoldeCompte.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(5)));
														
																JLabel lblNewLabel_3 = new JLabel("Compte bancaire : ");
																lblNewLabel_3.setBounds(10, 117, 303, 14);
																panel.add(lblNewLabel_3);
																
																		text_CompteBancaire = new JTextField();
																		text_CompteBancaire.setBounds(147, 114, 166, 20);
																		panel.add(text_CompteBancaire);
	}
	

	public String getDate() {
		return ((JTextField)date_Versement.getDateEditor().getUiComponent()).getText();
	}
	
	 public void setDate(String date) {
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
			Date dateU;
			try {
				dateU = sdf.parse(date);
				this.date_Versement.getDateEditor().setDate(dateU);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			   
	}
	
	
	public String getCompteBancaire() {
		return text_CompteBancaire.getText();
	}
	
	public void setCompteBancaire(String p) {
		text_CompteBancaire.setText(p);
	}
	
	
	public double getMontant() {
    	return ((Double)spinner_Montant.getValue()).doubleValue() ;
    }
	
	
	public double getSolde() {
    	return ((Double)spinner_SoldeCompte.getValue()).doubleValue() ;
    }
 

	public void validerListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		btn_Valider.addActionListener(actionListener);	
	}
	
	public void annulerListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		btn_Annuler.addActionListener(actionListener);	
	}
	
	
	
	public String getButtonValider() {
		return btn_Valider.getText();
	}
	public void setButtonValider(String btn_Valider) {
		this.btn_Valider.setText(btn_Valider);;
	}
	public void afficher() {
		
		this.setVisible(true);
	}
	
	public void quitter() {
		this.dispose();
	}
	
	public void effacer() {
		this.spinner_Montant.setValue(0);;
		this.spinner_SoldeCompte.setValue(0);;
		this.setCompteBancaire(null);
		
	}
	

	
      public void modifierPaiementVersement(Versement depense) {
		
    	this.setDate(depense.getDate());
		this.spinner_Montant.setValue(depense.getMontant());
		this.spinner_SoldeCompte.setValue(depense.getSoldeCompte());
		this.setCompteBancaire(String.valueOf(depense.getNumeroCompte()));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
		Date dateU;
		try {
			dateU = sdf.parse(depense.getDate());
			this.date_Versement.getDateEditor().setDate(dateU);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
      
      public Versement recupererPaiementVersement() {
    	  
    	  Versement depense =  new Versement();
  		
    	  depense.setDate(this.getDate());
    	  depense.setMontant(this.getMontant());
    	  depense.setNumeroCompte(this.getCompteBancaire());
  		  depense.setSoldeCompte(this.getSolde());
  		return depense;
  	}
	
	
	
}
