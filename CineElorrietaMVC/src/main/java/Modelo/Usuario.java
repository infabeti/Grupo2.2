package Modelo;

public class Usuario {

	String nombre;
	String pswd;
	
	public Usuario() {
		
	}
	

	public Usuario(String nombre, String pswd) {
		super();
		this.nombre = nombre;
		this.pswd = pswd;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	
	
}
