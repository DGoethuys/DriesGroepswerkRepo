package views;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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


public class CreateQuizView {
	
	private OpstartController o;
	private HashSet<Opdracht> hsRechts = new HashSet<Opdracht>();
	private HashSet<Opdracht> hsLinks = new HashSet<Opdracht>();
	
	public JFrame frame;
	private JTextField tfOnderwerp;
	private JPanel pBoven;
	private JPanel pOnder;
	private JLabel lblToonOpdrachtenVan;
	private JComboBox<String> cbCategorie;
	private JLabel lblSorteren;
	private JComboBox<String> cbSorteren;
	private JLabel lblAantalToegevoegdeOpdrachten;
	private JButton bVraagOmhoog;
	private JList<Opdracht> listRechts;
	private ListModel<Opdracht> modelRechts;
	private JScrollPane spListRechts;
	private JList<Opdracht> listLinks;
	private ListModel<Opdracht> modelLinks;
	private JScrollPane spListLinks;
	private JButton bOpdrachtVerwijderen;
	private JButton bOpdrachtToevoegen;
	private JLabel lblTeller;
	private JLabel lblOnderwerp;
	private JLabel lblKlas;
	private JComboBox<String> cbKlas;
	private JLabel lblAuteur;
	private JComboBox<String> cbAuteur;

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

	public CreateQuizView() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 936, 556);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pBoven = new JPanel();
		pBoven.setBounds(0, 0, 934, 91);
		
		pOnder = new JPanel();
		pOnder.setBounds(0, 109, 934, 418);
		
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
		cbCategorie.addActionListener(new VeranderTypeListener());
			
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
		
		modelRechts = new ListModel<Opdracht>();
		listRechts = new JList<Opdracht>(modelRechts);
		listRechts.setCellRenderer(new OpdrachtCellRenderer());
		spListRechts = new JScrollPane(listRechts);
		spListRechts.setBounds(497, 105, 437, 288);

		
		o = new OpstartController();
		hsLinks = new HashSet<Opdracht>(o.getPersistentie().getOpdrachtCatalogus().getListOpdrachten());
		modelLinks = new ListModel<Opdracht>(hsLinks);
		listLinks = new JList<Opdracht>(modelLinks);
		listLinks.setCellRenderer(new OpdrachtCellRenderer());
		spListLinks = new JScrollPane(listLinks);
	    spListLinks.setBounds(12, 105, 364, 288);

		
		bOpdrachtVerwijderen = new JButton("<<<<");
		bOpdrachtVerwijderen.setBounds(405, 243, 74, 25);
		bOpdrachtVerwijderen.addActionListener(new RemoveOpdrachtListener());
		
		bOpdrachtToevoegen = new JButton(">>>>");
		bOpdrachtToevoegen.setBounds(405, 177, 74, 25);
		bOpdrachtToevoegen.addActionListener(new AddOpdrachtListener());
		
		lblTeller = new JLabel("");
		lblTeller.setBounds(759, 32, 0, 0);
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
		frame.getContentPane().add(pBoven);
		pBoven.setLayout(null);
		pBoven.add(RegistreerQuiz);
		pBoven.add(lblOnderwerp);
		pBoven.add(tfOnderwerp);
		pBoven.add(lblKlas);
		pBoven.add(cbKlas);
		pBoven.add(lblAuteur);
		pBoven.add(cbAuteur);
		frame.getContentPane().add(pOnder);
		pOnder.setLayout(null);
		pOnder.add(lblToonOpdrachtenVan);
		pOnder.add(lblSorteren);
		pOnder.add(cbSorteren);
		pOnder.add(cbCategorie);
		pOnder.add(spListLinks);
		pOnder.add(bOpdrachtToevoegen);
		pOnder.add(bOpdrachtVerwijderen);
		pOnder.add(spListRechts);
		pOnder.add(lblAantalToegevoegdeOpdrachten);
		pOnder.add(lblTeller);
		pOnder.add(bVraagOmhoog);
	}
	
    class AddOpdrachtListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
          int selected[] = listLinks.getSelectedIndices();
          ListModel<Opdracht> model = new ListModel<Opdracht>();
          for (int i = 0; i < selected.length; i++) {
                  hsRechts.add((Opdracht) listLinks.getModel().getElementAt(selected[i]));
          }
          for(Opdracht o : hsRechts){
                  model.addElement(o);
          }
          listRechts.setModel(model);
          listRechts.setCellRenderer(new OpdrachtCellRenderer());
		}// Einde ActionListener
	}// Einde inner class
    
    // Inner class om uit de rechte JList objecten te verwijderen
	class RemoveOpdrachtListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int selected[] = listRechts.getSelectedIndices();
            ListModel<Opdracht> model = new ListModel<Opdracht>();
            for (int i = 0; i < selected.length; i++) {
                    hsRechts.remove((Opdracht) listRechts .getModel().getElementAt(selected[i]));
            }
            for(Opdracht o : hsRechts){
                    model.addElement(o);
            }
            listRechts.setModel(model);
            listRechts.setCellRenderer(new OpdrachtCellRenderer());
	  }// Einde ActionListener
	}// Einde inner class
	
	class VeranderTypeListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("in VeranderTypeListener");
			String c = cbCategorie.getSelectedItem().toString();
			System.out.println("String gegeven aan c variabele");
			hsLinks = new HashSet<Opdracht>(o.getPersistentie().getOpdrachtCatalogus().getListOpdrachten());
			if(!hsLinks.isEmpty()){
			 System.out.println("hsLinks volgestoken");
			}else{
				System.out.println("hsLinks niet volgestoken");
			}
			if(c == " -"){
				System.out.println("c was \" -\"");
			}else{
				System.out.println("c was " + c);
				volgensCategorie(c);
			}
		modelLinks = new ListModel<Opdracht>(hsLinks);
		}// Einde ActionListener
	}// Einde inner class
	
	//method om opdrachten aan lijst toe te voegen voor een categorie
	public void volgensCategorie(String c){
		System.out.println("in volgensCategorie");
		HashSet<Opdracht> hsTemp = hsLinks;
		for(Opdracht o : hsLinks){
			System.out.println("in for met opdracht" + o.toString());
			if(!o.getType().contains(c)){
				System.out.println("in if gegdraakt");
				hsTemp.remove(o);
				System.out.println("remove gelukt");
			}
		}
		hsLinks = hsTemp;
		modelLinks = new ListModel<Opdracht>(hsLinks);
	}
	
	

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