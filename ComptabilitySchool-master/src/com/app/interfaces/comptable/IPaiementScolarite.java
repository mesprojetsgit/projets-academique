package com.app.interfaces.comptable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
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

import com.app.metier.entites.Eleve;
import com.app.metier.entites.PaiementScolarite;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class IPaiementScolarite extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_Libelle;
	private JTextField textField_NumeroRecu;
	private JTextPane textPane_NumeroPaiement;
	private JTextPane textPane_Classe;
	private JTextPane textPane_nomEleve;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_AnneeScolaire;
	private JDateChooser date_Paiement;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_ModeDePaiement;
	private JTextPane textPane_Observation;
	private JTextField textField_MontantScolarite;
	private JSpinner spinner_MontantTotal;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_Tranche;
	private JButton btn_Valider;
	private JButton btn_Annuler;
	private JTextPane textPane_prenomEleve;
	private JTextPane textPane_Matricule;

	
	public IPaiementScolarite() {
		initComponent();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initComponent() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Paiement scolarit\u00E9");
		setResizable(false);
		setBounds(100, 100, 556, 536);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(222, 184, 135));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(210, 180, 140));
		panel.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
		panel.setBounds(10, 102, 515, 103);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Libell\u00E9 : ");
		lblNewLabel_2.setBounds(10, 75, 46, 14);
		panel.add(lblNewLabel_2);

		textField_Libelle = new JTextField();
		textField_Libelle.setBounds(76, 72, 429, 20);
		panel.add(textField_Libelle);
		textField_Libelle.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Classe : ");
		lblNewLabel_2_1.setBounds(10, 11, 54, 20);
		panel.add(lblNewLabel_2_1);

		JLabel lblNewLabel_1 = new JLabel("Nom : ");
		lblNewLabel_1.setBounds(10, 42, 46, 20);
		panel.add(lblNewLabel_1);

		textPane_Classe = new JTextPane();
		textPane_Classe.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		textPane_Classe.setEditable(false);
		textPane_Classe.setBounds(76, 11, 127, 20);
		panel.add(textPane_Classe);

		textPane_nomEleve = new JTextPane();
		textPane_nomEleve.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		textPane_nomEleve.setEditable(false);
		textPane_nomEleve.setBounds(76, 42, 127, 20);
		panel.add(textPane_nomEleve);
		
		textPane_prenomEleve = new JTextPane();
		textPane_prenomEleve.setEditable(false);
		textPane_prenomEleve.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		textPane_prenomEleve.setBounds(288, 42, 217, 20);
		panel.add(textPane_prenomEleve);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prenom : ");
		lblNewLabel_1_1.setBounds(213, 41, 65, 20);
		panel.add(lblNewLabel_1_1);
		
		textPane_Matricule = new JTextPane();
		textPane_Matricule.setEditable(false);
		textPane_Matricule.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		textPane_Matricule.setBounds(288, 11, 217, 20);
		panel.add(textPane_Matricule);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Matricule : ");
		lblNewLabel_1_1_1.setBounds(213, 14, 65, 20);
		panel.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_3 = new JLabel("Ann\u00E9e scolaire : ");
		lblNewLabel_3.setBounds(10, 232, 103, 14);
		contentPanel.add(lblNewLabel_3);

		String [] annee = {"2020/2021"};
		comboBox_AnneeScolaire = new JComboBox(annee);
		comboBox_AnneeScolaire.setBounds(123, 229, 133, 20);
		contentPanel.add(comboBox_AnneeScolaire);

		date_Paiement = new JDateChooser();
		date_Paiement.setBounds(123, 257, 133, 20);
		contentPanel.add(date_Paiement);

		textField_NumeroRecu = new JTextField();
		textField_NumeroRecu.setBounds(123, 288, 133, 20);
		contentPanel.add(textField_NumeroRecu);
		textField_NumeroRecu.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Num\u00E9ro de re\u00E7u : ");
		lblNewLabel_4.setBounds(10, 291, 103, 14);
		contentPanel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Date : ");
		lblNewLabel_5.setBounds(10, 260, 103, 14);
		contentPanel.add(lblNewLabel_5);

		spinner_MontantTotal = new JSpinner();
		spinner_MontantTotal.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(5)));
		spinner_MontantTotal.setBounds(364, 367, 161, 20);
		contentPanel.add(spinner_MontantTotal);

		String [] mode = {"wester","money"};
		comboBox_ModeDePaiement = new JComboBox(mode);
		comboBox_ModeDePaiement.setModel(new DefaultComboBoxModel(new String[] {"Liquide", "Ch\u00E8que", "Virement bancaire", "Transfert d'argent"}));
		comboBox_ModeDePaiement.setBounds(123, 319, 133, 20);
		contentPanel.add(comboBox_ModeDePaiement);

		JLabel lblNewLabel_6 = new JLabel("Montant : ");
		lblNewLabel_6.setBounds(276, 367, 78, 20);
		contentPanel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Mode de paiement : ");
		lblNewLabel_7.setBounds(10, 322, 118, 14);
		contentPanel.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Paiement N\u00B0 ");
		lblNewLabel_8.setBounds(10, 77, 90, 20);
		contentPanel.add(lblNewLabel_8);

		textPane_NumeroPaiement = new JTextPane();
		textPane_NumeroPaiement.setEditable(false);
		textPane_NumeroPaiement.setBackground(SystemColor.window);
		textPane_NumeroPaiement.setBounds(110, 77, 94, 20);
		contentPanel.add(textPane_NumeroPaiement);

		textField_MontantScolarite = new JTextField();
		textField_MontantScolarite.setEditable(false);
		textField_MontantScolarite.setBounds(352, 77, 173, 20);
		contentPanel.add(textField_MontantScolarite);

		JLabel lblNewLabel_9 = new JLabel("Scolarit\u00E9 : ");
		lblNewLabel_9.setBounds(276, 80, 78, 14);
		contentPanel.add(lblNewLabel_9);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(276, 247, 249, 92);
		contentPanel.add(scrollPane);

		textPane_Observation = new JTextPane();
		scrollPane.setViewportView(textPane_Observation);

		JLabel lblNewLabel_12 = new JLabel("Observation : ");
		lblNewLabel_12.setBounds(276, 232, 112, 14);
		contentPanel.add(lblNewLabel_12);

		String [] tranche = {"1","2","3"};
		comboBox_Tranche = new JComboBox(tranche);
		comboBox_Tranche.setBounds(98, 364, 132, 23);
		contentPanel.add(comboBox_Tranche);

		JLabel lblNewLabel_13 = new JLabel("Tranche N\u00B0 : ");
		lblNewLabel_13.setBounds(10, 364, 78, 23);
		contentPanel.add(lblNewLabel_13);

		btn_Valider = new JButton("Valider");
		btn_Valider.setIcon(new ImageIcon(IComptabilite.class.getResource("/checked.png")));
		btn_Valider.setBackground(new Color(205, 133, 63));
		btn_Valider.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Valider.setBounds(233, 444, 133, 42);
		contentPanel.add(btn_Valider);

		btn_Annuler = new JButton("Annuler");
		btn_Annuler.setIcon(new ImageIcon(IComptabilite.class.getResource("/cancel.png")));
		btn_Annuler.setBackground(new Color(205, 133, 63));
		btn_Annuler.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Annuler.setBounds(392, 444, 133, 42);
		contentPanel.add(btn_Annuler);
		
		JLabel lbl = new JLabel("Paiement scolarit\u00E9");
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setFont(new Font("Eras Medium ITC", Font.PLAIN, 26));
		lbl.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
		lbl.setBounds(10, 11, 515, 40);
		contentPanel.add(lbl);
	}
	
	
	public double montantMontantTotal() {
    	return ((Double)spinner_MontantTotal.getValue()).doubleValue() ;
    }
	
	public String getObservation() {
		return textPane_Observation.getText();
	}
	public void  setObservation(String employe) {
		textPane_Observation.setText(employe);
	}
	public String getAnneeScolaire() {
		return comboBox_AnneeScolaire.getSelectedItem().toString();
	}
	public void setAnneeScolaire(String annee) {
		comboBox_AnneeScolaire.setSelectedItem(annee);
	}
	public String getEleve() {
		return textPane_nomEleve.getText();
	}
	public void  setEleve(String employe) {
		textPane_nomEleve.setText(employe);
	}
	public String getClasse() {
		return textPane_Classe.getText();
	}
	public void  setClasse(String employe) {
		textPane_Classe.setText(employe);
	}
	public String getNumeroPaiement() {
		return textPane_NumeroPaiement.getText();
	}
	public void  setNumeroPaiement(String employe) {
		textPane_NumeroPaiement.setText(employe);
	}
	public String getLibelle() {
		return textField_Libelle.getText();
	}
	public void  setLibelle(String employe) {
		textField_Libelle.setText(employe);
	}
	
	public String getTextField_MontantScolarite() {
		return textField_MontantScolarite.getText();
	}

	public void setTextField_MontantScolarite(String textField_MontantScolarite) {
		this.textField_MontantScolarite.setText(textField_MontantScolarite);
	}

	public String getNumeroRecu() {
		return textField_NumeroRecu.getText();
	}
	
	public void  setNumeroRecu(String employe) {
		textField_NumeroRecu.setText(employe);
	}
	public String getDatePaiement() {
	return	((JTextField)date_Paiement.getDateEditor().getUiComponent()).getText();
				
	}
	public void setDatePaiement(String date) {
		 java.util.Date date2;
			try {
				date2 = new SimpleDateFormat("dd MMM yyyy").parse(date);
				this.date_Paiement.setDate(date2);
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
	
	public void setTranche(String annee) {
		comboBox_Tranche.setSelectedItem(annee);
	}
	public String getTranche() {
		return comboBox_Tranche.getSelectedItem().toString();
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
		this.btn_Valider.setText(btn_Valider);
	}

	public String getTextPane_Matricule() {
		return textPane_Matricule.getText();
	}

	public void setTextPane_Matricule(String textPane_Matricule) {
		this.textPane_Matricule.setText(textPane_Matricule);
	}

	public String getTextPane_nomEleve() {
		return textPane_nomEleve.getText();
	}

	public void setTextPane_nomEleve(String textPane_nomEleve) {
		this.textPane_nomEleve.setText(textPane_nomEleve);
	}

	public String getTextPane_prenomEleve() {
		return textPane_prenomEleve.getText();
	}

	public void setTextPane_prenomEleve(String textPane_prenomEleve) {
		this.textPane_prenomEleve.setText(textPane_prenomEleve);
	}

	public void effacer() {
		
		this.setNumeroPaiement(null);
		this.setClasse(null);
		this.setTextPane_nomEleve(null);
		this.setTextPane_prenomEleve(null);
		this.setTextPane_Matricule(null);
		this.setLibelle(null);
		this.setNumeroRecu(null);
		this.setAnneeScolaire(null);
		this.spinner_MontantTotal.setValue(0);;
		this.setTranche(null);
		this.setObservation(null);
		
	}
	
	public void quitter() {
		effacer();
		this.dispose();
	}
	
	
	public void afficher() {
		
		this.setVisible(true);
	}
	
	public void chargerEleve(Eleve eleve) {
	this.setNumeroPaiement(String.valueOf(eleve.getId()));
	this.setTextField_MontantScolarite(String.valueOf(eleve.getScolarite()));
	this.setTextPane_nomEleve(eleve.getNom());
	this.setTextPane_prenomEleve(eleve.getPrenom());
	this.setTextPane_Matricule(eleve.getNumeroMatricule());
	this.setClasse(eleve.getClasse());
		
		
	}
	 public void modifierPaiementScolarite(PaiementScolarite depense) {
			
	    	this.setButtonValider("changer"); 
	    	this.setNumeroPaiement(String.valueOf(depense.getNumeroPaiement()));
	    	this.setClasse(depense.getNomClasse());
	    	this.setTextPane_nomEleve(depense.getNom());
	    	this.setTextPane_prenomEleve(depense.getPrenom());
	    	this.setTextPane_Matricule(depense.getNumeroMatricule());
	    	this.setLibelle(depense.getLibele());
	    	this.setNumeroRecu(String.valueOf(depense.getNumeroRecu()));
			this.setTextField_MontantScolarite(String.valueOf(depense.getMontantScolarite()));
	    	this.setAnneeScolaire(depense.getAnneeScolarite());
	    	this.setDatePaiement(depense.getDate());
	    	this.spinner_MontantTotal.setValue(depense.getMontantTranche());
	    	this.setTranche(String.valueOf(depense.getNumeroTranche()));
			this.setObservation(depense.getObservation());
			this.setModePaiement(depense.getModePaiement());
			
		}
	      
	    
	      
	      public PaiementScolarite recupererPaiementScolarite() {
	    	  
	    		PaiementScolarite paiement = new PaiementScolarite();
				paiement.setNumeroPaiement(Integer.valueOf(this.getNumeroPaiement()));
				paiement.setNomClasse(this.getClasse());
				paiement.setNom(this.getTextPane_nomEleve());
				paiement.setPrenom(this.getTextPane_prenomEleve());
				paiement.setNumeroMatricule(this.getTextPane_Matricule());
				paiement.setLibele(this.getLibelle());
				paiement.setNumeroRecu(this.getNumeroRecu());
				paiement.setAnneeScolarite(this.getAnneeScolaire());
				paiement.setDate(this.getDatePaiement());
				paiement.setMontantScolarite(this.montantMontantTotal());
				paiement.setMontantTranche(this.montantMontantTotal());
				paiement.setNumeroTranche(Integer.valueOf(this.getTranche()));
				paiement.setObservation(this.getObservation());
				paiement.setModePaiement(this.getModePaiement());
				
				return paiement;
	  	      }
		
	
}
