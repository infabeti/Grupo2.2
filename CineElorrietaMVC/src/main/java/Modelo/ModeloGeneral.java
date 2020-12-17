package Modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class ModeloGeneral {
	private Modelo modelo;
	
	public ModeloGeneral(Modelo modelo) {
		this.modelo=modelo;
		
	}
	
	
	public Modelo getModelo() {
		return modelo;
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
	 * Comprueba que un número esté entre el 1 y el 4
	 * @param genero genero seleccionado
	 * @return devuelve true si el número está entre el 1 y el 4, si no false
	 */
	public boolean comprobarGenero(String genero) {
		if ((!genero.equals("4")&&(!genero.equals("3"))&&(!genero.equals("2"))&&(!genero.equals("1")))) {

			return false;
		}
		else return true;
		
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

}

