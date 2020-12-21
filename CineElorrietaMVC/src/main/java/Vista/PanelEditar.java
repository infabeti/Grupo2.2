package Vista;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

import Controlador.ControladorPanelEdicion;
import Controlador.ControladorPanelEditar;
import Modelo.Pelicula;

@SuppressWarnings("serial")
public class PanelEditar extends JPanel {

	private JButton btnVolver, btnSeleccionar ;
	private ControladorPanelEditar controladorPanelEditar;
	private ControladorPanelEdicion controladorPanelEdicion;
	String resultado="";
	static String seleccion;
	public PanelEditar(ControladorPanelEditar controladorPanelEditar) {

		this.controladorPanelEditar = controladorPanelEditar;
		
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(115, 72, 270, 271);
		add(scrollPane);
		
		JList lista_pelis = new JList();
		scrollPane.setViewportView(lista_pelis);
		lista_pelis.setFont(new Font("Tahoma", Font.BOLD, 12));
		scrollPane.setViewportView(lista_pelis);
		lista_pelis.setModel(controladorPanelEditar.getModelo().getModeloPeliculas().listaTodasPelis());
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSeleccionar.setEnabled(true);
		btnSeleccionar.setBounds(271, 372, 168, 23);
		add(btnSeleccionar);
		
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(lista_pelis.getSelectedValue()==null) {
					
					System.out.println("No has seleccionado ninguna pelicula");
					
				}
				else controladorPanelEditar.accionadoBotonSeleccionarPanelEditar(lista_pelis.getSelectedValue().toString().trim());
			}
				
				
			
		});
	
		JLabel lblPelis = new JLabel("Pel\u00EDculas");
		lblPelis.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPelis.setBounds(214, 47, 72, 14);
		add(lblPelis);

		

		

		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVolver.setBounds(59, 372, 143, 23);
		add(btnVolver);
		
		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEditar.setBounds(214, 11, 72, 14);
		add(lblEditar);


		initializeEvents();

	}

	private void initializeEvents() {
		
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelEditar));
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelEditar));
	}

	private ActionListener listenerBotonVolver(ControladorPanelEditar controladorPanelEditar) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelEditar.accionadoBotonVolverPanelEditar();
				System.out.println("Ejecutando evento Boton Volver");
				//controladorPanelEditar.accionadoBottonVolverPanelEditar();
			}
		};
	}


	public static String getSeleccion() {
		return seleccion;
	}

	public static void setSeleccion(String seleccion) {
		PanelEditar.seleccion = seleccion;
	}
}

