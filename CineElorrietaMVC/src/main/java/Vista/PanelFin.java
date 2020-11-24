package Vista;

import javax.swing.JPanel;

import Controlador.ControladorPanelFin;

import javax.swing.JLabel;
import java.awt.Font;

public class PanelFin extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelFin(ControladorPanelFin controladorPanelFin) {
		setLayout(null);
		
		JLabel lblFin = new JLabel("FIN");
		lblFin.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblFin.setBounds(163, 78, 70, 57);
		add(lblFin);

	}

}
