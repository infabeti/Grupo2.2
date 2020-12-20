package Controlador;

import Modelo.Modelo;
import Vista.PanelResumen2;
import Vista.Vista;

public class ControladorResumen2 {
	@SuppressWarnings("unused")
	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelResumen2 panelResumen2;

	public ControladorResumen2(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void mostrarPanelResumen2() {
		this.panelResumen2 = new PanelResumen2(this);
		this.vista.mostrarPanel(this.panelResumen2);
	}
	
	
	public PanelResumen2 makePanelResumen2(ControladorResumen2 ControladorResumen2) {
		return new PanelResumen2(ControladorResumen2);
	}
	public void accionadoBotonCancelarPanelResumen2() {
		this.modelo.getModeloGestion().actualizarAuxiliar();
		this.controlador.navegarPanelBienvenida();
	
		
	}
	public void accionadoBotonAceptarPanelResumen2() {
		this.modelo.getModeloGestion().actualizarPeliculas();
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
