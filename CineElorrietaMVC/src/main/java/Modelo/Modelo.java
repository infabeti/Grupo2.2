package Modelo;

import java.awt.Dialog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Controlador.Controlador;

public class Modelo {
	
	private ModeloGeneral modeloGeneral;
	private ModeloLogin modeloLogin;
	private ModeloPeliculas modeloPeliculas;
	private ModeloCartelera modeloCartelera;
	private ModeloGestion modeloGestion;
	private ModeloMovimientos modeloMovimientos;
	
	

	public Modelo() {
		this.modeloGeneral=new ModeloGeneral(this);
		this.modeloLogin=new ModeloLogin(this);
		this.modeloPeliculas=new ModeloPeliculas(this);
		this.modeloCartelera=new ModeloCartelera(this);
		this.modeloGestion=new ModeloGestion(this);
		this.modeloMovimientos=new ModeloMovimientos(this);
	
		this.modeloPeliculas.introducirPrimerasPeliculas();
		
		
	}
	


	public ModeloGeneral getModeloGeneral() {
		return modeloGeneral;
	}
	


	public ModeloLogin getModeloLogin() {
		return modeloLogin;
	}


	public ModeloPeliculas getModeloPeliculas() {
		return modeloPeliculas;
	}


	public ModeloCartelera getModeloCartelera() {
		return modeloCartelera;
	}



	public ModeloGestion getModeloGestion() {
		return modeloGestion;
	}



	public ModeloMovimientos getModeloMovimientos() {
		return modeloMovimientos;
	}





}
