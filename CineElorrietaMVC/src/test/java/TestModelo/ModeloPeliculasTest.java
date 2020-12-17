package TestModelo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import Modelo.Modelo;
import Modelo.ModeloPeliculas;
import Modelo.Pelicula;

public class ModeloPeliculasTest {
	
	private Modelo modeloMock=mock(Modelo.class);
	private ModeloPeliculas modeloPeliculas=new ModeloPeliculas(modeloMock);
	
	@Test
	public void testConstructorModeloPeliculas() {
		
		
		assertEquals(modeloMock.getClass(), modeloPeliculas.getModelo().getClass());
	}
	@Test
	public void setPeliculasTest() {
		Pelicula[] esperado = new Pelicula[15];
		
		modeloPeliculas.setPeliculas(esperado);
		
		assertEquals(esperado, modeloPeliculas.getPeliculas());
	
	}
	@Test
	public void introduccirPrimerasPeliculasTest() {
		modeloPeliculas.introducirPrimerasPeliculas();
		
		assertNotEquals(null, modeloPeliculas.getPeliculas());
	}
	@Test
	public void listaPorGeneroTest() {
		modeloPeliculas.introducirPrimerasPeliculas();
		
		modeloPeliculas.listaPorGenero("2");
	
	}

	
}
