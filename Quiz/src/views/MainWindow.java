package views;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.JList;

import persistentie.PersistentieFacade;
import persistentie.PersistentieType;
import controller.OpstartController;
import model.*;
import Enums.*;


public class MainWindow implements ActionListener {

	public JFrame frame;
	private JTextField Onderwerp;

	/**
	 * Launch the application.
	 */
	
		
	public void startUpMainWindow(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 936, 556);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 934, 91);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 109, 934, 418);
		
		JLabel lblToonOpdrachtenVan = new JLabel("Toon opdrachten van categorie");
		lblToonOpdrachtenVan.setBounds(12, 17, 222, 15);
		//Combobox voor het kiezen van de categorie van de vraagen die getoont worden
		JComboBox<String> CategorieCB = new JComboBox<String>();
		CategorieCB.setBounds(252, 12, 124, 24);
			//JComboBox opvullen met Enum Categorie
			Categorie [] categorie = Categorie.values();
			int n = 0;
			while(n < categorie.length){
				CategorieCB.addItem(categorie[n].toString());
				n++;
			}
			
		JLabel lblSorteerOpdrachtenOp = new JLabel("Sorteer opdrachten op");
		lblSorteerOpdrachtenOp.setBounds(12, 59, 162, 15);
		
		JComboBox Sorteren = new JComboBox();
		Sorteren.setBounds(252, 54, 124, 24);
		
		JLabel lblAantalToegevoegdeOpdrachten = new JLabel("Aantal toegevoegde opdrachten");
		lblAantalToegevoegdeOpdrachten.setBounds(497, 32, 230, 15);
		
		JButton VraagOmhoog = new JButton("^^^^^^");
		VraagOmhoog.setBounds(497, 53, 437, 40);
		
		JList<String> LijstToegevoegd = new JList<String>();
		LijstToegevoegd.setBounds(497, 105, 437, 288);
		
		JList<String> LijstToevoegen = new JList<String>();
		LijstToevoegen.setBounds(12, 105, 364, 288);

		
		JButton QuizVerwijderen = new JButton("<<<<");
		QuizVerwijderen.setBounds(405, 243, 74, 25);
		
		JButton QuizToevoegen = new JButton(">>>>");
		QuizToevoegen.setBounds(405, 177, 74, 25);
		
		JLabel Counter = new JLabel("");
		Counter.setBounds(759, 32, 0, 0);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ondewerp");
		lblNewLabel.setBounds(20, 17, 74, 15);
		
		Onderwerp = new JTextField();
		Onderwerp.setBounds(106, 15, 278, 19);
		Onderwerp.setColumns(10);
		
		JLabel lblKlas = new JLabel("Klas");
		lblKlas.setBounds(402, 17, 30, 15);
		
		JComboBox Klas = new JComboBox(); 
		Klas.setBounds(450, 12, 62, 24);
		
		JLabel lblAuteur = new JLabel("Auteur");
		lblAuteur.setBounds(539, 17, 48, 15);
		//Combobox met auteur van de gemaakte quiz
		JComboBox<String> AuteurCB = new JComboBox<String>();
			//JComboBox opvullen met Enum Categorie
			Leraar [] auteur = Leraar.values();
			n = 0;
			while(n < auteur.length){
				AuteurCB.addItem(auteur[n].toString());
				n++;
			}
		
		frame.add(AuteurCB);  
        //frame.pack();  
        frame.setLocationRelativeTo(null);  
        //frame.setVisible(true);
		AuteurCB.setBounds(605, 12, 137, 24);
		
		JButton RegistreerQuiz = new JButton("Registreer nieuwe quiz");
		RegistreerQuiz.setBounds(20, 48, 728, 31);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.add(RegistreerQuiz);
		panel_1.add(lblNewLabel);
		panel_1.add(Onderwerp);
		panel_1.add(lblKlas);
		panel_1.add(Klas);
		panel_1.add(lblAuteur);
		panel_1.add(AuteurCB);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.add(lblToonOpdrachtenVan);
		panel.add(lblSorteerOpdrachtenOp);
		panel.add(Sorteren);
		panel.add(CategorieCB);
		panel.add(LijstToevoegen);
		panel.add(QuizToevoegen);
		panel.add(QuizVerwijderen);
		panel.add(LijstToegevoegd);
		panel.add(lblAantalToegevoegdeOpdrachten);
		panel.add(Counter);
		panel.add(VraagOmhoog);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}// Einde class
