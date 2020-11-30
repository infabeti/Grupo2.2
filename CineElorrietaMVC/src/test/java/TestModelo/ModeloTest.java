package TestModelo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import Controlador.ControladorPanelPeliculas;
import Modelo.Modelo;
import Modelo.Pelicula;

public class ModeloTest {
	private Modelo modelo;
	private Modelo modeloMock = mock(Modelo.class);
	private int resultadoEsperado,resultado;
	
	@Test
	public void testModelo() {
		modelo=new Modelo();
	}
	 @Rule
	    public TemporaryFolder folder = new TemporaryFolder();
	 @Test
	public void escribirErrorEnLogTest() throws IOException {
		 File file=folder.newFile("errores.txt");
		 modeloMock.escribirErrorEnLog("Test Error");
		 
	 
		 
		 
		 
	 }
	 @Test
		public void esperarTest() {
			
			 modeloMock.esperar(3000);
			 	 
			 
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
	 

}
