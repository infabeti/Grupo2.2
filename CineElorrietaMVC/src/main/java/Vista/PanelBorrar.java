package Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controlador.ControladorPanelBorrar;
import Modelo.Pelicula;

public class PanelBorrar extends JPanel {
   
	private JLabel lblBorrar;
	private static JList lista_pelis;
	
    public PanelBorrar(ControladorPanelBorrar controladorPanelBorrar){
        
    	setLayout(null);
    	
    	lblBorrar = new JLabel("Escoga pelicula para borrar: ");
    	lblBorrar.setBounds(101, 35, 255, 14);
		add(lblBorrar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(101, 63, 268, 237);
		add(scrollPane);
		
		JList lista_pelis = new JList();
		scrollPane.setViewportView(lista_pelis);
		
		Pelicula[] peliculas=controladorPanelBorrar.getControlador().getPeliculas();
		
		DefaultListModel modelo = new DefaultListModel();
		for(int i=0;i<peliculas.length;i++) {
			modelo.addElement(peliculas[i].getTitulo());
			
		}
		
		lista_pelis.setModel(modelo);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(125, 340, 88, 23);
		btnBorrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				
			}
	
		});
		add(btnBorrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(255, 340, 88, 23);
		add(btnCancelar);
		
    }
    

  

}