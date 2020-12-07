package Controlador;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import Modelo.Modelo;
import Modelo.Pelicula;
import Vista.PanelPeliculas;
import Vista.Vista;
import Vista.PanelGeneros;



public class ControladorPanelPeliculas {

	@SuppressWarnings("unused")
	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelPeliculas panelPeliculas;
	
	
	public ControladorPanelPeliculas(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void mostrarPanelPeliculas(String genero) {
		
		this.panelPeliculas = new PanelPeliculas(this,genero);
		this.vista.mostrarPanel(this.panelPeliculas);

	
		
	}
	
	public void accionadoBotonVolverPanelPeliculas() {
		controlador.navegarPanelGeneros();
		
	}

	
	public void accionadoBotonAnadirPanelPeliculas(String peliSeleccionada) {
		modelo.introducirPeliculaSeleccionada(peliSeleccionada,controlador,controlador.getModelo().getPeliculas());
	}

	
	public PanelPeliculas makePanelPeliculas(ControladorPanelPeliculas controladorPeliculas,String genero) {
		return new PanelPeliculas(controladorPeliculas,genero);
	}

	public Modelo getModelo() {
		return modelo;
	}

	public Vista getVista() {
		return vista;
	}

	public Controlador getControlador() {
		return controlador;
	}



	
	


	
	


	
	
	
	
	
}
