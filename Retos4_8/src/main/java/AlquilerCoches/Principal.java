package AlquilerCoches;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author USUARIO CCC - TARDE
 * @author Alejandro Vargas
 */
public class Principal {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Coches> alquilados = new ArrayList<>();
        ArrayList<Coches> libres = new ArrayList<>();

        crearCoche(libres);
        alquilarCoche(libres, alquilados);
    }

    public static void Menu() {
        int opcion;
        do {
            System.out.println("""
                    1. Dar de alta
                    2. Alquilar
                    3. Devolver
                    0. Salir                     
                    """);
            opcion = sc.nextInt();
        } while (opcion < 0 || opcion > 3);
    }

    public static Coches crearCoche(ArrayList<Coches> libre) {
        String matricula, marca, modelo;
        System.out.println("Matricula: ");
        matricula = sc.nextLine();
        System.out.println("Marca: ");
        marca = sc.nextLine();
        System.out.println("Modelo: ");
        modelo = sc.nextLine();
        Coches coche = new Coches(matricula, marca, modelo);
        libre.add(coche);
        return coche;
    }

    public static void alquilarCoche(ArrayList<Coches> libre, ArrayList<Coches> alquilar) {
        int opcion, iterador;
        for (int i = 0; i < libre.size(); i++) {
            System.out.println(i + 1 + " " + libre.get(i));
        }
        System.out.println("Coche a alquilar: ");
        opcion = sc.nextInt();
        
    }
}
