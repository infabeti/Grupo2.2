package TestControlador;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import Controlador.Controlador;
import Controlador.ControladorPanelEditar;
import Controlador.ControladorPanelEditarPeliculas;
import Modelo.Modelo;
import Vista.PanelEditarPeliculas;
import Vista.Vista;

public class TestControladorPanelEditarPeliculas {
	private Modelo modeloMock = mock(Modelo.class);
	private Vista vistaMock = mock(Vista.class);
	private Controlador controladorMock = mock(Controlador.class);
	private ControladorPanelEditarPeliculas controladorEditarPeliculas=new ControladorPanelEditarPeliculas(modeloMock, vistaMock, controladorMock);
	private PanelEditarPeliculas panelEditarPeliculasMock = mock(PanelEditarPeliculas.class);
	private ControladorPanelEditarPeliculas spyControladorEditarPeliculas = spy(new ControladorPanelEditarPeliculas(modeloMock, vistaMock, controladorMock)); 


	@Test
	public void testContructorControladorEditarPeliculas() {
		assertEquals(modeloMock.getClass(), controladorEditarPeliculas.getModelo().getClass());
		assertEquals(vistaMock.getClass(), controladorEditarPeliculas.getVista().getClass());
		assertEquals(controladorMock.getClass(), controladorEditarPeliculas.getControlador().getClass());
		
	}
	
	@Test
	public void mostrarPanelEditarPeliculasTest() {
		doReturn(panelEditarPeliculasMock)
	    	.when(spyControladorEditarPeliculas)
	    	.makePanelEditarPeliculas(any( ControladorPanelEditarPeliculas.class),any( String.class)); 
		
		Modelo modelo=new Modelo();
		spyControladorEditarPeliculas = spy(new ControladorPanelEditarPeliculas(modelo, vistaMock, controladorMock)); 
	
		spyControladorEditarPeliculas.mostrarPanelEditarPeliculas("Handia");
		//verify(vistaMock, times(1)).mostrarPanel(panelBorrarMock);
		
	}
	@Test
	public void accionadoBotonVolverPanelEditarPeliculasTest() {
		controladorEditarPeliculas = new ControladorPanelEditarPeliculas(modeloMock,
				vistaMock, controladorMock);
		
		controladorEditarPeliculas.accionadoBotonVolverPanelEditarPeliculas();
		
		verify(controladorMock, times(1)).navegarPanelEditar();
	}
	
	public void accionadoBotonConfirmarPanelEditarPeliculasTest(){
		Modelo modelo1=new Modelo();
		
		controladorEditarPeliculas = new ControladorPanelEditarPeliculas(modelo1,
				vistaMock, controladorMock);
		
		controladorEditarPeliculas.accionadoBotonConfirmarPanelEditarPeliculas("Handia", 1, "Nuevo titulo", 120);
		
		verify(controladorMock, times(1)).navegarPanelEdicion();

	}
	

}
