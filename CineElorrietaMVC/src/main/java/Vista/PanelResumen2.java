package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import Controlador.ControladorPanelLogin;
import Controlador.ControladorPanelResumen;
import Controlador.ControladorResumen2;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class PanelResumen2 extends JPanel {
	private static JTextArea txtResumen2;
	private ControladorResumen2 controladorResumen2;

	/**
	 * Create the panel.
	 */
	public PanelResumen2(ControladorResumen2 controladorResumen2) {
		this.controladorResumen2=controladorResumen2;
		setLayout(null);
		
		JLabel lblResumen2 = new JLabel("RESUMEN:");
		lblResumen2.setBounds(75, 29, 97, 25);
		lblResumen2.setFont(new Font("Impact", Font.PLAIN, 20));
		add(lblResumen2);
		
		txtResumen2 = new JTextArea();
		txtResumen2.setBounds(75, 63, 297, 192);
		txtResumen2.setEnabled(false);
		txtResumen2.setDisabledTextColor(Color.BLACK);
		txtResumen2.setText(this.controladorResumen2.getModelo().getModeloMovimientos().getResumenMovimientos());
		add(txtResumen2);

		
		JButton botoncancelar = new JButton("Cancelar");
		botoncancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorResumen2.accionadoBotonCancelarPanelResumen2();
			}
		});
		botoncancelar.setBounds(36, 278, 102, 31);
		add(botoncancelar);
		
		JButton botonaceptar = new JButton("Aceptar");
		botonaceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorResumen2.accionadoBotonAceptarPanelResumen2();
			}
		});
		botonaceptar.setBounds(313, 278, 102, 31);
		add(botonaceptar);

	}

	public static JTextArea getTxtResumen() {
		return txtResumen2;
	}
}