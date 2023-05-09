package org.example;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static {
        try {
            Connection myConecction = DriverManager.getConnection("jdbc:mysql://localhost/maquinaexpendedora", "root", "");
            Statement myStatement = myConecction.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Menu();
    }

    public static void Menu() {
        int menu;
        boolean llave = true;
        do {
            menu = opcionMenu();
            switch (menu) {
                case 1:
                    Create();
                case 2:
                    Read();
                case 3:
                    Update();
                case 4:
                    Delete();
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

    public static void Create() throws SQLException {
        /*System.out.println("id: ");
        int id = sc.nextInt();
        System.out.println("nombre producto: ");
        String nombre = sc.nextLine();
        System.out.println("""
                Tipo:
                Comida / Bebida""");
        String tipo = sc.nextLine();
        boolean boleano = tipo.equalsIgnoreCase("comida");
        System.out.println("precio: ");
        double precio = sc.nextDouble();*/
        String instruccionSql = "INSERT INTO PRODUCTO (id,nombre,tipo,precio) VALUES (1,Snack,0,34.56)";
        ResultSet miResultSet = myStatement.executeQuery("SELECT * FROM PRUEBA");

        while (miResultSet.next()) {
            System.out.println(miResultSet.getString("Nombre") + "\t" + miResultSet.getInt("Edad"));
        }
    }

    public static void Read() {

    }

    private static void Update() {
    }

    private static void Delete() {
    }
}
