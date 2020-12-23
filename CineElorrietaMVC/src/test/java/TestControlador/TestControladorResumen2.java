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
import Controlador.ControladorPanelEditar;
import Controlador.ControladorResumen2;
import Modelo.Modelo;
import Vista.PanelAnadir;
import Vista.PanelResumen2;
import Vista.Vista;

public class TestControladorResumen2 {
	private Modelo modeloMock = mock(Modelo.class);
	private Vista vistaMock = mock(Vista.class);
	private Controlador controladorMock = mock(Controlador.class);
	private ControladorResumen2 controladorResumen2=new ControladorResumen2(modeloMock, vistaMock, controladorMock);
	private PanelResumen2 panelResumen2Mock = mock(PanelResumen2.class);
	private ControladorResumen2 spyControladorResumen2 = spy(new ControladorResumen2(modeloMock, vistaMock, controladorMock)); 


	@Test
	public void testContructorControladorBorrar() {
		assertEquals(modeloMock.getClass(), controladorResumen2.getModelo().getClass());
		assertEquals(vistaMock.getClass(), controladorResumen2.getVista().getClass());
		assertEquals(controladorMock.getClass(), controladorResumen2.getControlador().getClass());
		
	}
	
	@Test
	public void mostrarPanelBorrarTest() {
		doReturn(panelResumen2Mock)
	    	.when(spyControladorResumen2)
	    	.makePanelResumen2(any( ControladorResumen2.class)); 
		
		Modelo modelo=new Modelo();
		spyControladorResumen2 = spy(new ControladorResumen2(modelo, vistaMock, controladorMock)); 
		
		
		
		
		spyControladorResumen2.mostrarPanelResumen2();
		//verify(vistaMock, times(1)).mostrarPanel(panelBorrarMock);
		
	}
	@Test
	public void accionadoBotonCancelarPanelResumen2() {
		Modelo modelo=new Modelo();
		controladorResumen2 = new ControladorResumen2(modelo,
				vistaMock, controladorMock);
		
		controladorResumen2.accionadoBotonCancelarPanelResumen2();
		
		verify(controladorMock, times(1)).navegarPanelBienvenida();

		//verify(vistaMock, times(1)).mostrarPanel(panelBorrarMock);
		
	}
	@Test
	public void accionadoBotonConfirmarPanelResumen2() {
		Modelo modelo=new Modelo();
		controladorResumen2 = new ControladorResumen2(modelo,
				vistaMock, controladorMock);
		
		controladorResumen2.accionadoBotonAceptarPanelResumen2();
		
		verify(controladorMock, times(1)).navegarPanelEdicion();

		//verify(vistaMock, times(1)).mostrarPanel(panelBorrarMock);
		
	}
	

}
