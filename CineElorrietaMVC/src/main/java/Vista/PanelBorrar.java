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
				//Formatear el array de objetos seleccionados
				String[] pelisSeleccionadas=new String[lista_pelis.getSelectedValues().length];
				for(int i=0;i<pelisSeleccionadas.length;i++) {
					pelisSeleccionadas[i]=String.valueOf(lista_pelis.getSelectedValues()[i]).trim();
					System.out.println(String.valueOf(lista_pelis.getSelectedValues()[i]).trim());
				}
				controladorPanelBorrar.accionadoBotonBorrarPanelBorrar(pelisSeleccionadas);
				
				
			}
	
		});
		add(btnBorrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorPanelBorrar.accionadoBotonCancelarPanelBorrar();
				
			}
		});
		btnCancelar.setBounds(255, 340, 88, 23);
		add(btnCancelar);
		
    }
    

  

}