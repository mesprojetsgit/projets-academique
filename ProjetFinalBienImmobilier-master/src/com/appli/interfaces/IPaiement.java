
package com.appli.interfaces;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public abstract class IPaiement extends JFrame {
	private JButton btn_quitterPrincipalPaiements;



	public IPaiement() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setResizable(false);
		setMaximumSize(new Dimension(862, 573));
		setMinimumSize(new Dimension(862, 573));
		setSize(new Dimension(862, 573));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		panel.setBounds(10, 11, 715, 76);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbl_titre = new JLabel("Immobilier");
		lbl_titre.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_titre.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titre.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lbl_titre.setBounds(10, 11, 695, 54);
		panel.add(lbl_titre);
		
		JPanel panel_logo = new JPanel();
		panel_logo.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		panel_logo.setBounds(735, 11, 111, 76);
		getContentPane().add(panel_logo);
		panel_logo.setLayout(null);
		
		JLabel label = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/petit_avocats_2.jpg"));
		label.setIcon(img);
		
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.setToolTipText("Logo");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		label.setBounds(0, 0, 111, 76);
		panel_logo.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		panel_2.setBounds(255, 490, 465, 44);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		

	    btn_quitterPrincipalPaiements = new JButton("Quitter");
		btn_quitterPrincipalPaiements.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_quitterPrincipalPaiements.setToolTipText("Quitter l'application");
		btn_quitterPrincipalPaiements.setBounds(492, 11, 89, 22);
		panel_2.add(btn_quitterPrincipalPaiements);
		

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(10, 111, 10, 347);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(846, 111, 10, 347);
		getContentPane().add(separator_1);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	//affiche message
	public void showMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

	//message de confirmation
	public int showMessageConfirmation(String title,String message) {
		int retour = JOptionPane.showConfirmDialog(this,
	             message, 
	             title,
	             JOptionPane.OK_CANCEL_OPTION);
		
		return retour;
	}


}
