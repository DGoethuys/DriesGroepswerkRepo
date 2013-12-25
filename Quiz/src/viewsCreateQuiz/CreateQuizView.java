package viewsCreateQuiz;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import persistentie.PersistentieFacade;
import viewsCreateQuiz.OpdrachtList;
import viewsCreateQuiz.OpdrachtTableModel;
import model.*;
import Enums.*;

public class CreateQuizView {
	
	private PersistentieFacade p;

	
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
	private OpdrachtList listRechts;
	private OpdrachtTableModel modelRechts;
	private JTable tableRechts;
	private JScrollPane spListRechts;
	private OpdrachtList listLinks;
	private OpdrachtTableModel modelLinks;
	private JTable tableLinks;
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
		p = PersistentieFacade.getPersistentie();
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
			Categorie [] categoriën = Categorie.values();
			for(Categorie c : categoriën){
				cbCategorie.addItem(c.toString());
			}
		cbCategorie.addActionListener(new VeranderCategorieListener());
			
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
		
		listRechts = new OpdrachtList();
		modelRechts = new OpdrachtTableModel(listRechts);
		modelRechts.addMaxScoreToKolomNamen();
		tableRechts = new JTable();
		spListRechts = new JScrollPane(tableRechts);
		spListRechts.setBounds(497, 105, 437, 288);

		listLinks= new OpdrachtList();
		for(Iterator<Opdracht> i = p.getOpdrachtCatalogus().iterator(); i.hasNext();){
			Opdracht o = i.next();
			listLinks.addOpdracht(o);
		}
		modelLinks = new OpdrachtTableModel(listLinks);
		tableLinks = new JTable(modelLinks);
		spListLinks = new JScrollPane(tableLinks);
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
	
	private void vulLinksJTableUitDB(){
		listLinks = new OpdrachtList();
		for(Iterator<Opdracht> i = p.getOpdrachtCatalogus().iterator(); i.hasNext();){
			listLinks.addOpdracht(i.next());
		}
		modelLinks = new OpdrachtTableModel(listLinks);
		tableLinks.setModel(modelLinks);
	}
	
	private void vulLinksJTableUitDBVolgensCategorie(String c){
		listLinks = new OpdrachtList();
		for(Iterator<Opdracht> i = p.getOpdrachtCatalogus().iterator(); i.hasNext();){
			Opdracht o = i.next();
			if(o.getCategorie().toString().equals(c)){
				listLinks.addOpdracht(o);
			}
		}
		modelLinks = new OpdrachtTableModel(listLinks);
		tableLinks.setModel(modelLinks);
	}
	
	class AddOpdrachtListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int selected[] = tableLinks.getSelectedRows();
			for (int i = 0; i < selected.length; i++) {
				if(!listRechts.contains(listLinks.getOpdracht(selected[i]))){
					listRechts.addOpdracht(listLinks.getOpdracht(selected[i]));
				}
			}
			modelRechts = new OpdrachtTableModel(listRechts);
			modelRechts.addMaxScoreToKolomNamen();
			tableRechts.setModel(modelRechts);
		}// Einde ActionListener
	}// Einde inner class

	 // Inner class om uit de rechte JList objecten te verwijderen
	 class RemoveOpdrachtListener implements ActionListener {
		 public void actionPerformed(ActionEvent e) {
			 int selected[] = tableRechts.getSelectedRows();
			 for (int i = 0; i < selected.length; i++) {
				 listRechts.removeOpdracht(listRechts.getOpdracht(selected[i]));
				}
			modelRechts = new OpdrachtTableModel(listRechts);
			tableRechts.setModel(modelRechts);
			}// Einde ActionListener
		}// Einde inner class
	
	class VeranderCategorieListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String c = cbCategorie.getSelectedItem().toString();
			if(c == " -"){
				vulLinksJTableUitDB();
			}else{
				vulLinksJTableUitDBVolgensCategorie(c);
			}
		}// Einde ActionListener
	}// Einde inner class
	/*
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
		*/
	
}// Einde class