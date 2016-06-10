package igu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Travel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class ReservationWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Travel selectedTravel;
	private JPanel panel_1;
	private JLabel lblNombre;
	private JTextField txNombre;

	/**
	 * Create the dialog.
	 */
	public ReservationWindow(MainWindow parent, Travel selectedTravel) {
		this.selectedTravel = selectedTravel;
		setSize(450, 300);
		setLocationRelativeTo(parent);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 2, 0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(new GridLayout(4, 0, 0, 0));
			panel.add(getPanel_1());
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JLabel lblResumen = new JLabel("Resumen:");
				panel.add(lblResumen, BorderLayout.NORTH);
			}
			{
				JTextArea textArea = new JTextArea();
				panel.add(textArea);
				
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.setMnemonic('O');
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				cancelButton.setMnemonic('C');
				buttonPane.add(cancelButton);
			}
		}
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new GridLayout(2, 2, 0, 0));
			panel_1.add(getLblNombre());
			panel_1.add(getTxNombre());
		}
		return panel_1;
	}
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre: ");
		}
		return lblNombre;
	}
	private JTextField getTxNombre() {
		if (txNombre == null) {
			txNombre = new JTextField();
			txNombre.setColumns(10);
		}
		return txNombre;
	}
}
