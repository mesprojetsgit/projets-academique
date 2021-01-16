
package com.appli.interfaces;




import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public abstract class IPage extends JFrame {
	protected JButton btn_quitterPrincipalPages;

	public IPage() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setMaximumSize(new Dimension(930, 660));
		setMinimumSize(new Dimension(930, 660));
		setResizable(false);
		setSize(new Dimension(930, 660));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 770, 79);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbl_Titre = new JLabel("Immobilier");
		lbl_Titre.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_Titre.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Titre.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lbl_Titre.setBounds(10, 11, 750, 57);
		panel.add(lbl_Titre);
		
		JPanel panel_logo = new JPanel();
		panel_logo.setBounds(790, 11, 114, 79);
		panel_logo.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		getContentPane().add(panel_logo);
		panel_logo.setLayout(null);
		
		JLabel label = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/petit_avocats_2.jpg"));
		label.setIcon(img);
		
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.setToolTipText("Logo");
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		label.setBounds(0, 0, 114, 79);
		panel_logo.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(181, 565, 599, 41);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		
	    btn_quitterPrincipalPages = new JButton("Quitter");
		btn_quitterPrincipalPages.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_quitterPrincipalPages.setToolTipText("Quitter l'application");
		btn_quitterPrincipalPages.setBounds(630, 11, 89, 23);
		panel_2.add(btn_quitterPrincipalPages);
		

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	 public void addQuiterListener(ActionListener actionListener) {
			// TODO Auto-generated method stub
		 btn_quitterPrincipalPages.addActionListener(actionListener);	
	}
}
