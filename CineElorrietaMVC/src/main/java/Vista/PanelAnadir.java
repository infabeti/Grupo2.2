package Vista;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class PanelAnadir {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelAnadir window = new PanelAnadir();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PanelAnadir() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 475, 387);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel anadirlabel = new JLabel("AÑADIR");
		anadirlabel.setBounds(199, 13, 59, 33);
		anadirlabel.setFont(new Font("Impact", Font.PLAIN, 20));
		frame.getContentPane().add(anadirlabel);
		
		JLabel generolabel = new JLabel("GÉNERO");
		generolabel.setBounds(54, 83, 72, 14);
		frame.getContentPane().add(generolabel);
		
		JButton botoncancelar = new JButton("Cancelar");
		botoncancelar.setBounds(24, 285, 102, 31);
		frame.getContentPane().add(botoncancelar);		
		
		JButton botonconfirmar = new JButton("Confirmar");
		botonconfirmar.setBounds(343, 285, 102, 31);
		frame.getContentPane().add(botonconfirmar);
		
		JLabel nombrelabel = new JLabel("NOMBRE");
		nombrelabel.setBounds(204, 83, 54, 14);
		frame.getContentPane().add(nombrelabel);
		
		JLabel duracionlabel = new JLabel("DURACIÓN");
		duracionlabel.setBounds(350, 83, 65, 14);
		frame.getContentPane().add(duracionlabel);
		
		//nombre textfield
		textField = new JTextField();
		textField.setBounds(175, 102, 107, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		//duración textfield
		textField_1 = new JTextField();
		textField_1.setBounds(322, 102, 107, 23);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox generocomboBox = new JComboBox();
		generocomboBox.setBounds(24, 102, 107, 22);
		frame.getContentPane().add(generocomboBox);
		

		
	}
}

