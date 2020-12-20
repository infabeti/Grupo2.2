package Modelo;

public class ModeloGestion {
	
private Modelo modelo;
private Pelicula[] auxiliar;

	public ModeloGestion(Modelo modelo) {
		this.modelo=modelo;
		actualizarAuxiliar();
		
	}
	
	
	public Modelo getModelo() {
		return modelo;
	}
	
	
	public Pelicula[] getAuxiliar() {
		return auxiliar;
	}


	public void actualizarPeliculas() {
		modelo.getModeloPeliculas().setPeliculas(auxiliar);			
	}
	
	public void actualizarAuxiliar() {
		auxiliar = 	modelo.getModeloPeliculas().getPeliculas();			
	}
	
	public boolean encontrarPelicula(String pelicula) {
		
		boolean encontrado=false;
		
		for(int i=0;i<auxiliar.length;i++) {			
			if(auxiliar[i].getTitulo().equals(pelicula)) {
				encontrado=true;
			}		
		}
		
		if(encontrado==true) {
			return encontrado;
		}else {
			return encontrado;
		}
		
				
	}
	/**
	 * 
	 * @param pelicula Pelicula de la que queremos todos los datos
	 * @return objeto Pelicula con los datos buscados
	 */
	public Pelicula buscarPelicula(String pelicula) {
		System.out.println("buscando pelicula-> "+pelicula);
		Pelicula peliElegida = new Pelicula(3,"Fallo al introducir",0);

			for(int i=0;i<auxiliar.length;i++) {			
				if(auxiliar[i].getTitulo().equals(pelicula)) {
					peliElegida=new Pelicula(auxiliar[i].getGenero(),auxiliar[i].getTitulo(),auxiliar[i].getDuracion());
					
				}		
			}
			
		
		return peliElegida;
		
		
	}
	
	public boolean borrarPelicula(String pelicula) {
		
		Pelicula[] auxiliarBorrar=auxiliar;
		int posicionBorrar=0;
		
		if(encontrarPelicula(pelicula)==true) {
			
			//Recorremos el array para encontrar la posicion para borrar
			for(int i=0;i<auxiliarBorrar.length;i++) {
				
				if(auxiliarBorrar[i].getTitulo().equals(pelicula)) {
					posicionBorrar=i;	
					System.out.println("Pelicula borrada-> "+auxiliarBorrar[i].getTitulo());
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
			this.modelo.getModeloMovimientos().anadirMovimiento("Borrar", pelicula);
				
			return true;
		}else {
			return false;
		}
				
	}	
	
	public boolean meterPelicula(int genero, String pelicula,double tiempo) {
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
			this.modelo.getModeloMovimientos().anadirMovimiento("Añadir", pelicula);
					
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean borrarLista(String[] listaPeliculas) {
		
		//Miramos que el array no esté vacío
		if(listaPeliculas.length>0) {
			
			//Recorremos el array y llamamos a el metodo de borrar con cada pelicula
			for(int i=0;i<listaPeliculas.length;i++) {		
				borrarPelicula(listaPeliculas[i]);
			}
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean editarPelicula(String pelicula, int genero, String tituloNuevo, double duracion) {
		int posicionEditar=0;
		Pelicula[] auxiliarEditar=auxiliar;
		
		if(encontrarPelicula(pelicula)==true) {
			
			//Encontrar la posicion del que quedemos editar
			for(int i=0;i<auxiliarEditar.length;i++) {	
				
				if(auxiliarEditar[i].getTitulo().equals(pelicula)) {
					posicionEditar=i;			
				}			
			}
			
			
			//Editamos en la posicion
			auxiliarEditar[posicionEditar].setGenero(genero);
			auxiliarEditar[posicionEditar].setTitulo(tituloNuevo);
			auxiliarEditar[posicionEditar].setDuracion(duracion);
			
			auxiliar=auxiliarEditar;
			this.modelo.getModeloMovimientos().anadirMovimiento("Editar", pelicula);
			return true;
		}else {
			return false;
		}
	}

}
