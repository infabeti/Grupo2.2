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
import Controlador.ControladorPanelBienvenida;
import Controlador.ControladorPanelGeneros;
import Modelo.Modelo;
import Vista.PanelBienvenida;
import Vista.PanelGeneros;
import Vista.Vista;

public class TestControladorPanelBienvenida {

	
	private Modelo modeloMock = mock(Modelo.class);
	private Vista vistaMock = mock(Vista.class);
	private Controlador controladorMock = mock(Controlador.class);
	private ControladorPanelBienvenida controladorBienve=new ControladorPanelBienvenida(modeloMock, vistaMock, controladorMock);
	private PanelBienvenida panelBienvMock = mock(PanelBienvenida.class);
	private ControladorPanelBienvenida spyControladorGeneros = spy(new ControladorPanelBienvenida(modeloMock, vistaMock, controladorMock)); 
	
	@Test
	public void testContructorControladorBienve() {
		assertEquals(modeloMock.getClass(), controladorBienve.getModelo().getClass());
		assertEquals(vistaMock.getClass(), controladorBienve.getVista().getClass());
		assertEquals(controladorMock.getClass(), controladorBienve.getControlador().getClass());
		
	}

	@Test
	public void testMostrarPanelBienvenida() {
		doReturn(panelBienvMock)
	    	.when(spyControladorGeneros)
	    	.makePanelBienv(any( ControladorPanelBienvenida.class)); 
		
		Modelo modelo=new Modelo();
		spyControladorGeneros = spy(new ControladorPanelBienvenida(modelo, vistaMock, controladorMock)); 
		
		spyControladorGeneros.mostrarPanelBienvenida();
		//verify(vistaMock, times(1)).mostrarPanel(panelBienvMock);
	}
	@Test
	public void testAccionadoBottonMostrarPanelGeneros() {
		controladorBienve = new ControladorPanelBienvenida(modeloMock,
				vistaMock, controladorMock);
		
		controladorBienve.accionadoBottonMostrarPanelGeneros();
		
		//verify(controladorMock, times(1)).navegarPanelPeliculas(1);
	}

}
