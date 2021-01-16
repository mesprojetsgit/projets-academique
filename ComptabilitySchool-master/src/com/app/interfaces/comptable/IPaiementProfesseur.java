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
import javax.swing.JCheckBox;
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
import javax.swing.event.ChangeListener;

import com.app.metier.entites.PaiementProfesseur;
import com.app.metier.entites.Professeur;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class IPaiementProfesseur extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextPane textPane_Nom;
	private JTextPane textPane_Salaire;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_Mois;
	private JTextPane textPane_PrixParHeure;
	private JDateChooser date_Paiement;
	private JTextPane textPane_MontantTotalSalaire;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_ModeDePaiement;
	private JButton btn_Payer;
	private JButton btn_Annuler;
	private JTextPane textPane_classe;
	private JCheckBox chckbxPermanent;
	private JCheckBox chckbxNewCheckBox;
	private JTextPane textPane_matiere;
	private JTextPane textPane_prenom;
	private JSpinner spinner_nombreHeure;
	private JButton buttonVoirPayement;
	private JTextPane textPane_matricule;


	/**
	 * Create the dialog.
	 */
	public IPaiementProfesseur() {
		initComponent();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initComponent() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Paiement Salaire Professeur");
		setResizable(false);
		setBounds(100, 100, 477, 520);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(222, 184, 135));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		date_Paiement = new JDateChooser();
		date_Paiement.setBounds(134, 374, 121, 20);
		contentPanel.add(date_Paiement);

		JLabel lblNewLabel_1 = new JLabel("Date : ");
		lblNewLabel_1.setBounds(10, 374, 67, 20);
		contentPanel.add(lblNewLabel_1);

		
		
		String mois[]= {"Janvier","Fevrier","Mars","Avril","Mai","Juin","Juillet","Aout","Septembre","Octobre","Novembre","Decembre"};
		comboBox_Mois = new JComboBox(mois);
		comboBox_Mois.setBounds(134, 313, 121, 20);
		contentPanel.add(comboBox_Mois);

		JLabel lblNewLabel_2 = new JLabel("Mois : ");
		lblNewLabel_2.setBounds(10, 313, 46, 20);
		contentPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Montant : ");
		lblNewLabel_2_1.setBounds(10, 405, 75, 20);
		contentPanel.add(lblNewLabel_2_1);

		comboBox_ModeDePaiement = new JComboBox();
		comboBox_ModeDePaiement.setModel(new DefaultComboBoxModel(new String[] {"Liquide", "Ch\u00E8que", "Virement bancaire", "Transfert d'argent"}));
		comboBox_ModeDePaiement.setBounds(134, 436, 121, 20);
		contentPanel.add(comboBox_ModeDePaiement);

		JLabel lblNewLabel_2_2 = new JLabel("Mode de paiement : ");
		lblNewLabel_2_2.setBounds(10, 436, 114, 20);
		contentPanel.add(lblNewLabel_2_2);

		textPane_PrixParHeure = new JTextPane();
		textPane_PrixParHeure.setEditable(false);
		textPane_PrixParHeure.setBounds(134, 343, 121, 20);
		contentPanel.add(textPane_PrixParHeure);

		JLabel lblPrixHeure = new JLabel("Prix / Heure :");
		lblPrixHeure.setBounds(10, 343, 82, 20);
		contentPanel.add(lblPrixHeure);

		btn_Payer = new JButton("Payer");
		btn_Payer.setIcon(new ImageIcon(IComptabilite.class.getResource("/checked.png")));
		btn_Payer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Payer.setBackground(new Color(205, 133, 63));
		btn_Payer.setBounds(292, 361, 152, 43);
		contentPanel.add(btn_Payer);

		btn_Annuler = new JButton("Annuler");
		btn_Annuler.setIcon(new ImageIcon(IComptabilite.class.getResource("/cancel.png")));
		btn_Annuler.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Annuler.setBackground(new Color(205, 133, 63));
		btn_Annuler.setBounds(292, 413, 152, 43);
		contentPanel.add(btn_Annuler);

		textPane_MontantTotalSalaire = new JTextPane();
		textPane_MontantTotalSalaire.setEnabled(false);
		textPane_MontantTotalSalaire.setEditable(false);
		textPane_MontantTotalSalaire.setBackground(new Color(255, 255, 255));
		textPane_MontantTotalSalaire.setBounds(134, 405, 121, 20);
		contentPanel.add(textPane_MontantTotalSalaire);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(210, 180, 140));
		panel.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
		panel.setBounds(10, 71, 434, 208);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			textPane_Nom = new JTextPane();
			textPane_Nom.setBounds(95, 11, 329, 20);
			panel.add(textPane_Nom);
			textPane_Nom.setEditable(false);
		}
		{
			JLabel lblNewLabel = new JLabel("Nom : ");
			lblNewLabel.setBounds(10, 11, 75, 20);
			panel.add(lblNewLabel);
		}

		JLabel lblSalaire = new JLabel("Salaire : ");
		lblSalaire.setBounds(10, 132, 75, 20);
		panel.add(lblSalaire);

		textPane_Salaire = new JTextPane();
		textPane_Salaire.setBounds(95, 132, 121, 20);
		panel.add(textPane_Salaire);
		textPane_Salaire.setEditable(false);

		JLabel lblPrixheure = new JLabel("Nombre d'heures : ");
		lblPrixheure.setBounds(227, 132, 113, 20);
		panel.add(lblPrixheure);
		
	    textPane_classe = new JTextPane();
		textPane_classe.setBounds(95, 70, 329, 20);
		panel.add(textPane_classe);
		textPane_classe.setEditable(false);
		
		JLabel lblNewLabel_2_3 = new JLabel("Classe :");
		lblNewLabel_2_3.setBounds(10, 70, 75, 20);
		panel.add(lblNewLabel_2_3);
		
		textPane_matiere = new JTextPane();
		textPane_matiere.setEditable(false);
		textPane_matiere.setBounds(95, 101, 329, 20);
		panel.add(textPane_matiere);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Mati\u00E8re :");
		lblNewLabel_2_3_1.setBounds(10, 101, 75, 20);
		panel.add(lblNewLabel_2_3_1);
		
		textPane_prenom = new JTextPane();
		textPane_prenom.setEditable(false);
		textPane_prenom.setBounds(95, 42, 329, 20);
		panel.add(textPane_prenom);
		
		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setBounds(10, 45, 62, 14);
		panel.add(lblPrenom);
		
		spinner_nombreHeure = new JSpinner();
		spinner_nombreHeure.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_nombreHeure.setBounds(339, 132, 85, 20);
		panel.add(spinner_nombreHeure);
		
	     chckbxPermanent = new JCheckBox("Permanent");
	     chckbxPermanent.setBounds(327, 173, 97, 23);
	     panel.add(chckbxPermanent);
	     chckbxPermanent.setEnabled(false);
		
		chckbxNewCheckBox = new JCheckBox("Vacataire");
		chckbxNewCheckBox.setBounds(228, 173, 97, 23);
		panel.add(chckbxNewCheckBox);
		chckbxNewCheckBox.setEnabled(false);
		
		textPane_matricule = new JTextPane();
		textPane_matricule.setEditable(false);
		textPane_matricule.setBounds(95, 176, 121, 20);
		panel.add(textPane_matricule);
		
		JLabel lblMatricule = new JLabel("Matricule : ");
		lblMatricule.setBounds(10, 176, 75, 20);
		panel.add(lblMatricule);
		
		buttonVoirPayement = new JButton("Voir somme");
		buttonVoirPayement.setIcon(new ImageIcon(IComptabilite.class.getResource("/view.png")));
		buttonVoirPayement.setBackground(new Color(205, 133, 63));
		buttonVoirPayement.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonVoirPayement.setBounds(292, 313, 152, 37);
		contentPanel.add(buttonVoirPayement);
		
		JLabel lblPaiementProfesseur_1 = new JLabel("Paiement professeur");
		lblPaiementProfesseur_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaiementProfesseur_1.setFont(new Font("Eras Medium ITC", Font.PLAIN, 26));
		lblPaiementProfesseur_1.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
		lblPaiementProfesseur_1.setBounds(10, 11, 434, 40);
		contentPanel.add(lblPaiementProfesseur_1);
	}

	
	public int getNombreHeures() {
		return ((Integer)spinner_nombreHeure.getValue()).intValue();
	}
	public void  setNombreHeures(String employe) {
		spinner_nombreHeure.setValue(employe);
	}
	
	public double getMontantTotalSalaire() {
		return Double.parseDouble(textPane_MontantTotalSalaire.getText());
	}
	public void  setMontantTotalSalaire(String employe) {
		textPane_MontantTotalSalaire.setText(employe);
	}
	
	

	public String getNom() {
		return textPane_Nom.getText();
	}
	
	public void  setNom(String employe) {
		textPane_Nom.setText(employe);
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
	

	public void payerListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		btn_Payer.addActionListener(actionListener);	
	}
	public void actualiserListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		buttonVoirPayement.addActionListener(actionListener);	
	}
	
	
	public void annulerListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		btn_Annuler.addActionListener(actionListener);	
	}
	
	public void calculerSomme(ChangeListener listener) {
	spinner_nombreHeure.addChangeListener( listener);
	}
	
public String getTextPane_Nom() {
		return textPane_Nom.getText();
	}

	public void setTextPane_Nom(String textPane_Professeur) {
		this.textPane_Nom.setText(textPane_Professeur);
	}

	
	public String getTextPane_prenom() {
		return textPane_prenom.getText();
	}

	public void setTextPane_prenom(String textPane_prenom) {
		this.textPane_prenom.setText(textPane_prenom);
	}

	public String getTextPane_Salaire() {
		return textPane_Salaire.getText();
	}

	public void setTextPane_Salaire(String textPane_Salaire) {
		this.textPane_Salaire.setText(textPane_Salaire);
	}


	public String getTextPane_PrixParHeure() {
		return textPane_PrixParHeure.getText();
	}

	public void setTextPane_PrixParHeure(String textPane_PrixParHeure) {
		this.textPane_PrixParHeure.setText(textPane_PrixParHeure);
	}

	public String getDate_Paiement() {
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

	public String getTextPane_MontantTotalSalaire() {
		return textPane_MontantTotalSalaire.getText();
	}

	public void setTextPane_MontantTotalSalaire(String textPane_MontantTotalSalaire) {
		this.textPane_MontantTotalSalaire.setText(textPane_MontantTotalSalaire);
	}

	public String getTextPane_classe() {
		return textPane_classe.getText();
	}

	public void setTextPane_classe(String textPane_classe) {
		this.textPane_classe.setText(textPane_classe);
	}

	public String getTextPane_matiere() {
		return textPane_matiere.getText();
	}

	public void setTextPane_matiere(String textPane_matiere) {
		this.textPane_matiere.setText(textPane_matiere);
	}
	
	public double getPrixParHeure() {
		
		if (textPane_PrixParHeure .getText().isEmpty()) {
			
			return 0.0;
		}
		return Double.parseDouble(textPane_PrixParHeure .getText());
	}
	public void  setPrixParHeure(String employe) {
		textPane_PrixParHeure .setText(employe);
	}

	public String getSalaire() {
		return textPane_Salaire.getText();
	}
	public void  setSalaire(String employe) {
		textPane_Salaire.setText(employe);
	}
	
	
	
	public String getMatricule() {
		return textPane_matricule.getText();
	}

	public void setMatricule(String textPane_matricule) {
		this.textPane_matricule.setText(textPane_matricule);
	}

	public String getBtn_Payer() {
		return btn_Payer.getText();
	}


	public void onClickCheckBoxProf(Professeur depense) {
		
		if (depense.getType().equals("vaccataire")) {
			this.textPane_MontantTotalSalaire.setEditable(true);
			this.spinner_nombreHeure.setEnabled(true);
			this.chckbxNewCheckBox.setSelected(true);
			this.chckbxPermanent.setSelected(false);
			this.setTextPane_Salaire(String.valueOf(0.0));
			this.setPrixParHeure(String.valueOf(depense.getMontant()));
			buttonVoirPayement.setEnabled(true);
			
			
		}else if (depense.getType().equals("permanent")) {
			this.textPane_MontantTotalSalaire.setEditable(false); 
			this.spinner_nombreHeure.setEnabled(false);
			this.chckbxNewCheckBox.setSelected(false);
			this.chckbxPermanent.setSelected(true);
			this.setTextPane_Salaire(String.valueOf(depense.getMontant()));
			this.setTextPane_MontantTotalSalaire(String.valueOf(depense.getMontant()));
			this.setPrixParHeure(String.valueOf(0.0));
			buttonVoirPayement.setEnabled(false);
			
		}
		
	}
	

   public void afficher() {
		
		this.setVisible(true);
	}
	
	public void quitter() {
		this.dispose();
	}
	
	public void effacer() {
		
		this.setTextPane_Nom("");
		this.setTextPane_prenom("");
		this.setTextPane_classe(" ");
		this.setTextPane_matiere("");
		this.setTextPane_Salaire( "");
		this.spinner_nombreHeure.setValue(0);
		this.chckbxNewCheckBox.setSelected(false);
		this.chckbxPermanent.setSelected(false);
		this.textPane_PrixParHeure.setText(null);
		this.textPane_MontantTotalSalaire.setText(null);
		this.setMois(null);
		this.setModePaiement(null);
		
	}
	
	
	public void chargerTableEditeur(Professeur depense) {
		   
		this.btn_Payer.setText("Payer");
		this.setTextPane_Nom(depense.getNom());
		this.setTextPane_prenom(depense.getPrenom());;
		this.setTextPane_classe(depense.getNomClasse());
		this.setTextPane_matiere(depense.getNomMatiere());
		this.setMatricule(depense.getMatricule());
		this.onClickCheckBoxProf(depense);
	}
	
	
	
      public void modifierPaiementProf(PaiementProfesseur depense) {
		
    	  
    	this.btn_Payer.setText("Mise a jour");
		this.setTextPane_Nom(depense.getNom());
		this.setTextPane_prenom(depense.getPrenom());
		this.setTextPane_classe(depense.getNomClasse());
		this.setTextPane_matiere(depense.getNomMatiere());
		this.setTextPane_Salaire(String.valueOf(depense.getSalaire()));
		this.spinner_nombreHeure.setValue(depense.getNombreHeure());
		this.setMatricule(depense.getMatricule());
		
		if ( depense.getType().equals("permanent")) {
			this.chckbxNewCheckBox.setSelected(false);
			this.chckbxPermanent.setSelected(true);
			this.spinner_nombreHeure.setEnabled(false);
			this.textPane_Salaire.setEditable(true);

			
		}else {
			this.chckbxNewCheckBox.setSelected(true);
			this.chckbxPermanent.setSelected(false);
			this.spinner_nombreHeure.setEnabled(true);
			
		}
		
		this.textPane_PrixParHeure.setText(String.valueOf(depense.getPrixParHeure()));
		this.textPane_MontantTotalSalaire.setText(String.valueOf(depense.getMontantTotal()));
		this.setMois(depense.getMois());
		this.setModePaiement(depense.getModePaiement());
		
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
		Date dateU;
		try {
			dateU = sdf.parse(depense.getDateDePaiement());
			this.date_Paiement.getDateEditor().setDate(dateU);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
      
      public PaiementProfesseur recupererPaiementProf() {
    	  
    	PaiementProfesseur depense =  new PaiementProfesseur();
  		
    	depense.setNom(this.getTextPane_Nom());
    	depense.setPrenom(this.getTextPane_prenom());
    	depense.setNomClasse(this.getTextPane_classe());
    	depense.setNomMatiere(this.getTextPane_matiere());
    	depense.setNombreHeure(Integer.valueOf(this.getNombreHeures()));
  		
  		if (this.chckbxNewCheckBox.isSelected()) {
  
  			depense.setType("vaccataire");
  			depense.setSalaire((double) 0);
  			depense.setPrixParHeure(this.getPrixParHeure());
  			depense.setMontantTotal(Double.valueOf(this.getTextPane_MontantTotalSalaire()));
  			
  		}else if (this.chckbxPermanent.isSelected()){
  			
  			depense.setType("permanent");
  			depense.setSalaire(Double.valueOf(this.getTextPane_Salaire()));
  			depense.setPrixParHeure(this.getPrixParHeure());
  			depense.setMontantTotal(Double.valueOf(this.getTextPane_Salaire()));
  		}
  		depense.setMois(this.getMois());
  		depense.setModePaiement(this.getModePaiement());
  		depense.setDateDePaiement(this.getDate_Paiement());
  		depense.setMatricule(this.getMatricule());
  		
  		
  		return depense;
  	}
}
