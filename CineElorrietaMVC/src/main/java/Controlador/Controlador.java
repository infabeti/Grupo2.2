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
	private static Pelicula[] peliculas = new Pelicula[16];
	
	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.controladorPanelBienvenida = new ControladorPanelBienvenida(this.modelo, this.vista, this);
		this.controladorPanelGeneros = new ControladorPanelGeneros(this.modelo, this.vista, this);
		this.controladorPanelLogin = new ControladorPanelLogin(this.modelo, this.vista, this);
		this.controladorPanelPeliculas = new ControladorPanelPeliculas(this.modelo, this.vista, this);
		this.controladorPanelResumen = new ControladorPanelResumen(this.modelo, this.vista, this);
		this.controladorPanelFin = new ControladorPanelFin(this.modelo, this.vista, this);
		this.introducirPrimerasPeliculas();
		this.navegarPanelBienvenida();
	}
	public void introducirPrimerasPeliculas() {
		// ARRAY DE PELICULAS
				peliculas[0] = new Pelicula(1, "Handia", 116);
				peliculas[1] = new Pelicula(1, "La lista de Schindler", 197);
				peliculas[2] = new Pelicula(1, "Cadena Perpetua", 142);
				peliculas[3] = new Pelicula(1, "Million Dollar Baby", 133);

				peliculas[4] = new Pelicula(2, "Scary movie", 90);
				peliculas[5] = new Pelicula(2, "El gran Lebowsky", 119);
				peliculas[6] = new Pelicula(2, "La vida de Brian", 94);
				peliculas[7] = new Pelicula(2, "Aterriza como puedas", 117);

				peliculas[8] = new Pelicula(3, "Psicosis", 109);
				peliculas[9] = new Pelicula(3, "El resplandor", 146);
				peliculas[10] = new Pelicula(3, "Dracula", 155);
				peliculas[11] = new Pelicula(3, "Cisne negro", 100);

				peliculas[12] = new Pelicula(4, "2001: Odisea en el espacio", 142);
				peliculas[13] = new Pelicula(4, "La novia de Frankenstein", 75);
				peliculas[14] = new Pelicula(4, "El planeta de los simios", 115);
				peliculas[15] = new Pelicula(4, "Alien, el octavo pasajero", 117);
		
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
	
	public void navegarPanelPeliculas(int genero) {
		System.out.println("Navegar panel peliculas");
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
	public ControladorPanelGeneros makeControladorGeneros(Modelo modelo, Vista vista, Controlador controlador) {
		return new ControladorPanelGeneros(this.modelo, this.vista, this);
	}
	public static Pelicula[] getPeliculas() {
		return peliculas;
	}
	public static void setPeliculas(Pelicula[] peliculas) {
		Controlador.peliculas = peliculas;
	}
	public Modelo getModelo() {
		return modelo;
	}

	public Vista getVista() {
		return vista;
	}

	
	
	
	
}
