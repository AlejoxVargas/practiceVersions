package empresa;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Empleado> datos = new ArrayList<Empleado>();
		ArrayList<Empleado> empresas = new ArrayList<Empleado>();
		boolean llave = true;
		do {
			switch (Menu()) {
			case 1 -> crearEmpleado(empresas);
			case 2 -> crearBecario(empresas);
			case 3 -> crearJefe(empresas);
			case 0 -> llave = false;
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

	public static void crear(ArrayList<Empleado> Empleados, int opcion) {
		String nombre;
		double sueldo;
		sc.nextLine();
		System.out.println("Nombre: ");
		nombre = sc.nextLine();
		System.out.println("sueldo: ");
		sueldo = sc.nextDouble();
		switch(opcion)
		Empleados.add(new Empleado(nombre, sueldo));
		System.out.println(Empleados.toString());
	}

	public static void crearBecario(ArrayList<Empleado> Empleados) {
		String nombre;
		double sueldo;
		String contrato;
		sc.nextLine();
		System.out.println("Nombre: ");
		nombre = sc.nextLine();
		System.out.println("sueldo: ");
		sueldo = sc.nextDouble();
		System.out.println("Contrato: ");
		contrato = sc.nextLine();
		System.out.println("O");
		switch(){
		
		}
		Empleados.add(new Becarios(nombre, sueldo, contrato));
		System.out.println(Empleados.toString());
	}

	public static void crearJefe(ArrayList<Empleado> Empleados) {
		String nombre;
		double sueldo;
		double prima;
		sc.nextLine();
		System.out.println("Nombre: ");
		nombre = sc.nextLine();
		System.out.println("sueldo: ");
		sueldo = sc.nextDouble();
		System.out.println("prima: ");
		prima = sc.nextDouble();
		Empleados.add(new Jefes(nombre, sueldo, prima));
		System.out.println(Empleados.toString());
	}
}
