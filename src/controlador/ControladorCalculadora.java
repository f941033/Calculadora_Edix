package controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import vista.VentanaCalculadora;

public class ControladorCalculadora implements ActionListener {

	private VentanaCalculadora ventana;
	private JLabel etiquetaResultado;

	private float num1;
	private float num2;

	public void setNum1(float num1) {
		this.num1 = num1;
	}

	public void setNum2(float num2) {
		this.num2 = num2;
	}

	public float suma() {
		return num1 + num2;
	}

	public float resta() {
		return num1 - num2;
	}

	public float multiplicacion() {
		return num1 * num2;
	}

	public float division() {
		return num1 / num2;
	}

	public double raizCubica() {
		return Math.ceil(Math.cbrt(num1));
	}

	public void setVentana(VentanaCalculadora ventana) {
		this.ventana = ventana;
		etiquetaResultado = ventana.getEtiquetaResultado();
		etiquetaResultado.setForeground(Color.red);
		
	}

	private void cambiarEstilo(Color color, int tamanio, String mensaje) {
		etiquetaResultado.setForeground(color);
		etiquetaResultado.setFont(new Font("Arial", Font.BOLD, tamanio));
		etiquetaResultado.setText(mensaje);
	
	}

	private boolean comprobarCajas() {
		if (ventana.getCajaNumero1().getText().isEmpty()) {
			cambiarEstilo(Color.RED, 20, "Falta el número 1");
			return false;
		}
		if (ventana.getCajaNumero2().getText().isEmpty()) {
			cambiarEstilo(Color.RED, 20, "Falta el número 2");
			return false;
		}
		try {
			setNum1(Float.parseFloat(ventana.getCajaNumero1().getText()));
			setNum2(Float.parseFloat(ventana.getCajaNumero2().getText()));
			return true;
		} catch (Exception e) {
			cambiarEstilo(Color.RED, 20, "Números incorrectos");
			return false;
		}
	}

	private boolean comprobarCajaRaiz() {
		if (ventana.getCajaNumero1().getText().isEmpty() && ventana.getCajaNumero2().getText().isEmpty()) {
			cambiarEstilo(Color.RED, 20, "Escriba un número");
			return false;
		}

		if (!ventana.getCajaNumero1().getText().isEmpty()) {
			try {
				setNum1(Float.parseFloat(ventana.getCajaNumero1().getText()));
				return true;
			} catch (Exception e) {
				cambiarEstilo(Color.RED, 20, "Número incorrecto");
				return false;
			}
			
		} else if (!ventana.getCajaNumero2().getText().isEmpty()) {
			try {
				setNum1(Float.parseFloat(ventana.getCajaNumero2().getText()));
				return true;
			} catch (Exception e) {
				cambiarEstilo(Color.RED, 20, "Número incorrecto");
				return false;
			}
			
		} else
			return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object boton = e.getSource();

		if (boton == ventana.getBotonRaizCuadrado()) {
			JOptionPane.showMessageDialog(null, "Funcionalidad no disponible", "Raiz Cuadrada",
					JOptionPane.INFORMATION_MESSAGE);
		} else

		if (boton == ventana.getBotonRaizCubica()) {
			String pass = JOptionPane.showInputDialog("Contraseña:");
			if (pass != null) {
				if (pass.equals("123")) {
					if (comprobarCajaRaiz()) {
						cambiarEstilo(new Color(0, 255, 51), 30, String.valueOf(raizCubica()));
					}
				} else {
					cambiarEstilo(Color.RED, 20, "Contraseña incorrecta");
				}
			} else {
				cambiarEstilo(Color.RED, 14, "No se ha introducido contraseña");
			}

		} else

		if (comprobarCajas()) {
			String mensaje = "";

			if (boton == ventana.getBotonSumar()) {
				mensaje = String.valueOf(suma());
			}

			if (e.getSource() == ventana.getBotonRestar()) {
				mensaje = String.valueOf(resta());
			}

			if (e.getSource() == ventana.getBotonMultiplicar()) {
				mensaje = String.valueOf(multiplicacion());
			}

			if (e.getSource() == ventana.getBotonDividir()) {
				try {
					mensaje = String.valueOf(division());
				} catch (Exception ex) {
					cambiarEstilo(Color.RED, 20, "Error: división por cero");
				}

			}
			cambiarEstilo(new Color(0, 255, 51), 30, mensaje);
		}

	}

}
