package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controlador.ControladorPanelBienvenida;

import java.awt.Dimension;
import java.awt.Font;

@SuppressWarnings("serial")
public class PanelBienvenida extends JPanel{
	private JLabel lblBienvenida;
	private ControladorPanelBienvenida controladorPanelBienvenida;
	
	public PanelBienvenida(ControladorPanelBienvenida controladorPanelBienvenida) {
		this.controladorPanelBienvenida = controladorPanelBienvenida;
		
		setLayout(null);
		
		lblBienvenida = new JLabel("\u00A1Bienvenid@!");
		lblBienvenida.setFont(new Font("Impact", Font.PLAIN, 56));
		lblBienvenida.setBounds(96, 152, 331, 136);
		add(lblBienvenida);
		
		initializeEvents();
	}
	
	private void initializeEvents() {
	}
	
	
}


