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
import Controlador.ControladorPanelGeneros;
import Controlador.ControladorPanelLogin;
import Modelo.Modelo;
import Vista.PanelGeneros;
import Vista.PanelLogin;
import Vista.Vista;

public class TestControladorPanelLogin {

	
	
	private Modelo modeloMock = mock(Modelo.class);
	private Vista vistaMock = mock(Vista.class);
	private Controlador controladorMock = mock(Controlador.class);
	private ControladorPanelLogin controladorLogin=new ControladorPanelLogin(modeloMock, vistaMock, controladorMock);
	private PanelLogin panelLoginMock = mock(PanelLogin.class);
	
	private PanelGeneros panelGeneroMock = mock(PanelGeneros.class);

	private ControladorPanelLogin spyControladorLogin = spy(new ControladorPanelLogin(modeloMock, vistaMock, controladorMock)); 
	private String usuario="user";
	private String pswd="contrasena";
	
	@Test
	public void testContructorControladorLogin() {
		assertEquals(modeloMock.getClass(), controladorLogin.getModelo().getClass());
		assertEquals(vistaMock.getClass(), controladorLogin.getVista().getClass());
		assertEquals(controladorMock.getClass(), controladorLogin.getControlador().getClass());
	}
		
	
	
	@Test
	public void mostrarPanelLoginTest() {
		doReturn(panelLoginMock)
	    	.when(spyControladorLogin)
	    	.makePanelLogin(any( ControladorPanelLogin.class)); 
		
		spyControladorLogin.mostrarPanelLogin();
		//verify(vistaMock, times(1)).mostrarPanel(panelLoginMock);
	}
	
	@Test
	public void accionadoBotonEntrarPanelLoginTrue() {	
		Modelo modelo=new Modelo();
		controladorLogin=new ControladorPanelLogin(modelo, vistaMock, controladorMock);
		
		
		assertEquals(true,controladorLogin.accionadoBotonEntrarPanelLogin("usuario", "12345"));
		
	}
	@Test
	public void accionadoBotonEntrarPanelLoginFalse() {	
		Modelo modelo=new Modelo();
		controladorLogin=new ControladorPanelLogin(modelo, vistaMock, controladorMock);
		assertEquals(false,controladorLogin.accionadoBotonEntrarPanelLogin("usuariofalso", "12345"));

	}
	
	
	
}

