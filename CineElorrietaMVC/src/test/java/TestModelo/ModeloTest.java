package TestModelo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import Controlador.Controlador;
import Controlador.ControladorPanelPeliculas;
import Modelo.Modelo;
import Modelo.ModeloCartelera;
import Modelo.ModeloGeneral;
import Modelo.ModeloLogin;
import Modelo.ModeloPeliculas;
import Modelo.Pelicula;
import Vista.Vista;

public class ModeloTest {
	private Modelo modelo=new Modelo();

	
	@Test
	public void testConstructorModelo() {
		
		assertEquals(ModeloGeneral.class, modelo.getModeloGeneral().getClass());
		assertEquals(ModeloPeliculas.class, modelo.getModeloPeliculas().getClass());
		assertEquals(ModeloCartelera.class, modelo.getModeloCartelera().getClass());
		assertEquals(ModeloLogin.class, modelo.getModeloLogin().getClass());
		
	}
	
	
		 
	 
	 

	 

	 
	



	 

}
