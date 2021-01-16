package com.app.interfaces.accueil;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.app.controleur.Controleur;
import com.app.controleur.ControleurAdmin;
import com.app.metier.entites.Administrateur;
import com.app.metier.entites.Comptable;
import com.app.metier.service.IService;
import com.app.metier.service.Service;

@SuppressWarnings("serial")
public class Accueil extends JFrame {

	private JPanel contentPane;
	private JLabel label_message;
	private JButton connexion;
	private JTextField login;
	private IService service;
	private JPasswordField password;
    private boolean running=false;
    private Comptable comptable;
    private Administrateur initAdmin;
	/**
	 * Launch the application.
	 */
	public  void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accueil frame = new Accueil();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Accueil() {
		setResizable(false);
		service = new Service();
		initComponent();
		autorisation();
	    }
		
		private void initComponent(){
		setMinimumSize(new Dimension(400, 400));
		setTitle("Accueil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 589);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(210, 180, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/k.png"));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(153, 102, 102), 3, true));
		panel.setBounds(78, 116, 245, 395);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 11, 225, 225);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(img);
		
		login = new JTextField();
		login.setBounds(10, 263, 225, 20);
		panel.add(login);
		login.setColumns(10);
		
		 password = new JPasswordField();
		password.setBounds(10, 309, 225, 20);
		panel.add(password);
		
		JLabel lblNewLabel_2 = new JLabel("Identifiant");
		lblNewLabel_2.setBounds(10, 247, 225, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Mot de passe");
		lblNewLabel_2_1.setBounds(10, 294, 225, 14);
		panel.add(lblNewLabel_2_1);
		
		connexion = new JButton("Connexion");
		connexion.setForeground(new Color(102, 102, 102));
		connexion.setBackground(new Color(153, 102, 102));
		connexion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		connexion.setBounds(10, 340, 225, 44);
		panel.add(connexion);
		
		JLabel lblNewLabel_1 = new JLabel("Compta-Ecole");
		lblNewLabel_1.setForeground(new Color(102, 51, 51));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Levenim MT", Font.PLAIN, 50));
		lblNewLabel_1.setBorder(null);
		lblNewLabel_1.setBounds(10, 23, 384, 59);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("  SONA-Group \u00A9 2020");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(0, 536, 404, 14);
		contentPane.add(lblNewLabel_3);
		
		label_message = new JLabel("");
		label_message.setBounds(10, 91, 384, 14);
		contentPane.add(label_message);
	   }
		@SuppressWarnings("deprecation")
		private boolean operationAdmin() {
			List<Administrateur> admin=null;
		    admin= service.rechercheAdmineParLoginMdp(login.getText(), password.getText());
			boolean acces=false;
			if(admin.size()!=0) {
				initAdmin=admin.get(0);
				acces= true;
			}else {
				acces=false;
			}
			return acces;
		}
		@SuppressWarnings("deprecation")
		private boolean operationComptable() {
			boolean acess=false;
			List<Comptable> compt;
		    compt=service.rechercheComptableParLoginMdp(login.getText(), password.getText());
			if(compt.size()!=0)	{
				comptable=compt.get(0);
				
				acess= true;
			}else {
				acess=false;
			}
			return acess;
			
		}
		
		private void autorisation() {
			connexion.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
							
						boolean acces1=operationComptable();
						boolean acces2=operationAdmin();
						ControleurAdmin control = new ControleurAdmin(initAdmin);
						Controleur controleur = new Controleur(comptable);
						
					if(acces1) {
						dispose();
						controleur.demarerIComptabilite();
					}else if(acces2) {
						dispose();
						control.run();
						
					}else {
						login.setText("");
						password.setText("");
						exception();
					}
					
					}
				});
		}
		
		
		 private void exception() {
	    		Thread clignotant = new Thread ( new Runnable () {
	    			@Override
	    			public void run() {
	    				running = true;
	    				
	    				while ( running ) {					
	    					try {
	    						label_message.setForeground(Color.red);
	    						label_message.setText("Identifaint ou Mot de passe incorrect ):");
	    						Thread.sleep(3000);
	    						
	    						label_message.setText("");
	    						running=false;
	    					} catch (InterruptedException e) {}
	    				}
	    				
	    			}			
	    		});
	    		clignotant.start();
	    	}
			
		
		
}
