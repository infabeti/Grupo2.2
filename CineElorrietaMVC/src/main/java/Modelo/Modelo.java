package Modelo;

import java.awt.Dialog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Controlador.Controlador;

public class Modelo {

	//Estos dos arrays tendran almacenadas las peliculas que selecciona el usuario
	private ArrayList<Pelicula> peliculasSabado;
	private ArrayList<Pelicula> peliculasDomingo;
	private Pelicula[] peliculas = new Pelicula[16];
	private final String usuario="usuario";
	private final String contrasena="12345";
	
	private Usuario usuarioAcceso=new Usuario(usuario,contrasena);
	
	public Modelo() {
		this.peliculasSabado=new ArrayList <Pelicula>();
		this.peliculasDomingo=new ArrayList <Pelicula>();
		introducirPrimerasPeliculas();
		
		
	}
	
	
	public  ArrayList<Pelicula> getPeliculasSabado() {
		return peliculasSabado;
	}
	
	

	

	public ArrayList<Pelicula> getPeliculasDomingo() {
		return peliculasDomingo;
	}

	public Pelicula[] getPeliculas() {
		return peliculas;
	}


	public void setPeliculas(Pelicula[] peliculas) {
		this.peliculas = peliculas;
	}


	/**
	 * Metodo que escribe un error en un fichero junto a la fecha de este, si este no existe lo crea
	 * 	 * @param error cadena que contiene el error
	 */
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
			System.out.println(e.toString()+"->Ha ocurrido un error al escribir en el fichero de errores");
			
		}	 
	}
	public boolean comprobarUsuario(String usuarioIntroduccido, String passIntroducido) {
		System.out.println("Comprobando usuario");
		//System.out.println(usuario2);
		//System.out.println(pass);
		boolean correcto=false;
		
		if(usuarioIntroduccido.equals(usuarioAcceso.getNombre()) && passIntroducido.equals(usuarioAcceso.getPswd())) {		
			System.out.println("Usuario/Contraseña correctos");
			correcto=true;
			
		}
		else {
			System.out.println("Usuario/contraseña incorrectos");
			correcto=false;
			
		}
		
		return correcto;
		
	}
	
	/**
	 * Metodo que para la ejecuccion por el tiempo deseado
	 * @param tiempo tiempo que queremos que este detenido en milisegundos (3000->3s)
	 */
	public boolean esperar(int tiempo) {
		try {
			Thread.sleep(tiempo);
			return true;
		} catch (InterruptedException e) {
			escribirErrorEnLog(e.toString());
			return false;
			
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
	
	public void introducirPeliculaSeleccionada(String peliSeleccionada, Controlador controlador,Pelicula[] peliculas){
		
		
			String titulo;
			
			for(int i=0;i<peliculas.length;i++) {
				titulo=peliculas[i].getTitulo();

				
				if(titulo.toString().trim().equals(peliSeleccionada.trim())) {
					
					
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
						JOptionPane pane = new JOptionPane("No se puede introducir la pelicula, porque no hay tiempo \n"
								+ "(Esta ventana se cerrará automáticamente en 10 segundos)", JOptionPane.INFORMATION_MESSAGE);
						JDialog dialog = pane.createDialog("Sin tiempo disponible");
					    dialog.addWindowListener(null);
					    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					    dialog.setModalityType(Dialog.ModalityType.MODELESS);
					    dialog.setVisible(true); 
					    esperar(10000);
				           
				                dialog.setVisible(false);
				                dialog.dispose();
 
					    
						//JOptionPane.showMessageDialog(null, "No se puede introducir la pelicula, porque no hay tiempo");
						controlador.navegarPanelResumen();
					}
					
					
				}
				
			}
			
		
	}
	/**
	 * Comprueba que un número esté entre el 1 y el 4
	 * @param genero genero seleccionado
	 * @return devuelve true si el número está entre el 1 y el 4, si no false
	 */
	public boolean comprobarGenero(String genero) {
		if ((!genero.equals("4")&&(!genero.equals("3"))&&(!genero.equals("2"))&&(!genero.equals("1")))) {
			JOptionPane.showMessageDialog(null, "Seleccion incorrecta");
			return false;
		}
		else return true;
		
	}
	/**
	 * 
	 * @param genero genero del que queramos sacar las peliculas
	 * @return un DefaultListModel con un alista de las peliculas seleccionadas
	 */
	public DefaultListModel listaPorGenero(String genero) {
		DefaultListModel modelo=new DefaultListModel();
		

	
			modelo.clear();
		
			for (int i = 0; i < peliculas.length; i++) {
				
				if (peliculas[i].getGenero() == Integer.parseInt(genero)) {
					String resultado = "";
					resultado += peliculas[i].getTitulo() + "\n";
					modelo.addElement(resultado);
					
				}
			}

		return modelo;


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
