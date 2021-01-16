package com.app.interfaces.administrateur;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class IUtilisateur extends JDialog {
	private JTextField txtPrenom;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_genreUtilisateur;
	private JTextField txtAddresse;
	private JTextField txtTel;
	private JTextField txtCnib;
	private JTextField txtMail;
	private JPasswordField txtPassword;
	private JPasswordField txtPasswordRepeat;
	private JTextField txtNom;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private JButton btnAnnule;
	private JButton btnValider;
	private JTextField txtLogin;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			this.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
;

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public IUtilisateur() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(new Color(222, 184, 135));
		setTitle("Cr\u00E9ation utilisateur");
		setResizable(false);
		setBounds(100, 100, 408, 585);
		getContentPane().setLayout(null);
		{
			JLabel lblCompteUtilisateurs = new JLabel("  Cr\u00E9ation compte Utilisateur");
			lblCompteUtilisateurs.setHorizontalAlignment(SwingConstants.CENTER);
			lblCompteUtilisateurs.setFont(new Font("Eras Medium ITC", Font.PLAIN, 20));
			lblCompteUtilisateurs.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
			lblCompteUtilisateurs.setBounds(10, 11, 370, 40);
			getContentPane().add(lblCompteUtilisateurs);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(210, 180, 140));
			panel.setLayout(null);
			panel.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
			panel.setBounds(10, 62, 370, 417);
			getContentPane().add(panel);
			{
				JLabel lblNewLabel_4_2 = new JLabel("Nom :");
				lblNewLabel_4_2.setBounds(12, 75, 150, 14);
				panel.add(lblNewLabel_4_2);
			}
			{
				 txtNom = new JTextField();
				txtNom.setColumns(10);
				txtNom.setBounds(172, 72, 186, 20);
				panel.add(txtNom);
			}
			{
				JLabel lblNewLabel_4_1_2 = new JLabel("Prenom :");
				lblNewLabel_4_1_2.setBounds(12, 106, 150, 14);
				panel.add(lblNewLabel_4_1_2);
			}
			{
				txtPrenom = new JTextField();
				txtPrenom.setColumns(10);
				txtPrenom.setBounds(172, 103, 186, 20);
				panel.add(txtPrenom);
			}
			{
				JLabel lblNewLabel_4_1_1_2 = new JLabel("Genre :");
				lblNewLabel_4_1_1_2.setBounds(12, 137, 150, 14);
				panel.add(lblNewLabel_4_1_1_2);
			}
			{
				comboBox_genreUtilisateur = new JComboBox();
				comboBox_genreUtilisateur.setModel(new DefaultComboBoxModel(new String[] {"Masculin", "F\u00E9minin"}));
				comboBox_genreUtilisateur.setBounds(172, 134, 186, 20);
				panel.add(comboBox_genreUtilisateur);
			}
			{
				JLabel lblNewLabel_4_1_1_1_1_2 = new JLabel("Adresse :");
				lblNewLabel_4_1_1_1_1_2.setBounds(12, 164, 150, 14);
				panel.add(lblNewLabel_4_1_1_1_1_2);
			}
			{
				txtAddresse = new JTextField();
				txtAddresse.setColumns(10);
				txtAddresse.setBounds(172, 161, 186, 20);
				panel.add(txtAddresse);
			}
			{
				JLabel lblNewLabel_4_1_1_1_1_1 = new JLabel("Numero de telephone :");
				lblNewLabel_4_1_1_1_1_1.setBounds(12, 195, 150, 14);
				panel.add(lblNewLabel_4_1_1_1_1_1);
			}
			{
				txtTel = new JTextField();
				txtTel.setColumns(10);
				txtTel.setBounds(172, 192, 186, 20);
				panel.add(txtTel);
			}
			{
				JLabel lblNewLabel_4_1_1_1_1_1_1 = new JLabel("Numero carte d'identite :");
				lblNewLabel_4_1_1_1_1_1_1.setBounds(12, 226, 150, 14);
				panel.add(lblNewLabel_4_1_1_1_1_1_1);
			}
			{
				txtCnib = new JTextField();
				txtCnib.setColumns(10);
				txtCnib.setBounds(172, 223, 186, 20);
				panel.add(txtCnib);
			}
			{
				JLabel lblNewLabel_4_1_1_1_1_1_1_2 = new JLabel("Email : ");
				lblNewLabel_4_1_1_1_1_1_1_2.setBounds(12, 260, 150, 14);
				panel.add(lblNewLabel_4_1_1_1_1_1_1_2);
			}
			{
				txtMail = new JTextField();
				txtMail.setBounds(172, 257, 186, 20);
				panel.add(txtMail);
			}
			
			 comboBox = new JComboBox();
			 comboBox.setEnabled(false);
			comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboBox.setFont(new Font("Tahoma", Font.PLAIN, 30));
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Comptable", "Administrateur"}));
			comboBox.setBounds(12, 11, 346, 40);
			panel.add(comboBox);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(new Color(222, 184, 135));
				panel_1.setBorder(new LineBorder(new Color(160, 82, 45), 1, true));
				panel_1.setBounds(12, 300, 346, 106);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JLabel lblNewLabel_4_1_1_1_1_1_1_2_2 = new JLabel("Login :");
					lblNewLabel_4_1_1_1_1_1_1_2_2.setBounds(10, 14, 95, 14);
					panel_1.add(lblNewLabel_4_1_1_1_1_1_1_2_2);
				}
				{
				    txtLogin = new JTextField();
					txtLogin.setBounds(115, 11, 221, 20);
					panel_1.add(txtLogin);
				}
				
				txtPassword = new JPasswordField();
				txtPassword.setBounds(115, 45, 221, 20);
				panel_1.add(txtPassword);
				
				JLabel lblNewLabel_4_1_1_1_1_1_1_2_1 = new JLabel("Mot de passe :");
				lblNewLabel_4_1_1_1_1_1_1_2_1.setBounds(10, 48, 95, 14);
				panel_1.add(lblNewLabel_4_1_1_1_1_1_1_2_1);
				
				JLabel lblNewLabel_4_1_1_1_1_1_1_2 = new JLabel("Mot de passe :");
				lblNewLabel_4_1_1_1_1_1_1_2.setBounds(10, 79, 95, 14);
				panel_1.add(lblNewLabel_4_1_1_1_1_1_1_2);
				
		    txtPasswordRepeat = new JPasswordField();
		    txtPasswordRepeat.setBounds(115, 76, 221, 20);
		    panel_1.add(txtPasswordRepeat);
			}
		}
		{
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(new Color(210, 180, 140));
			panel_2.setLayout(null);
			panel_2.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
			panel_2.setBounds(10, 490, 370, 47);
			getContentPane().add(panel_2);
			{
				btnAnnule = new JButton("Annuler");
				btnAnnule.setIcon(new ImageIcon(IAdministrateur.class.getResource("/cancel.png")));
				btnAnnule.setBackground(new Color(205, 133, 63));
				btnAnnule.setBounds(235, 11, 125, 25);
				panel_2.add(btnAnnule);
			}
			{
			    btnValider = new JButton("Valider");
			    btnValider.setIcon(new ImageIcon(IAdministrateur.class.getResource("/checked.png")));
			    btnValider.setBackground(new Color(205, 133, 63));
				btnValider.setBounds(100, 11, 125, 25);
				panel_2.add(btnValider);
			}
		}
		
		
		
	}

	
	//getters et setters
	
	public String getLogin() {
		return txtLogin.getText();
		
	}
	
	public void setLogin(String nom) {
		txtLogin.setText(nom);
	}
	public String getNom() {
		return txtNom.getText();
		
	}
	
	public void setNom(String nom) {
		txtNom.setText(nom);
	}
	
	public String getPrenom() {
		return txtPrenom.getText();
		
	}
	
	public void setPrenom(String nom) {
		txtPrenom.setText(nom);
	}
	
	public String getGenre() {
		return comboBox_genreUtilisateur.getSelectedItem().toString();
	}
	
	public void setGenre(String sexe) {
		comboBox_genreUtilisateur.setToolTipText(sexe);
	}
	
	public String getTel() {
		return txtTel.getText();
		
	}
	
	public void setTel(String nom) {
		txtTel.setText(nom);
	}
	public String getAdresse() {
		return txtPrenom.getText();
		
	}
	
	public void setAdresse(String nom) {
		txtAddresse.setText(nom);
	}
	
	public String getCnib() {
		return txtAddresse.getText();
		
	}
	
	public void setCnib(String nom) {
		txtCnib.setText(nom);
	}
	
	public String getMail() {
		return txtMail.getText();
		
	}
	
	public void setMail(String nom) {
		txtMail.setText(nom);
	}
	
	@SuppressWarnings("deprecation")
	public String getPasword1() {
		return txtPassword.getText();
		
	}
	
	public void setPasword1(String nom) {
		txtPassword.setText(nom);
	}
	
	@SuppressWarnings("deprecation")
	public String getPasword2() {
		return txtPasswordRepeat.getText();
		
	}
	
	public void setPasword2(String nom) {
		txtPasswordRepeat.setText(nom);
	}
	
	
	//listeners
	public void validerListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		btnValider.addActionListener(actionListener);	
	}
	
	public void annulerListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		btnAnnule.addActionListener(actionListener);	
	}
	
	
	public void addUserMousseListener(ActionListener mousseListener) {
		comboBox.addActionListener(mousseListener);
	}
	
	
	public String getTypeUser() {
		return comboBox.getSelectedItem().toString();
	}
	
	
	
	public void setTypeUser(String annee) {
		comboBox.setSelectedItem(annee);
	}
	
	public void showMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	
	public void annuler() {
		dispose();
	}
	
	
	
	
	
	
	
}
