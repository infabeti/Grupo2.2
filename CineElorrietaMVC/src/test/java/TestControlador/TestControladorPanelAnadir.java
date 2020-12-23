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
import Controlador.ControladorPanelAnadir;
import Modelo.Modelo;
import Vista.PanelAnadir;
import Vista.Vista;

public class TestControladorPanelAnadir {
	private Modelo modeloMock = mock(Modelo.class);
	private Vista vistaMock = mock(Vista.class);
	private Controlador controladorMock = mock(Controlador.class);
	private ControladorPanelAnadir controladorAnadir=new ControladorPanelAnadir(modeloMock, vistaMock, controladorMock);
	private PanelAnadir panelAnadirMock = mock(PanelAnadir.class);
	private ControladorPanelAnadir spyControladorAnadir = spy(new ControladorPanelAnadir(modeloMock, vistaMock, controladorMock)); 


	@Test
	public void testContructorControladorBorrar() {
		assertEquals(modeloMock.getClass(), controladorAnadir.getModelo().getClass());
		assertEquals(vistaMock.getClass(), controladorAnadir.getVista().getClass());
		assertEquals(controladorMock.getClass(), controladorAnadir.getControlador().getClass());
		
	}
	
	@Test
	public void mostrarPanelBorrarTest() {
		doReturn(panelAnadirMock)
	    	.when(spyControladorAnadir)
	    	.makePanelAnadir(any( ControladorPanelAnadir.class)); 
		
		Modelo modelo=new Modelo();
		spyControladorAnadir = spy(new ControladorPanelAnadir(modelo, vistaMock, controladorMock)); 
		
		
		
		
		spyControladorAnadir.mostrarPanelAnadir();
		//verify(vistaMock, times(1)).mostrarPanel(panelBorrarMock);
		
	}
	
	@Test
	public void accionadoBotonCancelarPanelAnadirTest() {
		controladorAnadir = new ControladorPanelAnadir(modeloMock,
				vistaMock, controladorMock);
		
		controladorAnadir.accionadoBotonCancelarPanelAnadir();
		
		verify(controladorMock, times(1)).navegarPanelEdicion();
	}
	@Test
	public void accionadoBotonConfirmarPanelAnadirTest() {
		Modelo modelo=new Modelo();
		controladorAnadir = new ControladorPanelAnadir(modelo,
				vistaMock, controladorMock);
		
		controladorAnadir.accionadoBotonConfirmarPanelAnadir(2, "Test Pelicula", 120);
		
		verify(controladorMock, times(1)).navegarPanelEdicion();
	}
	

}
