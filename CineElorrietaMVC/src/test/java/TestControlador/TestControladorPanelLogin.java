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

	private ControladorPanelLogin controladorLogin;
	private ControladorPanelGeneros controladorGeneros;
	private Modelo modeloMock = mock(Modelo.class);
	private Vista vistaMock = mock(Vista.class);
	private Controlador controladorMock = mock(Controlador.class);
	private PanelLogin panelLoginMock = mock(PanelLogin.class);
	
	private PanelGeneros panelGeneroMock = mock(PanelGeneros.class);
	private ControladorPanelLogin spyControladorLogin = spy(new ControladorPanelLogin(modeloMock, vistaMock, controladorMock)); 
	private String usuario="user";
	private String pswd="contrasena";
	@Test
	public void mostrarPanelLoginTest() {
		doReturn(panelLoginMock)
	    	.when(spyControladorLogin)
	    	.makePanelLogin(any( ControladorPanelLogin.class)); 
		
		spyControladorLogin.mostrarPanelLogin();
		verify(vistaMock, times(1)).mostrarPanel(panelLoginMock);
	}
	

	public void accionadoBotonEntrarPanelLoginTrue(String user,String contrasena) {	
	//NO LO TESTEA ¿¿COMO HACER??
		
	/*controladorLogin = new ControladorPanelLogin(modeloMock,
				vistaMock, controladorMock);
		
		doReturn(panelGeneroMock)
    	.when(user.equals(this.usuario)&&(contrasena.equals(this.pswd)))
    	.navegarPanelGeneros(any(PanelGeneros.class)); 
			
	}	*/
		controladorLogin = new ControladorPanelLogin(modeloMock,
				vistaMock, controladorMock);
		
		controladorLogin.accionadoBotonEntrarPanelLogin(usuario,pswd);
		if(user.equals(this.usuario)&&(contrasena.equals(this.pswd))) {
		verify(controladorMock, times(1)).navegarPanelGeneros();
		}
	}
	
	
	
}

