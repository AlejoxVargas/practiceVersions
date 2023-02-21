package ejercicio2;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Profesor> Profesores = new ArrayList<>();
        boolean llave = true;
        do {
            switch (Menu()) {
                case 1 -> crearProfesor(Profesores);
                case 2 -> crearProfesorEmerito(Profesores);
                case 0 -> llave = false;
            }
        } while (llave);
    }

    public static int Menu() {
        int opcion;
        do {
            System.out.println("\n1.Profesor"
                    + "\n2.Profesor Emerito"
                    + "\n3.Profesor Existente" //Solo debo añadirle a cualquier profesor algun emerito
                    + "\n0.Salir");
            opcion = sc.nextInt();
        } while (opcion < 0 || opcion > 3);
        return opcion;
    }

    public static void crearProfesor(ArrayList<Profesor> Profesores) {
        String nombre;
        int edad;
        int annosConsolidados;
        sc.nextLine();
        System.out.println("Nombre: ");
        nombre = sc.nextLine();
        System.out.println("edad: ");
        edad = sc.nextInt();
        System.out.println("Años consolidados: ");
        annosConsolidados = sc.nextInt();
        Profesores.add(new Profesor(nombre, edad, annosConsolidados));
        showArray(Profesores);
    }

    public static void crearProfesorEmerito(ArrayList<Profesor> ProfesoresEmeritos) {
        String nombre;
        int edad;
        int annosConsolidados;
        int annosEmerito;
        sc.nextLine();
        System.out.println("Nombre: ");
        nombre = sc.nextLine();
        System.out.println("edad: ");
        edad = sc.nextInt();
        System.out.println("Años consolidados: ");
        annosConsolidados = sc.nextInt();
        System.out.println("Años emerito: ");
        annosEmerito = sc.nextInt();
        ProfesoresEmeritos.add(new ProfesorEmerito(nombre, edad, annosConsolidados, annosEmerito));
        showArray(ProfesoresEmeritos);
    }

    public static void showArray(ArrayList<Profesor> miArray) {
        for (Profesor i : miArray) {
            System.out.println(i.getDatos());
        }
    }
}
