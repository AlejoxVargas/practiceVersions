package Bytes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Bytes_Lectura {
	public static void main(String[] args) {
		FileInputStream fis;
		
		int contador = 0;
		int[] datos = new int[3268348];
		
		try {
			fis = new FileInputStream("C:\\Users\\ALUMNO CCC - TARDE\\Pictures\\Saved Pictures\\wallpaper.jpg");

			boolean finaliza = false;
			while (!finaliza) {
				int byteEntrada = fis.read();
				if (byteEntrada == -1) {
					finaliza = true;
				} else {
					datos[contador] = byteEntrada;
				}
				// System.out.println(byteEntrada);
				contador++;
			}
			fis.close();
			// System.out.println("Contador: " + contador);
		} catch (Exception e) {
			e.printStackTrace();
		}
		crea_fichero(datos);
	}

	static void crea_fichero(int[] datos) {
		File fo = new File("C:\\Users\\ALUMNO CCC - TARDE\\Pictures\\Saved Pictures\\wallpaper2.jpg");
		try {
			FileOutputStream fichero = new FileOutputStream(fo);
			for (int i = 0; i < datos.length; i++) {
				fichero.write(datos[i]);
			}
			fichero.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
