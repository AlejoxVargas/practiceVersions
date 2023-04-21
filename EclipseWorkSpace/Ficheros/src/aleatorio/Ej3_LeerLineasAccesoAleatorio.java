package aleatorio;

import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ej3_LeerLineasAccesoAleatorio {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		RandomAccessFile raf = null;// clase de acceso aleatorio

		String linea = null, palabra, cadena;

		StringBuilder sb;
		int indice;
		long posicion;

		try {
			raf = new RandomAccessFile("C:\\Users\\ALUMNO CCC - TARDE\\Desktop\\2.txt", "rw");
			System.out.println("Palabra a cambiar: ");
			palabra = sc.nextLine();
			posicion = raf.getFilePointer();
			linea = raf.readLine();
			while (linea != null) {
				indice = linea.indexOf(palabra);
				cadena = linea;
				while (indice != -1) {
					sb = new StringBuilder(cadena);
					sb.replace(indice, indice + palabra.length(), palabra.toUpperCase());
					cadena = sb.toString();
					raf.seek(posicion);
					// escribir un string en forma de byte
					raf.writeBytes(cadena);
					indice = cadena.indexOf(palabra);
				}
				posicion = raf.getFilePointer();
				linea = raf.readLine();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
