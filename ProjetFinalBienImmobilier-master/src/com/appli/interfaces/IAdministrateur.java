package com.appli.interfaces;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import java.awt.Cursor;
import java.awt.event.ActionEvent;

public class IAdministrateur extends IPage {
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_utilisateur;
	private JButton btn_ajoutCompte;
	private JButton btn_modifierCompte;
	private JButton btn_supprimerCompte;
	private JButton btn_annulerCompte;
	private JButton btn_desactiverBien;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_bienImmobilier;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_typeLocation;
	private JTextArea textArea_details;
	private JButton btn_ajouterBienImmobilier;
	private JButton btn_annulerBienImmobilier;
	private JButton btn_modifierBienImmobilier;
	
	private static final long serialVersionUID = 1L;
	private JTextField textField_nom;
	private JTextField textField_prenom;
	private JTextField textField_telephone;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_sexe;
	private JTextField textField_email;
	@SuppressWarnings("rawtypes")
	private JComboBox textField_statut;
	private JTextField textField_adresseBien;
	private JTable tableListeGestionnaires;
	private JTable tableListeAdministrateurs;
	private JTable tableAjoutEtModifications;
	private JTable tableBiensActives;
	private JTable tableBiensDesactives;
	private JTable tableAjoutBienImmobilier;
	
	DefaultTableModel tableGestionnaire = new DefaultTableModel();
	DefaultTableModel tableAdmin = new DefaultTableModel();
	DefaultTableModel tableUser = new DefaultTableModel();
	DefaultTableModel tableBien = new DefaultTableModel();
	DefaultTableModel tableBienActif = new DefaultTableModel();
	DefaultTableModel tableBienDesactive = new DefaultTableModel();
	private JSpinner spinner_montant;
	private JSpinner  spinner_nombrePiece;
	private JDateChooser dateChooser;
	private JButton btn_activerBien;
	private JButton btnQuitter;
	@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
	public IAdministrateur() {

		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("Administrateur");
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setBounds(10, 101, 894, 453);
		getContentPane().add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Gestion des comptes", null, panel_1, null);
		panel_1.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(0, 0, 889, 425);
		panel_1.add(tabbedPane_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		tabbedPane_1.addTab("Liste des gestionnaires", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setToolTipText("Liste des gestionnaires");
		scrollPane_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scrollPane_5.setBounds(10, 11, 864, 375);
		panel_3.add(scrollPane_5);
		
		tableListeGestionnaires = new JTable();
		tableListeGestionnaires.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"NOM", "PRENOM", "NAISSANCE", "EMAIL", "TELEPHONE", "SEXE"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_5.setViewportView(tableListeGestionnaires);
		tableListeGestionnaires.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		tabbedPane_1.addTab("Liste des administrateurs", null, panel_4, null);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scrollPane_4.setToolTipText("Liste des Administrateurs");
		scrollPane_4.setBounds(10, 11, 864, 375);
		panel_4.add(scrollPane_4);
		
		tableListeAdministrateurs = new JTable();
		tableListeAdministrateurs.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"NOM", "PRENOM", "NAISSANCE", "EMAIL", "TELEPHONE", "SEXE"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_4.setViewportView(tableListeAdministrateurs);
		tableListeAdministrateurs.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		tabbedPane_1.addTab("Ajouts et modifications", null, panel_5, null);
		panel_5.setLayout(null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_9.setBounds(10, 11, 200, 375);
		panel_5.add(panel_9);
		panel_9.setLayout(null);
		
	    comboBox_utilisateur = new JComboBox();
	    comboBox_utilisateur.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    comboBox_utilisateur.setToolTipText("Selectionner le type d'utilisateur");
		comboBox_utilisateur.setFont(new Font("Tahoma", Font.PLAIN, 24));
		comboBox_utilisateur.setModel(new DefaultComboBoxModel(new String[] {"Gestionnaire", "Administrateur"}));
		comboBox_utilisateur.setBounds(10, 11, 180, 39);
		panel_9.add(comboBox_utilisateur);
		
		JLabel lblNewLabel = new JLabel("Nom :");
		lblNewLabel.setBounds(10, 64, 46, 14);
		panel_9.add(lblNewLabel);
		
		textField_nom = new JTextField();
		textField_nom.setToolTipText("Entrez le nom");
		textField_nom.setBounds(72, 61, 119, 20);
		panel_9.add(textField_nom);
		textField_nom.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Prenom :");
		lblNewLabel_1.setBounds(10, 103, 46, 14);
		panel_9.add(lblNewLabel_1);
		
		textField_prenom = new JTextField();
		textField_prenom.setToolTipText("Entrez le prenom");
		textField_prenom.setBounds(72, 100, 119, 20);
		panel_9.add(textField_prenom);
		textField_prenom.setColumns(10);
		
		textField_telephone = new JTextField();
		textField_telephone.setToolTipText("Entrez le num\u00E9ro de t\u00E9l\u00E9phone");
		textField_telephone.setColumns(10);
		textField_telephone.setBounds(71, 139, 119, 20);
		panel_9.add(textField_telephone);
		
		JLabel lblNewLabel_1_2 = new JLabel("Telephone :");
		lblNewLabel_1_2.setBounds(0, 139, 62, 14);
		panel_9.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("N\u00E9 le :");
		lblNewLabel_1_3.setBounds(10, 188, 46, 14);
		panel_9.add(lblNewLabel_1_3);
		
		comboBox_sexe = new JComboBox();
		comboBox_sexe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox_sexe.setToolTipText("Entrez le genre");
		comboBox_sexe.setModel(new DefaultComboBoxModel(new String[] {"Masculin", "Feminin"}));
		comboBox_sexe.setBounds(71, 224, 119, 20);
		panel_9.add(comboBox_sexe);
		
		JLabel lblNewLabel_1_4 = new JLabel("Sexe :");
		lblNewLabel_1_4.setBounds(10, 227, 46, 14);
		panel_9.add(lblNewLabel_1_4);
		
		textField_email = new JTextField();
		textField_email.setToolTipText("Entrez  adresse mail");
		textField_email.setColumns(10);
		textField_email.setBounds(71, 272, 119, 20);
		panel_9.add(textField_email);
		
		JLabel lblNewLabel_1_5 = new JLabel("Email :");
		lblNewLabel_1_5.setBounds(10, 275, 46, 14);
		panel_9.add(lblNewLabel_1_5);
		
		textField_statut = new JComboBox();
		textField_statut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		textField_statut.setToolTipText("S\u00E9lectionnez le statut");
		textField_statut.setModel(new DefaultComboBoxModel(new String[] {"Autorise", "Pas autorise"}));
		textField_statut.setBounds(72, 344, 119, 20);
		panel_9.add(textField_statut);
		
		JLabel lblNewLabel_1_6 = new JLabel("Statut :");
		lblNewLabel_1_6.setBounds(10, 347, 46, 14);
		panel_9.add(lblNewLabel_1_6);
		
	    dateChooser = new JDateChooser();
	    dateChooser.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    dateChooser.setToolTipText("Entrez la date de naissance");
		dateChooser.setBounds(72, 182, 119, 20);
		panel_9.add(dateChooser);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(255, 255, 255));
		panel_10.setBounds(220, 342, 654, 44);
		panel_5.add(panel_10);
		panel_10.setLayout(null);
		
	    btn_ajoutCompte = new JButton("Ajouter");
	    btn_ajoutCompte.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    	}
	    });
	    btn_ajoutCompte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btn_ajoutCompte.setToolTipText("Ajouter l'utilisateur");
		btn_ajoutCompte.setBounds(10, 11, 143, 23);
		panel_10.add(btn_ajoutCompte);
		
	    btn_modifierCompte = new JButton("Modifier");
	    btn_modifierCompte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btn_modifierCompte.setToolTipText("Modifier l'utilisateur");
		
		btn_modifierCompte.setBounds(163, 11, 143, 23);
		panel_10.add(btn_modifierCompte);
		
	    btn_supprimerCompte = new JButton("Supprimer");
	    btn_supprimerCompte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btn_supprimerCompte.setToolTipText("Supprimer l'utilisateur");
		btn_supprimerCompte.setBounds(348, 11, 143, 23);
		panel_10.add(btn_supprimerCompte);
		
	    btn_annulerCompte = new JButton("Annuler");
	    btn_annulerCompte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btn_annulerCompte.setToolTipText("Anuler l'action");
		btn_annulerCompte.setBounds(501, 11, 143, 23);
		panel_10.add(btn_annulerCompte);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scrollPane_3.setToolTipText("Liste des utilisateurs ");
		scrollPane_3.setBounds(220, 23, 654, 331);
		panel_5.add(scrollPane_3);
		
		tableAjoutEtModifications = new JTable();
		tableAjoutEtModifications.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NOM", "PRENOM", "NAISSANCE", "EMAIL", "TELEPHONE", "SEXE"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_3.setViewportView(tableAjoutEtModifications);
		tableAjoutEtModifications.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Gestion des biens immobiliers", null, panel_2, null);
		panel_2.setLayout(null);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setBounds(0, 11, 889, 414);
		panel_2.add(tabbedPane_2);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		tabbedPane_2.addTab("Biens activ\u00E9s", null, panel_6, null);
		panel_6.setLayout(null);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(767, 11, 11, 364);
		panel_6.add(separator_1);
		
	    btn_desactiverBien = new JButton("D\u00E9sactiver");
	    btn_desactiverBien.setToolTipText("D\u00E9sactiver le bien immobilier !");
		btn_desactiverBien.setBounds(778, 11, 96, 23);
		panel_6.add(btn_desactiverBien);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setToolTipText("Liste des biens activ\u00E9s");
		scrollPane_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scrollPane_2.setBounds(10, 11, 747, 364);
		panel_6.add(scrollPane_2);
		
		tableBiensActives = new JTable();
		tableBiensActives.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "ADDRESSE", "MONTANT LOYER", "Nb PIECES", "                DETAILS", "TYPE LOCATION", "TYPE IMMOBILIER"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableBiensActives.getColumnModel().getColumn(0).setPreferredWidth(26);
		tableBiensActives.getColumnModel().getColumn(2).setPreferredWidth(94);
		tableBiensActives.getColumnModel().getColumn(3).setPreferredWidth(61);
		tableBiensActives.getColumnModel().getColumn(4).setPreferredWidth(152);
		tableBiensActives.getColumnModel().getColumn(5).setPreferredWidth(105);
		tableBiensActives.getColumnModel().getColumn(6).setPreferredWidth(111);
		scrollPane_2.setViewportView(tableBiensActives);
		tableBiensActives.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 255, 255));
		tabbedPane_2.addTab("Biens d\u00E9sactiv\u00E9s", null, panel_7, null);
		panel_7.setLayout(null);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1.setBounds(767, 11, 11, 364);
		panel_7.add(separator_1_1);
		
	    btn_activerBien = new JButton("Activer");
	    btn_activerBien.setToolTipText("Activer le bien immobilier !");
		btn_activerBien.setBounds(777, 11, 97, 23);
		panel_7.add(btn_activerBien);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scrollPane_1.setToolTipText("Liste des biens d\u00E9sactiv\u00E9s");
		scrollPane_1.setBounds(10, 11, 747, 364);
		panel_7.add(scrollPane_1);
		
		tableBiensDesactives = new JTable();
		tableBiensDesactives.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "ADDRESSE", "MONTANT", "Nb PIECES", "              DETAILS", "TYPE LOCATION", "TYPE IMMOBILIER"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableBiensDesactives.getColumnModel().getColumn(0).setPreferredWidth(53);
		tableBiensDesactives.getColumnModel().getColumn(1).setPreferredWidth(80);
		tableBiensDesactives.getColumnModel().getColumn(3).setPreferredWidth(62);
		tableBiensDesactives.getColumnModel().getColumn(4).setPreferredWidth(162);
		tableBiensDesactives.getColumnModel().getColumn(5).setPreferredWidth(90);
		tableBiensDesactives.getColumnModel().getColumn(6).setPreferredWidth(99);
		scrollPane_1.setViewportView(tableBiensDesactives);
		tableBiensDesactives.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 255, 255));
		tabbedPane_2.addTab("Ajout", null, panel_8, null);
		panel_8.setLayout(null);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		panel_11.setBounds(10, 11, 220, 364);
		panel_8.add(panel_11);
		panel_11.setLayout(null);
		
		textField_adresseBien = new JTextField();
		textField_adresseBien.setToolTipText("Entrez l'adresse du bien immobilier");
		textField_adresseBien.setBounds(66, 11, 144, 20);
		panel_11.add(textField_adresseBien);
		textField_adresseBien.setColumns(10);
		
		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setBounds(10, 14, 46, 14);
		panel_11.add(lblAdresse);
		
	    spinner_montant = new JSpinner();
	    spinner_montant.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    spinner_montant.setToolTipText("Entrez le montant de la location du bien imobilier !");
		spinner_montant.setModel(new SpinnerNumberModel(new Integer(5), new Integer(5), null, new Integer(5)));
		spinner_montant.setBounds(66, 42, 144, 20);
		panel_11.add(spinner_montant);
		
		JLabel lblMontant = new JLabel("Montant :");
		lblMontant.setBounds(10, 45, 60, 14);
		panel_11.add(lblMontant);
		
	    spinner_nombrePiece = new JSpinner();
	    spinner_nombrePiece.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    spinner_nombrePiece.setToolTipText("Entrez le nombre de pi\u00E8ces du bien immobilier !");
		spinner_nombrePiece.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_nombrePiece.setBounds(106, 73, 104, 20);
		panel_11.add(spinner_nombrePiece);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre de pi\u00E8ces :");
		lblNewLabel_2.setBounds(10, 76, 104, 14);
		panel_11.add(lblNewLabel_2);
		
	    comboBox_bienImmobilier = new JComboBox();
	    comboBox_bienImmobilier.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    comboBox_bienImmobilier.setToolTipText("S\u00E9lectionnez le type de bien immobilier !");
		comboBox_bienImmobilier.setModel(new DefaultComboBoxModel(new String[] {"Appartement", "Villa", "Studio"}));
		comboBox_bienImmobilier.setBounds(10, 122, 200, 20);
		panel_11.add(comboBox_bienImmobilier);
		
	    comboBox_typeLocation = new JComboBox();
	    comboBox_typeLocation.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    comboBox_typeLocation.setToolTipText("S\u00E9lectionnez le type de location !");
		comboBox_typeLocation.setModel(new DefaultComboBoxModel(new String[] {"Mensuelle", "Journali\u00E8re"}));
		comboBox_typeLocation.setBounds(10, 153, 200, 20);
		panel_11.add(comboBox_typeLocation);
		
	    textArea_details = new JTextArea();
	    textArea_details.setToolTipText("Entrez les d\u00E9tails concernant le bien immobilier !");
		textArea_details.setBorder(new LineBorder(Color.LIGHT_GRAY));
		textArea_details.setBounds(10, 219, 200, 134);
		panel_11.add(textArea_details);
		
		JLabel lblDtails = new JLabel("D\u00E9tails");
		lblDtails.setBounds(10, 194, 46, 14);
		panel_11.add(lblDtails);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(255, 255, 255));
		panel_12.setBounds(240, 333, 634, 42);
		panel_8.add(panel_12);
		panel_12.setLayout(null);
		
	    btn_ajouterBienImmobilier = new JButton("Ajouter");
	    btn_ajouterBienImmobilier.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btn_ajouterBienImmobilier.setToolTipText("Ajouter bien immobilier !");
		btn_ajouterBienImmobilier.setBounds(10, 11, 159, 27);
		panel_12.add(btn_ajouterBienImmobilier);
		
	    btn_annulerBienImmobilier = new JButton("Annuler");
	    btn_annulerBienImmobilier.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btn_annulerBienImmobilier.setToolTipText("Annuler action !");
		btn_annulerBienImmobilier.setBounds(465, 11, 159, 27);
		panel_12.add(btn_annulerBienImmobilier);
		
	    btn_modifierBienImmobilier = new JButton("Modifier");
	    btn_modifierBienImmobilier.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btn_modifierBienImmobilier.setToolTipText("Modifier bien immobilier !");
		btn_modifierBienImmobilier.setBounds(240, 11, 159, 27);
		panel_12.add(btn_modifierBienImmobilier);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scrollPane.setToolTipText("Liste des bien immobiliers !");
		scrollPane.setBounds(240, 11, 634, 322);
		panel_8.add(scrollPane);
		
		tableAjoutBienImmobilier = new JTable();
		tableAjoutBienImmobilier.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "  ADDRESSE", "   MONTANT", "  Nb PIECES", "      DESCRIPTION", " TYPE LOCATION", "TYPE IMMOBILIER"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, Object.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableAjoutBienImmobilier.getColumnModel().getColumn(4).setPreferredWidth(126);
		tableAjoutBienImmobilier.getColumnModel().getColumn(4).setMinWidth(61);
		tableAjoutBienImmobilier.getColumnModel().getColumn(5).setPreferredWidth(97);
		tableAjoutBienImmobilier.getColumnModel().getColumn(6).setPreferredWidth(100);
		scrollPane.setViewportView(tableAjoutBienImmobilier);
		tableAjoutBienImmobilier.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(10, 565, 161, 41);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAdministrateur = new JLabel("Administrateur");
		lblAdministrateur.setToolTipText("Vous \u00EAtes un administrateur !");
		lblAdministrateur.setBounds(0, 0, 164, 41);
		panel.add(lblAdministrateur);
		lblAdministrateur.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAdministrateur.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdministrateur.setForeground(Color.BLACK);
		lblAdministrateur.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
	    btnQuitter = new JButton("Quitter");
		btnQuitter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQuitter.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnQuitter.setBounds(792, 565, 112, 41);
		getContentPane().add(btnQuitter);
	}

//  ******************************************** element comptes *********************************	//
	
	//setters
public void setNom(String nom) {
	textField_nom.setText(nom);
}
	
public void setPrenom(String prenom) {
	textField_prenom.setText(prenom);
}


public void setEmail(String email) {
	textField_email.setText(email);
}

public void setTelephone(String phone) {
	 textField_telephone.setText(phone);
}

public void setSexe(int sexe) {
	comboBox_sexe.setSelectedIndex(sexe);
}
          
public void setUserType(String user) {
	comboBox_utilisateur.setToolTipText(user);
}

public void setDateNaissance(Date user) {
	dateChooser.setDate(user);
}

               //getters
public String getNom() {
	return textField_nom.getText();
}

public String getPrenom() {
	return textField_prenom.getText();
}

public String getEmail() {
	return textField_email.getText();
}
public String getTelephone() {
	return textField_telephone.getText();
}
public String getSexe() {
	return comboBox_sexe.getSelectedItem().toString();
}

public String getDateNaissance() {

	return ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
	
}
public String getUtilisateur() {
	return comboBox_utilisateur.getSelectedItem().toString();
}

public int getUtilisateurId() {
	return comboBox_utilisateur.getSelectedIndex();
}
//listeners user
public void addCreerCompteListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		btn_ajoutCompte.addActionListener(actionListener);	
	}
public void addModifierCompteListener(ActionListener actionListener) {
	// TODO Auto-generated method stub
	btn_modifierCompte.addActionListener(actionListener);	
}

public void addSupprimerCompteListener(ActionListener actionListener) {
	// TODO Auto-generated method stub
	btn_supprimerCompte.addActionListener(actionListener);	
}

public void addAnnulerCompteListener(ActionListener actionListener) {
	// TODO Auto-generated method stub
	btn_annulerCompte.addActionListener(actionListener);	
}

public void addTableGereCompteMousseListener(MouseAdapter mousseListener) {
	tableAjoutEtModifications.addMouseListener(mousseListener);
}

public void addTableListeUserMousseListener(ActionListener mousseListener) {
	comboBox_utilisateur.addActionListener(mousseListener);
}

public int selectRowTableUser() {
	// TODO Auto-generated method stub
	return tableAjoutEtModifications.getSelectedRow();
}



public void  addRowUser(String[] line) {
	tableUser =(DefaultTableModel) tableAjoutEtModifications.getModel();
	tableUser.addRow(line);
}
public void  addRowAdmin(String[] line) {
	tableAdmin =(DefaultTableModel) tableListeAdministrateurs.getModel();
	tableAdmin.addRow(line);
}

public void  addRowGestionnaire(String[] line) {
	tableGestionnaire =(DefaultTableModel) tableListeGestionnaires.getModel();
	tableGestionnaire.addRow(line);
}

 //valeur champ colonne de user
public String tableUserCol1() {
	tableUser =(DefaultTableModel) tableAjoutEtModifications.getModel();
	return (String) tableUser.getValueAt(selectRowTableUser(), 0);
}
public String tableUserCol2() {
	tableUser =(DefaultTableModel) tableAjoutEtModifications.getModel();
	return (String) tableUser.getValueAt(selectRowTableUser(), 1);
}

public String tableUserCol3() {
	tableUser =(DefaultTableModel) tableAjoutEtModifications.getModel();
	return (String) tableUser.getValueAt(selectRowTableUser(), 2);
}
public String tableUserCol4() {
	tableUser =(DefaultTableModel) tableAjoutEtModifications.getModel();
	return (String) tableUser.getValueAt(selectRowTableUser(), 3);
}

public String tableUserCol5() {
	tableUser =(DefaultTableModel) tableAjoutEtModifications.getModel();
	return (String) tableUser.getValueAt(selectRowTableUser(), 4);
}
public String tableUserCol6() {
	tableUser =(DefaultTableModel) tableAjoutEtModifications.getModel();
	return (String) tableUser.getValueAt(selectRowTableUser(), 5);
}
public String tableUserCol7() {
	tableUser =(DefaultTableModel) tableAjoutEtModifications.getModel();
	return (String) tableUser.getValueAt(selectRowTableUser(), 6);
}

public void actualiserTableUser() {
	tableUser =(DefaultTableModel) tableAjoutEtModifications.getModel();
	int counter=0;
	counter=tableUser.getRowCount();
	while(counter!=0) {
		tableUser.removeRow(0);
	    counter--;
	}
}


//********************************element bien immobilier**********************************//
public void setAddresseBien(String value) {
	textField_adresseBien.setText(value);
}

public void setLoyer(double value) {
	spinner_montant.setValue(value);
}
public void setNbPiece(int nb) {
	spinner_nombrePiece.setValue(nb);
}
public void setDetailBien(String value) {
	textArea_details.setText(value);
}
public String getAddresseBien() {
	return textField_adresseBien.getText();
}


public double getLoyer() {
	return Double.parseDouble(spinner_montant.getValue().toString());
}
public String getDetailBien() {
	return textArea_details.getText();
}

public String getTypeBien() {
	return comboBox_bienImmobilier.getSelectedItem().toString();
}

public int getNbPiece() {
	return Integer.parseInt(spinner_nombrePiece.getValue().toString());
}

public String getTypeLocation() {
	return comboBox_typeLocation.getSelectedItem().toString();
}


public void addCreerBienListener(ActionListener actionListener) {
	// TODO Auto-generated method stub
	btn_ajouterBienImmobilier.addActionListener(actionListener);	
}
public void addModifierBienListener(ActionListener actionListener) {
// TODO Auto-generated method stub
     btn_modifierBienImmobilier.addActionListener(actionListener);	
}

public void addDesactiverBienListener(ActionListener actionListener) {
// TODO Auto-generated method stub
     btn_desactiverBien.addActionListener(actionListener);	
}

public void addActiverBienListener(ActionListener actionListener) {
	
	     btn_activerBien.addActionListener(actionListener);	
	}

public void addAnnulerBienListener(ActionListener actionListener) {
// TODO Auto-generated method stub
	btn_annulerBienImmobilier.addActionListener(actionListener);	
}

public void addTableGereBienMousseListener(MouseAdapter mousseListener) {
	tableAjoutBienImmobilier.addMouseListener(mousseListener);
}

public void addTableGereBienActifMousseListener(MouseAdapter mousseListener) {
	tableBiensActives.addMouseListener(mousseListener);
}

public void addTableGereBienDesactiveMousseListener(MouseAdapter mousseListener) {
	tableBiensDesactives.addMouseListener(mousseListener);
}

public int selectRowTableBien() {
	// TODO Auto-generated method stub
	return tableAjoutBienImmobilier.getSelectedRow();
}


public int selectRowTableBienActive() {
	// TODO Auto-generated method stub
	return tableBiensActives.getSelectedRow();
}

public int selectRowTableBiendesactive() {
	// TODO Auto-generated method stub
	return tableBiensDesactives.getSelectedRow();
}

public void  addRowBien(String[] line) {
	tableBien =(DefaultTableModel) tableAjoutBienImmobilier.getModel();
	tableBien.addRow(line);
}

public void  addRowBienActif(String[] line) {
	tableBienActif =(DefaultTableModel) tableBiensActives.getModel();
	tableBienActif.addRow(line);
}

public void  addRowBienDesactive(String[] line) {
	tableBienDesactive =(DefaultTableModel) tableBiensDesactives.getModel();
	tableBienDesactive.addRow(line);
}

// bien actif
public String tableBienActifCol1() {
	tableBienActif =(DefaultTableModel) tableBiensActives.getModel();
	return (String) tableBienActif.getValueAt(selectRowTableBienActive(), 0);
}
public String tableBienActifCol2() {
	tableBienActif =(DefaultTableModel) tableBiensActives.getModel();
	return (String) tableBienActif.getValueAt(selectRowTableBienActive(), 1);
}

public String tableBienActifCol3() {
	tableBienActif =(DefaultTableModel) tableBiensActives.getModel();
	return (String) tableBienActif.getValueAt(selectRowTableBienActive(), 2);
}

public String tableBienActifCol4() {
	tableBienActif =(DefaultTableModel) tableBiensActives.getModel();
	return (String) tableBienActif.getValueAt(selectRowTableBienActive(), 3);
}

public String tableBienActifCol5() {
	tableBienActif =(DefaultTableModel) tableBiensActives.getModel();
	return (String) tableBienActif.getValueAt(selectRowTableBienActive(), 4);
}

public String tableBienActifCol6() {
	tableBienActif =(DefaultTableModel) tableBiensActives.getModel();
	return (String) tableBienActif.getValueAt(selectRowTableBienActive(), 5);
}

public String tableBienActifCol7() {
	tableBienActif =(DefaultTableModel) tableBiensActives.getModel();
	return (String) tableBienActif.getValueAt(selectRowTableBienActive(), 6);
}
//bien desactive

public String tableBienDesactiveCol1() {
	tableBienDesactive =(DefaultTableModel) tableBiensDesactives.getModel();
	return (String) tableBienDesactive.getValueAt(selectRowTableBiendesactive(), 0);
}
public String tableBienDesactiveCol2() {
	tableBienDesactive =(DefaultTableModel) tableBiensDesactives.getModel();
	return (String) tableBienDesactive.getValueAt(selectRowTableBiendesactive(), 1);
}

public String tableBienDesactiveCol3() {
	tableBienDesactive =(DefaultTableModel) tableBiensDesactives.getModel();
	return (String) tableBienDesactive.getValueAt(selectRowTableBiendesactive(), 2);
}

public String tableBienDesactiveCol4() {
	tableBienDesactive =(DefaultTableModel) tableBiensDesactives.getModel();
	return (String) tableBienDesactive.getValueAt(selectRowTableBiendesactive(), 3);
}

public String tableBienDesactiveCol5() {
	tableBienDesactive =(DefaultTableModel) tableBiensDesactives.getModel();
	return (String) tableBienDesactive.getValueAt(selectRowTableBiendesactive(), 4);
}

public String tableBienDesactiveCol6() {
	tableBienDesactive =(DefaultTableModel) tableBiensDesactives.getModel();
	return (String) tableBienDesactive.getValueAt(selectRowTableBiendesactive(), 5);
}

public String tableBienDesactiveCol7() {
	tableBienDesactive =(DefaultTableModel) tableBiensDesactives.getModel();
	return (String) tableBienDesactive.getValueAt(selectRowTableBiendesactive(), 6);
}



//bien modif 
public String tableBienCol1() {
	tableBien =(DefaultTableModel) tableAjoutBienImmobilier.getModel();
	return (String) tableBien.getValueAt(selectRowTableBien(), 0);
}
public String tableBienCol2() {
	tableBien =(DefaultTableModel) tableAjoutBienImmobilier.getModel();
	return (String) tableBien.getValueAt(selectRowTableBien(), 1);
}

public String tableBienCol3() {
	tableBien =(DefaultTableModel) tableAjoutBienImmobilier.getModel();
	return (String) tableBien.getValueAt(selectRowTableBien(), 2);
}

public String tableBienCol4() {
	tableBien =(DefaultTableModel) tableAjoutBienImmobilier.getModel();
	return (String) tableBien.getValueAt(selectRowTableBien(), 3);
}

public String tableBienCol5() {
	tableBien =(DefaultTableModel) tableAjoutBienImmobilier.getModel();
	return (String) tableBien.getValueAt(selectRowTableBien(), 4);
}

public String tableBienCol6() {
	tableBien =(DefaultTableModel) tableAjoutBienImmobilier.getModel();
	return (String) tableBien.getValueAt(selectRowTableBien(), 5);
}

public String tableBienCol7() {
	tableBien =(DefaultTableModel) tableAjoutBienImmobilier.getModel();
	return (String) tableBien.getValueAt(selectRowTableBien(), 6);
}

public void actualiserTableBien() {
	tableBien =(DefaultTableModel) tableAjoutBienImmobilier.getModel();
	int counter=0;
	counter=tableBien.getRowCount();
	while(counter!=0) {
		tableBien.removeRow(0);
	    counter--;
	}
}

public void actualiserTableBienActif() {
	tableBienActif =(DefaultTableModel) tableBiensActives.getModel();
	int counter=0;
	counter=tableBienActif.getRowCount();
	while(counter!=0) {
		tableBienActif.removeRow(0);
	    counter--;
	}
}

public void actualiserTableBienDesactive() {
	tableBienDesactive =(DefaultTableModel) tableBiensDesactives.getModel();
	int counter=0;
	counter=tableBienDesactive.getRowCount();
	while(counter!=0) {
		tableBienDesactive.removeRow(0);
	    counter--;
	}
}



//lancer la fenetre
public void run() {
	setVisible(true);
	
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



public void fermerFenetre() {
	dispose();
}


public void addQuiterListener(ActionListener actionListener) {
	// TODO Auto-generated method stub
	btnQuitter.addActionListener(actionListener);	
}

public void  colorerChampVideBien() {
	
    if(textField_adresseBien.getText().isEmpty()) {
	 
    	textField_adresseBien.setBackground(Color.RED);
	  }else {
	    		 
		  textField_adresseBien.setBackground(Color.WHITE); 
	 }
    
    
    if(textArea_details.getText().isEmpty()) {
   	 
    	textArea_details.setBackground(Color.RED);
	  }else {
	    		 
		  textArea_details.setBackground(Color.WHITE); 
	 }
    
}


public void colorerBlancheBI() {
	textArea_details.setBackground(Color.WHITE); 
	textField_adresseBien.setBackground(Color.WHITE); 
    
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
	 
	
}

public void colorerBlanche() {
	textField_email.setBackground(Color.WHITE); 
	textField_telephone.setBackground(Color.WHITE); 
    textField_prenom.setBackground(Color.WHITE); 
    textField_nom.setBackground(Color.WHITE);
	
}


public int tailleCompteTableCompte() {
	
int nbr=tableAjoutEtModifications.getRowCount();
	
	return nbr;
}


public int tailleCompteTableBienActive() {
	
int nbr=tableBienActif.getRowCount();
	
	return nbr;
}




public int tailleCompteTableDesActive() {
	
int nbr=tableBienDesactive.getRowCount();
	
	return nbr;
}


}

	
	
	
