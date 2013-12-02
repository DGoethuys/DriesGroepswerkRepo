package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class MainWindow implements ActionListener {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(252, 12, 124, 24);
		
		JLabel lblSorteerOpdrachtenOp = new JLabel("Sorteer opdrachten op");
		lblSorteerOpdrachtenOp.setBounds(12, 59, 162, 15);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(252, 54, 124, 24);
		
		JLabel lblAantalToegevoegdeOpdrachten = new JLabel("Aantal toegevoegde opdrachten");
		lblAantalToegevoegdeOpdrachten.setBounds(497, 32, 230, 15);
		
		JButton btnNewButton_1 = new JButton("^^^^^^");
		btnNewButton_1.setBounds(497, 53, 437, 40);
		
		JList list = new JList();
		list.setBounds(497, 105, 437, 288);
		
		JList list_1 = new JList();
		list_1.setBounds(12, 105, 364, 288);
		
		JButton btnNewButton_2 = new JButton("<<<<");
		btnNewButton_2.setBounds(405, 243, 74, 25);
		
		JButton btnNewButton_3 = new JButton(">>>>");
		btnNewButton_3.setBounds(405, 177, 74, 25);
		
		JLabel Counter = new JLabel("");
		Counter.setBounds(759, 32, 0, 0);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ondewerp");
		lblNewLabel.setBounds(20, 17, 74, 15);
		
		textField = new JTextField();
		textField.setBounds(106, 15, 278, 19);
		textField.setColumns(10);
		
		JLabel lblKlas = new JLabel("Klas");
		lblKlas.setBounds(402, 17, 30, 15);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(450, 12, 62, 24);
		
		JLabel lblAuteur = new JLabel("Auteur");
		lblAuteur.setBounds(539, 17, 48, 15);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(605, 12, 137, 24);
		
		JButton btnNewButton = new JButton("Registreer nieuwe quiz");
		btnNewButton.setBounds(20, 48, 728, 31);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.add(btnNewButton);
		panel_1.add(lblNewLabel);
		panel_1.add(textField);
		panel_1.add(lblKlas);
		panel_1.add(comboBox);
		panel_1.add(lblAuteur);
		panel_1.add(comboBox_1);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.add(lblToonOpdrachtenVan);
		panel.add(lblSorteerOpdrachtenOp);
		panel.add(comboBox_3);
		panel.add(comboBox_2);
		panel.add(list_1);
		panel.add(btnNewButton_3);
		panel.add(btnNewButton_2);
		panel.add(list);
		panel.add(lblAantalToegevoegdeOpdrachten);
		panel.add(Counter);
		panel.add(btnNewButton_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
