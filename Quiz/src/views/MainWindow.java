package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.ListCellRenderer;
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
import persistentie.TextPersistentie;
import controller.OpstartController;
import model.*;
import Enums.*;


public class MainWindow implements ActionListener {
	
	public JFrame frame;
	private JTextField tfOnderwerp;
	private JPanel pTop;
	private JPanel pBottom;
	private JLabel lblToonOpdrachtenVan;
	private JComboBox<String> cbCategorie;
	private JLabel lblSorteerOpdrachtenOp;
	private JComboBox cbSorteren;
	private JLabel lblAantalToegevoegdeOpdrachten;
	private JButton bVraagOmhoog;
	private JList<String> listToegevoegd;
	private JList listToevoegen ;
	private JButton bQuizVerwijderen;
	private JButton bQuizToevoegen;
	private JLabel lblCounter;
	private JLabel lblOnderwerp;
	private JLabel lblKlas;
	private JComboBox cbKlas;
	private JLabel lblAuteur;
	private JComboBox<String> cbAuteur;

	/**
	 * Launch the application.
	 */
	
/*		
	public void startUpMainWindow(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/	

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
		
		pTop = new JPanel();
		pTop.setBounds(0, 0, 934, 91);
		
		pBottom = new JPanel();
		pBottom.setBounds(0, 109, 934, 418);
		
		lblToonOpdrachtenVan = new JLabel("Toon opdrachten van categorie");
		lblToonOpdrachtenVan.setBounds(12, 17, 222, 15);
		//Combobox voor het kiezen van de categorie van de vraagen die getoont worden
		cbCategorie = new JComboBox<String>();
		cbCategorie.setBounds(252, 12, 124, 24);
			//JComboBox opvullen met Enum Categorie
			Categorie [] categorie = Categorie.values();
			for(Categorie e : categorie){
				cbCategorie.addItem(e.toString());
			}
			
		lblSorteerOpdrachtenOp = new JLabel("Sorteer opdrachten op");
		lblSorteerOpdrachtenOp.setBounds(12, 59, 162, 15);
		
		cbSorteren = new JComboBox();
		cbSorteren.setBounds(252, 54, 124, 24);
		
		lblAantalToegevoegdeOpdrachten = new JLabel("Aantal toegevoegde opdrachten");
		lblAantalToegevoegdeOpdrachten.setBounds(497, 32, 230, 15);
		
		bVraagOmhoog = new JButton("^^^^^^");
		bVraagOmhoog.setBounds(497, 53, 437, 40);
		
		listToegevoegd = new JList();
		listToegevoegd.setBounds(497, 105, 437, 288);

		OpstartController o = new OpstartController();
		listToevoegen = new JList(o.getPersistentie().getOpdrachtCatalogus().getListOpdrachten().toArray());
		listToevoegen.setCellRenderer(new OpdrachtCellRenderer());
		listToevoegen.setBounds(12, 105, 364, 288);
	    //JScrollPane pane = new JScrollPane(listToevoegen);

		
		bQuizVerwijderen = new JButton("<<<<");
		bQuizVerwijderen.setBounds(405, 243, 74, 25);
		
		bQuizToevoegen = new JButton(">>>>");
		bQuizToevoegen.setBounds(405, 177, 74, 25);
		
		lblCounter = new JLabel("");
		lblCounter.setBounds(759, 32, 0, 0);
		frame.getContentPane().setLayout(null);
		
		lblOnderwerp = new JLabel("Ondewerp");
		lblOnderwerp.setBounds(20, 17, 74, 15);
		
		tfOnderwerp = new JTextField();
		tfOnderwerp.setBounds(106, 15, 278, 19);
		tfOnderwerp.setColumns(10);
		
		lblKlas = new JLabel("Klas");
		lblKlas.setBounds(402, 17, 30, 15);
		
		cbKlas = new JComboBox(); 
		cbKlas.setBounds(450, 12, 62, 24);
		
		lblAuteur = new JLabel("Auteur");
		lblAuteur.setBounds(539, 17, 48, 15);
		//Combobox met auteur van de gemaakte quiz
		cbAuteur = new JComboBox<String>();
			//JComboBox opvullen met Enum Categorie
			Leraar [] auteur = Leraar.values();
			for(Leraar e : auteur){
				cbAuteur.addItem(e.toString());
			}
		
		//frame.add(AuteurCB);  
        //frame.pack();  
        frame.setLocationRelativeTo(null);  
        //frame.setVisible(true);
		cbAuteur.setBounds(605, 12, 137, 24);
		
		JButton RegistreerQuiz = new JButton("Registreer nieuwe quiz");
		RegistreerQuiz.setBounds(20, 48, 728, 31);
		frame.getContentPane().add(pTop);
		pTop.setLayout(null);
		pTop.add(RegistreerQuiz);
		pTop.add(lblOnderwerp);
		pTop.add(tfOnderwerp);
		pTop.add(lblKlas);
		pTop.add(cbKlas);
		pTop.add(lblAuteur);
		pTop.add(cbAuteur);
		frame.getContentPane().add(pBottom);
		pBottom.setLayout(null);
		pBottom.add(lblToonOpdrachtenVan);
		pBottom.add(lblSorteerOpdrachtenOp);
		pBottom.add(cbSorteren);
		pBottom.add(cbCategorie);
		pBottom.add(listToevoegen);
		pBottom.add(bQuizToevoegen);
		pBottom.add(bQuizVerwijderen);
		pBottom.add(listToegevoegd);
		pBottom.add(lblAantalToegevoegdeOpdrachten);
		pBottom.add(lblCounter);
		pBottom.add(bVraagOmhoog);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

	// An inner class to respond to clicks on the Print button
	class PrintListener implements ActionListener {
	  public void actionPerformed(ActionEvent e) {
	    int selected[] = listToevoegen.getSelectedIndices();
	    System.out.println("Selected Elements:  ");

	    for (int i = 0; i < selected.length; i++) {
	  	  Opdracht element = (Opdracht) listToevoegen.getModel().getElementAt(selected[i]);
	      System.out.println("  " + element.toString());
	    }
	  }
	}

	class OpdrachtCellRenderer extends JLabel implements ListCellRenderer {
		  private Color HIGHLIGHT_COLOR = new Color(0, 0, 128);

		  public OpdrachtCellRenderer() {
		    setOpaque(true);
		    setIconTextGap(12);
		  }

		  public Component getListCellRendererComponent(JList list, Object value,
		      int index, boolean isSelected, boolean cellHasFocus) {
		    Opdracht entry = (Opdracht) value;
		    setText(entry.getVraag() + " - " + entry.getType());
		    if (isSelected) {
		      setBackground(HIGHLIGHT_COLOR);
		      setForeground(Color.white);
		    } else {
		      setBackground(Color.white);
		      setForeground(Color.black);
		    }
		    return this;
		  }
		}
}// Einde class




