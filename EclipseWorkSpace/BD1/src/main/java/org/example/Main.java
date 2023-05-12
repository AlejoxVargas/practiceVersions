package org.example;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Connection myConecction = null;
    //static Statement myStatement = null;
    static PreparedStatement ps = null;
    static ResultSet miResultSet = null;

    public static void main(String[] args) {
        Menu();
    }

    public static void Menu() {
        int menu;
        do {
            menu = opcionMenu();
            switch (menu) {
                case 1 -> Create();
                case 2 -> Read();
                case 3 -> Update();
                case 4 -> Delete();
            }
        } while (menu != 0);
    }

    public static int opcionMenu() {
        int menu = 0;
        boolean valido = false;
        do {
            try {
                System.out.println("""
                         _____MAQUINA EXPENDEDORA_____
                        1.Create
                        2.Read (Consult)
                        3.Update
                        4.Delete
                        0.Salir""");
                menu = sc.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Opcición no valida " + e.getMessage());
            }
        } while (!valido);
        return menu;
    }
    /*----C----R----U-----D*/

    public static void Create() {
        try {
            myConecction = DriverManager.getConnection("jdbc:mysql://localhost/maquinaexpendedora", "root", "");

            System.out.println("id: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("nombre producto: ");
            String nombre = sc.nextLine();
            System.out.println("""
                    Tipo:
                    Comida / Bebida""");
            String tipo = sc.nextLine();
            boolean boleano = tipo.equalsIgnoreCase("comida");
            System.out.println("precio: ");
            double precio = sc.nextDouble();

            //String instruccionSql = "INSERT INTO PRODUCTOS (id,nombre,tipo,precio) VALUES (" + id + "," + "'" + nombre + "'" + "," + boleano + "," + precio + ")";
            //myStatement.executeUpdate(instruccionSql);

            ps = myConecction.prepareStatement("INSERT INTO PRODUCTOS (id,nombre,tipo,precio) VALUES (?,?,?,?)");
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.setBoolean(3, boleano);
            ps.setDouble(4, precio);
            int row = ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void Read() {
        try {
            miResultSet = ps.executeQuery("SELECT * FROM PRODUCTOS");
            while (miResultSet.next()) {
                System.out.println(miResultSet.getInt("id") + "\t" + miResultSet.getString("nombre") + "\t" + miResultSet.getBoolean("tipo") + "\t" + miResultSet.getDouble("precio"));
            }
            miResultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void Update() {
        //hacer una sentencia que me permita pasarle el campo que quiero tal vez con un arrayList y luego modificar
        try {
            myConecction = DriverManager.getConnection("jdbc:mysql://localhost/maquinaexpendedora", "root", "");
            System.out.println("""
                    \tCampo a modificar
                    1.id
                    2.Nombre
                    3.Tipo
                    4.Precio""");
            int opcion = sc.nextInt();
            System.out.println("Nuevo valor: ");
            ps = myConecction.prepareStatement("UPDATE INTO PRODUCTOS (id,nombre,tipo,precio) VALUES (?,?,?,?)");
            switch (opcion) {
                case 1 -> {
                    System.out.println("Nuevo id: ");
                    ps.setInt(opcion, sc.nextInt());
                }
                case 2 -> {
                    System.out.println("Nuevo nombre: ");
                    ps.setString(opcion, sc.nextLine());
                }
                case 3 -> {
                    System.out.println("Nuevo tipo: ");
                    boolean boleano = sc.nextLine().equalsIgnoreCase("comida");
                    ps.setBoolean(opcion, boleano);
                }
                case 4 -> {
                    System.out.println("Nuevo precio: ");
                    ps.setDouble(opcion, sc.nextDouble());
                }
            }
            int row = ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void Delete() {
    }
}
