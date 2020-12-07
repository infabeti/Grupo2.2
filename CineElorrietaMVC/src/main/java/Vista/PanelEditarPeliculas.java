package Vista;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import Controlador.Controlador;
import Controlador.ControladorPanelPeliculas;
import Modelo.Pelicula;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;

public class PanelEditarPeliculas extends JPanel {
	private JButton btnConfirmarEdicion;
	private JLabel lblGenero;
	private JPanel txtTituloSeleccionado;
	DefaultListModel modelo;
	private JTextField TextFTitulo;
	private JTextField texFDuración;
	private JLabel lblEditar;
	
	/**
	 * Create the panel.
	 */
	public PanelEditarPeliculas(ControladorPanelPeliculas controladorPanelPeliculas) {
		setLayout(null);
		
		btnConfirmarEdicion = new JButton("Confirmar");
		btnConfirmarEdicion.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConfirmarEdicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		//		controladorPanelPeliculas.accionadoBotonAnadirPanelPeliculas(lista_pelis);
			}
		});
		btnConfirmarEdicion.setBounds(270, 387, 168, 23);
		add(btnConfirmarEdicion);
		
		lblGenero = new JLabel("Pel\u00EDcula Seleccionada:");
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGenero.setBounds(164, 45, 132, 23);
		add(lblGenero);
		
		txtTituloSeleccionado = new JPanel();
		txtTituloSeleccionado.setBackground(Color.WHITE);
		txtTituloSeleccionado.setBounds(108, 79, 250, 23);
		add(txtTituloSeleccionado);
		modelo = new DefaultListModel();
		
		
	//	 Pelicula[] peliculas=Controlador.getPeliculas();
		 
		 int genero=Integer.parseInt(PanelGeneros.getSeleccion());
		
		 
		 
		 
		modelo.clear();
//		for (int i = 0; i < peliculas.length; i++) {
//			if (peliculas[i].getGenero() == genero) {
//				String resultado = "";
//				System.out.println(peliculas[i].getTitulo());
//				resultado += peliculas[i].getTitulo() + "\n";
//				modelo.addElement(resultado);
//				
//				
//			}
//		}
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelPeliculas.accionadoBotonVolverPanelPeliculas();
			}
		});
		btnVolver.setBounds(66, 387, 156, 23);
		add(btnVolver);
		
		JLabel lblCambiarTitulo = new JLabel("Cambiar Titulo:");
		lblCambiarTitulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCambiarTitulo.setBounds(66, 201, 108, 23);
		add(lblCambiarTitulo);
		
		JLabel lblDuración = new JLabel("Cambiar Duraci\u00F3n:");
		lblDuración.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDuración.setBounds(66, 273, 117, 23);
		add(lblDuración);
		
		TextFTitulo = new JTextField();
		TextFTitulo.setBounds(184, 202, 244, 20);
		add(TextFTitulo);
		TextFTitulo.setColumns(10);
		
		texFDuración = new JTextField();
		texFDuración.setBounds(184, 274, 86, 20);
		add(texFDuración);
		texFDuración.setColumns(10);
		
		JComboBox comboBoxGeneros = new JComboBox();
		comboBoxGeneros.setBounds(184, 136, 108, 22);
		add(comboBoxGeneros);
		
		JLabel labCambiarGenero = new JLabel("Cambiar Genero:");
		labCambiarGenero.setFont(new Font("Tahoma", Font.BOLD, 11));
		labCambiarGenero.setBounds(66, 136, 108, 23);
		add(labCambiarGenero);
		
		lblEditar = new JLabel("EDITAR");
		lblEditar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEditar.setBounds(218, 11, 65, 14);
		add(lblEditar);

	}

//	public static JList getLista_pelis() {
//		//return lista_pelis;
//	}

	public void setLista_pelis(JList lista_pelis) {
	//	this.lista_pelis = lista_pelis;
	}

	public JPanel getTxtGenero() {
		return txtTituloSeleccionado;
	}

	public void setTxtGenero(JPanel txtGenero) {
		this.txtTituloSeleccionado = txtGenero;
	}

	public DefaultListModel getModelo() {
		return modelo;
	}

	public void setModelo(DefaultListModel modelo) {
		this.modelo = modelo;
	}
}
