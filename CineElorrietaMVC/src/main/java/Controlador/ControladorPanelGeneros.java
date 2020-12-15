package Controlador;

import java.awt.Dialog;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

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
	public void accionadoBotonAceptarPanelGeneros(String seleccion) {
		if(this.modelo.getModeloGeneral().comprobarGenero(seleccion)) {
			panelGeneros.agregarModeloLista(this.modelo.getModeloPeliculas().listaPorGenero(seleccion));
			
			panelGeneros.setSeleccion(seleccion);
			panelGeneros.vaciarTxtSeleccion();
			panelGeneros.habilitarBtnAnadir();
		
		}
		else {
			JOptionPane pane = new JOptionPane("Seleccion incorrecta", JOptionPane.INFORMATION_MESSAGE);
			JDialog dialog = pane.createDialog("Sin tiempo disponible");
		    dialog.addWindowListener(null);
		    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		    dialog.setModalityType(Dialog.ModalityType.MODELESS);
		    dialog.setVisible(true); 
		    this.modelo.getModeloGeneral().esperar(2000);
	           
	                dialog.setVisible(false);
	                dialog.dispose();
	                panelGeneros.vaciarTxtSeleccion();
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
