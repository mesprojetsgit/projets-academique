package com.app.interfaces.comptable;

import java.awt.Color;
import java.awt.ComponentOrientation;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class IDetailEleve extends JDialog {
	private JTextField textField_prenomParentEleve;
	private JTextField textField_adresseParentEleve;
	private JTextField textField_telephoneParentEleve;
	private JTextField textField_NomParentEleve;
	private JTextField textField_nomEleve;
	private JTextField textField_prenomEleve;
	private JTextField textField_genreEleve;
	private JTextField textField_adresseEleve;
	private JTextField textField_telephoneEleve;
	private JTextField textField_numMatriculeEleve;
	private JDateChooser dateChooser_naissanceEleve;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_statutEleve;
	private JTextField textField_classeEleve;
	private JButton btnAnnuler_Eleve;
	JFrame frame = new JFrame();
	private JTextField textField_tranche_1;
	private JTextField textField_tranche_2;
	private JTextField textField_tranche_3;

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
	public IDetailEleve() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(new Color(222, 184, 135));
		setResizable(false);
		setBounds(100, 100, 784, 508);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(210, 180, 140));
		panel_1.setBounds(10, 62, 366, 187);
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
			textField_prenomParentEleve.setForeground(new Color(0, 0, 0));
			textField_prenomParentEleve.setEditable(false);
			textField_prenomParentEleve.setColumns(10);
			textField_prenomParentEleve.setBounds(171, 84, 185, 20);
			panel_1.add(textField_prenomParentEleve);
		}
		{
			textField_adresseParentEleve = new JTextField();
			textField_adresseParentEleve.setForeground(new Color(0, 0, 0));
			textField_adresseParentEleve.setEditable(false);
			textField_adresseParentEleve.setColumns(10);
			textField_adresseParentEleve.setBounds(171, 112, 185, 20);
			panel_1.add(textField_adresseParentEleve);
		}
		{
			textField_telephoneParentEleve = new JTextField();
			textField_telephoneParentEleve.setForeground(new Color(0, 0, 0));
			textField_telephoneParentEleve.setEditable(false);
			textField_telephoneParentEleve.setColumns(10);
			textField_telephoneParentEleve.setBounds(171, 143, 185, 20);
			panel_1.add(textField_telephoneParentEleve);
		}
		{
			textField_NomParentEleve = new JTextField();
			textField_NomParentEleve.setForeground(new Color(0, 0, 0));
			textField_NomParentEleve.setEditable(false);
			textField_NomParentEleve.setColumns(10);
			textField_NomParentEleve.setBounds(171, 53, 185, 20);
			panel_1.add(textField_NomParentEleve);
		}
		JPanel panel = new JPanel();
		panel.setBackground(new Color(210, 180, 140));
		panel.setBounds(386, 62, 370, 334);
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
		{
			JLabel lblNewLabel_4_2 = new JLabel("Nom :");
			lblNewLabel_4_2.setBounds(12, 83, 150, 14);
			panel.add(lblNewLabel_4_2);
		}
		{
			textField_nomEleve = new JTextField();
			textField_nomEleve.setForeground(new Color(0, 0, 0));
			textField_nomEleve.setEditable(false);
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
			textField_prenomEleve.setForeground(new Color(0, 0, 0));
			textField_prenomEleve.setEditable(false);
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
			textField_genreEleve = new JTextField();
			textField_genreEleve.setForeground(new Color(0, 0, 0));
			textField_genreEleve.setEditable(false);
			textField_genreEleve.setColumns(10);
			textField_genreEleve.setBounds(172, 142, 186, 20);
			panel.add(textField_genreEleve);
		}
		{
			JLabel lblNewLabel_4_1_1_1_2 = new JLabel("Date de naissance :");
			lblNewLabel_4_1_1_1_2.setBounds(12, 176, 150, 14);
			panel.add(lblNewLabel_4_1_1_1_2);
		}
		{
			JLabel lblNewLabel_4_1_1_1_1_2 = new JLabel("Adresse :");
			lblNewLabel_4_1_1_1_1_2.setBounds(12, 207, 150, 14);
			panel.add(lblNewLabel_4_1_1_1_1_2);
		}
		{
			textField_adresseEleve = new JTextField();
			textField_adresseEleve.setForeground(new Color(0, 0, 0));
			textField_adresseEleve.setEnabled(false);
			textField_adresseEleve.setColumns(10);
			textField_adresseEleve.setBounds(172, 204, 186, 20);
			panel.add(textField_adresseEleve);
		}
		{
			JLabel lblNewLabel_4_1_1_1_1_1 = new JLabel("Numero de telephone :");
			lblNewLabel_4_1_1_1_1_1.setBounds(12, 238, 150, 14);
			panel.add(lblNewLabel_4_1_1_1_1_1);
		}
		{
			textField_telephoneEleve = new JTextField();
			textField_telephoneEleve.setForeground(new Color(0, 0, 0));
			textField_telephoneEleve.setEditable(false);
			textField_telephoneEleve.setColumns(10);
			textField_telephoneEleve.setBounds(172, 235, 186, 20);
			panel.add(textField_telephoneEleve);
		}
		{
			JLabel lblNewLabel_4_1_1_1_1_1_1 = new JLabel("Numero matricule :");
			lblNewLabel_4_1_1_1_1_1_1.setBounds(12, 55, 150, 14);
			panel.add(lblNewLabel_4_1_1_1_1_1_1);
		}
		{
			textField_numMatriculeEleve = new JTextField();
			textField_numMatriculeEleve.setForeground(new Color(0, 0, 0));
			textField_numMatriculeEleve.setEditable(false);
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
			lblNewLabel_4_1_1_1_1_1_1_2.setBounds(12, 269, 150, 14);
			panel.add(lblNewLabel_4_1_1_1_1_1_1_2);
		}
		{
			comboBox_statutEleve = new JComboBox();
			comboBox_statutEleve.setForeground(new Color(0, 0, 0));
			comboBox_statutEleve.setEnabled(false);
			comboBox_statutEleve.setModel(new DefaultComboBoxModel(new String[] {"Affect\u00E9 de l'\u00E9tat", "Compl\u00E9ment d'\u00E9ffectif"}));
			comboBox_statutEleve.setBounds(172, 266, 186, 20);
			panel.add(comboBox_statutEleve);
		}
		{
			dateChooser_naissanceEleve = new JDateChooser();
			dateChooser_naissanceEleve.setForeground(new Color(0, 0, 0));
			dateChooser_naissanceEleve.setEnabled(false);
			dateChooser_naissanceEleve.setDoubleBuffered(false);
			dateChooser_naissanceEleve.setBounds(171, 170, 187, 20);
			panel.add(dateChooser_naissanceEleve);
		}
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(210, 180, 140));
		panel_2.setBounds(10, 404, 746, 57);
		panel_2.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
		panel_2.setLayout(null);
		
		btnAnnuler_Eleve = new JButton("Fermer");
		btnAnnuler_Eleve.setIcon(new ImageIcon(IComptabilite.class.getResource("/cancel.png")));
		btnAnnuler_Eleve.setBackground(new Color(205, 133, 63));
		btnAnnuler_Eleve.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		btnAnnuler_Eleve.setActionCommand("Fermer");
		btnAnnuler_Eleve.setBounds(606, 11, 130, 36);
		panel_2.add(btnAnnuler_Eleve);
		getContentPane().setLayout(null);
		getContentPane().add(panel_1);
		getContentPane().add(panel);
		{
			textField_classeEleve = new JTextField();
			textField_classeEleve.setForeground(new Color(0, 0, 0));
			textField_classeEleve.setEditable(false);
			textField_classeEleve.setBounds(172, 297, 186, 20);
			panel.add(textField_classeEleve);
		}
		{
			JLabel lblNewLabel_4_1_1_1_1_1_1_2 = new JLabel("Classe : ");
			lblNewLabel_4_1_1_1_1_1_1_2.setBounds(12, 300, 150, 14);
			panel.add(lblNewLabel_4_1_1_1_1_1_1_2);
		}
		getContentPane().add(panel_2);
		
		JLabel lblNewLabel = new JLabel("  Informations de l'\u00E9leve");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Eras Medium ITC", Font.PLAIN, 20));
		lblNewLabel.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
		lblNewLabel.setBounds(10, 11, 746, 40);
		getContentPane().add(lblNewLabel);
		{
			JPanel panel_3 = new JPanel();
			panel_3.setBackground(new Color(210, 180, 140));
			panel_3.setLayout(null);
			panel_3.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
			panel_3.setBounds(10, 260, 366, 136);
			getContentPane().add(panel_3);
			{
				JLabel lblNewLabel_4_1_1_1_1_2 = new JLabel("Tranche 1 :");
				lblNewLabel_4_1_1_1_1_2.setBounds(10, 40, 86, 14);
				panel_3.add(lblNewLabel_4_1_1_1_1_2);
			}
			{
				textField_tranche_1 = new JTextField();
				textField_tranche_1.setForeground(new Color(0, 0, 0));
				textField_tranche_1.setEnabled(false);
				textField_tranche_1.setColumns(10);
				textField_tranche_1.setBounds(106, 37, 250, 20);
				panel_3.add(textField_tranche_1);
			}
			{
				textField_tranche_2 = new JTextField();
				textField_tranche_2.setForeground(new Color(0, 0, 0));
				textField_tranche_2.setEnabled(false);
				textField_tranche_2.setColumns(10);
				textField_tranche_2.setBounds(106, 68, 250, 20);
				panel_3.add(textField_tranche_2);
			}
			{
				JLabel lblNewLabel_4_1_1_1_1_2 = new JLabel("Tranche 2 :");
				lblNewLabel_4_1_1_1_1_2.setBounds(10, 71, 86, 14);
				panel_3.add(lblNewLabel_4_1_1_1_1_2);
			}
			{
				JLabel lblNewLabel_4_1_1_1_1_2 = new JLabel("Tranche 3 :");
				lblNewLabel_4_1_1_1_1_2.setBounds(10, 99, 86, 14);
				panel_3.add(lblNewLabel_4_1_1_1_1_2);
			}
			{
				textField_tranche_3 = new JTextField();
				textField_tranche_3.setForeground(new Color(0, 0, 0));
				textField_tranche_3.setEnabled(false);
				textField_tranche_3.setColumns(10);
				textField_tranche_3.setBounds(106, 96, 250, 20);
				panel_3.add(textField_tranche_3);
			}
			{
				JLabel lblNewLabel_4 = new JLabel("Les paiements de l'el\u00E8ve");
				lblNewLabel_4.setHorizontalTextPosition(SwingConstants.CENTER);
				lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_4.setFont(new Font("Eras Medium ITC", Font.PLAIN, 11));
				lblNewLabel_4.setBorder(new LineBorder(Color.GRAY, 1, true));
				lblNewLabel_4.setBounds(10, 11, 346, 15);
				panel_3.add(lblNewLabel_4);
			}
		}
	}
	
	//GETTER SETTER
	
	public void setStatus(String annee) {
		comboBox_statutEleve.setSelectedItem(annee);
	}
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

	public String getTextField_genreEleve() {
		return textField_genreEleve.getText();
	}

	public void setTextField_genreEleve(String genreEleve) {
		textField_genreEleve.setText(genreEleve);
	}

	public String getTextField_adresseEleve() {
		return textField_adresseEleve.getText();
	}

	public void setTextField_adresseEleve(String adresseEleve) {
		textField_adresseEleve.setText(adresseEleve);
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

	public Date getDateChooser_naissanceEleve() {
		return dateChooser_naissanceEleve.getDate();
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
		
		
		public void annulerListener(ActionListener actionListener) {
			
			btnAnnuler_Eleve.addActionListener(actionListener);	
		}
		public String getStatus() {
			return comboBox_statutEleve.getSelectedItem().toString();
		}
		
		public void statutEleveMousseListener(ActionListener mousseListener) {
			comboBox_statutEleve.addActionListener(mousseListener);
		}
		
		public void setClasse(String mousseListener) {
			textField_classeEleve.setText(mousseListener);
		}

		public String getClasse( ) {
			return textField_classeEleve.getText();
			
		}

		public void fermer() {
			dispose();
		}
}
