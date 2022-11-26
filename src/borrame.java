import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class borrame {

	private JFrame frame;
	private JTextField txtUsuario;
	private JTextField txtContrasea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					borrame window = new borrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public borrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 512, 318);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(159, 182, 162, 38);
		frame.getContentPane().add(btnNewButton);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(159, 61, 162, 25);
		TextPrompt placeholder = new TextPrompt("usuario", txtUsuario); // texto del placeholder y el TextField en el que va
	    placeholder.changeAlpha(0.75f); // bajar la transparencia de la fuente (1=opaco, 0=transparente)
	    placeholder.changeStyle(Font.ITALIC); // estilo de la fuente, es opcional
	    
	    
	    
	    
		frame.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContrasea = new JTextField();
		txtContrasea.setBounds(159, 106, 162, 25);
		frame.getContentPane().add(txtContrasea);
		txtContrasea.setColumns(10);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\raque\\OneDrive\\Escritorio\\fondo.jpeg"));
		lblNewLabel.setBounds(0, 0, 500, 280);
		frame.getContentPane().add(lblNewLabel);		

	}
}
