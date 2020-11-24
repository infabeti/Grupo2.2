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
		assertEquals(user.getNombre(),"usuario");
		assertEquals(user.getPswd(),"12345");
	}
	@Test
	public void setNombre() {
		user.setNombre("usuario");
		assertEquals(user.getNombre(),"usuario");
	}
	@Test
	public void sePswd() {
		user.setPswd("12345");
		assertEquals(user.getPswd(),"12345");
	}
	
	

}
