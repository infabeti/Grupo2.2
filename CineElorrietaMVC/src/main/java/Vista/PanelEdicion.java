package Vista;


import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelEdicion {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelEdicion window = new PanelEdicion();
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
	public PanelEdicion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 489, 372);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel edicion = new JLabel("EDICIÓN");
		edicion.setBounds(12, 2, 158, 50);
		edicion.setFont(new Font("Impact", Font.PLAIN, 40));
		frame.getContentPane().add(edicion);
		
		JButton botoneditar = new JButton("Editar");
		botoneditar.setBounds(361, 23, 86, 31);
		frame.getContentPane().add(botoneditar);
		
		JButton botonborrar = new JButton("Borrar");
		botonborrar.setBounds(361, 61, 86, 31);
		frame.getContentPane().add(botonborrar);
		
		JButton botonañadir = new JButton("Añadir");
		botonañadir.setBounds(361, 100, 86, 31);
		frame.getContentPane().add(botonañadir);
		
		JButton botoncancelar = new JButton("Cancelar");
		botoncancelar.setBounds(24, 269, 102, 31);
		frame.getContentPane().add(botoncancelar);		
		
		JButton botonconfirmar = new JButton("Confirmar");
		botonconfirmar.setBounds(344, 269, 102, 31);
		frame.getContentPane().add(botonconfirmar);
		
		

		
	}
}
