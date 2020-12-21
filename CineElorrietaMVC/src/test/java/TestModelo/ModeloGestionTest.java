package TestModelo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import Modelo.Modelo;
import Modelo.ModeloGestion;
import Modelo.Pelicula;


public class ModeloGestionTest {
	private Modelo modeloMock=mock(Modelo.class);
	private Modelo modelo=new Modelo();
	private ModeloGestion modeloGestion=new ModeloGestion(modelo);
	
	
	@Test
	public void testConstructorModeloGestion() {
		
		
		assertEquals(modelo.getClass(), modeloGestion.getModelo().getClass());
	}
	@Test
	public void getAuxiliarTest() {
		
		Pelicula[] peliculasAuxiliar=modeloGestion.getAuxiliar();
	}
	
	@Test
	public void actualizarPeliculasTest() {
		
		modeloGestion.actualizarPeliculas();
	
	}
	@Test
	public void actualizarAuxiliarTest() {

		
		modeloGestion.actualizarAuxiliar();
	
	}
	@Test
	public void encontrarPeliculaTrueTest() {
		assertEquals(true, modeloGestion.encontrarPelicula("Handia"));
		

	}
	@Test
	public void encontrarPeliculaFalseTest() {
		assertEquals(false, modeloGestion.encontrarPelicula("noexisteestapelicula"));
		

	
	}
	@Test
	public void buscarPeliculaTest() {
		
		Pelicula resultadoEsperado=new Pelicula(1, "Handia", 116);
		Pelicula resultado=modeloGestion.buscarPelicula("Handia");
		
		//assertEquals(resultadoEsperado, resultado);
		

	
	}
	@Test
	public void borrarPeliculaTrueTest() {
	
		assertEquals(true, modeloGestion.borrarPelicula("Handia"));

	}
	@Test
	public void borrarPeliculaFalseTest() {
	
		assertEquals(false, modeloGestion.borrarPelicula("noexisteestapelicula"));

	}
	@Test
	public void meterPeliculaTrueTest() {
	
		
		assertEquals(true, modeloGestion.meterPelicula(1,"noexisteestapelicula",100));

	}
	@Test
	public void meterPeliculaFalseTest() {
	
		assertEquals(false, modeloGestion.meterPelicula(1,"Handia",100));

	}
	@Test
	public void borrarListaTrueTest() {
		String[] listaParaBorrar=new String[3];
		listaParaBorrar[0]="Handia";
		listaParaBorrar[1]="La lista de Schindler";
		listaParaBorrar[2]="Cadena perpetua";
		
	
		
		assertEquals(true, modeloGestion.borrarLista(listaParaBorrar));

	}
	@Test
	public void borrarListaFalseTest() {
	
		String[] listaParaBorrar=new String[0];

		assertEquals(false, modeloGestion.borrarLista(listaParaBorrar));

	}
	
	@Test
	public void editarPeliculaTrueTest() {
	
		
		assertEquals(true, modeloGestion.editarPelicula("Handia", 2, "Nuevo titulo", 120));

	}
	
	@Test
	public void editarPeliculaFalseTest() {
	
		assertEquals(false, modeloGestion.editarPelicula("Estapeliculanoexiste", 2, "Nuevo titulo", 120));

	}
	

}
