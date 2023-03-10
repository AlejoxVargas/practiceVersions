package exepciones;

import javax.swing.JOptionPane;

public class CompruebaCorreo {

	public static void main(String[] args) {
		String miCorreo = JOptionPane.showInputDialog("Introducir correo-e: ");
		try {			
			examinaCorreo (miCorreo);
		}catch (longitudMailErrorLevel e) {
			System.out.println("Correo incorrecto");
			e.printStackTrace();
		}
	}
	
	static void examinaCorreo (String mail) throws longitudMailErrorLevel {
		int arroba = 0;
		boolean punto = false;
		if(mail.length() <= 3) {
//			ArrayIndexOutOfBoundsException miExcepcion = new ArrayIndexOutOfBoundsException();
//			throw miExcepcion;
			throw new longitudMailErrorLevel("El correo no puede tener menos de 3 caracteres");
		}
		for (int i = 0; i < mail.length(); i++) {
			if (mail.charAt(i) == '@') {
				arroba++;
			}
			if(mail.charAt(i) == '.') {
				punto = true;
			}
			if (arroba ==1 && punto == true) {
				System.out.println("Correo correcto");
			}else {
				System.out.println("Correo incorrecto");
			}
		}
	}

}
