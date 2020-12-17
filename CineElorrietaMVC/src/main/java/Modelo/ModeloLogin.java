package Modelo;

public class ModeloLogin {
private Modelo modelo;
private final String usuario="usuario";
private final String contrasena="12345";
private Usuario usuarioAcceso=new Usuario(usuario,contrasena);

	
	public ModeloLogin(Modelo modelo) {
		this.modelo=modelo;
		
	}
	
	
	public Modelo getModelo() {
		return modelo;
	}


	public boolean comprobarUsuario(String usuarioIntroduccido, String passIntroducido) {
		System.out.println("Comprobando usuario");
		boolean correcto=false;
		
		if(usuarioIntroduccido.equals(usuarioAcceso.getNombre()) && passIntroducido.equals(usuarioAcceso.getPswd())) {		
			System.out.println("Usuario/Contraseña correctos");
			correcto=true;
			
		}
		else {
			System.out.println("Usuario/contraseña incorrectos");
			correcto=false;
			
		}
		
		return correcto;
		
	}
	

}
