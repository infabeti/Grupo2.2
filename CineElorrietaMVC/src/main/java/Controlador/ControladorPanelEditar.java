package Controlador;

import Modelo.Modelo;
import Vista.PanelEditar;
import Vista.Vista;

public class ControladorPanelEditar {
	@SuppressWarnings("unused")
	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelEditar panelEditar;
	
	public ControladorPanelEditar(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void mostrarPanelEditar() {
		this.panelEditar = new PanelEditar(this);
		this.vista.mostrarPanel(this.panelEditar);
	}
	
	public PanelEditar makePanelEditar(ControladorPanelEditar controladorEditar) {
		return new PanelEditar(controladorEditar);
	}
	public void accionadoBotonVolverPanelEditar() {
		controlador.navegarPanelEdicion();
		
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