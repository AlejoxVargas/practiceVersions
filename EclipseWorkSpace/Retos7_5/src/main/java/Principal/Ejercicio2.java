package Principal;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio2 {
    static ObjectOutputStream escribiendo;
    static ObjectInputStream leyendo;

    static {
        try {
            escribiendo = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Alejandro Vargas\\Desktop\\objetos.dat",true));
            leyendo = new ObjectInputStream(new FileInputStream("C:\\Users\\Alejandro Vargas\\Desktop\\objetos.dat"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args) {

        clientes.add(new Cliente(1, "Juan Ramirez", "Calle Mayor"));
        clientes.add(new Cliente(2, "Pedro Sanchez", "Plaza del Sol"));
        clientes.add(new Cliente(3, "Zara Cervantes", "Calle del Carmen"));
        clientes.add(new Cliente(4, "Camilo Gonzalo", "Calle de la Princesa"));
        clientes.add(new Cliente(5, "Maria Castellanos", "Rambla de Cataluña"));
        try {
            escribiendo.writeObject(clientes);
            //escribiendo.close();
            Menu(); //hacer que esto no se ejecute si lo anterior falla
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void Menu() {
        int menu;
        boolean llave = true;
        do {
            menu = opcionMenu();
            switch (menu) {
                case 1 -> anyadirCliente(clientes);
                case 2 -> modificarCliente();
                case 3 -> borrarCliente();
                case 4 -> consultarCliente();
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
                        1. Añadir Cliente
                        2. Modificar Cliente
                        3. Borra cliente
                        4. Consultar Cliente
                        0. Salir""");
                menu = sc.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Tiene que ser un número entero entre 1 y 5");
            }
        } while (!valido);

        return menu;
    }

    public static void escribir(ArrayList<Cliente> clientes) {
        try {
            escribiendo.writeObject(anyadirCliente(clientes).lastIndexOf(clientes));
            escribiendo.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static ArrayList<Cliente> anyadirCliente(ArrayList<Cliente> clientes) {
        System.out.println("Código: ");
        int codigo = sc.nextInt();
        sc.nextLine();
        System.out.println("Nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Direccion: ");
        String direccion = sc.nextLine();
        clientes.add(new Cliente(codigo, nombre, direccion));
        return clientes;
    }

    private static void modificarCliente() {
    }

    private static void borrarCliente() {
    }

    private static void consultarCliente() {
        try {
            ArrayList<Cliente> clientesLeidos = (ArrayList<Cliente>) leyendo.readObject();
            for (Cliente i : clientesLeidos) {
                System.out.println(i.toString());
            }
            leyendo.close();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer del fichero: " + e.getMessage());
        }
    }


    public static class Cliente implements Serializable {
        private int codigo;
        private String nombre;
        private String direccion;

        public Cliente(int codigo, String nombre, String direccion) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.direccion = direccion;
        }

        public int getCodigo() {
            return codigo;
        }

        public void setCodigo(int codigo) {
            this.codigo = codigo;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        @Override
        public String toString() {
            return "Código: " + getCodigo() + " Nombre: " + getNombre() + " Dirección: " + getDireccion();
        }
    }
}
