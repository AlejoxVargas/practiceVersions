package leer;

import java.io.FileReader;
import java.io.IOException;

public class AccesoFichero {

	public static void main(String[] args) {
		LeerFichero Leyendo = new LeerFichero();
		Leyendo.lee();

	}

	static class LeerFichero {
		public void lee() {
			try {
				FileReader entrada = new FileReader("C:\\Users\\ALUMNO CCC - TARDE\\Desktop\\Ficheros\\f1.txt");
				int c;
				do {
					c = entrada.read();
					if (c != -1) {
						System.out.print((char) c);
					}
				} while (c != -1);
				entrada.close();
			} catch (IOException e) {
				// e.printStackTrace();
				System.out.println("No se ha encontrado el fichero");
			}
		}
	}
}
