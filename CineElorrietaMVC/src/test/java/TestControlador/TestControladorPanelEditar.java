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
import Controlador.ControladorPanelBorrar;
import Controlador.ControladorPanelEditar;
import Modelo.Modelo;
import Vista.PanelBorrar;
import Vista.PanelEditar;
import Vista.Vista;

public class TestControladorPanelEditar {
	private Modelo modeloMock = mock(Modelo.class);
	private Vista vistaMock = mock(Vista.class);
	private Controlador controladorMock = mock(Controlador.class);
	private ControladorPanelEditar controladorEditar=new ControladorPanelEditar(modeloMock, vistaMock, controladorMock);
	private PanelEditar panelEditarMock = mock(PanelEditar.class);
	private ControladorPanelEditar spyControladorEditar = spy(new ControladorPanelEditar(modeloMock, vistaMock, controladorMock)); 


	@Test
	public void testContructorControladorEditar() {
		assertEquals(modeloMock.getClass(), controladorEditar.getModelo().getClass());
		assertEquals(vistaMock.getClass(), controladorEditar.getVista().getClass());
		assertEquals(controladorMock.getClass(), controladorEditar.getControlador().getClass());
		
	}
	
	@Test
	public void mostrarPanelEditarTest() {
		doReturn(panelEditarMock)
	    	.when(spyControladorEditar)
	    	.makePanelEditar(any( ControladorPanelEditar.class)); 
		
		Modelo modelo=new Modelo();
		spyControladorEditar = spy(new ControladorPanelEditar(modelo, vistaMock, controladorMock)); 
	
		spyControladorEditar.mostrarPanelEditar();
		//verify(vistaMock, times(1)).mostrarPanel(panelBorrarMock);
		
	}
	@Test
	public void accionadoBotonVolverPanelEditarTest() {
		controladorEditar = new ControladorPanelEditar(modeloMock,
				vistaMock, controladorMock);
		
		controladorEditar.accionadoBotonVolverPanelEditar();
		
		verify(controladorMock, times(1)).navegarPanelEdicion();
	}
	@Test
	public void accionadoBotonSeleccionarPanelEditarTest() {
		Modelo modelo=new Modelo();
		controladorEditar = new ControladorPanelEditar(modelo,
				vistaMock, controladorMock);
	
		controladorEditar.accionadoBotonSeleccionarPanelEditar("Handia");
		
		verify(controladorMock, times(1)).navegarPanelEditarPeliculas("Handia");
	}

}
