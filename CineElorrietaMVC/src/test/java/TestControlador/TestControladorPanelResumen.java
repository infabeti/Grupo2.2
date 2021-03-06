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
import Controlador.ControladorPanelGeneros;
import Controlador.ControladorPanelPeliculas;
import Controlador.ControladorPanelResumen;
import Modelo.Modelo;
import Modelo.Pelicula;
import Vista.PanelPeliculas;
import Vista.PanelResumen;
import Vista.Vista;

public class TestControladorPanelResumen {
	

	
	private Modelo modeloMock = mock(Modelo.class);
	private Vista vistaMock = mock(Vista.class);
	private Controlador controladorMock = mock(Controlador.class);
	private ControladorPanelResumen controladorResumen=new ControladorPanelResumen(modeloMock, vistaMock, controladorMock);
	private PanelResumen panelResumenMock = mock(PanelResumen.class);
	private ControladorPanelResumen spyControladorResumen = spy(new ControladorPanelResumen(modeloMock, vistaMock, controladorMock)); 

	@Test
	public void testContructorControladorResumen() {
		assertEquals(modeloMock.getClass(), controladorResumen.getModelo().getClass());
		assertEquals(vistaMock.getClass(), controladorResumen.getVista().getClass());
		assertEquals(controladorMock.getClass(), controladorResumen.getControlador().getClass());
		
	}
	
	@Test
	public void mostrarPanelResumenTest() {
		doReturn(panelResumenMock)
	    	.when(spyControladorResumen)
	    	.makePanelResumen(any(ControladorPanelResumen.class)); 
		
		Modelo modelo=new Modelo();
		spyControladorResumen = spy(new ControladorPanelResumen(modelo, vistaMock, controladorMock));
		
		spyControladorResumen.mostrarPanelResumen();
		//verify(vistaMock, times(1)).mostrarPanel(panelResumenMock);
	}
	
	
	@Test
	public void accionadoBotonAceptarPanelResumenTest() {
		controladorResumen = new ControladorPanelResumen(modeloMock,
				vistaMock, controladorMock);
		
		
		ArrayList<Pelicula> peliculas=new ArrayList<Pelicula>();
		Pelicula peli1=new Pelicula(2,"Handia",126);
		peliculas.add(peli1);
		
	
		controladorResumen.accionadoBotonAceptarPanelResumen();
		
		verify(controladorMock, times(1)).navegarPanelFin();
	

}
	
	@Test
	public void accionadoBotonRechazarPanelResumenTest() {
		Modelo modelo=new Modelo();
		controladorResumen = new ControladorPanelResumen(modelo,
				vistaMock, controladorMock);
		
		controladorResumen.accionadoBotonRechazarPanelResumen();
		
		verify(controladorMock, times(1)).navegarPanelGeneros();
	

}

}
