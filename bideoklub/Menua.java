package bideoklub;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfazeGrafikoa.AdministratzaileaIn;
import interfazeGrafikoa.BazkideaIn;
import interfazeGrafikoa.DatuakAldatu;
import interfazeGrafikoa.Librea;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Enumeration;

import javax.swing.Box;

public class Menua extends JFrame {

	private static Menua myMenu;
	private JPanel contentPane;
	private JPanel panel;
	private JButton btnOk;
	private JLabel label;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JPasswordField textField_1;
	private Component verticalStrut;
	private JRadioButton rdbtnAdmin;
	private JRadioButton rdbtnErab;
	private JRadioButton rdbtnLib;
	private ButtonGroup butGroup;
	private BazkideaIn bazLei;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menua frame = new Menua();
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
	public Menua() {
		initialize();
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		butGroup=new ButtonGroup();
		contentPane.add(getPanel(), BorderLayout.CENTER);
		contentPane.add(getPanel_1(), BorderLayout.NORTH);
		contentPane.add(getPanel_2(), BorderLayout.SOUTH);
		textField.setText(null);
		textField_1.setText(null);
	}
	public String kodeaLortu(){
		return Menua.getMenua().getTextField().getText();
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getPanel_3(), BorderLayout.NORTH);
			panel.add(getPanel_4(), BorderLayout.CENTER);
			panel.add(getPanel_5(), BorderLayout.SOUTH);
		}
		return panel;
	}
	public static Menua getMenua(){
		if (myMenu == null) {
			myMenu = new Menua();
		}
		return myMenu;
	}
	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("OK");
			btnOk.addActionListener(new ActionListener(){
				
				@Override
				public void actionPerformed(ActionEvent e){
					for(Enumeration<AbstractButton> buttons = Menua.getMenua().butGroup.getElements(); buttons.hasMoreElements();){
						AbstractButton button = buttons.nextElement();
						if(button.isSelected()){
							if(button.getText().equals("Libre")){
								Librea libLei = new Librea();
								libLei.setVisible(true);
								dispose();
							}
							else if(button.getText().equals("Erabiltzaile")){
								if(Bideokluba.getDB().login(kodeaLortu(), getTextField_1().getText())){
									bazLei = BazkideaIn.getBazkide();
									bazLei.setVisible(true);
									dispose();
								}
								else{
									 JOptionPane a = new JOptionPane();
									 a.showMessageDialog(null, "Erabiltzaile eta pasahitz okerrak");
									 textField_1.setText(null);
								}
							}
							else{
								AdministratzaileaIn adminLei = new AdministratzaileaIn();
								adminLei.setVisible(true);
								dispose();
							}
						}
					}
				}
			});
		}
		return btnOk;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Aukeratu zure egoera:");
			label.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return label;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.add(getLabel());
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.add(getBtnOk());
			panel_2.add(getVerticalStrut());
		}
		return panel_2;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.add(getRdbtnAdmin());
			panel_3.add(getRdbtnErab());
		}
		return panel_3;
	}
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel_4.add(getLblNewLabel());
			panel_4.add(getTextField());
			panel_4.add(getLblNewLabel_1());
			panel_4.add(getTextField_1());
		}
		return panel_4;
	}
	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.add(getRdbtnLib());
		}
		return panel_5;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
			textField.addKeyListener(new KeyListener(){
				
				@Override
				public void keyPressed(KeyEvent arg0) {
					// TODO Auto-generated method stub
				}

				@Override
				public void keyReleased(KeyEvent arg0) {
					// TODO Auto-generated method stub
					Menua.getMenua().getTextField().setText(textField.getText());
				}

				@Override
				public void keyTyped(KeyEvent arg0) {
					// TODO Auto-generated method stub
				}
			});
		}
		return textField;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("User");
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Password");
		}
		return lblNewLabel_1;
	}
	private JPasswordField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JPasswordField();
			textField_1.setColumns(10);
			textField_1.addKeyListener(new KeyListener(){
				
				@Override
				public void keyPressed(KeyEvent arg0) {
					// TODO Auto-generated method stub
				}

				@Override
				public void keyReleased(KeyEvent arg0) {
					// TODO Auto-generated method stub
					Menua.getMenua().getTextField_1().setText(textField_1.getText());
				}

				@Override
				public void keyTyped(KeyEvent arg0) {
					// TODO Auto-generated method stub
				}
			});
		}
		return textField_1;
	}
	
	private Component getVerticalStrut() {
		if (verticalStrut == null) {
			verticalStrut = Box.createVerticalStrut(65);
		}
		return verticalStrut;
	}
	private JRadioButton getRdbtnAdmin() {
		if (rdbtnAdmin == null) {
			rdbtnAdmin = new JRadioButton("Administratzaile");
			rdbtnAdmin.addActionListener(new ActionListener(){
				
				@Override
				public void actionPerformed(ActionEvent e){
					Menua.getMenua().getRdbtnAdmin().setSelected(true);
				}
			});
			butGroup.add(rdbtnAdmin);
		}
		return rdbtnAdmin;
	}
	private JRadioButton getRdbtnErab() {
		if (rdbtnErab == null) {
			rdbtnErab = new JRadioButton("Erabiltzaile");
			rdbtnErab.addActionListener(new ActionListener(){
				
				@Override
				public void actionPerformed(ActionEvent e){
					Menua.getMenua().getRdbtnErab().setSelected(true);
				}
			});
			butGroup.add(rdbtnErab);
		}
		return rdbtnErab;
	}
	private JRadioButton getRdbtnLib() {
		if (rdbtnLib == null) {
			rdbtnLib = new JRadioButton("Libre",true);
			rdbtnLib.addActionListener(new ActionListener(){
				
				@Override
				public void actionPerformed(ActionEvent e){
					Menua.getMenua().getRdbtnLib().setSelected(true);
				}
			});
			butGroup.add(rdbtnLib);
		}
		return rdbtnLib;
	}
	public void hasieratu() {
		myMenu = new Menua();
	}
}