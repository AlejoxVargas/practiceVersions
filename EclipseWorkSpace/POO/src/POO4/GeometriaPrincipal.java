package POO4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GeometriaPrincipal {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Menu();
	}

	public static void Menu() {
		int menu;
		do {
			menu = opcionMenu();
			
			switch(menu) {
			case 1 -> {
				System.out.println("Base del rectagulo");
				double baseRec = sc.nextDouble();
				System.out.println("Altura del rectangulo");
				double altRec = sc.nextDouble();
				
				Rectangulo rectangulo1 = new Rectangulo(baseRec, altRec);
				System.out.println("Area del rectangulo: " + rectangulo1.calcularArea());
				break;
			}
			case 2 -> {
				System.out.println("Base del rectagulo");
				double baseRec = sc.nextDouble();
				System.out.println("Altura del rectángulo");
				double altRec = sc.nextDouble();
				
				Rectangulo rectangulo2 = new Rectangulo(baseRec, altRec);
				System.out.println("Perimetro del rectangulo: " + rectangulo2.calcularPerimetro());
				break;
			}
			case 3 -> {
				System.out.println("Radio del circulo");
				double radioCir = sc.nextDouble();
				
				Circulo circulo1 = new Circulo(radioCir);
				System.out.println("Area del circulo: " + circulo1.calcularArea());
				break;
			}
			case 4 -> {
				System.out.println("Radio del circulo");
				double radioCir = sc.nextDouble();
				
				Circulo circulo2 = new Circulo(radioCir);
				System.out.println("Perimetro del circulo: " + circulo2.calcularPerimetro());
				break;
			}
			case 5 -> {
				System.out.println("Base del Triangulo");
				double baseTri = sc.nextDouble();
				System.out.println("Altura del Triangulo");
				double altTri = sc.nextDouble();
				
				Triangulo triangulo1 = new Triangulo(baseTri, altTri);
				System.out.println("Area del triangulo: " + triangulo1.calcularArea());
				break;
			}
			case 6 -> {
				System.out.println("Base del Triangulo");
				double baseTri = sc.nextDouble();
				System.out.println("Altura del Triangulo");
				double altTri = sc.nextDouble();
				
				Triangulo triangulo2 = new Triangulo (baseTri, altTri);
				System.out.println("Perimetro del triangulo: " + triangulo2.calcularPerimetro());
				break;
			}
			}
		} while (menu != 0);
	}
	
	public static int opcionMenu(){
		int menu = 0;
		boolean valido = false;
		
		do {
			try {
				System.out.println("\n _____MENU_____"
						+"\n1. Area Rectangulo"
						+"\n2. Perimentro Rectangulo"
						+"\n3. Area Circulo"
						+"\n4. Perimetro Circulo"
						+"\n5. Area Triangulo"
						+"\n6. Perimetro Triangulo");
				menu = sc.nextInt();
				valido = true; //excepciones
			} catch(InputMismatchException e) {
				System.out.println("Tiene que ser un número entero entre 1 y 6");
			}
		}while(!valido); //mientras no se cumpla valido
		
		return menu;
	}
}
