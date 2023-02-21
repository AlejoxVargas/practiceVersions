package empresa;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Empleados[] empresas = new Empleados[10];
		 boolean llave = true;
	        do {
	            switch (Menu()) {
	                case 1 -> crearProfesor();
	                case 2 -> crearProfesorEmerito();
	                case 0 -> llave = false;
	            }
	        } while (llave);
	}

	public static int Menu() {
		int opcion;
		do {
			System.out.println(
							"\n1.Empleado" 
							+ "\n2.Jefe"
							+ "\n3.Becario" 
							+ "\n0.Salir");
			opcion = sc.nextInt();
		} while (opcion < 0 || opcion > 3);
		return opcion;
	}
}
