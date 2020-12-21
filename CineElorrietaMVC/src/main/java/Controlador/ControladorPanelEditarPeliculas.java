package Controlador;

import Modelo.Modelo;
import Modelo.Pelicula;
import Vista.PanelEditarPeliculas;
import Vista.Vista;

public class ControladorPanelEditarPeliculas {
	@SuppressWarnings("unused")
	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelEditarPeliculas panelEditarPeliculas;
	
	public ControladorPanelEditarPeliculas(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void mostrarPanelEditarPeliculas(String pelicula) {
		this.panelEditarPeliculas = new PanelEditarPeliculas(this,pelicula);
		Pelicula peli=modelo.getModeloGestion().buscarPelicula(pelicula);
		this.panelEditarPeliculas.cambiarGenero(peli.getGenero());
		this.panelEditarPeliculas.cambiarTitulo(peli.getTitulo());
		this.panelEditarPeliculas.cambiarDuracion(peli.getDuracion());
		this.vista.mostrarPanel(this.panelEditarPeliculas);
	}
	
	public PanelEditarPeliculas makePanelEditarPeliculas(ControladorPanelEditarPeliculas controladorEditarPeliculas, String pelicula) {
		return new PanelEditarPeliculas(controladorEditarPeliculas, pelicula);
	}
	
	public void accionadoBotonVolverPanelEditarPeliculas() {
		controlador.navegarPanelEditar();
		
	}
	

	public void accionadoBotonConfirmarPanelEditarPeliculas(String tituloAntiguo, int genero,String titulo, double duracion){
		this.modelo.getModeloGestion().editarPelicula(tituloAntiguo, genero, titulo, duracion);
		
		this.controlador.navegarPanelEdicion();
		
		
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
