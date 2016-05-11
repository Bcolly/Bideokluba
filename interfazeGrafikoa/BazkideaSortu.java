package interfazeGrafikoa;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import bideoklub.Administratzailea;

public class BazkideaSortu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField textField_2;
	private JTextField textField_3;
	
	private Administratzailea admin = new Administratzailea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BazkideaSortu frame = new BazkideaSortu();
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
	public BazkideaSortu() {
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
		
		JLabel lblNewLabel = new JLabel("Jarri bazkidearen datuak");
		lblNewLabel.setBounds(10, 11, 160, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblIzena = new JLabel("Izena (GUTXIENEZ 3 KARAKTERE)");
		lblIzena.setBounds(10, 36, 300, 14);
		contentPane.add(lblIzena);
		JLabel lblAbizena = new JLabel("Abizena (GUTXIENEZ 3 KARAKTERE)");
		lblAbizena.setBounds(10, 81, 300, 14);
		contentPane.add(lblAbizena);
		
		JLabel lblPasahitza = new JLabel("Pasahitza");
		lblPasahitza.setBounds(10, 133, 60, 14);
		contentPane.add(lblPasahitza);
		
		JLabel lblHelbidea = new JLabel("Helbidea");
		lblHelbidea.setBounds(10, 177, 60, 14);
		contentPane.add(lblHelbidea);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 95, 127, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JPasswordField();
		textField_2.setBounds(10, 146, 127, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(10, 191, 378, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnSortu = new JButton("Sortu");
		btnSortu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane a = new JOptionPane();
				a.showMessageDialog(null, admin.bazkideaSortu(textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText()));
				dispose();
			}
		});
		btnSortu.setBounds(20, 222, 89, 23);
		contentPane.add(btnSortu);
		
		JButton btnIrten = new JButton("Irten");
		btnIrten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnIrten.setBounds(135, 222, 89, 23);
		contentPane.add(btnIrten);
	}
}
