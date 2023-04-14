package Principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Ejercicio1 {
	/*
	 * Hacer un programa que lea el fichero de texto, “texto.txt”, y genere otro
	 * llamado “invertido.txt”, en el que se guardarán las frases del primero pero
	 * invertidas. Mostrar en pantalla el nuevo fichero.
	 */

	public static void main(String[] args) {

		FileReader fr = null;
		BufferedReader br = null;

		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura con el metodo readLine.

			fr = new FileReader("C:\\Users\\ALUMNO CCC - TARDE\\Desktop\\texto.txt");
			br = new BufferedReader(fr);

			fw = new FileWriter("C:\\Users\\ALUMNO CCC - TARDE\\Desktop\\invertido.txt"); // true, para sobreescribir el fichero
			bw = new BufferedWriter(fw);

			String linea;
			ArrayList<Character> invertida = new ArrayList<>();

			while ((linea = br.readLine()) != null) {
				System.out.println(linea);

				for (int i = linea.length() - 1; i >= 0; i--) {
					invertida.add(linea.charAt(i));
				}
			}

			System.out.println(invertida.toString());
			// bw.newLine(); //salto de linea para sobreescribir
			bw.write(invertida);

		} catch (IOException e) {
			System.err.println("Fichero no encontrado");

		} finally {
			try {
				// En el finally cerramos el fichero, para asegurarnos
				// que se cierra tanto si todo va bien como si salta una excepcion.
				if (null != fr && null != fw) {
					br.close();
					fr.close();
					bw.close();
					fw.close();
				}
			} catch (Exception e2) {
				System.err.println("No se ha podido cerrar");
			}
		}
	}
}
