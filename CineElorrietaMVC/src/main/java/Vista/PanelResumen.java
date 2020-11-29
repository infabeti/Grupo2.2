package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import Controlador.ControladorPanelLogin;
import Controlador.ControladorPanelResumen;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class PanelResumen extends JPanel {
	private static JTextArea txtResumen;

	/**
	 * Create the panel.
	 */
	public PanelResumen(ControladorPanelResumen controladorPanelResumen) {
		setLayout(null);
		
		JLabel lblResumen = new JLabel("RESUMEN:");
		lblResumen.setBounds(91, 49, 96, 14);
		add(lblResumen);
		
		txtResumen = new JTextArea();
		txtResumen.setBounds(91, 96, 302, 203);
		txtResumen.setEnabled(false);
		txtResumen.setDisabledTextColor(Color.BLACK);
		add(txtResumen);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelResumen.accionadoBotonAceptarPanelResumen();
			}
		});
		btnAceptar.setBounds(91, 353, 89, 23);
		add(btnAceptar);
		
		JButton btnRechazar = new JButton("Rechazar");
		btnRechazar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelResumen.accionadoBotonRechazarPanelResumen();
			}
		});
		btnRechazar.setBounds(304, 353, 89, 23);
		add(btnRechazar);

	}

	public static JTextArea getTxtResumen() {
		return txtResumen;
	}


	
}
