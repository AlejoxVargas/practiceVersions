package AlquilerCoches;

import java.util.ArrayList;
import java.util.Iterator;
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

        libres.add(new Coches ("AB123", "HONDA", "H1"));
        libres.add(new Coches("CD456", "KIA", "K2"));
        libres.add(new Coches("EF789", "RENAULT", "R2"));

        boolean llave = true;
        do {
            switch (Menu()) {
                case 1 -> CrearCoche(libres);
                case 2 -> AlquilarCoche(libres, alquilados);
                case 3 -> DevolverCoche(libres, alquilados);
                case 0 -> llave = false;
            }
        } while (llave);
    }

    public static int Menu() {
        int opcion;
        do {
            System.out.println("""
                    \t MENU
                    1. Dar de alta
                    2. Alquilar
                    3. Devolver
                    0. Salir                     
                    """);
            opcion = sc.nextInt();
        } while (opcion < 0 || opcion > 3);
        return opcion;
    }

    public static void CrearCoche(ArrayList<Coches> libres) {
        int opcion;
        String matricula, marca, modelo;

        sc.nextLine();

        System.out.println("Matricula: ");
        matricula = sc.nextLine();
        System.out.println("Marca: ");
        marca = sc.nextLine();
        System.out.println("Modelo: ");
        modelo = sc.nextLine();
        Coches cocheAux = new Coches(matricula, marca, modelo); //esto enviarlo al MAIN, crear algunos coches ya previamente

        libres.add(cocheAux);
    }

    public static void AlquilarCoche(ArrayList<Coches> libres, ArrayList<Coches> alquilar) {
        String matricula;
/*        for (int i = 0; i < libre.size(); i++) {
            System.out.println(libre.get(i));
        }*/
        System.out.println(libres);

        sc.nextLine();
        System.out.println("Coche a alquilar: ");
        matricula = sc.nextLine();

        for (int i = 0; i < libres.size(); i++) {
            if (libres.get(i).matricula.equalsIgnoreCase(matricula)) {
                System.out.println("Se encuentra libre");
                alquilar.add(libres.get(i));
                libres.remove(i);
            } else {
                System.out.println("No se encuentra libre");
            }
        }
        System.out.println(libres.toString());
        System.out.println(alquilar.toString());
    }

    public static void DevolverCoche(ArrayList<Coches> libres, ArrayList<Coches> alquilar) {
        String matricula;
        sc.nextLine();
        System.out.println("Matriculas del coche: ");
        matricula = sc.nextLine();

        for (int i = 0; i < alquilar.size(); i++) {
            if (alquilar.get(i).matricula.equalsIgnoreCase(matricula)) {
                System.out.println("Se ha devuelto exitosamente");
                libres.add(alquilar.get(i));
                alquilar.remove(i);
            }
        }
        System.out.println(libres.toString());
        System.out.println(alquilar.toString());
    }
}
