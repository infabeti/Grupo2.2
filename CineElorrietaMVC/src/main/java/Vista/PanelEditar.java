package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controlador.Controlador;
import Controlador.ControladorPanelGeneros;
import Modelo.Pelicula;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.Font;

@SuppressWarnings("serial")
public class PanelEditar extends JPanel {

	private JButton btnVolver;
	private ControladorPanelGeneros controladorPanelGeneros;
	String resultado="";
	static String seleccion;
	//private Pelicula[] peliculas=Controlador.getPeliculas();
	public PanelEditar(ControladorPanelGeneros controladorPanelGeneros) {

		// ARRAYLIST PARA PARA PELIS SELECCIONADAS
		ArrayList <Pelicula> pelis_seleccion = new ArrayList<>();

		this.controladorPanelGeneros = controladorPanelGeneros;

		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(115, 72, 270, 271);
		add(scrollPane);
		
		JList lista_pelis = new JList();
		lista_pelis.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(lista_pelis);
		
		DefaultListModel modelo = new DefaultListModel();//necesario crear un modelo con el que llenar el jlist
		JButton btnAnadir = new JButton("Seleccionar");
		btnAnadir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAnadir.setEnabled(false);
		
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorPanelGeneros.accionadoBotonSeleccionarPanelGeneros(Integer.parseInt(seleccion));
				
				
			}
		});
	
		JLabel lblPelis = new JLabel("Peliculas");
		lblPelis.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPelis.setBounds(214, 47, 72, 14);
		add(lblPelis);

		

		btnAnadir.setBounds(271, 372, 168, 23);
		add(btnAnadir);

		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVolver.setBounds(59, 372, 143, 23);
		add(btnVolver);
		
		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEditar.setBounds(214, 11, 72, 14);
		add(lblEditar);


		initializeEvents();

	}

	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelGeneros));
	}

	private ActionListener listenerBotonVolver(ControladorPanelGeneros controladorPanelGeneros) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				controladorPanelGeneros.accionadoBottonVolverPanelGeneros();
			}
		};
	}


	public static String getSeleccion() {
		return seleccion;
	}

	public static void setSeleccion(String seleccion) {
		PanelEditar.seleccion = seleccion;
	}
}

