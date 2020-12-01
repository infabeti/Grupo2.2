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
	private JList listamock=mock(JList.class);
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
		
		//assertEquals(Pelicula.class,resultadoPeliculasDom.);
		
		
	}
	 @Rule
	    public TemporaryFolder folder = new TemporaryFolder();
	 @Test
	public void escribirErrorEnLogTest() throws IOException {
		 File file=folder.newFile("errores.txt");
		 modelo.escribirErrorEnLog("Test Error");
		 
		 
		 
	 
		 
		 
		 
	 }
	 @Test
		public void esperarTestCorrecto() {

			 modelo.esperar(3000);
			
			 	 
			 
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
		public void resumenEscritoTest() {
			String resultadoEsperado="";
			String resultado;
			resultadoEsperado=resultadoEsperado+"Sábado: \n";
			resultadoEsperado=resultadoEsperado+"\nDomingo: \n";
			
			
			modelo=new Modelo();
			
			
			
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
	 	public void introducirPeliculaSeleccionadaVaciaTest() {
	 		modelo.introducirPeliculaSeleccionada(listamock, controladormock);
	 		assertEquals(0,modelo.getPeliculasSabado().size());
	 		
	 		
	 		
	 	}
	 	@Test
	 	public void introducirPeliculaSeleccionadaRellenaTest() {
	 		DefaultListModel listModel = new DefaultListModel();
	 		listModel.addElement("PeliculaTest");
	 		listamock.setModel(listModel);
	 		listamock.setSelectedIndex(0);
	 	
	 		System.out.println(listamock.getComponent(1));
	 		
	 		
	 		modelo.introducirPeliculaSeleccionada(listamock, controladormock);
	 		

	 	}

	 

}
