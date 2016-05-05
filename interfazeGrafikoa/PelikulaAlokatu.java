package interfazeGrafikoa;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import bideoklub.Bazkidea;
import bideoklub.Menua;

public class PelikulaAlokatu extends JFrame {

	private JPanel contentPane;
	private JTextField txtUty;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PelikulaAlokatu frame = new PelikulaAlokatu();
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
	public PelikulaAlokatu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJarriZePelikula = new JLabel("Jarri alokatu nahi duzun pelikularen kodea");
		lblJarriZePelikula.setBounds(10, 47, 361, 14);
		contentPane.add(lblJarriZePelikula);
		
		txtUty = new JTextField();
		txtUty.setBounds(10, 72, 283, 20);
		contentPane.add(txtUty);
		txtUty.setColumns(10);
		
		JButton btnAlokatu = new JButton("Alokatu");
		btnAlokatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Bazkidea bazkide = new Bazkidea();
				JOptionPane a = new JOptionPane();
				a.showMessageDialog(null, bazkide.pelikulaAlokatu(txtUty.getText(), Menua.getMenua().kodeaLortu()));
				dispose();
				BazkideaIn.getBazkide().diruaEguneratu();
			}
		});
		btnAlokatu.setBounds(10, 103, 89, 23);
		contentPane.add(btnAlokatu);
	}

}
