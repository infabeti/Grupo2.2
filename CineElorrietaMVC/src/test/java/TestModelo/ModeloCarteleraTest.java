package TestModelo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;

import org.junit.Test;

import Controlador.Controlador;
import Modelo.Modelo;
import Modelo.ModeloCartelera;
import Modelo.Pelicula;


public class ModeloCarteleraTest {

	private Modelo modeloMock=mock(Modelo.class);
	private ModeloCartelera modeloCartelera=new ModeloCartelera(modeloMock);
	private Controlador controladorMock=mock(Controlador.class);
	private ArrayList<Pelicula> resultadoPeliculasSab;
	private ArrayList<Pelicula> resultadoPeliculasDom;
	
	
	@Test
	public void testConstructorModeloPeliculas() {
		resultadoPeliculasDom=modeloCartelera.getPeliculasDomingo();
		resultadoPeliculasSab=modeloCartelera.getPeliculasSabado();

		assertEquals(modeloMock.getClass(), modeloCartelera.getModelo().getClass());
		
		assertEquals(0, resultadoPeliculasDom.size());
		assertEquals(0, resultadoPeliculasSab.size());
		
		
		
		assertEquals(ArrayList.class,resultadoPeliculasDom.getClass());
		assertEquals(ArrayList.class,resultadoPeliculasSab.getClass());
		
	}
	
	
 	@Test
    public void introducirPeliculaSeleccionadaTest() {
 		
 		Modelo modelo1=new Modelo();
 		modeloCartelera=new ModeloCartelera(modelo1);

        Pelicula peli1=new Pelicula(2, "Peli Test", 470);
        Pelicula peli2=new Pelicula(2, "Peli Test 2", 350);
        Pelicula peli3=new Pelicula(2, "Peli Test 3", 390);
        Pelicula[] peliculas=new Pelicula[3];
        peliculas[0]=peli1;
        peliculas[1]=peli2;
        peliculas[2]=peli3;
        modeloCartelera.getModelo().getModeloPeliculas().setPeliculas(peliculas);




        modeloCartelera.introducirPeliculaSeleccionada("Peli Test", controladorMock);
        modeloCartelera.introducirPeliculaSeleccionada("Peli Test 2", controladorMock);
        modeloCartelera.introducirPeliculaSeleccionada("Peli Test 3", controladorMock);
        


    }
    
 	@Test
    public void limpiarDiasTest() {
 		
 		Pelicula peli1=new Pelicula(2,"Titulo Test",110);
		

		
		Modelo modelo1=new Modelo();
 		modeloCartelera=new ModeloCartelera(modelo1);
		modeloCartelera.getPeliculasSabado().add(peli1);
		modeloCartelera.getPeliculasDomingo().add(peli1);
		
		modeloCartelera.limpiarDias();
		
		assertEquals(0, modeloCartelera.getPeliculasSabado().size());
		assertEquals(0, modeloCartelera.getPeliculasDomingo().size());
 		
 	}
 	
	 @Test
		public void resumenEscritoRellenoTest() {
			String resultadoEsperado="";
			String resultado;
			Pelicula peli1=new Pelicula(2,"Titulo Test",110);
			

			
			Modelo modelo1=new Modelo();
	 		modeloCartelera=new ModeloCartelera(modelo1);
			modeloCartelera.getPeliculasSabado().add(peli1);
			modeloCartelera.getPeliculasDomingo().add(peli1);
			
			//resultadoFinal=resultadoFinal+getPeliculasSabado().get(i).getTitulo()+"-> "+
			//horas+"h "+minutos+"m \n";
			resultadoEsperado=resultadoEsperado+"Sábado: \n";
			resultadoEsperado=resultadoEsperado+peli1.getTitulo()+"-> 1h 50m \n";
			
			resultadoEsperado=resultadoEsperado+"\nDomingo: \n";
			resultadoEsperado=resultadoEsperado+peli1.getTitulo()+"-> 1h 50m \n";
			
			
			
			resultado = modeloCartelera.resumenEscrito();
			
			assertEquals(resultadoEsperado, resultado);
			
			
	}
	 @Test
		public void resumenEscritoVacioTest() {
			String resultadoEsperado="";
			String resultado;
			resultadoEsperado=resultadoEsperado+"Sábado: \n";
			resultadoEsperado=resultadoEsperado+"\nDomingo: \n";
			

			resultado = modeloCartelera.resumenEscrito();
			
			assertEquals(resultadoEsperado, resultado);
			
			
	}

}
