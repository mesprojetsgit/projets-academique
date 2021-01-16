package com.app.interfaces.administrateur;

import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class IProfesseur extends JDialog {
	private JTextField textField_nomProfesseur;
	private JTextField textField_prenomProfesseur;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_genreProfesseur;
	private JTextField textField_adresseProfesseur;
	private JTextField textField_telephoneProfesseur;
	private JTextField textField_numCarteIdentiteProfesseur;
	private JTextField textField_emailProfesseur;
	private JDateChooser dateChooser_dateRecrutementProfesseur;
	private JDateChooser dateChooser_dateArretProfesseur;
	private JTextField txt_classe;
	private JTextField txt_matiere;
	private JRadioButton rdbtn_vacataire;
	private JRadioButton rdbtn_permanent;
	private JSpinner spinner_salaireHoraire;
	private JSpinner spinner_salaireMensuel;
	private JButton btnValider_professeur;
	private JButton btnAnnuler_professeur;
	private JSpinner spinner_anneeExperience;
	private JTextField textField_matriculeProfesseur;

	/**
	 * Launch the application.
	 */
	public  void run() {
		try {
			
			this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			this.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public IProfesseur() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Cr\u00E9ation compte Professeur");
		getContentPane().setBackground(new Color(222, 184, 135));
		setResizable(false);
		setBounds(100, 100, 773, 442);
		getContentPane().setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(210, 180, 140));
			panel.setLayout(null);
			panel.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
			panel.setBounds(10, 62, 736, 277);
			getContentPane().add(panel);
			{
				JLabel lblNewLabel_4_2 = new JLabel("Nom :");
				lblNewLabel_4_2.setBounds(12, 49, 150, 14);
				panel.add(lblNewLabel_4_2);
			}
			{
				textField_nomProfesseur = new JTextField();
				textField_nomProfesseur.setColumns(10);
				textField_nomProfesseur.setBounds(172, 46, 186, 20);
				panel.add(textField_nomProfesseur);
			}
			{
				JLabel lblNewLabel_4_1_2 = new JLabel("Prenom :");
				lblNewLabel_4_1_2.setBounds(12, 80, 150, 14);
				panel.add(lblNewLabel_4_1_2);
			}
			{
				textField_prenomProfesseur = new JTextField();
				textField_prenomProfesseur.setColumns(10);
				textField_prenomProfesseur.setBounds(172, 77, 186, 20);
				panel.add(textField_prenomProfesseur);
			}
			{
				JLabel lblNewLabel_4_1_1_2 = new JLabel("Genre :");
				lblNewLabel_4_1_1_2.setBounds(12, 111, 150, 14);
				panel.add(lblNewLabel_4_1_1_2);
			}
			{
				comboBox_genreProfesseur = new JComboBox();
				comboBox_genreProfesseur.setModel(new DefaultComboBoxModel(new String[] {"Masculin", "F\u00E9minin"}));
				comboBox_genreProfesseur.setBounds(172, 108, 186, 20);
				panel.add(comboBox_genreProfesseur);
			}
			{
				JLabel lblNewLabel_4_1_1_1_1_2 = new JLabel("Adresse :");
				lblNewLabel_4_1_1_1_1_2.setBounds(12, 138, 150, 14);
				panel.add(lblNewLabel_4_1_1_1_1_2);
			}
			{
				textField_adresseProfesseur = new JTextField();
				textField_adresseProfesseur.setColumns(10);
				textField_adresseProfesseur.setBounds(172, 135, 186, 20);
				panel.add(textField_adresseProfesseur);
			}
			{
				JLabel lblNewLabel_4_1_1_1_1_1 = new JLabel("Numero de telephone :");
				lblNewLabel_4_1_1_1_1_1.setBounds(12, 169, 150, 14);
				panel.add(lblNewLabel_4_1_1_1_1_1);
			}
			{
				textField_telephoneProfesseur = new JTextField();
				textField_telephoneProfesseur.setColumns(10);
				textField_telephoneProfesseur.setBounds(172, 166, 186, 20);
				panel.add(textField_telephoneProfesseur);
			}
			{
				JLabel lblNewLabel_4_1_1_1_1_1_1 = new JLabel("Numero carte d'identite :");
				lblNewLabel_4_1_1_1_1_1_1.setBounds(12, 200, 150, 14);
				panel.add(lblNewLabel_4_1_1_1_1_1_1);
			}
			{
				textField_numCarteIdentiteProfesseur = new JTextField();
				textField_numCarteIdentiteProfesseur.setColumns(10);
				textField_numCarteIdentiteProfesseur.setBounds(172, 197, 186, 20);
				panel.add(textField_numCarteIdentiteProfesseur);
			}
			{
				JLabel lblNewLabel_4_1_1_1_1_1_1_2 = new JLabel("Email : ");
				lblNewLabel_4_1_1_1_1_1_1_2.setBounds(12, 234, 150, 14);
				panel.add(lblNewLabel_4_1_1_1_1_1_1_2);
			}
			{
				textField_emailProfesseur = new JTextField();
				textField_emailProfesseur.setBounds(172, 231, 186, 20);
				panel.add(textField_emailProfesseur);
			}
			
			dateChooser_dateRecrutementProfesseur = new JDateChooser();
			dateChooser_dateRecrutementProfesseur.setBounds(539, 11, 187, 20);
			panel.add(dateChooser_dateRecrutementProfesseur);
			
			JLabel lblNewLabel_4_1_1_1_2 = new JLabel("Date de recrutement :");
			lblNewLabel_4_1_1_1_2.setBounds(380, 17, 150, 14);
			panel.add(lblNewLabel_4_1_1_1_2);
			
			dateChooser_dateArretProfesseur = new JDateChooser();
			dateChooser_dateArretProfesseur.setBounds(539, 42, 187, 20);
			panel.add(dateChooser_dateArretProfesseur);
			
			JLabel lblNewLabel_4_1_1_1_2_1 = new JLabel("Date d'arret :");
			lblNewLabel_4_1_1_1_2_1.setBounds(380, 48, 150, 14);
			panel.add(lblNewLabel_4_1_1_1_2_1);
			
			JLabel lblNewLabel_4_1_1_1_1_1_1_2 = new JLabel("Annees d'experience : ");
			lblNewLabel_4_1_1_1_1_1_1_2.setBounds(380, 76, 150, 14);
			panel.add(lblNewLabel_4_1_1_1_1_1_1_2);
			
			spinner_anneeExperience = new JSpinner();
			spinner_anneeExperience.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinner_anneeExperience.setBounds(540, 73, 186, 20);
			panel.add(spinner_anneeExperience);
			
			textField_matriculeProfesseur = new JTextField();
			textField_matriculeProfesseur.setColumns(10);
			textField_matriculeProfesseur.setBounds(172, 11, 186, 20);
			panel.add(textField_matriculeProfesseur);
			
			JLabel lblNewLabel_4_2 = new JLabel("Matricule :");
			lblNewLabel_4_2.setBounds(12, 14, 150, 14);
			panel.add(lblNewLabel_4_2);
			
			txt_classe = new JTextField();
			txt_classe.setBounds(477, 111, 249, 20);
			panel.add(txt_classe);
			
			JLabel lblNewLabel = new JLabel("Classe : ");
			lblNewLabel.setBounds(381, 114, 67, 14);
			panel.add(lblNewLabel);
			
			JLabel lblMatiere = new JLabel("Matiere : ");
			lblMatiere.setBounds(380, 144, 67, 14);
			panel.add(lblMatiere);
			
			txt_matiere = new JTextField();
			txt_matiere.setBounds(476, 141, 249, 20);
			panel.add(txt_matiere);
			
			JLabel lblSalaireHoraire = new JLabel("Salaire horaire  : ");
			lblSalaireHoraire.setBounds(382, 206, 105, 14);
			panel.add(lblSalaireHoraire);
			
			rdbtn_vacataire = new JRadioButton("Vacataire");
			rdbtn_vacataire.setBounds(381, 174, 109, 23);
			panel.add(rdbtn_vacataire);
			rdbtn_vacataire.setSelected(true);
			
			rdbtn_permanent = new JRadioButton("Permanent");
			rdbtn_permanent.setBounds(602, 174, 90, 23);
			panel.add(rdbtn_permanent);
			
			JLabel lblSalaireMensuel = new JLabel("Salaire mensuel  : ");
			lblSalaireMensuel.setBounds(602, 206, 105, 14);
			panel.add(lblSalaireMensuel);
			
			spinner_salaireHoraire = new JSpinner();
			spinner_salaireHoraire.setBounds(381, 231, 134, 20);
			panel.add(spinner_salaireHoraire);
			spinner_salaireHoraire.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(5)));
			
			spinner_salaireMensuel = new JSpinner();
			spinner_salaireMensuel.setBounds(590, 231, 136, 20);
			panel.add(spinner_salaireMensuel);
			spinner_salaireMensuel.setEnabled(false);
			spinner_salaireMensuel.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(5)));
		}
		{
			JLabel lblCompteProfesseur = new JLabel("  Compte Professeur");
			lblCompteProfesseur.setHorizontalAlignment(SwingConstants.CENTER);
			lblCompteProfesseur.setFont(new Font("Eras Medium ITC", Font.PLAIN, 20));
			lblCompteProfesseur.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
			lblCompteProfesseur.setBounds(10, 11, 736, 40);
			getContentPane().add(lblCompteProfesseur);
		}
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(210, 180, 140));
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
		panel_2.setBounds(10, 350, 736, 47);
		getContentPane().add(panel_2);
		
		btnAnnuler_professeur = new JButton("Annuler");
		btnAnnuler_professeur.setIcon(new ImageIcon(IAdministrateur.class.getResource("/cancel.png")));
		btnAnnuler_professeur.setBackground(new Color(205, 133, 63));
		btnAnnuler_professeur.setBounds(596, 11, 130, 25);
		panel_2.add(btnAnnuler_professeur);
		
		btnValider_professeur = new JButton("Valider");
		btnValider_professeur.setIcon(new ImageIcon(IAdministrateur.class.getResource("/checked.png")));
		btnValider_professeur.setBackground(new Color(205, 133, 63));
		btnValider_professeur.setBounds(456, 11, 130, 25);
		panel_2.add(btnValider_professeur);
	}
	
	
	
	public String getNomProfesseur() {
		return textField_nomProfesseur.getText();
	}

	public void setNomProfesseur(String nomProfesseur) {
		textField_nomProfesseur.setText(nomProfesseur);
	}

	public String getPrenomProfesseur() {
		return textField_prenomProfesseur.getText();
	}

	public void setPrenomProfesseur(String prenomProfesseur) {
		textField_prenomProfesseur.setText(prenomProfesseur);
	}

	public String getGenre() {
		return comboBox_genreProfesseur.getSelectedItem().toString();
	}
	
	public void setGenre(String sexe) {
		comboBox_genreProfesseur.setToolTipText(sexe);
	}

	public String getAdresseProfesseur() {
		return textField_adresseProfesseur.getText();
	}

	public void setAdresseProfesseur(String adresseProfesseur) {
		textField_adresseProfesseur.setText(adresseProfesseur);
	}

	public String getTelephoneProfesseur() {
		return textField_telephoneProfesseur.getText();
	}

	public void setTelephoneProfesseur(String telephoneProfesseur) {
		textField_telephoneProfesseur.setText(telephoneProfesseur);
	}

	public String getNumCarteIdentiteProfesseur() {
		return textField_numCarteIdentiteProfesseur.getText();
	}

	public void setNumCarteIdentiteProfesseur(String numCarteIdentiteProfesseur) {
		textField_numCarteIdentiteProfesseur.setText(numCarteIdentiteProfesseur);
	}

	public String getEmailProfesseur() {
		return textField_emailProfesseur.getText();
	}

	public void setEmailProfesseur(String emailProfesseur) {
		textField_emailProfesseur.setText(emailProfesseur);
		
	}
	
	
	
	/////
	public String getDateRecrutementProfesseur() {
		return ((JTextField)dateChooser_dateRecrutementProfesseur.getDateEditor().getUiComponent()).getText();
		
	}

	public void setDateRecrutementProfesseur(String dateRecrutementProfesseur) {
		 java.util.Date date2;
			try {
				date2 = new SimpleDateFormat("dd MMM yyyy").parse(dateRecrutementProfesseur);
				this.dateChooser_dateRecrutementProfesseur.setDate(date2);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	public String getDateArretProfesseur() {
		return ((JTextField)dateChooser_dateArretProfesseur.getDateEditor().getUiComponent()).getText();
		
	}

	public void setDateArretProfesseur(String dateArretProfesseur) {
		 java.util.Date date2;
			try {
				date2 = new SimpleDateFormat("dd MMM yyyy").parse(dateArretProfesseur);
				this.dateChooser_dateArretProfesseur.setDate(date2);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
	
	public boolean getVacataire() {
		return rdbtn_vacataire.isSelected();
	}

	public void setVacataire(boolean rd_vacataire) {
		rdbtn_vacataire.setSelected(rd_vacataire);
	}

	public boolean getPermanent() {
		return rdbtn_permanent.isSelected();
	}

	public void setPermanent_permanent(boolean rd_permanent) {
		rdbtn_permanent.setSelected(rd_permanent);
	}

	
	
	public double getSalaireHoraire() {
		 return	((Double)spinner_salaireHoraire.getValue()).doubleValue();
	
	}
	public void setEtatSalaireVacataire(boolean etat) {
		spinner_salaireHoraire.setEnabled(etat);
	}

	public void setSalaireHoraire(double salaireHoraire) {
		spinner_salaireHoraire.setValue(salaireHoraire);
	}
	
	public void setEtatSalairePermanent(boolean etat) {
		spinner_salaireMensuel.setEnabled(etat);
	}
	
	public double getSalaireMensuel() {
	 return	((Double)spinner_salaireMensuel.getValue()).doubleValue();
		
	}

	public void setSalaireMensuel(double salaireMensuel) {
		spinner_salaireMensuel.setValue(salaireMensuel);
	}

	public int getAnneeExperience() {
		return ((Integer)spinner_anneeExperience.getValue()).intValue();
		
	}

	public void setAnneeExperience(int anneeExperience) {
		spinner_anneeExperience.setValue(anneeExperience);
	}
	

	//LISTENERS
	public void validerListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		btnValider_professeur.addActionListener(actionListener);	
	}
	public void chxVacataireListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		rdbtn_vacataire.addActionListener(actionListener);	
	}
	public void chxPermanentListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		rdbtn_permanent.addActionListener(actionListener);	
	}
	public void annulerListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		btnAnnuler_professeur.addActionListener(actionListener);	
	}
	
	
	public void classeMousseListener(ActionListener mousseListener) {
		txt_classe.addActionListener(mousseListener);
	}
	
	public void matiereMousseListener(ActionListener mousseListener) {
		txt_matiere.addActionListener(mousseListener);
	}


	public String getClasse() {
		return txt_classe.getText();
	}
	public void setClasse(String classe) {
		 txt_classe.setText(classe);
	}
	public String getMatiere() {
		return txt_matiere.getText();
	}
	public void setMatiere(String matiere) {
		 txt_matiere.setText(matiere);
	}
	public String getMatricule() {
		return textField_matriculeProfesseur.getText();
	}
	public void setMatricule(String mat) {
		textField_matriculeProfesseur.setText(mat);
	}
	
	
	public void annuler() {
		dispose() ;
	}
}
