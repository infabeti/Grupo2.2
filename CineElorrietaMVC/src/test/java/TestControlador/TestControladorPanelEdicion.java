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
import Controlador.ControladorPanelEdicion;
import Modelo.Modelo;
import Vista.PanelEdicion;
import Vista.Vista;

public class TestControladorPanelEdicion {
	private Modelo modeloMock = mock(Modelo.class);
	private Vista vistaMock = mock(Vista.class);
	private Controlador controladorMock = mock(Controlador.class);
	private ControladorPanelEdicion controladorEdicion=new ControladorPanelEdicion(modeloMock, vistaMock, controladorMock);
	private PanelEdicion panelEdicionMock = mock(PanelEdicion.class);
	private ControladorPanelEdicion spyControladorEdicion = spy(new ControladorPanelEdicion(modeloMock, vistaMock, controladorMock)); 


	@Test
	public void testContructorControladorGeneros() {
		assertEquals(modeloMock.getClass(), controladorEdicion.getModelo().getClass());
		assertEquals(vistaMock.getClass(), controladorEdicion.getVista().getClass());
		assertEquals(controladorMock.getClass(), controladorEdicion.getControlador().getClass());
		
	}
	@Test
	public void mostrarPanelEdicionTest() {
		doReturn(panelEdicionMock)
	    	.when(spyControladorEdicion)
	    	.makePanelEdicion(any( ControladorPanelEdicion.class)); 
		
		spyControladorEdicion.mostrarPanelEdicion();
		//verify(vistaMock, times(1)).mostrarPanel(panelEdicionMock);
	}

	
	@Test
	public void accionadoBotonEditarPanelEdicionTest() {
		controladorEdicion = new ControladorPanelEdicion(modeloMock,
				vistaMock, controladorMock);
		
		controladorEdicion.accionadoBotonEditar();
		
		verify(controladorMock, times(1)).navegarPanelEditar();
	}

	@Test
	public void accionadoBotonBorrarPanelEdicionTest() {
		controladorEdicion = new ControladorPanelEdicion(modeloMock,
				vistaMock, controladorMock);
		
		controladorEdicion.accionadoBotonBorrar();
		
		verify(controladorMock, times(1)).navegarPanelBorrar();
	}
	@Test
	public void accionadoBotonAnadirPanelEdicionTest() {
		controladorEdicion = new ControladorPanelEdicion(modeloMock,
				vistaMock, controladorMock);
		
		controladorEdicion.accionadoBotonAnadir();
		
		verify(controladorMock, times(1)).navegarPanelAnadir();
	}
	@Test
	public void accionadoBotonCancelarPanelEdicionTest() {
		Modelo modelo=new Modelo();
		controladorEdicion = new ControladorPanelEdicion(modelo,
				vistaMock, controladorMock);
		
		controladorEdicion.accionadoBotonCancelar();
		
		verify(controladorMock, times(1)).navegarPanelBienvenida();
	}
	@Test
	public void accionadoBotonConfirmarPanelEdicionTest() {
		controladorEdicion = new ControladorPanelEdicion(modeloMock,
				vistaMock, controladorMock);
		
		controladorEdicion.accionadoBotonConfirmar();
		
		verify(controladorMock, times(1)).navegarPanelResumen2();
	}
	

}
