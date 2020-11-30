package TestControlador;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;

import org.junit.Test;

import Controlador.Controlador;
import Controlador.ControladorPanelBienvenida;
import Controlador.ControladorPanelFin;
import Controlador.ControladorPanelGeneros;
import Controlador.ControladorPanelLogin;
import Controlador.ControladorPanelPeliculas;
import Controlador.ControladorPanelResumen;
import Modelo.Modelo;
import Modelo.Pelicula;
import Vista.PanelGeneros;
import Vista.Vista;

public class TestControlador {
	private Controlador controlador;
	private Modelo modeloMock = mock(Modelo.class);
	private Vista vistaMock = mock(Vista.class);	
	private Controlador spyControlador;
	private Controlador controladorMock= mock(Controlador.class);
	private ControladorPanelBienvenida controladorBienvenidaMock = mock(ControladorPanelBienvenida .class); 
	private ControladorPanelLogin controladorLoginMock =mock(ControladorPanelLogin.class); 
	private ControladorPanelGeneros controladorGenerosMock = mock(ControladorPanelGeneros.class); 
	private ControladorPanelPeliculas controladorPeliculasMock = mock(ControladorPanelPeliculas .class); 
	private ControladorPanelResumen controladorResumenMock =mock(ControladorPanelResumen.class);
	private ControladorPanelFin controladorFinMock =mock(ControladorPanelFin.class);
	
	private PanelGeneros panelGeneroMock = mock(PanelGeneros.class);
	public void testNavegarPanelBienvenida() {
		this.controladorBienvenidaMock.mostrarPanelBienvenida();
	
	}
	@Test
	public void testNavegarPanelLogin() {
		controlador=new Controlador(modeloMock,vistaMock);
		
		controlador.navegarPanelLogin();
	}
	
	@Test
	public void testNavegarPanelGeneros() {
		spyControlador = spy(new Controlador(modeloMock, vistaMock)); 
		doReturn(controladorGenerosMock)
    	.when(spyControlador)
    	.makeControladorGeneros(any(Modelo.class), any(Vista.class), any(Controlador.class)); 
	
	spyControlador.navegarPanelGeneros();
	verify(spyControlador, times(1)).navegarPanelGeneros();
}//		COMO SE HACE???
		/*doReturn(panelGeneroMock)
    	.when(spyControlador)
    	.makeControladorGeneros(any(Modelo.class), any(Vista.class), any(Controlador.class)); 
	
		spyControlador.navegarPanelGeneros();
		verify(vistaMock, times(1)).mostrarPanel(panelGeneroMock);
	}
	
			/*spyControlador = spy(new Controlador(modeloMock, vistaMock)); 
			doReturn(controladorGenerosMock)
			.when(spyControlador)
			.makeControladorPanelGeneros(any(Modelo.class), any(Vista.class), any(Controlador.class));
		
		
		spyControlador.navegarPanelGeneros();
		
		verify(spyControlador, times(1)).controladorProductosMostrarPanelProductos();
	}*/
	@Test
	public void testNavegarPanelPeliculas() {
		controlador=new Controlador(modeloMock,vistaMock);
		
		controlador.navegarPanelPeliculas(2);
		
	}
	@Test
	public void testNavegarPanelResumen() {
		controlador=new Controlador(modeloMock,vistaMock);
		
		controlador.navegarPanelResumen();
		
	}
	@Test
	public void navegarPanelFin() {
		controlador=new Controlador(modeloMock,vistaMock);
		
		controlador.navegarPanelFin();
		
		
	}
	@Test
	public void getPeliculasTest() {
		controlador=new Controlador(modeloMock,vistaMock);
		
	    
		Pelicula[] resultadoEsperado=new Pelicula[16];
		resultadoEsperado[0] = new Pelicula(1, "Handia", 116);
		resultadoEsperado[1] = new Pelicula(1, "La lista de Schindler", 197);
		resultadoEsperado[2] = new Pelicula(1, "Cadena Perpetua", 142);
		resultadoEsperado[3] = new Pelicula(1, "Million Dollar Baby", 133);

		resultadoEsperado[4] = new Pelicula(2, "Scary movie", 90);
		resultadoEsperado[5] = new Pelicula(2, "El gran Lebowsky", 119);
		resultadoEsperado[6] = new Pelicula(2, "La vida de Brian", 94);
		resultadoEsperado[7] = new Pelicula(2, "Aterriza como puedas", 117);

		resultadoEsperado[8] = new Pelicula(3, "Psicosis", 109);
		resultadoEsperado[9] = new Pelicula(3, "El resplandor", 146);
		resultadoEsperado[10] = new Pelicula(3, "Dracula", 155);
		resultadoEsperado[11] = new Pelicula(3, "Cisne negro", 100);

		resultadoEsperado[12] = new Pelicula(4, "2001: Odisea en el espacio", 142);
		resultadoEsperado[13] = new Pelicula(4, "La novia de Frankenstein", 75);
		resultadoEsperado[14] = new Pelicula(4, "El planeta de los simios", 115);
		resultadoEsperado[15] = new Pelicula(4, "Alien, el octavo pasajero", 117);
	    
	    controlador.introducirPrimerasPeliculas();
		Pelicula[] resultado = controlador.getPeliculas();
	    assertEquals(resultadoEsperado, resultado);
	}
	/*
	@Test
	public static void setPeliculasTest() {
		Controlador.peliculas = peliculas;
	}
	*/

}
