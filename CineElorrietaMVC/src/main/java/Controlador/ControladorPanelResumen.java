package Controlador;

import Modelo.Modelo;
import Vista.PanelGeneros;
import Vista.PanelLogin;
import Vista.PanelPeliculas;
import Vista.PanelResumen;
import Vista.Vista;

public class ControladorPanelResumen {
	@SuppressWarnings("unused")
	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelResumen panelResumen;
	
	public ControladorPanelResumen(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	//Muestra las peliculas del sabado y domingo con su duración
	public void mostrarPanelResumen() {
		this.panelResumen = new PanelResumen(this);
		this.vista.mostrarPanel(this.panelResumen);
		int horas,minutos;
		
		
		//txtArea.append("Goodbye Cruel World\n");
		
		panelResumen.getTxtResumen().append("Sábado: \n");
		
		for(int i=0;i<ControladorPanelPeliculas.getPeliculasSabado().size();i++) {
			
			
			
			horas=(int) Math.floor((ControladorPanelPeliculas.getPeliculasSabado().get(i).getDuracion())/60);
			minutos=(int) Math.round((ControladorPanelPeliculas.getPeliculasSabado().get(i).getDuracion())%60);
			
			panelResumen.getTxtResumen().append(ControladorPanelPeliculas.getPeliculasSabado().get(i).getTitulo()+"-> "+
					horas+"h "+minutos+"m \n");
			
			
		}
		
		panelResumen.getTxtResumen().append("\nDomingo: \n");
		
		for(int i=0;i<ControladorPanelPeliculas.getPeliculasDomingo().size();i++) {
			horas=(int) Math.floor((ControladorPanelPeliculas.getPeliculasDomingo().get(i).getDuracion())/60);
			minutos=(int) Math.round((ControladorPanelPeliculas.getPeliculasDomingo().get(i).getDuracion())%60);
			
			
			panelResumen.getTxtResumen().append(ControladorPanelPeliculas.getPeliculasDomingo().get(i).getTitulo()+"-> "+
					horas+"h "+minutos+"m \n");
			
			
		}
		
	}
	
	public void accionadoBotonRechazarPanelResumen() {
		controlador.navegarPanelGeneros();
		ControladorPanelPeliculas.getPeliculasSabado().removeAll(ControladorPanelPeliculas.getPeliculasSabado());
		ControladorPanelPeliculas.getPeliculasDomingo().removeAll(ControladorPanelPeliculas.getPeliculasDomingo());
		
	}
	
	public void accionadoBotonAceptarPanelResumen() {
		controlador.navegarPanelFin();
		
		
	}
	
	public PanelResumen makePanelResumen(ControladorPanelResumen controladorResumen) {
		return new PanelResumen(controladorResumen);
	}
	
	
	

}
