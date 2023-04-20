package aleatorio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ej1 {
	static RandomAccessFile fichero = null;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int num;
		try {
			fichero = new RandomAccessFile("C:\\Users\\ALUMNO CCC - TARDE\\Desktop\\1.txt", "rw");
			mostrar();
			System.out.println("Introducir un numero: ");
			num = sc.nextInt();
			fichero.seek(fichero.length());
			fichero.writeInt(num);
			mostrar();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fichero != null) {
				try {
					fichero.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void mostrar() {
		int n;
		try {
			fichero.seek(0);
			while (true) {
				n = fichero.readInt();
				System.out.println(n);
			}
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("Fin de fichero");
		}
	}
}
