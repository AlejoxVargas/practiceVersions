package org.example;

import java.sql.*;
import java.util.Objects;

public class Main {
    private static Connection connection;

    static {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/tienda","root","");
            System.out.println("Conexión establecida");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        //Crea las tablas fabricantes y articulos
        //createTables();

        //Inserta datos en las tablas
        //insertData();

        //Crea la tabla ArtFab
        createArtFabTable();

        //Rellena la tabla "ArtFab" con los datos
        //updateArtTabTable();

        //Mouestra la información de la tabla ArtFab
        mostrarArtFabTable();
    }

    public static void createDatabase() {
        try (Statement statement = connection.createStatement()) {
            String createDatabaseQuery = "CREATE DATABASE Tienda";
            statement.executeUpdate(createDatabaseQuery);
            System.out.println("Base de datos Tienda creada con exito");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTables() {
        try (Statement statement = connection.createStatement()) {
            String createFabricantesQuery = "CREATE TABLE Fabricantes(" +
                    "CLFAB int PRIMARY KEY," +
                    "Nombre varchar(30)" +
                    ")ENGINE=InnoDB";
            statement.executeUpdate(createFabricantesQuery);

            String createArticulosQuery = "CREATE TABLE Articulos(" +
                    "CLART int PRIMARY KEY," +
                    "Nombre varchar(30)," +
                    "Precio int," +
                    "CLFAB int," +
                    "FOREIGN KEY (CLFAB) REFERENCES Fabricantes(CLFAB) ON DELETE CASCADE ON UPDATE CASCADE" +
                    ")ENGINE=InnoDB";
            statement.executeUpdate(createArticulosQuery);

            System.out.println("Tabla 'Fabricantes' y 'Articulos' creadas con exito");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertData() {
        try (Statement statement = connection.createStatement()) {
            String[] fabricantesData = {
                    "INSERT INTO Fabricantes VALUES(1,'Kingston')",
                    "INSERT INTO Fabricantes VALUES(2,'Adata')",
                    "INSERT INTO Fabricantes VALUES(3,'Logitech')",
                    "INSERT INTO Fabricantes VALUES(4,'Lexar')",
                    "INSERT INTO Fabricantes VALUES(5,'Seagate')"
            };

            String[] articulosData = {
                    "INSERT INTO Articulos VALUES(1,'Teclado',100,3)",
                    "INSERT INTO Articulos VALUES(2,'Disco Duro 300Gb',500,5)",
                    "INSERT INTO Articulos VALUES(3,'Mouse',80,3)",
                    "INSERT INTO Articulos VALUES(4,'Memoria USB',140,4)",
                    "INSERT INTO Articulos VALUES(5,'Memoria Ram',290,1)",
                    "INSERT INTO Articulos VALUES(6,'Disco Duro Extraible 250 Gb',650,5)",
                    "INSERT INTO Articulos VALUES(7,'Memoria USB',279,1)",
                    "INSERT INTO Articulos VALUES(8,'DVD Rom',450,2)",
                    "INSERT INTO Articulos VALUES(9,'CD Rom',200,2)",
                    "INSERT INTO Articulos VALUES(10,'Tarjeta de Red',180,3)"
            };

            for (String fabricanteData : fabricantesData) {
                statement.executeUpdate(fabricanteData);
            }

            for (String articuloData : articulosData) {
                statement.executeUpdate(articuloData);
            }

            System.out.println("Datos insertados con éxito");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertDataIntoSeguroCoche() {
        String query = "SELECT Articulos.Nombre, Fabricantes.Nombre, Articulos.Precio FROM Articulos JOIN Fabricantes ON Articulos.CLFAB = Fabricantes.CLFAB;";
        try (Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String nombreArticulo = resultSet.getString("Articulos.Nombre");
                String nombreFabricante = resultSet.getString("Fabricantes.Nombre");
                double precio = resultSet.getDouble("Articulos.Precio");

                String sql = "INSERT INTO ArtFab (Nombre_Articulo, Nombre_Fabricantes, Precio_Articulo) VALUES (?, ?, ?, ?)";
                PreparedStatement statement2 = connection.prepareStatement(sql);
                statement2.setString(1, nombreArticulo);
                statement2.setString(2, nombreFabricante);
                statement2.setDouble(3, precio);
                if (precio < 200) {
                    precio *= 0.1;
                } else if (precio >= 200 && precio < 500) {
                    precio *= 0.08;
                } else if (precio >= 500 && precio < 700) {
                    precio *= 0.06;
                }
                statement2.setDouble(4, precio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createArtFabTable() {
        try (Statement statement = connection.createStatement()) {
            String createArtFabTableQuery = "CREATE TABLE (Nombre_Articulo varchar(50), Nombre_Fabricantes (50), Precio_Articulo int, iva double;";
            statement.executeUpdate(createArtFabTableQuery);
            System.out.println("tabla 'ArtFab' creada con exito");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*public static void updateArtTabTable() {
        String selectQuery = "SELECT * FROM ArtFab";
        try (Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            ResultSet resultSet = statement.executeQuery(selectQuery);
            while (resultSet.next()) {
                int precio = resultSet.getInt("precio");

                if (precio < 200) {
                    resultSet.updateInt("Iva", (int) (precio * 0.1));
                } else if (precio >= 200 && precio < 500) {
                    resultSet.updateInt("Iva", (int) (precio * 0.08));
                } else if (precio >= 500 && precio < 700) {
                    resultSet.updateInt("Iva", (int) (precio * 0.06));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/

    public static void mostrarArtFabTable() {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM ArtFab")) {
            while (resultSet.next()) {
                String nombreArticulo = resultSet.getString(1);
                String nombreFabricante = resultSet.getString(2);
                int precio = resultSet.getInt(3);
                double iva = resultSet.getDouble(4);
                System.out.println("Nombre Artículo: " + nombreArticulo + "Nombre Fabricante: " + nombreFabricante + "Precio: " + precio + "IVA: " + iva);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
