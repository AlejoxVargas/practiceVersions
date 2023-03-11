package Gestion;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PrincipalGestion {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
//        int personalCantidad = 0;
//        System.out.println("Tamaño de la plantila de la empresa: ");
//        personalCantidad = sc.nextInt();
//        Empleado[] plantilla = new Empleado[personalCantidad];
        Menu();
    }

    public static void Menu() {
        int menu;
        int tamañoPlantilla;
        boolean llave = true;
        do {
            menu = opcionMenu();
            //tamañoPlantilla = fillArray();
            Empleado[] plantilla = new Empleado[4];
            switch (menu) {
                case 1 -> {
                    for (Empleado i : plantilla) {
                        crearEmpleado(plantilla, crearTipoEmpleadoMenu());
                    }
                }
                case 2 -> consultarSueldo(plantilla);
            }
        } while (menu != 0);
    }

    public static int opcionMenu() {
        int menu = 0;
        boolean valido = false;
        do {
            try {
                System.out.println("""
                         _____MENU_____
                        1. Agregar Empleado
                        2. Consulta Sueldo de empleado
                        3. Consulta Sueldo Medio por Categorias
                        4. Consulta de Categorias segun criterios
                        0. Salir""");
                menu = sc.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Tiene que ser un número entero entre 1 y 4");
            }
        } while (!valido);

        return menu;
    }

    public static Empleado[] usarArray(int tamañoPlantilla) {
        Empleado[] plantilla = new Empleado[tamañoPlantilla];
        return plantilla;
    }

    public static int fillArray() {
        int personalCantidad = 0;
        System.out.println("Tamaño de la plantila de la empresa: ");
        personalCantidad = sc.nextInt();
        return personalCantidad;
    }

    public static void crearEmpleado(Empleado[] plantilla, int opcion) {
        String nombre;
        String apellido;
        int edad;
        int anyo, mes, dia;

        sc.nextLine();

        System.out.println("Nombre: ");
        nombre = sc.nextLine();
        System.out.println("Apellido: ");
        apellido = sc.nextLine();
        System.out.println("Edad: ");
        edad = sc.nextInt();
        System.out.println("Año:");
        anyo = sc.nextInt();
        System.out.println("Mes: ");
        mes = sc.nextInt();
        System.out.println("Día: ");
        dia = sc.nextInt();

        for (int i = 0; i < plantilla.length; i++) {
            switch (opcion) {
                case 1 -> {
                    plantilla[i] = new EmpVenta(nombre, apellido, edad, LocalDate.of(anyo, mes, dia));
                    System.out.println("Numero de ventas: ");
                    int ventas = sc.nextInt();
                    ((EmpVenta) plantilla[i]).setVentas(ventas);
                }
                case 2 -> {
                    plantilla[i] = new EmpRepresentantes(nombre, apellido, edad, LocalDate.of(anyo, mes, dia));
                    System.out.println("Numero de ventas: ");
                    int ventas = sc.nextInt();
                    ((EmpRepresentantes) plantilla[i]).setVentas(ventas);
                }
                case 3 -> {
                    plantilla[i] = new EmpProduccion(nombre, apellido, edad, LocalDate.of(anyo, mes, dia));
                    System.out.println("¿Manipula productos de riesgo? ");
                    String opcionRiesgo = sc.nextLine();
                    ((EmpProduccion) plantilla[i]).setProductoRiesgo(opcionRiesgo);
                    System.out.println("Unidades producidas: ");
                    int produccion = sc.nextInt();
                    ((EmpProduccion) plantilla[i]).setUnidadesProducidas(produccion);
                }
                case 4 -> {
                    plantilla[i] = new EmpMantenimiento(nombre, apellido, edad, LocalDate.of(anyo, mes, dia));
                    System.out.println("¿Manipula productos de riesgo? ");
                    String opcionRiesgo = sc.nextLine();
                    ((EmpMantenimiento) plantilla[i]).setProductoRiesgo(opcionRiesgo);
                    System.out.println("Horas trabajadas: ");
                    int produccion = sc.nextInt();
                    ((EmpProduccion) plantilla[i]).setUnidadesProducidas(produccion);
                }
                case 5 -> opcionMenu();
            }
        }
    }

    public static int crearTipoEmpleadoMenu() {
        int menu = 0;
        boolean valido = false;
        do {
            try {
                System.out.println("""
                         _____EMPLEADO_____
                        1. Venta
                        2. Representantes
                        3. Producción
                        4. Mantenimiento
                        5. Menu Principal
                        0. Salir""");
                menu = sc.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Tiene que ser un número entero entre 1 y 4");
            }
        } while (!valido);

        return menu;
    }

    public static void empleadosCategorias(Empleado[] plantilla) {
        for (int i = 0; i < plantilla.length; i++) {
            if (plantilla[i] instanceof EmpVenta) {
            }
        }
    }

    public static void consultarSueldo(Empleado[] plantilla) {
        for (Empleado i : plantilla) {
            if (i instanceof EmpVenta) {
                System.out.println(((EmpVenta) i).getSueldo());
            }
        }
    }
}