package com.app.interfaces.comptable;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.app.metier.entites.PaiementProfesseur;
import com.app.metier.model.ModelBulletinProfesseur;

@SuppressWarnings("serial")
public class IBulletinDeSalaireProfesseur extends JDialog {
	private JTable table;
	private JTextPane textPane_NomProfesseur;
	private JTextPane textPane_prenomProfesseur;
	private JTextPane textPane_classeProfesseur;
	private JTextPane textPane_matiereProfesseur;
	private JTextPane textPane_SalaireProfesseur;
	private JTextPane textPane_nombreHeureProfesseur;
	private JButton btnImprimer;
	private JTextPane textPane_typeProfesseur;
	private JButton btnFermer;


	public IBulletinDeSalaireProfesseur() {
		getContentPane().setBackground(new Color(222, 184, 135));
		setTitle("Bulletin de salaire du professeur");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 766, 561);
		getContentPane().setLayout(null);
		{
			JLabel lblBulletinDeSalaire = new JLabel("Bulletin de salaire professeur");
			lblBulletinDeSalaire.setHorizontalAlignment(SwingConstants.CENTER);
			lblBulletinDeSalaire.setFont(new Font("Eras Medium ITC", Font.PLAIN, 26));
			lblBulletinDeSalaire.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
			lblBulletinDeSalaire.setBounds(10, 11, 724, 40);
			getContentPane().add(lblBulletinDeSalaire);
		}
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(210, 180, 140));
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
		panel.setBounds(10, 62, 437, 163);
		getContentPane().add(panel);
		
		textPane_NomProfesseur = new JTextPane();
		textPane_NomProfesseur.setEditable(false);
		textPane_NomProfesseur.setBounds(95, 11, 329, 20);
		panel.add(textPane_NomProfesseur);
		
		JLabel lblNewLabel = new JLabel("Nom : ");
		lblNewLabel.setBounds(10, 11, 75, 20);
		panel.add(lblNewLabel);
		
		JLabel lblSalaire = new JLabel("Salaire : ");
		lblSalaire.setBounds(10, 132, 75, 20);
		panel.add(lblSalaire);
		
		textPane_SalaireProfesseur = new JTextPane();
		textPane_SalaireProfesseur.setEditable(false);
		textPane_SalaireProfesseur.setBounds(95, 132, 121, 20);
		panel.add(textPane_SalaireProfesseur);
		
		JLabel lblPrixheure = new JLabel("Nombre d'heures : ");
		lblPrixheure.setBounds(227, 132, 113, 20);
		panel.add(lblPrixheure);
		
		textPane_classeProfesseur = new JTextPane();
		textPane_classeProfesseur.setEditable(false);
		textPane_classeProfesseur.setBounds(95, 70, 329, 20);
		panel.add(textPane_classeProfesseur);
		
		JLabel lblNewLabel_2_3 = new JLabel("Classe :");
		lblNewLabel_2_3.setBounds(10, 70, 75, 20);
		panel.add(lblNewLabel_2_3);
		
		textPane_matiereProfesseur = new JTextPane();
		textPane_matiereProfesseur.setEditable(false);
		textPane_matiereProfesseur.setBounds(95, 101, 329, 20);
		panel.add(textPane_matiereProfesseur);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Mati\u00E8re :");
		lblNewLabel_2_3_1.setBounds(10, 101, 75, 20);
		panel.add(lblNewLabel_2_3_1);
		
		textPane_prenomProfesseur = new JTextPane();
		textPane_prenomProfesseur.setEditable(false);
		textPane_prenomProfesseur.setBounds(95, 42, 329, 20);
		panel.add(textPane_prenomProfesseur);
		
		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setBounds(10, 45, 62, 14);
		panel.add(lblPrenom);
		
		textPane_nombreHeureProfesseur = new JTextPane();
		textPane_nombreHeureProfesseur.setEditable(false);
		textPane_nombreHeureProfesseur.setBounds(339, 132, 85, 20);
		panel.add(textPane_nombreHeureProfesseur);
		
		JScrollPane scrollPane_1_3 = new JScrollPane();
		scrollPane_1_3.setBounds(10, 236, 724, 271);
		getContentPane().add(scrollPane_1_3);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Montant", "Date", "Mois", "Nombre d'heure", "Prix/Heure", "Mode de paiement"
			}
		) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		table.setAutoscrolls(true);
		scrollPane_1_3.setViewportView(table);
		
		btnImprimer = new JButton("Imprimer");
		btnImprimer.setIcon(new ImageIcon(IComptabilite.class.getResource("/printer.png")));
		btnImprimer.setBackground(new Color(205, 133, 63));
		btnImprimer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnImprimer.setBounds(519, 62, 215, 40);
		getContentPane().add(btnImprimer);
		
		textPane_typeProfesseur = new JTextPane();
		textPane_typeProfesseur.setEditable(false);
		textPane_typeProfesseur.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPane_typeProfesseur.setBorder(new LineBorder(new Color(139, 69, 19), 1, true));
		textPane_typeProfesseur.setBounds(519, 205, 215, 20);
		getContentPane().add(textPane_typeProfesseur);
		
		JLabel lblType = new JLabel("Type :");
		lblType.setBounds(457, 205, 52, 20);
		getContentPane().add(lblType);
		
		btnFermer = new JButton("Fermer");
		btnFermer.setIcon(new ImageIcon(IComptabilite.class.getResource("/cancel.png")));
		btnFermer.setBackground(new Color(205, 133, 63));
		btnFermer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFermer.setBounds(519, 113, 215, 40);
		getContentPane().add(btnFermer);
	}
	
	
	public void addListenerButtonFermer(ActionListener listener) {
		btnFermer.addActionListener(listener);
	}
	
	
	 public void chargerModelBulletinProfesseur(ModelBulletinProfesseur model) {
		  table.removeAll();
		  table.setModel(model);
		  table.repaint();
		  table.revalidate();
	  }
	
	public void fermer() {
		this.dispose();
	}
	 public void affiche() {
		 
		 this.setVisible(true);
	 }
	public void chargerTableEditeur(PaiementProfesseur depense) {
		this.textPane_classeProfesseur.setText(depense.getNomClasse());
		this.textPane_matiereProfesseur.setText(depense.getNomMatiere());
		this.textPane_nombreHeureProfesseur.setText(String.valueOf(depense.getNombreHeure()));
		this.textPane_NomProfesseur.setText(depense.getNom());
		this.textPane_prenomProfesseur.setText(depense.getPrenom());
		this.textPane_SalaireProfesseur.setText(String.valueOf(depense.getMontantTotal()));
        this.textPane_typeProfesseur.setText(depense.getType());		
	}
}
