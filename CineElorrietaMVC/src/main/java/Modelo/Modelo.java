package Modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Modelo {

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
	
	public int minutosTotales(ArrayList<Pelicula> peliculas) {
		int minutosTotales=0;
		for(int i=0;i<peliculas.size();i++) {
			minutosTotales=(int) (minutosTotales+peliculas.get(i).getDuracion());
		}
		
		return minutosTotales;
		
	}

}
