package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;
import java.io.LineNumberInputStream;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import io.FileManager;
import logica.Travel;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JScrollPane scpLista;
	private JList<Travel> listViajes;
	private DefaultListModel<Travel> modeloViajes;
	private FileManager reader;
	private JPanel panel;
	private JTextField txInfo;
	private JLabel lblInfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		reader = new FileManager("viajes.dat");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// POSITION OF THE WINDOW
		setSize(600, 450);
		setLocationRelativeTo(null);
		////////////////////////

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getScpLista(), BorderLayout.CENTER);
		contentPane.add(getPanel(), BorderLayout.SOUTH);
	}

	private JScrollPane getScpLista() {
		if (scpLista == null) {
			scpLista = new JScrollPane();
			scpLista.setViewportView(getListViajes());
		}
		return scpLista;
	}

	private JList getListViajes() {
		if (listViajes == null) {
			listViajes = new JList();
			listViajes.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if (listViajes.getSelectedValue() != null) {
						txInfo.setText(listViajes.getSelectedValue().getDescription());
					}
				}
			});
			listViajes.setBorder(new TitledBorder(null, "TRAVELS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			modeloViajes = new DefaultListModel<Travel>();

			for (Travel t : reader.getTrips()) {
				modeloViajes.addElement(t);
			}
			listViajes.setModel(modeloViajes);
		}
		return listViajes;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getLblInfo());
			panel.add(getTxInfo());
		}
		return panel;
	}

	private JTextField getTxInfo() {
		if (txInfo == null) {
			txInfo = new JTextField();
			txInfo.setColumns(10);
		}
		return txInfo;
	}

	private JLabel getLblInfo() {
		if (lblInfo == null) {
			lblInfo = new JLabel("info:");
		}
		return lblInfo;
	}
}
