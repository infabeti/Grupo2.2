package TestControlador;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;

import javax.swing.JList;

import org.junit.Test;

import Controlador.Controlador;
import Controlador.ControladorPanelGeneros;
import Controlador.ControladorPanelPeliculas;
import Controlador.ControladorPanelPeliculas;
import Modelo.Modelo;
import Modelo.Pelicula;
import Vista.PanelGeneros;
import Vista.PanelPeliculas;
import Vista.Vista;

public class TestControladorPanelPeliculas {
	
	private Modelo modeloMock = mock(Modelo.class);
	private Vista vistaMock = mock(Vista.class);
	private Controlador controladorMock = mock(Controlador.class);
	private ControladorPanelPeliculas controladorPeliculas=new ControladorPanelPeliculas(modeloMock, vistaMock, controladorMock);
	private PanelPeliculas panelPeliculasMock = mock(PanelPeliculas.class);
	private PanelGeneros panelGenerosMock = mock(PanelGeneros.class);
	private ControladorPanelPeliculas spyControladorPeliculas = spy(new ControladorPanelPeliculas(modeloMock, vistaMock, controladorMock)); 
	
	private int resultado;
	private int resultadoEsperado;
	
	@Test
	public void testContructorControladorPeliculas() {
		assertEquals(modeloMock.getClass(), controladorPeliculas.getModelo().getClass());
		assertEquals(vistaMock.getClass(), controladorPeliculas.getVista().getClass());
		assertEquals(controladorMock.getClass(), controladorPeliculas.getControlador().getClass());
		
	}

	
	@Test
	public void mostrarPanelPeliculasTest() {
		doReturn(panelPeliculasMock)
	    	.when(spyControladorPeliculas)
	    	.makePanelPeliculas(any( ControladorPanelPeliculas.class),""); 
		
		//spyControladorPeliculas.mostrarPanelPeliculas(2);
		//verify(vistaMock, times(1)).mostrarPanel(panelPeliculasMock);
	}
	

	//testeo del boton que nos lleva al panel de bienvenida
	@Test
	public void accionadoBottonVolverPanelProductosTest() {
		controladorPeliculas = new ControladorPanelPeliculas(modeloMock,
				vistaMock, controladorMock);
		
		controladorPeliculas.accionadoBotonVolverPanelPeliculas();
		
		verify(controladorMock, times(1)).navegarPanelGeneros();
	

}
	
			
	
			/*
			public void testAccionadoBotonAnadirPanelPeliculas() {
				controladorPeliculas = new ControladorPanelPeliculas(modeloMock,
						vistaMock, controladorMock);
				
				
				controladorPeliculas.accionadoBotonAnadirPanelPeliculas(panelPeliculasMock.getLista_pelis());
				
				
				verify(controladorMock, times(0)).navegarPanelGeneros();
				
				
				panelGenerosMock.setSeleccion("1");
				
				
				String[] opciones= {"Handia"};
				JList nuevalista=new JList(opciones);
				
				panelPeliculasMock.setLista_pelis(nuevalista);
				panelPeliculasMock.getLista_pelis().setSelectedIndex(0);
				System.out.println(panelPeliculasMock.getLista_pelis().getSelectedIndex());
				
				controladorPeliculas.accionadoBotonAnadirPanelPeliculas(nuevalista);
				
				
				verify(controladorMock, times(1)).navegarPanelGeneros();
				
				
				
			}
			*/
			
	
	
	
	
}
