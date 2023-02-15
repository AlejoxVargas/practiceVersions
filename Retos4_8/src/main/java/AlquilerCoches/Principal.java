package AlquilerCoches;

import java.util.*;

/**
 * @author USUARIO CCC - TARDE
 * @author Alejandro Vargas
 */
public class Principal {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Coches> alquilados = new ArrayList<>();
        ArrayList<Coches> libres = new ArrayList<>();

        libres.add(new Coches("AB123", "HONDA", "H1"));
        libres.add(new Coches("CD456", "KIA", "K2"));
        libres.add(new Coches("EF789", "RENAULT", "R2"));

        alquilados.add(new Coches("KL789", "BUGATTI", "B2"));
        alquilados.add(new Coches("GH123", "FERRARI", "F23"));
        alquilados.add(new Coches("JI456", "AUDI", "A50"));

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
        String matricula, marca, modelo;
        sc.nextLine();

        System.out.println("Matricula: ");
        matricula = sc.nextLine();
        System.out.println("Marca: ");
        marca = sc.nextLine();
        System.out.println("Modelo: ");
        modelo = sc.nextLine();

        Coches cocheAux = new Coches(matricula, marca, modelo);
        libres.add(cocheAux);
    }

    public static void AlquilarCoche(ArrayList<Coches> libres, ArrayList<Coches> alquilar) {
        String matricula;
        boolean noDisponible = false;
        do {
            sc.nextLine();
            arrangeNumbers(libres);
            System.out.println("Coche a alquilar: ");
            matricula = sc.nextLine();

            for (int i = 0; i < libres.size(); i++) {
                if (libres.get(i).matricula.equalsIgnoreCase(matricula)) {
                    System.out.println("Se encuentra libre");
                    alquilar.add(libres.get(i));
                    libres.remove(i);
                    noDisponible = false;
                    break;
                } else {
                    noDisponible = true;
                }
            }
        } while (noDisponible);

        System.out.println("\t -------LIBRES--------");
        arrangeNumbers(libres);
        System.out.println("\t -------ALQUILADOS--------");
        arrangeNumbers(alquilar);
    }

    public static void DevolverCoche(ArrayList<Coches> libres, ArrayList<Coches> alquilar) {
        String matricula;
        boolean noDisponible = false;
        do {
            sc.nextLine();
            arrangeNumbers(alquilar);
            System.out.println("Coche a devolver: ");
            matricula = sc.nextLine();

            for (int i = 0; i < alquilar.size(); i++) {
                if (alquilar.get(i).matricula.equalsIgnoreCase(matricula)) {
                    System.out.println("Se ha devuelto exitosamente");
                    libres.add(alquilar.get(i));
                    alquilar.remove(i);
                    noDisponible = false;
                    break;
                } else {
                    noDisponible = true;
                }
            }
        } while (noDisponible);

        System.out.println("\t -------ALQUILADOS--------");
        arrangeNumbers(alquilar);
        System.out.println("\t -------LIBRES--------");
        arrangeNumbers(libres);
    }

    public static void arrangeNumbers(ArrayList<Coches> MarcasOrdenar) {
        Collections.sort(MarcasOrdenar, new Comparator<Coches>() {
            @Override
            public int compare(Coches o1, Coches o2) {
                return o1.getMarca().compareTo(o2.getMarca());
            }
        });
        for (Coches coche : MarcasOrdenar) {
            System.out.println(coche.toString());
        }
    }
}