package exepciones;

import javax.swing.JOptionPane;

public class VariasExcepciones {
	public static void main(String[] args) {
		try {
			division();
		} catch (ArithmeticException e) {
			System.out.println("Error division por 0");
		}catch (NumberFormatException e) {
			System.out.println("Hay que introducir n entero");
			System.out.println(e.getMessage());
			System.out.println("Error de tipo: " + e.getClass().getName());
		}
	}

	static void division() {
		int num1 = Integer.parseInt(JOptionPane.showInputDialog("Dividiendo"));
		int num2 = Integer.parseInt(JOptionPane.showInputDialog("Divisor"));
		System.out.println("Resultado: " + num1 / num2);
	}
}
