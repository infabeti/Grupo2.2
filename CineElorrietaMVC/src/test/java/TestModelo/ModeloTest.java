package TestModelo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import Controlador.Controlador;
import Controlador.ControladorPanelPeliculas;
import Modelo.Modelo;
import Modelo.Pelicula;
import Vista.Vista;

public class ModeloTest {
	private Modelo modelo=new Modelo();
	private int resultadoEsperado,resultado;
	//private JList listamock=mock(JList.class);
	private Controlador controladormock=mock(Controlador.class);
	
	private ArrayList<Pelicula> resultadoPeliculasSab;
	private ArrayList<Pelicula> resultadoPeliculasDom;
	
	
	/**
	 * 
	 */
	@Test
	public void testConstructorModelo() {
		resultadoPeliculasDom=modelo.getPeliculasDomingo();
		resultadoPeliculasSab=modelo.getPeliculasSabado();
		
		
		assertEquals(0, resultadoPeliculasDom.size());
		assertEquals(0, resultadoPeliculasSab.size());
		
		
		
		assertEquals(ArrayList.class,resultadoPeliculasDom.getClass());
		assertEquals(ArrayList.class,resultadoPeliculasSab.getClass());
		
		
	}
	 @Rule
	    public TemporaryFolder folder = new TemporaryFolder();
	 @Test
	public void escribirErrorEnLogCorrectoTest() throws IOException {
		 File file=folder.newFile("errores.txt");
		 modelo.escribirErrorEnLog("Test Error");
		 

		 
	 }
	 /*
	 @Test
		public void escribirErrorEnLogFalloTest() throws IOException {
			 File file=folder.newFile("errores.txt");
			 org.junit.Assert.(modelo.escribirErrorEnLog("Test Error")).andThrow(
				        new IOException("Something terrible happened"));
			 

			 
		 }
		 */
	 @Test
		public void esperarTestCorrecto() {
			 assertEquals(true, modelo.esperar(3000));
			 
		 }
	
		 
	 
	 
	
	 @Test
	public void minutosTotalesTest() {
		resultadoEsperado=100;
		
		
		modelo=new Modelo();
		//Pelicula peli1=new
		ArrayList<Pelicula> peliInstancia=new ArrayList();
		Pelicula peli=new Pelicula(1,"Test Pelicula",100);
		peliInstancia.add(peli);
		
		
		
		resultado = modelo.minutosTotales(peliInstancia);
		
		assertEquals(resultadoEsperado, resultado);
		
		
		
	

}
	 @Test
		public void resumenEscritoVacioTest() {
			String resultadoEsperado="";
			String resultado;
			resultadoEsperado=resultadoEsperado+"Sábado: \n";
			resultadoEsperado=resultadoEsperado+"\nDomingo: \n";
			
			
			modelo=new Modelo();
			
			
			
			resultado = modelo.resumenEscrito();
			
			assertEquals(resultadoEsperado, resultado);
			
			
	}
	 @Test
		public void resumenEscritoRellenoTest() {
			String resultadoEsperado="";
			String resultado;
			Pelicula peli1=new Pelicula(2,"Titulo Test",110);
			

			
			modelo=new Modelo();
			modelo.getPeliculasSabado().add(peli1);
			modelo.getPeliculasDomingo().add(peli1);
			
			//resultadoFinal=resultadoFinal+getPeliculasSabado().get(i).getTitulo()+"-> "+
			//horas+"h "+minutos+"m \n";
			resultadoEsperado=resultadoEsperado+"Sábado: \n";
			resultadoEsperado=resultadoEsperado+peli1.getTitulo()+"-> 1h 50m \n";
			
			resultadoEsperado=resultadoEsperado+"\nDomingo: \n";
			resultadoEsperado=resultadoEsperado+peli1.getTitulo()+"-> 1h 50m \n";
			
			
			
			resultado = modelo.resumenEscrito();
			
			assertEquals(resultadoEsperado, resultado);
			
			
	}
	 
	
	
	 	@Test
			public void getPeliculasSabadoTest() {
				modelo=new Modelo();
				
			    
				ArrayList<Pelicula> resultadoEsperado=new ArrayList();
			    
			    
				ArrayList<Pelicula> resultado = modelo.getPeliculasSabado();
			    assertEquals(resultadoEsperado, resultado);
			}
	 	@Test
		public void getPeliculasDomingoTest() {
			modelo=new Modelo();
			
		    
			ArrayList<Pelicula> resultadoEsperado=new ArrayList();
		    
		    
			ArrayList<Pelicula> resultado = modelo.getPeliculasDomingo();
		    assertEquals(resultadoEsperado, resultado);
		}
	 	

	 	@Test
	 	public void introducirPeliculaSeleccionadaTest() {
	 		
	 		Pelicula peli1=new Pelicula(2, "Peli Test", 470);
	 		Pelicula peli2=new Pelicula(2, "Peli Test 2", 350);
	 		Pelicula peli3=new Pelicula(2, "Peli Test 3", 390);
	 		Pelicula[] peliculas=new Pelicula[3];
	 		peliculas[0]=peli1;
	 		peliculas[1]=peli2;
	 		peliculas[2]=peli3;
	 		
	 		
	 		
	 		
	 		modelo.introducirPeliculaSeleccionada("Peli Test", controladormock,peliculas);
	 		modelo.introducirPeliculaSeleccionada("Peli Test 2", controladormock,peliculas);
	 		modelo.introducirPeliculaSeleccionada("Peli Test 3", controladormock,peliculas);
	 		

	 	}

	 

}
