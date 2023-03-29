package escribir;

import java.io.FileWriter;
import java.io.IOException;

public class EscribirFichero {

	public static void main(String[] args) {
		Escribir escribe = new Escribir();
		escribe.escribir();
	}

	static class Escribir {
		public void escribir() {
			String frase = "Ahora estoy escribiendo...";
			try {
				FileWriter escribir = new FileWriter(
						"C:\\Users\\ALUMNO CCC - TARDE\\Desktop\\Ficheros\\EscribirFichero.txt");
				for (int i = 0; i < frase.length(); i++) {
					escribir.write(frase.charAt(i));
				}
				escribir.close();
			} catch (IOException e) {
				// e.printStackTrace();
				System.out.println("No se ha encontrado el fichero");
			}
		}
	}
}
