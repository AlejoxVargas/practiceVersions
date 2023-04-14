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
			String frase = "Ahora estoy escribiendo";
			try {
				FileWriter escribir = new FileWriter("C:\\Users\\ALUMNO CCC - TARDE\\Desktop\\Ficheros2\\EscribirFichero.txt", true); //el true añade en un texto
				BufferedWriter mibuffer = new BufferedWriter(escribir);
				
				mibuffer.write(frase);
				mibuffer.newLine();
				mibuffer.append('#');
				
				mibuffer.close();
				escribir.close();
				
			} catch (IOException e) {
				
				System.err.println("No se ha encontrado el fichero");
			}
		}
	}
}
