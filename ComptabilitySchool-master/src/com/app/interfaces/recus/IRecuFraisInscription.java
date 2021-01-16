package com.app.interfaces.recus;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.app.interfaces.comptable.IComptabilite;
import com.app.metier.entites.FraisInscription;

@SuppressWarnings("serial")
public class IRecuFraisInscription extends JDialog {
	private JTextArea textArea;
	private JButton btnImprimer;
	private JButton btnAnnuler;

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
	public IRecuFraisInscription(FraisInscription frais) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		initComponent();
		setRecu(frais);
		annuler();
		imprimer();
	}
	
	public void initComponent() {
		setTitle("Re\u00E7u de paiement de frais d'inscription");
		setResizable(false);
		getContentPane().setBackground(new Color(222, 184, 135));
		setBounds(100, 100, 675, 556);
		getContentPane().setLayout(null);
		{
			JLabel lblReuDePaiement = new JLabel("Re\u00E7u de paiement de frais d'inscription");
			lblReuDePaiement.setHorizontalAlignment(SwingConstants.CENTER);
			lblReuDePaiement.setFont(new Font("Eras Medium ITC", Font.PLAIN, 26));
			lblReuDePaiement.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
			lblReuDePaiement.setBounds(10, 9, 637, 40);
			getContentPane().add(lblReuDePaiement);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
			scrollPane.setBounds(12, 62, 633, 398);
			getContentPane().add(scrollPane);
			{
				textArea = new JTextArea();
				textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
				textArea.setEditable(false);
				scrollPane.setViewportView(textArea);
			}
		}
		{
			btnImprimer = new JButton("Imprimer");
			btnImprimer.setIcon(new ImageIcon(IComptabilite.class.getResource("/printer.png")));
			btnImprimer.setBackground(new Color(205, 133, 63));
			btnImprimer.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnImprimer.setBounds(358, 473, 143, 31);
			getContentPane().add(btnImprimer);
		}
		{
			btnAnnuler = new JButton("Fermer");
			btnAnnuler.setIcon(new ImageIcon(IComptabilite.class.getResource("/cancel.png")));
			btnAnnuler.setBackground(new Color(205, 133, 63));
			btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAnnuler.setBounds(511, 473, 136, 31);
			getContentPane().add(btnAnnuler);
		}
	}

	
	public void setRecu(FraisInscription frais) {
		textArea.append("\tRécu de paiement de frais d'inscription\n"+
				"\t\t------------------------\n\n"+
				
				"\tN° Reçu:  "+ 
				"\n\n\tMatricule:  "+frais.getMatricule()
				+"\n\n\tNom:  "+frais.getNom()
				+"\n\n\tPrenom:  "+frais.getPrenom()
				+"\n\n\tClasse:  "+frais.getClasse()
				+"\n\n\t****************************************************"+
				"\n\n\tMontant:  "+frais.getMontant()
				+"\n\n\tDate:  " +frais.getDate()                                
				+"\n\n\tSignature"
				
				
				
				);
	}
	
	private void imprimer() {
		
		btnImprimer.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						textArea.print();
					} catch (PrinterException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
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
		
		
		

