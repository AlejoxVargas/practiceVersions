package org.example;

import java.sql.*;

public class Main {
    private Connection connection;
    private Statement statement;

    public static void main(String[] args) {
        Main main = new Main();
        main.connect();
       // main.createSeguroCocheTabla();
        main.insertDataIntoSeguroCoche();
        //main.updateSeguroCocheTable();
        main.disconnect();
    }

    public void connect() {
        String url = "jdbc:mysql://localhost/datoscoches";
        String username = "root";
        String password = "";

        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conexión establecida");
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    public void createSeguroCocheTabla() {
        try {
            String createTableQuery = "CREATE TABLE IF NOT EXISTS segurocoche (dni VARCHAR(9), edad INTEGER, matricula VARCHAR(10), seguro DOUBLE)";
            statement.executeUpdate(createTableQuery);
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla en la base de datos: " + e.getMessage());
        }
    }

    public void insertDataIntoSeguroCoche() {
        try {
            String selectQuery = "SELECT P.DNI, P.Edad, C.Matricula, C.Precio FROM propietarios P INNER JOIN coches C ON P.DNI = C.DNI";
            ResultSet resultSet = statement.executeQuery(selectQuery);
            while (resultSet.next()) {
                String dni = resultSet.getString("P.DNI");
                int edad = resultSet.getInt("P.Edad");
                String matricula = resultSet.getString("C.Matricula");
                double precio = resultSet.getDouble("C.Precio");

                double seguro;
                if (edad < 40) {
                    seguro = precio * 0.02;
                } else {
                    seguro = precio * 0.01;
                }
                resultSet.moveToInsertRow();
                resultSet.updateString("Dni", dni);
                resultSet.updateInt("Edad", edad);
                resultSet.updateString("Matricula", matricula);
                resultSet.updateDouble("Seguro", seguro);
                resultSet.insertRow();
                resultSet.moveToCurrentRow();
            }
            printSeguroCocheTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateSeguroCocheTable() {
        String selectQuery = "SELECT * FROM segurocoche";
        try {
            ResultSet resultSet = statement.executeQuery(selectQuery);
            while (resultSet.next()) {
                double seguro = resultSet.getDouble("seguro");

                if (seguro < 100) {
                    resultSet.updateDouble("seguro", seguro * 1.05);
                } else if (seguro > 400) {
                    resultSet.deleteRow();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        printSeguroCocheTable();
    }

    public void printSeguroCocheTable() {
        String selectAllQuery = "SELECT * FROM segurocoche";
        try {
            ResultSet resultSet = statement.executeQuery(selectAllQuery);
            while (resultSet.next()) {
                String dni = resultSet.getString("Dni");
                int edad = resultSet.getInt("Edad");
                String matricula = resultSet.getString("Matricula");
                double seguro = resultSet.getDouble("Seguro");
                System.out.println("DNI: " + dni + ", Edad: " + edad + ", Matricula: " + matricula + ", Seguro: " + seguro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexión cerrada");
                statement.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
