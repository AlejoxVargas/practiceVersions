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
				organizarCategoria(empresa);
				sueldoCategorias(empresa);
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
		} while (opcion < 0 || opcion > 3);

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
			Empresa.add(new CrearEmpleado(nombre, sueldo));
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
	}

	public static void sueldoCategorias(ArrayList<Empleado> Empresa) {
		double sueldoEmpleado = 0;
		double sueldoBecarios = 0;
		double sueldoJefes = 0;

		for (int i = 0; i < Empresa.size(); i++) {
			if (Empresa.get(i) instanceof CrearEmpleado) {
				sueldoEmpleado += Empresa.get(i).getSueldo();
			}
			if (Empresa.get(i) instanceof Becarios) {
				sueldoBecarios += Empresa.get(i).getSueldo();
			}
			if (Empresa.get(i) instanceof Jefes) {
				sueldoJefes += Empresa.get(i).getSueldo();
			}
		}
		System.out.println("----Sumar sueldos por categorías----");
		System.out.println("Sueldo Total Empleados: " + sueldoEmpleado);
		System.out.println("Sueldo Total Jefes: " + sueldoJefes);
		System.out.println("Sueldo Total Becarios: " + sueldoBecarios);
	}
	
	public static void organizarCategoria(ArrayList<Empleado>empresa) {
		for (int i = 0; i < empresa.size(); i++){
			if (empresa.get(i) instanceof CrearEmpleado){
				System.out.println("-----EMPLEADOS-----");
				System.out.println(empresa.get(i));
			}
			if (empresa.get(i) instanceof Becarios){	
				System.out.println("-----BECARIOS-----");
				System.out.println(empresa.get(i));
			}
			if (empresa.get(i) instanceof Jefes){
				System.out.println("-----JEFES-----");
				System.out.println(empresa.get(i));
			}
		}
	}
}
