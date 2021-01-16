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
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class IEmployer extends JDialog {
	private JTextField textField_nomEmployer;
	private JTextField textField_prenomEmployer;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_genreEmployer;
	private JTextField textField_adresseEmployer;
	private JTextField textField_telephoneEmployer;
	private JTextField textField_numCarteIdentiteEmployer;
	private JTextField textField_emailEmployer;
	private JTextField textField_posteEmployer;
	private JDateChooser dateChooser_dateRecrutementEmployer;
	private JDateChooser dateChooser_dateArretEmployer;
	private JSpinner spinner_salaireEmployer;
	private JButton btnValider_Employer;
	private JButton btnAnnuler_Employer;

	/**
	 * Launch the application.
	 */
	public  void  run() {
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public IEmployer() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		getContentPane().setBackground(new Color(222, 184, 135));
		setTitle("Cr\u00E9ation compte Employer");
		setBounds(100, 100, 410, 580);
		getContentPane().setLayout(null);
		{
			JLabel lblComptePersonnel = new JLabel("  Compte Employer");
			lblComptePersonnel.setHorizontalAlignment(SwingConstants.CENTER);
			lblComptePersonnel.setFont(new Font("Eras Medium ITC", Font.PLAIN, 20));
			lblComptePersonnel.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
			lblComptePersonnel.setBounds(10, 11, 370, 40);
			getContentPane().add(lblComptePersonnel);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(210, 180, 140));
			panel.setLayout(null);
			panel.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
			panel.setBounds(10, 62, 370, 409);
			getContentPane().add(panel);
			{
				JLabel lblNewLabel_4_2 = new JLabel("Nom :");
				lblNewLabel_4_2.setBounds(12, 35, 150, 14);
				panel.add(lblNewLabel_4_2);
			}
			{
				textField_nomEmployer = new JTextField();
				textField_nomEmployer.setColumns(10);
				textField_nomEmployer.setBounds(172, 32, 186, 20);
				panel.add(textField_nomEmployer);
			}
			{
				JLabel lblNewLabel_4_1_2 = new JLabel("Prenom :");
				lblNewLabel_4_1_2.setBounds(12, 66, 150, 14);
				panel.add(lblNewLabel_4_1_2);
			}
			{
				textField_prenomEmployer = new JTextField();
				textField_prenomEmployer.setColumns(10);
				textField_prenomEmployer.setBounds(172, 63, 186, 20);
				panel.add(textField_prenomEmployer);
			}
			{
				JLabel lblNewLabel_4_1_1_2 = new JLabel("Genre :");
				lblNewLabel_4_1_1_2.setBounds(12, 97, 150, 14);
				panel.add(lblNewLabel_4_1_1_2);
			}
			{
				comboBox_genreEmployer = new JComboBox();
				comboBox_genreEmployer.setModel(new DefaultComboBoxModel(new String[] {"Masculin", "F\u00E9minin"}));
				comboBox_genreEmployer.setBounds(172, 94, 186, 20);
				panel.add(comboBox_genreEmployer);
			}
			{
				JLabel lblNewLabel_4_1_1_1_1_2 = new JLabel("Adresse :");
				lblNewLabel_4_1_1_1_1_2.setBounds(12, 124, 150, 14);
				panel.add(lblNewLabel_4_1_1_1_1_2);
			}
			{
				textField_adresseEmployer = new JTextField();
				textField_adresseEmployer.setColumns(10);
				textField_adresseEmployer.setBounds(172, 121, 186, 20);
				panel.add(textField_adresseEmployer);
			}
			{
				JLabel lblNewLabel_4_1_1_1_1_1 = new JLabel("Numero de telephone :");
				lblNewLabel_4_1_1_1_1_1.setBounds(12, 155, 150, 14);
				panel.add(lblNewLabel_4_1_1_1_1_1);
			}
			{
				textField_telephoneEmployer = new JTextField();
				textField_telephoneEmployer.setColumns(10);
				textField_telephoneEmployer.setBounds(172, 152, 186, 20);
				panel.add(textField_telephoneEmployer);
			}
			{
				JLabel lblNewLabel_4_1_1_1_1_1_1 = new JLabel("Numero carte d'identite :");
				lblNewLabel_4_1_1_1_1_1_1.setBounds(12, 186, 150, 14);
				panel.add(lblNewLabel_4_1_1_1_1_1_1);
			}
			{
				textField_numCarteIdentiteEmployer = new JTextField();
				textField_numCarteIdentiteEmployer.setColumns(10);
				textField_numCarteIdentiteEmployer.setBounds(172, 183, 186, 20);
				panel.add(textField_numCarteIdentiteEmployer);
			}
			{
				JLabel lblNewLabel_4_1_1_1_1_1_1_2 = new JLabel("Email : ");
				lblNewLabel_4_1_1_1_1_1_1_2.setBounds(12, 220, 150, 14);
				panel.add(lblNewLabel_4_1_1_1_1_1_1_2);
			}
			{
				textField_emailEmployer = new JTextField();
				textField_emailEmployer.setBounds(172, 217, 186, 20);
				panel.add(textField_emailEmployer);
			}
			{
				dateChooser_dateRecrutementEmployer = new JDateChooser();
				dateChooser_dateRecrutementEmployer.setBounds(171, 245, 187, 20);
				panel.add(dateChooser_dateRecrutementEmployer);
			}
			{
				JLabel lblNewLabel_4_1_1_1_2 = new JLabel("Date de recrutement :");
				lblNewLabel_4_1_1_1_2.setBounds(12, 251, 150, 14);
				panel.add(lblNewLabel_4_1_1_1_2);
			}
			{
				dateChooser_dateArretEmployer = new JDateChooser();
				dateChooser_dateArretEmployer.setBounds(171, 276, 187, 20);
				panel.add(dateChooser_dateArretEmployer);
			}
			{
				JLabel lblNewLabel_4_1_1_1_2_1 = new JLabel("Date d'arret :");
				lblNewLabel_4_1_1_1_2_1.setBounds(12, 282, 150, 14);
				panel.add(lblNewLabel_4_1_1_1_2_1);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(new Color(222, 184, 135));
				panel_1.setBorder(new LineBorder(new Color(160, 82, 45), 1, true));
				panel_1.setBounds(12, 321, 346, 77);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					spinner_salaireEmployer = new JSpinner();
					spinner_salaireEmployer.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(5)));
					spinner_salaireEmployer.setBounds(81, 46, 255, 20);
					panel_1.add(spinner_salaireEmployer);
				}
				{
					JLabel lblNewLabel_4_1_1_1_1_1_1_2 = new JLabel("Salaire : ");
					lblNewLabel_4_1_1_1_1_1_1_2.setBounds(10, 49, 61, 14);
					panel_1.add(lblNewLabel_4_1_1_1_1_1_1_2);
				}
				
				textField_posteEmployer = new JTextField();
				textField_posteEmployer.setBounds(81, 11, 255, 20);
				panel_1.add(textField_posteEmployer);
				
				JLabel lblNewLabel_4_1_1_1_1_1_1_2 = new JLabel("Poste : ");
				lblNewLabel_4_1_1_1_1_1_1_2.setBounds(10, 14, 61, 14);
				panel_1.add(lblNewLabel_4_1_1_1_1_1_1_2);
			}
		}
		{
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(new Color(210, 180, 140));
			panel_2.setLayout(null);
			panel_2.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
			panel_2.setBounds(10, 482, 370, 47);
			getContentPane().add(panel_2);
			{
				btnAnnuler_Employer = new JButton("Annuler");
				btnAnnuler_Employer.setIcon(new ImageIcon(IAdministrateur.class.getResource("/cancel.png")));
				btnAnnuler_Employer.setBackground(new Color(205, 133, 63));
				btnAnnuler_Employer.setBounds(230, 11, 130, 25);
				panel_2.add(btnAnnuler_Employer);
			}
			{
				btnValider_Employer = new JButton("Valider");
				btnValider_Employer.setIcon(new ImageIcon(IAdministrateur.class.getResource("/checked.png")));
				btnValider_Employer.setBackground(new Color(205, 133, 63));
				btnValider_Employer.setBounds(90, 11, 130, 25);
				panel_2.add(btnValider_Employer);
			}
		}
	}

	public void validerListener(ActionListener actionListener) {
		btnValider_Employer.addActionListener(actionListener);
		
	}
	public void annulerListener(ActionListener actionListener) {
		btnAnnuler_Employer.addActionListener(actionListener);
		
	}
	public void setNom(String tAdminCol2) {
		textField_nomEmployer.setText(tAdminCol2);
		
	}
	public String getNom() {
		return textField_nomEmployer.getText();
		
	}
	public void setPrenom(String tAdminCol3) {
		textField_prenomEmployer.setText(tAdminCol3);
		
	}
	public String getPrenom() {
		return textField_prenomEmployer.getText();
		
	}
	
	public String getGenre() {
		return comboBox_genreEmployer.getSelectedItem().toString();
	}
	
	public void setGenre(String sexe) {
		comboBox_genreEmployer.setToolTipText(sexe);
	}
	
	
	
	public void setAdresse(String tAdminCol3) {
		textField_adresseEmployer.setText(tAdminCol3);
		
	}
	public String getAdresse() {
		return textField_adresseEmployer.getText();
		
	}
	public void setTel(String tAdminCol3) {
		textField_telephoneEmployer.setText(tAdminCol3);
		
	}
	public String getTel() {
		return textField_telephoneEmployer.getText();
		
	}
	public void setCnib(String tAdminCol3) {
		textField_numCarteIdentiteEmployer.setText(tAdminCol3);
		
	}
	public String getCnib() {
		return textField_numCarteIdentiteEmployer.getText();
		
	}
	public void setMail(String tAdminCol3) {
		textField_emailEmployer.setText(tAdminCol3);
		
	}
	public String getMail() {
		return textField_emailEmployer.getText();
		
	}
	public void setPoste(String tAdminCol3) {
		textField_posteEmployer.setText(tAdminCol3);
		
	}
	public String getPoste( ) {
		return textField_posteEmployer.getText();
		
	}
	public double getSalaire() {
	    return ((Double)spinner_salaireEmployer.getValue()).floatValue();
	
	}
	public void setSalaire(double montant) {
		this.spinner_salaireEmployer.setValue(montant);
	}
	
	public void setDateRecru(String date) {
	    
	    java.util.Date date2;
		try {
			date2 = new SimpleDateFormat("dd MMM yyyy").parse(date);
			this.dateChooser_dateRecrutementEmployer.setDate(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getDateRecru() {
	   return ((JTextField)dateChooser_dateRecrutementEmployer.getDateEditor().getUiComponent()).getText();
	}
	
    public void setDateFin(String date) {
	    
	    java.util.Date date2;
		try {
			date2 = new SimpleDateFormat("dd MMM yyyy").parse(date);
			this.dateChooser_dateArretEmployer.setDate(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getDatFin() {
	   return ((JTextField)dateChooser_dateArretEmployer.getDateEditor().getUiComponent()).getText();
	}
	
	public void annuler() {
		dispose();
	}
	
	
}
