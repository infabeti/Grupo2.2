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
	
	private ControladorPanelResumen controladorResumen;
	private ControladorPanelPeliculas controladorPeliculas;
	private Modelo modeloMock = mock(Modelo.class);
	private Vista vistaMock = mock(Vista.class);
	private Controlador controladorMock = mock(Controlador.class);
	private PanelResumen panelResumenMock = mock(PanelResumen.class);
	private ControladorPanelResumen spyControladorGeneros = spy(new ControladorPanelResumen(modeloMock, vistaMock, controladorMock)); 

	
	
	@Test
	public void mostrarPanelResumenTest() {
		doReturn(panelResumenMock)
	    	.when(spyControladorGeneros)
	    	.makePanelResumen(any( ControladorPanelResumen.class)); 
		
		spyControladorGeneros.mostrarPanelResumen();
		verify(vistaMock, times(1)).mostrarPanel(panelResumenMock);
	}
	
	
	@Test
	public void accionadoBotonAceptarPanelResumenTest() {
		controladorResumen = new ControladorPanelResumen(modeloMock,
				vistaMock, controladorMock);
		controladorPeliculas=new ControladorPanelPeliculas(modeloMock, vistaMock, controladorMock);
		
		ArrayList<Pelicula> peliculas=new ArrayList<Pelicula>();
		Pelicula peli1=new Pelicula(2,"Handia",126);
		peliculas.add(peli1);
		
	
		controladorResumen.accionadoBotonAceptarPanelResumen();
		
		verify(controladorMock, times(1)).navegarPanelFin();
	

}
	
	@Test
	public void accionadoBotonRechazarPanelResumenTest() {
		controladorResumen = new ControladorPanelResumen(modeloMock,
				vistaMock, controladorMock);
		
		controladorResumen.accionadoBotonRechazarPanelResumen();
		
		verify(controladorMock, times(1)).navegarPanelGeneros();
	

}

}
