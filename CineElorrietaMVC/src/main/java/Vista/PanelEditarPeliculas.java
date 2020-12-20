package Vista;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import Controlador.Controlador;
import Controlador.ControladorPanelEditarPeliculas;
import Controlador.ControladorPanelPeliculas;
import Modelo.Pelicula;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;

public class PanelEditarPeliculas extends JPanel {
	private JButton btnConfirmarEdicion;
	private JLabel lblGenero;
	private JTextField textFTitulo;
	private JTextField texFDuracion;
	private JLabel lblEditar;
	private ControladorPanelEditarPeliculas controladorPanelEditarPeliculas;
	private JTextField txtTituloSeleccionado;
	private JComboBox comboBoxGeneros;
	
	/**
	 * Create the panel.
	 */
	public PanelEditarPeliculas(ControladorPanelEditarPeliculas controladorPanelEditarPeliculas, String pelicula) {
		this.controladorPanelEditarPeliculas=controladorPanelEditarPeliculas;
		setLayout(null);
		
		btnConfirmarEdicion = new JButton("Confirmar");
		btnConfirmarEdicion.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConfirmarEdicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorPanelEditarPeliculas.accionadoBotonConfirmarPanelEditarPeliculas(
						pelicula, comboBoxGeneros.getSelectedIndex()+1, textFTitulo.getText(), Double.parseDouble(texFDuracion.getText()));
			}
		});
		btnConfirmarEdicion.setBounds(270, 387, 168, 23);
		add(btnConfirmarEdicion);
		
		lblGenero = new JLabel("Pel\u00EDcula Seleccionada:");
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGenero.setBounds(164, 45, 132, 23);
		add(lblGenero);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelEditarPeliculas.accionadoBotonVolverPanelEditarPeliculas();
			}
		});
		btnVolver.setBounds(66, 387, 156, 23);
		add(btnVolver);
		
		JLabel lblCambiarTitulo = new JLabel("Cambiar Titulo:");
		lblCambiarTitulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCambiarTitulo.setBounds(66, 201, 108, 23);
		add(lblCambiarTitulo);
		
		JLabel lblDuración = new JLabel("Duraci\u00F3n:");
		lblDuración.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDuración.setBounds(66, 273, 117, 23);
		add(lblDuración);
		
		textFTitulo = new JTextField();
		textFTitulo.setBounds(184, 202, 244, 20);
		add(textFTitulo);
		textFTitulo.setColumns(10);
		
		texFDuracion = new JTextField();
		texFDuracion.setEditable(false);
		texFDuracion.setBounds(184, 274, 86, 20);
		add(texFDuracion);
		texFDuracion.setColumns(10);
		
		comboBoxGeneros = new JComboBox();
		comboBoxGeneros.setModel(new DefaultComboBoxModel(new String[] {"1. Drama", "2. Comedia", "3. Terror", "4. Ciencia Ficci\u00F3n"}));
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
		
		txtTituloSeleccionado = new JTextField();
		txtTituloSeleccionado.setEditable(false);
		txtTituloSeleccionado.setColumns(10);
		txtTituloSeleccionado.setBounds(106, 86, 244, 20);
		txtTituloSeleccionado.setText(pelicula);
		add(txtTituloSeleccionado);

	}
	
	public void cambiarGenero(int genero) {
		comboBoxGeneros.setSelectedIndex(genero-1);
		
	}
	public void cambiarTitulo(String titulo) {
		textFTitulo.setText(titulo);
	}
	public void cambiarDuracion(double duracion) {
		texFDuracion.setText(String.valueOf(duracion));
	}




}
