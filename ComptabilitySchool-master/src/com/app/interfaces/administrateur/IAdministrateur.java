package com.app.interfaces.administrateur;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.app.interfaces.comptable.IComptabilite;

@SuppressWarnings("serial")
public class IAdministrateur extends JFrame {
	private JPanel panel_Surveillance;
	private JPanel panel_CRUD_Comptes;
	private JLayeredPane layeredPane;
	private JTabbedPane tabbedPane_CRUD_Compte;
	private JPanel panel_Eleves;
	private JPanel panel_Professeurs;
	private JPanel panel_Employers;
	private JPanel panel_Comptables;
	private JPanel panel_Administrateurs;
	private JLabel lbl_info_compte;
	private JLabel lblSurveillanceAdministrateur;
	private JTabbedPane tabbedPane_Surveillance;
	private JPanel panel_Depense;
	private JPanel panel_PaiementsScolarite;
	private JPanel panel_PaiementProfesseurs;
	private JPanel panel_PaiementsEmployers;
	private JPanel panel_FraisDeScolarite;
	private JPanel panel_VersementBancaires;
	private JTable table_ListeDepense;
	private JTable table_ListePaiementScolarite;
	private JTable table_ListePaiementProfesseur;
	private JTable table_ListePaiementEmployer;
	private JTable table_FraisDeScolarite;
	private JTable table_ListeVersement;
	private JTable table_ListeClasse;
	private JTable table_ListeMatiere;
	private JTextField textField_NomMatiere;
	private JTextField textField_NomClasse;
	@SuppressWarnings("rawtypes")
	private JComboBox textField_AnneeScolaire;
	private JTextField textField_RechercheProfesseur;
	private JTable table_ListeProfesseur;
	private JTextField textField_RechercheEmployer;
	private JTable table_ListeEmployer;
	private JTable table_ListeComptable;
	private JTable table_ListeAdministrateur;
	private JTextField textField_RechercheEleve;
	private JTable table_ListeEleve;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_TrierEleve;
	private JButton btnCreer_Eleve;
	private JButton btnModifier_Eleve;
	private JButton btnSupprimer_Eleve;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_TrierProfesseur;
	private JButton btnCreer_Professeur;
	private JButton btnCreer_Professeur_1;
	private JButton btnModifier_Professeur;
	private JButton btnModifier_Professeur_1;
	private JButton btnSupprimer_Professeur;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_TrierEmployer;
	private JButton btnCreer_Employer;
	private JButton btnCreer_Employer_1;
	private JButton btnModifier_Employer;
	private JButton btnModifier_Employer_1;
	private JButton btnSupprimer_Employer;
	private JButton btnCreer_Comptable;
	private JButton btnCreer_Comptable_1;
	private JButton btnModifier_Comptable;
	private JButton btnModifier_Comptable_1;
	private JButton btnSupprimer_Comptable;
	private JButton btnCreer_Administrateur;
	private JButton btnCreer_Administrateur_1;
	private JButton btnModifier_Administrateur;
	private JButton btnModifier_Administrateur_1;
	private JButton btnSupprimer_Administrateur;
	private JButton btn_AjouterClasse;
	private JButton btn_ModifierClasse;
	private JButton btn_SupprimerClasse;
	private JSpinner spinner_PrixHeureMatiere;
	private JButton btn_AjouterMatiere;
	private JButton btn_ModifierMatiere;
	private JButton btn_SupprimerMatiere;
	
	//boutons principeaux
	private JButton btnGestionsDesComptes;
	private JButton btnSurveillance;
	
	DefaultTableModel tDepense = new DefaultTableModel();
	
	DefaultTableModel tPaiementScolarite = new DefaultTableModel();
	DefaultTableModel tPaiementProfesseur = new DefaultTableModel();
	DefaultTableModel tPaiementEmployer = new DefaultTableModel();
	DefaultTableModel tComptable = new DefaultTableModel();
	DefaultTableModel tVersement = new DefaultTableModel();
	DefaultTableModel tClasse = new DefaultTableModel();
	DefaultTableModel tMatiere = new DefaultTableModel();
	DefaultTableModel tEmployer = new DefaultTableModel();
	DefaultTableModel tAdministrateur = new DefaultTableModel();
	DefaultTableModel tProfesseur = new DefaultTableModel();
	DefaultTableModel tEleve = new DefaultTableModel();
	DefaultTableModel tFraisScolarite = new DefaultTableModel();
	private JButton btnDetailEleve;
	private JLabel message;
	private JButton btn_lancerTrierPar_FraisInscription;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_TrierPar_FraisInscription;
	private JButton btn_lancerTrierPar_PaiementEmployer;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_TrierPar_PaiementEmployer;
	private JButton btn_lancerTrierPar_PaiementProfesseur;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_TrierPar_PAiementProfesseur;
	private JButton btn_lancerTrierPar_PaiementScolarite;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_TrierPar_PaiementScolarite;
	private JTextField textField_TotalPaiementScolarite;
	private JTextField textField_TotalPaiementProfesseur;
	private JTextField textField_TotalPaiementEmployer;
	private JTextField textField_TotalFraisInscription;
	private JTextField textField_TotalVersement;
	private JTextField textField_TotalDepense;
	private JMenuItem btnDeconection;
	private JMenuItem btnModifierCompte;
	private JMenu mnNewMenu;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public IAdministrateur() {
		setTitle("Administrateur");
		getContentPane().setBackground(new Color(222, 184, 135));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(1124, 720));
		
		layeredPane = new JLayeredPane();
		layeredPane.setBorder(new LineBorder(Color.DARK_GRAY));
		
		JLabel lblcopyrightsSonagroupSarl = new JLabel("  SONA-Group \u00A9 2020");
		lblcopyrightsSonagroupSarl.setBorder(new LineBorder(Color.DARK_GRAY));
		lblcopyrightsSonagroupSarl.setBackground(Color.LIGHT_GRAY);
		
		btnGestionsDesComptes = new JButton("Gestions des comptes ");
		btnGestionsDesComptes.setIcon(new ImageIcon(IComptabilite.class.getResource("/account.png")));

		btnGestionsDesComptes.setBackground(new Color(240,240,240));

	

		btnGestionsDesComptes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSurveillance.setBackground(new Color(205, 133, 63));
				btnGestionsDesComptes.setBackground(new Color(240,240,240 ));
					switchPanel(panel_CRUD_Comptes);
				
			}
		});
		
		btnSurveillance = new JButton("Surveillance");
		btnSurveillance.setIcon(new ImageIcon(IComptabilite.class.getResource("/research.png")));

		btnSurveillance.setBackground(new Color(205, 133, 63));

		btnSurveillance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnGestionsDesComptes.setBackground(new Color(205, 133, 63));
				btnSurveillance.setBackground(new Color(240,240,240));
				switchPanel(panel_Surveillance);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblcopyrightsSonagroupSarl, GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnGestionsDesComptes, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnSurveillance, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(512, Short.MAX_VALUE))
				.addComponent(layeredPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnGestionsDesComptes, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSurveillance, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblcopyrightsSonagroupSarl, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
		);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panel_CRUD_Comptes = new JPanel();
		panel_CRUD_Comptes.setBackground(new Color(222, 184, 135));
		layeredPane.add(panel_CRUD_Comptes, "name_88212864123920");
		
		tabbedPane_CRUD_Compte = new JTabbedPane(JTabbedPane.TOP);
		
		lbl_info_compte = new JLabel("");
		lbl_info_compte.setBorder(new LineBorder(new Color(160, 82, 45), 1, true));
		lbl_info_compte.setFont(new Font("Eras Medium ITC", Font.PLAIN, 11));
		
		message = new JLabel("");
		message.setFont(new Font("Tahoma", Font.BOLD, 13));
		message.setHorizontalAlignment(SwingConstants.RIGHT);
		GroupLayout gl_panel_CRUD_Comptes = new GroupLayout(panel_CRUD_Comptes);
		gl_panel_CRUD_Comptes.setHorizontalGroup(
			gl_panel_CRUD_Comptes.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_CRUD_Comptes.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_CRUD_Comptes.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_info_compte, GroupLayout.DEFAULT_SIZE, 1086, Short.MAX_VALUE)
						.addComponent(tabbedPane_CRUD_Compte, GroupLayout.DEFAULT_SIZE, 1086, Short.MAX_VALUE)
						.addComponent(message, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1086, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_CRUD_Comptes.setVerticalGroup(
			gl_panel_CRUD_Comptes.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_CRUD_Comptes.createSequentialGroup()
					.addContainerGap()
					.addComponent(lbl_info_compte)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(message)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tabbedPane_CRUD_Compte, GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		panel_Eleves = new JPanel();
		panel_Eleves.setBackground(new Color(222, 184, 135));
		tabbedPane_CRUD_Compte.addTab("Eleves", null, panel_Eleves, null);
		
		JLabel lblNewLabel_1_3_1_4 = new JLabel("Recherche : ");
		
		textField_RechercheEleve = new JTextField();
		textField_RechercheEleve.setColumns(10);
		
		JLabel lblNewLabel_2_3_1_4 = new JLabel("Trier par : ");
		
		comboBox_TrierEleve = new JComboBox();
		
		btnCreer_Eleve = new JButton("Creer");
		btnCreer_Eleve.setIcon(new ImageIcon(IComptabilite.class.getResource("/add-user.png")));
		btnCreer_Eleve.setBackground(new Color(205, 133, 63));
		
		btnModifier_Eleve = new JButton("Modifier");
		btnModifier_Eleve.setIcon(new ImageIcon(IComptabilite.class.getResource("/pencil2.png")));
		btnModifier_Eleve.setBackground(new Color(205, 133, 63));
		
		btnSupprimer_Eleve = new JButton("Supprimer");
		btnSupprimer_Eleve.setIcon(new ImageIcon(IComptabilite.class.getResource("/delete.png")));
		btnSupprimer_Eleve.setBackground(new Color(205, 133, 63));

//		btnCreer_Eleve.setBackground(new Color(205, 133, 63));
		
//		btnModifier_Eleve = new JButton("Modifier");
//		btnModifier_Eleve.setBackground(new Color(205, 133, 63));
		
//		btnSupprimer_Eleve = new JButton("Supprimer");
//		btnSupprimer_Eleve.setBackground(new Color(205, 133, 63));

		
		JScrollPane scrollPane_8_4 = new JScrollPane();
		
		btnDetailEleve = new JButton("D\u00E9tails");
		btnDetailEleve.setIcon(new ImageIcon(IComptabilite.class.getResource("/information.png")));
		btnDetailEleve.setBackground(new Color(205, 133, 63));

		GroupLayout gl_panel_Eleves = new GroupLayout(panel_Eleves);
		gl_panel_Eleves.setHorizontalGroup(
			gl_panel_Eleves.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Eleves.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1_3_1_4, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textField_RechercheEleve, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblNewLabel_2_3_1_4, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(comboBox_TrierEleve, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
					.addComponent(btnDetailEleve, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCreer_Eleve, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnModifier_Eleve, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSupprimer_Eleve, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addGap(15))
				.addComponent(scrollPane_8_4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1081, Short.MAX_VALUE)
		);
		gl_panel_Eleves.setVerticalGroup(
			gl_panel_Eleves.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Eleves.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_Eleves.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_Eleves.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1_3_1_4))
						.addComponent(textField_RechercheEleve, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_Eleves.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_2_3_1_4))
						.addComponent(comboBox_TrierEleve, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_Eleves.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnDetailEleve)
							.addComponent(btnCreer_Eleve))
						.addComponent(btnModifier_Eleve)
						.addComponent(btnSupprimer_Eleve))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane_8_4, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))
		);
		
		table_ListeEleve = new JTable();
		table_ListeEleve.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table_ListeEleve.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"", "Matricule", "Nom", "Prenom", "Classe", "Genre", "Telephone" ,"Statut"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_8_4.setViewportView(table_ListeEleve);
		panel_Eleves.setLayout(gl_panel_Eleves);
		
		panel_Professeurs = new JPanel();
		panel_Professeurs.setBackground(new Color(222, 184, 135));
		tabbedPane_CRUD_Compte.addTab("Professeurs", null, panel_Professeurs, null);
		
		btnSupprimer_Professeur = new JButton("Supprimer");
		btnSupprimer_Professeur.setIcon(new ImageIcon(IComptabilite.class.getResource("/delete.png")));
		btnSupprimer_Professeur.setBackground(new Color(205, 133, 63));
		
		btnModifier_Professeur = new JButton("Modifier");
		btnModifier_Professeur.setIcon(new ImageIcon(IComptabilite.class.getResource("/pencil2.png")));
		btnModifier_Professeur.setBackground(new Color(205, 133, 63));
		
		btnCreer_Professeur = new JButton("Creer");
		btnCreer_Professeur.setIcon(new ImageIcon(IComptabilite.class.getResource("/add-user.png")));
		btnCreer_Professeur.setBackground(new Color(205, 133, 63));

		btnSupprimer_Professeur.setBackground(new Color(205, 133, 63));
		
		btnModifier_Professeur_1 = new JButton("Modifier");
		btnModifier_Professeur_1.setIcon(new ImageIcon(IComptabilite.class.getResource("/pencil2.png")));
		btnModifier_Professeur_1.setBackground(new Color(205, 133, 63));
		
		btnCreer_Professeur_1 = new JButton("Creer");
		btnCreer_Professeur_1.setIcon(new ImageIcon(IComptabilite.class.getResource("/add-user.png")));
		btnCreer_Professeur_1.setBackground(new Color(205, 133, 63));

		
		comboBox_TrierProfesseur = new JComboBox();
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Trier par : ");
		
		textField_RechercheProfesseur = new JTextField();
		textField_RechercheProfesseur.setColumns(10);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Recherche : ");
		
		JScrollPane scrollPane_8 = new JScrollPane();
		GroupLayout gl_panel_Professeurs = new GroupLayout(panel_Professeurs);
		gl_panel_Professeurs.setHorizontalGroup(
			gl_panel_Professeurs.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Professeurs.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1_3_1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textField_RechercheProfesseur, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblNewLabel_2_3_1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(comboBox_TrierProfesseur, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 320, Short.MAX_VALUE)
					.addComponent(btnCreer_Professeur_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnModifier_Professeur_1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSupprimer_Professeur, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addGap(15))
				.addComponent(scrollPane_8, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1081, Short.MAX_VALUE)
		);
		gl_panel_Professeurs.setVerticalGroup(
			gl_panel_Professeurs.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Professeurs.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_Professeurs.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_Professeurs.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1_3_1))
						.addComponent(textField_RechercheProfesseur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_Professeurs.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_2_3_1))
						.addComponent(comboBox_TrierProfesseur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_Professeurs.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnModifier_Professeur_1)
							.addComponent(btnCreer_Professeur_1))
						.addComponent(btnSupprimer_Professeur))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane_8, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))
		);
		
		table_ListeProfesseur = new JTable();
		table_ListeProfesseur.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table_ListeProfesseur.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"","Matricule", "Nom", "Prenom", "Genre", "Type", "Classe", "Matiere", "Telephone", "Email", "Experience", "Salaire", "Adresse", "N\u00B0 carte d'identite", "Date recrutement", "Date arret"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class,String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_8.setViewportView(table_ListeProfesseur);
		panel_Professeurs.setLayout(gl_panel_Professeurs);
		
		panel_Employers = new JPanel();
		panel_Employers.setBackground(new Color(222, 184, 135));
		tabbedPane_CRUD_Compte.addTab("Employers", null, panel_Employers, null);
		
		btnSupprimer_Employer = new JButton("Supprimer");
		btnSupprimer_Employer.setIcon(new ImageIcon(IComptabilite.class.getResource("/delete.png")));

		btnSupprimer_Employer.setBackground(new Color(205, 133, 63));
		
		btnModifier_Employer = new JButton("Modifier");
		btnModifier_Employer.setIcon(new ImageIcon(IComptabilite.class.getResource("/pencil2.png")));
		btnModifier_Employer.setBackground(new Color(205, 133, 63));
		
		btnCreer_Employer = new JButton("Creer");
		btnCreer_Employer.setIcon(new ImageIcon(IComptabilite.class.getResource("/add-user.png")));
		btnCreer_Employer.setBackground(new Color(205, 133, 63));

		btnSupprimer_Employer.setBackground(new Color(205, 133, 63));
		btnSupprimer_Employer.setIcon(new ImageIcon(IComptabilite.class.getResource("/delete.png")));
		
		btnModifier_Employer_1 = new JButton("Modifier");
		btnModifier_Employer_1.setIcon(new ImageIcon(IComptabilite.class.getResource("/pencil2.png")));
		btnModifier_Employer_1.setBackground(new Color(205, 133, 63));
		
		btnCreer_Employer_1 = new JButton("Creer");
		btnCreer_Employer_1.setIcon(new ImageIcon(IComptabilite.class.getResource("/add-user.png")));
		btnCreer_Employer_1.setBackground(new Color(205, 133, 63));

		
		comboBox_TrierEmployer = new JComboBox();
		
		JLabel lblNewLabel_2_3_1_1 = new JLabel("Trier par : ");
		
		textField_RechercheEmployer = new JTextField();
		textField_RechercheEmployer.setColumns(10);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("Recherche : ");
		
		JScrollPane scrollPane_8_1 = new JScrollPane();
		GroupLayout gl_panel_Employers = new GroupLayout(panel_Employers);
		gl_panel_Employers.setHorizontalGroup(
			gl_panel_Employers.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Employers.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1_3_1_1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textField_RechercheEmployer, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblNewLabel_2_3_1_1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(comboBox_TrierEmployer, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 309, Short.MAX_VALUE)
					.addComponent(btnCreer_Employer_1, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnModifier_Employer_1, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSupprimer_Employer, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addGap(15))
				.addComponent(scrollPane_8_1, GroupLayout.DEFAULT_SIZE, 1081, Short.MAX_VALUE)
		);
		gl_panel_Employers.setVerticalGroup(
			gl_panel_Employers.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Employers.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_Employers.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_Employers.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1_3_1_1))
						.addComponent(textField_RechercheEmployer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_Employers.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_2_3_1_1))
						.addComponent(comboBox_TrierEmployer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_Employers.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnModifier_Employer_1)
							.addComponent(btnCreer_Employer_1))
						.addComponent(btnSupprimer_Employer))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane_8_1, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))
		);
		
		table_ListeEmployer = new JTable();
		table_ListeEmployer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table_ListeEmployer.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"", "Nom", "Prenom", "Genre", "Poste", "Salaire", "Telephone", "Email", "Adresse", "N\u00B0 carte d'identite", "Date debut contrat", "Date arret"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_8_1.setViewportView(table_ListeEmployer);
		panel_Employers.setLayout(gl_panel_Employers);
		
		panel_Comptables = new JPanel();
		panel_Comptables.setBackground(new Color(222, 184, 135));
		tabbedPane_CRUD_Compte.addTab("Comptables", null, panel_Comptables, null);
		
		btnSupprimer_Comptable = new JButton("Supprimer");
		btnSupprimer_Comptable.setIcon(new ImageIcon(IComptabilite.class.getResource("/delete.png")));

		btnSupprimer_Comptable.setBackground(new Color(205, 133, 63));
		
		btnModifier_Comptable = new JButton("Modifier");
		btnModifier_Comptable.setIcon(new ImageIcon(IComptabilite.class.getResource("/pencil2.png")));
		btnModifier_Comptable.setBackground(new Color(205, 133, 63));
		
		btnCreer_Comptable = new JButton("Creer");
		btnCreer_Comptable.setIcon(new ImageIcon(IComptabilite.class.getResource("/add-user.png")));
		btnCreer_Comptable.setBackground(new Color(205, 133, 63));

		btnSupprimer_Comptable.setBackground(new Color(205, 133, 63));
		btnSupprimer_Employer.setIcon(new ImageIcon(IComptabilite.class.getResource("/delete.png")));
		
		btnModifier_Comptable_1 = new JButton("Modifier");
		btnModifier_Comptable_1.setIcon(new ImageIcon(IComptabilite.class.getResource("/pencil2.png")));
		btnModifier_Comptable_1.setBackground(new Color(205, 133, 63));
		
		btnCreer_Comptable_1 = new JButton("Creer");
		btnCreer_Comptable_1.setIcon(new ImageIcon(IComptabilite.class.getResource("/add-user.png")));
		btnCreer_Comptable_1.setBackground(new Color(205, 133, 63));

		
		JScrollPane scrollPane_8_2 = new JScrollPane();
		GroupLayout gl_panel_Comptables = new GroupLayout(panel_Comptables);
		gl_panel_Comptables.setHorizontalGroup(
			gl_panel_Comptables.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_Comptables.createSequentialGroup()
					.addContainerGap(725, Short.MAX_VALUE)
					.addComponent(btnCreer_Comptable_1, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnModifier_Comptable_1, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSupprimer_Comptable, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addGap(15))
				.addComponent(scrollPane_8_2, GroupLayout.DEFAULT_SIZE, 1081, Short.MAX_VALUE)
		);
		gl_panel_Comptables.setVerticalGroup(
			gl_panel_Comptables.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Comptables.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_Comptables.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_Comptables.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnModifier_Comptable_1)
							.addComponent(btnCreer_Comptable_1))
						.addComponent(btnSupprimer_Comptable))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane_8_2, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))
		);
		
		table_ListeComptable = new JTable();
		table_ListeComptable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table_ListeComptable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"", "Nom", "Prenom", "Genre", "Login", "Mot de passe", "Telephone", "Adresse", "N\u00B0 carte d'identite", "Email"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_8_2.setViewportView(table_ListeComptable);
		panel_Comptables.setLayout(gl_panel_Comptables);
		
		panel_Administrateurs = new JPanel();
		panel_Administrateurs.setBackground(new Color(222, 184, 135));
		tabbedPane_CRUD_Compte.addTab("Administrateurs", null, panel_Administrateurs, null);
		
		btnSupprimer_Administrateur = new JButton("Supprimer");
		btnSupprimer_Administrateur.setIcon(new ImageIcon(IComptabilite.class.getResource("/delete.png")));

		btnSupprimer_Administrateur.setBackground(new Color(205, 133, 63));
		
		btnModifier_Administrateur = new JButton("Modifier");
		btnModifier_Administrateur.setIcon(new ImageIcon(IComptabilite.class.getResource("/pencil2.png")));
		btnModifier_Administrateur.setBackground(new Color(205, 133, 63));
		
		btnCreer_Administrateur = new JButton("Creer");
		btnCreer_Administrateur.setIcon(new ImageIcon(IComptabilite.class.getResource("/add-user.png")));
		btnCreer_Administrateur.setBackground(new Color(205, 133, 63));

		btnSupprimer_Administrateur.setBackground(new Color(205, 133, 63));
		btnSupprimer_Administrateur.setIcon(new ImageIcon(IComptabilite.class.getResource("/delete.png")));
		
		btnModifier_Administrateur_1 = new JButton("Modifier");
		btnModifier_Administrateur_1.setIcon(new ImageIcon(IComptabilite.class.getResource("/pencil2.png")));
		btnModifier_Administrateur_1.setBackground(new Color(205, 133, 63));
		
		btnCreer_Administrateur_1 = new JButton("Creer");
		btnCreer_Administrateur_1.setIcon(new ImageIcon(IComptabilite.class.getResource("/add-user.png")));
		btnCreer_Administrateur_1.setBackground(new Color(205, 133, 63));

		
		JScrollPane scrollPane_8_3 = new JScrollPane();
		GroupLayout gl_panel_Administrateurs = new GroupLayout(panel_Administrateurs);
		gl_panel_Administrateurs.setHorizontalGroup(
			gl_panel_Administrateurs.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_Administrateurs.createSequentialGroup()
					.addContainerGap(724, Short.MAX_VALUE)
					.addComponent(btnCreer_Administrateur_1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnModifier_Administrateur_1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSupprimer_Administrateur, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addGap(15))
				.addComponent(scrollPane_8_3, GroupLayout.DEFAULT_SIZE, 1081, Short.MAX_VALUE)
		);
		gl_panel_Administrateurs.setVerticalGroup(
			gl_panel_Administrateurs.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Administrateurs.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_Administrateurs.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_Administrateurs.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnModifier_Administrateur_1)
							.addComponent(btnCreer_Administrateur_1))
						.addComponent(btnSupprimer_Administrateur))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane_8_3, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))
		);
		
		table_ListeAdministrateur = new JTable();
		table_ListeAdministrateur.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table_ListeAdministrateur.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"", "Nom", "Prenom", "Genre", "Login", "Mot de passe", "Telephone", "Email", "Adresse", "N\u00B0 carte d'identite"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_8_3.setViewportView(table_ListeAdministrateur);
		panel_Administrateurs.setLayout(gl_panel_Administrateurs);
		
		JPanel panel_Classe = new JPanel();
		panel_Classe.setBackground(new Color(222, 184, 135));
		tabbedPane_CRUD_Compte.addTab("Classe", null, panel_Classe, null);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		
		JScrollPane scrollPane_7_1 = new JScrollPane();
		
		textField_NomMatiere = new JTextField();
		textField_NomMatiere.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nom : ");
		
		spinner_PrixHeureMatiere = new JSpinner();
		
		JLabel lblNewLabel_1_1 = new JLabel("Prix / Heure : ");
		
		btn_SupprimerMatiere = new JButton("Supprimer");
		btn_SupprimerMatiere.setBackground(new Color(205, 133, 63));
		
		btn_AjouterMatiere = new JButton("Ajouter");
		btn_AjouterMatiere.setBackground(new Color(205, 133, 63));
		
		btn_ModifierMatiere = new JButton("Modifier");
		btn_ModifierMatiere.setBackground(new Color(205, 133, 63));
		
		JLabel lblNewLabel_2 = new JLabel("Nom : ");
		
		textField_NomClasse = new JTextField();
		textField_NomClasse.setColumns(10);
		
		textField_AnneeScolaire = new JComboBox();
		
		JLabel lblNewLabel_3 = new JLabel("Annee scolaire : ");
		
		btn_SupprimerClasse = new JButton("Supprimer");
		btn_SupprimerClasse.setBackground(new Color(205, 133, 63));
		
		btn_ModifierClasse = new JButton("Modifier");
		btn_ModifierClasse.setBackground(new Color(205, 133, 63));
		
		btn_AjouterClasse = new JButton("Ajouter");
		btn_AjouterClasse.setBackground(new Color(205, 133, 63));
		GroupLayout gl_panel_Classe = new GroupLayout(panel_Classe);
		gl_panel_Classe.setHorizontalGroup(
			gl_panel_Classe.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_Classe.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_Classe.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_Classe.createSequentialGroup()
							.addGroup(gl_panel_Classe.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrollPane_7, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, gl_panel_Classe.createSequentialGroup()
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_NomClasse))
								.addGroup(Alignment.LEADING, gl_panel_Classe.createSequentialGroup()
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_AnneeScolaire, 0, 246, Short.MAX_VALUE)))
							.addGap(367))
						.addGroup(gl_panel_Classe.createSequentialGroup()
							.addComponent(btn_AjouterClasse, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(btn_ModifierClasse, GroupLayout.PREFERRED_SIZE, 57, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(btn_SupprimerClasse, GroupLayout.PREFERRED_SIZE, 74, Short.MAX_VALUE)
							.addGap(367)))
					.addGroup(gl_panel_Classe.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_7_1, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_panel_Classe.createSequentialGroup()
							.addComponent(btn_AjouterMatiere, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btn_ModifierMatiere, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btn_SupprimerMatiere, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_Classe.createSequentialGroup()
							.addGroup(gl_panel_Classe.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_Classe.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_NomMatiere, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
								.addComponent(spinner_PrixHeureMatiere, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panel_Classe.setVerticalGroup(
			gl_panel_Classe.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_Classe.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_Classe.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_NomMatiere, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(textField_NomClasse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_Classe.createParallelGroup(Alignment.BASELINE)
						.addComponent(spinner_PrixHeureMatiere, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1)
						.addComponent(textField_AnneeScolaire, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addGap(54)
					.addGroup(gl_panel_Classe.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_Classe.createParallelGroup(Alignment.BASELINE)
							.addComponent(btn_SupprimerMatiere)
							.addComponent(btn_AjouterMatiere)
							.addComponent(btn_ModifierMatiere))
						.addComponent(btn_AjouterClasse)
						.addComponent(btn_ModifierClasse)
						.addComponent(btn_SupprimerClasse))
					.addGap(6)
					.addGroup(gl_panel_Classe.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_7_1, GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
						.addComponent(scrollPane_7, GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		table_ListeMatiere = new JTable();
		table_ListeMatiere.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Nom", "Prix / Heure"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_7_1.setViewportView(table_ListeMatiere);
		
		table_ListeClasse = new JTable();
		table_ListeClasse.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Nom", "Annee scolaire", "Nombre de matieres"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_7.setViewportView(table_ListeClasse);
		panel_Classe.setLayout(gl_panel_Classe);
		panel_CRUD_Comptes.setLayout(gl_panel_CRUD_Comptes);
		
		panel_Surveillance = new JPanel();
		panel_Surveillance.setBackground(new Color(222, 184, 135));
		layeredPane.add(panel_Surveillance, "name_88249309549305");
		
		lblSurveillanceAdministrateur = new JLabel("Surveillance | Administrateur | NANA C\u00E9dric Bollky Arnauld");
		lblSurveillanceAdministrateur.setBorder(new LineBorder(Color.GRAY, 1, true));
		lblSurveillanceAdministrateur.setFont(new Font("Eras Medium ITC", Font.PLAIN, 11));
		
		tabbedPane_Surveillance = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_Surveillance.setBackground(new Color(222, 184, 135));
		GroupLayout gl_panel_Surveillance = new GroupLayout(panel_Surveillance);
		gl_panel_Surveillance.setHorizontalGroup(
			gl_panel_Surveillance.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Surveillance.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_Surveillance.createParallelGroup(Alignment.TRAILING)
						.addComponent(tabbedPane_Surveillance, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1086, Short.MAX_VALUE)
						.addComponent(lblSurveillanceAdministrateur, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1086, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_Surveillance.setVerticalGroup(
			gl_panel_Surveillance.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Surveillance.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSurveillanceAdministrateur, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(tabbedPane_Surveillance, GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		panel_Depense = new JPanel();
		panel_Depense.setBackground(new Color(222, 184, 135));
		tabbedPane_Surveillance.addTab("Liste de D\u00E9pense", null, panel_Depense, null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		textField_TotalDepense = new JTextField();
		textField_TotalDepense.setEditable(false);
		textField_TotalDepense.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Total :");
		GroupLayout gl_panel_Depense = new GroupLayout(panel_Depense);
		gl_panel_Depense.setHorizontalGroup(
			gl_panel_Depense.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_Depense.createSequentialGroup()
					.addContainerGap(817, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_TotalDepense, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1081, Short.MAX_VALUE)
		);
		gl_panel_Depense.setVerticalGroup(
			gl_panel_Depense.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Depense.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_Depense.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_TotalDepense, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_2))
					.addGap(14)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE))
		);
		
		table_ListeDepense = new JTable();
		table_ListeDepense.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table_ListeDepense.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Montant", "Date", "Mode de paiement", "Annee scolaire", "Motif"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table_ListeDepense);
		panel_Depense.setLayout(gl_panel_Depense);
		
		panel_PaiementsScolarite = new JPanel();
		panel_PaiementsScolarite.setBackground(new Color(222, 184, 135));
		tabbedPane_Surveillance.addTab("Paiements scolarite", null, panel_PaiementsScolarite, null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblNewLabel_2_3_1_1_1_1 = new JLabel("Trier par : ");
		
		comboBox_TrierPar_PaiementScolarite = new JComboBox();
		comboBox_TrierPar_PaiementScolarite.setModel(new DefaultComboBoxModel(new String[] {"tous", "date", "prenom", "nom"}));
		
		btn_lancerTrierPar_PaiementScolarite = new JButton("");
		btn_lancerTrierPar_PaiementScolarite.setIcon(new ImageIcon(IComptabilite.class.getResource("/fleche.png")));

		btn_lancerTrierPar_PaiementScolarite.setBackground(new Color(205, 133, 63));

		btn_lancerTrierPar_PaiementScolarite.setBackground(new Color(205, 133, 63));

		
		textField_TotalPaiementScolarite = new JTextField();
		textField_TotalPaiementScolarite.setEditable(false);
		textField_TotalPaiementScolarite.setColumns(10);
		
		JLabel lblNewLabel_1_3 = new JLabel("Total :");
		GroupLayout gl_panel_PaiementsScolarite = new GroupLayout(panel_PaiementsScolarite);
		gl_panel_PaiementsScolarite.setHorizontalGroup(
			gl_panel_PaiementsScolarite.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_PaiementsScolarite.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2_3_1_1_1_1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(comboBox_TrierPar_PaiementScolarite, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btn_lancerTrierPar_PaiementScolarite)
					.addPreferredGap(ComponentPlacement.RELATED, 551, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_TotalPaiementScolarite, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 1081, Short.MAX_VALUE)
		);
		gl_panel_PaiementsScolarite.setVerticalGroup(
			gl_panel_PaiementsScolarite.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_PaiementsScolarite.createSequentialGroup()
					.addGroup(gl_panel_PaiementsScolarite.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_PaiementsScolarite.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_PaiementsScolarite.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_PaiementsScolarite.createParallelGroup(Alignment.BASELINE)
									.addComponent(textField_TotalPaiementScolarite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_1_3))
								.addGroup(gl_panel_PaiementsScolarite.createSequentialGroup()
									.addGap(3)
									.addGroup(gl_panel_PaiementsScolarite.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_PaiementsScolarite.createSequentialGroup()
											.addGap(4)
											.addComponent(lblNewLabel_2_3_1_1_1_1))
										.addGroup(gl_panel_PaiementsScolarite.createSequentialGroup()
											.addGap(1)
											.addComponent(comboBox_TrierPar_PaiementScolarite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))
						.addGroup(gl_panel_PaiementsScolarite.createSequentialGroup()
							.addGap(14)
							.addComponent(btn_lancerTrierPar_PaiementScolarite)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))
		);
		
		table_ListePaiementScolarite = new JTable();
		table_ListePaiementScolarite.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table_ListePaiementScolarite.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Date", "Recu N\u00B0", "Paiement N\u00B0", "Montant", "Matricule", "Nom", "Prenom", "Genre", "Mode de paiement"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_1.setViewportView(table_ListePaiementScolarite);
		panel_PaiementsScolarite.setLayout(gl_panel_PaiementsScolarite);
		
		panel_PaiementProfesseurs = new JPanel();
		panel_PaiementProfesseurs.setBackground(new Color(222, 184, 135));
		tabbedPane_Surveillance.addTab("Paiement professeurs", null, panel_PaiementProfesseurs, null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		JLabel lblNewLabel_2_3_1_1_1_2 = new JLabel("Trier par : ");
		
		comboBox_TrierPar_PAiementProfesseur = new JComboBox();
		comboBox_TrierPar_PAiementProfesseur.setModel(new DefaultComboBoxModel(new String[] {"tous", "mois", "type", "classe"}));
		
		btn_lancerTrierPar_PaiementProfesseur = new JButton("");
		btn_lancerTrierPar_PaiementProfesseur.setIcon(new ImageIcon(IComptabilite.class.getResource("/fleche.png")));

		btn_lancerTrierPar_PaiementProfesseur.setBackground(new Color(205, 133, 63));

		btn_lancerTrierPar_PaiementProfesseur.setBackground(new Color(205, 133, 63));

		
		textField_TotalPaiementProfesseur = new JTextField();
		textField_TotalPaiementProfesseur.setEditable(false);
		textField_TotalPaiementProfesseur.setColumns(10);
		
		JLabel lblNewLabel_1_4 = new JLabel("Total :");
		GroupLayout gl_panel_PaiementProfesseurs = new GroupLayout(panel_PaiementProfesseurs);
		gl_panel_PaiementProfesseurs.setHorizontalGroup(
			gl_panel_PaiementProfesseurs.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_PaiementProfesseurs.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2_3_1_1_1_2, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(comboBox_TrierPar_PAiementProfesseur, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btn_lancerTrierPar_PaiementProfesseur)
					.addPreferredGap(ComponentPlacement.RELATED, 618, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_TotalPaiementProfesseur, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 1081, Short.MAX_VALUE)
		);
		gl_panel_PaiementProfesseurs.setVerticalGroup(
			gl_panel_PaiementProfesseurs.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_PaiementProfesseurs.createSequentialGroup()
					.addGroup(gl_panel_PaiementProfesseurs.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_PaiementProfesseurs.createSequentialGroup()
							.addGap(14)
							.addGroup(gl_panel_PaiementProfesseurs.createParallelGroup(Alignment.LEADING)
								.addComponent(btn_lancerTrierPar_PaiementProfesseur)
								.addGroup(gl_panel_PaiementProfesseurs.createSequentialGroup()
									.addGap(4)
									.addComponent(lblNewLabel_2_3_1_1_1_2))
								.addGroup(gl_panel_PaiementProfesseurs.createSequentialGroup()
									.addGap(1)
									.addComponent(comboBox_TrierPar_PAiementProfesseur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_1_4)))
						.addGroup(gl_panel_PaiementProfesseurs.createSequentialGroup()
							.addContainerGap()
							.addComponent(textField_TotalPaiementProfesseur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))
		);
		
		table_ListePaiementProfesseur = new JTable();
		table_ListePaiementProfesseur.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table_ListePaiementProfesseur.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Montant", "Date", "Nom", "Prenom", "Classe", "Matiere", "Mode de paiement"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_2.setViewportView(table_ListePaiementProfesseur);
		panel_PaiementProfesseurs.setLayout(gl_panel_PaiementProfesseurs);
		
		panel_PaiementsEmployers = new JPanel();
		panel_PaiementsEmployers.setBackground(new Color(222, 184, 135));
		tabbedPane_Surveillance.addTab("Paiements employers", null, panel_PaiementsEmployers, null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		
		JLabel lblNewLabel_2_3_1_1_1_3 = new JLabel("Trier par : ");
		
		comboBox_TrierPar_PaiementEmployer = new JComboBox();
		comboBox_TrierPar_PaiementEmployer.setModel(new DefaultComboBoxModel(new String[] {"tous", "mois", "nom", "prenom"}));
		
		btn_lancerTrierPar_PaiementEmployer = new JButton("");
		btn_lancerTrierPar_PaiementEmployer.setIcon(new ImageIcon(IComptabilite.class.getResource("/fleche.png")));

		btn_lancerTrierPar_PaiementEmployer.setBackground(new Color(205, 133, 63));

		btn_lancerTrierPar_PaiementEmployer.setBackground(new Color(205, 133, 63));

		
		textField_TotalPaiementEmployer = new JTextField();
		textField_TotalPaiementEmployer.setEditable(false);
		textField_TotalPaiementEmployer.setColumns(10);
		
		JLabel lblNewLabel_1_5 = new JLabel("Total :");
		GroupLayout gl_panel_PaiementsEmployers = new GroupLayout(panel_PaiementsEmployers);
		gl_panel_PaiementsEmployers.setHorizontalGroup(
			gl_panel_PaiementsEmployers.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_PaiementsEmployers.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2_3_1_1_1_3, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(comboBox_TrierPar_PaiementEmployer, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btn_lancerTrierPar_PaiementEmployer)
					.addPreferredGap(ComponentPlacement.RELATED, 618, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1_5, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_TotalPaiementEmployer, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 1081, Short.MAX_VALUE)
		);
		gl_panel_PaiementsEmployers.setVerticalGroup(
			gl_panel_PaiementsEmployers.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_PaiementsEmployers.createSequentialGroup()
					.addGroup(gl_panel_PaiementsEmployers.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_PaiementsEmployers.createSequentialGroup()
							.addGap(14)
							.addGroup(gl_panel_PaiementsEmployers.createParallelGroup(Alignment.LEADING)
								.addComponent(btn_lancerTrierPar_PaiementEmployer)
								.addGroup(gl_panel_PaiementsEmployers.createSequentialGroup()
									.addGap(4)
									.addComponent(lblNewLabel_2_3_1_1_1_3))
								.addGroup(gl_panel_PaiementsEmployers.createSequentialGroup()
									.addGap(1)
									.addComponent(comboBox_TrierPar_PaiementEmployer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_1_5)))
						.addGroup(gl_panel_PaiementsEmployers.createSequentialGroup()
							.addContainerGap()
							.addComponent(textField_TotalPaiementEmployer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))
		);
		
		table_ListePaiementEmployer = new JTable();
		table_ListePaiementEmployer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table_ListePaiementEmployer.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Montant", "Date", "Nom", "Prenom", "Poste", "Mode de paiement"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_3.setViewportView(table_ListePaiementEmployer);
		panel_PaiementsEmployers.setLayout(gl_panel_PaiementsEmployers);
		
		panel_FraisDeScolarite = new JPanel();
		panel_FraisDeScolarite.setBackground(new Color(222, 184, 135));
		tabbedPane_Surveillance.addTab("Frais Inscription", null, panel_FraisDeScolarite, null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		
		JLabel lblNewLabel_2_3_1_1_1_4 = new JLabel("Trier par : ");
		
		comboBox_TrierPar_FraisInscription = new JComboBox();
		comboBox_TrierPar_FraisInscription.setModel(new DefaultComboBoxModel(new String[] {"tous", "date", "classe"}));
		
		btn_lancerTrierPar_FraisInscription = new JButton("");
		btn_lancerTrierPar_FraisInscription.setIcon(new ImageIcon(IComptabilite.class.getResource("/fleche.png")));

		btn_lancerTrierPar_FraisInscription.setBackground(new Color(205, 133, 63));

		

		
		textField_TotalFraisInscription = new JTextField();
		textField_TotalFraisInscription.setEditable(false);
		textField_TotalFraisInscription.setColumns(10);
		
		JLabel lblNewLabel_1_6 = new JLabel("Total :");
		GroupLayout gl_panel_FraisDeScolarite = new GroupLayout(panel_FraisDeScolarite);
		gl_panel_FraisDeScolarite.setHorizontalGroup(
			gl_panel_FraisDeScolarite.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_FraisDeScolarite.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2_3_1_1_1_4, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(comboBox_TrierPar_FraisInscription, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btn_lancerTrierPar_FraisInscription)
					.addPreferredGap(ComponentPlacement.RELATED, 618, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1_6, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_TotalFraisInscription, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addComponent(scrollPane_4, GroupLayout.DEFAULT_SIZE, 1081, Short.MAX_VALUE)
		);
		gl_panel_FraisDeScolarite.setVerticalGroup(
			gl_panel_FraisDeScolarite.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_FraisDeScolarite.createSequentialGroup()
					.addGroup(gl_panel_FraisDeScolarite.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_FraisDeScolarite.createSequentialGroup()
							.addGap(14)
							.addGroup(gl_panel_FraisDeScolarite.createParallelGroup(Alignment.LEADING)
								.addComponent(btn_lancerTrierPar_FraisInscription)
								.addGroup(gl_panel_FraisDeScolarite.createSequentialGroup()
									.addGap(4)
									.addComponent(lblNewLabel_2_3_1_1_1_4))
								.addGroup(gl_panel_FraisDeScolarite.createSequentialGroup()
									.addGap(1)
									.addComponent(comboBox_TrierPar_FraisInscription, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_1_6)))
						.addGroup(gl_panel_FraisDeScolarite.createSequentialGroup()
							.addContainerGap()
							.addComponent(textField_TotalFraisInscription, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane_4, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))
		);
		
		table_FraisDeScolarite = new JTable();
		table_FraisDeScolarite.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table_FraisDeScolarite.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Montant", "Date", "Matricule", "Nom", "Prenom", "Classe", "Genre", "Mode de paiement"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, true, true, true, true, true, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_4.setViewportView(table_FraisDeScolarite);
		panel_FraisDeScolarite.setLayout(gl_panel_FraisDeScolarite);
		
		panel_VersementBancaires = new JPanel();
		panel_VersementBancaires.setBackground(new Color(222, 184, 135));
		tabbedPane_Surveillance.addTab("Versement bancaires", null, panel_VersementBancaires, null);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		
		textField_TotalVersement = new JTextField();
		textField_TotalVersement.setEditable(false);
		textField_TotalVersement.setColumns(10);
		
		JLabel lblNewLabel_1_7 = new JLabel("Total :");
		GroupLayout gl_panel_VersementBancaires = new GroupLayout(panel_VersementBancaires);
		gl_panel_VersementBancaires.setHorizontalGroup(
			gl_panel_VersementBancaires.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_VersementBancaires.createSequentialGroup()
					.addContainerGap(860, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1_7, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_TotalVersement, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addComponent(scrollPane_5, GroupLayout.DEFAULT_SIZE, 1081, Short.MAX_VALUE)
		);
		gl_panel_VersementBancaires.setVerticalGroup(
			gl_panel_VersementBancaires.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_VersementBancaires.createSequentialGroup()
					.addGroup(gl_panel_VersementBancaires.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_VersementBancaires.createSequentialGroup()
							.addGap(14)
							.addComponent(lblNewLabel_1_7))
						.addGroup(gl_panel_VersementBancaires.createSequentialGroup()
							.addContainerGap()
							.addComponent(textField_TotalVersement, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(14)
					.addComponent(scrollPane_5, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE))
		);
		
		table_ListeVersement = new JTable();
		table_ListeVersement.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table_ListeVersement.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Date", "Montant", "Numero de compte", "Solde du compte", "Mode de paiement"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_5.setViewportView(table_ListeVersement);
		panel_VersementBancaires.setLayout(gl_panel_VersementBancaires);
		panel_Surveillance.setLayout(gl_panel_Surveillance);
		getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Mon compte");
		mnNewMenu.setIcon(new ImageIcon(IComptabilite.class.getResource("/man-user.png")));
		menuBar.add(mnNewMenu);
		
		btnModifierCompte = new JMenuItem("Modifier mon mot de passe");
		btnModifierCompte.setIcon(new ImageIcon(IComptabilite.class.getResource("/lock.png")));
		
		
		
		mnNewMenu.add(btnModifierCompte);
		
		btnDeconection = new JMenuItem("D\u00E9connexion");
		btnDeconection.setIcon(new ImageIcon(IComptabilite.class.getResource("/logout.png")));
		
		
		
		mnNewMenu.add(btnDeconection);
		
		
		
		//colums
		table_ListeEleve.getColumnModel().getColumn(0).setMaxWidth(0);
		table_ListeEmployer.getColumnModel().getColumn(0).setMaxWidth(0);
		table_ListeComptable.getColumnModel().getColumn(0).setMaxWidth(0);
		table_ListeAdministrateur.getColumnModel().getColumn(0).setMaxWidth(0);
		table_ListeProfesseur.getColumnModel().getColumn(0).setMaxWidth(0);
		
	}
	
	public void switchPanel(JPanel panel) {

		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();

	}
	//liste comptes
	
	
	public void  addRowDepense(String[] line) {
		tDepense =(DefaultTableModel) table_ListeDepense.getModel();
		tDepense.addRow(line);
	}
	public void  addRowPaiementScolarite(String[] line) {
		tPaiementScolarite =(DefaultTableModel) table_ListePaiementScolarite.getModel();
		tPaiementScolarite.addRow(line);
	}
	public void  addRowPaiementProf(String[] line) {

		tPaiementProfesseur =(DefaultTableModel) table_ListePaiementProfesseur.getModel();
		tPaiementProfesseur.addRow(line);
	}
	
	public void  addRowEmployer(String[] line) {
		tEmployer =(DefaultTableModel) table_ListeEmployer.getModel();
		tEmployer.addRow(line);
	}
	public void  addRowVersement(String[] line) {
		tVersement =(DefaultTableModel) table_ListeVersement.getModel();
		tVersement.addRow(line);
	}
	public void  addRowComptable(String[] line) {
		tComptable =(DefaultTableModel) table_ListeComptable.getModel();
		tComptable.addRow(line);
	}
	
	public void  addRowClasse(String[] line) {
		tClasse =(DefaultTableModel) table_ListeClasse.getModel();
		tClasse.addRow(line);
	}
	public void  addRowMatiere(String[] line) {
		tMatiere =(DefaultTableModel) table_ListeMatiere.getModel();
		tMatiere.addRow(line);
	}
	public void  addRowEleve(String[] line) {
		tEleve =(DefaultTableModel) table_ListeEleve.getModel();
		tEleve.addRow(line);
	}
	public void  addRowAdmin(String[] line) {
		tAdministrateur =(DefaultTableModel) table_ListeAdministrateur.getModel();
		tAdministrateur.addRow(line);
	}
	public void  addRowPaiementEmployer(String[] line) {
		tPaiementEmployer =(DefaultTableModel) table_ListePaiementEmployer.getModel();
		tPaiementEmployer.addRow(line);
	}
	public void  addRowFraisScolarite(String[] line) {
		tFraisScolarite =(DefaultTableModel) table_FraisDeScolarite.getModel();
		tFraisScolarite.addRow(line);
	}
	public void  addRowProf(String[] line) {

		tProfesseur =(DefaultTableModel) table_ListeProfesseur.getModel();
		tProfesseur.addRow(line);
	}
	

	public int selectRowDepense() {
		// TODO Auto-generated method stub
		return table_ListeDepense.getSelectedRow();
	}
	public int selectRowPaiementProf() {
		// TODO Auto-generated method stub
		return table_ListePaiementProfesseur.getSelectedRow();
	}
	public int selectRowComptable() {
		// TODO Auto-generated method stub
		return table_ListeComptable.getSelectedRow();
	}
	public int selectRowClasse() {
		// TODO Auto-generated method stub
		return table_ListeClasse.getSelectedRow();
	}
	public int selectRowVersement() {
		// TODO Auto-generated method stub
		return table_ListeVersement.getSelectedRow();
	}
	public int selectRowMatiere() {
		// TODO Auto-generated method stub
		return table_ListeMatiere.getSelectedRow();
	}
	public int selectRowEleve() {
		// TODO Auto-generated method stub
		return table_ListeEleve.getSelectedRow();
	}
	public int selectRowAdmin() {
		// TODO Auto-generated method stub
		return table_ListeAdministrateur.getSelectedRow();
	}
	public int selectRowPaiementEmployer() {
		// TODO Auto-generated method stub
		return table_ListePaiementEmployer.getSelectedRow();
	}
	public int selectRowFraisScolarite() {
		// TODO Auto-generated method stub
		return table_FraisDeScolarite.getSelectedRow();
	}
	public int selectRowProf() {
		// TODO Auto-generated method stub
		return table_ListeProfesseur.getSelectedRow();
	}
	public int selectRowPaiementScolarite() {
		// TODO Auto-generated method stub
		return table_ListePaiementScolarite.getSelectedRow();
	}
	public int selectRowEmployer() {
		// TODO Auto-generated method stub
		return table_ListeEmployer.getSelectedRow();
	}
	
	public void actualiserDepense() {
		tDepense =(DefaultTableModel) table_ListeDepense.getModel();
		int counter=0;
		counter=tDepense.getRowCount();
		while(counter!=0) {
			tDepense.removeRow(0);
		    counter--;
		}
	
	}
	
		
	
	public void actualiserPaiementProfesseur() {
		tPaiementProfesseur =(DefaultTableModel) table_ListePaiementProfesseur.getModel();
		int counter=0;
		counter=tPaiementProfesseur.getRowCount();
		while(counter!=0) {
			tPaiementProfesseur.removeRow(0);
		    counter--;
		}
	
	}
	
	public void actualiserComptabilite() { 
	
		tComptable =(DefaultTableModel) table_ListeComptable.getModel();
		int counter=0;
		counter=tComptable.getRowCount();
		while(counter!=0) {
			tComptable.removeRow(0);
		    counter--;
		}
	}
	
	public void actualiserClasse() {
		tClasse =(DefaultTableModel) table_ListeClasse.getModel();
		int counter=0;
		counter=tClasse.getRowCount();
		while(counter!=0) {
			tClasse.removeRow(0);
		    counter--;
		}
	
		
	}
	public void actualiserVersement() {
		tVersement =(DefaultTableModel) table_ListeVersement.getModel();
		int counter=0;
		counter=tVersement.getRowCount();
		while(counter!=0) {
			tVersement.removeRow(0);
		    counter--;
		}
		
	}
	public void actualiserMatiere() {
		tMatiere =(DefaultTableModel) table_ListeMatiere.getModel();
		int counter=0;
		counter=tMatiere.getRowCount();
		while(counter!=0) {
			tMatiere.removeRow(0);
		    counter--;
		}
	
	}
	public void actualiserEleve() {
		tEleve =(DefaultTableModel) table_ListeEleve.getModel();
		int counter=0;
		counter=tEleve.getRowCount();
		while(counter!=0) {
			tEleve.removeRow(0);
		    counter--;
		}
		;
	}
	public void actualiserAdministrateur() {
		
		tAdministrateur =(DefaultTableModel) table_ListeAdministrateur.getModel();
		int counter=0;
		counter=tAdministrateur.getRowCount();
		while(counter!=0) {
			tAdministrateur.removeRow(0);
		    counter--;
		}
	}
	public void actualiserPaiementEmployer() {
		tPaiementEmployer =(DefaultTableModel) table_ListePaiementEmployer.getModel();
		int counter=0;
		counter=tPaiementEmployer.getRowCount();
		while(counter!=0) {
			tPaiementEmployer.removeRow(0);
		    counter--;
		}
		
	}
	public void actualiserFraisDeScolarite() {
		tFraisScolarite =(DefaultTableModel) table_FraisDeScolarite.getModel();
		int counter=0;
		counter=tFraisScolarite.getRowCount();
		while(counter!=0) {
			tFraisScolarite.removeRow(0);
		    counter--;
		}
		
	}
	
	public void actualiserProfesseur() {
		tProfesseur =(DefaultTableModel) table_ListeProfesseur.getModel();
		int counter=0;
		counter=tProfesseur.getRowCount();
		while(counter!=0) {
			tProfesseur.removeRow(0);
		    counter--;
		}
		
	}
	public void actualiserPaiementScolariter() {
		tPaiementScolarite =(DefaultTableModel) table_ListePaiementScolarite.getModel();
		int counter=0;
		counter=tPaiementScolarite.getRowCount();
		while(counter!=0) {
			tPaiementScolarite.removeRow(0);
		    counter--;
		}

	}
	public void actualiserEmployer() {
		tEmployer =(DefaultTableModel) table_ListeEmployer.getModel();
		int counter=0;
		counter=tEmployer.getRowCount();
		while(counter!=0) {
			tEmployer.removeRow(0);
		    counter--;
		}
	}
	
	public String tProfCol1() {
		tProfesseur =(DefaultTableModel) table_ListeProfesseur.getModel();
		return (String) tProfesseur.getValueAt(selectRowProf(), 0);
	}
	public String tProfCol2() {
		tProfesseur =(DefaultTableModel) table_ListeProfesseur.getModel();
		return (String) tProfesseur.getValueAt(selectRowProf(), 1);
	}

	public String tProfCol3() {
		tProfesseur =(DefaultTableModel) table_ListeProfesseur.getModel();
		return (String) tProfesseur.getValueAt(selectRowProf(), 2);
	}
	public String tProfCol4() {
		tProfesseur =(DefaultTableModel) table_ListeProfesseur.getModel();
		return (String) tProfesseur.getValueAt(selectRowProf(), 3);
	}

	public String tProfCol5() {
		tProfesseur =(DefaultTableModel) table_ListeProfesseur.getModel();
		return (String) tProfesseur.getValueAt(selectRowProf(), 4);
	}
	public String tProfCol6() {
		tProfesseur =(DefaultTableModel) table_ListeProfesseur.getModel();
		return (String) tProfesseur.getValueAt(selectRowProf(), 5);
	}
	public String tProfCol7() {
		tProfesseur =(DefaultTableModel) table_ListeProfesseur.getModel();
		return (String) tProfesseur.getValueAt(selectRowProf(), 6);
	}
	public String tProfCol8() {
		tProfesseur =(DefaultTableModel) table_ListeProfesseur.getModel();
		return (String) tProfesseur.getValueAt(selectRowProf(), 7);
	}
	public String tProfCol9() {
		tProfesseur =(DefaultTableModel) table_ListeProfesseur.getModel();
		return (String) tProfesseur.getValueAt(selectRowProf(), 8);
	}
	public String tProfCol10() {
		tProfesseur =(DefaultTableModel) table_ListeProfesseur.getModel();
		return (String) tProfesseur.getValueAt(selectRowProf(), 9);
	}
	public String tProfCol11() {
		tProfesseur =(DefaultTableModel) table_ListeProfesseur.getModel();
		return (String) tProfesseur.getValueAt(selectRowProf(), 10);
	}
	public String tProfCol12() {
		tProfesseur =(DefaultTableModel) table_ListeProfesseur.getModel();
		return (String) tProfesseur.getValueAt(selectRowProf(), 11);
	}
	public String tProfCol13() {
		tProfesseur =(DefaultTableModel) table_ListeProfesseur.getModel();
		return (String) tProfesseur.getValueAt(selectRowProf(), 12);
	}
	public String tProfCol14() {
		tProfesseur =(DefaultTableModel) table_ListeProfesseur.getModel();
		return (String) tProfesseur.getValueAt(selectRowProf(), 13);
	}
	public String tProfCol15() {
		tProfesseur =(DefaultTableModel) table_ListeProfesseur.getModel();
		return (String) tProfesseur.getValueAt(selectRowProf(), 14);
	}
	public String tProfCol16() {
		tProfesseur =(DefaultTableModel) table_ListeProfesseur.getModel();
		return (String) tProfesseur.getValueAt(selectRowProf(), 15);
	}
	public String tAdminCol1() {
		tAdministrateur =(DefaultTableModel) table_ListeAdministrateur.getModel();
		return (String) tAdministrateur.getValueAt(selectRowAdmin(), 0);
	}
	public String tAdminCol2() {
		tAdministrateur =(DefaultTableModel) table_ListeAdministrateur.getModel();
		return (String) tAdministrateur.getValueAt(selectRowAdmin(), 1);
	}

	public String tAdminCol3() {
		tAdministrateur =(DefaultTableModel) table_ListeAdministrateur.getModel();
		return (String) tAdministrateur.getValueAt(selectRowAdmin(), 2);
	}
	public String tAdminCol4() {
		tAdministrateur =(DefaultTableModel) table_ListeAdministrateur.getModel();
		return (String) tAdministrateur.getValueAt(selectRowAdmin(), 3);
	}

	public String tAdminCol5() {
		tAdministrateur =(DefaultTableModel) table_ListeAdministrateur.getModel();
		return (String) tAdministrateur.getValueAt(selectRowAdmin(), 4);
	}
	public String tAdminCol6() {
		tAdministrateur =(DefaultTableModel) table_ListeAdministrateur.getModel();
		return (String) tAdministrateur.getValueAt(selectRowAdmin(), 5);
	}
	public String tAdminCol7() {
		tAdministrateur =(DefaultTableModel) table_ListeAdministrateur.getModel();
		return (String) tAdministrateur.getValueAt(selectRowAdmin(), 6);
	}
	public String tAdminCol8() {
		tAdministrateur =(DefaultTableModel) table_ListeAdministrateur.getModel();
		return (String) tAdministrateur.getValueAt(selectRowAdmin(), 6);
	}
	
	
	
	public String tComptCol1() {
		tComptable =(DefaultTableModel) table_ListeComptable.getModel();
		return (String) tComptable.getValueAt(selectRowComptable(), 0);
	}
	public String tComptCol2() {
		tComptable =(DefaultTableModel) table_ListeComptable.getModel();
		return (String) tComptable.getValueAt(selectRowComptable(), 1);
	}

	public String tComptCol3() {
		tComptable =(DefaultTableModel) table_ListeComptable.getModel();
		return (String) tComptable.getValueAt(selectRowComptable(), 2);
	}
	public String tComptCol4() {
		tComptable =(DefaultTableModel) table_ListeComptable.getModel();
		return (String) tComptable.getValueAt(selectRowComptable(), 3);
	}

	public String tComptCol5() {
		tComptable =(DefaultTableModel) table_ListeComptable.getModel();
		return (String) tComptable.getValueAt(selectRowComptable(), 4);
	}
	public String tComptCol6() {
		tComptable =(DefaultTableModel) table_ListeComptable.getModel();
		return (String) tComptable.getValueAt(selectRowComptable(), 5);
	}
	public String tComptCol7() {
		tComptable =(DefaultTableModel) table_ListeComptable.getModel();
		return (String) tComptable.getValueAt(selectRowComptable(), 6);
	}
	
	//comptable
	public void supprimerComptableListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		btnSupprimer_Comptable.addActionListener(actionListener);	
	}
	public void supprimerAdminListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		btnSupprimer_Administrateur.addActionListener(actionListener);	
	}
	public void addComptableListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		btnCreer_Comptable_1.addActionListener(actionListener);	
	}
	public void addAdminListener(ActionListener actionListener) {
		// TODO Auto-generated method stub 
		btnCreer_Administrateur_1.addActionListener(actionListener);	
	}
	public void updateComptableListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		btnModifier_Comptable_1.addActionListener(actionListener);	
	}
	public void updateAdminListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		btnModifier_Administrateur_1.addActionListener(actionListener);	
	}
	
	
	//employe
		public void supprimerEmployeListener(ActionListener actionListener) {
			// TODO Auto-generated method stub
			btnSupprimer_Employer.addActionListener(actionListener);	
		}
		
		public void addEmployeListener(ActionListener actionListener) {
			// TODO Auto-generated method stub
			btnCreer_Employer_1.addActionListener(actionListener);	
		}
	
		public void updateEmployeListener(ActionListener actionListener) {
			// TODO Auto-generated method stub
			btnModifier_Employer_1.addActionListener(actionListener);	
		}
		
	//colone employe
		public String tEmployeCol1() {
			tEmployer =(DefaultTableModel) table_ListeEmployer.getModel();
			return (String) tEmployer.getValueAt(selectRowEmployer(), 0);
		}
		public String tEmployeCol2() {
			tEmployer =(DefaultTableModel) table_ListeEmployer.getModel();
			return (String) tEmployer.getValueAt(selectRowEmployer(), 1);
		}

		public String tEmployeCol3() {
			tEmployer =(DefaultTableModel) table_ListeEmployer.getModel();
			return (String) tEmployer.getValueAt(selectRowEmployer(), 2);
		}
		public String tEmployeCol4() {
			tEmployer =(DefaultTableModel) table_ListeEmployer.getModel();
			return (String) tEmployer.getValueAt(selectRowEmployer(), 3);
		}

		public String tEmployeCol5() {
			tEmployer =(DefaultTableModel) table_ListeEmployer.getModel();
			return (String) tEmployer.getValueAt(selectRowEmployer(), 4);
		}
		public String tEmployeCol6() {
			tEmployer =(DefaultTableModel) table_ListeEmployer.getModel();
			return (String) tEmployer.getValueAt(selectRowEmployer(), 5);
		}
		public String tEmployeCol7() {
			tEmployer =(DefaultTableModel) table_ListeEmployer.getModel();
			return (String) tEmployer.getValueAt(selectRowEmployer(), 6);
		}
		public String tEmployeCol8() {
			tEmployer =(DefaultTableModel) table_ListeEmployer.getModel();
			return (String) tEmployer.getValueAt(selectRowEmployer(), 7);
		}
		public String tEmployeCol9() {
			tEmployer =(DefaultTableModel) table_ListeEmployer.getModel();
			return (String) tEmployer.getValueAt(selectRowEmployer(), 8);
		}
		public String tEmployeCol10() {
			tEmployer =(DefaultTableModel) table_ListeEmployer.getModel();
			return (String) tEmployer.getValueAt(selectRowEmployer(), 9);
		}
		public String tEmployeCol11() {
			tEmployer =(DefaultTableModel) table_ListeEmployer.getModel();
			return (String) tEmployer.getValueAt(selectRowEmployer(), 10);
		}
	
		public String tEmployeCol12() {
			tEmployer =(DefaultTableModel) table_ListeEmployer.getModel();
			return (String) tEmployer.getValueAt(selectRowEmployer(), 11);
		}
		
		
		
		//colone eleve
		public String tEleveCol1() {
			tEleve =(DefaultTableModel) table_ListeEleve.getModel();
			return (String) tEleve.getValueAt(selectRowEleve(), 0);
		}
		public String tEleveCol2() {
			tEleve =(DefaultTableModel) table_ListeEleve.getModel();
			return (String) tEleve.getValueAt(selectRowEleve(), 1);
		}

		public String tEleveCol3() {
			tEleve =(DefaultTableModel) table_ListeEleve.getModel();
			return (String) tEleve.getValueAt(selectRowEleve(), 2);
		}
		public String tEleveCol4() {
			tEleve =(DefaultTableModel) table_ListeEleve.getModel();
			return (String) tEleve.getValueAt(selectRowEleve(), 3);
		}

		public String tEleveCol5() {
			tEleve =(DefaultTableModel) table_ListeEleve.getModel();
			return (String) tEleve.getValueAt(selectRowEleve(), 4);
		}
		public String tEleveCol6() {
			tEleve =(DefaultTableModel) table_ListeEleve.getModel();
			return (String) tEleve.getValueAt(selectRowEleve(), 5);
		}
		public String tEleveCol7() {
			tEleve =(DefaultTableModel) table_ListeEleve.getModel();
			return (String) tEleve.getValueAt(selectRowEleve(), 6);
		}
		public String tEleveCol8() {
			tEleve =(DefaultTableModel) table_ListeEleve.getModel();
			return (String) tEleve.getValueAt(selectRowEleve(), 7);
		}
		public String tEleveCol9() {
			tEleve =(DefaultTableModel) table_ListeEleve.getModel();
			return (String) tEleve.getValueAt(selectRowEleve(), 8);
		}
		
		
		public void setMessage(String msg) {
			message.setText(msg);
		}
		public void setCouleur(Color col) {
			message.setForeground(col);
		}
		
	
	public void addTableAdminMousseListener(MouseAdapter mousseListener) {
		table_ListeAdministrateur.addMouseListener(mousseListener);
	}
	public void addTableComptableMousseListener(MouseAdapter mousseListener) {
		table_ListeComptable.addMouseListener(mousseListener);
	}
	public void addTableEmployerMousseListener(MouseAdapter mousseListener) {
		table_ListeEmployer.addMouseListener(mousseListener);
	}
	public void addTableEleveMousseListener(MouseAdapter mousseListener) {
		table_ListeEleve.addMouseListener(mousseListener);
	}


	public void addEleveListener(ActionListener actionListener) {
		btnCreer_Eleve.addActionListener(actionListener);	
		
	}

	public void updateEleveListener(ActionListener actionListener) {
		btnModifier_Eleve.addActionListener(actionListener);
		
	}
	
	
	
	
	
	public void afficher() {
		setVisible(true);
		pack();
	}

	public void addProfListener(ActionListener actionListener) {
		btnCreer_Professeur_1.addActionListener(actionListener);
		
	}

	public void updateProfListener(ActionListener actionListener) {
		btnModifier_Professeur_1.addActionListener(actionListener);
		
	}

	public void addTableProfMousseListener(MouseAdapter mouseAdapter) {
		table_ListeProfesseur.addMouseListener(mouseAdapter);
		
	}

	public void supprimerProfListener(ActionListener actionListener) {
		btnSupprimer_Professeur.addActionListener(actionListener);
		
	}

	public void supprimerEleveListener(ActionListener actionListener) {
		btnSupprimer_Eleve.addActionListener(actionListener);
		
	}
	public void detailEleveListener(ActionListener actionListener) {
		btnDetailEleve.addActionListener(actionListener);
		
	}
	
	public String getTrieScolarite() {
		return comboBox_TrierPar_PaiementScolarite.getSelectedItem().toString();
	}
	public String getTriePProf() {
		return comboBox_TrierPar_PAiementProfesseur.getSelectedItem().toString();
	}
	public String getTriePInscription() {
		return comboBox_TrierPar_FraisInscription.getSelectedItem().toString();
	}
	public String getTriePEmployer() {
		return comboBox_TrierPar_PaiementEmployer.getSelectedItem().toString();
	}
	
	public void addValiderProfListener(ActionListener actionListener) {
		btn_lancerTrierPar_PaiementProfesseur.addActionListener(actionListener);
		
	}
	
	public void addValiderScolariteListener(ActionListener actionListener) {
		btn_lancerTrierPar_PaiementScolarite.addActionListener(actionListener);
		
	}
	public void addValiderInscriptionListener(ActionListener actionListener) {
		btn_lancerTrierPar_FraisInscription.addActionListener(actionListener);
		
	}
	
	public void addValiderEmployeListener(ActionListener actionListener) {
		btn_lancerTrierPar_PaiementEmployer.addActionListener(actionListener);
		
	}
	
	
	public void setTotalDepense(String mtn) {
		textField_TotalDepense.setText(mtn);
	}
	public void setTotalInscription(String mtn) {
		textField_TotalFraisInscription.setText(mtn);
	}
	public void setTotalScolarite(String mtn) {
		textField_TotalPaiementScolarite.setText(mtn);
	}
	
	
	public void setTotalPaieProf(String mtn) {
		textField_TotalPaiementProfesseur.setText(mtn);
	}
	public void setTotalPaieEmploye(String mtn) {
		textField_TotalPaiementEmployer.setText(mtn);
	}
	public void setTotalVersement(String mtn) {
		textField_TotalVersement.setText(mtn);
	}
	
	
	
	
	public void addDeconectionListener(ActionListener actionListener) {
		btnDeconection.addActionListener(actionListener);
		
	}
	

	public void addModifierMdpListener(ActionListener actionListener) {
		btnModifierCompte.addActionListener(actionListener);
		
	}
	
	
	public int showMessageConfirmation(String title,String message) {
		int retour = JOptionPane.showConfirmDialog(this,
	             message, 
	             title,
	             JOptionPane.OK_CANCEL_OPTION);
		
		return retour;
	}
	
	
	public void setNomPrenomUser(String name) {
		lbl_info_compte.setText("Gestion des comptes | Administrateur | "+name);
	}
	
	@SuppressWarnings("static-access")
	public void aProposActionPerformed(java.awt.event.ActionEvent evt,String msg) {
		  JOptionPane jOptionPane1=null;
		jOptionPane1.showMessageDialog(this,msg);
		}
	
	public void close() {
		dispose();
	}

	public void setNomPrenomUserSurveillance(String name) {
		lblSurveillanceAdministrateur.setText("Gestion des comptes | Administrateur | "+name);
		
	}
	
	
	
	
}
