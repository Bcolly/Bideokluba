package interfazeGrafikoa;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import bideoklub.Administratzailea;

public class AdministratzaileaIn extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministratzaileaIn frame = new AdministratzaileaIn();
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
	public AdministratzaileaIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Administratzailea admin = new Administratzailea();
		
		
		JButton button = new JButton("Katalogoa Ikusi");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				admin.katalogoaIkusi();
			}
		});
		button.setBounds(23, 207, 188, 44);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Estreinaldiak ikusi");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin.estreinaldiakIkusi();
			}
		});
		button_1.setBounds(221, 207, 186, 44);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Pelikula baja eman");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PelikulaBajaEman frame = new PelikulaBajaEman();
				frame.setVisible(true);
			}
		});
		button_2.setBounds(23, 150, 188, 46);
		contentPane.add(button_2);
		
		JButton btnBazkideaSortu = new JButton("Bazkidea sortu");
		btnBazkideaSortu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BazkideaSortu frame = new BazkideaSortu();
				frame.setVisible(true);
			}
		});
		btnBazkideaSortu.setBounds(23, 95, 188, 44);
		contentPane.add(btnBazkideaSortu);
		
		JButton btnPelikulaSortu = new JButton("Pelikula sortu");
		btnPelikulaSortu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PelikulaSortu frame = new PelikulaSortu();
				frame.setVisible(true);
			}
		});
		btnPelikulaSortu.setBounds(219, 95, 188, 44);
		contentPane.add(btnPelikulaSortu);
		
		JButton btnBazkideEgoera = new JButton("Bazkide egoera aldatu");
		btnBazkideEgoera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BazkideEgoeraAldatu frame = new BazkideEgoeraAldatu();
				frame.setVisible(true);
			}
		});
		btnBazkideEgoera.setBounds(221, 150, 188, 46);
		contentPane.add(btnBazkideEgoera);
		
		JButton btnSaioaAmaitu = new JButton("Saioa Amaitu");
		btnSaioaAmaitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSaioaAmaitu.setBounds(165, 271, 130, 23);
		contentPane.add(btnSaioaAmaitu);
		
		JLabel lblKaixoAdministratzailea = new JLabel("Kaixo administratzailea!!!");
		lblKaixoAdministratzailea.setBounds(10, 11, 144, 14);
		contentPane.add(lblKaixoAdministratzailea);
	
}
}
