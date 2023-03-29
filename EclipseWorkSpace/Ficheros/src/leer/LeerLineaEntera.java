package leer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerLineaEntera {
	public static void main(String[] args) {
		LeerFichero Leyendo = new LeerFichero();
		Leyendo.lee();
	}

	static class LeerFichero {
		public void lee() {
			try {
				FileReader entrada = new FileReader("C:\\Users\\ALUMNO CCC - TARDE\\Desktop\\Ficheros\\f1.txt");
				BufferedReader mibuffer = new BufferedReader(entrada);
				String linea = "";
				while (linea != null) {
					linea = mibuffer.readLine();
					if (linea != null) {
						System.out.println(linea);
					}
				}
				entrada.close();
			} catch (IOException e) {
				// e.printStackTrace();
				System.out.println("No se ha encontrado el fichero");
			}
		}
	}
}
