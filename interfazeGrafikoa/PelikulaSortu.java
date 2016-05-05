package interfazeGrafikoa;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import bideoklub.Administratzailea;

public class PelikulaSortu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PelikulaSortu frame = new PelikulaSortu();
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
	public PelikulaSortu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 51, 127, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Jarri pelikularen datuak");
		lblNewLabel.setBounds(10, 11, 160, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblIzena = new JLabel("Titulua (GUTXIENEZ 2 KARAKTERE)");
		lblIzena.setBounds(10, 36,300, 14);
		contentPane.add(lblIzena);
		
		JLabel lblAbizena = new JLabel("Kostua");
		lblAbizena.setBounds(10, 81, 46, 14);
		contentPane.add(lblAbizena);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 95, 127, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSortu = new JButton("Sortu");
		btnSortu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane a = new JOptionPane();
				a.showMessageDialog(null, new Administratzailea().pelikulaSortu(textField.getText(),textField_1.getText()));
				dispose();
			}
		});
		btnSortu.setBounds(20, 222, 89, 23);
		contentPane.add(btnSortu);
	}
}