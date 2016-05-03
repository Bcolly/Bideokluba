package interfazeGrafikoa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import bideoklub.Libre;

public class Librea extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Librea frame = new Librea();
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
	public Librea() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 221, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Libre Lib = new Libre();
		
		JLabel lblAukeratuHauetakoBat = new JLabel("Aukeratu hauetako bat:");
		lblAukeratuHauetakoBat.setBounds(5, 5, 424, 14);
		contentPane.add(lblAukeratuHauetakoBat);
		
		JButton btnKatalogoaIkusi = new JButton("Katalogoa Ikusi");
		btnKatalogoaIkusi.setBounds(5, 58, 193, 73);
		btnKatalogoaIkusi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				KatalogoaIn frame = new KatalogoaIn();
				frame.setVisible(true);
			}
		});
		contentPane.add(btnKatalogoaIkusi);
		
		JButton btnEstreinaldiakIkusi = new JButton("Estreinaldiak ikusi");
		btnEstreinaldiakIkusi.setBounds(5, 138, 194, 73);
		btnEstreinaldiakIkusi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EstreinaldiakIn frame = new EstreinaldiakIn();
				frame.setVisible(true);
			}
		});
		contentPane.add(btnEstreinaldiakIkusi);
		
		JButton btnSaioaAmaitu = new JButton("Saioa Amaitu");
		btnSaioaAmaitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSaioaAmaitu.setBounds(46, 222, 110, 23);
		contentPane.add(btnSaioaAmaitu);
	}
}
