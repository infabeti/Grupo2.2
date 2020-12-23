package TestModelo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import Modelo.Modelo;
import Modelo.ModeloMovimientos;


public class ModeloMovimientosTest {
	private Modelo modeloMock=mock(Modelo.class);
	private Modelo modelo=new Modelo();
	private ModeloMovimientos modeloGestion=new ModeloMovimientos(modeloMock);
	
	
	@Test
	public void testConstructorModeloGestion() {
		
		
		assertEquals(modeloMock.getClass(), modeloGestion.getModelo().getClass());
	}
	
	@Test
	public void anadirMovimientoTest() {
		
		modeloGestion.anadirMovimiento("Prueba", "PeliPrueba");
		
		String resultadoEsperado="Prueba -> PeliPrueba\n";
		
		assertEquals(resultadoEsperado, modeloGestion.getResumenMovimientos());
	}
	
	

}
