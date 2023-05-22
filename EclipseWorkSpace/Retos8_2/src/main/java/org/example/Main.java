package org.example;

import java.sql.*;
import java.util.Objects;

public class Main {
    private Connection connection;
    private Statement statement;
    // Database credentials
    static final String url = "jdbc:mysql://localhost/datoscoches";
    static final String username = "root";
    static final String password = "";

    public static void main(String[] args) {
        Main main = new Main();
        main.connect();
        //main.createSeguroCocheTabla();
        main.insertDataIntoSeguroCoche();
        //main.printSeguroCocheTable();
        //main.updateSeguroCocheTable();
        //main.disconnect();
    }


    private void connect() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conexión establecida");
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    private void createSeguroCocheTabla() {
        try {
            String createTableQuery = "CREATE TABLE IF NOT EXISTS segurocoche (dni VARCHAR(9), edad INTEGER, matricula VARCHAR(10), seguro DOUBLE)";
            statement.executeUpdate(createTableQuery);
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla en la base de datos: " + e.getMessage());
        }
    }

    public void insertDataIntoSeguroCoche() {
        String selectPropietarios = "SELECT * FROM propietarios";
        String selectCoches = "SELECT * FROM coches";
        try {
            ResultSet resultSetPropietarios = statement.executeQuery(selectPropietarios);
            while (resultSetPropietarios.next()) {
                String dni = resultSetPropietarios.getString("dni");
                int edad = resultSetPropietarios.getInt("edad");
                ResultSet resultSetCoches = statement.executeQuery(selectCoches);
                while (resultSetCoches.next()) {
                    String matricula = resultSetCoches.getString("matricula");
                    double precio = resultSetCoches.getDouble("precio");
                    String dniForanea = resultSetCoches.getString("dni");
                    double seguro;

                    if (edad < 40) {
                        seguro = precio * 0.02;
                    } else {
                        seguro = precio * 0.01;
                    }
                    if (Objects.equals(dniForanea, dni)) {
                        ResultSet resultSetSeguroCoche = statement.executeQuery("SELECT * FROM SeguroCoche");
                        resultSetSeguroCoche.updateString("dni", dni);
                        resultSetSeguroCoche.updateInt("edad", edad);
                        resultSetSeguroCoche.updateString("matricula", matricula);
                        resultSetSeguroCoche.updateDouble("seguro", seguro);
                        resultSetSeguroCoche.insertRow();
                        resultSetSeguroCoche.moveToInsertRow();
                    }
                }
            }
            printSeguroCocheTable();
        } catch (SQLException e) {
            e.printStackTrace();
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
        String selectAllQuery = "SELECT * FROM segurocoches";
        try {
            ResultSet resultSet = statement.executeQuery(selectAllQuery);
            while (resultSet.next()) {
                String dni = resultSet.getString("dni");
                int edad = resultSet.getInt("edad");
                String matricula = resultSet.getString("matricula");
                double seguro = resultSet.getDouble("Seguro");
                System.out.println("DNI: " + dni + ", Edad: " + edad + ", Matricula: " + matricula + ", Seguro: " + seguro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void disconnect() {
        try {
            statement.close();
            connection.close();
            System.out.println("Conexión cerrada");
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
