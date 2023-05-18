package org.example;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private Connection connection;

    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }

    public void menu() {
        connect();
        int menu;
        do {
            menu = opcionMenu();
            switch (menu) {
                case 1 -> create();
                case 2 -> read();
                case 3 -> update();
                case 4 -> delete();
            }
        } while (menu != 0);
        disconnect();
    }

    public static int opcionMenu() {
        Scanner sc = new Scanner(System.in);
        int menu = 0;
        boolean valido = false;
        do {
            try {
                System.out.println("""
                         _____MAQUINA EXPENDEDORA_____
                        1.Create
                        2.Read
                        3.Update
                        4.Delete
                        0.Salir""");
                menu = sc.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Opción no valida " + e.getMessage());
            }
        } while (!valido);
        return menu;
    }

    // Método para establecer la conexión con la base de datos
    public void connect() {
        String url = "jdbc:mysql://localhost/maquinaexpendedora";
        String username = "root";
        String password = "";

        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conexión establecida");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    // Método para crear un nuevo registro en la tabla
    public void create() {
        try {
            // Obtener los datos ingresados por el usuario
            Scanner sc = new Scanner(System.in);
            System.out.print("Ingrese el valor para el campo 'nombre': ");
            String nombre = sc.nextLine();

            System.out.print("Ingrese el valor para el campo 'tipo': ");
            String tipo = sc.nextLine();

            System.out.print("Ingrese el valor para el campo 'precio': ");
            double precio = sc.nextDouble();

            // Consulta SQL
            String sql = "INSERT INTO productos (nombre, tipo, precio) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Establecer los valores de los parámetros
            statement.setString(1, nombre);
            statement.setString(2, tipo);
            statement.setDouble(3, precio);

            // Ejecutar la consulta
            int filasAfectadas = statement.executeUpdate();

            // Verificar si se creó el registro correctamente
            if (filasAfectadas > 0) {
                System.out.println("El registro se ha creado correctamente.");
            } else {
                System.out.println("Error al crear el registro.");
            }

            // Cerrar el statement
            statement.close();

            /*String instruccionSql = "INSERT INTO PRODUCTOS (id,nombre,tipo,precio) VALUES (" + id + "," + "'" + nombre + "'" + "," + boleano + "," + precio + ")";
             * myStatement.executeUpdate(instruccionSql); */

        } catch (SQLException e) {
            System.out.println("Error al crear el registro: " + e.getMessage());
        }
    }

    // Método para consultar todos los registros de la tabla
    public void read() {
        try {
            String sql = "SELECT * FROM productos";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Ejecutar la consulta
            ResultSet resultSet = statement.executeQuery();

            // Recorrer los resultados y mostrarlos en pantalla
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String tipo = resultSet.getString("tipo");
                double precio = resultSet.getDouble("precio");

                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Tipo: " + tipo + ", Precio: " + precio);
            }

            // Cerrar el statement y el resultSet
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Error al consultar los registros: " + e.getMessage());
        }
    }

    // Método para modificar un registro en la tabla
    private void update() {
        try {
            // Obtener los datos ingresados por el usuario
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el ID del registro a modificar: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            System.out.print("Ingrese el nuevo valor para el campo 'nombre': ");
            String nuevoNombre = scanner.nextLine();

            System.out.print("Ingrese el nuevo valor para el campo 'Tipo': ");
            String nuevoTipo = scanner.nextLine();

            System.out.print("Ingrese el nuevo valor para el campo 'Precio': ");
            double nuevoPrecio = scanner.nextDouble();

            String sql = "UPDATE productos SET nombre = ?, tipo = ?, precio = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Establecer los valores de los parámetros
            statement.setString(1, nuevoNombre);
            statement.setString(2, nuevoTipo);
            statement.setDouble(3, nuevoPrecio);
            statement.setInt(4, id);

            // Ejecutar la consulta
            int filasAfectadas = statement.executeUpdate();

            // Verificar si se modificó algún registro
            if (filasAfectadas > 0) {
                System.out.println("El registro se ha modificado correctamente.");
            } else {
                System.out.println("No se encontró ningún registro con el ID proporcionado.");
            }

            // Cerrar el statement
            statement.close();

        } catch (SQLException e) {
            System.out.println("Error al modificar el registro: " + e.getMessage());
        }
    }

    // Método para borrar un registro de la tabla
    public void delete() {
        try {
            // Obtener el ID del registro a borrar ingresado por el usuario
            Scanner sc = new Scanner(System.in);
            System.out.print("Ingrese el ID del registro a borrar: ");
            int id = sc.nextInt();

            // Consulta SQL
            String sql = "DELETE FROM productos WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Establecer el valor del parámetro
            statement.setInt(1, id);

            // Ejecutar la consulta
            int filasAfectadas = statement.executeUpdate();

            // Verificar si se borró el registro correctamente
            if (filasAfectadas > 0) {
                System.out.println("El registro se ha borrado correctamente.");
            } else {
                System.out.println("No se encontró ningún registro con el ID proporcionado.");
            }

            // Cerrar el statement
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error al borrar el registro: " + e.getMessage());
        }
    }

    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
