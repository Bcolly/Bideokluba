package interfazeGrafikoa;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import bideoklub.Bazkidea;
import bideoklub.Bideokluba;
import bideoklub.Menua;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.TextArea;

public class PelikulaItzuli extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PelikulaItzuli frame = new PelikulaItzuli();
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
	public PelikulaItzuli() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setBounds(100, 100, 381, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJarriHemenItzuli = new JLabel("Jarri hemen itzuli nahi duzun pelikularen kodea");
		lblJarriHemenItzuli.setBounds(10, 11, 361, 14);
		contentPane.add(lblJarriHemenItzuli);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 36, 283, 20);
		contentPane.add(textField);

		JButton btnItzuli = new JButton("Itzuli");
		btnItzuli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Bazkidea bazkide = new Bazkidea();
				String mezua = bazkide.pelikulaItzuli(textField.getText(), Menua.getMenua().kodeaLortu());
				JOptionPane a = new JOptionPane();
				a.showMessageDialog(null, mezua);
				pelikulaLista();
			}
		});
		btnItzuli.setBounds(10, 67, 89, 23);
		contentPane.add(btnItzuli);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		pelikulaLista();
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(10, 120, 335, 142);
		contentPane.add(scrollPane);
		
		JLabel lblZurePelikulak = new JLabel("Zure Pelikulak:");
		lblZurePelikulak.setBounds(20, 101, 89, 14);
		contentPane.add(lblZurePelikulak);
		
		JButton btnIrten = new JButton("Irten");
		btnIrten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnIrten.setBounds(109, 67, 89, 23);
		contentPane.add(btnIrten);
	}

	private void pelikulaLista() {
		ArrayList<String> pelis = Bideokluba.getDB().bezeroarenPelikulak(Menua.getMenua().kodeaLortu());
		Iterator<String> itr = pelis.iterator();
		int i = 0;
		textArea.setText(null);
		while (itr.hasNext()) {
			i++;
			String titulo = itr.next();
			String kodigo = itr.next();
			String erantzuna = i+". "
					+titulo+" - "+kodigo+"\r\n";
			textArea.setText(textArea.getText()+erantzuna);
		}
	}
}


