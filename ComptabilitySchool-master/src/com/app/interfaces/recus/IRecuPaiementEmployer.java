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
import com.app.metier.entites.PaiementEmployer;

@SuppressWarnings("serial")
public class IRecuPaiementEmployer extends JDialog {
	private JButton btnImprimer;
	private JButton btnAnnuler;
	private JTextArea textArea;

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
	public IRecuPaiementEmployer(PaiementEmployer employe) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		initComponent();
		setRecu(employe);
		annuler();
		imprimer();;
	 }
	private void initComponent() {
		setTitle("Re\u00E7u de paiement du personnel");
		setResizable(false);
		getContentPane().setBackground(new Color(222, 184, 135));
		setBounds(100, 100, 680, 554);
		getContentPane().setLayout(null);
		{
			JLabel lblReuDePaiement_1 = new JLabel("Re\u00E7u de paiement du personnel");
			lblReuDePaiement_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblReuDePaiement_1.setFont(new Font("Eras Medium ITC", Font.PLAIN, 26));
			lblReuDePaiement_1.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
			lblReuDePaiement_1.setBounds(10, 11, 637, 40);
			getContentPane().add(lblReuDePaiement_1);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
			scrollPane.setBounds(12, 64, 633, 398);
			getContentPane().add(scrollPane);
			{
				textArea = new JTextArea();
				textArea.setEditable(false);
				textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
				scrollPane.setViewportView(textArea);
			}
		}
		{
			btnImprimer = new JButton("Imprimer");
			btnImprimer.setIcon(new ImageIcon(IComptabilite.class.getResource("/printer.png")));
			btnImprimer.setBackground(new Color(205, 133, 63));
			btnImprimer.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnImprimer.setBounds(338, 475, 157, 31);
			getContentPane().add(btnImprimer);
		}
		{
			btnAnnuler = new JButton("Fermer");
			btnAnnuler.setIcon(new ImageIcon(IComptabilite.class.getResource("/cancel.png")));
			btnAnnuler.setBackground(new Color(205, 133, 63));
			btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAnnuler.setBounds(505, 475, 142, 31);
			getContentPane().add(btnAnnuler);
		}
	}

	public void setRecu(PaiementEmployer employe) {
		textArea.append("\tRécu de paiement de salaire\n"+
				"\t\t------------------------\n\n"+
				
				"\tN° Reçu:  "+
				"\n\n\tNom:  "+employe.getNom()+
				"\n\n\tPrenom:  "+employe.getPrenom()+
				"\n\n\tPoste:  "+employe.getPoste()+
				"\n\n\t****************************************************"+
				"\n\n\tMontant:  "+employe.getMontant()+
				"\n\n\tDate:  " + employe.getDate()+                               
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
