package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controlador.Controlador;
import Controlador.ControladorPanelGeneros;
import Modelo.Pelicula;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class PanelGeneros extends JPanel {

	private JButton btnVolver;
	private JLabel lblGeneros;
	private ControladorPanelGeneros controladorPanelGeneros;
	private JTextField txt_seleccion;
	private String resultado="";
	private String seleccion;
	private JList lista_pelis;
	JButton btnAnadir;
	
	
	public PanelGeneros(ControladorPanelGeneros controladorPanelGeneros) {

		

		this.controladorPanelGeneros = controladorPanelGeneros;

		setLayout(null);

		// ---------------------------Ventana----------------------------------------------
		lblGeneros = new JLabel("Panel Generos");
		lblGeneros.setBounds(61, 35, 115, 14);
		add(lblGeneros);

		JTextPane textPaneGeneros = new JTextPane();
		textPaneGeneros.setEditable(false);
		textPaneGeneros.setEnabled(false);
		textPaneGeneros.setDisabledTextColor(Color.BLACK);
		textPaneGeneros.setBounds(61, 63, 168, 137);
		add(textPaneGeneros);
		textPaneGeneros.setText("1. DRAMA\n2. COMEDIA\r\n3. TERROR\r\n4. CIENCIA FICCION");
		

		JLabel lbl_SeleccionGenero = new JLabel("Genero seleccionado");
		lbl_SeleccionGenero.setBounds(61, 227, 149, 14);
		add(lbl_SeleccionGenero);

		txt_seleccion = new JTextField();
		txt_seleccion.setBounds(61, 252, 168, 37);
		add(txt_seleccion);
		txt_seleccion.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(271, 63, 168, 137);
		add(scrollPane);
		
		lista_pelis = new JList();
		scrollPane.setViewportView(lista_pelis);
		
		
		btnAnadir = new JButton("Seleccionar");
		btnAnadir.setEnabled(false);
		
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorPanelGeneros.accionadoBotonSeleccionarPanelGeneros(seleccion);
				
				
			}
		});
		
		JButton btnElegir = new JButton("Aceptar");
		btnElegir.setBounds(61, 304, 168, 23);
		btnElegir.addActionListener(new ActionListener() {
		

			public void actionPerformed(ActionEvent arg0) {
				controladorPanelGeneros.accionadoBottonAceptarPanelGeneros(txt_seleccion.getText());
					
			}
		});

		add(btnElegir);
	
		JLabel lblPelis = new JLabel("Peliculas Disponibles");
		lblPelis.setBounds(282, 35, 181, 14);
		add(lblPelis);

		

		btnAnadir.setBounds(271, 304, 168, 23);
		add(btnAnadir);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(350, 372, 89, 23);
		add(btnVolver);


		initializeEvents();

	}

	

	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelGeneros));
	}

	private ActionListener listenerBotonVolver(ControladorPanelGeneros controladorPanelGeneros) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				controladorPanelGeneros.accionadoBottonVolverPanelGeneros();
			}
		};
	}
	public void habilitarBtnAnadir() {
		btnAnadir.setEnabled(true);
		
	}
	public void vaciarTxtSeleccion() {
		txt_seleccion.setText("");
	}
	public void agregarModeloLista(DefaultListModel modeloLista) {
		lista_pelis.setModel(modeloLista);
		
	}


	public JTextField getTxt_seleccion() {
		return txt_seleccion;
	}



	public String getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(String seleccion) {
		this.seleccion = seleccion;
	}
	public JList getLista_pelis() {
		return lista_pelis;
	}

	
	

	
}

