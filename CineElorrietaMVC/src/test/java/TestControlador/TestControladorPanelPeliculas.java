package TestControlador;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;

import javax.swing.JList;

import org.junit.Test;

import Controlador.Controlador;
import Controlador.ControladorPanelGeneros;
import Controlador.ControladorPanelPeliculas;
import Controlador.ControladorPanelPeliculas;
import Modelo.Modelo;
import Modelo.Pelicula;
import Vista.PanelGeneros;
import Vista.PanelPeliculas;
import Vista.Vista;

public class TestControladorPanelPeliculas {
	
	private Modelo modeloMock = mock(Modelo.class);
	private Vista vistaMock = mock(Vista.class);
	private Controlador controladorMock = mock(Controlador.class);
	private ControladorPanelPeliculas controladorPeliculas=new ControladorPanelPeliculas(modeloMock, vistaMock, controladorMock);
	private PanelPeliculas panelPeliculasMock = mock(PanelPeliculas.class);
	private PanelGeneros panelGenerosMock = mock(PanelGeneros.class);
	private ControladorPanelPeliculas spyControladorPeliculas = spy(new ControladorPanelPeliculas(modeloMock, vistaMock, controladorMock)); 
	
	private int resultado;
	private int resultadoEsperado;
	
	@Test
	public void testContructorControladorPeliculas() {
		assertEquals(modeloMock.getClass(), controladorPeliculas.getModelo().getClass());
		assertEquals(vistaMock.getClass(), controladorPeliculas.getVista().getClass());
		assertEquals(controladorMock.getClass(), controladorPeliculas.getControlador().getClass());
		
	}

	
	@Test
	public void mostrarPanelPeliculasTest() {
		doReturn(panelPeliculasMock)
	    	.when(spyControladorPeliculas)
	    	.makePanelPeliculas(any( ControladorPanelPeliculas.class),any(String.class)); 
		
		Modelo modelo=new Modelo();
		spyControladorPeliculas = spy(new ControladorPanelPeliculas(modelo, vistaMock, controladorMock));
		spyControladorPeliculas.mostrarPanelPeliculas("2");
		//verify(vistaMock, times(1)).mostrarPanel(panelPeliculasMock);
	}
	

	//testeo del boton que nos lleva al panel de bienvenida
	@Test
	public void accionadoBottonVolverPanelPeliculasTest() {
		Modelo modelo=new Modelo();
		controladorPeliculas = new ControladorPanelPeliculas(modelo,
				vistaMock, controladorMock);
		
		controladorPeliculas.accionadoBotonVolverPanelPeliculas();
		
		verify(controladorMock, times(1)).navegarPanelGeneros();
	

}
	
/*
	public void testAccionadoBotonAnadirPanelPeliculas() {
		Modelo modelo=new Modelo();
		Controlador controlador=new Controlador(modelo,vistaMock);
		controladorPeliculas = new ControladorPanelPeliculas(modelo,
						vistaMock, controlador);
				
				
		controladorPeliculas.accionadoBotonAnadirPanelPeliculas("Handia");
				
				
		verify(controladorMock, times(0)).navegarPanelGeneros();


				
				
				
	}
	*/

			
	
	
	
	
}
