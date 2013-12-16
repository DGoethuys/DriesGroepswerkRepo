package views;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashSet;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JList;

import controller.OpstartController;
import model.*;
import Enums.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MainWindow {
	
	private OpstartController o;
	private HashSet<Opdracht> hsRechts = new HashSet<Opdracht>();
	
	public JFrame frame;
	private JTextField tfOnderwerp;
	private JPanel pTop;
	private JPanel pBottom;
	private JLabel lblToonOpdrachtenVan;
	private JComboBox<String> cbCategorie;
	private JLabel lblSorteren;
	private JComboBox<String> cbSorteren;
	private JLabel lblAantalToegevoegdeOpdrachten;
	private JButton bVraagOmhoog;
	private JList<Opdracht> listRight;
	private ListModel<Opdracht> modelRight;
	private JScrollPane spListRight;
	private JList<Opdracht> listLeft;
	private ListModel<Opdracht> modelLeft;
	private JScrollPane spListLeft;
	private JButton bOpdrachtVerwijderen;
	private JButton bOpdrachtToevoegen;
	private JLabel lblCounter;
	private JLabel lblOnderwerp;
	private JLabel lblKlas;
	private JComboBox<String> cbKlas;
	private JLabel lblAuteur;
	private JComboBox<String> cbAuteur;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

/*	startUpMainWindow verplaatst naar opstart
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

	public MainWindow() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 936, 555);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pTop = new JPanel();
		pTop.setBounds(0, 0, 934, 91);
		
		pBottom = new JPanel();
		pBottom.setBounds(0, 109, 934, 406);
		
		lblToonOpdrachtenVan = new JLabel("Toon opdrachten van categorie");
		lblToonOpdrachtenVan.setBounds(12, 17, 222, 15);
		//Combobox voor het kiezen van de categorie van de vraagen die getoont worden
		cbCategorie = new JComboBox<String>();
		cbCategorie.setBounds(252, 12, 124, 24);
		//default waarde toevoegen
		cbCategorie.addItem(" -");
			//JComboBox opvullen met Enum Categorie
			Categorie [] categorie = Categorie.values();
			for(Categorie e : categorie){
				cbCategorie.addItem(e.toString());
			}
			
		lblSorteren = new JLabel("Sorteer opdrachten op");
		lblSorteren.setBounds(12, 59, 162, 15);
		//Combobox die de manier van sorteren bepaald
		cbSorteren = new JComboBox<String>();
		cbSorteren.setBounds(252, 54, 124, 24);
		//dafault sorteren van A tot Z
		cbSorteren.addItem("A-Z");
		//achterstevoren sorteren
		cbSorteren.addItem("Z-A");
		
		lblAantalToegevoegdeOpdrachten = new JLabel("Aantal toegevoegde opdrachten");
		lblAantalToegevoegdeOpdrachten.setBounds(497, 32, 230, 15);
		
		bVraagOmhoog = new JButton("^^^^^^");
		bVraagOmhoog.setBounds(497, 53, 437, 40);
		
		modelRight = new ListModel<Opdracht>();
		listRight = new JList<Opdracht>(modelRight);
		listRight.setCellRenderer(new OpdrachtCellRenderer());
		spListRight = new JScrollPane(listRight);
		spListRight.setBounds(497, 105, 437, 288);

		
		o = new OpstartController();
		modelLeft = new ListModel<Opdracht>(o.getPersistentie().getOpdrachtCatalogus().getListOpdrachten());
		listLeft = new JList<Opdracht>(modelLeft);
		listLeft.setCellRenderer(new OpdrachtCellRenderer());
		spListLeft = new JScrollPane(listLeft);
	    spListLeft.setBounds(12, 105, 364, 288);

		
		bOpdrachtVerwijderen = new JButton("<<<<");
		bOpdrachtVerwijderen.setBounds(405, 243, 74, 25);
		bOpdrachtVerwijderen.addActionListener(new RemoveOpdrachtListener());
		
		bOpdrachtToevoegen = new JButton(">>>>");
		bOpdrachtToevoegen.setBounds(405, 177, 74, 25);
		bOpdrachtToevoegen.addActionListener(new AddOpdrachtListener());
		
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
		//Combobox met auteur van de gemaakte quiz
		cbKlas = new JComboBox<String>(); 
		cbKlas.setBounds(450, 12, 62, 24);
		cbKlas.addItem(" -");
		
		lblAuteur = new JLabel("Auteur");
		lblAuteur.setBounds(539, 17, 48, 15);
		//Combobox met auteur van de gemaakte quiz
		cbAuteur = new JComboBox<String>();
		cbAuteur.setBounds(605, 12, 137, 24);
		//defaultwaarde toevoegen
		cbAuteur.addItem(" -");
			//JComboBox opvullen met Enum Categorie
			Leraar [] auteur = Leraar.values();
			for(Leraar e : auteur){
				cbAuteur.addItem(e.toString());
			}
		 
        frame.setLocationRelativeTo(null);
		//frame.pack();
		
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
		pBottom.add(lblSorteren);
		pBottom.add(cbSorteren);
		pBottom.add(cbCategorie);
		pBottom.add(spListLeft);
		pBottom.add(bOpdrachtToevoegen);
		pBottom.add(bOpdrachtVerwijderen);
		pBottom.add(spListRight);
		pBottom.add(lblAantalToegevoegdeOpdrachten);
		pBottom.add(lblCounter);
		pBottom.add(bVraagOmhoog);
	}
	
    class AddOpdrachtListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
          int selected[] = listLeft.getSelectedIndices();
          ListModel<Opdracht> model = new ListModel<Opdracht>();
          for (int i = 0; i < selected.length; i++) {
                  hsRechts.add((Opdracht) listLeft.getModel().getElementAt(selected[i]));
          }
          for(Opdracht o : hsRechts){
                  model.addElement(o);
          }
          listRight.setModel(model);
          listRight.setCellRenderer(new OpdrachtCellRenderer());
		}// Einde ActionListener
	}// Einde inner class
	
	// Inner class om uit de rechte JList objecten te verwijderen
	class RemoveOpdrachtListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int selected[] = listRight.getSelectedIndices();
            ListModel<Opdracht> model = new ListModel<Opdracht>();
            for (int i = 0; i < selected.length; i++) {
                    hsRechts.remove((Opdracht) listRight .getModel().getElementAt(selected[i]));
            }
            for(Opdracht o : hsRechts){
                    model.addElement(o);
            }
            listRight.setModel(model);
            listRight.setCellRenderer(new OpdrachtCellRenderer());
	  }// Einde ActionListener
	}// Einde inner class

	// Inner class om uitzicht van cellen te bepalen
	class OpdrachtCellRenderer extends JLabel implements ListCellRenderer<Object> {
		private static final long serialVersionUID = 1L;
		private Color HIGHLIGHT_COLOR = new Color(0, 0, 128);

		  public OpdrachtCellRenderer() {
		    setOpaque(true);
		    setIconTextGap(12);
		  }// Einde constructor

		  public Component getListCellRendererComponent(JList<?> list, Object value,
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
		  }// Einde method
		}// Einde inner class
}// Einde class




