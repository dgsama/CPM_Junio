package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;
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
import javax.swing.plaf.SeparatorUI;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JMenuBar;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JScrollPane scpLista;
	private JList<Travel> listViajes;
	private DefaultListModel<Travel> modeloViajes;
	private FileManager reader;
	private JPanel pnInfo;
	private JLabel lblInfo;
	private JTextArea txaInfo;
	private JMenuBar menuBar;
	private JPanel pnSouth;
	private JPanel pnButton;
	private JButton btnReservar;

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
		setJMenuBar(getMenuBar_1());
		////////////////////////

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getScpLista());
		contentPane.add(getPnSouth(), BorderLayout.SOUTH);
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
			listViajes.setFont(new Font("Tahoma", Font.PLAIN, 14));
			listViajes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listViajes.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if (listViajes.getSelectedValue() != null) {
						// Si son varios, mejor un metodo fuera que lo haga
						// defrente
						txaInfo.setText(listViajes.getSelectedValue().getDescription());
					}
				}
			});
			listViajes.setBorder(new TitledBorder(null, "TRAVELS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			modeloViajes = new DefaultListModel<Travel>();

			for (Travel t : reader.getTrips()) {
				modeloViajes.addElement(t);
			}
			listViajes.setModel(modeloViajes);
			listViajes.setSelectedIndex(0);
		}
		return listViajes;
	}

	private JPanel getPnInfo() {
		if (pnInfo == null) {
			pnInfo = new JPanel();
			pnInfo.setLayout(new GridLayout(0, 1, 0, 0));
			pnInfo.add(getLblInfo());
			pnInfo.add(getTxaInfo());
		}
		return pnInfo;
	}

	private JLabel getLblInfo() {
		if (lblInfo == null) {
			lblInfo = new JLabel(" INFO:   ");
		}
		return lblInfo;
	}

	private JTextArea getTxaInfo() {
		if (txaInfo == null) {
			txaInfo = new JTextArea();
			txaInfo.setLineWrap(true);
			txaInfo.setRows(1);
			txaInfo.setEditable(false);
		}
		return txaInfo;
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();

		}
		return menuBar;
	}

	private JPanel getPnSouth() {
		if (pnSouth == null) {
			pnSouth = new JPanel();
			pnSouth.setLayout(new BorderLayout(0, 0));
			pnSouth.add(getPnInfo());
			pnSouth.add(getPnButton(), BorderLayout.EAST);
		}
		return pnSouth;
	}

	private JPanel getPnButton() {
		if (pnButton == null) {
			pnButton = new JPanel();
			pnButton.add(getBtnReservar());
		}
		return pnButton;
	}

	private JButton getBtnReservar() {
		if (btnReservar == null) {
			btnReservar = new JButton("Reservar");
			btnReservar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					openCheckout();
				}
			});
		}
		return btnReservar;
	}

	private void openCheckout() {
		if (listViajes.getSelectedValue() != null) {
			Travel t = listViajes.getSelectedValue();
			new ReservationWindow(this, t).setVisible(true);
		}
	}
}
