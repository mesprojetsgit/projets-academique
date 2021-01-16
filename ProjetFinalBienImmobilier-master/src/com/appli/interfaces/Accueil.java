

package com.appli.interfaces;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Accueil extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField textField_login;
	private JPasswordField passwordField;
	private JButton btn_seConnecter;
	private JButton btn_annuler;

	
	
	
	public Accueil() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("Accueil");
		setResizable(false);
		setSize(new Dimension(940, 620));
		setMaximumSize(new Dimension(940, 620));
		setMinimumSize(new Dimension(940, 620));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(null);
		panel.setBounds(10, 11, 635, 555);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
//		label.setIcon(new ImageIcon("C:\\Users\\Arnauld Bollky\\Desktop\\MP-SI\\Projet Java\\WorkSpace\\ProjetFinalBienImmobilier\\images\\petit_avocats_Accueil.jpg"));
		JLabel label = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/petit_avocats_Accueil.jpg"));
		label.setIcon(img);
		
		label.setBackground(Color.WHITE);
		label.setBounds(0, 0, 635, 555);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new LineBorder(new Color(50, 205, 50), 2, true));
		panel_1.setBounds(655, 97, 262, 346);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 11, 242, 101);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblConnexion = new JLabel("Connexion");
		lblConnexion.setForeground(new Color(50, 205, 50));
		lblConnexion.setBounds(40, 11, 162, 43);
		panel_2.add(lblConnexion);
		lblConnexion.setFont(new Font("Tahoma", Font.PLAIN, 35));
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(255, 255, 255));
		panel_2_1.setBounds(10, 276, 242, 59);
		panel_1.add(panel_2_1);
		panel_2_1.setLayout(null);
		

	    btn_seConnecter = new JButton("Se connecter");
	    btn_seConnecter.setToolTipText("Se connecter");
	    btn_seConnecter.setForeground(new Color(0, 0, 0));
	    btn_seConnecter.setBackground(new Color(65, 105, 225));
	    btn_seConnecter.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn_seConnecter.setBounds(10, 11, 103, 37);
		panel_2_1.add(btn_seConnecter);
		
	    btn_annuler = new JButton("Annuler");

		JButton btn_seConnecter = new JButton("Se connecter");
		btn_seConnecter.setBounds(10, 11, 103, 37);
		panel_2_1.add(btn_seConnecter);
		
	    btn_annuler = new JButton("Annuler");
		btn_annuler.setToolTipText("Annuler et quitter");
		btn_annuler.setForeground(new Color(0, 0, 0));
		btn_annuler.setBackground(new Color(65, 105, 225));
		btn_annuler.setFont(new Font("Tahoma", Font.PLAIN, 11));

		btn_annuler.setBounds(129, 11, 103, 37);
		panel_2_1.add(btn_annuler);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setBackground(new Color(255, 255, 255));
		panel_2_1_1.setBounds(10, 123, 242, 101);
		panel_1.add(panel_2_1_1);
		panel_2_1_1.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLogin.setBounds(10, 11, 72, 17);
		panel_2_1_1.add(lblLogin);
		
		textField_login = new JTextField();
		textField_login.setToolTipText("Entrez votre pseudonyme");
		textField_login.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_login.setBounds(92, 8, 140, 20);
		panel_2_1_1.add(textField_login);
		textField_login.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(10, 70, 72, 20);
		panel_2_1_1.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Entrez votre mot de passe");
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passwordField.setBounds(92, 70, 140, 20);
		panel_2_1_1.add(passwordField);
		
		
	}
	
    public String getLogin() {
    	return textField_login.getText();
    }
    
    
    public void SetLogin(String texte) {
    	this.textField_login.setText(texte);;
    }
    
    
    @SuppressWarnings("deprecation")
	public String getPassword() {
    	return passwordField.getText();
    }
    
    
    public void  SetPassword(String password) {
     this.passwordField.setText(password);;
    }
    
    public void addSeConnecterListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		btn_seConnecter.addActionListener(actionListener);
		
	}
    
    public void addAnnulerListener(ActionListener actionListener) {
  		// TODO Auto-generated method stub
  		btn_annuler.addActionListener(actionListener);
  		
  	}

	public void run() {
		setVisible(true);
		
	}
	
    public void fermerFenetre() {
    	dispose();
    }
    
   
    	
    public void colorerChamp(String champ) {
    	
    	if(champ.equals("L")) {
    		
    	 if(textField_login.getText().isEmpty()) {
    		 
    		 textField_login.setBackground(Color.RED);
    	 }else {
    		 
    		 textField_login.setBackground(Color.WHITE); 
    	 }
    		
    	}
    	
    	
    	if(champ.equals("P")) {
    		
       	 if(passwordField.getText().isEmpty()) {
       		 
       		passwordField.setBackground(Color.RED);
       	 }else {
       		 
       		passwordField.setBackground(Color.WHITE); 
       	 }
       		
       	}
    	
    	
    	
    }
    
    public void colorerBlanche() {
    	passwordField.setBackground(Color.WHITE); 
    	textField_login.setBackground(Color.WHITE); 
    	
    }
    
    
    

	/**
	 * 
	 */
//	private static final long serialVersionUID1 = 1L;
//	private JTextField textField_login1;
//	private JPasswordField passwordField1;

}
