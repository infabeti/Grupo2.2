package TestModelo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Controlador.ControladorPanelPeliculas;
import Modelo.Modelo;
import Modelo.Pelicula;

public class ModeloTest {

	@Test
	public void testModelo() {
		Modelo nuevoModelo=new Modelo();
	}
	
	/*
	 @Test
	public void minutosTotalesTest() {
		resultadoEsperado=100;
		
		
		controladorPeliculas = new ControladorPanelPeliculas(modeloMock,
				vistaMock, controladorMock);
		//Pelicula peli1=new
		ArrayList<Pelicula> peliInstancia=new ArrayList();
		Pelicula peli=new Pelicula(1,"Test Pelicula",100);
		peliInstancia.add(peli);
		controladorPeliculas.setPeliculasSabado(peliInstancia);
		
		
		resultado = controladorPeliculas.minutosTotalesSabado();
		
		assertEquals(resultadoEsperado, resultado);
		
		
		
	

}
	 */
	
	/*
	 	@Test
			public void testGetPeliculasSabado() {
				controladorPeliculas = new ControladorPanelPeliculas(modeloMock,
						vistaMock, controladorMock);
				
				ArrayList<Pelicula> peliInstancia=new ArrayList();
				controladorPeliculas.setPeliculasSabado(peliInstancia);
			    
				ArrayList<Pelicula> resultadoEsperado=new ArrayList();
			    
			    
				ArrayList<Pelicula> resultado = controladorPeliculas.getPeliculasSabado();
			    assertEquals(resultadoEsperado, resultado);
			}
	 */

}
