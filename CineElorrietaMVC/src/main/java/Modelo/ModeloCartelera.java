package Modelo;

import java.awt.Dialog;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import Controlador.Controlador;

public class ModeloCartelera {
private Modelo modelo;
//Estos dos arrays tendran almacenadas las peliculas que selecciona el usuario
private ArrayList<Pelicula> peliculasSabado;
private ArrayList<Pelicula> peliculasDomingo;
	
	public ModeloCartelera(Modelo modelo) {
		this.modelo=modelo;
		this.peliculasSabado=new ArrayList <Pelicula>();
		this.peliculasDomingo=new ArrayList <Pelicula>();
		
	}
	
	
	public Modelo getModelo() {
		return modelo;
	}


	public  ArrayList<Pelicula> getPeliculasSabado() {
		return peliculasSabado;
	}
	
	

	

	public ArrayList<Pelicula> getPeliculasDomingo() {
		return peliculasDomingo;
	}


	/**
	 * 
	 * @param lista_pelis
	 */
	
	public void introducirPeliculaSeleccionada(String peliSeleccionada, Controlador controlador){


        String titulo;

        for(int i=0;i<this.modelo.getModeloPeliculas().getPeliculas().length;i++) {
            titulo=this.modelo.getModeloPeliculas().getPeliculas()[i].getTitulo();


            if(titulo.toString().trim().equals(peliSeleccionada.trim())) {


                //Para que se pueda añadir una pelicula tiene que sumar menos de 8horas el sabado completo (480minutos)
                if((this.modelo.getModeloPeliculas().getPeliculas()[i].getDuracion()+this.modelo.getModeloGeneral().minutosTotales(this.peliculasSabado))<480){
                    getPeliculasSabado().add(this.modelo.getModeloPeliculas().getPeliculas()[i]);
                    controlador.navegarPanelGeneros();
                    System.out.println("Peliculas Sabado-> "+getPeliculasSabado().size());
                    System.out.println("Minutos-> "+this.modelo.getModeloGeneral().minutosTotales(this.peliculasSabado));


                }
                else if((this.modelo.getModeloPeliculas().getPeliculas()[i].getDuracion()+this.modelo.getModeloGeneral().minutosTotales(this.peliculasDomingo))<360){
                    getPeliculasDomingo().add(this.modelo.getModeloPeliculas().getPeliculas()[i]);
                    controlador.navegarPanelGeneros();
                    System.out.println("Peliculas Domingo-> "+getPeliculasDomingo().size());
                    System.out.println("Minutos-> "+this.modelo.getModeloGeneral().minutosTotales(this.peliculasDomingo));

                }
					else {
						JOptionPane pane = new JOptionPane("No se puede introducir la pelicula, porque no hay tiempo \n"
								+ "(Esta ventana se cerrará automáticamente en 10 segundos)", JOptionPane.INFORMATION_MESSAGE);
						JDialog dialog = pane.createDialog("Sin tiempo disponible");
					    dialog.addWindowListener(null);
					    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					    dialog.setModalityType(Dialog.ModalityType.MODELESS);
					    dialog.setVisible(true); 
					    this.modelo.getModeloGeneral().esperar(10000);
				           
				                dialog.setVisible(false);
				                dialog.dispose();
 
					    
						//JOptionPane.showMessageDialog(null, "No se puede introducir la pelicula, porque no hay tiempo");
						controlador.navegarPanelResumen();
					}
					
					
				}
				
			}
			
		
	}

	
	public void limpiarDias() {
		
		if(peliculasSabado.size()!=0) {
			getPeliculasSabado().removeAll(peliculasSabado);
		}
		
		if(peliculasDomingo.size()!=0) {
			getPeliculasDomingo().removeAll(peliculasDomingo);
		}
	}

	
	/**
	 * Metodo para escribir en el panel de Resumen el texto con la lista de peliculas
	 * @return un string con saltos de linea incluidos del resumen
	 */
	public String resumenEscrito() {
		String resultadoFinal="";
		int horas,minutos;
		
		
		resultadoFinal=resultadoFinal+"Sábado: \n";
		
		for(int i=0;i<getPeliculasSabado().size();i++) {
			
			
			
			horas=(int) Math.floor((getPeliculasSabado().get(i).getDuracion())/60);
			minutos=(int) Math.round((getPeliculasSabado().get(i).getDuracion())%60);
			
			resultadoFinal=resultadoFinal+getPeliculasSabado().get(i).getTitulo()+"-> "+
					horas+"h "+minutos+"m \n";
			
			
		}
		
		resultadoFinal=resultadoFinal+"\nDomingo: \n";
		
		for(int i=0;i<getPeliculasDomingo().size();i++) {
			horas=(int) Math.floor((getPeliculasDomingo().get(i).getDuracion())/60);
			minutos=(int) Math.round((getPeliculasDomingo().get(i).getDuracion())%60);
			
			
			resultadoFinal=resultadoFinal+getPeliculasDomingo().get(i).getTitulo()+"-> "+
					horas+"h "+minutos+"m \n";
			
			
		}
		
		return resultadoFinal;
		
	}
	
	
	

}
