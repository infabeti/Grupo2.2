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

		// ARRAYLIST PARA PARA PELIS SELECCIONADAS
		ArrayList <Pelicula> pelis_seleccion = new ArrayList<>();

		this.controladorPanelEditar = controladorPanelEditar;
		
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(115, 72, 270, 271);
		add(scrollPane);
		
		JList lista_pelis = new JList();
		scrollPane.setViewportView(lista_pelis);
		lista_pelis.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(lista_pelis);
		

		
	//	Pelicula[] peliculas=controladorPanelEditar.getControlador().getPeliculas();
	//	DefaultListModel modelo = new DefaultListModel();//necesario crear un modelo con el que llenar el jlist
		
//		for(int i=0;i<peliculas.length;i++) {
//			modelo.addElement(peliculas[i].getTitulo());
//			
//		}		
		//lista_pelis.setModel(modelo);
		
		
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSeleccionar.setEnabled(false);
		btnSeleccionar.setBounds(271, 372, 168, 23);
		add(btnSeleccionar);
		
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	controladorPanelEditar.accionadoBotonSeleccionarPanelEditar();
				
				
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

