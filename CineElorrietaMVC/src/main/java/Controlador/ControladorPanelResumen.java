package Controlador;

import Modelo.Modelo;
import Vista.PanelGeneros;
import Vista.PanelLogin;
import Vista.PanelPeliculas;
import Vista.PanelResumen;
import Vista.Vista;

public class ControladorPanelResumen {
	@SuppressWarnings("unused")
	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelResumen panelResumen;
	
	public ControladorPanelResumen(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	//Muestra las peliculas del sabado y domingo con su duración
	public void mostrarPanelResumen() {
		this.panelResumen = new PanelResumen(this);
		this.vista.mostrarPanel(this.panelResumen);
		
		
		
		this.panelResumen.anadirTextoResumen(this.modelo.getModeloCartelera().resumenEscrito());
		
		
	}
	
	public void accionadoBotonRechazarPanelResumen() {
		this.controlador.navegarPanelGeneros();
		this.modelo.getModeloCartelera().limpiarDias();
		
	}
	
	public void accionadoBotonAceptarPanelResumen() {
		this.controlador.navegarPanelFin();
		
		
	}
	
	public PanelResumen makePanelResumen(ControladorPanelResumen controladorResumen) {
		return new PanelResumen(controladorResumen);
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
