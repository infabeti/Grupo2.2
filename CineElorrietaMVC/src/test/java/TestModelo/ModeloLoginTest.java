package TestModelo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import Modelo.Modelo;
import Modelo.ModeloLogin;


public class ModeloLoginTest {

	private Modelo modeloMock=mock(Modelo.class);
	private ModeloLogin modeloLogin=new ModeloLogin(modeloMock);
	
	@Test
	public void testConstructorModeloPeliculas() {
		
		
		assertEquals(modeloMock.getClass(), modeloLogin.getModelo().getClass());
	}
	@Test
	public void comprobarUsuarioTrueTest() {
		
		assertEquals(true,modeloLogin.comprobarUsuario("usuario", "12345"));
	
	}
	
	@Test
	public void comprobarUsuarioFalseTest() {
		assertEquals(false,modeloLogin.comprobarUsuario("usuario", "contrasenamal"));
	
	}
	@Test
	public void comprobarUsuarioAdminTrueTest() {
		
		assertEquals(true,modeloLogin.comprobarUsuarioAdmin("admin", "12345"));
	
	}
	
	@Test
	public void comprobarUsuarioAdminFalseTest() {
		assertEquals(false,modeloLogin.comprobarUsuarioAdmin("admin", "contrasenamal"));
	
	}

}
