package Modelo;

public class ModeloLogin {
private Modelo modelo;
private final String usuario="usuario";
private final String contrasena="12345";
private Usuario usuarioAcceso=new Usuario(usuario,contrasena);

private final String usuarioAdmin="admin";
private final String contrasenaAdmin="12345";
private Usuario usuarioAccesoAdmin=new Usuario(usuarioAdmin,contrasenaAdmin);

	
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
			System.out.println("Usuario/Contrase�a correctos");
			correcto=true;
			
		}
		else {
			System.out.println("Usuario/contrase�a incorrectos");
			correcto=false;
			
		}
		
		return correcto;
		
	}
	public boolean comprobarUsuarioAdmin(String usuarioIntroduccido, String passIntroducido) {
		System.out.println("Comprobando usuario");
		boolean correcto=false;
		
		if(usuarioIntroduccido.equals(usuarioAccesoAdmin.getNombre()) && passIntroducido.equals(usuarioAccesoAdmin.getPswd())) {		
			System.out.println("Usuario/Contrase�a correctos");
			correcto=true;
			
		}
		else {
			System.out.println("Usuario/contrase�a incorrectos");
			correcto=false;
			
		}
		
		return correcto;
		
	}
	

}
