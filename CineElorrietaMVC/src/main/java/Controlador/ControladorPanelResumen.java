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
		
		
		panelResumen.getTxtResumen().append("Sábado: \n");
		
		for(int i=0;i<modelo.getPeliculasSabado().size();i++) {
			
			
			
			horas=(int) Math.floor((modelo.getPeliculasSabado().get(i).getDuracion())/60);
			minutos=(int) Math.round((modelo.getPeliculasSabado().get(i).getDuracion())%60);
			
			panelResumen.getTxtResumen().append(modelo.getPeliculasSabado().get(i).getTitulo()+"-> "+
					horas+"h "+minutos+"m \n");
			
			
		}
		
		panelResumen.getTxtResumen().append("\nDomingo: \n");
		
		for(int i=0;i<modelo.getPeliculasDomingo().size();i++) {
			horas=(int) Math.floor((modelo.getPeliculasDomingo().get(i).getDuracion())/60);
			minutos=(int) Math.round((modelo.getPeliculasDomingo().get(i).getDuracion())%60);
			
			
			panelResumen.getTxtResumen().append(modelo.getPeliculasDomingo().get(i).getTitulo()+"-> "+
					horas+"h "+minutos+"m \n");
			
			
		}
		
	}
	
	public void accionadoBotonRechazarPanelResumen() {
		controlador.navegarPanelGeneros();
		modelo.getPeliculasSabado().removeAll(modelo.getPeliculasSabado());
		modelo.getPeliculasDomingo().removeAll(modelo.getPeliculasDomingo());
		
	}
	
	public void accionadoBotonAceptarPanelResumen() {
		controlador.navegarPanelFin();
		
		
	}
	
	public PanelResumen makePanelResumen(ControladorPanelResumen controladorResumen) {
		return new PanelResumen(controladorResumen);
	}
	
	
	

}
