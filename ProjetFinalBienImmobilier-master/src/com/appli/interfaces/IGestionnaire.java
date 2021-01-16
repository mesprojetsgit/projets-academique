package com.appli.interfaces;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Cursor;



public class IGestionnaire extends IPage {
	
	private static final long serialVersionUID = 1L;
	
	private JTextField textField_nom;
	private JTextField textField_prenom;
	private JTextField textField_matricule;
	private JTextField textField_telephone;
	private JTextField textField_email;
	private JTextField textField_idImmobilier;
	private JTable tableBiensImmobiliers;
	private JTable tableListeLocataires;
	private JTable tableListeBiensAloues;
	private JTable tableAjoutLocataire;

	private JButton btn_librerLeBien;

	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_sexe;

	private JButton btn_annulerAjout;

	private JButton btn_ajouterLocataire;

	private JButton btn_voirPaiements;

	private JDateChooser dateChooser_finContrat;

	private JDateChooser dateChooser_debutContrat;
	
	
	DefaultTableModel tableAjouterLocataire = new DefaultTableModel();
	DefaultTableModel tableListeBien = new DefaultTableModel();
	DefaultTableModel tableBienAloue = new DefaultTableModel();
	DefaultTableModel tableListeLocataire = new DefaultTableModel();

	private JButton btnQuitter;

	private JLabel lblBoomLocataireAriere;

	private JLabel lblBoomLocataireRegle;

	private JLabel lblBoomNombreAloue;
	
	@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
	public IGestionnaire() {
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 101, 894, 454);
		getContentPane().add(tabbedPane_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		tabbedPane_1.addTab("Biens immobiliers", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scrollPane_3.setToolTipText("Liste des biens immobiliers !");
		scrollPane_3.setBounds(10, 11, 864, 404);
		panel.add(scrollPane_3);
		
		tableBiensImmobiliers = new JTable();
		tableBiensImmobiliers.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NOM", "PRENOM", "No REFERENCE", "PHONE", "EMAIL", "DEBUT CONTRAT", "FIN CONTRAT", "STATUS"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableBiensImmobiliers.getColumnModel().getColumn(3).setPreferredWidth(85);
		tableBiensImmobiliers.getColumnModel().getColumn(6).setPreferredWidth(95);
		tableBiensImmobiliers.getColumnModel().getColumn(7).setPreferredWidth(84);
		scrollPane_3.setViewportView(tableBiensImmobiliers);
		tableBiensImmobiliers.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		tabbedPane_1.addTab("Locataires", null, panel_1, null);
		panel_1.setLayout(null);
		
		JTabbedPane tabbedPane_1_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1_1.setBounds(0, 11, 889, 415);
		panel_1.add(tabbedPane_1_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		tabbedPane_1_1.addTab("Liste des locataires", null, panel_3, null);
		panel_3.setLayout(null);
		
	    btn_voirPaiements = new JButton("Voir paiements");
	    btn_voirPaiements.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btn_voirPaiements.setToolTipText("Voir les paiements du locataire !");
		btn_voirPaiements.setBounds(754, 353, 120, 23);
		panel_3.add(btn_voirPaiements);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setToolTipText("Liste de tous les locataires !");
		scrollPane_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scrollPane_2.setBounds(10, 11, 864, 331);
		panel_3.add(scrollPane_2);
		
		tableListeLocataires = new JTable();
		tableListeLocataires.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NOM", "PRENOM", "No REFERENCE", "PHONE", "EMAIL", "GENRE", "DEBUTCONTRAT", "FIN CONTRAT", "STATUS"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableListeLocataires.getColumnModel().getColumn(0).setPreferredWidth(36);
		tableListeLocataires.getColumnModel().getColumn(1).setPreferredWidth(88);
		tableListeLocataires.getColumnModel().getColumn(2).setPreferredWidth(85);
		tableListeLocataires.getColumnModel().getColumn(3).setPreferredWidth(86);
		tableListeLocataires.getColumnModel().getColumn(5).setPreferredWidth(88);
		tableListeLocataires.getColumnModel().getColumn(6).setPreferredWidth(95);
		tableListeLocataires.getColumnModel().getColumn(7).setPreferredWidth(92);
		tableListeLocataires.getColumnModel().getColumn(8).setPreferredWidth(80);
		scrollPane_2.setViewportView(tableListeLocataires);
		tableListeLocataires.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		tabbedPane_1_1.addTab("Liste des biens alou\u00E9s", null, panel_4, null);
		panel_4.setLayout(null);
		
	    btn_librerLeBien = new JButton("Lib\u00E9rer le bien ");
	    btn_librerLeBien.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btn_librerLeBien.setToolTipText("Lib\u00E9rer le bien immobiler !");
		btn_librerLeBien.setBounds(754, 353, 120, 23);
		panel_4.add(btn_librerLeBien);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setToolTipText("Liste de tous les biens alou\u00E9s !");
		scrollPane_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scrollPane_1.setBounds(10, 11, 864, 331);
		panel_4.add(scrollPane_1);
		
		tableListeBiensAloues = new JTable();
		tableListeBiensAloues.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "ADDRESSE", "MONTANT LOYER", "NB PIECE", "DETAIL", "TYPE LOYER", "TYPE IMMOBILIER"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableListeBiensAloues.getColumnModel().getColumn(0).setPreferredWidth(34);
		tableListeBiensAloues.getColumnModel().getColumn(2).setPreferredWidth(96);
		tableListeBiensAloues.getColumnModel().getColumn(3).setPreferredWidth(55);
		tableListeBiensAloues.getColumnModel().getColumn(4).setPreferredWidth(177);
		tableListeBiensAloues.getColumnModel().getColumn(5).setPreferredWidth(87);
		tableListeBiensAloues.getColumnModel().getColumn(6).setPreferredWidth(100);
		scrollPane_1.setViewportView(tableListeBiensAloues);
		tableListeBiensAloues.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		tabbedPane_1_1.addTab("Ajouter et affecter des logements", null, panel_5, null);
		panel_5.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_6.setBounds(10, 11, 205, 277);
		panel_5.add(panel_6);
		panel_6.setLayout(null);
		
		textField_nom = new JTextField();
		textField_nom.setToolTipText("Entrez le nom du locataire ");
		textField_nom.setBounds(78, 32, 117, 20);
		panel_6.add(textField_nom);
		textField_nom.setColumns(10);
		
		textField_prenom = new JTextField();
		textField_prenom.setToolTipText("Entrez le pr\u00E9nom du locataire ");
		textField_prenom.setBounds(78, 63, 117, 20);
		panel_6.add(textField_prenom);
		textField_prenom.setColumns(10);
		
	    comboBox_sexe = new JComboBox();
	    comboBox_sexe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    comboBox_sexe.setToolTipText("Entrez le genre du locataire ");
		comboBox_sexe.setModel(new DefaultComboBoxModel(new String[] {"Masculin", "F\u00E9minin"}));
		comboBox_sexe.setBounds(78, 94, 117, 20);
		panel_6.add(comboBox_sexe);
		
		textField_matricule = new JTextField();
		textField_matricule.setToolTipText("Entrez le num\u00E9ro matricule du locataire ");
		textField_matricule.setBounds(78, 193, 117, 20);
		panel_6.add(textField_matricule);
		textField_matricule.setColumns(10);
		
		textField_telephone = new JTextField();
		textField_telephone.setToolTipText("Entrez le num\u00E9ro de t\u00E9l\u00E9phone du locataire ");
		textField_telephone.setBounds(78, 224, 117, 20);
		panel_6.add(textField_telephone);
		textField_telephone.setColumns(10);
		
		textField_email = new JTextField();
		textField_email.setToolTipText("Entrez l'adresse mail du locataire ");
		textField_email.setBounds(78, 162, 117, 20);
		panel_6.add(textField_email);
		textField_email.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(10, 35, 57, 14);
		panel_6.add(lblNom);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom :");
		lblPrnom.setBounds(10, 66, 57, 14);
		panel_6.add(lblPrnom);
		
		JLabel lblSexe = new JLabel("Sexe :");
		lblSexe.setBounds(10, 97, 57, 14);
		panel_6.add(lblSexe);
		
		JLabel lblMatricule = new JLabel("Matricule :");
		lblMatricule.setBounds(11, 196, 57, 14);
		panel_6.add(lblMatricule);
		
		JLabel lblTlephone = new JLabel("T\u00E9lephone :");
		lblTlephone.setBounds(10, 227, 64, 14);
		panel_6.add(lblTlephone);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(10, 165, 57, 14);
		panel_6.add(lblEmail);
		
		JPanel panel_6_1 = new JPanel();
		panel_6_1.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_6_1.setBounds(10, 299, 205, 77);
		panel_5.add(panel_6_1);
		panel_6_1.setLayout(null);
		
	    dateChooser_finContrat = new JDateChooser();
	    dateChooser_finContrat.getCalendarButton().setToolTipText("Choisissez la date de fin du contrat");
	    dateChooser_finContrat.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    dateChooser_finContrat.setToolTipText("Entrez la date de fin du contrat");
		dateChooser_finContrat.setBounds(82, 42, 113, 20);
		panel_6_1.add(dateChooser_finContrat);
		
	    dateChooser_debutContrat = new JDateChooser();
	    dateChooser_debutContrat.getCalendarButton().setToolTipText("Choisissez la date du d\u00E9but du contrat");
	    dateChooser_debutContrat.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    dateChooser_debutContrat.setToolTipText("Entrez la date du d\u00E9but du contrat");
		dateChooser_debutContrat.setBounds(82, 11, 113, 20);
		panel_6_1.add(dateChooser_debutContrat);
		
		JLabel lblNewLabel = new JLabel("Fin contrat :");
		lblNewLabel.setBounds(10, 48, 74, 14);
		panel_6_1.add(lblNewLabel);
		
		JLabel lblDbutDeContrat = new JLabel("D\u00E9but contrat:");
		lblDbutDeContrat.setBounds(10, 17, 74, 14);
		panel_6_1.add(lblDbutDeContrat);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_7.setBounds(225, 299, 649, 77);
		panel_5.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblIdentifiantDeLimmobilier = new JLabel("Identifiant de l'immobilier");
		lblIdentifiantDeLimmobilier.setBounds(10, 11, 126, 14);
		panel_7.add(lblIdentifiantDeLimmobilier);
		
		textField_idImmobilier = new JTextField();
		textField_idImmobilier.setToolTipText("Identifiant du bien \u00E0 affecter au nouveau locataire !");
		textField_idImmobilier.setBounds(10, 46, 126, 20);
		panel_7.add(textField_idImmobilier);
		textField_idImmobilier.setColumns(10);
		
	    btn_annulerAjout = new JButton("Annuler");
	    btn_annulerAjout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btn_annulerAjout.setToolTipText("Annuler l'action !");
		btn_annulerAjout.setBounds(550, 43, 89, 23);
		panel_7.add(btn_annulerAjout);
		
	    btn_ajouterLocataire = new JButton("Ajouter");
	    btn_ajouterLocataire.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btn_ajouterLocataire.setToolTipText("Ajouter le locataire !");
		btn_ajouterLocataire.setBounds(550, 11, 89, 23);
		panel_7.add(btn_ajouterLocataire);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scrollPane.setToolTipText("Liste de biens immobiliers disponibles pour \u00EAtre affect\u00E9s !");
		scrollPane.setBounds(225, 11, 649, 277);
		panel_5.add(scrollPane);
		
		tableAjoutLocataire = new JTable();
		tableAjoutLocataire.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "ADDRESSE", "MONTANT LOYER", "NB PIECE", "DETAIL", "TYPE LOYER", "TYPE IMMOBILIER"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableAjoutLocataire.getColumnModel().getColumn(0).setPreferredWidth(38);
		tableAjoutLocataire.getColumnModel().getColumn(2).setPreferredWidth(94);
		tableAjoutLocataire.getColumnModel().getColumn(4).setPreferredWidth(156);
		tableAjoutLocataire.getColumnModel().getColumn(5).setPreferredWidth(87);
		tableAjoutLocataire.getColumnModel().getColumn(6).setPreferredWidth(98);
		scrollPane.setViewportView(tableAjoutLocataire);
		tableAjoutLocataire.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		tabbedPane_1.addTab("Statistiques", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_11.setBounds(10, 11, 869, 101);
		panel_2.add(panel_11);
		panel_11.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de biens alou\u00E9s");
		lblNewLabel_1.setBounds(10, 11, 175, 14);
		panel_11.add(lblNewLabel_1);
		
	    lblBoomNombreAloue = new JLabel("");
		lblBoomNombreAloue.setToolTipText("Nombre des bien allou\u00E9s sur le total");
		lblBoomNombreAloue.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoomNombreAloue.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblBoomNombreAloue.setBackground(new Color(255, 255, 255));
		lblBoomNombreAloue.setBorder(new LineBorder(new Color(65, 105, 225), 2, true));
		lblBoomNombreAloue.setBounds(10, 36, 849, 54);
		panel_11.add(lblBoomNombreAloue);
		
		JPanel panel_11_1 = new JPanel();
		panel_11_1.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_11_1.setBounds(10, 314, 869, 101);
		panel_2.add(panel_11_1);
		panel_11_1.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nombre de locataires sous contencieux");
		lblNewLabel_1_2.setBounds(10, 11, 211, 14);
		panel_11_1.add(lblNewLabel_1_2);
		
	    lblBoomLocataireAriere = new JLabel("");
		lblBoomLocataireAriere.setToolTipText("Nombre de locataires sous contencieux sur le total");
		lblBoomLocataireAriere.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoomLocataireAriere.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblBoomLocataireAriere.setBackground(new Color(255, 255, 255));
		lblBoomLocataireAriere.setBorder(new LineBorder(new Color(255, 0, 0), 2, true));
		lblBoomLocataireAriere.setBounds(10, 36, 849, 54);
		panel_11_1.add(lblBoomLocataireAriere);
		
		JPanel panel_11_2 = new JPanel();
		panel_11_2.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_11_2.setBounds(10, 161, 869, 101);
		panel_2.add(panel_11_2);
		panel_11_2.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre de locataires en r\u00E8gle");
		lblNewLabel_1_1.setBounds(10, 11, 175, 14);
		panel_11_2.add(lblNewLabel_1_1);
		
	    lblBoomLocataireRegle = new JLabel("");
		lblBoomLocataireRegle.setToolTipText("Nombre de locataires en r\u00E8gle sur le total");
		lblBoomLocataireRegle.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoomLocataireRegle.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblBoomLocataireRegle.setBackground(new Color(255, 255, 255));
		lblBoomLocataireRegle.setBorder(new LineBorder(new Color(50, 205, 50), 2, true));
		lblBoomLocataireRegle.setBounds(10, 36, 849, 54);
		panel_11_2.add(lblBoomLocataireRegle);
		
		JLabel lblGestionnaire = new JLabel("Gestionnaire");
		lblGestionnaire.setToolTipText("Vous \u00EAtes un gestionnaire.");
		lblGestionnaire.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblGestionnaire.setHorizontalTextPosition(SwingConstants.CENTER);
		lblGestionnaire.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionnaire.setForeground(Color.BLACK);
		lblGestionnaire.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGestionnaire.setBounds(10, 565, 164, 41);
		getContentPane().add(lblGestionnaire);
		
	    btnQuitter = new JButton("Quitter");
		btnQuitter.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnQuitter.setBounds(791, 566, 113, 40);
		getContentPane().add(btnQuitter);
	}

	
	//*********************************locataire*************************************************************//
	
	public void setNombreAloue(int nbr) {
		lblBoomNombreAloue.setText(""+nbr);
	}
	
	public void setLocataireEnRegle(int nbr) {
		lblBoomLocataireRegle.setText(""+nbr);
	}
	
	public void setLocataireNonEnRegle(int nbr) {
		lblBoomLocataireAriere.setText(""+nbr);
	}
	
	public void setNom(String nom) {
		textField_nom.setText(nom);
	}
	public void setPrenom(String prenom) {
		textField_prenom.setText(prenom);
	}
	public void setTelephone(String phone) {
		textField_telephone.setText(phone);
	}
	
	
	public void setEmail(String email) {
		textField_email.setText(email);
	}
	
	public void setReferencePiece(String sexe) {
		textField_matricule.setText(sexe);
	}
	
	public void setSexe(String sex) {
		comboBox_sexe.setSelectedItem(sex);
	}
	 
	
	public String getNom() {
		return textField_nom.getText();
	}
	
	public String getPrenom() {
		return textField_prenom.getText();
	}
	
	public String getEmail() {
		return textField_email.getText();
	}
	
	public String getSexe() {
		return comboBox_sexe.getSelectedItem().toString();
	}
	
	public String getTelephone() {
		return textField_telephone.getText();
	}
	
	public String getReferencePiece() {
		return textField_matricule.getText();
	}
	
	public String getDateFin() {
		return ((JTextField)dateChooser_finContrat.getDateEditor().getUiComponent()).getText();
	}
	
	public String getDateDebut() {
		return ((JTextField)dateChooser_debutContrat.getDateEditor().getUiComponent()).getText();
	}
	
	
	public void addAffecterBienListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		btn_ajouterLocataire.addActionListener(actionListener);	
	}
   public void addLibererBienListener(ActionListener actionListener) {
	// TODO Auto-generated method stub
	btn_librerLeBien.addActionListener(actionListener);	
    }
 
   public void addVoirPaiementListener(ActionListener actionListener) {
	// TODO Auto-generated method stub
	btn_voirPaiements.addActionListener(actionListener);	
    }

   public void addAnnulerAjoutCompteListener(ActionListener actionListener) {
	// TODO Auto-generated method stub
	btn_annulerAjout.addActionListener(actionListener);	
   }
	
   public void addTableAjoutLocationMousseListener(MouseAdapter mousseListener) {
	   tableAjoutLocataire.addMouseListener(mousseListener);
	}

	public void addTableListeBienAloueMousseListener(MouseAdapter mousseListener) {
		tableListeBiensAloues.addMouseListener(mousseListener);
	}
	
	 public void addTableListeLocataireMousseListener(MouseAdapter mousseListener) {
		 tableListeLocataires.addMouseListener(mousseListener);
	}

	public void addTableListeBienMousseListener(MouseAdapter mousseListener) {
		tableBiensImmobiliers.addMouseListener(mousseListener);
	  }
	
	
	public int selectRowTableBiens() {
		// TODO Auto-generated method stub
		return tableBiensImmobiliers.getSelectedRow();
	}


	public int selectRowTableListeLocataire() {
		// TODO Auto-generated method stub
		return tableListeLocataires.getSelectedRow();
	}

	public int selectRowTableListeBienAloue() {
		// TODO Auto-generated method stub
		return tableListeBiensAloues.getSelectedRow();
	}
    
	public int selectRowTableAjouterLocataire() {
		// TODO Auto-generated method stub
		return tableAjoutLocataire.getSelectedRow();
	}
	
	public void  addRowBienLocateur(String[] line) {
		tableAjouterLocataire =(DefaultTableModel) tableAjoutLocataire.getModel();
		tableAjouterLocataire.addRow(line);
	}
	public void  addRowBienAloue(String[] line) {
		tableBienAloue =(DefaultTableModel) tableListeBiensAloues.getModel();
		tableBienAloue.addRow(line);
	}
	
	public void  addRowListeLocateur(String[] line) {
		tableListeLocataire =(DefaultTableModel) tableListeLocataires.getModel();
		tableListeLocataire.addRow(line);
	}
	public void  addRowListeBien(String[] line) {
		tableListeBien =(DefaultTableModel) tableBiensImmobiliers.getModel();
		tableListeBien.addRow(line);
	}

	//ajouter locataire
	public String tableAjoutLocataireCol1() {
		tableAjouterLocataire =(DefaultTableModel) tableAjoutLocataire.getModel();
		return (String) tableAjouterLocataire.getValueAt(selectRowTableAjouterLocataire(), 0);
	}
	public String tableAjoutLocataireCol2() {
		tableAjouterLocataire =(DefaultTableModel) tableAjoutLocataire.getModel();
		return (String) tableAjouterLocataire.getValueAt(selectRowTableAjouterLocataire(), 1);
	}

	public String tableAjoutLocataireCol3() {
		tableAjouterLocataire =(DefaultTableModel) tableAjoutLocataire.getModel();
		return (String) tableAjouterLocataire.getValueAt(selectRowTableAjouterLocataire(), 2);
	}
	public String tableAjoutLocataireCol4() {
		tableAjouterLocataire =(DefaultTableModel) tableAjoutLocataire.getModel();
		return (String) tableAjouterLocataire.getValueAt(selectRowTableAjouterLocataire(), 3);
	}

	public String tableAjoutLocataireCol5() {
		tableAjouterLocataire =(DefaultTableModel) tableAjoutLocataire.getModel();
		return (String) tableAjouterLocataire.getValueAt(selectRowTableAjouterLocataire(), 4);
	}
	public String tableAjoutLocataireCol6() {
		tableAjouterLocataire =(DefaultTableModel) tableAjoutLocataire.getModel();
		return (String) tableAjouterLocataire.getValueAt(selectRowTableAjouterLocataire(), 5);
	}
	public String tableAjoutLocataireCol7() {
		tableAjouterLocataire =(DefaultTableModel) tableAjoutLocataire.getModel();
		return (String) tableAjouterLocataire.getValueAt(selectRowTableAjouterLocataire(), 6);
	}
	
	
	//liste bien
	public String tableListeBienCol1() {
		tableListeBien =(DefaultTableModel) tableBiensImmobiliers.getModel();
		return (String) tableListeBien.getValueAt(selectRowTableBiens(), 0);
	}
	public String tableListeBienCol2() {
		tableListeBien =(DefaultTableModel) tableBiensImmobiliers.getModel();
		return (String) tableListeBien.getValueAt(selectRowTableBiens(), 1);
	}

	public String tableListeBienCol3() {
		tableListeBien =(DefaultTableModel) tableBiensImmobiliers.getModel();
		return (String) tableListeBien.getValueAt(selectRowTableBiens(), 2);
	}
	public String tableListeBienCol4() {
		tableListeBien =(DefaultTableModel) tableBiensImmobiliers.getModel();
		return (String) tableListeBien.getValueAt(selectRowTableBiens(), 3);
	}

	public String tableListeBienCol5() {
		tableListeBien =(DefaultTableModel) tableBiensImmobiliers.getModel();
		return (String) tableListeBien.getValueAt(selectRowTableBiens(), 4);
	}
	public String tableListeBienCol6() {
		tableListeBien =(DefaultTableModel) tableBiensImmobiliers.getModel();
		return (String) tableListeBien.getValueAt(selectRowTableBiens(), 5);
	}
	public String tableListeBienCol7() {
		tableListeBien =(DefaultTableModel) tableBiensImmobiliers.getModel();
		return (String) tableListeBien.getValueAt(selectRowTableBiens(), 6);
	}
	
	
	//liste bien aloue
		public String tableListeBienAloueCol1() {
			tableBienAloue =(DefaultTableModel) tableListeBiensAloues.getModel();
			return (String) tableBienAloue.getValueAt(selectRowTableListeBienAloue(), 0);
		}
		public String tableListeBienAloueCol2() {
			tableBienAloue =(DefaultTableModel) tableListeBiensAloues.getModel();
			return (String) tableBienAloue.getValueAt(selectRowTableListeBienAloue(), 1);
		}

		public String tableListeBienAloueCol3() {
			tableBienAloue =(DefaultTableModel) tableListeBiensAloues.getModel();
			return (String) tableBienAloue.getValueAt(selectRowTableListeBienAloue(), 2);
		}
		public String tableListeBienAloueCol4() {
			tableBienAloue =(DefaultTableModel) tableListeBiensAloues.getModel();
			return (String) tableBienAloue.getValueAt(selectRowTableListeBienAloue(), 3);
		}

		public String tableListeBienAloueCol5() {
			tableBienAloue =(DefaultTableModel) tableListeBiensAloues.getModel();
			return (String) tableBienAloue.getValueAt(selectRowTableListeBienAloue(), 4);
		}
		public String tableListeBienAloueCol6() {
			tableBienAloue =(DefaultTableModel) tableListeBiensAloues.getModel();
			return (String) tableBienAloue.getValueAt(selectRowTableListeBienAloue(), 5);
		}
		public String tableListeBienAloueCol7() {
			tableBienAloue =(DefaultTableModel) tableListeBiensAloues.getModel();
			return (String) tableBienAloue.getValueAt(selectRowTableListeBienAloue(), 6);
		}
	
		//liste locataire
				public String tableListeLocataireCol1() {
					tableListeLocataire =(DefaultTableModel) tableListeLocataires.getModel();
					return (String) tableListeLocataire.getValueAt(selectRowTableListeLocataire(), 0);
				}
				public String tableListeLocataireCol2() {
					tableListeLocataire =(DefaultTableModel) tableListeLocataires.getModel();
					return (String) tableListeLocataire.getValueAt(selectRowTableListeLocataire(), 1);
				}

				public String tableListeLocataireCol3() {
					tableListeLocataire =(DefaultTableModel) tableListeLocataires.getModel();
					return (String) tableListeLocataire.getValueAt(selectRowTableAjouterLocataire(), 2);
				}
				public String tableListeLocataireCol4() {
					tableListeLocataire =(DefaultTableModel) tableListeLocataires.getModel();
					return (String) tableListeLocataire.getValueAt(selectRowTableListeLocataire(), 3);
				}

				public String tableListeLocataireCol5() {
					tableListeLocataire =(DefaultTableModel) tableListeLocataires.getModel();
					return (String) tableListeLocataire.getValueAt(selectRowTableListeLocataire(), 4);
				}
				public String tableListeLocataireCol6() {
					tableListeLocataire =(DefaultTableModel) tableListeLocataires.getModel();
					return (String) tableListeLocataire.getValueAt(selectRowTableListeLocataire(), 5);
				}
				public String tableListeLocataireCol7() {
					tableListeLocataire =(DefaultTableModel) tableListeLocataires.getModel();
					return (String) tableListeLocataire.getValueAt(selectRowTableListeLocataire(), 6);
				}
				public String tableListeLocataireCol8() {
					tableListeLocataire =(DefaultTableModel) tableListeLocataires.getModel();
					return (String) tableListeLocataire.getValueAt(selectRowTableListeLocataire(), 5);
				}
				public String tableListeLocataireCol9() {
					tableListeLocataire =(DefaultTableModel) tableListeLocataires.getModel();
					return (String) tableListeLocataire.getValueAt(selectRowTableListeLocataire(), 6);
				}


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



				public void actualiserTableBienLocataire() {
					tableAjouterLocataire =(DefaultTableModel) tableAjoutLocataire.getModel();
					int counter=0;
					counter=tableAjouterLocataire.getRowCount();
					while(counter!=0) {
						tableAjouterLocataire.removeRow(0);
					    counter--;
					}
					
				}
				
				public void actualiserTableBienAloue() {
					tableBienAloue =(DefaultTableModel) tableListeBiensAloues.getModel();
					int counter=0;
					counter=tableBienAloue.getRowCount();
					while(counter!=0) {
						tableBienAloue.removeRow(0);
					    counter--;
					}
					
				}

				public void actualiserTableBienGestionnaire() {
					tableListeBien =(DefaultTableModel) tableBiensImmobiliers.getModel();
					int counter=0;
					counter=tableListeBien.getRowCount();
					while(counter!=0) {
						tableListeBien.removeRow(0);
					    counter--;
					}
					
				}
				
				public void actualiserTableLocataire() {
					tableListeLocataire =(DefaultTableModel) tableListeLocataires.getModel();
					int counter=0;
					counter=tableListeLocataire.getRowCount();
					while(counter!=0) {
						tableListeLocataire.removeRow(0);
					    counter--;
					}
					
				}

				public void run() {
					setVisible(true);
					
				}
				
				
			  public void fermerFenetre() {
				   dispose();
			  }
			  
			  public void addQuiterListener(ActionListener actionListener) {
					// TODO Auto-generated method stub
					btnQuitter.addActionListener(actionListener);	
			  }

			  
			  
			  public void  colorerChampVide() {
					
				    if(textField_nom.getText().isEmpty()) {
					 
					    textField_nom.setBackground(Color.RED);
					  }else {
					    		 
					    		 textField_nom.setBackground(Color.WHITE); 
					 }
					    		
					  	    	
				    if(textField_prenom.getText().isEmpty()) {
				   	 
					    textField_prenom.setBackground(Color.RED);
					  }else {
					    		 
					    		 textField_prenom.setBackground(Color.WHITE); 
					 }
					    		
					  	    	
				    if(textField_email.getText().isEmpty()) {
				      	 
					    textField_email.setBackground(Color.RED);
					  }else {
					    		 
					    		 textField_email.setBackground(Color.WHITE); 
					 }  	
					 
					    
				    if(textField_telephone.getText().isEmpty()) {
				     	 
					    textField_telephone.setBackground(Color.RED);
					  }else {
					    		 
					    		 textField_telephone.setBackground(Color.WHITE); 
					 }  	
					 
				    
				    if(textField_matricule.getText().isEmpty()) {
				     	 
				    	textField_matricule.setBackground(Color.RED);
					  }else {
					    		 
						  textField_matricule.setBackground(Color.WHITE); 
					 }  
					
				}

				public void colorerBlanche() {
					textField_email.setBackground(Color.WHITE); 
					textField_telephone.setBackground(Color.WHITE); 
				    textField_prenom.setBackground(Color.WHITE); 
				    textField_nom.setBackground(Color.WHITE);
				    textField_matricule.setBackground(Color.WHITE);
				}

			
}
