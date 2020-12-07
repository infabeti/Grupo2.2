package Controlador;

import Modelo.Modelo;
import Vista.PanelGeneros;
import Vista.PanelLogin;
import Vista.Vista;

public class ControladorPanelLogin {
	@SuppressWarnings("unused")
	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelLogin panelLogin;
	private final String usuario="usuario";
	private final String contrasena="12345";
	
	
	
	
	public ControladorPanelLogin(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void mostrarPanelLogin() {
		this.panelLogin = new PanelLogin(this);
		this.vista.mostrarPanel(this.panelLogin);
	}
	
	
	public PanelLogin makePanelLogin(ControladorPanelLogin controladorLogin) {
		return new PanelLogin(controladorLogin);
	}

	public boolean accionadoBotonEntrarPanelLogin(String usuario2, String pass) {
		if(modelo.comprobarUsuario(usuario2, pass)) {
			this.controlador.navegarPanelGeneros();
			return true;
		}
		else return false;
		
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


