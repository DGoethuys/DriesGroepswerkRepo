package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;

import model.Opdracht;
import persistentie.PersistentieFacade;
import persistentie.PersistentieType;
import persistentie.TextPersistentie;
import controller.OpstartController;

public class jlistNest extends JPanel {

		  private JList opdrachtlist = new JList();

		  public jlistNest(PersistentieFacade persistentie) {
		    setLayout(new BorderLayout());
		    JButton button = new JButton("Print");
		    button.addActionListener(new PrintListener());
		    opdrachtlist = new JList(persistentie.getOpdrachtCatalogus().getListOpdrachten().toArray());
		    opdrachtlist.setCellRenderer(new OpdrachtCellRenderer());
		    opdrachtlist.setVisibleRowCount(4);
		    JScrollPane pane = new JScrollPane(opdrachtlist);

		    add(pane, BorderLayout.NORTH);
		    add(button, BorderLayout.SOUTH);
		  }

		  public static void main(String s[]) {
				PersistentieFacade persistentie = new TextPersistentie();
				OpstartController opstart = new OpstartController();
				PersistentieType type = new PersistentieType();
				persistentie = type.getPersistentie(opstart.setPersistentieFromInit());
				persistentie.laadData();
		    JFrame frame = new JFrame("Opdrachten");
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setContentPane(new jlistNest(persistentie));
		    frame.pack();
		    frame.setVisible(true);
		  }

		  // An inner class to respond to clicks on the Print button
		  class PrintListener implements ActionListener {
		    public void actionPerformed(ActionEvent e) {
		      int selected[] = opdrachtlist.getSelectedIndices();
		      System.out.println("Selected Elements:  ");

		      for (int i = 0; i < selected.length; i++) {
		    	  Opdracht element = (Opdracht) opdrachtlist.getModel()
		            .getElementAt(selected[i]);
		        System.out.println("  " + element.toString());
		      }
		    }
		  }
		}

		class OpdrachtCellRenderer extends JLabel implements ListCellRenderer {
		  private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);

		  public OpdrachtCellRenderer() {
		    setOpaque(true);
		    setIconTextGap(12);
		  }

		  public Component getListCellRendererComponent(JList list, Object value,
		      int index, boolean isSelected, boolean cellHasFocus) {
		    Opdracht entry = (Opdracht) value;
		    setText(entry.toString());
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
