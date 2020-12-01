package TestControlador;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Spy;

import Controlador.Controlador;
import Controlador.ControladorPanelFin;
import Modelo.Modelo;
import Vista.PanelFin;
import Vista.Vista;

public class TestControladorPanelFin {
	private ControladorPanelFin controladorFin;
	private Modelo modeloMock = mock(Modelo.class);
	private Vista vistaMock = mock(Vista.class);
	private Controlador controladorMock = mock(Controlador.class);
	private PanelFin panelFinMock = mock(PanelFin.class);
	private ControladorPanelFin spyControladorFin = spy(new ControladorPanelFin(modeloMock, vistaMock, controladorMock)); 

	@Test
	public void testContructorControladorFin() {
		assertEquals(modeloMock.getClass(), controladorFin.getModelo().getClass());
		assertEquals(vistaMock.getClass(), controladorFin.getVista().getClass());
		assertEquals(controladorMock.getClass(), controladorFin.getControlador().getClass());
		
	}

	@Test
	public void mostrarPanelFinTest() {
		doReturn(panelFinMock)
	    	.when(spyControladorFin)
	    	.makePanelFin(any( ControladorPanelFin.class)); 
		
		spyControladorFin.mostrarPanelFin();
		verify(vistaMock, times(1)).mostrarPanel(panelFinMock);
	}
	

	
	
	@Test
	public void falloMostrarPanelFinTest() throws Exception {
		doReturn(panelFinMock)
    	.when(spyControladorFin)
    	.makePanelFin(any( ControladorPanelFin.class)); 
		
	
		//spyControladorFin.mostrarPanelFin();
		
		controladorFin=new ControladorPanelFin(modeloMock, vistaMock, controladorMock);
	
	}
	
	
	
}
