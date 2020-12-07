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
		
		
		
		panelResumen.anadirTextoResumen(modelo.resumenEscrito());
		
		
	}
	
	public void accionadoBotonRechazarPanelResumen() {
		controlador.navegarPanelGeneros();
		modelo.getPeliculasSabado().removeAll(modelo.getPeliculasSabado());
		modelo.getPeliculasDomingo().removeAll(modelo.getPeliculasDomingo());
		
	}
	
	public void accionadoBotonAceptarPanelResumen() {
		controlador.navegarPanelFin();
		
		
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
