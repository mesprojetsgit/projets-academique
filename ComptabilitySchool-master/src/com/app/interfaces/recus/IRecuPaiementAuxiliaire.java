package com.app.interfaces.recus;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.app.interfaces.comptable.IComptabilite;
import com.app.metier.entites.PaiementAuxiliaire;

@SuppressWarnings("serial")
public class IRecuPaiementAuxiliaire extends JDialog {
	private JButton btnImprimer;
	private JButton btnAnnuler;
	private JTextArea textArea;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss");  
	LocalDateTime now = LocalDateTime.now();  

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
	public IRecuPaiementAuxiliaire(PaiementAuxiliaire aux) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		initComponent();
		setRecu(aux);
		annuler();
		imprimer();
	}
	
	public void initComponent() {
		setResizable(false);
		setTitle("Re\u00E7u de paiement auxiliaire");
		getContentPane().setBackground(new Color(222, 184, 135));
		setBounds(100, 100, 678, 558);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 62, 637, 402);
		getContentPane().add(scrollPane_1);
		
		textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		JLabel lbl = new JLabel("Re\u00E7u de paiement auxiliaire");
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setFont(new Font("Eras Medium ITC", Font.PLAIN, 26));
		lbl.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
		lbl.setBounds(10, 11, 637, 40);
		getContentPane().add(lbl);
		
		btnImprimer = new JButton("Imprimer");
		btnImprimer.setIcon(new ImageIcon(IComptabilite.class.getResource("/printer.png")));
		btnImprimer.setBackground(new Color(205, 133, 63));
		btnImprimer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnImprimer.setBounds(341, 475, 152, 31);
		getContentPane().add(btnImprimer);
		
		btnAnnuler = new JButton("Fermer");
		btnAnnuler.setIcon(new ImageIcon(IComptabilite.class.getResource("/cancel.png")));
		btnAnnuler.setBackground(new Color(205, 133, 63));
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAnnuler.setBounds(503, 475, 144, 31);
		getContentPane().add(btnAnnuler);
	}
	
	public void setRecu(PaiementAuxiliaire aux) {
		textArea.append("\tRécu de paiement auxiliaire\n"+
				"\t\t------------------------\n\n"+
				
				"\tN° Reçu:  "+
				"\n\n\tMatricule:  "+aux.getMatricule()+
				"\n\n\tNom:  "+aux.getNom()+
				"\n\n\tPrenom:  "+aux.getPrenom()+
				"\n\n\tClasse:  "+aux.getClasse()+
				"\n\n\t****************************************************"+
				"\n\n\tPrix:  "+aux.getMontant()+
				"\n\n\tPour:  " +aux.getDescription()+
				"\n\n\tDate:  "+dtf.format(now)+                                
				"\n\n\tSignature"
				
				
				
				);
 	}
	private void imprimer() {
		
		btnImprimer.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						textArea.print();
					} catch (PrinterException e1) {
						
					}
			}});
		}
	
	
	private void annuler() {
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
