package Gestion;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PrincipalGestion {
	static Scanner sc = new Scanner (System.in);
	public static void main(String[] args) {
		Empleado[] plantilla = new Empleado[10];
	}
	
	public static int opcionMenu(){
		int menu = 0;
		boolean valido = false;
		
		do {
			try {
				System.out.println("\n _____MENU_____"
						+"\n1. Agregar Empleado"
						+"\n2. Consulta Sueldo de empleado"
						+"\n3. Consulta Sueldo Medio por Categorias"
						+"\n4. Consulta de Categorias segun criterios"
						+"\n0. Salir");
				menu = sc.nextInt();
				valido = true;
			} catch(InputMismatchException e) {
				System.out.println("Tiene que ser un número entero entre 1 y 4");
			}
		}while(!valido);
		
		return menu;
	}
	
	public static void crear(Empleado[] plantilla, int opcion) {
		String nombre;
		String apellido;
		int edad;
		int año,mes,dia;

		sc.nextLine();

		System.out.println("Nombre: ");
		nombre = sc.nextLine();
		System.out.println("Apellido: ");
		apellido = sc.nextLine();
		System.out.println("edad: ");
		edad = sc.nextInt();
		

		switch (opcion) {
		case 1 -> {
			Empleado
		}
		case 2 -> {
			System.out.println("Prima: ");
			prima = sc.nextDouble();
			EmpRepresentante(new Jefes(nombre, sueldo, prima));
		case 3 -> {
			sc.nextLine();
			System.out.println("Contrato: ");
			contrato = sc.nextLine();
			EmpVentas(new Becarios(nombre, sueldo, contrato));
		}
		}
		System.out.println(Empresa.toString());
	}
	//hacer una clase de localdate para rellenar de manera directa y sin tener 3 variables distintas
	
	
}
