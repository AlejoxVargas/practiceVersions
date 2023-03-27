package ejercicio2;

import java.util.*;

public class Principal {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Profesor> Profesores = new ArrayList<>();
        ArrayList<Profesor> ProfesoresEmeritos = new ArrayList<>();

        Profesores.add(new Profesor("Geraldine", 41, 7));
        Profesores.add(new Profesor("Erika", 42, 8));
        Profesores.add(new Profesor("Lorena", 43, 9));

        ProfesoresEmeritos.add(new ProfesorEmerito("Javier", 44, 10, 8));
        ProfesoresEmeritos.add(new ProfesorEmerito("Fernando", 45, 11, 2));
        ProfesoresEmeritos.add(new ProfesorEmerito("Diana", 46, 12, 3));

        boolean llave = true;
        do {
            switch (Menu()) {
                case 1 -> {
                    crearProfesor(Profesores);
                }
                case 2 -> {
                    crearProfesorEmerito(ProfesoresEmeritos);
                }
                case 3 -> {
                    setProfesorEmerito(ProfesoresEmeritos, Profesores);
                }
                case 0 -> llave = false;
            }
        } while (llave);
    }

    public static int Menu() {
        int opcion;
        do {
            System.out.println("\n1.Profesor"
                    + "\n2.Profesor Emerito"
                    + "\n3.Profesor Existente"
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
    }

    public static void showArray(ArrayList<Profesor> miArray) {
        for (Profesor i : miArray) {
            System.out.println(i.getDatos());
            System.out.println();
        }
    }

    public static void setProfesorEmerito(ArrayList<Profesor> profesorEmerito, ArrayList<Profesor> profesor) {
        boolean encontrado = false;
        int annosEmerito;
        String nombreProfesor;
        do {
            sc.nextLine();
            System.out.println("Nombre profesor a ascender a emerito: ");
            nombreProfesor = sc.nextLine();

            for (int i = 0; i < profesor.size(); i++) {
                if (profesor.get(i).getNombre().equalsIgnoreCase(nombreProfesor)) {
                    System.out.println("Años emerito: ");
                    annosEmerito = sc.nextInt();
                    profesorEmerito.add(profesor.get(i));
                    ((ProfesorEmerito) profesorEmerito.get(i)).setAñosEmerito(annosEmerito);
                    profesor.remove(i);
                    encontrado = false;
                    break;
                } else {
                    encontrado = true;
                }
            }
        } while (encontrado);
        System.out.println("-----EMERITO-----");
        arrangeProfesores(profesorEmerito);
        System.out.println("-----PROFESOR-----");
        arrangeProfesores(profesor);
    }

    public static void arrangeProfesores(ArrayList<Profesor> profesorOrdenar) {
        Collections.sort(profesorOrdenar, new Comparator<Profesor>() {
            @Override
            public int compare(Profesor o1, Profesor o2) {
                return Integer.compare(o1.getAnnosConsolidados(), o2.getAnnosConsolidados());
            }
        });
        for (Profesor profesor : profesorOrdenar) {
            System.out.println(profesor.getDatos());
            System.out.println();
        }
    }
}
