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
	private ControladorPanelEdicion controladorPanelEdicion;
	private ControladorPanelEditar controladorPanelEditar;
	private ControladorPanelBorrar controladorPanelBorrar;
	private ControladorResumen2 controladorResumen2;
	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.controladorPanelBienvenida = new ControladorPanelBienvenida(this.modelo, this.vista, this);
		this.controladorPanelGeneros = new ControladorPanelGeneros(this.modelo, this.vista, this);
		this.controladorPanelLogin = new ControladorPanelLogin(this.modelo, this.vista, this);
		this.controladorPanelPeliculas = new ControladorPanelPeliculas(this.modelo, this.vista, this);
		this.controladorPanelResumen = new ControladorPanelResumen(this.modelo, this.vista, this);
		this.controladorPanelFin = new ControladorPanelFin(this.modelo, this.vista, this);
		this.controladorPanelEdicion = new ControladorPanelEdicion(this.modelo, this.vista, this);
		this.controladorPanelEditar = new ControladorPanelEditar(this.modelo, this.vista, this);
		this.controladorPanelBorrar= new ControladorPanelBorrar(this.modelo, this.vista, this);
		this.controladorResumen2= new ControladorResumen2(this.modelo, this.vista, this);
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
	public void navegarPanelEdicion() {
		System.out.println("Navegar panel Edicion");
		this.controladorPanelEdicion.mostrarPanelEdicion();
		
		
	}
	public void navegarPanelEditar() {
		System.out.println("Navegar panel editar");
		this.controladorPanelEditar.mostrarPanelEditar();
	}

	public void navegarPanelBorrar() {
		System.out.println("Navegar panel Edicion");
		this.controladorPanelBorrar.mostrarPanelBorrar();
		
		
	}
	
	public void navegarResumen2() {
		System.out.println("Navegar panel Edicion");
		this.controladorResumen2.mostrarPanelResumen2();
		
		
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
