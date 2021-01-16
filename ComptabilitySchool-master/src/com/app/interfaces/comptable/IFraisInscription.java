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
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.app.metier.entites.Eleve;
import com.app.metier.entites.FraisInscription;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class IFraisInscription extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextPane textPane_Classe;
	private JTextPane textPane_nomEleve;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_AnneeScolaire;
	private JDateChooser date_Paiement;
	private JSpinner spinner_Montant;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_ModeDePaiement;
	private JButton btn_Valider;
	private JButton btn_Annuler;
	private JTextPane textPane_prenomEleve,textPane_Matricule ;
	

	public IFraisInscription() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		initComponent();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initComponent() {
		setResizable(false);
		setTitle("Frais d'inscription");
		setBounds(100, 100, 360, 438);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(222, 184, 135));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblDateDePaiement = new JLabel("Date de paiement : ");
			lblDateDePaiement.setBounds(10, 247, 111, 20);
			contentPanel.add(lblDateDePaiement);
		}
		{
			date_Paiement = new JDateChooser();
			date_Paiement.setBounds(134, 247, 200, 20);
			contentPanel.add(date_Paiement);
		}
		{
			spinner_Montant = new JSpinner();
			spinner_Montant.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(5)));
			spinner_Montant.setBounds(134, 278, 200, 20);
			contentPanel.add(spinner_Montant);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Montant : ");
			lblNewLabel_1.setBounds(10, 278, 111, 20);
			contentPanel.add(lblNewLabel_1);
		}
		{
			btn_Valider = new JButton("Valider");
			btn_Valider.setIcon(new ImageIcon(IComptabilite.class.getResource("/checked.png")));
			btn_Valider.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btn_Valider.setBackground(new Color(205, 133, 63));
			btn_Valider.setBounds(10, 353, 139, 40);
			contentPanel.add(btn_Valider);
		}
		{
			btn_Annuler = new JButton("Annuler");
			btn_Annuler.setIcon(new ImageIcon(IComptabilite.class.getResource("/cancel.png")));
			btn_Annuler.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btn_Annuler.setBackground(new Color(205, 133, 63));
			btn_Annuler.setBounds(195, 353, 139, 40);
			contentPanel.add(btn_Annuler);
		}
		{
			comboBox_ModeDePaiement = new JComboBox();
			comboBox_ModeDePaiement.setModel(new DefaultComboBoxModel(new String[] {"Liquide", "Ch\u00E8que", "Virement bancaire", "Transfert d'argent"}));
			comboBox_ModeDePaiement.setBounds(134, 309, 200, 20);
			contentPanel.add(comboBox_ModeDePaiement);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Mode de paiement : ");
			lblNewLabel_2.setBounds(10, 309, 119, 20);
			contentPanel.add(lblNewLabel_2);
		}
		{
			String annee[]= {"2010/2011","2011/2012"};
			comboBox_AnneeScolaire = new JComboBox(annee);
			comboBox_AnneeScolaire.setBounds(134, 216, 200, 20);
			contentPanel.add(comboBox_AnneeScolaire);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Ann\u00E9e scolaire : ");
			lblNewLabel_2.setBounds(10, 216, 119, 20);
			contentPanel.add(lblNewLabel_2);
		}
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(210, 180, 140));
		panel.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
		panel.setBounds(10, 65, 324, 137);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			textPane_Classe = new JTextPane();
			textPane_Classe.setBounds(74, 11, 237, 20);
			panel.add(textPane_Classe);
			textPane_Classe.setEditable(false);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Classe : ");
			lblNewLabel_2.setBounds(10, 11, 54, 20);
			panel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Nom : ");
			lblNewLabel_2.setBounds(10, 42, 54, 20);
			panel.add(lblNewLabel_2);
		}
		{
			textPane_nomEleve = new JTextPane();
			textPane_nomEleve.setBounds(74, 42, 237, 20);
			panel.add(textPane_nomEleve);
			textPane_nomEleve.setEditable(false);
		}
		
		textPane_Matricule = new JTextPane();
		textPane_Matricule.setEditable(false);
		textPane_Matricule.setBounds(74, 104, 237, 20);
		panel.add(textPane_Matricule);
		
		JLabel lblNewLabel_2 = new JLabel("Matricule : ");
		lblNewLabel_2.setBounds(10, 104, 65, 20);
		panel.add(lblNewLabel_2);
		
		textPane_prenomEleve = new JTextPane();
		textPane_prenomEleve.setEditable(false);
		textPane_prenomEleve.setBounds(74, 73, 237, 20);
		panel.add(textPane_prenomEleve);
		
		JLabel lblNewLabel_2_1 = new JLabel("Prenom : ");
		lblNewLabel_2_1.setBounds(10, 73, 54, 20);
		panel.add(lblNewLabel_2_1);
		{
			JLabel lbl = new JLabel("Frais d'inscription");
			lbl.setHorizontalAlignment(SwingConstants.CENTER);
			lbl.setFont(new Font("Eras Medium ITC", Font.PLAIN, 26));
			lbl.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
			lbl.setBounds(10, 11, 324, 40);
			contentPanel.add(lbl);
		}
		
	}
	

	
	public String getMatricule() {
		return textPane_Matricule.getText();
	}

	public void setMatricule(String textPane_Matricule) {
		this.textPane_Matricule.setText(textPane_Matricule);
	}

	public String getDatePaiement() {
		return ((JTextField)date_Paiement.getDateEditor().getUiComponent()).getText();
	}
   public void setDatePaiement(String date) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
		Date dateU;
		try {
			dateU = sdf.parse(date);
			this.date_Paiement.getDateEditor().setDate(dateU);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		   
		}

	public String getModePaiement() {
		return comboBox_ModeDePaiement.getSelectedItem().toString();
	}
	
	public void setModePaiement(String p) {
		comboBox_ModeDePaiement.setSelectedItem(p);
	}
	
	
	
	public String getButtonValider() {
		return btn_Valider.getText();
	}

	public void setButtonValider(String text) {
		this.btn_Valider.setText(text);;
	}

	public void setAnneeScolaire(String annee) {
		comboBox_AnneeScolaire.setSelectedItem(annee);
	}
	public String getAnneeScolaire() {
		return comboBox_AnneeScolaire.getSelectedItem().toString();
	}
	
	public double getMontant() {
		return ((Double)spinner_Montant.getValue()).doubleValue() ;
	}
	public void setMontant(double montant) {
		spinner_Montant.setValue(montant);;
	}
	public String getClasse() {
		return textPane_Classe.getText();
	}
	public void setClasse(String classe) {
		textPane_Classe.setText(classe);
	}
	public String getNom() {
		return textPane_nomEleve.getText();
	}
	public void setNom(String eleve) {
		textPane_nomEleve.setText(eleve);
	}
	
	
	public String getPrenom() {
		return textPane_prenomEleve.getText();
	}

	public void setPrenom(String textPane_prenomEleve) {
		this.textPane_prenomEleve.setText(textPane_prenomEleve);
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
		
		this.setClasse(null);
		this.setNom(null);
		this.setPrenom(null);
		this.setMatricule(null);
		this.setAnneeScolaire(null);
		this.setModePaiement(null);
		this.setMontant(0.0);
	}
	
	
	public void chargerTableEditeur(Eleve depense) {
		this.setClasse(depense.getClasse());
		this.setNom(depense.getNom());
		this.setPrenom(depense.getPrenom());
		this.setMatricule(depense.getNumeroMatricule());
		
	}
	
	
	
      public void modifierPaiementProf(FraisInscription depense) {
		
    	this.setButtonValider("changer"); 
    	this.setClasse(depense.getClasse());
  		this.setNom(depense.getNom());
  		this.setPrenom(depense.getPrenom());
  		this.setMatricule(depense.getMatricule());
    	this.setAnneeScolaire(depense.getAnneeScolaire()); 
		this.setDatePaiement(depense.getDate());
		this.setMontant(depense.getMontant());
		this.setModePaiement(depense.getModeDePaiement());		
		
	}
	
	
      
      public FraisInscription recupererFraisInscription() {
    	  
    	  FraisInscription depense =  new FraisInscription();
    	  
    	  depense.setClasse(this.getClasse());
    	  depense.setNom(this.getNom());
    	  depense.setPrenom(this.getPrenom());
    	  depense.setDate(this.getDatePaiement());
    	  depense.setMatricule(this.getMatricule());
    	  depense.setAnneeScolaire(this.getAnneeScolaire()); 
    	  depense.setModeDePaiement(String.valueOf(this.getDatePaiement()));
    	  depense.setMontant(this.getMontant());
    	  depense.setModeDePaiement(String.valueOf(this.getModePaiement()));	
  		
  		  return depense;
  	}
	
}
