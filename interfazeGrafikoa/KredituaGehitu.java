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

import bideoklub.Bazkidea;
import bideoklub.Menua;


public class KredituaGehitu extends JFrame {
	


		private JPanel contentPane;
		private JTextField textField;
		


		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						KredituaGehitu frame = new KredituaGehitu();
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
		public KredituaGehitu() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			setBounds(100, 100, 338, 203);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblJarriHemenItzuli = new JLabel("Jarri hemen gehitu nahi duzun kreditu kantitatea!");
			lblJarriHemenItzuli.setBounds(10, 53, 361, 14);
			contentPane.add(lblJarriHemenItzuli);
			
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(10, 76, 283, 20);
			contentPane.add(textField);

			JButton btnItzuli = new JButton("Gehitu");
			btnItzuli.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Bazkidea bazkide = new Bazkidea();
					JOptionPane a = new JOptionPane();
					a.showMessageDialog(null,bazkide.kredituaGehitu(Menua.getMenua().kodeaLortu(),textField.getText()));
					dispose();
					BazkideaIn.getBazkide().diruaEguneratu();
				}
			});
			btnItzuli.setBounds(10, 107, 89, 23);
			contentPane.add(btnItzuli);
			
			JButton btnIrten = new JButton("Irten");
			btnIrten.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnIrten.setBounds(109, 107, 89, 23);
			contentPane.add(btnIrten);
		}
	}