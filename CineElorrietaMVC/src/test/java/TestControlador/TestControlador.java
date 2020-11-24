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
import Controlador.ControladorPanelFin;
import Controlador.ControladorPanelGeneros;
import Controlador.ControladorPanelLogin;
import Controlador.ControladorPanelPeliculas;
import Controlador.ControladorPanelResumen;
import Modelo.Modelo;
import Vista.PanelGeneros;
import Vista.Vista;

public class TestControlador {
	private Controlador controlador;
	private Modelo modeloMock = mock(Modelo.class);
	private Vista vistaMock = mock(Vista.class);	
	private Controlador spyControlador;
	private Controlador controladorMock= mock(Controlador.class);
	private ControladorPanelBienvenida controladorBienvenidaMock = mock(ControladorPanelBienvenida .class); 
	private ControladorPanelLogin controladorLoginMock =mock(ControladorPanelLogin.class); 
	private ControladorPanelGeneros controladorGenerosMock = mock(ControladorPanelGeneros.class); 
	private ControladorPanelPeliculas controladorPeliculasMock = mock(ControladorPanelPeliculas .class); 
	private ControladorPanelResumen controladorResumenMock =mock(ControladorPanelResumen.class);
	private ControladorPanelFin controladorFinMock =mock(ControladorPanelFin.class);
	
	private PanelGeneros panelGeneroMock = mock(PanelGeneros.class);
	public void testNavegarPanelBienvenida() {
		this.controladorBienvenidaMock.mostrarPanelBienvenida();
	
	}
	@Test
	public void testNavegarPanelLogin() {
		controlador=new Controlador(modeloMock,vistaMock);
		
		controlador.navegarPanelLogin();
	}
	
	@Test
	public void testNavegarPanelGeneros() {
		spyControlador = spy(new Controlador(modeloMock, vistaMock)); 
		doReturn(controladorGenerosMock)
    	.when(spyControlador)
    	.makeControladorGeneros(any(Modelo.class), any(Vista.class), any(Controlador.class)); 
	
	spyControlador.navegarPanelGeneros();
	verify(spyControlador, times(1)).navegarPanelGeneros();
}//		COMO SE HACE???
		/*doReturn(panelGeneroMock)
    	.when(spyControlador)
    	.makeControladorGeneros(any(Modelo.class), any(Vista.class), any(Controlador.class)); 
	
		spyControlador.navegarPanelGeneros();
		verify(vistaMock, times(1)).mostrarPanel(panelGeneroMock);
	}
	
			/*spyControlador = spy(new Controlador(modeloMock, vistaMock)); 
			doReturn(controladorGenerosMock)
			.when(spyControlador)
			.makeControladorPanelGeneros(any(Modelo.class), any(Vista.class), any(Controlador.class));
		
		
		spyControlador.navegarPanelGeneros();
		
		verify(spyControlador, times(1)).controladorProductosMostrarPanelProductos();
	}*/
	@Test
	public void testNavegarPanelPeliculas(int genero) {
		controlador=new Controlador(modeloMock,vistaMock);
		
		controlador.navegarPanelPeliculas(2);
		
	}
	@Test
	public void testNavegarPanelResumen() {
		controlador=new Controlador(modeloMock,vistaMock);
		
		controlador.navegarPanelResumen();
		
	}
	@Test
	public void navegarPanelFin() {
		controlador=new Controlador(modeloMock,vistaMock);
		
		controlador.navegarPanelFin();
		
		
	}

}
