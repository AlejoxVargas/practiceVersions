package Examen;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    static Scanner sc = new Scanner(System.in);
    static Programa[] escaleta = new Programa[24];
    static Pelicula auxPeli = new Pelicula("TENET", "Christopher Nolan", false);
    static Documental auxDocu = new Documental("Welcome to earth", 3, "Naturaleza", false);

    public static void main(String[] args) {
        usarMenu();
    }

    public static void usarMenu() {
        int opcion = 0;
        do {
            opcion = Menu();
            switch (opcion) {
                case 1 -> {
                    int tamaño = tamañoCrear();
                    for (int i = 0; i < tamaño; i++) {
                        switch (MenuTipo()) {
                            case 1 -> crearPelicula();
                            case 2 -> crearDocumental();
                        }
                    }
                }
                case 2 -> ProgramarPrograma(escaleta);
                case 3 -> visualizarEscaleta(escaleta);
                case 0 -> opcion = 0;
            }
        } while (opcion != 0);
    }

    public static int Menu() {
        int opcion = 0;
        do {
            try {
                System.out.println("""
                        \t----MENU----
                        1.Dar de alta un programa
                        2.Programar un programa
                        3.Visualizar escaleta
                        0.Salir""");
                opcion = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un valor númerico");
            }
        } while (opcion < 0 || opcion > 3);
        return opcion;
    }

    public static int MenuTipo() {
        int opcion = 0;
        do {
            try {
                System.out.println("""
                        \t----TIPO PROGRAMA ----
                        1.Película
                        2.Documental""");
                opcion = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un valor númerico");
            }
        } while (opcion < 1 || opcion > 2);
        return opcion;
    }

    public static void crearPelicula() {
        String nombre;
        int duracion;
        boolean llave;

        sc.nextLine();

        System.out.println("Nombre: ");
        nombre = sc.nextLine();
        System.out.println("Nombre del director: ");
        String nombreDirector = sc.nextLine();

        System.out.println("¿Esta pélicula es de estreno?: ");
        String estreno = sc.nextLine();

        if (estreno.equalsIgnoreCase("si")) {
            llave = true;
        } else {
            llave = false;
        }

        auxPeli = new Pelicula(nombre, nombreDirector, llave);
        System.out.println(auxPeli.toString());
    }

    public static void crearDocumental() {
        String nombre;
        int duracion;
        String redifusion;
        boolean llave;

        sc.nextLine();

        System.out.println("Nombre: ");
        nombre = sc.nextLine();
        System.out.println("Duración: ");
        duracion = sc.nextInt();
        sc.nextLine();
        System.out.println("Tema: ");
        String tema = sc.nextLine();

        System.out.println("¿Este documental es de redifusión?: ");
        redifusion = sc.nextLine();

        if (redifusion.equalsIgnoreCase("si")) {
            llave = true;
        } else {
            llave = false;
        }
        auxDocu = new Documental(nombre, duracion, tema, llave);
        System.out.println(auxDocu.toString());
    }

    //metodo para mostrar la opción 3 de escaleta
    public static void visualizarEscaleta(Programa[] escaleta) {
        for (Programa programa : escaleta) {
            if (programa instanceof Pelicula) {
                System.out.println("---PELICULAS----");
                System.out.println(programa.toString());
            }
            if (programa instanceof Documental) {
                System.out.println("----PROGRAMAS----");
                System.out.println(programa.toString());
            }
        }
    }

    public static void ProgramarPrograma(Programa[] escaleta) {
        int opcion = 0;
        int hora;
        System.out.println("Hora del programa: ");
        hora = sc.nextInt();
        do {
            visualizarProgramas();
            System.out.println("""
                    \t----PROGRAMAR----
                    1.Película
                    2.Documental""");
            opcion = sc.nextInt();
        } while (opcion < 1 || opcion > 2);
        switch (opcion) {
            case 1 -> System.out.println(auxPeli.programar(escaleta, hora));
            case 2 -> System.out.println(auxDocu.programar(escaleta, hora));
        }
    }

    public static int tamañoCrear() {
        System.out.println("¿Cuantas programas quiere crear?");
        int cantidad = sc.nextInt();
        return cantidad;
    }

    public static void visualizarProgramas() {
        System.out.println("\t----PELICULAS----");
        System.out.println(auxPeli.toString());
        System.out.println("\t----DOCUMENTAL----");
        System.out.println(auxDocu.toString());
    }
}

