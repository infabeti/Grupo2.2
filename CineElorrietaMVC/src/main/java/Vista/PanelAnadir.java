package Vista;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Controlador.ControladorPanelAnadir;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAnadir extends JPanel{


	private JTextField txtTitulo;
	private JTextField txtDuracion;
	private ControladorPanelAnadir controladorPanelAnadir;
	JComboBox generocomboBox;

	

	/**
	 * Create the application.
	 */
	public PanelAnadir(ControladorPanelAnadir controladorPanelAnadir) {
		
		this.controladorPanelAnadir=controladorPanelAnadir;
		
		setLayout(null);
		

		
		JLabel anadirlabel = new JLabel("AÑADIR");
		anadirlabel.setBounds(150, 11, 59, 26);
		anadirlabel.setFont(new Font("Impact", Font.PLAIN, 20));
		add(anadirlabel);
		
		JLabel generolabel = new JLabel("GÉNERO");
		generolabel.setBounds(50, 89, 41, 14);
		add(generolabel);
		
		JButton botoncancelar = new JButton("Cancelar");
		botoncancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorPanelAnadir.accionadoBotonCancelarPanelAnadir();
			}
		});
		botoncancelar.setBounds(71, 249, 126, 23);
		add(botoncancelar);		
		
		JButton botonconfirmar = new JButton("Confirmar");
		botonconfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtTitulo.getText().equals("") && !txtDuracion.getText().equals("")) {
					controladorPanelAnadir.accionadoBotonConfirmarPanelAnadir(
							generocomboBox.getSelectedIndex()+1, txtTitulo.getText(), Double.parseDouble(txtDuracion.getText()));
					
				}
			}
		});
		botonconfirmar.setBounds(303, 249, 114, 23);
		add(botonconfirmar);
		
		JLabel lblTitulo = new JLabel("TITULO");
		lblTitulo.setBounds(37, 145, 42, 14);
		add(lblTitulo);
		
		JLabel duracionlabel = new JLabel("DURACIÓN");
		duracionlabel.setBounds(37, 195, 54, 14);
		add(duracionlabel);
		
		//nombre textfield
		txtTitulo = new JTextField();
		txtTitulo.setBounds(207, 142, 161, 20);
		add(txtTitulo);
		txtTitulo.setColumns(10);
		
		//duración textfield
		txtDuracion = new JTextField();
		txtDuracion.setBounds(207, 192, 161, 20);
		add(txtDuracion);
		txtDuracion.setColumns(10);
		
		generocomboBox = new JComboBox();
		generocomboBox.setModel(new DefaultComboBoxModel(new String[] {"1. Drama", "2. Comedia", "3. Terror", "4. CIencia Ficci\u00F3n"}));
		generocomboBox.setBounds(207, 85, 149, 22);
		add(generocomboBox);
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		

		
	}
}

