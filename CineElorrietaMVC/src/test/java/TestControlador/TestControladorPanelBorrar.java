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
import Controlador.ControladorPanelEdicion;
import Modelo.Modelo;
import Vista.PanelBorrar;
import Vista.Vista;

public class TestControladorPanelBorrar {
	private Modelo modeloMock = mock(Modelo.class);
	private Vista vistaMock = mock(Vista.class);
	private Controlador controladorMock = mock(Controlador.class);
	private ControladorPanelBorrar controladorBorrar=new ControladorPanelBorrar(modeloMock, vistaMock, controladorMock);
	private PanelBorrar panelBorrarMock = mock(PanelBorrar.class);
	private ControladorPanelBorrar spyControladorBorrar = spy(new ControladorPanelBorrar(modeloMock, vistaMock, controladorMock)); 


	@Test
	public void testContructorControladorBorrar() {
		assertEquals(modeloMock.getClass(), controladorBorrar.getModelo().getClass());
		assertEquals(vistaMock.getClass(), controladorBorrar.getVista().getClass());
		assertEquals(controladorMock.getClass(), controladorBorrar.getControlador().getClass());
		
	}
	
	@Test
	public void mostrarPanelBorrarTest() {
		doReturn(panelBorrarMock)
	    	.when(spyControladorBorrar)
	    	.makePanelBorrar(any( ControladorPanelBorrar.class)); 
		
		Modelo modelo=new Modelo();
		spyControladorBorrar = spy(new ControladorPanelBorrar(modelo, vistaMock, controladorMock)); 
		
		
		
		
		spyControladorBorrar.mostrarPanelBorrar();
		//verify(vistaMock, times(1)).mostrarPanel(panelBorrarMock);
		
	}
	
	@Test
	public void accionadoBotonCancelarPanelBorrarTest() {
		controladorBorrar = new ControladorPanelBorrar(modeloMock,
				vistaMock, controladorMock);
		
		controladorBorrar.accionadoBotonCancelarPanelBorrar();
		
		verify(controladorMock, times(1)).navegarPanelEdicion();
	}
	@Test
	public void accionadoBotonBorrarPanelBorrarTest() {
		Modelo modelo=new Modelo();
		controladorBorrar = new ControladorPanelBorrar(modelo,
				vistaMock, controladorMock);
		
		String[] pelisSeleccionadas=new String[3];
		pelisSeleccionadas[0]="Handia";
		pelisSeleccionadas[0]="Cadena perpetua";
		pelisSeleccionadas[0]="Scary movie";
		
		
		controladorBorrar.accionadoBotonBorrarPanelBorrar(pelisSeleccionadas);;
		
		verify(controladorMock, times(1)).navegarPanelEdicion();
	}

}
