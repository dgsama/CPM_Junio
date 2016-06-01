package igu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;

public class VentanaPrueba extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnChangeColor;
	public boolean clicked = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrueba frame = new VentanaPrueba();
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
	public VentanaPrueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(1, 0, 0, 0));
			panel.add(getBtnChangeColor());
		}
		return panel;
	}

	private JButton getBtnChangeColor() {
		if (btnChangeColor == null) {
			btnChangeColor = new JButton("Change Color");
			btnChangeColor.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent arg0) {
					btnChangeColor.setBackground(Color.white);
				}
			});
			btnChangeColor.setBackground(Color.YELLOW);
			btnChangeColor.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnChangeColor.setBackground(Color.CYAN);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (clicked == false)
						btnChangeColor.setBackground(Color.YELLOW);
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					btnChangeColor.setBackground(Color.BLACK);
					clicked = true;
				}
			});
			btnChangeColor.setVerticalAlignment(SwingConstants.CENTER);
		}
		return btnChangeColor;
	}
}
