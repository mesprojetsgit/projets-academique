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
public class IEleve extends JDialog {
	private JTextField textField_prenomParentEleve;
	private JTextField textField_adresseParentEleve;
	private JTextField textField_telephoneParentEleve;
	private JTextField textField_NomParentEleve;
	private JTextField textField_nomEleve;
	private JTextField textField_prenomEleve;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_genreEleve;
	private JTextField textField_telephoneEleve;
	private JTextField textField_numMatriculeEleve;
	private JDateChooser dateChooser_naissanceEleve;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_statutEleve;
	private JTextField textField_classeEleve;
	private JButton btnValider_Eleve;
	private JButton btnAnnuler_Eleve;
	private JSpinner spiner_montantScolarite;

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
	public IEleve() {
		setTitle("Cr\u00E9ation compte El\u00E8ve");
		getContentPane().setBackground(new Color(222, 184, 135));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 784, 508);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(210, 180, 140));
		panel_1.setBounds(10, 62, 366, 331);
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
		{
			JLabel lblNewLabel_4 = new JLabel("Informations du parent ou du tuteur");
			lblNewLabel_4.setHorizontalTextPosition(SwingConstants.CENTER);
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4.setFont(new Font("Eras Medium ITC", Font.PLAIN, 11));
			lblNewLabel_4.setBorder(new LineBorder(Color.GRAY, 1, true));
			lblNewLabel_4.setBounds(12, 13, 344, 15);
			panel_1.add(lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_4_2_1 = new JLabel("Nom :");
			lblNewLabel_4_2_1.setBounds(12, 56, 149, 14);
			panel_1.add(lblNewLabel_4_2_1);
		}
		{
			JLabel lblNewLabel_4_1_2_1 = new JLabel("Prenom :");
			lblNewLabel_4_1_2_1.setBounds(12, 87, 149, 14);
			panel_1.add(lblNewLabel_4_1_2_1);
		}
		{
			JLabel lblNewLabel_4_1_1_1_1_1_2 = new JLabel("Numero de telephone :");
			lblNewLabel_4_1_1_1_1_1_2.setBounds(12, 146, 149, 14);
			panel_1.add(lblNewLabel_4_1_1_1_1_1_2);
		}
		{
			JLabel lblNewLabel_4_1_1_1_1_2_1 = new JLabel("Adresse :");
			lblNewLabel_4_1_1_1_1_2_1.setBounds(12, 115, 149, 14);
			panel_1.add(lblNewLabel_4_1_1_1_1_2_1);
		}
		{
			textField_prenomParentEleve = new JTextField();
			textField_prenomParentEleve.setColumns(10);
			textField_prenomParentEleve.setBounds(171, 84, 185, 20);
			panel_1.add(textField_prenomParentEleve);
		}
		{
			textField_adresseParentEleve = new JTextField();
			textField_adresseParentEleve.setColumns(10);
			textField_adresseParentEleve.setBounds(171, 112, 185, 20);
			panel_1.add(textField_adresseParentEleve);
		}
		{
			textField_telephoneParentEleve = new JTextField();
			textField_telephoneParentEleve.setColumns(10);
			textField_telephoneParentEleve.setBounds(171, 143, 185, 20);
			panel_1.add(textField_telephoneParentEleve);
		}
		{
			textField_NomParentEleve = new JTextField();
			textField_NomParentEleve.setColumns(10);
			textField_NomParentEleve.setBounds(171, 53, 185, 20);
			panel_1.add(textField_NomParentEleve);
		}
		JPanel panel = new JPanel();
		panel.setBackground(new Color(210, 180, 140));
		panel.setBounds(386, 59, 370, 334);
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
		{
			JLabel lblNewLabel_4_2 = new JLabel("Nom :");
			lblNewLabel_4_2.setBounds(12, 83, 150, 14);
			panel.add(lblNewLabel_4_2);
		}
		{
			textField_nomEleve = new JTextField();
			textField_nomEleve.setColumns(10);
			textField_nomEleve.setBounds(172, 80, 186, 20);
			panel.add(textField_nomEleve);
		}
		{
			JLabel lblNewLabel_4_1_2 = new JLabel("Prenom :");
			lblNewLabel_4_1_2.setBounds(12, 114, 150, 14);
			panel.add(lblNewLabel_4_1_2);
		}
		{
			textField_prenomEleve = new JTextField();
			textField_prenomEleve.setColumns(10);
			textField_prenomEleve.setBounds(172, 111, 186, 20);
			panel.add(textField_prenomEleve);
		}
		{
			JLabel lblNewLabel_4_1_1_2 = new JLabel("Genre :");
			lblNewLabel_4_1_1_2.setBounds(12, 145, 150, 14);
			panel.add(lblNewLabel_4_1_1_2);
		}
		{
			comboBox_genreEleve = new JComboBox();
			comboBox_genreEleve.setModel(new DefaultComboBoxModel(new String[] {"Masculin", "F\u00E9minin"}));
			comboBox_genreEleve.setBounds(172, 142, 186, 20);
			panel.add(comboBox_genreEleve);
		}
		{
			JLabel lblNewLabel_4_1_1_1_2 = new JLabel("Date de naissance :");
			lblNewLabel_4_1_1_1_2.setBounds(12, 176, 150, 14);
			panel.add(lblNewLabel_4_1_1_1_2);
		}
		{
			JLabel lblNewLabel_4_1_1_1_1_1 = new JLabel("Numero de telephone :");
			lblNewLabel_4_1_1_1_1_1.setBounds(12, 204, 150, 14);
			panel.add(lblNewLabel_4_1_1_1_1_1);
		}
		{
			textField_telephoneEleve = new JTextField();
			textField_telephoneEleve.setColumns(10);
			textField_telephoneEleve.setBounds(172, 201, 186, 20);
			panel.add(textField_telephoneEleve);
		}
		{
			JLabel lblNewLabel_4_1_1_1_1_1_1 = new JLabel("Numero matricule :");
			lblNewLabel_4_1_1_1_1_1_1.setBounds(12, 55, 150, 14);
			panel.add(lblNewLabel_4_1_1_1_1_1_1);
		}
		{
			textField_numMatriculeEleve = new JTextField();
			textField_numMatriculeEleve.setColumns(10);
			textField_numMatriculeEleve.setBounds(172, 52, 186, 20);
			panel.add(textField_numMatriculeEleve);
		}
		{
			JLabel lblNewLabel_4_1 = new JLabel("Informations de l'eleve");
			lblNewLabel_4_1.setHorizontalTextPosition(SwingConstants.CENTER);
			lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4_1.setFont(new Font("Eras Medium ITC", Font.PLAIN, 11));
			lblNewLabel_4_1.setBorder(new LineBorder(Color.GRAY, 1, true));
			lblNewLabel_4_1.setBounds(12, 13, 346, 15);
			panel.add(lblNewLabel_4_1);
		}
		{
			JLabel lblNewLabel_4_1_1_1_1_1_1_2 = new JLabel("Statut : ");
			lblNewLabel_4_1_1_1_1_1_1_2.setBounds(12, 235, 150, 14);
			panel.add(lblNewLabel_4_1_1_1_1_1_1_2);
		}
		{
			comboBox_statutEleve = new JComboBox();
			comboBox_statutEleve.setModel(new DefaultComboBoxModel(new String[] {"Affect\u00E9 de l'\u00E9tat", "Compl\u00E9ment d'\u00E9ffectif"}));
			comboBox_statutEleve.setBounds(172, 232, 186, 20);
			panel.add(comboBox_statutEleve);
		}
		{
			dateChooser_naissanceEleve = new JDateChooser();
			dateChooser_naissanceEleve.setBounds(171, 170, 187, 20);
			panel.add(dateChooser_naissanceEleve);
		}
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(210, 180, 140));
		panel_2.setBounds(10, 404, 746, 57);
		panel_2.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
		panel_2.setLayout(null);
		
		btnAnnuler_Eleve = new JButton("Annuler");
		btnAnnuler_Eleve.setIcon(new ImageIcon(IAdministrateur.class.getResource("/cancel.png")));
		btnAnnuler_Eleve.setBackground(new Color(205, 133, 63));
		btnAnnuler_Eleve.setBounds(606, 11, 130, 36);
		panel_2.add(btnAnnuler_Eleve);
		
		btnValider_Eleve = new JButton("Valider");
		btnValider_Eleve.setIcon(new ImageIcon(IAdministrateur.class.getResource("/checked.png")));
		btnValider_Eleve.setBackground(new Color(205, 133, 63));
		btnValider_Eleve.setBounds(466, 11, 130, 36);
		panel_2.add(btnValider_Eleve);
		getContentPane().setLayout(null);
		getContentPane().add(panel_1);
		getContentPane().add(panel);
		{
			textField_classeEleve = new JTextField();
			textField_classeEleve.setBounds(172, 263, 186, 20);
			panel.add(textField_classeEleve);
		}
		{
			JLabel lblNewLabel_4_1_1_1_1_1_1_2 = new JLabel("Classe : ");
			lblNewLabel_4_1_1_1_1_1_1_2.setBounds(12, 266, 150, 14);
			panel.add(lblNewLabel_4_1_1_1_1_1_1_2);
		}
		
		spiner_montantScolarite = new JSpinner();
		spiner_montantScolarite.setBounds(172, 294, 186, 20);
		panel.add(spiner_montantScolarite);
		spiner_montantScolarite.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(5)));
		
		JLabel lblNewLabel_1 = new JLabel("Montant scolarit\u00E9 :");
		lblNewLabel_1.setBounds(12, 297, 150, 14);
		panel.add(lblNewLabel_1);
		getContentPane().add(panel_2);
		
		JLabel lblNewLabel = new JLabel("  Compte Eleve");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Eras Medium ITC", Font.PLAIN, 20));
		lblNewLabel.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
		lblNewLabel.setBounds(10, 11, 746, 40);
		getContentPane().add(lblNewLabel);
	}
	
	//GETTER SETTER
	public String getTextField_prenomParentEleve() {
		return textField_prenomParentEleve.getText();
	}

	public void setTextField_prenomParentEleve(String prenom) {
		textField_prenomParentEleve.setText(prenom);
	}

	public String getTextField_adresseParentEleve() {
		return textField_adresseParentEleve.getText();
	}

	public void setTextField_adresseParentEleve(String adresseParentEleve) {
		textField_adresseParentEleve.setText(adresseParentEleve);
	}

	public String getTextField_telephoneParentEleve() {
		return textField_telephoneParentEleve.getText();
	}

	public void setTextField_telephoneParentEleve(String telephoneParentEleve) {
		textField_telephoneParentEleve.setText(telephoneParentEleve);
	}

	public String getTextField_NomParentEleve() {
		return textField_NomParentEleve.getText();
	}

	public void setTextField_NomParentEleve(String NomParentEleve) {
		textField_NomParentEleve.setText(NomParentEleve);
	}

	public String getTextField_nomEleve() {
		return textField_nomEleve.getText();
	}

	public void setTextField_nomEleve(String nomEleve) {
		textField_nomEleve.setText(nomEleve);
	}

	public String getTextField_prenomEleve() {
		return textField_prenomEleve.getText();
	}

	public void setTextField_prenomEleve(String prenomEleve) {
		textField_prenomEleve.setText(prenomEleve);
	}

	public String getTextField_telephoneEleve() {
		return textField_telephoneEleve.getText();
	}

	public void setTextField_telephoneEleve(String telephoneEleve) {
		textField_telephoneEleve.setText(telephoneEleve);
	}

	public String getTextField_numMatriculeEleve() {
		return textField_numMatriculeEleve.getText();
	}

	public void setTextField_numMatriculeEleve(String numMatriculeEleve) {
		textField_numMatriculeEleve.setText(numMatriculeEleve);
	}

	public String getDateChooser_naissanceEleve() {
		 
		return ((JTextField)dateChooser_naissanceEleve.getDateEditor().getUiComponent()).getText();
	}
	public double getScolarite() {
		 return	((Double)spiner_montantScolarite.getValue()).doubleValue();
			
	}

	public void setScolarite(double salaireMensuel) {
		spiner_montantScolarite.setValue(salaireMensuel);
	}

	public void setDateChooser_naissanceEleve(String date) {
		 java.util.Date date2;
			try {
				date2 = new SimpleDateFormat("dd MMM yyyy").parse(date);
				this.dateChooser_naissanceEleve.setDate(date2);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

		//LISTENERS
		public void validerListener(ActionListener actionListener) {
			
			btnValider_Eleve.addActionListener(actionListener);	
		}
		
		public void annulerListener(ActionListener actionListener) {
			
			btnAnnuler_Eleve.addActionListener(actionListener);	
		}
		public String getStatus() {
			return comboBox_statutEleve.getSelectedItem().toString();
		}
		
		public void setStatus(String sexe) {
			comboBox_statutEleve.setToolTipText(sexe);
		}
		
		public void setClasse(String mousseListener) {
			textField_classeEleve.setText(mousseListener);
		}

		public String getClasse( ) {
			return textField_classeEleve.getText();
			
		}

		
		public String getGenre() {
			return comboBox_genreEleve.getSelectedItem().toString();
		}
		
		public void setGenre(String sexe) {
			comboBox_genreEleve.setToolTipText(sexe);
		}
		
		
		public void annuler() {
			dispose();
			
		}
}
