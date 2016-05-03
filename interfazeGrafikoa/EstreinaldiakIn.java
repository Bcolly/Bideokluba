package interfazeGrafikoa;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.Text;

import bideoklub.Libre;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class EstreinaldiakIn extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextArea textArea;
	private JButton btnItzuli;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KatalogoaIn frame = new KatalogoaIn();
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
	public EstreinaldiakIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Libre l = new Libre();
		
		textArea = new JTextArea();
		//scrollPane.setRowHeaderView(textArea);
		ArrayList<String> pelis = l.estreinaldiakIkusi();
		Iterator<String> itr = pelis.iterator();
		int i = 0;
		while (itr.hasNext()) {
			i++;
			String titulo = itr.next();
			String kodigo = itr.next();
			String precio = itr.next();
			String egoera = itr.next();
			String erantzuna = "Pelikula "+i+"\r\n"
					+"Titulua: "+titulo+"\r\nKodea: "+kodigo+"\r\n"
					+"Prezioa: "+precio+"\r\nEgoera: "+egoera+"\r\n\r\n\r\n";
			textArea.setText(textArea.getText()+erantzuna);
		}
		textArea.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		contentPane.add(scrollPane, BorderLayout.CENTER);	
		
		btnItzuli = new JButton("Itzuli");
		scrollPane.setColumnHeaderView(btnItzuli);
		btnItzuli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}