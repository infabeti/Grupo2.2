package TestModelo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import Modelo.Modelo;
import Modelo.ModeloGeneral;
import Modelo.Pelicula;

public class ModeloGeneralTest {
	private Modelo modeloMock=mock(Modelo.class);
	
	private ModeloGeneral modeloGeneral=new ModeloGeneral(modeloMock);
	private int resultadoEsperado,resultado;
	

	

	@Test
	public void testConstructorModeloGeneral() {
		
		
		assertEquals(modeloMock.getClass(), modeloGeneral.getModelo().getClass());
	}
	 @Rule
	    public TemporaryFolder folder = new TemporaryFolder();
	 @Test
	public void escribirErrorEnLogCorrectoTest() throws IOException {
		 File file=folder.newFile("errores.txt");
		 modeloGeneral.escribirErrorEnLog("Test Error");
		 

		 
	 }
	 /*
	 @Test
		public void escribirErrorEnLogFalloTest() throws IOException {
			 File file=folder.newFile("errores.txt");
			 org.junit.Assert.(modeloGeneral.escribirErrorEnLog("Test Error")).andThrow(
				        new IOException("Something terrible happened"));
			 

			 
		 }
		 */
	 @Test
		public void esperarTestCorrecto() {
			 assertEquals(true, modeloGeneral.esperar(3000));
			 
		 }
	 @Test
		public void comprobarGeneroTrueTest() {
		 assertEquals(true, modeloGeneral.comprobarGenero("1"));
		 assertEquals(true, modeloGeneral.comprobarGenero("2"));
		 assertEquals(true, modeloGeneral.comprobarGenero("3"));
		 assertEquals(true, modeloGeneral.comprobarGenero("4"));
	 
	 }
	 @Test
		public void comprobarGeneroFalseTest() {
		 assertEquals(false, modeloGeneral.comprobarGenero("5"));
	 
	 }
		
	 @Test
	public void minutosTotalesTest() {
		resultadoEsperado=100;
		
		
		modeloGeneral=new ModeloGeneral(modeloMock);
		//Pelicula peli1=new
		ArrayList<Pelicula> peliInstancia=new ArrayList();
		Pelicula peli=new Pelicula(1,"Test Pelicula",100);
		peliInstancia.add(peli);
		
		
		
		resultado = modeloGeneral.minutosTotales(peliInstancia);
		
		assertEquals(resultadoEsperado, resultado);
		
		
		
	

}
	

}
