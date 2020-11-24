package Vista;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JScrollPane;


import Controlador.ControladorPanelPeliculas;
import Modelo.Pelicula;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class PanelPeliculas extends JPanel {
	private JButton btnAnadirPelicula;
	private JLabel lblGenero;
	private JScrollPane scrollPane;
	private static JList lista_pelis;
	private JPanel txtGenero;
	DefaultListModel modelo;
	
	/**
	 * Create the panel.
	 */
	public PanelPeliculas(ControladorPanelPeliculas controladorPanelPeliculas) {
		setLayout(null);
		
		btnAnadirPelicula = new JButton("A\u00F1adir Pelicula");
		btnAnadirPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorPanelPeliculas.accionadoBotonAnadirPanelPeliculas(lista_pelis);
			}
		});
		btnAnadirPelicula.setBounds(47, 314, 168, 23);
		add(btnAnadirPelicula);
		
		lblGenero = new JLabel("Genero Seleccionado:");
		lblGenero.setBounds(37, 45, 141, 14);
		add(lblGenero);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 114, 168, 137);
		add(scrollPane);
		
		lista_pelis = new JList();
		lista_pelis.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(lista_pelis);
		
		txtGenero = new JPanel();
		txtGenero.setBounds(221, 45, 156, 23);
		add(txtGenero);
		modelo = new DefaultListModel();
		
		
		 Pelicula[] peliculas=PanelGeneros.getPeliculas();
		 
		 int genero=Integer.parseInt(PanelGeneros.getSeleccion());
		
		 
		 
		 
		modelo.clear();
		for (int i = 0; i < peliculas.length; i++) {
			if (peliculas[i].getGenero() == genero) {
				String resultado = "";
				System.out.println(peliculas[i].getTitulo());
				resultado += peliculas[i].getTitulo() + "\n";
				modelo.addElement(resultado);
				
				
			}
		}
		
		 
		lista_pelis.setModel(modelo);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelPeliculas.accionadoBotonVolverPanelPeliculas();
			}
		});
		btnVolver.setBounds(308, 314, 89, 23);
		add(btnVolver);

	}

	public static JList getLista_pelis() {
		return lista_pelis;
	}

	public void setLista_pelis(JList lista_pelis) {
		this.lista_pelis = lista_pelis;
	}

	public JPanel getTxtGenero() {
		return txtGenero;
	}

	public void setTxtGenero(JPanel txtGenero) {
		this.txtGenero = txtGenero;
	}

	public DefaultListModel getModelo() {
		return modelo;
	}

	public void setModelo(DefaultListModel modelo) {
		this.modelo = modelo;
	}
}
