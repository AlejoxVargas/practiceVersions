package exepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EntradaDatos {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Opciones:\n1. Introducir datos\n2. Salir");
		int opcion = sc.nextInt();
		if (opcion == 1) {
			try {
				dameDatos();
			} catch (InputMismatchException e) {
				System.out.println("Se debe introducir con coma");
			}
		}
	}

	static void dameDatos() throws InputMismatchException {
		sc.nextLine();
		System.out.println("sueldo ");
		double sueldo = sc.nextDouble();
		try {
			System.out.println("Edad: ");
			int edad = sc.nextInt();
			System.out.println("sueldo: " + sueldo + " Edad " + edad);
		} catch (InputMismatchException e) {
			System.out.println("Se debe introducir un numero");
		}
	}
}
