package Modelo;

public class ModeloGestion {
	
private Modelo modelo;
Pelicula[] auxiliar;

	public ModeloGestion(Modelo modelo) {
		this.modelo=modelo;
		
	}
	
	
	public Modelo getModelo() {
		return modelo;
	}
	
	
	public void actualizarPeliculas() {
		modelo.getModeloPeliculas().setPeliculas(auxiliar);			
	}
	
	
	public boolean encontrarPelicula(String pelicula) {
		
		boolean encontrado=false;
		
		for(int i=0;i<modelo.getModeloPeliculas().getPeliculas().length;i++) {			
			if(modelo.getModeloPeliculas().getPeliculas()[i].getTitulo().equals(pelicula)) {
				encontrado=true;
			}		
		}
		
		if(encontrado==true) {
			return encontrado;
		}else {
			return encontrado;
		}
		
				
	}
	
	public boolean borrarPelicula(String pelicula) {
		
		Pelicula[] auxiliarBorrar=auxiliar;
		int posicionBorrar=0;
		
		if(encontrarPelicula(pelicula)==true) {
			
			//Recorremos el array para encontrar la posicion para borrar
			for(int i=0;i<auxiliarBorrar.length;i++) {
				
				if(auxiliarBorrar[i].getTitulo().equals(pelicula)) {
					posicionBorrar=i;			
				}			
			}
			
			//Pasamos todas las peliculas una posicion hacia abajo desde la que ha sido borrado
			for(int i=posicionBorrar;i<auxiliarBorrar.length-1;i++) {
				auxiliarBorrar[i]=auxiliarBorrar[(i+1)];
			}
			
			//Creamos uno que será de un limite de uno menos (ya que lo queremos quitar)
			Pelicula[] auxiliarBorrarFinal = new Pelicula[auxiliarBorrar.length-1];
				for(int i=0;i<auxiliarBorrarFinal.length;i++) {
					auxiliarBorrarFinal[i]=auxiliarBorrar[i];
				}
			
			//Lo igualamos al auxiliar
			auxiliar=auxiliarBorrarFinal;
				
			return true;
		}else {
			return false;
		}
				
	}	
	
	public boolean meterPelicula(int genero, String pelicula,int tiempo) {
		Pelicula[] auxiliarMeter=new Pelicula[auxiliar.length+1];
		
		if(encontrarPelicula(pelicula)==false) {
			
			//Metemos todas las peliculas que ya estaban en el auxiliar
			for(int i=0;i<auxiliar.length;i++) {	
				auxiliarMeter[i]=auxiliar[i];
			}
			
			//Metemos la nueva al final
			auxiliarMeter[auxiliarMeter.length-1] = new Pelicula(genero, pelicula, tiempo);
			
			
			//Lo igualamos al auxiliar
			auxiliar=auxiliarMeter;
					
			return true;
		}else {
			return false;
		}
		
	}

}
