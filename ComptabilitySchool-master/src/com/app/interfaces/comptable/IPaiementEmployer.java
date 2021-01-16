package com.app.interfaces.comptable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.app.metier.entites.Paiement;
import com.app.metier.entites.PaiementEmployer;
import com.app.metier.entites.Personnel;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class IPaiementEmployer extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextPane textPane_nom;
	private JTextPane textPane_Salaire;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_Mois;
	private JDateChooser date_Paiement;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_ModeDePaiement;
	private JButton btn_Payer;
	private JButton btn_Annuler;
	@SuppressWarnings("unused")
	private Paiement paiement;
	private JTextPane textPane_Salaire_1,textPane_prenom;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public IPaiementEmployer() {
		setResizable(false);

		initComponent();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initComponent() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Paiement Employer");
		setBounds(100, 100, 403, 361);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(222, 184, 135));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			btn_Payer = new JButton("Payer");
			btn_Payer.setIcon(new ImageIcon(IComptabilite.class.getResource("/checked.png")));
			btn_Payer.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btn_Payer.setBackground(new Color(205, 133, 63));
			btn_Payer.setBounds(265, 225, 109, 33);
			contentPanel.add(btn_Payer);
		}
		{
			String mois[]= {"Janvier","Fevrier","Mars","Avril","Mai","Juin","Juillet","Aout","Septembre","Octobre","Novembre","Decembre"};
			comboBox_Mois = new JComboBox(mois);
			comboBox_Mois.setBounds(134, 225, 121, 20);
			contentPanel.add(comboBox_Mois);
		}
		{
			date_Paiement = new JDateChooser();
			date_Paiement.setBounds(134, 256, 121, 20);
			contentPanel.add(date_Paiement);
		}
		{
			comboBox_ModeDePaiement = new JComboBox();
			comboBox_ModeDePaiement.setModel(new DefaultComboBoxModel(new String[] {"Liquide", "Ch\u00E8que", "Virement bancaire", "Transfert d'argent"}));
			comboBox_ModeDePaiement.setBounds(134, 287, 121, 20);
			contentPanel.add(comboBox_ModeDePaiement);
		}
		{
			btn_Annuler = new JButton("Annuler");
			btn_Annuler.setIcon(new ImageIcon(IComptabilite.class.getResource("/cancel.png")));
			btn_Annuler.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btn_Annuler.setBackground(new Color(205, 133, 63));
			btn_Annuler.setBounds(265, 269, 109, 38);
			contentPanel.add(btn_Annuler);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Mois : ");
			lblNewLabel_2.setBounds(10, 225, 46, 20);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Date : ");
			lblNewLabel_1.setBounds(10, 256, 67, 20);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2_2 = new JLabel("Mode de paiement : ");
			lblNewLabel_2_2.setBounds(10, 287, 114, 20);
			contentPanel.add(lblNewLabel_2_2);
		}

		JPanel panel = new JPanel();
		panel.setBackground(new Color(210, 180, 140));
		panel.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
		panel.setBounds(10, 65, 364, 135);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			textPane_Salaire = new JTextPane();
			textPane_Salaire.setBounds(95, 104, 259, 20);
			panel.add(textPane_Salaire);
			textPane_Salaire.setEditable(false);
		}
		{
			textPane_nom = new JTextPane();
			textPane_nom.setBounds(95, 11, 259, 20);
			panel.add(textPane_nom);
			textPane_nom.setEditable(false);
		}
		{
			JLabel lblEmployer = new JLabel("Nom : ");
			lblEmployer.setBounds(10, 11, 75, 20);
			panel.add(lblEmployer);
		}
		{
			JLabel lblSalaire = new JLabel("Salaire : ");
			lblSalaire.setBounds(10, 104, 75, 20);
			panel.add(lblSalaire);
		}
		
		textPane_Salaire_1 = new JTextPane();
		textPane_Salaire_1.setEditable(false);
		textPane_Salaire_1.setBounds(95, 73, 259, 20);
		panel.add(textPane_Salaire_1);
		
		JLabel lblPoste = new JLabel("Poste : ");
		lblPoste.setBounds(10, 73, 75, 20);
		panel.add(lblPoste);
		
		JLabel lblNewLabel = new JLabel("Prenom");
		lblNewLabel.setBounds(10, 42, 46, 14);
		panel.add(lblNewLabel);
		
		textPane_prenom = new JTextPane();
		textPane_prenom.setEditable(false);
		textPane_prenom.setBounds(95, 42, 259, 20);
		panel.add(textPane_prenom);
		{
			JLabel lbl = new JLabel("Paiement employer");
			lbl.setHorizontalAlignment(SwingConstants.CENTER);
			lbl.setFont(new Font("Eras Medium ITC", Font.PLAIN, 26));
			lbl.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
			lbl.setBounds(10, 11, 364, 40);
			contentPanel.add(lbl);
		}
	}
	
	
	public String getSalaire() {
		return textPane_Salaire.getText();
	}
	public void  setSalaire(String employe) {
		textPane_Salaire.setText(employe);
	}

	public String getNom() {
		return textPane_nom.getText();
	}
	
	public void  setNom(String employe) {
		textPane_nom.setText(employe);
	}
	public String getDatePaiement() {
		return ((JTextField)date_Paiement.getDateEditor().getUiComponent()).getText();
	}
	
	public String getModePaiement() {
		return comboBox_ModeDePaiement.getSelectedItem().toString();
	}
	
	public void setModePaiement(String p) {
		comboBox_ModeDePaiement.setSelectedItem(p);
	}
	
	public void setMois(String annee) {
		comboBox_Mois.setSelectedItem(annee);
	}
	public String getMois() {
		return comboBox_Mois.getSelectedItem().toString();
	}
		
	
	public JDateChooser getDate_Paiement() {
		return date_Paiement;
	}

	public void setDate_Paiement(String date) {
		 java.util.Date date2;
			try {
				date2 = new SimpleDateFormat("dd MMM yyyy").parse(date);
				this.date_Paiement.setDate(date2);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	   
	}

	public String getTextPane_prenom() {
		return textPane_prenom.getText();
	}

	public void setTextPane_prenom(String textPane_prenom) {
		this.textPane_prenom.setText(textPane_prenom);
	}

	public String getSalaire1() {
		return textPane_Salaire_1.getText();
	}
	public void  setSalaire1(String employe) {
		textPane_Salaire_1.setText(employe);
	}

	public void payerListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		btn_Payer.addActionListener(actionListener);	
	}
	
	public void annulerListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		btn_Annuler.addActionListener(actionListener);	
	}
	
	
	
	
    public String getBtn_Payer() {
		return btn_Payer.getText();
	}

	public void afficher() {
		
		this.setVisible(true);
	}
	
	public void quitter() {
		this.dispose();
	}
	
	public void effacer() {
		
		this.setNom(null);
		this.setTextPane_prenom(null);
		this.setSalaire1(null);;
		this.setSalaire(null);
		this.setMois(null);
		this.setModePaiement(null);
		
	}
	
	
	public void chargerTableEditeur(Personnel depense) {
		   
		this.btn_Payer.setText("Payer");
		this.setNom(depense.getNom());
		this.setTextPane_prenom(depense.getPrenom());;
		this.setSalaire(String.valueOf(depense.getSalaire()));
		this.setSalaire1(depense.getPoste());
	}
	
	
	
      public void modifierPaiementEmployer(PaiementEmployer depense) {
		
    	  
    	this.btn_Payer.setText("Mise a jour");
		this.setNom(depense.getNom());
		this.setTextPane_prenom(depense.getPrenom());
		this.setSalaire1(depense.getPoste());
		this.setSalaire(String.valueOf(depense.getMontant()));
		this.setMois(depense.getMois());
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
		Date dateU;
		try {
			dateU = sdf.parse(depense.getDate());
			this.date_Paiement.getDateEditor().setDate(dateU);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setModePaiement(depense.getModeDePaiement());
		
	}
	
	
      
      public PaiementEmployer recupererPaiementEmployer() {
    	  
    	  PaiementEmployer depense =  new PaiementEmployer();
  		
    	depense.setNom(this.getNom());
    	depense.setPrenom(this.getTextPane_prenom());
    	depense.setPoste(this.getSalaire1());
    	depense.setMontant(Double.valueOf(this.getSalaire()));
    	depense.setMois(this.getMois());
    	depense.setDate(this.getDatePaiement());
    	depense.setModeDePaiement(this.getModePaiement());
  		  		
  		return depense;
  	}
}
