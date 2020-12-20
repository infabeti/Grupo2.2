package Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controlador.ControladorPanelBorrar;
import Modelo.Pelicula;

public class PanelBorrar extends JPanel {
   
	private JLabel lblBorrar;
	private static JList lista_pelis;
	private ControladorPanelBorrar controladorPanelBorrar;
	
    public PanelBorrar(ControladorPanelBorrar controladorPanelBorrar){
    	this.controladorPanelBorrar=controladorPanelBorrar;
        
    	setLayout(null);
    	
    	lblBorrar = new JLabel("Escoga pelicula para borrar: ");
    	lblBorrar.setBounds(101, 35, 255, 14);
		add(lblBorrar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(101, 63, 268, 237);
		add(scrollPane);
		
		lista_pelis = new JList();
        scrollPane.setViewportView(lista_pelis);
	
		lista_pelis.setModel(controladorPanelBorrar.getModelo().getModeloPeliculas().listaTodasPelis());
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(125, 340, 88, 23);
		btnBorrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controladorPanelBorrar.accionadoBotonBorrarPanelPeliculas(lista_pelis.getSelectedValues());
				
				
			}
	
		});
		add(btnBorrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorPanelBorrar.accionadoBotonCancelarPanelPeliculas();
				
			}
		});
		btnCancelar.setBounds(255, 340, 88, 23);
		add(btnCancelar);
		
    }
    

  

}