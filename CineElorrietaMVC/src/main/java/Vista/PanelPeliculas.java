package Vista;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import Controlador.Controlador;
import Controlador.ControladorPanelPeliculas;
import Modelo.Pelicula;
import java.awt.event.ActionListener;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class PanelPeliculas extends JPanel {
	private JButton btnAnadirPelicula;
	private JLabel lblGenero;
	private JScrollPane scrollPane;
	private JList lista_pelis;
	private JPanel txtGenero;
	DefaultListModel modelo;
	private ControladorPanelPeliculas controladorPanelPeliculas;
	
	/**
	 * Create the panel.
	 */
	public PanelPeliculas(ControladorPanelPeliculas controladorPanelPeliculas, String seleccion) {
		this.controladorPanelPeliculas=controladorPanelPeliculas;
		setLayout(null);
		
		
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
		
		
		System.out.println("seleccion>> "+seleccion);
		lista_pelis.setModel(controladorPanelPeliculas.getModelo().getModeloPeliculas().listaPorGenero(seleccion));
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelPeliculas.accionadoBotonVolverPanelPeliculas();
			}
		});
		btnVolver.setBounds(308, 314, 89, 23);
		add(btnVolver);
		
		btnAnadirPelicula = new JButton("A\u00F1adir Pelicula");
		btnAnadirPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lista_pelis.getSelectedValue()==null) {
					
					System.out.println("No has seleccionado ninguna pelicula");
					
				}
				else controladorPanelPeliculas.accionadoBotonAnadirPanelPeliculas(lista_pelis.getSelectedValue().toString());
			}
		});
		btnAnadirPelicula.setBounds(47, 314, 168, 23);
		add(btnAnadirPelicula);

	}
	
	
	public void alertaNoMasPelis() {
		JOptionPane pane = new JOptionPane("No se puede introducir la pelicula, porque no hay tiempo \n"
				+ "(Esta ventana se cerrará automáticamente en 10 segundos)", JOptionPane.INFORMATION_MESSAGE);
		JDialog dialog = pane.createDialog("Sin tiempo disponible");
	    dialog.addWindowListener(null);
	    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	    dialog.setVisible(true); 
	    controladorPanelPeliculas.getModelo().getModeloGeneral().esperar(10000);
           
                dialog.setVisible(false);
                dialog.dispose();
	}


	public  JList getLista_pelis() {
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
