package Vista;


import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import Controlador.ControladorPanelEdicion;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelEdicion extends JPanel{

	private ControladorPanelEdicion controladorPanelEdicion;


	public PanelEdicion(ControladorPanelEdicion controladorPanelEdicion) {
		
		this.controladorPanelEdicion = controladorPanelEdicion;
		
		setLayout(null);
		
		JLabel edicion = new JLabel("EDICIÓN");
		edicion.setBounds(12, 2, 158, 50);
		edicion.setFont(new Font("Impact", Font.PLAIN, 40));
		add(edicion);
		
		JButton botoneditar = new JButton("Editar");
		botoneditar.setBounds(361, 23, 86, 31);
		add(botoneditar);
		
		JButton botonborrar = new JButton("Borrar");
		botonborrar.setBounds(361, 61, 86, 31);
		add(botonborrar);
		
		JButton botonañadir = new JButton("Añadir");
		botonañadir.setBounds(361, 100, 86, 31);
		add(botonañadir);
		
		JButton botoncancelar = new JButton("Cancelar");
		botoncancelar.setBounds(24, 269, 102, 31);
		add(botoncancelar);		
		
		JButton botonconfirmar = new JButton("Confirmar");
		botonconfirmar.setBounds(344, 269, 102, 31);
		add(botonconfirmar);
		
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
	

		
	}
}
