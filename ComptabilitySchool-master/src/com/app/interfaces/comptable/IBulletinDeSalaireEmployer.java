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

import com.app.metier.entites.Personnel;
import com.app.metier.model.ModelBulletinEmployer;

@SuppressWarnings("serial")
public class IBulletinDeSalaireEmployer extends JDialog {
	private JTable table;
	private JButton btnImprimer;
	private JTextPane textPane_nomEmployer;
	private JTextPane textPane_prenomEmployer;
	private JTextPane textPane_posteEmployer;
	private JTextPane textPane_SalaireEmployer;
	private JButton btnFermer;


	public IBulletinDeSalaireEmployer() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Bulletin de salaire du personnel");
		setResizable(false);
		getContentPane().setBackground(new Color(222, 184, 135));
		setBounds(100, 100, 654, 552);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane_1_3 = new JScrollPane();
		scrollPane_1_3.setBounds(10, 208, 614, 294);
		getContentPane().add(scrollPane_1_3);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Montant", "Date", "Mois", "Mode de paiement"
			}
		) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		table.setAutoscrolls(true);
		scrollPane_1_3.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(210, 180, 140));
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(139, 69, 19), 2, true));
		panel.setBounds(10, 62, 447, 135);
		getContentPane().add(panel);
		
		textPane_SalaireEmployer = new JTextPane();
		textPane_SalaireEmployer.setEditable(false);
		textPane_SalaireEmployer.setBounds(95, 104, 342, 20);
		panel.add(textPane_SalaireEmployer);
		
		textPane_nomEmployer = new JTextPane();
		textPane_nomEmployer.setEditable(false);
		textPane_nomEmployer.setBounds(95, 11, 342, 20);
		panel.add(textPane_nomEmployer);
		
		JLabel lblEmployer = new JLabel("Nom : ");
		lblEmployer.setBounds(10, 11, 75, 20);
		panel.add(lblEmployer);
		
		JLabel lblSalaire = new JLabel("Salaire : ");
		lblSalaire.setBounds(10, 104, 75, 20);
		panel.add(lblSalaire);
		
		textPane_posteEmployer = new JTextPane();
		textPane_posteEmployer.setEditable(false);
		textPane_posteEmployer.setBounds(95, 73, 342, 20);
		panel.add(textPane_posteEmployer);
		
		JLabel lblPoste = new JLabel("Poste : ");
		lblPoste.setBounds(10, 73, 75, 20);
		panel.add(lblPoste);
		
		JLabel lblNewLabel = new JLabel("Prenom");
		lblNewLabel.setBounds(10, 42, 46, 14);
		panel.add(lblNewLabel);
		
		textPane_prenomEmployer = new JTextPane();
		textPane_prenomEmployer.setEditable(false);
		textPane_prenomEmployer.setBounds(95, 42, 342, 20);
		panel.add(textPane_prenomEmployer);
		
		JLabel lblBulletinDeSalaire_1 = new JLabel("Bulletin de salaire du personnel");
		lblBulletinDeSalaire_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBulletinDeSalaire_1.setFont(new Font("Eras Medium ITC", Font.PLAIN, 26));
		lblBulletinDeSalaire_1.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
		lblBulletinDeSalaire_1.setBounds(10, 11, 614, 40);
		getContentPane().add(lblBulletinDeSalaire_1);
		
		btnImprimer = new JButton("Imprimer");
		btnImprimer.setIcon(new ImageIcon(IComptabilite.class.getResource("/printer.png")));
		btnImprimer.setBackground(new Color(205, 133, 63));
		btnImprimer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnImprimer.setBounds(467, 62, 157, 40);
		getContentPane().add(btnImprimer);
		
		btnFermer = new JButton("Fermer");
		btnFermer.setIcon(new ImageIcon(IComptabilite.class.getResource("/cancel.png")));
		btnFermer.setBackground(new Color(205, 133, 63));
		btnFermer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFermer.setBounds(467, 113, 157, 40);
		getContentPane().add(btnFermer);
	}
	
	public void addListenerButtonFermer(ActionListener listener) {
		
		btnFermer.addActionListener(listener);
		
	}
	
	 public void chargerModelBulletinEmployer(ModelBulletinEmployer model) {
		  table.removeAll();
		  table.setModel(model);
		  table.repaint();
		  table.revalidate();
	  }
	
	public void fermer() {
		this.dispose();
	}
	 public void affiche() {
		 
		 this.setVisible(true);;
	 }
	public void chargerTableEditeurEmployer(Personnel depense) {
		
		this.textPane_nomEmployer.setText(depense.getNom());
		this.textPane_posteEmployer.setText(depense.getPoste());
		this.textPane_prenomEmployer.setText(depense.getPrenom());
		this.textPane_SalaireEmployer.setText(String.valueOf(depense.getSalaire()));
	}
}
