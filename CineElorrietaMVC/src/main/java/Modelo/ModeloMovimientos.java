package Modelo;

public class ModeloMovimientos {
private Modelo modelo;
private String resumenMovimientos;
	
	public ModeloMovimientos(Modelo modelo) {
		this.modelo=modelo;
		resumenMovimientos="";
		
	}
	
	
	public Modelo getModelo() {
		return modelo;
	}
	
	/**
	 * A�adir un movimiento realizado 
	 * @param tipoMov tipo de Movimiento realizado (Editar,Borrar,A�adir)
	 * @param peliMov pelicula de la que se realiza el movimiento
	 */

	public void anadirMovimiento(String tipoMov, String peliMov) {

		resumenMovimientos=resumenMovimientos+tipoMov+" -> "+peliMov+"\n";	
		
	}


	public String getResumenMovimientos() {
		return resumenMovimientos;
	}
	
}
