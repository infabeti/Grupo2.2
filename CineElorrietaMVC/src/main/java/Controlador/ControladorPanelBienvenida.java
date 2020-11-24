package Controlador;

import Modelo.Modelo;
import Vista.PanelBienvenida;
import Vista.PanelGeneros;
import Vista.Vista;

public class ControladorPanelBienvenida {

	@SuppressWarnings("unused")
	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelBienvenida panelBienvenida;
	
	
	public ControladorPanelBienvenida(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void mostrarPanelBienvenida() {
		this.panelBienvenida = new PanelBienvenida(this);
		this.vista.mostrarPanel(this.panelBienvenida);
		
		
		
		//Parar ejecucion durante 3 segundos y Mostrar Panel de Login
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			Controlador.escribirErrorEnLog(e.toString());
			e.printStackTrace();
		}
		this.controlador.navegarPanelLogin();
		
		
		
	}
	
	public void accionadoBottonMostrarPanelGeneros() {
		this.controlador.navegarPanelGeneros();
	}
	public PanelBienvenida makePanelBienv(ControladorPanelBienvenida controladorBienvenida) {
		return new PanelBienvenida(controladorBienvenida);
	}
}
