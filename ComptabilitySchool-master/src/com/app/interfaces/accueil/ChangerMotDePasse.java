package com.app.interfaces.accueil;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.app.interfaces.comptable.IComptabilite;
import com.app.metier.entites.Administrateur;
import com.app.metier.entites.Comptable;
import com.app.metier.service.IService;
import com.app.metier.service.Service;

@SuppressWarnings("serial")
public class ChangerMotDePasse extends JDialog {
	private JPasswordField textField_MotDePasse;
	private JPasswordField textField_NouveauMotDePasse;
	private JPasswordField textField_RepeterNouveauMotDePasse;
	private JButton boutton_Ok;
	private JButton boutton_Annuler;
	private IService service;
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

	/**
	 * Create the dialog.
	 */
	public ChangerMotDePasse(Comptable comptable,Administrateur admin) {
		initComponent();
		service=new Service();
		valider( comptable, admin);
	}
	
	public void initComponent() {
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Modifier mot de passe");
		getContentPane().setBackground(new Color(210, 180, 140));
		setBounds(100, 100, 227, 355);
		getContentPane().setLayout(null);
		
		JLabel lblModifierVotreMot = new JLabel("Modifier votre mot de passe");
		lblModifierVotreMot.setBackground(new Color(139, 69, 19));
		lblModifierVotreMot.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifierVotreMot.setFont(new Font("Eras Medium ITC", Font.PLAIN, 14));
		lblModifierVotreMot.setBorder(new LineBorder(new Color(139, 69, 19), 2, true));
		lblModifierVotreMot.setBounds(10, 11, 200, 33);
		getContentPane().add(lblModifierVotreMot);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setBounds(10, 104, 86, 14);
		getContentPane().add(lblMotDePasse);
		
		textField_MotDePasse = new JPasswordField();
		textField_MotDePasse.setColumns(10);
		textField_MotDePasse.setBounds(10, 118, 189, 20);
		getContentPane().add(textField_MotDePasse);
		
		textField_NouveauMotDePasse = new JPasswordField();
		textField_NouveauMotDePasse.setColumns(10);
		textField_NouveauMotDePasse.setBounds(10, 181, 189, 20);
		getContentPane().add(textField_NouveauMotDePasse);
		
		JLabel lblNouveauMotDe = new JLabel("Nouveau mot de passe");
		lblNouveauMotDe.setBounds(10, 166, 147, 14);
		getContentPane().add(lblNouveauMotDe);
		
		textField_RepeterNouveauMotDePasse = new JPasswordField();
		textField_RepeterNouveauMotDePasse.setColumns(10);
		textField_RepeterNouveauMotDePasse.setBounds(10, 243, 189, 20);
		getContentPane().add(textField_RepeterNouveauMotDePasse);
		
		JLabel lblRpterNouveauMot = new JLabel("R\u00E9p\u00E9ter nouveau mot de passe");
		lblRpterNouveauMot.setBounds(21, 228, 189, 14);
		getContentPane().add(lblRpterNouveauMot);
		{
			boutton_Annuler = new JButton("Annuler");
			boutton_Annuler.setIcon(new ImageIcon(ChangerMotDePasse.class.getResource("/cancel.png")));
			boutton_Annuler.setBounds(97, 274, 102, 33);
			getContentPane().add(boutton_Annuler);
			boutton_Annuler.setActionCommand("Cancel");
		}
		{
			boutton_Ok = new JButton("OK");
			boutton_Ok.setIcon(new ImageIcon(IComptabilite.class.getResource("/checked.png")));
			boutton_Ok.setBounds(10, 274, 77, 33);
			getContentPane().add(boutton_Ok);
			boutton_Ok.setActionCommand("OK");
			getRootPane().setDefaultButton(boutton_Ok);
		}
	}
	@SuppressWarnings("deprecation")
	public boolean operation() {
		if(textField_NouveauMotDePasse.getText().equals(textField_RepeterNouveauMotDePasse.getText())) {
			return true;
		}else {
			return false;
		}
	}

	private void valider(Comptable comptable,Administrateur admin) {
		boutton_Annuler.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				
			}
		});
		
		boutton_Ok.addActionListener(new ActionListener() {
				
				@SuppressWarnings("deprecation")
				@Override
				public void actionPerformed(ActionEvent e) {
					
					if(comptable!=null) {
						if(textField_MotDePasse.getText().equals(comptable.getPassword())) {
							if(operation()) {
								comptable.setPassword(textField_NouveauMotDePasse.getText());
								service.modifierComptable(comptable);
								ActionEvent action=null;
								dispose();
								aProposActionPerformed(action,"mot de passe modifié");
								
							}else {
								textField_NouveauMotDePasse.setText("");
								textField_RepeterNouveauMotDePasse.setText("");
								aProposActionPerformed(null,"mot de passe non conforme");
							}
						}else {
							textField_MotDePasse.setText("");
							textField_NouveauMotDePasse.setText("");
							textField_RepeterNouveauMotDePasse.setText("");
							aProposActionPerformed(null,"mot de passe incorrect");
						}
					}else
					
					if(admin!=null) {
						if(textField_MotDePasse.getText().equals(admin.getPassword())) {
							if(operation()) {
								admin.setPassword(textField_NouveauMotDePasse.getText());
								service.modifierAdmin(admin);
								ActionEvent action=null;
								dispose();
								aProposActionPerformed(action,"mot de passe modifié");
								
							}else {
								textField_NouveauMotDePasse.setText("");
								textField_RepeterNouveauMotDePasse.setText("");
								aProposActionPerformed(null,"mot de passe non conforme");
							}
						}else {
							textField_MotDePasse.setText("");
							textField_NouveauMotDePasse.setText("");
							textField_RepeterNouveauMotDePasse.setText("");
							aProposActionPerformed(null,"mot de passe incorrect");
						}
					}
					
					
				}
				
			});
	}
	
	
	@SuppressWarnings("static-access")
	public void aProposActionPerformed(java.awt.event.ActionEvent evt,String msg) {
		  JOptionPane jOptionPane1=null;
		jOptionPane1.showMessageDialog(this,msg);
		}
}
