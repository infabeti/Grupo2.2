package TestModelo;

import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.Usuario;

public class TestUsuario {
	
	private String nombre="usuario";
	private String pswd="12345";
	
	private Usuario user_vacio= new Usuario();
	private Usuario user= new Usuario(nombre,pswd);


	@Test
	public void testUsuario() {
		assertEquals("usuario",user.getNombre());
		assertEquals("12345",user.getPswd());
	}
	@Test
	public void testSetNombre() {
		user.setNombre("usuario");
		assertEquals(user.getNombre(),"usuario");
	}
	@Test
	public void testSetPswd() {
		user.setPswd("12345");
		assertEquals(user.getPswd(),"12345");
	}
	
	

}
