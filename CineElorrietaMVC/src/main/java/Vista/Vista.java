package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Vista extends JFrame{

	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 500, 500);
	}
	
	public void mostrarPanel(JPanel panel) {
		this.setContentPane(panel);
		this.setVisible(true);
	}
	
}
