package interfazeGrafikoa;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import bideoklub.Administratzailea;
import bideoklub.Menua;

public class BazkideEgoeraAldatu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BazkideEgoeraAldatu frame = new BazkideEgoeraAldatu();
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
	public BazkideEgoeraAldatu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJarriHemenItzuli = new JLabel("Jarri hemen aldatu nahi duzun bazkidearen kodea");
		lblJarriHemenItzuli.setBounds(10, 53, 361, 14);
		contentPane.add(lblJarriHemenItzuli);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 76, 283, 20);
		contentPane.add(textField);

		JButton btnItzuli = new JButton("Aldatu");
		btnItzuli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Administratzailea admin = new Administratzailea();

				admin.bazkideEgoera(textField.getText());
				JOptionPane a = new JOptionPane();
				dispose();
			}
		});
		btnItzuli.setBounds(10, 107, 89, 23);
		contentPane.add(btnItzuli);
	}
}