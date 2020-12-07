package Controlador;

import javax.swing.DefaultListModel;

import Modelo.Modelo;
import Modelo.Pelicula;
import Vista.PanelBienvenida;
import Vista.PanelGeneros;
import Vista.Vista;

public class ControladorPanelGeneros {
	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelGeneros panelGeneros;
	
	public ControladorPanelGeneros(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void mostrarPanelGeneros() {
		this.panelGeneros = new PanelGeneros(this);
		this.vista.mostrarPanel(this.panelGeneros);
	}
	
	public void accionadoBottonVolverPanelGeneros() {
		this.controlador.navegarPanelBienvenida();
	}
	public void accionadoBottonAceptarPanelGeneros() {
		if(modelo.comprobarGenero(panelGeneros.getTxt_seleccion().getText())) {
			panelGeneros.agregarModeloLista(modelo.listaPorGenero(panelGeneros.getTxt_seleccion().getText()));
			
			panelGeneros.setSeleccion(panelGeneros.getTxt_seleccion().getText());
			panelGeneros.vaciarTxtSeleccion();
			panelGeneros.habilitarBtnAnadir();
		
		}
	}
	public void accionadoBotonSeleccionarPanelGeneros(String genero) {

		this.controlador.navegarPanelPeliculas(genero);
	}
	public PanelGeneros makePanelGeneros(ControladorPanelGeneros controladorGeneros) {
		return new PanelGeneros(controladorGeneros);
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
