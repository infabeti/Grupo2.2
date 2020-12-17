package Vista;

import javax.swing.JPanel;

import Controlador.ControladorPanelLogin;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class PanelLogin extends JPanel {
	private JTextField txtUsuario;
	private JPasswordField passContrasena;
	private JLabel lblError;
	private JLabel lblLogin;

	/**
	 * Create the panel.
	 */
	public PanelLogin(ControladorPanelLogin controladorPanelLogin) {
		
		setLayout(null);
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a:");
		lblContrasena.setBounds(142, 233, 89, 14);
		add(lblContrasena);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(142, 202, 70, 14);
		add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(252, 199, 86, 20);
		add(txtUsuario);
		txtUsuario.setColumns(10);
		
		passContrasena = new JPasswordField();
		passContrasena.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				  if (e.getKeyCode()==KeyEvent.VK_ENTER){
			    	   controladorPanelLogin.accionadoBotonEntrarPanelLogin(txtUsuario.getText()
								, String.valueOf(getPassContrasena().getPassword()));
			       }
			}
		});
		passContrasena.setBounds(252, 230, 121, 20);
		add(passContrasena);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!controladorPanelLogin.accionadoBotonEntrarPanelLogin(txtUsuario.getText()
						, String.valueOf(getPassContrasena().getPassword()))) {
					mostrarError();
				}
				
				
			}
		});
		btnEntrar.setBounds(198, 327, 89, 23);
		add(btnEntrar);
		
		lblError = new JLabel("usuario/contrase\u00F1a incorrectos");
		lblError.setForeground(Color.RED);
		lblError.setBounds(164, 283, 272, 14);
		add(lblError);
		
		lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblLogin.setBounds(198, 112, 141, 55);
		add(lblLogin);
		lblError.setVisible(false);
	

	}

	public void mostrarError() {
		lblError.setVisible(true);
	}

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public JPasswordField getPassContrasena() {
		return passContrasena;
	}

	public void setPassContrasena(JPasswordField passContrasena) {
		this.passContrasena = passContrasena;
	}

}
