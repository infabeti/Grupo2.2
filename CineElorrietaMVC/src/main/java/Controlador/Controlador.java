package Controlador;

import Modelo.Modelo;
import Modelo.Pelicula;
import Vista.Vista;

public class Controlador {

	private Modelo modelo;
	private Vista vista;
	private ControladorPanelBienvenida controladorPanelBienvenida;
	private ControladorPanelGeneros controladorPanelGeneros;
	private ControladorPanelLogin controladorPanelLogin;
	private ControladorPanelPeliculas controladorPanelPeliculas;
	private ControladorPanelResumen controladorPanelResumen;
	private ControladorPanelFin controladorPanelFin;
	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.controladorPanelBienvenida = new ControladorPanelBienvenida(this.modelo, this.vista, this);
		this.controladorPanelGeneros = new ControladorPanelGeneros(this.modelo, this.vista, this);
		this.controladorPanelLogin = new ControladorPanelLogin(this.modelo, this.vista, this);
		this.controladorPanelPeliculas = new ControladorPanelPeliculas(this.modelo, this.vista, this);
		this.controladorPanelResumen = new ControladorPanelResumen(this.modelo, this.vista, this);
		this.controladorPanelFin = new ControladorPanelFin(this.modelo, this.vista, this);
		this.navegarPanelBienvenida();
	}
	
	
	public void navegarPanelBienvenida() {
		System.out.println("Navegar panel Bienvenida");
		this.controladorPanelBienvenida.mostrarPanelBienvenida();
	}
	public void navegarPanelLogin() {
		System.out.println("Navegar panel Bienvenida");
		this.controladorPanelLogin.mostrarPanelLogin();
	}
	
	
	public void navegarPanelGeneros() {
		System.out.println("Navegar panel Generos");
		this.controladorPanelGeneros.mostrarPanelGeneros();
	}
	
	public void navegarPanelPeliculas(String genero) {
		System.out.println("Navegar panel peliculas Genero: "+genero);
		this.controladorPanelPeliculas.mostrarPanelPeliculas(genero);
		
	}
	
	public void navegarPanelResumen() {
		System.out.println("Navegar panel Resumen");
		this.controladorPanelResumen.mostrarPanelResumen();
		
	}
	public void navegarPanelFin() {
		System.out.println("Navegar panel Fin");
		this.controladorPanelFin.mostrarPanelFin();
		
		
	}
	

	public ControladorPanelPeliculas getControladorPanelPeliculas() {
		return controladorPanelPeliculas;
	}


	public Modelo getModelo() {
		return modelo;
	}

	public Vista getVista() {
		return vista;
	}

	
	
	
	
}
