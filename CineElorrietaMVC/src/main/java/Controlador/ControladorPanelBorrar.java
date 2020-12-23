package Controlador;

import Modelo.Modelo;
import Vista.PanelBorrar;
import Vista.PanelLogin;
import Vista.Vista;

public class ControladorPanelBorrar {
	@SuppressWarnings("unused")
	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelBorrar panelBorrar;
	
	public ControladorPanelBorrar(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void mostrarPanelBorrar() {
		this.panelBorrar = new PanelBorrar(this);
		this.vista.mostrarPanel(this.panelBorrar);
	}
	public void accionadoBotonCancelarPanelBorrar() {
		this.controlador.navegarPanelEdicion();
		
	}
	public void accionadoBotonBorrarPanelBorrar(String[] pelisSeleccionadas) {
		
		this.modelo.getModeloGestion().borrarLista(pelisSeleccionadas);
		
		this.controlador.navegarPanelEdicion();
		
		
		
		
	}
	
	
	public PanelBorrar makePanelBorrar(ControladorPanelBorrar controladorBorrar) {
		return new PanelBorrar(controladorBorrar);
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
