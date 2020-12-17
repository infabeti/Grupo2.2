package Modelo;

import java.awt.Component;

public class Pelicula {

	private int genero;
	private String titulo;
	private double duracion;


	public Pelicula(int genero, String titulo, double duracion) {
		super();
		this.genero = genero;
		this.titulo = titulo;
		this.duracion = duracion;
	}

	public int getGenero() {
		return genero;
	}

	public void setGenero(int genero) {
		this.genero = genero;
	}
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	
}