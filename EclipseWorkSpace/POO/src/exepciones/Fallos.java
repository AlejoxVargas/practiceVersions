package exepciones;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Fallos {
	public static void main(String[] args) {
		int[] mi_matriz = new int[5];
		mi_matriz[0] = 10;
		mi_matriz[1] = 1;
		mi_matriz[2] = 11;
		mi_matriz[3] = 20;
		mi_matriz[4] = 40;
		// mi_matriz[5] = 10;

		for (int i = 0; i < 5; i++) {
			System.out.println("Posicion: " + i + " Indice: " + mi_matriz[i]);
		}

		String nombre = JOptionPane.showInputDialog("Introducir nombre");
		int edad = 0;
		try {
			edad = Integer.parseInt(JOptionPane.showInputDialog("Introducir edad"));		
		}catch (NumberFormatException e) {
			System.out.println("La edad debe ser un numero");
		}
		System.out.println("Nombre: " + nombre + " Edad: " + edad);
		
		Image imagen;
		
		try {
			imagen = ImageIO.read(new File ("imagen.gif"));
		} catch (IOException e) {
			System.out.println("Error al abrir el fichero");
			e.printStackTrace();
		}
		//searching about exceptions in Java
	}
}
