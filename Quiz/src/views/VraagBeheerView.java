package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.VraagController;
import model.Opdracht;
import model.Vraag;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;

public class VraagBeheerView extends JDialog {

	public static VraagController controller;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField vraagField;
	private JTextField aantalPogingen;
	private JTextField maximumAntwoordTijd;
	private JTextField juistAntwoordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			controller = new VraagController();
			VraagBeheerView dialog = new VraagBeheerView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VraagBeheerView() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblVraag = new JLabel("Vraag");
		vraagField = new JTextField();
		vraagField.setColumns(10);
		JLabel lblCatergorie = new JLabel("Catergorie");
		JComboBox comboBox = new JComboBox();
		aantalPogingen = new JTextField();
		aantalPogingen.setColumns(10);
		maximumAntwoordTijd = new JTextField();
		maximumAntwoordTijd.setColumns(10);
		juistAntwoordField = new JTextField();
		juistAntwoordField.setColumns(10);
		JComboBox vraagType = new JComboBox();
		JLabel lblType = new JLabel("Type");
		JLabel lblAantalPogingen = new JLabel("Aantal pogingen");
		JLabel lblMaximumAntwoordtijd = new JLabel("Maximum antwoordtijd");
		JLabel lblJuistAntwoord = new JLabel("Juist antwoord");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(4)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCatergorie)
						.addComponent(lblType)
						.addComponent(lblAantalPogingen)
						.addComponent(lblVraag)
						.addComponent(lblMaximumAntwoordtijd)
						.addComponent(lblJuistAntwoord))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(vraagField, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
						.addComponent(comboBox, 0, 284, Short.MAX_VALUE)
						.addComponent(vraagType, 0, 284, Short.MAX_VALUE)
						.addComponent(aantalPogingen, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
						.addComponent(maximumAntwoordTijd, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
						.addComponent(juistAntwoordField, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(vraagField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblVraag))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCatergorie)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(vraagType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblType))
					.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(aantalPogingen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAantalPogingen))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(maximumAntwoordTijd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMaximumAntwoordtijd))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(juistAntwoordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblJuistAntwoord))
					.addGap(29))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						/*Vraag v = new Vraag(comboBox.getSelectedItem(),vraagField.getText());
						
						controller.VraagUpdate(v);*/
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void SetView(Opdracht geselecteerdeOpdracht) {
		
		
	}

}
