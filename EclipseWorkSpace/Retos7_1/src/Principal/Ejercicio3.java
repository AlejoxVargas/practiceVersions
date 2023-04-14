package Principal;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

import javax.xml.catalog.CatalogFeatures.Feature;

public class Ejercicio3 implements FilenameFilter {

	public static void main(String[] args) {
		EjemploFile();
	}

	static Scanner sc = new Scanner(System.in);

	public static void EjemploFile() {

		System.out.println("Introduce la ruta de un fichero: ");
		String ruta1 = sc.nextLine();

		File file1 = new File(ruta1);

		if (file1.exists()) {

			File[] directorios = file1.listFiles();
			String[] filtrar = file1.list(new Ejercicio3('h'));
			int sizeTotal = 0;

			for (File f : directorios) {
				System.out.println(f.getAbsolutePath());
				sizeTotal += directorios.length;
			}
			System.out.println("\nTamaño total: " + sizeTotal);
			System.out.println();
			for (String f : filtrar) {
				System.out.println(f);
			}
		} else {
			System.err.println("El fichero no existe.");
		}
	}

	char letra;

	@Override
	public boolean accept(File dir, String name) {
		if (name.charAt(0) == this.letra) {
			return true;
		} else {
			return false;
		}
	}

	Ejercicio3(char letra) {
		this.letra = letra;
	}
}
