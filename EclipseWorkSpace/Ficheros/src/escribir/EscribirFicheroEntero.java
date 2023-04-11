package escribir;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import escribir.EscribirFichero.Escribir;

public class EscribirFicheroEntero {
	public static void main(String[] args) {
		Escribir escribe = new Escribir();
		escribe.escribir();
	}

	static class Escribir {
		public void escribir() {
			try {
				FileWriter escribir = new FileWriter("C:\\Users\\ALUMNO CCC - TARDE\\Desktop\\Ficheros\\EscribirFichero.txt");
				BufferedWriter mibuffer = new BufferedWriter(escribir);
				String frase = "Ahora estoy escribiendo2...";
					mibuffer.write(frase);
				escribir.close();
			} catch (IOException e) {
				System.out.println("No se ha encontrado el fichero");
			}
		}
	}
}
