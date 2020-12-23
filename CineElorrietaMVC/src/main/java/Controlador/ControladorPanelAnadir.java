package Controlador;

import Modelo.Modelo;
import Vista.PanelAnadir;
import Vista.Vista;

public class ControladorPanelAnadir {
	@SuppressWarnings("unused")
	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelAnadir panelAnadir;

	public ControladorPanelAnadir(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void mostrarPanelAnadir() {
		this.panelAnadir = new PanelAnadir(this);
		this.vista.mostrarPanel(this.panelAnadir);
	}
	
	
	public PanelAnadir makePanelAnadir(ControladorPanelAnadir controladorAnadir) {
		return new PanelAnadir(controladorAnadir);
	}

	public void accionadoBotonCancelarPanelAnadir() {
		this.controlador.navegarPanelEdicion();
	
		
	}
	public void accionadoBotonConfirmarPanelAnadir(int genero, String titulo, double duracion) {
		this.modelo.getModeloGestion().meterPelicula(genero, titulo, duracion);
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
