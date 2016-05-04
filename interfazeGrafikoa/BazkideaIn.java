package interfazeGrafikoa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import bideoklub.Bazkidea;
import bideoklub.Bideokluba;
import bideoklub.Menua;

public class BazkideaIn extends JFrame {

	private static BazkideaIn nBazkide;
	private JPanel contentPane;
	private JLabel lblNewLabel2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BazkideaIn frame = new BazkideaIn();
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
	private BazkideaIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Bazkidea Baz = new Bazkidea();
		
		JLabel lblNewLabel = new JLabel("Kaixo " + Bideokluba.getDB().bazkideOsoa(Menua.getMenua().kodeaLortu())[0]);
		lblNewLabel.setBounds(5, 5, 424, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel2 = new JLabel("Zure dirua: "+ Bideokluba.getDB().dirua(Menua.getMenua().kodeaLortu())+"€ da");
		lblNewLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel2, BorderLayout.NORTH);
		lblNewLabel2.setBounds(5, 5, 424, 14);
		contentPane.add(lblNewLabel2);
		
		JButton btnKatalogoaIkusi = new JButton("Katalogoa Ikusi");
		btnKatalogoaIkusi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				KatalogoaIn frame = new KatalogoaIn();
				frame.setVisible(true);
			}
		});
		btnKatalogoaIkusi.setBounds(38, 116, 175, 41);
		contentPane.add(btnKatalogoaIkusi);
		
		JButton button_1 = new JButton("Estreinaldiak ikusi");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EstreinaldiakIn frame = new EstreinaldiakIn();
				frame.setVisible(true);
			}
		});
		button_1.setBounds(215, 116, 175, 41);
		contentPane.add(button_1);
		
		JButton btnPelikulaAlokatu = new JButton("Pelikula alokatu");
		btnPelikulaAlokatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PelikulaAlokatu frame = new PelikulaAlokatu();
				frame.setVisible(true);
			}
		});
		btnPelikulaAlokatu.setBounds(38, 64, 175, 41);
		contentPane.add(btnPelikulaAlokatu);
		
		JButton btnPelikulaItzuli = new JButton("Pelikula itzuli");
		btnPelikulaItzuli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PelikulaItzuli frame = new PelikulaItzuli();
				frame.setVisible(true);
			}
		});
		btnPelikulaItzuli.setBounds(215, 64, 175, 41);
		contentPane.add(btnPelikulaItzuli);
	
	
	JButton btnSaioaAmaitu = new JButton("Saioa Amaitu");
	btnSaioaAmaitu.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			nBazkide=null;
			Menua.getMenua().hasieratu();;
			Menua.getMenua().setVisible(true);
			dispose();
		}
	});
	btnSaioaAmaitu.setBounds(46, 222, 110, 23);
	contentPane.add(btnSaioaAmaitu);
	
	JButton btnNewButton = new JButton("Kreditua Gehitu");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			KredituaGehitu frame = new KredituaGehitu();
			frame.setVisible(true);
			
		}
	});
	btnNewButton.setBounds(38, 168, 175, 43);
	contentPane.add(btnNewButton);
	
	JButton btnBazkideEgoera = new JButton("Bazkide egoera aldatu");
	btnBazkideEgoera.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			DatuakAldatu frame = new DatuakAldatu();
			frame.setVisible(true);
		}
	});
	btnBazkideEgoera.setBounds(215, 168, 175, 41);
	contentPane.add(btnBazkideEgoera);
}
	public static BazkideaIn getBazkide() {
		if (nBazkide == null) {
			nBazkide = new BazkideaIn();
		}
		return nBazkide;
	}
	
	public void diruaEguneratu() {
		lblNewLabel2.setText("Zure dirua: "+ Bideokluba.getDB().dirua(Menua.getMenua().kodeaLortu())+"€ da");
	}
}
