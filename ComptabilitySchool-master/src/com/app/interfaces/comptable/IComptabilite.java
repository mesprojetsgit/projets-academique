package com.app.interfaces.comptable;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import com.app.colorTable.ColorTable;
import com.app.dao.IDaoPersonnel;
import com.app.dao.IDaoProffesseur;
import com.app.daoImpl.DaoPersonnelImpl;
import com.app.daoImpl.DaoProfesseurImpl;
import com.app.metier.entites.Personnel;
import com.app.metier.entites.Professeur;
import com.app.metier.entites.ResumePaiementProfesseur;
import com.app.metier.model.ModelDepense;
import com.app.metier.model.ModelEleve;
import com.app.metier.model.ModelEleveListe;
import com.app.metier.model.ModelEmployer;
import com.app.metier.model.ModelFraisInscription;
import com.app.metier.model.ModelPaiementAuxiliaire;
import com.app.metier.model.ModelPaiementEmployer;
import com.app.metier.model.ModelPaiementProfesseur;
import com.app.metier.model.ModelPaiementScolarite;
import com.app.metier.model.ModelProfesseur;
import com.app.metier.model.ModelResume;
import com.app.metier.model.ModelVersement;

@SuppressWarnings("serial")
public class IComptabilite extends JFrame {
	private JTable tableDepense;
	private JButton buttonRechercherEleve ;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_MoisDepense;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_Scolarite_TrierPar_listePaiement;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_PaiementProfesseur_TrierPar_listeProfesseur ;
	private JLayeredPane layeredPane;
	private JPanel panel_Dépenses;
	private JPanel panel_PaiementScolarité;
	private JTextField textField_MontantTotalDepense;
	private JTable tableListeEleve;
    private JButton buttonRechercherEmployerPaiement,buttonTrierPaiementEmployer ;

	private JTable table_listeProfesseur;
	private JTable table_listeEmployer;
	private JTable table_listeEleve_FraisInscription;
	private JTable table_listeVersementBancaire;

	private JPanel panel_VersementBancaire;
	private JPanel panel_FraisInscription;
	private JPanel panel_PaiementEmployers;
	private JPanel panel_PaiementProfesseurs;
	private JTextField textField_PaiementProfesseur_RechercheProfesseur;
	private JTable tableListePaiementScolarite;
	private JTable table_listePaiementProfesseur;
	private JTable table_listePaiementEmployer;
	private JTable table_listePaiementFraisInscription;
	private JButton btn_Menu_PaiementEmployer;
	private JButton btn_Menu_PaiementProfesseur;
	private JButton btn_Menu_Scolarite;
	private JButton btn_Menu_Depense;
	private JButton btn_Menu_FraisInscription;
	private JButton btn_Menu_VersementBancaire;
	private JButton btn_AjouterDepense;
	private JButton btn_ModifierDepense;
	private JButton btn_SupprimerDepense;
	private JButton btn_Scolarite_NouveauPaiement;
	private JButton btn_Scolarite_Recu;
	private JButton btn_Scolarite_SupprimerPaiement;
	private JButton btn_Scolarite_ModifierPaiement;
	private JButton btn_PaiementProfesseur_PayerSalaire;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_PaiementProfesseur_TrierPar_listePaiementProfesseur;
	private JButton btn_PaiementProfesseur_BulletinDeSalaire;
	private JButton btn_PaiementProfesseur_ModifierPaiement;
	private JButton btn_PaiementProfesseur_SupprimerPaiement;
	private JButton btn_PaiementEmployer_PayerSalaire;
	private JButton btn_PaiementEmployer_BulletinSalaire;
	private JButton btn_PaiementEmployer_ModifierPaiement;
	private JButton btn_PaiementEmployer_SupprimerPaiement;
	private JButton btn_FraisInscription_AjouterFraisScolarite;
	private JButton btn_FraisInscription_Recu;
	private JButton btn_FraisInscription_ModifierFraisScolarite;
	private JButton btn_FraisInscription_SupprimerFraisScolarite;
	private JButton btn_VersementBancaire_Ajouter;
	private JButton btn_VersementBancaire_Modifier;
	private JButton btn_VersementBancaire_Supprimer,btnRechercher;
	private JButton buttonLancerRechercheProf ;
	
	private JButton buttonTriProf;
	private JTextField textFieldRechercherRecu;
	private JTextField textFieldRechercherEleve;
	private JTextField textField_rechercheProfesseur;
	private JTextField textField_recherchePaiementEmployer;
	private JLabel lblNewLabel_2_1_3;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_PaiementEmployer_TrierPar_listePaiementEmployer;
	private JLabel lblNewLabel_1_1_3;
	private JTextField textField_rechercheEmployer_listeEmployer;
	private JLabel lblNewLabel_2_1_2;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_PaiementEmployer_TrierPar_listeEmployer;
	private JLabel lblNewLabel_1_1_2;
	private JTabbedPane tabbedPane_3;
	private JPanel panel_ListeDesEleves;
	private JPanel panel_FraisInscription_;
	private JTextField textField_recherche_listeEleve_FraisInscription;
	private JLabel lblNewLabel_2_1_4;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_FraisInscription_listeEleve_TrierPar;
	private JLabel lblNewLabel_1_1_4;
	private JTextField textField_rechercheFraisInscription;
	private JLabel lblNewLabel_2_1_5;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_FraisInscription_TrierPar_listeFraisInscription;
	private JLabel lblNewLabel_1_1_5;
	private JLabel lbl_info_depense;
	private JLabel lbl_info_scolarite;
	private JLabel lbl_info_professeur;
	private JLabel lbl_info_employer;
	private JLabel lbl_info_inscription;
	private JLabel lbl_info_versement;
	private  Double somme =0.0;
	private JButton buttonRechercherRecu;
	private JButton buttonTrierParRecu;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_Scolarite_TrierPar_listeEleve;
	private JButton button_TrierPar_listeEleve;
	private JButton buttonRechercherPaiementProf;
	private JButton buttonTriPaiementProf;
	private JButton buttonRechercherEmployer;
	private JButton buttonTriEmployer;
	private JButton buttonrechercherEleveInscription;
	private JButton buttonTriEleveInscription;
	private JButton buttonRechercherFraisInscription;
	private JButton buttonTriFraisInscription;
	private JLabel label_Information;
	private JButton btn_details;
	private JPanel panel_6;
	private JTable table_resumePaiementProfesseur;
	private JTextField textField_total_Resume_PaiementProfesseur;
	private JLabel lblNewLabel_1;
	private JPanel panel_7;
	private JScrollPane scrollPane_8;
	private JButton btn_SupprimerPaiementAuxiliaire;
	private JTable table_Auxiliaire;
	private JMenu mnNewMenu;
	private JButton btn_recuPaiementProfesseur;
	private JButton btn_recuPaiementEmployer;
	private JButton btn_ModifierPaiementAuxiliaire;
	private JButton btnRecuPaiementAuxiliaire;
	private JButton btn_PayerExtra;
	private JMenuItem btn_modifierMotDePasse;
	private JMenuItem btn_deconnexion;
	private JLabel lblNewLabel_2;
	private JTextField textField_totalVErsementBancaire;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public IComptabilite() {
		setTitle("Comptabilit\u00E9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(1124, 720));
		getContentPane().setBackground(new Color(222, 184, 135));

		JPanel panel_MenuPrincipal = new JPanel();
		panel_MenuPrincipal.setAutoscrolls(true);
		panel_MenuPrincipal.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel_MenuPrincipal.setBackground(new Color(222, 184, 135));
		panel_MenuPrincipal.setBorder(null);

		layeredPane = new JLayeredPane();
		layeredPane.setBorder(null);
		layeredPane.setLayout(new CardLayout(0, 0));

		JLabel lblN = new JLabel("  SONA-Group \u00A9 2020");
		lblN.setBorder(null);
		lblN.setBackground(Color.LIGHT_GRAY);
		
		label_Information = new JLabel("");
		label_Information.setHorizontalAlignment(SwingConstants.RIGHT);
		label_Information.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_Information.setBorder(null);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_MenuPrincipal, GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
						.addComponent(lblN, GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE))
					.addGap(10))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_Information, GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 1108, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_MenuPrincipal, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_Information, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblN)
					.addGap(5))
		);

		btn_Menu_Depense = new JButton("\r\nD\u00E9penses");
		btn_Menu_Depense.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Menu_Depense.setBackground(new Color(240,240,240));
		btn_Menu_Depense.setBounds(0, 0, 165, 100);
		btn_Menu_Depense.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_Menu_Scolarite.setBackground(new Color(205, 133, 63));
				btn_Menu_Depense.setBackground(new Color(240,240,240));
				btn_Menu_PaiementProfesseur.setBackground(new Color(205, 133, 63));
				btn_Menu_PaiementEmployer.setBackground(new Color(205, 133, 63));
				btn_Menu_FraisInscription.setBackground(new Color(205, 133, 63));
				btn_Menu_VersementBancaire.setBackground(new Color(205, 133, 63));
				switchPanel(panel_Dépenses);
			}
		});
		btn_Menu_Depense.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btn_Menu_Depense.setMinimumSize(new Dimension(200, 100));
		btn_Menu_Depense.setMaximumSize(new Dimension(200, 100));
		btn_Menu_Depense.setIcon(new ImageIcon(IComptabilite.class.getResource("/depense2.png")));

		btn_Menu_Scolarite = new JButton("\r\nScolarit\u00E9");
		btn_Menu_Scolarite.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Menu_Scolarite.setIcon(new ImageIcon(IComptabilite.class.getResource("/education.png")));
		btn_Menu_Scolarite.setBackground(new Color(205, 133, 63));
		btn_Menu_Scolarite.setBounds(175, 0, 165, 100);
		btn_Menu_Scolarite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_Menu_Scolarite.setBackground(new Color(240,240,240));
				btn_Menu_Depense.setBackground(new Color(205, 133, 63));
				btn_Menu_PaiementProfesseur.setBackground(new Color(205, 133, 63));
				btn_Menu_PaiementEmployer.setBackground(new Color(205, 133, 63));
				btn_Menu_FraisInscription.setBackground(new Color(205, 133, 63));
				btn_Menu_VersementBancaire.setBackground(new Color(205, 133, 63));
				switchPanel(panel_PaiementScolarité);
			}
		});
		
		btn_Menu_Scolarite.setMinimumSize(new Dimension(100, 100));
		btn_Menu_Scolarite.setMaximumSize(new Dimension(100, 100));

		btn_Menu_PaiementProfesseur = new JButton("Prof\u00E9sseurs");
		btn_Menu_PaiementProfesseur.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Menu_PaiementProfesseur.setIcon(new ImageIcon(IComptabilite.class.getResource("/presentation.png")));
		btn_Menu_PaiementProfesseur.setBackground(new Color(205, 133, 63));
		btn_Menu_PaiementProfesseur.setBounds(350, 0, 174, 100);
		btn_Menu_PaiementProfesseur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_Menu_Scolarite.setBackground(new Color(205, 133, 63));
				btn_Menu_Depense.setBackground(new Color(205, 133, 63));
				btn_Menu_PaiementProfesseur.setBackground(new Color(240,240,240));
				btn_Menu_PaiementEmployer.setBackground(new Color(205, 133, 63));
				btn_Menu_FraisInscription.setBackground(new Color(205, 133, 63));
				btn_Menu_VersementBancaire.setBackground(new Color(205, 133, 63));
				switchPanel(panel_PaiementProfesseurs);
			}
		});
		btn_Menu_PaiementProfesseur.setMinimumSize(new Dimension(100, 100));
		btn_Menu_PaiementProfesseur.setMaximumSize(new Dimension(100, 100));

		btn_Menu_PaiementEmployer = new JButton("Employers");
		btn_Menu_PaiementEmployer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Menu_PaiementEmployer.setIcon(new ImageIcon(IComptabilite.class.getResource("/employees.png")));
		btn_Menu_PaiementEmployer.setBackground(new Color(205, 133, 63));
		btn_Menu_PaiementEmployer.setBounds(534, 0, 165, 100);
		btn_Menu_PaiementEmployer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_Menu_Scolarite.setBackground(new Color(205, 133, 63));
				btn_Menu_Depense.setBackground(new Color(205, 133, 63));
				btn_Menu_PaiementProfesseur.setBackground(new Color(205, 133, 63));
				btn_Menu_PaiementEmployer.setBackground(new Color(240,240,240));
				btn_Menu_FraisInscription.setBackground(new Color(205, 133, 63));
				btn_Menu_VersementBancaire.setBackground(new Color(205, 133, 63));
				switchPanel(panel_PaiementEmployers);
			}
		});
		btn_Menu_PaiementEmployer.setMinimumSize(new Dimension(100, 100));
		btn_Menu_PaiementEmployer.setMaximumSize(new Dimension(100, 100));

		btn_Menu_FraisInscription = new JButton("Inscription");
		btn_Menu_FraisInscription.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Menu_FraisInscription.setIcon(new ImageIcon(IComptabilite.class.getResource("/inscription.png")));
		btn_Menu_FraisInscription.setBackground(new Color(205, 133, 63));
		btn_Menu_FraisInscription.setBounds(709, 0, 165, 100);
		btn_Menu_FraisInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_Menu_Scolarite.setBackground(new Color(205, 133, 63));
				btn_Menu_Depense.setBackground(new Color(205, 133, 63));
				btn_Menu_PaiementProfesseur.setBackground(new Color(205, 133, 63));
				btn_Menu_PaiementEmployer.setBackground(new Color(205, 133, 63));
				btn_Menu_FraisInscription.setBackground(new Color(240,240,240));
				btn_Menu_VersementBancaire.setBackground(new Color(205, 133, 63));
				switchPanel(panel_FraisInscription);
			}
		});
		btn_Menu_FraisInscription.setMinimumSize(new Dimension(100, 100));
		btn_Menu_FraisInscription.setMaximumSize(new Dimension(100, 100));

		btn_Menu_VersementBancaire = new JButton("Versement");
		btn_Menu_VersementBancaire.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Menu_VersementBancaire.setIcon(new ImageIcon(IComptabilite.class.getResource("/bank.png")));
		btn_Menu_VersementBancaire.setBackground(new Color(205, 133, 63));
		btn_Menu_VersementBancaire.setBounds(884, 0, 165, 100);
		btn_Menu_VersementBancaire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_Menu_Scolarite.setBackground(new Color(205, 133, 63));
				btn_Menu_Depense.setBackground(new Color(205, 133, 63));
				btn_Menu_PaiementProfesseur.setBackground(new Color(205, 133, 63));
				btn_Menu_PaiementEmployer.setBackground(new Color(205, 133, 63));
				btn_Menu_FraisInscription.setBackground(new Color(205, 133, 63));
				btn_Menu_VersementBancaire.setBackground(new Color(240,240,240));
				switchPanel(panel_VersementBancaire);
			}
		});
		btn_Menu_VersementBancaire.setMinimumSize(new Dimension(100, 100));
		btn_Menu_VersementBancaire.setMaximumSize(new Dimension(100, 100));
		panel_MenuPrincipal.setLayout(null);
		panel_MenuPrincipal.add(btn_Menu_Depense);
		panel_MenuPrincipal.add(btn_Menu_Scolarite);
		panel_MenuPrincipal.add(btn_Menu_PaiementProfesseur);
		panel_MenuPrincipal.add(btn_Menu_PaiementEmployer);
		panel_MenuPrincipal.add(btn_Menu_FraisInscription);
		panel_MenuPrincipal.add(btn_Menu_VersementBancaire);

		panel_Dépenses = new JPanel();
		panel_Dépenses.setBackground(new Color(222, 184, 135));
		layeredPane.add(panel_Dépenses, "name_35638772037198");
		 String[]mois= {
				"tout","janv", "févr", "mars", "avr", "mai", "juin", "juil", "août", "sept", "oct", "nov", " déc"
			} ;
		comboBox_MoisDepense = new JComboBox(mois);

		JLabel lblRecherche = new JLabel("Mois : ");

		textField_MontantTotalDepense = new JTextField();
		textField_MontantTotalDepense.setEditable(false);
		textField_MontantTotalDepense.setColumns(10);

		JLabel lblNewLabel = new JLabel("Total : ");

		btn_SupprimerDepense = new JButton("Supprimer");
		btn_SupprimerDepense.setBackground(new Color(205, 133, 63));
		btn_SupprimerDepense.setIcon(new ImageIcon(IComptabilite.class.getResource("/delete.png")));

		btn_ModifierDepense = new JButton("Modifier");
		btn_ModifierDepense.setBackground(new Color(205, 133, 63));
		btn_ModifierDepense.setIcon(new ImageIcon(IComptabilite.class.getResource("/pencil2.png")));

		btn_AjouterDepense = new JButton("Ajouter");
		btn_AjouterDepense.setBackground(new Color(205, 133, 63));
		btn_AjouterDepense.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_AjouterDepense.setIcon(new ImageIcon(IComptabilite.class.getResource("/cart.png")));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		
		lbl_info_depense = new JLabel("Depenses | Comptable | NANA C\u00E9dric Bollky Arnauld");
		lbl_info_depense.setBackground(SystemColor.menu);
		lbl_info_depense.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
		lbl_info_depense.setFont(new Font("Eras Medium ITC", Font.PLAIN, 11));
		
		btnRechercher = new JButton("");
		btnRechercher.setIcon(new ImageIcon(IComptabilite.class.getResource("/loupe.png")));
		btnRechercher.setBackground(new Color(205, 133, 63));
		GroupLayout gl_panel_Dépenses = new GroupLayout(panel_Dépenses);
		gl_panel_Dépenses.setHorizontalGroup(
			gl_panel_Dépenses.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Dépenses.createSequentialGroup()
					.addGroup(gl_panel_Dépenses.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_Dépenses.createSequentialGroup()
							.addGap(10)
							.addComponent(lblRecherche, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBox_MoisDepense, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnRechercher)
							.addPreferredGap(ComponentPlacement.RELATED, 343, Short.MAX_VALUE)
							.addComponent(btn_AjouterDepense, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_ModifierDepense, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_SupprimerDepense, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_MontantTotalDepense, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_Dépenses.createSequentialGroup()
							.addContainerGap()
							.addComponent(lbl_info_depense, GroupLayout.DEFAULT_SIZE, 1088, Short.MAX_VALUE)))
					.addContainerGap())
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1108, Short.MAX_VALUE)
		);
		gl_panel_Dépenses.setVerticalGroup(
			gl_panel_Dépenses.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Dépenses.createSequentialGroup()
					.addContainerGap()
					.addComponent(lbl_info_depense, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_Dépenses.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_Dépenses.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblRecherche)
							.addComponent(comboBox_MoisDepense, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_Dépenses.createParallelGroup(Alignment.BASELINE)
							.addComponent(btn_SupprimerDepense, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel)
							.addComponent(textField_MontantTotalDepense, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_Dépenses.createParallelGroup(Alignment.BASELINE)
							.addComponent(btn_ModifierDepense, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addComponent(btn_AjouterDepense, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnRechercher))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE))
		);
		
				tableDepense = new JTable();
				tableDepense.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
				
				scrollPane.setViewportView(tableDepense);
				tableDepense.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null, null, null, null, null},
					},
					new String[] {
						"Id", "Montant", "Date", "Mois", "Mode de paiement", "Annee scolaire", "Motif"
					}
				) {
					Class[] columnTypes = new Class[] {
						String.class, String.class, String.class, String.class, String.class, String.class, String.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				tableDepense.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_Dépenses.setLayout(gl_panel_Dépenses);

		panel_PaiementScolarité = new JPanel();
		panel_PaiementScolarité.setBackground(new Color(222, 184, 135));
		layeredPane.add(panel_PaiementScolarité, "name_35649855587076");
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		lbl_info_scolarite = new JLabel("Paiement scolarite | Comptable | NANA C\u00E9dric Bollky Arnauld");
		lbl_info_scolarite.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
		lbl_info_scolarite.setFont(new Font("Eras Medium ITC", Font.PLAIN, 11));
		GroupLayout gl_panel_PaiementScolarité = new GroupLayout(panel_PaiementScolarité);
		gl_panel_PaiementScolarité.setHorizontalGroup(
			gl_panel_PaiementScolarité.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_PaiementScolarité.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_PaiementScolarité.createParallelGroup(Alignment.LEADING)
						.addComponent(tabbedPane)
						.addComponent(lbl_info_scolarite, GroupLayout.DEFAULT_SIZE, 1086, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_PaiementScolarité.setVerticalGroup(
			gl_panel_PaiementScolarité.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_PaiementScolarité.createSequentialGroup()
					.addContainerGap()
					.addComponent(lbl_info_scolarite, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(222, 184, 135));
		tabbedPane.addTab("Liste des \u00E9l\u00E8ves", null, panel, null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
				tableListeEleve = new JTable();
				tableListeEleve.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

				ColorTable renderer = new ColorTable(); 
				tableListeEleve.setDefaultRenderer(Object.class, renderer);
				tableListeEleve.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Id", "Matricule", "Nom", "Prenom", "Classe", "Genre", "Scolarite", "1e tranche", "2e tranche", "3e tranche", "status"
					}
				) {
					Class[] columnTypes = new Class[] {
						String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				scrollPane_1.setViewportView(tableListeEleve);
				tableListeEleve.setAutoscrolls(true);
				tableListeEleve.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
				
						btn_Scolarite_NouveauPaiement = new JButton("Payer scolarit\u00E9");
						btn_Scolarite_NouveauPaiement.setIcon(new ImageIcon(IComptabilite.class.getResource("/money.png")));
						btn_Scolarite_NouveauPaiement.setBackground(new Color(205, 133, 63));
						
						textFieldRechercherEleve = new JTextField();
						textFieldRechercherEleve.setColumns(10);
						
						JLabel lblNewLabel_1_3 = new JLabel("Recherche : ");
						
						JLabel lblNewLabel_2_3 = new JLabel("Trier par : ");
						
						String tri []= {"croissant","decroissant"};
						comboBox_Scolarite_TrierPar_listeEleve = new JComboBox(tri);
						
						buttonRechercherEleve = new JButton("");
						buttonRechercherEleve.setIcon(new ImageIcon(IComptabilite.class.getResource("/loupe.png")));
						buttonRechercherEleve.setBackground(new Color(205, 133, 63));
						buttonRechercherEleve.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
							}
						});
						
						button_TrierPar_listeEleve = new JButton("");
						button_TrierPar_listeEleve.setIcon(new ImageIcon(IComptabilite.class.getResource("/fleche.png")));
						button_TrierPar_listeEleve.setBackground(new Color(205, 133, 63));
						
						btn_details = new JButton("Details");
						btn_details.setIcon(new ImageIcon(IComptabilite.class.getResource("/information.png")));
						btn_details.setBackground(new Color(205, 133, 63));
						
						btn_PayerExtra = new JButton("Payer extra");
						btn_PayerExtra.setIcon(new ImageIcon(IComptabilite.class.getResource("/coin.png")));
						btn_PayerExtra.setBackground(new Color(205, 133, 63));
						GroupLayout gl_panel = new GroupLayout(panel);
						gl_panel.setHorizontalGroup(
							gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(10)
									.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldRechercherEleve, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(buttonRechercherEleve)
									.addGap(18)
									.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox_Scolarite_TrierPar_listeEleve, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(button_TrierPar_listeEleve, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
									.addComponent(btn_Scolarite_NouveauPaiement)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btn_PayerExtra)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btn_details, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
								.addComponent(scrollPane_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1083, Short.MAX_VALUE)
						);
						gl_panel.setVerticalGroup(
							gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(11)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
											.addComponent(btn_PayerExtra, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
											.addComponent(btn_Scolarite_NouveauPaiement, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
											.addComponent(btn_details, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(3)
											.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblNewLabel_1_3)
												.addComponent(textFieldRechercherEleve, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(buttonRechercherEleve)
												.addComponent(lblNewLabel_2_3)
												.addComponent(comboBox_Scolarite_TrierPar_listeEleve, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(button_TrierPar_listeEleve))))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
						);
						panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(222, 184, 135));
		tabbedPane.addTab("Paiements de scolarit\u00E9", null, panel_1, null);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		
				tableListePaiementScolarite = new JTable();
				tableListePaiementScolarite.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				tableListePaiementScolarite.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Id", "Montant", "Date", "Recu N\u00B0", "Matricule", "Nom", "Prenom", "Classe", "Annee scolaire", "Mode de paiement", "Scolarite", "Tranche", "Observation", "Libelle", "Paiement N\u00B0"
					}
				) {
					Class[] columnTypes = new Class[] {
						String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				scrollPane_1_1.setViewportView(tableListePaiementScolarite);
				tableListePaiementScolarite.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
				tableListePaiementScolarite.setAutoscrolls(true);
										
												btn_Scolarite_SupprimerPaiement = new JButton("Supprimer paiement");
												btn_Scolarite_SupprimerPaiement.setIcon(new ImageIcon(IComptabilite.class.getResource("/delete.png")));
												btn_Scolarite_SupprimerPaiement.setBackground(new Color(205, 133, 63));
												
														btn_Scolarite_ModifierPaiement = new JButton("Modifier paiement");
														btn_Scolarite_ModifierPaiement.setIcon(new ImageIcon(IComptabilite.class.getResource("/pencil2.png")));
														btn_Scolarite_ModifierPaiement.setBackground(new Color(205, 133, 63));
														
																btn_Scolarite_Recu = new JButton("Recu");
																btn_Scolarite_Recu.setIcon(new ImageIcon(IComptabilite.class.getResource("/bill.png")));
																btn_Scolarite_Recu.setBackground(new Color(205, 133, 63));
																
																String classe []= {"Toutes","6eme","5eme","4eme","3eme"};
																comboBox_Scolarite_TrierPar_listePaiement = new JComboBox(classe);
																
																JLabel lblNewLabel_2_2 = new JLabel("Trier par : ");
																
																textFieldRechercherRecu = new JTextField();
																textFieldRechercherRecu.setColumns(10);
																
																JLabel lblNewLabel_1_2 = new JLabel("Recherche : ");
																
															   buttonRechercherRecu = new JButton("");
															   buttonRechercherRecu.setIcon(new ImageIcon(IComptabilite.class.getResource("/loupe.png")));
															   buttonRechercherRecu.setBackground(new Color(205, 133, 63));
																
																buttonTrierParRecu = new JButton("");
																buttonTrierParRecu.setIcon(new ImageIcon(IComptabilite.class.getResource("/fleche.png")));
																buttonTrierParRecu.setBackground(new Color(205, 133, 63));
																
															
																GroupLayout gl_panel_1 = new GroupLayout(panel_1);
																gl_panel_1.setHorizontalGroup(
																	gl_panel_1.createParallelGroup(Alignment.TRAILING)
																		.addGroup(gl_panel_1.createSequentialGroup()
																			.addContainerGap()
																			.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
																			.addPreferredGap(ComponentPlacement.RELATED)
																			.addComponent(textFieldRechercherRecu, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
																			.addPreferredGap(ComponentPlacement.RELATED)
																			.addComponent(buttonRechercherRecu)
																			.addGap(16)
																			.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
																			.addPreferredGap(ComponentPlacement.RELATED)
																			.addComponent(comboBox_Scolarite_TrierPar_listePaiement, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
																			.addPreferredGap(ComponentPlacement.RELATED)
																			.addComponent(buttonTrierParRecu)
																			.addPreferredGap(ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
																			.addComponent(btn_Scolarite_Recu, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
																			.addPreferredGap(ComponentPlacement.RELATED)
																			.addComponent(btn_Scolarite_ModifierPaiement, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
																			.addPreferredGap(ComponentPlacement.RELATED)
																			.addComponent(btn_Scolarite_SupprimerPaiement, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
																			.addContainerGap())
																		.addComponent(scrollPane_1_1, GroupLayout.DEFAULT_SIZE, 1083, Short.MAX_VALUE)
																);
																gl_panel_1.setVerticalGroup(
																	gl_panel_1.createParallelGroup(Alignment.LEADING)
																		.addGroup(gl_panel_1.createSequentialGroup()
																			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
																				.addGroup(gl_panel_1.createSequentialGroup()
																					.addGap(13)
																					.addComponent(btn_Scolarite_ModifierPaiement, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
																				.addGroup(gl_panel_1.createSequentialGroup()
																					.addGap(12)
																					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
																						.addComponent(btn_Scolarite_SupprimerPaiement, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
																						.addComponent(btn_Scolarite_Recu, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
																						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
																							.addComponent(lblNewLabel_1_2)
																							.addComponent(textFieldRechercherRecu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																							.addComponent(lblNewLabel_2_2)
																							.addComponent(buttonRechercherRecu)
																							.addComponent(comboBox_Scolarite_TrierPar_listePaiement, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																							.addComponent(buttonTrierParRecu)))))
																			.addPreferredGap(ComponentPlacement.UNRELATED)
																			.addComponent(scrollPane_1_1, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
																);
																panel_1.setLayout(gl_panel_1);
																
																panel_7 = new JPanel();
																panel_7.setBackground(new Color(222, 184, 135));
																tabbedPane.addTab("Paiements auxiliaires", null, panel_7, null);
																
																scrollPane_8 = new JScrollPane();
																
																btn_SupprimerPaiementAuxiliaire = new JButton("Supprimer");
																btn_SupprimerPaiementAuxiliaire.setIcon(new ImageIcon(IComptabilite.class.getResource("/delete.png")));
																btn_SupprimerPaiementAuxiliaire.setBackground(new Color(205, 133, 63));
																
																btn_ModifierPaiementAuxiliaire = new JButton("Modifier");
																btn_ModifierPaiementAuxiliaire.setIcon(new ImageIcon(IComptabilite.class.getResource("/pencil2.png")));
																btn_ModifierPaiementAuxiliaire.setBackground(new Color(205, 133, 63));
																
																btnRecuPaiementAuxiliaire = new JButton("Re\u00E7u");
																btnRecuPaiementAuxiliaire.setIcon(new ImageIcon(IComptabilite.class.getResource("/bill.png")));
																btnRecuPaiementAuxiliaire.setBackground(new Color(205, 133, 63));
																GroupLayout gl_panel_7 = new GroupLayout(panel_7);
																gl_panel_7.setHorizontalGroup(
																	gl_panel_7.createParallelGroup(Alignment.TRAILING)
																		.addComponent(scrollPane_8, GroupLayout.DEFAULT_SIZE, 1083, Short.MAX_VALUE)
																		.addGroup(gl_panel_7.createSequentialGroup()
																			.addContainerGap(820, Short.MAX_VALUE)
																			.addComponent(btnRecuPaiementAuxiliaire)
																			.addPreferredGap(ComponentPlacement.RELATED)
																			.addComponent(btn_ModifierPaiementAuxiliaire)
																			.addPreferredGap(ComponentPlacement.RELATED)
																			.addComponent(btn_SupprimerPaiementAuxiliaire)
																			.addContainerGap())
																);
																gl_panel_7.setVerticalGroup(
																	gl_panel_7.createParallelGroup(Alignment.TRAILING)
																		.addGroup(gl_panel_7.createSequentialGroup()
																			.addContainerGap()
																			.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
																				.addComponent(btn_SupprimerPaiementAuxiliaire)
																				.addComponent(btn_ModifierPaiementAuxiliaire)
																				.addComponent(btnRecuPaiementAuxiliaire))
																			.addGap(13)
																			.addComponent(scrollPane_8, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE))
																);
																
																table_Auxiliaire = new JTable();
																table_Auxiliaire.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																table_Auxiliaire.setModel(new DefaultTableModel(
																	new Object[][] {
																	},
																	new String[] {
																		"Id", "Matricule", "Nom", "Prenom", "Classe", "Statut", "Montant", "Description", "Commentaire"
																	}
																) {
																	Class[] columnTypes = new Class[] {
																		String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
																	};
																	public Class getColumnClass(int columnIndex) {
																		return columnTypes[columnIndex];
																	}
																});
																table_Auxiliaire.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
																table_Auxiliaire.setAutoscrolls(true);
																scrollPane_8.setViewportView(table_Auxiliaire);
																panel_7.setLayout(gl_panel_7);
		panel_PaiementScolarité.setLayout(gl_panel_PaiementScolarité);

		panel_PaiementProfesseurs = new JPanel();
		panel_PaiementProfesseurs.setBackground(new Color(222, 184, 135));
		layeredPane.add(panel_PaiementProfesseurs, "name_5457225254585");
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		
		lbl_info_professeur = new JLabel("Paiement professeur | Comptable | NANA C\u00E9dric Bollky Arnauld");
		lbl_info_professeur.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
		lbl_info_professeur.setFont(new Font("Eras Medium ITC", Font.PLAIN, 11));
		GroupLayout gl_panel_PaiementProfesseurs = new GroupLayout(panel_PaiementProfesseurs);
		gl_panel_PaiementProfesseurs.setHorizontalGroup(
			gl_panel_PaiementProfesseurs.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_PaiementProfesseurs.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_PaiementProfesseurs.createParallelGroup(Alignment.TRAILING)
						.addComponent(tabbedPane_1, Alignment.LEADING)
						.addComponent(lbl_info_professeur, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1088, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_PaiementProfesseurs.setVerticalGroup(
			gl_panel_PaiementProfesseurs.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_PaiementProfesseurs.createSequentialGroup()
					.addContainerGap()
					.addComponent(lbl_info_professeur, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(tabbedPane_1, GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(222, 184, 135));
		tabbedPane_1.addTab("Liste des professeurs", null, panel_2, null);
		
		JScrollPane scrollPane_1_2 = new JScrollPane();
				

				table_listeProfesseur = new JTable();
				table_listeProfesseur.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				table_listeProfesseur.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Id", "Nom", "Prenom", "Type", "Classe", "Matiere", "Matricule"
					}
				) {
					Class[] columnTypes = new Class[] {
						String.class, String.class, String.class, String.class, String.class, String.class, String.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				table_listeProfesseur.getColumnModel().getColumn(0).setResizable(false);
				table_listeProfesseur.getColumnModel().getColumn(0).setPreferredWidth(25);
				scrollPane_1_2.setViewportView(table_listeProfesseur);
				table_listeProfesseur.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
				table_listeProfesseur.setAutoscrolls(true);

				
						btn_PaiementProfesseur_PayerSalaire = new JButton("Payer salaire");
						btn_PaiementProfesseur_PayerSalaire.setIcon(new ImageIcon(IComptabilite.class.getResource("/money.png")));
						btn_PaiementProfesseur_PayerSalaire.setBackground(new Color(205, 133, 63));
						
								btn_PaiementProfesseur_BulletinDeSalaire = new JButton("Bulletin de salaire");
								btn_PaiementProfesseur_BulletinDeSalaire.setIcon(new ImageIcon(IComptabilite.class.getResource("/receipt.png")));
								btn_PaiementProfesseur_BulletinDeSalaire.setBackground(new Color(205, 133, 63));
								
								textField_rechercheProfesseur = new JTextField();
								textField_rechercheProfesseur.setColumns(10);
								
								JLabel lblNewLabel_2_1_1_1 = new JLabel("Trier par : ");
								
								String prof [] = {"classe","matiere"};
								comboBox_PaiementProfesseur_TrierPar_listeProfesseur = new JComboBox(prof);
								
								JLabel lblNewLabel_1_1_1_1 = new JLabel("Recherche : ");
								
								buttonLancerRechercheProf = new JButton("");
								buttonLancerRechercheProf.setIcon(new ImageIcon(IComptabilite.class.getResource("/loupe.png")));
								buttonLancerRechercheProf.setBackground(new Color(205, 133, 63));
								
								buttonTriProf = new JButton("");
								buttonTriProf.setIcon(new ImageIcon(IComptabilite.class.getResource("/fleche.png")));
								buttonTriProf.setBackground(new Color(205, 133, 63));
								GroupLayout gl_panel_2 = new GroupLayout(panel_2);
								gl_panel_2.setHorizontalGroup(
									gl_panel_2.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel_2.createSequentialGroup()
											.addGap(10)
											.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(textField_rechercheProfesseur, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(buttonLancerRechercheProf)
											.addGap(30)
											.addComponent(lblNewLabel_2_1_1_1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(comboBox_PaiementProfesseur_TrierPar_listeProfesseur, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(buttonTriProf)
											.addPreferredGap(ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
											.addComponent(btn_PaiementProfesseur_PayerSalaire, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btn_PaiementProfesseur_BulletinDeSalaire, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
											.addGap(10))
										.addComponent(scrollPane_1_2, GroupLayout.DEFAULT_SIZE, 1083, Short.MAX_VALUE)
								);
								gl_panel_2.setVerticalGroup(
									gl_panel_2.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_2.createSequentialGroup()
											.addContainerGap()
											.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel_2.createSequentialGroup()
													.addGap(3)
													.addComponent(lblNewLabel_1_1_1_1))
												.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
													.addComponent(textField_rechercheProfesseur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addComponent(buttonLancerRechercheProf)
													.addComponent(comboBox_PaiementProfesseur_TrierPar_listeProfesseur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addComponent(buttonTriProf)
													.addComponent(lblNewLabel_2_1_1_1))
												.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
													.addComponent(btn_PaiementProfesseur_BulletinDeSalaire, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
													.addComponent(btn_PaiementProfesseur_PayerSalaire, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(scrollPane_1_2, GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE))
								);
								panel_2.setLayout(gl_panel_2);
						btn_PaiementProfesseur_PayerSalaire.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
							}
						});
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(222, 184, 135));
		tabbedPane_1.addTab("Paiements des professeurs", null, panel_3, null);
		
		JScrollPane scrollPane_1_3 = new JScrollPane();
		
				table_listePaiementProfesseur = new JTable();
				table_listePaiementProfesseur.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				table_listePaiementProfesseur.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null, null, null, null, null, null, null, null, "", null, null},
					},
					new String[] {
						"Id", "Nom", "Prenom", "Classe", "Matiere", "Montant", "type", "nombre heure", "prix horaire", "montant total", "mois", "mode paiement", "date paiement"
					}
				) {
					Class[] columnTypes = new Class[] {
						String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Object.class, Object.class, Object.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				table_listePaiementProfesseur.getColumnModel().getColumn(0).setResizable(false);
				table_listePaiementProfesseur.getColumnModel().getColumn(0).setPreferredWidth(21);
				scrollPane_1_3.setViewportView(table_listePaiementProfesseur);
				table_listePaiementProfesseur.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
				table_listePaiementProfesseur.setAutoscrolls(true);
				
						btn_PaiementProfesseur_SupprimerPaiement = new JButton("Supprimer paiement");
						btn_PaiementProfesseur_SupprimerPaiement.setIcon(new ImageIcon(IComptabilite.class.getResource("/delete.png")));
						btn_PaiementProfesseur_SupprimerPaiement.setBackground(new Color(205, 133, 63));
						
								btn_PaiementProfesseur_ModifierPaiement = new JButton("Modifier paiement ");
								btn_PaiementProfesseur_ModifierPaiement.setIcon(new ImageIcon(IComptabilite.class.getResource("/pencil2.png")));
								btn_PaiementProfesseur_ModifierPaiement.setBackground(new Color(205, 133, 63));
								
										textField_PaiementProfesseur_RechercheProfesseur = new JTextField();
										textField_PaiementProfesseur_RechercheProfesseur.setColumns(10);
										
												JLabel lblNewLabel_1_1_1 = new JLabel("Recherche : ");
												
														JLabel lblNewLabel_2_1_1 = new JLabel("Trier par : ");
														
														        String moi[] = {"mois","type"};
																comboBox_PaiementProfesseur_TrierPar_listePaiementProfesseur = new JComboBox(moi);
																
																buttonRechercherPaiementProf = new JButton("");
																buttonRechercherPaiementProf.setIcon(new ImageIcon(IComptabilite.class.getResource("/loupe.png")));
																buttonRechercherPaiementProf.setBackground(new Color(205, 133, 63));
																
																buttonTriPaiementProf = new JButton("");
																buttonTriPaiementProf.setIcon(new ImageIcon(IComptabilite.class.getResource("/fleche.png")));
																buttonTriPaiementProf.setBackground(new Color(205, 133, 63));
																GroupLayout gl_panel_3 = new GroupLayout(panel_3);
																gl_panel_3.setHorizontalGroup(
																	gl_panel_3.createParallelGroup(Alignment.TRAILING)
																		.addGroup(gl_panel_3.createSequentialGroup()
																			.addGap(10)
																			.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
																			.addPreferredGap(ComponentPlacement.RELATED)
																			.addComponent(textField_PaiementProfesseur_RechercheProfesseur, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
																			.addPreferredGap(ComponentPlacement.RELATED)
																			.addComponent(buttonRechercherPaiementProf)
																			.addGap(50)
																			.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
																			.addPreferredGap(ComponentPlacement.RELATED)
																			.addComponent(comboBox_PaiementProfesseur_TrierPar_listePaiementProfesseur, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
																			.addPreferredGap(ComponentPlacement.RELATED)
																			.addComponent(buttonTriPaiementProf)
																			.addPreferredGap(ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
																			.addComponent(btn_PaiementProfesseur_ModifierPaiement)
																			.addGap(10)
																			.addComponent(btn_PaiementProfesseur_SupprimerPaiement)
																			.addGap(10))
																		.addComponent(scrollPane_1_3, GroupLayout.DEFAULT_SIZE, 1083, Short.MAX_VALUE)
																);
																gl_panel_3.setVerticalGroup(
																	gl_panel_3.createParallelGroup(Alignment.LEADING)
																		.addGroup(gl_panel_3.createSequentialGroup()
																			.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
																				.addGroup(gl_panel_3.createSequentialGroup()
																					.addGap(11)
																					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
																						.addGroup(gl_panel_3.createSequentialGroup()
																							.addGap(3)
																							.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
																								.addComponent(lblNewLabel_1_1_1)
																								.addComponent(textField_PaiementProfesseur_RechercheProfesseur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
																						.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
																							.addComponent(buttonRechercherPaiementProf)
																							.addComponent(comboBox_PaiementProfesseur_TrierPar_listePaiementProfesseur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																							.addComponent(buttonTriPaiementProf)
																							.addComponent(lblNewLabel_2_1_1))
																						.addComponent(btn_PaiementProfesseur_SupprimerPaiement, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
																				.addGroup(gl_panel_3.createSequentialGroup()
																					.addGap(12)
																					.addComponent(btn_PaiementProfesseur_ModifierPaiement, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
																			.addPreferredGap(ComponentPlacement.UNRELATED)
																			.addComponent(scrollPane_1_3, GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE))
																);
																panel_3.setLayout(gl_panel_3);
																
																panel_6 = new JPanel();
																panel_6.setBackground(new Color(222, 184, 135));
																tabbedPane_1.addTab("R\u00E9sum\u00E9", null, panel_6, null);
																
																JScrollPane scrollPane_7 = new JScrollPane();
																
																table_resumePaiementProfesseur = new JTable();
																table_resumePaiementProfesseur.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																table_resumePaiementProfesseur.setModel(new DefaultTableModel(
																	new Object[][] {
																	},
																	new String[] {
																		"Nom", "Prenom", "Montant", "Type", "Mois", "Matricule"
																	}
																) {
																	Class[] columnTypes = new Class[] {
																		String.class, String.class, String.class, String.class, String.class, String.class
																	};
																	public Class getColumnClass(int columnIndex) {
																		return columnTypes[columnIndex];
																	}
																});
																scrollPane_7.setViewportView(table_resumePaiementProfesseur);
																
																textField_total_Resume_PaiementProfesseur = new JTextField();
																textField_total_Resume_PaiementProfesseur.setEditable(false);
																textField_total_Resume_PaiementProfesseur.setColumns(10);
																
																lblNewLabel_1 = new JLabel("Total :");
																
																btn_recuPaiementProfesseur = new JButton("Re\u00E7u");
																btn_recuPaiementProfesseur.setIcon(new ImageIcon(IComptabilite.class.getResource("/bill.png")));
																btn_recuPaiementProfesseur.setBackground(new Color(205, 133, 63));
																GroupLayout gl_panel_6 = new GroupLayout(panel_6);
																gl_panel_6.setHorizontalGroup(
																	gl_panel_6.createParallelGroup(Alignment.TRAILING)
																		.addComponent(scrollPane_7, GroupLayout.DEFAULT_SIZE, 1083, Short.MAX_VALUE)
																		.addGroup(gl_panel_6.createSequentialGroup()
																			.addGap(718)
																			.addComponent(btn_recuPaiementProfesseur)
																			.addGap(55)
																			.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
																			.addPreferredGap(ComponentPlacement.RELATED)
																			.addComponent(textField_total_Resume_PaiementProfesseur, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
																			.addGap(10))
																);
																gl_panel_6.setVerticalGroup(
																	gl_panel_6.createParallelGroup(Alignment.LEADING)
																		.addGroup(gl_panel_6.createSequentialGroup()
																			.addContainerGap()
																			.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
																				.addComponent(textField_total_Resume_PaiementProfesseur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																				.addComponent(lblNewLabel_1)
																				.addComponent(btn_recuPaiementProfesseur))
																			.addGap(10)
																			.addComponent(scrollPane_7, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE))
																);
																panel_6.setLayout(gl_panel_6);
		panel_PaiementProfesseurs.setLayout(gl_panel_PaiementProfesseurs);

		panel_PaiementEmployers = new JPanel();
		panel_PaiementEmployers.setBackground(new Color(222, 184, 135));
		layeredPane.add(panel_PaiementEmployers, "name_5473431228916");
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		
		lbl_info_employer = new JLabel("Paiement employers | Comptable | NANA C\u00E9dric Bollky Arnauld");
		lbl_info_employer.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
		lbl_info_employer.setFont(new Font("Eras Medium ITC", Font.PLAIN, 11));
		GroupLayout gl_panel_PaiementEmployers = new GroupLayout(panel_PaiementEmployers);
		gl_panel_PaiementEmployers.setHorizontalGroup(
			gl_panel_PaiementEmployers.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_PaiementEmployers.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_PaiementEmployers.createParallelGroup(Alignment.LEADING)
						.addComponent(tabbedPane_2)
						.addComponent(lbl_info_employer, GroupLayout.DEFAULT_SIZE, 1086, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_PaiementEmployers.setVerticalGroup(
			gl_panel_PaiementEmployers.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_PaiementEmployers.createSequentialGroup()
					.addContainerGap()
					.addComponent(lbl_info_employer, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tabbedPane_2, GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(222, 184, 135));
		tabbedPane_2.addTab("Liste des employers", null, panel_4, null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
				table_listeEmployer = new JTable();
				table_listeEmployer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				table_listeEmployer.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null, null},
					},
					new String[] {
						"Id", "Nom", "Prenom", "Poste"
					}
				) {
					Class[] columnTypes = new Class[] {
						String.class, String.class, String.class, String.class
					};
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
				table_listeEmployer.getColumnModel().getColumn(0).setPreferredWidth(15);
				scrollPane_2.setViewportView(table_listeEmployer);
				table_listeEmployer.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
				table_listeEmployer.setAutoscrolls(true);
		
				btn_PaiementEmployer_PayerSalaire = new JButton("Payer salaire");
				btn_PaiementEmployer_PayerSalaire.setIcon(new ImageIcon(IComptabilite.class.getResource("/money.png")));
				btn_PaiementEmployer_PayerSalaire.setBackground(new Color(205, 133, 63));
		
				btn_PaiementEmployer_BulletinSalaire = new JButton("Bulletin de salaire");
				btn_PaiementEmployer_BulletinSalaire.setIcon(new ImageIcon(IComptabilite.class.getResource("/receipt.png")));
				btn_PaiementEmployer_BulletinSalaire.setBackground(new Color(205, 133, 63));
		
		textField_rechercheEmployer_listeEmployer = new JTextField();
		textField_rechercheEmployer_listeEmployer.setColumns(10);
		
		lblNewLabel_2_1_2 = new JLabel("Trier par : ");
		
		String texte[]= {"nom","prenom"};
		comboBox_PaiementEmployer_TrierPar_listeEmployer = new JComboBox(texte);
		
		lblNewLabel_1_1_2 = new JLabel("Recherche : ");
		
		buttonRechercherEmployer = new JButton("");
		buttonRechercherEmployer.setIcon(new ImageIcon(IComptabilite.class.getResource("/loupe.png")));
		buttonRechercherEmployer.setBackground(new Color(205, 133, 63));
		
		buttonTriEmployer = new JButton("");
		buttonTriEmployer.setIcon(new ImageIcon(IComptabilite.class.getResource("/fleche.png")));
		buttonTriEmployer.setBackground(new Color(205, 133, 63));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1_1_2, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_rechercheEmployer_listeEmployer, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonRechercherEmployer)
					.addGap(44)
					.addComponent(lblNewLabel_2_1_2, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox_PaiementEmployer_TrierPar_listeEmployer, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonTriEmployer)
					.addPreferredGap(ComponentPlacement.RELATED, 278, Short.MAX_VALUE)
					.addComponent(btn_PaiementEmployer_PayerSalaire)
					.addGap(10)
					.addComponent(btn_PaiementEmployer_BulletinSalaire)
					.addContainerGap())
				.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 1083, Short.MAX_VALUE)
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addContainerGap()
							.addComponent(btn_PaiementEmployer_BulletinSalaire, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(12)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btn_PaiementEmployer_PayerSalaire, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblNewLabel_1_1_2)
									.addComponent(textField_rechercheEmployer_listeEmployer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(buttonRechercherEmployer)
									.addComponent(lblNewLabel_2_1_2)
									.addComponent(comboBox_PaiementEmployer_TrierPar_listeEmployer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(buttonTriEmployer)))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(222, 184, 135));
		tabbedPane_2.addTab("Paiements des employers", null, panel_5, null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		
				table_listePaiementEmployer = new JTable();
				table_listePaiementEmployer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				table_listePaiementEmployer.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null, null, null, null, null, null},
					},
					new String[] {
						"Id", "Montant", "Date", "Mois", "Poste", "Nom", "Prenom", "Mode de paiement"
					}
				) {
					Class[] columnTypes = new Class[] {
						String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				table_listePaiementEmployer.getColumnModel().getColumn(0).setResizable(false);
				table_listePaiementEmployer.getColumnModel().getColumn(0).setPreferredWidth(28);
				scrollPane_3.setViewportView(table_listePaiementEmployer);
				table_listePaiementEmployer.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
				table_listePaiementEmployer.setAutoscrolls(true);
		
		textField_recherchePaiementEmployer = new JTextField();
		textField_recherchePaiementEmployer.setColumns(10);
		
		lblNewLabel_2_1_3 = new JLabel("Trier par : ");
		
		String text[]= {"mois","nom","prenom"};
		comboBox_PaiementEmployer_TrierPar_listePaiementEmployer = new JComboBox(text);
		
		lblNewLabel_1_1_3 = new JLabel("Recherche : ");
		
				btn_PaiementEmployer_SupprimerPaiement = new JButton("Supprimer paiement");
				btn_PaiementEmployer_SupprimerPaiement.setIcon(new ImageIcon(IComptabilite.class.getResource("/delete.png")));
				btn_PaiementEmployer_SupprimerPaiement.setBackground(new Color(205, 133, 63));
		
				btn_PaiementEmployer_ModifierPaiement = new JButton("Modifier paiement ");
				btn_PaiementEmployer_ModifierPaiement.setIcon(new ImageIcon(IComptabilite.class.getResource("/pencil2.png")));
				btn_PaiementEmployer_ModifierPaiement.setBackground(new Color(205, 133, 63));
		
		buttonRechercherEmployerPaiement = new JButton("");
		buttonRechercherEmployerPaiement.setIcon(new ImageIcon(IComptabilite.class.getResource("/loupe.png")));
		buttonRechercherEmployerPaiement.setBackground(new Color(205, 133, 63));
		buttonRechercherEmployerPaiement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		buttonTrierPaiementEmployer = new JButton("");
		buttonTrierPaiementEmployer.setIcon(new ImageIcon(IComptabilite.class.getResource("/fleche.png")));
		buttonTrierPaiementEmployer.setBackground(new Color(205, 133, 63));
		
		btn_recuPaiementEmployer = new JButton("Re\u00E7u");
		btn_recuPaiementEmployer.setIcon(new ImageIcon(IComptabilite.class.getResource("/bill.png")));
		btn_recuPaiementEmployer.setBackground(new Color(205, 133, 63));
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1_1_3, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_recherchePaiementEmployer, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(buttonRechercherEmployerPaiement)
					.addGap(18)
					.addComponent(lblNewLabel_2_1_3, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox_PaiementEmployer_TrierPar_listePaiementEmployer, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonTrierPaiementEmployer)
					.addPreferredGap(ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
					.addComponent(btn_recuPaiementEmployer)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btn_PaiementEmployer_ModifierPaiement, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btn_PaiementEmployer_SupprimerPaiement, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 1083, Short.MAX_VALUE)
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1_1_3)
								.addComponent(textField_recherchePaiementEmployer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(buttonRechercherEmployerPaiement)
								.addComponent(lblNewLabel_2_1_3)
								.addComponent(comboBox_PaiementEmployer_TrierPar_listePaiementEmployer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(buttonTrierPaiementEmployer))
							.addGroup(gl_panel_5.createSequentialGroup()
								.addGap(1)
								.addComponent(btn_PaiementEmployer_ModifierPaiement))
							.addComponent(btn_recuPaiementEmployer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(btn_PaiementEmployer_SupprimerPaiement))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE))
		);
		panel_5.setLayout(gl_panel_5);
		panel_PaiementEmployers.setLayout(gl_panel_PaiementEmployers);

		panel_FraisInscription = new JPanel();
		panel_FraisInscription.setBackground(new Color(222, 184, 135));
		layeredPane.add(panel_FraisInscription, "name_5482220857680");
		
		tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		
		lbl_info_inscription = new JLabel("Frais d'inscription | Comptable | NANA C\u00E9dric Bollky Arnauld");
		lbl_info_inscription.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
		lbl_info_inscription.setFont(new Font("Eras Medium ITC", Font.PLAIN, 11));
		GroupLayout gl_panel_FraisInscription = new GroupLayout(panel_FraisInscription);
		gl_panel_FraisInscription.setHorizontalGroup(
			gl_panel_FraisInscription.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_FraisInscription.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_FraisInscription.createParallelGroup(Alignment.LEADING)
						.addComponent(tabbedPane_3)
						.addComponent(lbl_info_inscription, GroupLayout.DEFAULT_SIZE, 1086, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_FraisInscription.setVerticalGroup(
			gl_panel_FraisInscription.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_FraisInscription.createSequentialGroup()
					.addContainerGap()
					.addComponent(lbl_info_inscription, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tabbedPane_3, GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		panel_ListeDesEleves = new JPanel();
		panel_ListeDesEleves.setBackground(new Color(222, 184, 135));
		tabbedPane_3.addTab("Liste des \u00E9l\u00E8ves", null, panel_ListeDesEleves, null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		
				table_listeEleve_FraisInscription = new JTable();
				table_listeEleve_FraisInscription.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				table_listeEleve_FraisInscription.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null, null, null, null, null},
					},
					new String[] {
						"Id", "Matricule", "Nom", "Prenom", "Classe", "Genre", "Statut"
					}
				) {
					Class[] columnTypes = new Class[] {
						String.class, String.class, String.class, String.class, String.class, String.class, String.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
					boolean[] columnEditables = new boolean[] {
						true, true, true, true, true, true, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				scrollPane_4.setViewportView(table_listeEleve_FraisInscription);
				table_listeEleve_FraisInscription.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
				table_listeEleve_FraisInscription.setAutoscrolls(true);
		
		textField_recherche_listeEleve_FraisInscription = new JTextField();
		textField_recherche_listeEleve_FraisInscription.setColumns(10);
		
		lblNewLabel_2_1_4 = new JLabel("Trier par : ");
		String eleve[]= {"nom","prenom","classe"};
		comboBox_FraisInscription_listeEleve_TrierPar = new JComboBox(eleve);
		
		lblNewLabel_1_1_4 = new JLabel("Recherche : ");
		
				btn_FraisInscription_AjouterFraisScolarite = new JButton("Ajouter paiement frais de scolarite");
				btn_FraisInscription_AjouterFraisScolarite.setIcon(new ImageIcon(IComptabilite.class.getResource("/coin.png")));
				btn_FraisInscription_AjouterFraisScolarite.setBackground(new Color(205, 133, 63));
		
		buttonrechercherEleveInscription = new JButton("");
		buttonrechercherEleveInscription.setIcon(new ImageIcon(IComptabilite.class.getResource("/loupe.png")));
		buttonrechercherEleveInscription.setBackground(new Color(205, 133, 63));
		
		buttonTriEleveInscription = new JButton("");
		buttonTriEleveInscription.setIcon(new ImageIcon(IComptabilite.class.getResource("/fleche.png")));
		buttonTriEleveInscription.setBackground(new Color(205, 133, 63));
		GroupLayout gl_panel_ListeDesEleves = new GroupLayout(panel_ListeDesEleves);
		gl_panel_ListeDesEleves.setHorizontalGroup(
			gl_panel_ListeDesEleves.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_ListeDesEleves.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1_1_4, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_recherche_listeEleve_FraisInscription, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonrechercherEleveInscription)
					.addGap(30)
					.addComponent(lblNewLabel_2_1_4, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox_FraisInscription_listeEleve_TrierPar, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonTriEleveInscription)
					.addPreferredGap(ComponentPlacement.RELATED, 324, Short.MAX_VALUE)
					.addComponent(btn_FraisInscription_AjouterFraisScolarite)
					.addContainerGap())
				.addComponent(scrollPane_4, GroupLayout.DEFAULT_SIZE, 1650, Short.MAX_VALUE)
		);
		gl_panel_ListeDesEleves.setVerticalGroup(
			gl_panel_ListeDesEleves.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_ListeDesEleves.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_ListeDesEleves.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_ListeDesEleves.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1_1_4)
							.addComponent(textField_recherche_listeEleve_FraisInscription, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_ListeDesEleves.createParallelGroup(Alignment.BASELINE)
							.addComponent(buttonrechercherEleveInscription)
							.addComponent(lblNewLabel_2_1_4)
							.addComponent(comboBox_FraisInscription_listeEleve_TrierPar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(buttonTriEleveInscription))
						.addComponent(btn_FraisInscription_AjouterFraisScolarite, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_4, GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
		);
		panel_ListeDesEleves.setLayout(gl_panel_ListeDesEleves);
		
		panel_FraisInscription_ = new JPanel();
		panel_FraisInscription_.setBackground(new Color(222, 184, 135));
		tabbedPane_3.addTab("Frais Inscription", null, panel_FraisInscription_, null);
		
		textField_rechercheFraisInscription = new JTextField();
		textField_rechercheFraisInscription.setColumns(10);
		
		lblNewLabel_2_1_5 = new JLabel("Trier par : ");
		
		String choix[]= {"date","nom","classe"};
		comboBox_FraisInscription_TrierPar_listeFraisInscription = new JComboBox(choix);
		
		lblNewLabel_1_1_5 = new JLabel("Recherche : ");
		
		JScrollPane scrollPane_5 = new JScrollPane();
		
				table_listePaiementFraisInscription = new JTable();
				table_listePaiementFraisInscription.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				table_listePaiementFraisInscription.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null, null, null, null, null, null},
					},
					new String[] {
						"Id", "Montant", "Date", "Matricule", "Nom", "Prenom", "Classe", "Mode de paiement"
					}
				) {
					Class[] columnTypes = new Class[] {
						String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
					boolean[] columnEditables = new boolean[] {
						true, true, true, true, true, true, true, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				scrollPane_5.setViewportView(table_listePaiementFraisInscription);
				table_listePaiementFraisInscription.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
				table_listePaiementFraisInscription.setAutoscrolls(true);
		
				btn_FraisInscription_SupprimerFraisScolarite = new JButton("Supprimer");
				btn_FraisInscription_SupprimerFraisScolarite.setIcon(new ImageIcon(IComptabilite.class.getResource("/delete.png")));
				btn_FraisInscription_SupprimerFraisScolarite.setBackground(new Color(205, 133, 63));
		
				btn_FraisInscription_ModifierFraisScolarite = new JButton("Modifier");
				btn_FraisInscription_ModifierFraisScolarite.setIcon(new ImageIcon(IComptabilite.class.getResource("/pencil2.png")));
				btn_FraisInscription_ModifierFraisScolarite.setBackground(new Color(205, 133, 63));
		
				btn_FraisInscription_Recu = new JButton("Recu");
				btn_FraisInscription_Recu.setIcon(new ImageIcon(IComptabilite.class.getResource("/bill.png")));
				btn_FraisInscription_Recu.setBackground(new Color(205, 133, 63));
		
		buttonRechercherFraisInscription = new JButton("");
		buttonRechercherFraisInscription.setIcon(new ImageIcon(IComptabilite.class.getResource("/loupe.png")));
		buttonRechercherFraisInscription.setBackground(new Color(205, 133, 63));
		
		buttonTriFraisInscription = new JButton("");
		buttonTriFraisInscription.setIcon(new ImageIcon(IComptabilite.class.getResource("/fleche.png")));
		buttonTriFraisInscription.setBackground(new Color(205, 133, 63));
		GroupLayout gl_panel_FraisInscription_ = new GroupLayout(panel_FraisInscription_);
		gl_panel_FraisInscription_.setHorizontalGroup(
			gl_panel_FraisInscription_.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_FraisInscription_.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1_1_5, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_rechercheFraisInscription, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonRechercherFraisInscription)
					.addGap(30)
					.addComponent(lblNewLabel_2_1_5, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox_FraisInscription_TrierPar_listeFraisInscription, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonTriFraisInscription)
					.addPreferredGap(ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
					.addComponent(btn_FraisInscription_Recu, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(btn_FraisInscription_ModifierFraisScolarite)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btn_FraisInscription_SupprimerFraisScolarite)
					.addContainerGap())
				.addComponent(scrollPane_5, GroupLayout.DEFAULT_SIZE, 1083, Short.MAX_VALUE)
		);
		gl_panel_FraisInscription_.setVerticalGroup(
			gl_panel_FraisInscription_.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_FraisInscription_.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_FraisInscription_.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_FraisInscription_.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
							.addComponent(btn_FraisInscription_Recu, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_FraisInscription_.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_panel_FraisInscription_.createSequentialGroup()
								.addGap(3)
								.addGroup(gl_panel_FraisInscription_.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblNewLabel_1_1_5)
									.addComponent(textField_rechercheFraisInscription, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(buttonRechercherFraisInscription)))
							.addGroup(gl_panel_FraisInscription_.createSequentialGroup()
								.addGap(3)
								.addGroup(gl_panel_FraisInscription_.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblNewLabel_2_1_5)
									.addComponent(comboBox_FraisInscription_TrierPar_listeFraisInscription, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(buttonTriFraisInscription)))
							.addComponent(btn_FraisInscription_ModifierFraisScolarite, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btn_FraisInscription_SupprimerFraisScolarite)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane_5, GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE))
		);
		panel_FraisInscription_.setLayout(gl_panel_FraisInscription_);
		panel_FraisInscription.setLayout(gl_panel_FraisInscription);

		panel_VersementBancaire = new JPanel();
		panel_VersementBancaire.setBackground(new Color(222, 184, 135));
		layeredPane.add(panel_VersementBancaire, "name_5496354010834");

		btn_VersementBancaire_Ajouter = new JButton("Ajouter un versement");
		btn_VersementBancaire_Ajouter.setIcon(new ImageIcon(IComptabilite.class.getResource("/transfer-money.png")));
		btn_VersementBancaire_Ajouter.setBackground(new Color(205, 133, 63));

		btn_VersementBancaire_Modifier = new JButton("Modifier un versement");
		btn_VersementBancaire_Modifier.setIcon(new ImageIcon(IComptabilite.class.getResource("/pencil2.png")));
		btn_VersementBancaire_Modifier.setBackground(new Color(205, 133, 63));

		btn_VersementBancaire_Supprimer = new JButton("Supprimer un versement");
		btn_VersementBancaire_Supprimer.setIcon(new ImageIcon(IComptabilite.class.getResource("/delete.png")));
		btn_VersementBancaire_Supprimer.setBackground(new Color(205, 133, 63));
		btn_VersementBancaire_Supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JScrollPane scrollPane_6 = new JScrollPane();
		
		lbl_info_versement = new JLabel("Versements bancaires | Comptable | NANA C\u00E9dric Bollky Arnauld");
		lbl_info_versement.setBackground(new Color(160, 82, 45));
		lbl_info_versement.setBorder(new LineBorder(new Color(160, 82, 45), 2, true));
		lbl_info_versement.setFont(new Font("Eras Medium ITC", Font.PLAIN, 11));
		
		lblNewLabel_2 = new JLabel("Total : ");
		
		textField_totalVErsementBancaire = new JTextField();
		textField_totalVErsementBancaire.setEditable(false);
		textField_totalVErsementBancaire.setColumns(10);
		GroupLayout gl_panel_VersementBancaire = new GroupLayout(panel_VersementBancaire);
		gl_panel_VersementBancaire.setHorizontalGroup(
			gl_panel_VersementBancaire.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_VersementBancaire.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_VersementBancaire.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_VersementBancaire.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addGap(4)
							.addComponent(textField_totalVErsementBancaire, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
							.addComponent(btn_VersementBancaire_Ajouter, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_VersementBancaire_Modifier, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_VersementBancaire_Supprimer, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE))
						.addComponent(lbl_info_versement, GroupLayout.DEFAULT_SIZE, 1088, Short.MAX_VALUE))
					.addContainerGap())
				.addComponent(scrollPane_6, GroupLayout.DEFAULT_SIZE, 1108, Short.MAX_VALUE)
		);
		gl_panel_VersementBancaire.setVerticalGroup(
			gl_panel_VersementBancaire.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_VersementBancaire.createSequentialGroup()
					.addContainerGap()
					.addComponent(lbl_info_versement, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel_VersementBancaire.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_VersementBancaire.createSequentialGroup()
							.addGap(7)
							.addGroup(gl_panel_VersementBancaire.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btn_VersementBancaire_Modifier, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btn_VersementBancaire_Ajouter, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, gl_panel_VersementBancaire.createSequentialGroup()
									.addGap(3)
									.addComponent(lblNewLabel_2))
								.addComponent(textField_totalVErsementBancaire, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_VersementBancaire.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_VersementBancaire_Supprimer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_6, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE))
		);
		
				table_listeVersementBancaire = new JTable();
				table_listeVersementBancaire.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				table_listeVersementBancaire.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Id", "Date", "Montant", "Num\u00E9ro de compte", "Solde du compte"
					}
				) {
					Class[] columnTypes = new Class[] {
						String.class, String.class, String.class, String.class, String.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				table_listeVersementBancaire.getColumnModel().getColumn(0).setPreferredWidth(0);
				table_listeVersementBancaire.getColumnModel().getColumn(0).setMinWidth(0);
				table_listeVersementBancaire.getColumnModel().getColumn(0).setMaxWidth(0);
				scrollPane_6.setViewportView(table_listeVersementBancaire);
				table_listeVersementBancaire.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
				table_listeVersementBancaire.setAutoscrolls(true);
		panel_VersementBancaire.setLayout(gl_panel_VersementBancaire);
		getContentPane().setLayout(groupLayout);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Mon compte");
		mnNewMenu.setIcon(new ImageIcon(IComptabilite.class.getResource("/man-user.png")));
		mnNewMenu.setHorizontalAlignment(SwingConstants.RIGHT);
		menuBar.add(mnNewMenu);
		
		btn_modifierMotDePasse = new JMenuItem("Modifier mon mot de passe");
		btn_modifierMotDePasse.setIcon(new ImageIcon(IComptabilite.class.getResource("/lock.png")));
		mnNewMenu.add(btn_modifierMotDePasse);
		
		btn_deconnexion = new JMenuItem("D\u00E9connexion");
		btn_deconnexion.setIcon(new ImageIcon(IComptabilite.class.getResource("/logout.png")));
		mnNewMenu.add(btn_deconnexion);
		
	}

	public void switchPanel(JPanel panel) {

		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();

	}
	public void addListenerButtonDepense(ActionListener listener) {
		
		btn_Menu_Depense.addActionListener(listener);
		
	}
	
public void addListenerButtonLancerRecherchePaiementProf(ActionListener listener) {
		
	buttonRechercherPaiementProf.addActionListener(listener);
		
	}
	
public void addListenerButtonLancerRechercheProf(ActionListener listener) {
		
		buttonLancerRechercheProf.addActionListener(listener);
		
	}

public void addListenerButtonLancerTriProf(ActionListener listener) {
		
		buttonTriProf.addActionListener(listener);
		
	}
	
	
public void addListenerButtonModifierPaiementEmployer(ActionListener listener) {
	
	btn_PaiementEmployer_ModifierPaiement.addActionListener(listener);
	
}


	
    public void addListenerButtonAjouter(ActionListener listener) {
		
		btn_AjouterDepense.addActionListener(listener);
		
	}
   public void addListenerButtonSupprimer(ActionListener listener) {
	
	btn_SupprimerDepense.addActionListener(listener);
	
   }
   public void addListenerButtonModifier(ActionListener listener) {
	
	btn_ModifierDepense.addActionListener(listener);
	
  }
    
	 
 public int recupererId() {
	 
	 int index = tableDepense.getSelectedRow();
	 int id = (int) tableDepense.getValueAt(index, 0);
	 return id;
	 
 }
  public void chargerModelDepense(ModelDepense model) {
	  tableDepense.removeAll();
	  tableDepense.setModel(model);
	  tableDepense.repaint();
	  tableDepense.revalidate();
	  somme=0.0;
	  int nombreLigne = tableDepense.getRowCount();
	  
	  for(int i=0;i<nombreLigne;i++) {
		  
		 somme =somme + (Double) tableDepense.getValueAt(i, 1);
	  }
	  
  }
  
  public void chargerModelListeEleve(ModelEleve model) {
		 
	  tableListeEleve.setModel(model);
  }
  
  
  public void afficherMenuDepense() {
	  this.setVisible(true);
  }
  
  public Double totalTable() {
	 return somme;
  }
  public void chargerModelEleve(ModelEleve model) {
	  tableListeEleve.removeAll();
	  tableListeEleve.setModel(model);
	  tableListeEleve.repaint();
	  tableListeEleve.revalidate();
  }
  
  public boolean estVide(AbstractTableModel model) {
	  
	  int count = model.getRowCount();
	  
	  return (count == 0) ? true : false;
	  
  }
  
  public void chargerModelPaiementAuxiliaire(ModelPaiementAuxiliaire model) {
	  table_Auxiliaire.removeAll();
	  table_Auxiliaire.setModel(model);
	  table_Auxiliaire.repaint();
	  table_Auxiliaire.revalidate();
  }
  
  
  public void chargerModelListeEleveInscription(ModelEleveListe model) {
	  table_listeEleve_FraisInscription.removeAll();
	  table_listeEleve_FraisInscription.setModel(model);
	  table_listeEleve_FraisInscription.repaint();
	  table_listeEleve_FraisInscription.revalidate();
  }
  
  
  public void chargerModelProfesseur(ModelProfesseur model) {
	  table_listeProfesseur.removeAll();
	  table_listeProfesseur.setModel(model);
	  table_listeProfesseur.repaint();
	  table_listeProfesseur.revalidate();
  }
  public void chargerModelEmployer(ModelEmployer model) {
	  table_listeEmployer.removeAll();
	  table_listeEmployer.setModel(model);
	  table_listeEmployer.repaint();
	  table_listeEmployer.revalidate();
  }
  
  public void chargerModelPaiementScolarite(ModelPaiementScolarite model) {
	  tableListePaiementScolarite.removeAll();
	  tableListePaiementScolarite.setModel(model);
	  tableListePaiementScolarite.repaint();
	  tableListePaiementScolarite.revalidate();
  }
  
  
  public void chargerModelPaiementProfesseur(ModelPaiementProfesseur model) {
	  table_listePaiementProfesseur.removeAll();
	  table_listePaiementProfesseur.setModel(model);
	  table_listePaiementProfesseur.repaint();
	  table_listePaiementProfesseur.revalidate();
  }
  
  public void chargerModelResume(ModelResume model) {
	  table_resumePaiementProfesseur.removeAll();
	  table_resumePaiementProfesseur.setModel(model);
	  table_resumePaiementProfesseur.repaint();
	  table_resumePaiementProfesseur.revalidate();
  }
  
  
  public void chargerModelPaiementEmployer(ModelPaiementEmployer model) {
	  table_listePaiementEmployer.removeAll();
	  table_listePaiementEmployer.setModel(model);
	  table_listePaiementEmployer.repaint();
	  table_listePaiementEmployer.revalidate();
  }
  
  
  public void chargerModelFraisInscription(ModelFraisInscription model) {
	  table_listePaiementFraisInscription.removeAll();
	  table_listePaiementFraisInscription.setModel(model);
	  table_listePaiementFraisInscription.repaint();
	  table_listePaiementFraisInscription.revalidate();
  }
  
  public void chargerModelVersement(ModelVersement model) {
	  table_listeVersementBancaire.removeAll();
	  table_listeVersementBancaire.setModel(model);
	  table_listeVersementBancaire.repaint();
	  table_listeVersementBancaire.revalidate();
  }
  
  
  public int recuperer() {  
	     int id = 0;
		 int index = table_listeVersementBancaire.getSelectedRow();
		 id = (int) table_listeVersementBancaire.getValueAt(index, 0);
		 return id;
		 
	 }
  
  public Double recupererSommeResume() {  
	     Double id = 0.0;
		 int index = table_resumePaiementProfesseur.getRowCount();
		 for(int i = 0;i < index ;i++) {
			 id = id + (Double)table_resumePaiementProfesseur.getValueAt(i, 2); 
			 
		 }
		
		 return id;
		 
	 }
  
  public int recupererIdListeVersement() {  
	     int id = 0;
		 int index = table_listeVersementBancaire.getSelectedRow();
		 id = (int) table_listeVersementBancaire.getValueAt(index, 0);
		 return id;
		 
	 }
  
  public int recupererIdPaiementAuxiliaire() {
		 
		 int index = table_Auxiliaire.getSelectedRow();
		 int id = (int) table_Auxiliaire.getValueAt(index, 0);
		 return id;
		 
	 }
  
  public int recupererIdListeDepense() {
		 
		 int index = tableDepense.getSelectedRow();
		 int id = (int) tableDepense.getValueAt(index, 0);
		 return id;
		 
	 }
  
  
  public int recupererIdListeFraisInscription() {
		 
		 int index = table_listePaiementFraisInscription.getSelectedRow();
		 int id = (int) table_listePaiementFraisInscription.getValueAt(index, 0);
		 return id;
		 
	 }
  
  public int recupererIdEleveListeInscription() {
		 
		 int index = table_listeEleve_FraisInscription.getSelectedRow();
		 int id = (int) table_listeEleve_FraisInscription.getValueAt(index, 0);
		 return id;
		 
	 }
  
  public int recupererIdPaiementScolarite() {
		 
		 int index = tableListePaiementScolarite.getSelectedRow();
		 int id = (int) tableListePaiementScolarite.getValueAt(index, 0);
		 return id;
		 
	 }
  
  public int recupererIdPaiementEmployer() {
		 
		 int index = table_listePaiementEmployer.getSelectedRow();
		 int id = (int) table_listePaiementEmployer.getValueAt(index, 0);
		 return id;
		 
	 }
  
  public int recupererIdPaiementProfesseur() {
		 
		 int index = table_listePaiementProfesseur.getSelectedRow();
		 int id = (int) table_listePaiementProfesseur.getValueAt(index, 0);
		 return id;
		 
	 }
  
  
  public int recupererIdProfesseur() {
		 
		 int index = table_listeProfesseur.getSelectedRow();
		 int id = (int) table_listeProfesseur.getValueAt(index, 0);
		 return id;
		 
	 }
  
  public int recupererIdEmployer() {
		 
		 int index = table_listeEmployer.getSelectedRow();
		 int id = (int) table_listeEmployer.getValueAt(index, 0);
		 return id;
		 
	 }
  
  
  public Professeur recupererProfesseurDeLaListeProfesseur() {
	    int index = table_listeProfesseur.getSelectedRow();
	     IDaoProffesseur dao = new DaoProfesseurImpl();
	     Professeur prof = dao.read(
	    		 (String)table_listeProfesseur.getValueAt(index, 1), 
	    		 (String)table_listeProfesseur.getValueAt(index, 2),
	    		 (String) table_listeProfesseur.getValueAt(index, 4),
	    		 (String)table_listeProfesseur.getValueAt(index, 5), 
	    		 (String)table_listeProfesseur.getValueAt(index, 3));
	     
		 return prof;
		 
	 }
  
  
  public ResumePaiementProfesseur recupererResumePaiementProfesseur() {
	    int index = table_resumePaiementProfesseur.getSelectedRow();
	     
	    ResumePaiementProfesseur prof = new ResumePaiementProfesseur(
	    		 (String)table_resumePaiementProfesseur.getValueAt(index,0), 
	    		 (String)table_resumePaiementProfesseur.getValueAt(index, 1),
	    		 Double.valueOf(String.valueOf(table_resumePaiementProfesseur.getValueAt(index, 2))),
	    		 (String)table_resumePaiementProfesseur.getValueAt(index, 3), 
	    		 (String)table_resumePaiementProfesseur.getValueAt(index, 4),
	    		 (String)table_resumePaiementProfesseur.getValueAt(index, 5));
	     
		 return prof;
		 
	 }
  
  public Personnel recupererEmplyerDeLaListeEmployer() {
	    int index = table_listeEmployer.getSelectedRow();
	     IDaoPersonnel dao = new DaoPersonnelImpl();
	     Personnel prof = dao.read(
	    		 (String)table_listeEmployer.getValueAt(index, 1), 
	    		 (String)table_listeEmployer.getValueAt(index, 2),
	    		 (String) table_listeEmployer.getValueAt(index, 3));
	     
		 return prof;
		 
	 }
  
  
  
  public int recupererIdPaiement() {
		 
		 int index = tableListeEleve.getSelectedRow();
		 int id = (int) tableListeEleve.getValueAt(index, 0);
		 return id;
		 
	 }
  
  
  public String recupererMois() {
	  
	 return  (String) comboBox_MoisDepense.getSelectedItem();
  }
  
  
  public String recupererClasse() {
	  
		 return  (String) comboBox_Scolarite_TrierPar_listePaiement.getSelectedItem();
	  }
  
  public String recupererComboBoxProf() {
	  
		 return  (String) comboBox_PaiementProfesseur_TrierPar_listeProfesseur.getSelectedItem();
	  }
  
  public String recupererComboTriEmployer() {
	  
		 return  (String) comboBox_PaiementEmployer_TrierPar_listeEmployer.getSelectedItem();
	  }
  
  
  public String recupererComboTriEleveInscription() {
	  
		 return  (String) comboBox_FraisInscription_listeEleve_TrierPar.getSelectedItem();
	  }
  
  public String recupererComboTriFraisInscription() {
	  
		 return  (String) comboBox_FraisInscription_TrierPar_listeFraisInscription.getSelectedItem();
	  }

  
  
  public String recupererComboTriPaiementEmployer() {
	  
		 return  (String) comboBox_PaiementEmployer_TrierPar_listePaiementEmployer.getSelectedItem();
	  }
  
  public String recupererComboBoxPaiementProf() {
	  
		 return  (String) comboBox_PaiementProfesseur_TrierPar_listePaiementProfesseur.getSelectedItem();
	  }

  
  public String recupererComboBoxTriEleveScolarite() {
	  
		 return  (String) comboBox_Scolarite_TrierPar_listeEleve.getSelectedItem();
	  }

  
  public void addListenerButtonMois(ItemListener listener) {
		
	  comboBox_MoisDepense.addItemListener(listener);;
		
	  }
  
  public void addListenerButtonRechercherEmployer(ActionListener listener) {
		
		buttonRechercherEmployer.addActionListener(listener);
		
	  }
  
  public void addListenerButtonRechercherEleve(ActionListener listener) {
		
		buttonRechercherEleve.addActionListener(listener);
		
	  }
  public void addListenerButtonTriPaiementEmployer(ActionListener listener) {
		
		buttonTrierPaiementEmployer.addActionListener(listener);
		
	  }
  
  public void addListenerButtonRechercherPaiementEmployer(ActionListener listener) {
		
		buttonRechercherEmployerPaiement.addActionListener(listener);
		
	  }
  
  public void addListenerButtonTrieEleveInscription(ActionListener listener) {
		
      buttonTriEleveInscription.addActionListener(listener);
		
	  }
  
  public void addListenerButtonTrieFraisInscription(ActionListener listener) {
		
      buttonTriFraisInscription.addActionListener(listener);
		
	  }
  
  public void addListenerButtonRecuPaiementAuxiliaire(ActionListener listener) {
		
      btnRecuPaiementAuxiliaire.addActionListener(listener);
		
	  }
  
  
  public void addListenerButtonModifierPaiementAuxiliaire(ActionListener listener) {
		
      btn_ModifierPaiementAuxiliaire.addActionListener(listener);
		
	  }
  
  public void addListenerButtonSupprimerPaiementAuxiliaire(ActionListener listener) {
		
      btn_SupprimerPaiementAuxiliaire.addActionListener(listener);
		
	  }
  
  
  
  public void addListenerButtonPayerAuxiliaire(ActionListener listener) {
		
      btn_PayerExtra.addActionListener(listener);
		
	  }
  
  public void addListenerButtonRecuFraisInscription(ActionListener listener) {
		
      btn_FraisInscription_Recu.addActionListener(listener);
		
	  }
  
  
  public void addListenerButtonRecuPaiementProfesseur(ActionListener listener) {
		
      btn_recuPaiementProfesseur.addActionListener(listener);
		
	  }
  
  
  public void addListenerButtonRecuPaiementEmployer(ActionListener listener) {
		
      btn_recuPaiementEmployer.addActionListener(listener);
		
	  }
  
  
  public void addListenerButtonTrieEleveScolarite(ActionListener listener) {
		
      button_TrierPar_listeEleve.addActionListener(listener);
		
	  }
  
  public void addListenerButtonTriRecu(ActionListener listener) {
		
       buttonTrierParRecu.addActionListener(listener);
		
	  }
  
  public void addListenerButtonRechercherRecu(ActionListener listener) {
		
		buttonRechercherRecu.addActionListener(listener);
		
	  }
  
  public void addListenerButtonPayerRecuScolarite(ActionListener listener) {
		
		btn_Scolarite_Recu.addActionListener(listener);
		
	  }
  
  
  
  public void addListenerButtonTriEmployer(ActionListener listener) {
		
		buttonTriEmployer.addActionListener(listener);
		
	  }
  
  public void addListenerButtonTrierProfesseur(ActionListener listener) {
		
		buttonTriProf.addActionListener(listener);
		
	  }
  
  
  public void addListenerNouveauPaiement(ActionListener listener) {
		btn_Scolarite_NouveauPaiement.addActionListener(listener);
	}
  public void addListenerButtonScolarite(ActionListener listener) {
		
		btn_Menu_Scolarite.addActionListener(listener);
		
	  }
  
  public void addListenerButtonMenuEmployer(ActionListener listener) {
		
		btn_Menu_PaiementEmployer.addActionListener(listener);
		
	  }
  
  
  public void addListenerButtonMenuInscription(ActionListener listener) {
		
		btn_Menu_FraisInscription.addActionListener(listener);
		
	  }
  
  
  
  public void addListenerButtonMenuProf(ActionListener listener) {
		
		btn_Menu_PaiementProfesseur.addActionListener(listener);
		
	  }
  
  public void addListenerButtonSupprimerPaiementProf(ActionListener listener) {
		
		btn_PaiementProfesseur_SupprimerPaiement.addActionListener(listener);
		
		
	  }
  
  
  public void addListenerButtonModifierPaiementProf(ActionListener listener) {
		
		btn_PaiementProfesseur_ModifierPaiement.addActionListener(listener);
		
		
	  }
  
  
  public void addListenerButtonBulletinEmployer(ActionListener listener) {
		
		btn_PaiementEmployer_BulletinSalaire.addActionListener(listener);
		
		
	  }
  
  public void addListenerButtonBulletinProfesseur(ActionListener listener) {
		
		btn_PaiementProfesseur_BulletinDeSalaire.addActionListener(listener);
		
		
	  }
  
  
  public void addListenerButtonModifierFraisInscription(ActionListener listener) {
		
		btn_FraisInscription_ModifierFraisScolarite.addActionListener(listener);
		
		
	  }
  
  
  public void addListenerButtonAjouterFraisInscription(ActionListener listener) {
		
		btn_FraisInscription_AjouterFraisScolarite.addActionListener(listener);
		
		
	  }
  
  public void addListenerButtonTriPaiementProf(ActionListener listener) {
		
		buttonTriPaiementProf.addActionListener(listener);
		
		
	  }
  
  public void addListenerButtonSpprimerPaiementEmployer(ActionListener listener) {
		
		btn_PaiementEmployer_SupprimerPaiement.addActionListener(listener);
		
		
	  }

  public void addListenerButtonSpprimerFraisInscription(ActionListener listener) {
		
		btn_FraisInscription_SupprimerFraisScolarite.addActionListener(listener);
		
		
	  }

  
  public void addListenerButtonPayerEmployer(ActionListener listener) {
		
		btn_PaiementEmployer_PayerSalaire.addActionListener(listener);
		
		
	  }
  
  public void addListenerButtonPayerProf(ActionListener listener) {
		
		btn_PaiementProfesseur_PayerSalaire.addActionListener(listener);
		
		
	  }
  
  
  public void addListenerButtonSupprimerScolarite(ActionListener listener) {
		
		btn_Scolarite_SupprimerPaiement.addActionListener(listener);
		
	  }
  public void addListenerButtonModifierScolarite(ActionListener listener) {
		
		btn_Scolarite_ModifierPaiement.addActionListener(listener);
		
	  }
  
  
  public void addListenerButtonDetailsEleve(ActionListener listener) {
		
		btn_details.addActionListener(listener);
		
	  }
  
  public void addListenerButtonAjouterVersement(ActionListener listener) {
		
		btn_VersementBancaire_Ajouter.addActionListener(listener);
		
	  }
  
  public void addListenerButtonModifierVersement(ActionListener listener) {
		
		btn_VersementBancaire_Modifier.addActionListener(listener);
		
	  }
  
  public void addListenerButtonSupprimerVersement(ActionListener listener) {
		
		btn_VersementBancaire_Supprimer.addActionListener(listener);
		
	  }
  
  public void addListenerButtonMenuVersement(ActionListener listener) {
		
		btn_Menu_VersementBancaire.addActionListener(listener);
		
	  }
  
  
  public void addListenerButtonRechercher(ActionListener listener) {
		
		btnRechercher.addActionListener(listener);
		
	  }
  
  public void addListenerButtonRechercherEleveInscription(ActionListener listener) {
		
		buttonrechercherEleveInscription.addActionListener(listener);
		
	  }

  
  public void addListenerButtonRechercherfraisInscription(ActionListener listener) {
		
		buttonRechercherFraisInscription.addActionListener(listener);
		
	  }
  

public String getTextField_rechercheFraisInscription() {
	return textField_rechercheFraisInscription.getText();
}

public void setTextField_rechercheFraisInscription(String textField_rechercheFraisInscription) {
	this.textField_rechercheFraisInscription.setText(textField_rechercheFraisInscription);
}

public String getTextField_totalVErsementBancaire() {
	return textField_totalVErsementBancaire.getText();
}

public void setTextField_totalVErsementBancaire(String textField_totalVErsementBancaire) {
	this.textField_totalVErsementBancaire.setText(textField_totalVErsementBancaire);
}

public String getTextField_MontantTotalDepense() {
	return textField_MontantTotalDepense.getText();
}

public void setTextField_MontantTotalDepense(String textField_MontantTotalDepense) {
	this.textField_MontantTotalDepense.setText(textField_MontantTotalDepense);
}
public void DepenseListener(ActionListener actionListener) {
	// TODO Auto-generated method stub
	btn_Menu_Depense.addActionListener(actionListener);	
}

public String getTextFieldRechercherEleve() {
	return textFieldRechercherEleve.getText();
}

public void setTextFieldRechercherEleve(String textFieldRechercherEleve) {
	this.textFieldRechercherEleve.setText(textFieldRechercherEleve);
}


public String getTextFieldRechercherRecu() {
	return textFieldRechercherRecu.getText();
}


public String getTextField_recherchePaiementEmployer() {
	return textField_recherchePaiementEmployer.getText();
}

public void setTextField_recherchePaiementEmployer(String textField_recherchePaiementEmployer) {
	this.textField_recherchePaiementEmployer.setText(textField_recherchePaiementEmployer);
}

public void setTextFieldRechercherRecu(String textFieldRechercherRecu) {
	this.textFieldRechercherRecu.setText(textFieldRechercherRecu);
}

public String getTextField_rechercheProfesseur() {
	return textField_rechercheProfesseur.getText();
}

public String getTextField_rechercheEmployer_listeEmployer() {
	return textField_rechercheEmployer_listeEmployer.getText();
}

public void setTextField_rechercheEmployer_listeEmployer(String textField_rechercheEmployer_listeEmployer) {
	this.textField_rechercheEmployer_listeEmployer.setText(textField_rechercheEmployer_listeEmployer);
}

public void setTextField_rechercheProfesseur(String textField_rechercheProfesseur) {
	this.textField_rechercheProfesseur.setText(textField_rechercheProfesseur);
}

public String getTextField_PaiementProfesseur_RechercheProfesseur() {
	return textField_PaiementProfesseur_RechercheProfesseur.getText();
}

public void setTextField_PaiementProfesseur_RechercheProfesseur(
		String textField_PaiementProfesseur_RechercheProfesseur) {
	this.textField_PaiementProfesseur_RechercheProfesseur.setText(textField_PaiementProfesseur_RechercheProfesseur);
}

public String getTextField_recherche_listeEleve_FraisInscription() {
	return textField_recherche_listeEleve_FraisInscription.getText();
}

public void setTextField_recherche_listeEleve_FraisInscription(
		String textField_recherche_listeEleve_FraisInscription) {
	this.textField_recherche_listeEleve_FraisInscription.setText(textField_recherche_listeEleve_FraisInscription);
}

public String getLabelInformation() {
	return label_Information.getText();
}

public void setLabelInformation(String label_Information) {
	
  this.label_Information.setText(label_Information);
	
}

public void setLabelInformationColor(Color color) {
	this.label_Information.setForeground(color);;
}

public String getTextField_total_Resume_PaiementProfesseur() {
	return textField_total_Resume_PaiementProfesseur.getText();
}

public void setTextField_total_Resume_PaiementProfesseur(String textField_total_Resume_PaiementProfesseur) {
	this.textField_total_Resume_PaiementProfesseur.setText(textField_total_Resume_PaiementProfesseur);
}


@SuppressWarnings("static-access")
public void confirmationInformationSupprimerEnregistrer(String message) {
	//Boîte du message d'information
	JOptionPane jop1 = new JOptionPane();
	jop1.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
	
}

		@SuppressWarnings("static-access")
		public int confirmerSupprimerAjouter(String message) {
	  

	  JOptionPane jop = new JOptionPane();			
	  int option = jop.showConfirmDialog(null, "Voulez-vous "+message+"?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	  			
	  	return option;
	   		
	  }
		
		
		
		public void addDeconectionListener(ActionListener actionListener) {
			btn_deconnexion.addActionListener(actionListener);
			
		}
		

		public void addModifierMdpListener(ActionListener actionListener) {
			btn_modifierMotDePasse.addActionListener(actionListener);
			
		}
		
		
		public int showMessageConfirmation(String title,String message) {
			int retour = JOptionPane.showConfirmDialog(this,
		             message, 
		             title,
		             JOptionPane.OK_CANCEL_OPTION);
			
			return retour;
		}
		
		
	public void setNomPrenomUser(String name) {
		lbl_info_depense.setText("Depense | Comptable | "+name);
		lbl_info_scolarite.setText("Paiement scolarité | Comptable | "+name);
		lbl_info_professeur.setText("Paiement professeur | Comptable | "+name);
		lbl_info_employer.setText("Paiement employer | Comptable | "+name);
		lbl_info_inscription.setText("Frais d'inscription | Comptable | "+name);
		lbl_info_versement.setText("Versement bancaire | Comptable | "+name);
	}

	public void close() {
		dispose();
		
	}
}

