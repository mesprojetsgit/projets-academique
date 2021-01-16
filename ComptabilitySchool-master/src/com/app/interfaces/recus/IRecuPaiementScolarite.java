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
import com.app.metier.entites.PaiementScolarite;

@SuppressWarnings("serial")
public class IRecuPaiementScolarite extends JDialog {
	private JTextArea textArea;
	private JButton btnImprimer;
	private JButton btnAnnuler;

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
	public IRecuPaiementScolarite(PaiementScolarite frais) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		initComponent();
		setRecu(frais);
		annuler();
		imprimer();
	}
	
	public void initComponent() {
		setResizable(false);
		getContentPane().setBackground(new Color(222, 184, 135));
		setTitle("Re\u00E7u du paiement de scolarite");
		setBounds(100, 100, 673, 555);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
		scrollPane.setBounds(10, 62, 637, 402);
		getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		scrollPane.setViewportView(textArea);
		
		JLabel lblReuDePaiement = new JLabel("Re\u00E7u de paiement de scolarite");
		lblReuDePaiement.setHorizontalAlignment(SwingConstants.CENTER);
		lblReuDePaiement.setFont(new Font("Eras Medium ITC", Font.PLAIN, 26));
		lblReuDePaiement.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
		lblReuDePaiement.setBounds(10, 11, 637, 40);
		getContentPane().add(lblReuDePaiement);
		
		btnImprimer = new JButton("Imprimer");
		btnImprimer.setIcon(new ImageIcon(IComptabilite.class.getResource("/printer.png")));
		btnImprimer.setBackground(new Color(205, 133, 63));
		btnImprimer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnImprimer.setBounds(352, 475, 152, 31);
		getContentPane().add(btnImprimer);
		
		btnAnnuler = new JButton("Fermer");
		btnAnnuler.setIcon(new ImageIcon(IComptabilite.class.getResource("/cancel.png")));
		btnAnnuler.setBackground(new Color(205, 133, 63));
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAnnuler.setBounds(514, 475, 133, 31);
		getContentPane().add(btnAnnuler);
	}

	public void setRecu(PaiementScolarite scolarite) {
		textArea.append("\tRécu de paiement de frais de scolarité\n"+
				"\t\t------------------------\n\n"+
				
				"\tN° Reçu:  "+scolarite.getNumeroRecu()+
				"\n\n\tMatricule:  "+scolarite.getNumeroMatricule()+
				"\n\n\tNom:  "+scolarite.getNom()+
				"\n\n\tPrenom:  "+scolarite.getPrenom()+
				"\n\n\tClasse:  "+scolarite.getNomClasse()+
				"\n\n\t****************************************************"+
				"\n\n\tMontant:  "+scolarite.getMontantTranche()+
				"\n\n\tTranche:  "+scolarite.getNumeroTranche()+
				"\n\n\tDate:  " +scolarite.getDate()+                                
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
