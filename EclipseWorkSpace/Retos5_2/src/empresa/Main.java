package empresa;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Empleado> empresa = new ArrayList<Empleado>();
		boolean llave = true;
		int opcion;
		do {
			opcion = Menu();
			if (opcion == 0) {
				llave = false;
			} else {
				crear(empresa, opcion);
			}
		} while (llave);
	}

	public static int Menu() {
		int opcion;

		do {
			System.out.println("1.Empleado" + "\n2.Jefe" + "\n3.Becario" + "\n0.Salir");
			opcion = sc.nextInt();
		} while (opcion != 1 && opcion != 2 && opcion != 3);

		return opcion;
	}

	public static void crear(ArrayList<Empleado> Empresa, int opcion) {
		String nombre;
		double sueldo;
		String contrato;
		double prima;

		sc.nextLine();

		System.out.println("Nombre: ");
		nombre = sc.nextLine();
		System.out.println("sueldo: ");
		sueldo = sc.nextDouble();

		switch (opcion) {
		case 1 -> {
			Empresa.add(new Empleado(nombre, sueldo));
		}
		case 2 -> {
			System.out.println("Prima: ");
			prima = sc.nextDouble();
			Empresa.add(new Jefes(nombre, sueldo, prima));
		}
		case 3 -> {
			sc.nextLine();
			System.out.println("Contrato: ");
			contrato = sc.nextLine();
			Empresa.add(new Becarios(nombre, sueldo, contrato));
		}
		}
		System.out.println(Empresa.toString());
	}

	public static void sueldoCategorias(ArrayList<Empleado> Empresa) {
		double sueldoEmpleado = 0;
		double sueldoBecarios = 0;
		double sueldoJefes = 0;

		for (int i = 0; i < Empresa.size(); i++) {
			if (Empresa.get(i) instanceof Empleado) {
				sueldoEmpleado += Empresa.get(i).getSueldo();
			}
			if (Empresa.get(i) instanceof Becarios) {
				sueldoBecarios += Empresa.get(i).getSueldo();
			}
			if (Empresa.get(i) instanceof Jefes) {
				sueldoEmpleado += Empresa.get(i).getSueldo();
			}
		}
		System.out.println("Sueldo Total Empleados: " + sueldoEmpleado);
		System.out.println("Sueldo Total Becarios: " + sueldoBecarios);
		System.out.println("Sueldo Total Jefes: " + sueldoJefes);
	}
}
