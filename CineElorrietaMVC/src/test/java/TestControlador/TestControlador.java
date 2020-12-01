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
	
	private Modelo modeloMock = mock(Modelo.class);
	private Vista vistaMock = mock(Vista.class);
	private Controlador controlador=new Controlador(modeloMock, vistaMock);
	private Controlador spyControlador;
	private Controlador controladorMock= mock(Controlador.class);
	private ControladorPanelBienvenida controladorBienvenidaMock = mock(ControladorPanelBienvenida .class); 
	private ControladorPanelLogin controladorLoginMock =mock(ControladorPanelLogin.class); 
	private ControladorPanelGeneros controladorGenerosMock = mock(ControladorPanelGeneros.class); 
	private ControladorPanelPeliculas controladorPeliculasMock = mock(ControladorPanelPeliculas .class); 
	private ControladorPanelResumen controladorResumenMock =mock(ControladorPanelResumen.class);
	private ControladorPanelFin controladorFinMock =mock(ControladorPanelFin.class);
	
	private PanelGeneros panelGeneroMock = mock(PanelGeneros.class);
	
	Pelicula[] peliculas = new Pelicula[16];
	
	@Test
	public void testConstructorControlador() {
		assertEquals(vistaMock, controlador.getVista());
		assertEquals(modeloMock, controlador.getModelo());
		
		assertEquals(vistaMock.getClass(), controlador.getVista().getClass());
		assertEquals(modeloMock.getClass(), controlador.getModelo().getClass());
		
	}
	public void testNavegarPanelBienvenida() {
		this.controladorBienvenidaMock.mostrarPanelBienvenida();
	
	}
	@Test
	public void testNavegarPanelLogin() {
		
		
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
		
		
		controlador.navegarPanelPeliculas(2);
		
	}
	@Test
	public void testNavegarPanelResumen() {
		
		
		controlador.navegarPanelResumen();
		
	}
	@Test
	public void navegarPanelFin() {
		
		
		controlador.navegarPanelFin();
		
		
	}
	@Test
	public void getPeliculasTest() {
		
		
		
		Pelicula[] resultadoEsperado = controlador.getPeliculas();
	    assertEquals(resultadoEsperado, peliculas);
	}
	/*
	@Test
	public static void setPeliculasTest() {
		Controlador.peliculas = peliculas;
	}
	*/

}
