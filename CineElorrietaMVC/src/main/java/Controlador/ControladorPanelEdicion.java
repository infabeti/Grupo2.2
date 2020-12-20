package Controlador;

import Modelo.Modelo;
import Vista.PanelEdicion;
import Vista.PanelLogin;
import Vista.Vista;

public class ControladorPanelEdicion {
	@SuppressWarnings("unused")
	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelEdicion panelEdicion;

	public ControladorPanelEdicion(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void mostrarPanelEdicion() {
		this.panelEdicion = new PanelEdicion(this);
		this.vista.mostrarPanel(this.panelEdicion);
	}
	
	
	public PanelEdicion makePanelEdicion(ControladorPanelEdicion controladorEdicion) {
		return new PanelEdicion(controladorEdicion);
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



