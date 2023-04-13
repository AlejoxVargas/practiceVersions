package Principal;

import java.io.File;
import java.util.Scanner;

public class Ejercicio1 {
	public static void main(String[] args) {
		EjemploFile();
	}

	static Scanner sc = new Scanner(System.in);

	public static void EjemploFile() {

		System.out.println("Introduce el nombre de un fichero: ");
		String directorio = sc.nextLine();

		File file1 = new File(directorio);

		File[] ficheros;

		if (file1.isDirectory()) {
			ficheros = file1.listFiles();
			for (File f : ficheros) {
				System.out.println(f.getAbsolutePath());
			}

		} else if (file1.isFile()) {
			System.out.println("La longitud del fichero es de " + file1.length());

			System.out.println("Nombre nuevo: ");
			String renombrar = sc.nextLine();

			File file2 = new File(renombrar);

			if (file1.renameTo(file2)) {
				System.out.println("Se ha renombrado");
				System.out.println(file2.getAbsolutePath());
			} else {
				System.out.println("No se ha renombrado");
			}

		} else {
			System.out.println("El fichero no existe.");
		}
	}
}
