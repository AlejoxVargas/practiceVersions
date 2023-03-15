package Gestion;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PrincipalGestion {
    static Scanner sc = new Scanner(System.in);
    static Empleado[] plantilla = new Empleado[2];

    public static void main(String[] args) {
        Menu();
    }

    public static void Menu() {
        int menu;
        int tamañoPlantilla;
        boolean llave = true;
        do {
            menu = opcionMenu();
//            tamañoPlantilla = fillArray();
//            Empleado[] plantilla = new Empleado[2];
            switch (menu) {
                case 1 -> {
                    for (Empleado i : plantilla) {
                        crearEmpleado(plantilla, crearTipoEmpleadoMenu());
                    }
                }
                case 2 -> consultarSueldo(plantilla);
                case 3 -> sueldoMedioCategorias(plantilla);
                case 4 -> {
                    switch (MenuCriteriosInterface1()) {
                        case 1 -> organizarPorCategorias(plantilla);
                        case 2 -> MenuCriteriosInterface2(plantilla);
                    }
                }
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

    public static Empleado[] usarArray(int Plantilla) {
        return new Empleado[Plantilla];
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
        boolean vacio = false;

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

        for (int i = 0; i < plantilla.length && !vacio; i++) {
            if (plantilla[i] == null) {
                switch (opcion) {
                    case 1 -> {
                        plantilla[i] = new EmpVenta(nombre, apellido, edad, LocalDate.of(anyo, mes, dia));
                        System.out.println("Numero de ventas: ");
                        int ventas = sc.nextInt();
                        ((EmpVenta) plantilla[i]).setVentas(ventas);
                        vacio = true;
                    }
                    case 2 -> {
                        plantilla[i] = new EmpRepresentantes(nombre, apellido, edad, LocalDate.of(anyo, mes, dia));
                        System.out.println("Numero de ventas: ");
                        int ventas = sc.nextInt();
                        ((EmpRepresentantes) plantilla[i]).setVentas(ventas);
                        vacio = true;
                    }
                    case 3 -> {
                        plantilla[i] = new EmpProduccion(nombre, apellido, edad, LocalDate.of(anyo, mes, dia));
                        System.out.println("¿Manipula productos de riesgo? ");
                        sc.nextLine();
                        String opcionRiesgo = sc.nextLine();
                        ((EmpProduccion) plantilla[i]).setProductoRiesgo(opcionRiesgo);
                        System.out.println("Unidades producidas: ");
                        int produccion = sc.nextInt();
                        ((EmpProduccion) plantilla[i]).setUnidadesProducidas(produccion);
                        vacio = true;
                    }
                    case 4 -> {
                        plantilla[i] = new EmpMantenimiento(nombre, apellido, edad, LocalDate.of(anyo, mes, dia));
                        System.out.println("¿Manipula productos de riesgo? ");
                        String opcionRiesgo = sc.nextLine();
                        ((EmpMantenimiento) plantilla[i]).setProductoRiesgo(opcionRiesgo);
                        System.out.println("Horas trabajadas: ");
                        int produccion = sc.nextInt();
                        ((EmpProduccion) plantilla[i]).setUnidadesProducidas(produccion);
                        vacio = true;
                    }
                    case 5 -> opcionMenu();
                }
            }
        }
        consultarEmpleado(plantilla);
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
        String nombre;
        System.out.println("Nombre del empleado a consultar: ");
        sc.nextLine();
        nombre = sc.nextLine();

        for (Empleado empleado : plantilla) {
            if (empleado.getNombre().equalsIgnoreCase(nombre) && empleado instanceof EmpVenta) {
                System.out.println(((EmpVenta) empleado).getSueldo());
            }
            if (empleado.getNombre().equalsIgnoreCase(nombre) && empleado instanceof EmpRepresentantes) {
                System.out.println(((EmpRepresentantes) empleado).getSueldo());
            }
            if (empleado.getNombre().equalsIgnoreCase(nombre) && empleado instanceof EmpProduccion) {
                System.out.println(((EmpProduccion) empleado).getSueldo());
            }
            if (empleado.getNombre().equalsIgnoreCase(nombre) && empleado instanceof EmpMantenimiento) {
                System.out.println(((EmpMantenimiento) empleado).getSueldo());
            }
        }
    }

    public static void consultarEmpleado(Empleado[] plantilla) {
        for (Empleado empleado : plantilla) {
            if (empleado instanceof EmpVenta) {
                System.out.println(empleado.getNombreCompleto());
            }
            if (empleado instanceof EmpRepresentantes) {
                System.out.println(empleado.getNombreCompleto());
            }
            if (empleado instanceof EmpProduccion) {
                System.out.println(empleado.getNombreCompleto());
            }
            if (empleado instanceof EmpMantenimiento) {
                System.out.println(empleado.getNombreCompleto());
            }
        }
    }

    public static void sueldoMedioCategorias(Empleado[] plantilla) {
        double mediaEmpVentas = 0, mediaEmpRepresentantes = 0, mediaEmpProduccion = 0, mediaEmpMantenimiento = 0;
        int contadorVentas = 0, contadorRepre = 0, contadorProdu = 0, contardorManteni = 0;
        for (Empleado empleado : plantilla) {
            if (empleado instanceof EmpVenta) {
                mediaEmpVentas += ((EmpVenta) empleado).getSueldo();
                contadorVentas++;
            }
            if (empleado instanceof EmpRepresentantes) {
                mediaEmpRepresentantes += ((EmpRepresentantes) empleado).getSueldo();
                contadorRepre++;
            }
            if (empleado instanceof EmpProduccion) {
                mediaEmpProduccion += ((EmpProduccion) empleado).getSueldo();
                contadorProdu++;
            }
            if (empleado instanceof EmpMantenimiento) {
                mediaEmpMantenimiento += ((EmpMantenimiento) empleado).getSueldo();
                contardorManteni++;
            }
        }
        System.out.println("Sueldo medio de la categoria ventas: " + mediaEmpVentas / contadorVentas);
        System.out.println("Sueldo medio de la categoria representantes: " + mediaEmpRepresentantes / contadorRepre);
        System.out.println("Sueldo medio de la categoria Producción: " + mediaEmpProduccion / contadorProdu);
        System.out.println("Sueldo medio de la categoria Mantenimiento: " + mediaEmpMantenimiento / contardorManteni);
    }

    public static int MenuCriteriosInterface1() {
        int menu = 0;
        boolean llave = false;
        do {
            //try {
            System.out.println("""
                    1.Organizar por categorias:
                    2.Organizar por criterio especifico
                    0.Salir""");
            menu = sc.nextInt();
//                if (menu > 2) {
//                    System.out.println("Debe elegir una opción entre 0 y 2");
//                } else {
//                    llave = true;
//                }
//                if (menu == 0) {
//                    sc.close();
//                }
//            } catch (InputMismatchException e) {
//                System.out.println("Debe elegir una opción entre 0 y 2");
//            }
        } while (llave);
        return menu;
    }

    public static int MenuCriteriosInterface2(Empleado[] plantilla) {
        int menu = 0;
        boolean llave = false;
        do {
            try {
                System.out.println("""
                        Organizar según: 
                        \n1.Nombre
                        \n2.Apellido
                        \n3.Edad
                        \n4.Fecha Entrada
                        \n0.Salir""");
                menu = sc.nextInt();
                if (menu > 2) {
                    System.out.println("Debe elegir una opción entre 0 y 4");
                } else {
                    llave = true;
                }
                if (menu == 0) {
                    sc.close();
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe elegir una opción entre 0 y 4");
            }
        } while (llave);
        return menu;
    }

    public static void organizarPorCategorias(Empleado[] plantilla) {
        for (Empleado empleado : plantilla) {
            if (empleado instanceof EmpVenta) {
                System.out.println(empleado.getNombreCompleto() + ((EmpVenta) empleado).getSueldo());
            }
            if (empleado instanceof EmpRepresentantes) {
                System.out.println(empleado.getNombreCompleto() + ((EmpRepresentantes) empleado).getSueldo());
            }
            if (empleado instanceof EmpProduccion) {
                System.out.println(empleado.getNombreCompleto() + ((EmpProduccion) empleado).getSueldo());
            }
            if (empleado instanceof EmpMantenimiento) {
                System.out.println(empleado.getNombreCompleto() + ((EmpMantenimiento) empleado).getSueldo());
            }
        }
    }
}
/*
 * Saber como hacer el toString para consultar el sueldo (tengo errores desde la clase hija con el método getNombreCompleto)
 * Saber como recorrer el array para hacer el compareTO y sí debo hacerlo con el objeto siguiente, método burbuja, etc...
 * organizar cada uno segun criterios pero dentro de su misma categoria sin que se salga de esta categoria*/