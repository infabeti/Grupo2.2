package Controlador;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import Modelo.Modelo;
import Modelo.Pelicula;
import Vista.PanelPeliculas;
import Vista.Vista;
import Vista.PanelGeneros;



public class ControladorPanelPeliculas {

	@SuppressWarnings("unused")
	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelPeliculas panelPeliculas;
	
	
	//Estos dos arrays tendran almacenadas las peliculas que selecciona el usuario
	private static ArrayList<Pelicula> peliculasSabado=new ArrayList <Pelicula>();
	private static ArrayList<Pelicula> peliculasDomingo=new ArrayList <Pelicula>();
	
	
	
	
	public ControladorPanelPeliculas(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void mostrarPanelPeliculas(int genero) {
		this.panelPeliculas = new PanelPeliculas(this);
		this.vista.mostrarPanel(this.panelPeliculas);
		System.out.println("Este es el genero seleccionado: "+genero);
		//Cargar las peliculas del genero seleccionado
		
		
		
		 
		
		
	}
	
	public void accionadoBotonVolverPanelPeliculas() {
		controlador.navegarPanelGeneros();
		
	}

	
	public void accionadoBotonAnadirPanelPeliculas(JList lista_pelis) {
		Pelicula[] peliculas=PanelGeneros.getPeliculas();
		//JList lista_pelis=PanelPeliculas.getLista_pelis();
		//System.out.println((String)lista_pelis.getSelectedValue());
		
	
		if(lista_pelis.getSelectedValue()==null) {
			
			System.out.println("No has seleccionado ninguna pelicula");
			
		}
		else {
			String titulo;
			
			for(int i=0;i<peliculas.length;i++) {
				titulo=peliculas[i].getTitulo();
				//System.out.println(titulo+"  "+(String)lista_pelis.getSelectedValue());
				
				
			
				
				
				if(titulo.toString().trim().equals(lista_pelis.getSelectedValue().toString().trim())) {
					
					
					//Para que se pueda añadir una pelicula tiene que sumar menos de 8horas el sabado completo (480minutos)
					if((peliculas[i].getDuracion()+modelo.minutosTotales(peliculasSabado))<480){
						peliculasSabado.add(peliculas[i]);
						controlador.navegarPanelGeneros();
						System.out.println("Peliculas Sabado-> "+peliculasSabado.size());
						System.out.println("Minutos-> "+modelo.minutosTotales(peliculasSabado));
						
						
					}
					else if((peliculas[i].getDuracion()+modelo.minutosTotales(peliculasDomingo))<360){
						peliculasDomingo.add(peliculas[i]);
						controlador.navegarPanelGeneros();
						System.out.println("Peliculas Domingo-> "+peliculasDomingo.size());
						System.out.println("Minutos-> "+modelo.minutosTotales(peliculasDomingo));
						
					}
					else {
						JOptionPane.showMessageDialog(null, "No se puede introducir la pelicula, porque no hay tiempo");
						controlador.navegarPanelResumen();
					}
					
					
				}
				
			}
			
		}
	}

	public static void setPeliculasSabado(ArrayList<Pelicula> peliculasSabado) {
		ControladorPanelPeliculas.peliculasSabado = peliculasSabado;
	}

	public static void setPeliculasDomingo(ArrayList<Pelicula> peliculasDomingo) {
		ControladorPanelPeliculas.peliculasDomingo = peliculasDomingo;
	}

	public static ArrayList<Pelicula> getPeliculasSabado() {
		return peliculasSabado;
	}

	

	public static ArrayList<Pelicula> getPeliculasDomingo() {
		return peliculasDomingo;
	}
	
	public PanelPeliculas makePanelPeliculas(ControladorPanelPeliculas controladorPeliculas) {
		return new PanelPeliculas(controladorPeliculas);
	}


	
	
	
	
	
}
