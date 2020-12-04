package Vista;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controlador.Controlador;
import Modelo.Pelicula;

public class PanelBorrar extends JFrame {
   
	private JLabel lblBorrar;
	private static JList lista_pelis;
	//private Pelicula[] peliculas=Controlador.getPeliculas();
	
    public PanelBorrar(){
        
    	setLayout(null);
    	
    	lblBorrar = new JLabel("Escoga pelicula para borrar: ");
    	lblBorrar.setBounds(101, 35, 255, 14);
		add(lblBorrar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(101, 63, 268, 237);
		add(scrollPane);
		
		JList lista_pelis = new JList();
		scrollPane.setViewportView(lista_pelis);
		
		/*Controlador.introducirPrimerasPeliculas();
		Controlador.getPeliculas();

		DefaultListModel modelo = new DefaultListModel();
		for(int i=0;i<peliculas.length;i++) {
			modelo.addElement(peliculas[i].getTitulo());
			
		}
		
		lista_pelis.setModel(modelo);
		*/
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
    
  

      public static void main(String[] ar){
       
    	   PanelBorrar panelBorrar=new PanelBorrar();
    	   panelBorrar.setBounds(500,500,500,500);
    	   panelBorrar.setLocationRelativeTo(null);
    	   panelBorrar.setVisible(true);
    	   panelBorrar.setTitle("Borrar");

      }
}