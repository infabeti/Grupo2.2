package Modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Controlador.Controlador;

public class Modelo {

	//Estos dos arrays tendran almacenadas las peliculas que selecciona el usuario
	private static ArrayList<Pelicula> peliculasSabado=new ArrayList <Pelicula>();
	private static ArrayList<Pelicula> peliculasDomingo=new ArrayList <Pelicula>();
	public static ArrayList<Pelicula> getPeliculasSabado() {
		return peliculasSabado;
	}

	

	public static ArrayList<Pelicula> getPeliculasDomingo() {
		return peliculasDomingo;
	}

	/**
	 * Metodo que escribe un error en un fichero junto a la fecha de este, si este no existe lo crea
	 * 	 * @param error cadena que contiene el error
	 */
	public void escribirErrorEnLog(String error) {
		
		try {
			FileWriter fr;
			File fichero=new File("errores.log");
			fr = new FileWriter(fichero,true);
			BufferedWriter br= new BufferedWriter(fr);	//se crea el buffer para escibir
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			System.out.println(formatter.format(date));
			br.write("["+formatter.format(date)+"]-> "+error); 	
			br.newLine();//escribimos
			br.close(); 		//cerramos el buffer
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Ha ocurrido un error al escribir en el fichero de errores");
			e.printStackTrace();
		}	 
	}
	
	/**
	 * Metodo que para la ejecuccion por el tiempo deseado
	 * @param tiempo tiempo que queremos que este detenido en milisegundos (3000->3s)
	 */
	public void esperar(int tiempo) {
		try {
			Thread.sleep(tiempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			escribirErrorEnLog(e.toString());
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param peliculas ArrayList de peliculas (generalmente se introducira las del sabado o domingo)
	 * @return suma de minutos de todas las peliculas que estan en el interior del ArrayList
	 */
	
	public int minutosTotales(ArrayList<Pelicula> peliculas) {
		int minutosTotales=0;
		for(int i=0;i<peliculas.size();i++) {
			minutosTotales=(int) (minutosTotales+peliculas.get(i).getDuracion());
		}
		
		return minutosTotales;
		
	}
	/**
	 * 
	 * @param lista_pelis
	 */
	
	public void introducirPeliculaSeleccionada(JList lista_pelis, Controlador controlador){
		Pelicula[] peliculas=controlador.getPeliculas();
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
					if((peliculas[i].getDuracion()+minutosTotales(getPeliculasSabado()))<480){
						getPeliculasSabado().add(peliculas[i]);
						controlador.navegarPanelGeneros();
						System.out.println("Peliculas Sabado-> "+getPeliculasSabado().size());
						System.out.println("Minutos-> "+minutosTotales(getPeliculasSabado()));
						
						
					}
					else if((peliculas[i].getDuracion()+minutosTotales(getPeliculasDomingo()))<360){
						getPeliculasDomingo().add(peliculas[i]);
						controlador.navegarPanelGeneros();
						System.out.println("Peliculas Domingo-> "+getPeliculasDomingo().size());
						System.out.println("Minutos-> "+minutosTotales(getPeliculasDomingo()));
						
					}
					else {
						JOptionPane.showMessageDialog(null, "No se puede introducir la pelicula, porque no hay tiempo");
						controlador.navegarPanelResumen();
					}
					
					
				}
				
			}
			
		}
	}
	/**
	 * Metodo para escribir en el panel de Resumen el texto con la lista de peliculas
	 * @return un string con saltos de linea incluidos del resumen
	 */
	public String resumenEscrito() {
		String resultadoFinal="";
		int horas,minutos;
		
		
		resultadoFinal=resultadoFinal+"Sábado: \n";
		
		for(int i=0;i<getPeliculasSabado().size();i++) {
			
			
			
			horas=(int) Math.floor((getPeliculasSabado().get(i).getDuracion())/60);
			minutos=(int) Math.round((getPeliculasSabado().get(i).getDuracion())%60);
			
			resultadoFinal=resultadoFinal+getPeliculasSabado().get(i).getTitulo()+"-> "+
					horas+"h "+minutos+"m \n";
			
			
		}
		
		resultadoFinal=resultadoFinal+"\nDomingo: \n";
		
		for(int i=0;i<getPeliculasDomingo().size();i++) {
			horas=(int) Math.floor((getPeliculasDomingo().get(i).getDuracion())/60);
			minutos=(int) Math.round((getPeliculasDomingo().get(i).getDuracion())%60);
			
			
			resultadoFinal=resultadoFinal+getPeliculasDomingo().get(i).getTitulo()+"-> "+
					horas+"h "+minutos+"m \n";
			
			
		}
		
		return resultadoFinal;
		
	}

	



}
