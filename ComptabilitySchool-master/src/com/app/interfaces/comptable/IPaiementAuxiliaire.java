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
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.app.metier.entites.Eleve;
import com.app.metier.entites.PaiementAuxiliaire;

@SuppressWarnings("serial")
public class IPaiementAuxiliaire extends JDialog {
	private JTextField textField_description;
	private JTextPane textPane_MatriculeEleve;
	private JTextPane textPane_nomEleve;
	private JTextPane textPane_prenomEleve;
	private JTextPane textPane_ClasseEleve;
	private JSpinner spinner_montant;
	private JTextPane textPane_commentaire;
	private JButton btnValider;
	private JButton btnFermer;
	private JTextPane textPane_StatutEleve;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			IPaiementAuxiliaire dialog = new IPaiementAuxiliaire();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IPaiementAuxiliaire() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(new Color(222, 184, 135));
		setResizable(false);
		setTitle("Paiement auxiliaire");
		setBounds(100, 100, 360, 482);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(210, 180, 140));
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
		panel.setBounds(10, 62, 315, 174);
		getContentPane().add(panel);
		
		JLabel lblNewLabel_2_1 = new JLabel("Classe : ");
		lblNewLabel_2_1.setBounds(10, 105, 54, 20);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1 = new JLabel("Nom : ");
		lblNewLabel_1.setBounds(10, 42, 46, 20);
		panel.add(lblNewLabel_1);
		
		textPane_ClasseEleve = new JTextPane();
		textPane_ClasseEleve.setEditable(false);
		textPane_ClasseEleve.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		textPane_ClasseEleve.setBounds(85, 105, 217, 20);
		panel.add(textPane_ClasseEleve);
		
		textPane_nomEleve = new JTextPane();
		textPane_nomEleve.setEditable(false);
		textPane_nomEleve.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		textPane_nomEleve.setBounds(85, 42, 217, 20);
		panel.add(textPane_nomEleve);
		
		textPane_prenomEleve = new JTextPane();
		textPane_prenomEleve.setEditable(false);
		textPane_prenomEleve.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		textPane_prenomEleve.setBounds(85, 74, 217, 20);
		panel.add(textPane_prenomEleve);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prenom : ");
		lblNewLabel_1_1.setBounds(10, 73, 65, 20);
		panel.add(lblNewLabel_1_1);
		
		textPane_MatriculeEleve = new JTextPane();
		textPane_MatriculeEleve.setEditable(false);
		textPane_MatriculeEleve.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		textPane_MatriculeEleve.setBounds(85, 11, 217, 20);
		panel.add(textPane_MatriculeEleve);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Matricule : ");
		lblNewLabel_1_1_1.setBounds(10, 13, 65, 20);
		panel.add(lblNewLabel_1_1_1);
		
		textPane_StatutEleve = new JTextPane();
		textPane_StatutEleve.setEditable(false);
		textPane_StatutEleve.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		textPane_StatutEleve.setBounds(85, 136, 217, 20);
		panel.add(textPane_StatutEleve);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Statut : ");
		lblNewLabel_2_1_1.setBounds(10, 136, 54, 20);
		panel.add(lblNewLabel_2_1_1);
		
		JLabel lbl = new JLabel("Paiement auxiliaire");
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setFont(new Font("Eras Medium ITC", Font.PLAIN, 26));
		lbl.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
		lbl.setBounds(10, 11, 315, 40);
		getContentPane().add(lbl);
		
		textField_description = new JTextField();
		textField_description.setBounds(104, 247, 221, 20);
		getContentPane().add(textField_description);
		textField_description.setColumns(10);
		
		spinner_montant = new JSpinner();
		spinner_montant.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(5)));
		spinner_montant.setBounds(104, 278, 221, 20);
		getContentPane().add(spinner_montant);
		
		JLabel lblNewLabel = new JLabel("Description : ");
		lblNewLabel.setBounds(10, 250, 84, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblPrix = new JLabel("Prix :");
		lblPrix.setBounds(10, 281, 84, 14);
		getContentPane().add(lblPrix);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 324, 315, 68);
		getContentPane().add(scrollPane);
		
		textPane_commentaire = new JTextPane();
		scrollPane.setViewportView(textPane_commentaire);
		
		JLabel lblCommentaire = new JLabel("Commentaire");
		lblCommentaire.setBounds(10, 306, 84, 14);
		getContentPane().add(lblCommentaire);
		
		btnFermer = new JButton("Fermer");
		btnFermer.setIcon(new ImageIcon(IComptabilite.class.getResource("/cancel.png")));
		btnFermer.setBackground(new Color(205, 133, 63));
		btnFermer.setBounds(212, 403, 113, 23);
		getContentPane().add(btnFermer);
		
		btnValider = new JButton("Valider");
		btnValider.setIcon(new ImageIcon(IComptabilite.class.getResource("/checked.png")));
		btnValider.setBackground(new Color(205, 133, 63));
		btnValider.setBounds(11, 402, 113, 22);
		getContentPane().add(btnValider);
	}

	public String getDescription() {
		return textField_description.getText();
	}

	public void setDescription(String textField_description) {
		this.textField_description.setText(textField_description);
	}

	public String getMatricule() {
		return textPane_MatriculeEleve.getText();
	}

	public void setMatricule(String textPane_MatriculeEleve) {
		this.textPane_MatriculeEleve.setText(textPane_MatriculeEleve);
	}

	public String getNom() {
		return textPane_nomEleve.getText();
	}

	public void setNom(String textPane_nomEleve) {
		this.textPane_nomEleve.setText(textPane_nomEleve);
	}

	public String getPrenom() {
		return textPane_prenomEleve.getText();
	}

	public void setPrenom(String textPane_prenomEleve) {
		this.textPane_prenomEleve.setText(textPane_prenomEleve);
	}

	public String getClasse() {
		return textPane_ClasseEleve.getText();
	}

	public void setClasse(String textPane_ClasseEleve) {
		this.textPane_ClasseEleve.setText(textPane_ClasseEleve);
	}
	public double getMontant() {
		return ((Double)spinner_montant.getValue()).doubleValue() ;
	}
	public void setMontant(double montant) {
		spinner_montant.setValue(montant);
	}

	public String getCommentaire() {
		return textPane_commentaire.getText();
	}

	public void setCommentaire(String textPane_commentaire) {
		this.textPane_commentaire.setText(textPane_commentaire);
	}

	public String getButtonValider() {
		return btnValider.getText();
	}

	public void setButtonValider(String btnValider) {
		this.btnValider.setText(btnValider);
	}

	public void validerListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		btnValider.addActionListener(actionListener);	
	}
	
	public void fermerListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		btnFermer.addActionListener(actionListener);	
	}
	

   public String getStatut() {
		return textPane_StatutEleve.getText();
	}

	public void setStatut(String textPane_StatutEleve) {
		this.textPane_StatutEleve.setText(textPane_StatutEleve);
	}

public void afficher() {
		this.setVisible(true);
	}
	
	public void quitter() {
		this.dispose();
	}
	
	public void effacer() {
		this.setStatut(null);
		this.setClasse(null);
		this.setNom(null);
		this.setPrenom(null);
		this.setMatricule(null);
		this.setMontant(0.0);
		this.setCommentaire(null);
		this.setDescription(null);
	}
	
	
	public void chargerTableEditeur(Eleve depense) {
		this.setClasse(depense.getClasse());
		this.setNom(depense.getNom());
		this.setPrenom(depense.getPrenom());
		this.setMatricule(depense.getNumeroMatricule());
		this.setStatut(depense.getStatus());
		
	}
	
	
	
      public void modifierPaiementProf(PaiementAuxiliaire depense) {
		
    	this.setButtonValider("changer"); 
    	this.setClasse(depense.getClasse());
  		this.setNom(depense.getNom());
  		this.setPrenom(depense.getPrenom());
  		this.setMatricule(depense.getMatricule());
		this.setMontant(depense.getMontant());
		this.setCommentaire(depense.getCommentaire());		
		this.setDescription(depense.getDescription());
		this.setStatut(depense.getStatus());
		
	}
      
      public PaiementAuxiliaire recupererPaiementAuxiliaire() {
    	  
    	  PaiementAuxiliaire depense =  new PaiementAuxiliaire();
    		
      	depense.setNom(this.getNom());
      	depense.setPrenom(this.getPrenom());
      	depense.setClasse(this.getClasse());
      	depense.setMontant(Double.valueOf(this.getMontant()));
      	depense.setMatricule(this.getMatricule());
      	depense.setDescription(this.getDescription());
      	depense.setCommentaire(this.getCommentaire());
      	depense.setStatus(this.getStatut());
      		
    	return depense;
    	}   
}
