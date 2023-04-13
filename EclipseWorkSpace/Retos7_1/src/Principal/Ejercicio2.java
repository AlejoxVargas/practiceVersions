package Principal;

import java.io.File;
import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) {
		EjemploFile();
	}

	static Scanner sc = new Scanner(System.in);

	public static void EjemploFile() {
		System.out.println("Introduce la ruta de un fichero: ");
		String ruta1 = sc.nextLine();

		File file1 = new File(ruta1);

		if (file1.exists()) {
			if (file1.canRead() && file1.canWrite()) {
				System.out.println("Se puede leer y escribir");
				System.out.println(file1.length());
				if (file1.delete()) {
					System.out.println("Se ha eliminado");
				} else {
					System.out.println("No se ha eliminado");
				}
			}
		} else {
			System.err.println("El fichero no existe.");
		}

	}
}
