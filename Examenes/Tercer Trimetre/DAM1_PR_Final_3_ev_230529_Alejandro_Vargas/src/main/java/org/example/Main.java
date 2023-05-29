package org.example;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class Main {
    private static Connection connection;


    private static RandomAccessFile raf;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta para crear el fichero: ");
        String directorio = sc.nextLine();

        //Método para insertar datos al ciudades.bin
        insertarDatosFichero(directorio);
        //Modifica y agrega los datos de las ciudades.bin
        modificarValores(directorio);

        //Crea la base de datos y si existe la elimina
        createDatabase();

        //Crea la tabla Ciudades
        crearBBDDTabla();

        //Insertar datos en 'Ciudades'
        insertDatosBBDD();

        //Muestra la información de la tabla Ciudades
        visualizarBBDD();

    }

    public static void insertarDatosFichero(String directorio) {
        try {
            FileOutputStream fos = new FileOutputStream(directorio + "ciudades.bin");
            DataOutputStream dos = new DataOutputStream(fos);

            Ciudades[] ciudadesData = new Ciudades[5];
            ciudadesData[0] = new Ciudades("Las Rozas", 95071, 35390, 50286, 58.31);
            ciudadesData[1] = new Ciudades("Colmenar Viejo", 48614, 18925, 31360, 182.56);
            ciudadesData[2] = new Ciudades("Tres Cantos", 46046, 14460, 41048, 37.93);
            ciudadesData[3] = new Ciudades("Aranjuez", 58213, 24790, 26386, 201.11);
            ciudadesData[4] = new Ciudades("Fuenlabrada", 194669, 70835, 22092, 39.45);

            //Agregamos los datos sin modificar al archivo 'ciudades.bin'
            for (Ciudades ciudadesDataLeer : ciudadesData) {
                dos.writeUTF(ciudadesDataLeer.getNombre());
                dos.writeInt(ciudadesDataLeer.getPoblacion());
                dos.writeInt(ciudadesDataLeer.getViviendas());
                dos.writeInt(ciudadesDataLeer.getRenta());
                dos.writeDouble(ciudadesDataLeer.getExtension());
                dos.writeDouble(ciudadesDataLeer.getDensidad());
                dos.writeDouble(ciudadesDataLeer.getRiqueza());

                /*C:\\Users\\ALUMNO CCC - TARDE\\Desktop\\*/
            }
            //Leer
            visualizarDatosFichero(directorio);

            System.out.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void modificarValores(String directorio) {
        try {
            raf = new RandomAccessFile(directorio + "ciudades.bin", "rw");
            raf.seek(0);

            while (raf.getFilePointer() < raf.length()) {
                long posicion = raf.getFilePointer();
                String nombre = raf.readUTF();
                int poblacion = raf.readInt();
                int viviendas = raf.readInt();
                int renta = raf.readInt();
                double extension = raf.readDouble();
                double densidad;
                double riqueza;

                //se ejecutan los cambios de valores para los valores agregados
                densidad = poblacion / extension;
                riqueza = renta * poblacion;

                // Volver a la posición anterior para actualizar los datos
                raf.seek(posicion);
                raf.writeUTF(nombre);
                raf.writeInt(poblacion);
                raf.writeInt(viviendas);
                raf.writeInt(renta);
                raf.writeDouble(extension);
                raf.writeDouble(densidad);
                raf.writeDouble(riqueza);
            }
            visualizarDatosFichero(directorio);
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    // Ignore
                }
            }
        }
    }

    public static void visualizarDatosFichero(String directorio) {
        try {
            raf = new RandomAccessFile(directorio + "ciudades.bin", "rw");
            raf.seek(0);

            while (raf.getFilePointer() < raf.length()) {
                String nombre = raf.readUTF();
                int poblacion = raf.readInt();
                int viviendas = raf.readInt();
                int renta = raf.readInt();
                double extension = raf.readDouble();
                double densidad = raf.readDouble();
                double riqueza = raf.readDouble();

                System.out.println("Nombre: " + nombre + ", Poblacion:" + poblacion + ", Viviendas: " + viviendas + ", Renta: " + renta + ", Extension: " + extension + ", Densidad: " + densidad + ", Riqueza: " + riqueza);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static class Ciudades {
        private final String nombre;
        private final int poblacion;
        private final int viviendas;
        private final int renta;
        private final double extension;
        private final double densidad;
        private final double riqueza;

        public Ciudades(String nombre, int poblacion, int viviendas, int renta, double extension) {
            this.nombre = nombre;
            this.poblacion = poblacion;
            this.viviendas = viviendas;
            this.renta = renta;
            this.extension = extension;
            this.densidad = 0;
            this.riqueza = 0;
        }

        public String getNombre() {
            return nombre;
        }

        public int getPoblacion() {
            return poblacion;
        }

        public int getViviendas() {
            return viviendas;
        }

        public int getRenta() {
            return renta;
        }

        public double getExtension() {
            return extension;
        }

        public double getDensidad() {
            return densidad;
        }

        public double getRiqueza() {
            return riqueza;
        }
    }

    public static void createDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try (Statement statement = connection.createStatement()) {
            String dropDataBaseIfExistQuery = "DROP DATABASE IF EXISTS DatosDeCiudades;";
            String createDataBaseQuery = "CREATE DATABASE DatosDeCiudades;";
            String usedDataBaseQuery = "USE DatosDeCiudades";
            statement.executeUpdate(dropDataBaseIfExistQuery);
            statement.executeUpdate(createDataBaseQuery);
            statement.executeUpdate(usedDataBaseQuery);
            System.out.println("Base de datos 'DatosDeCiudades' creada con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void crearBBDDTabla() {
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/DatosDeCiudades", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try (Statement statement = connection.createStatement()) {
            String createCiudadesQuery =
                    "CREATE TABLE Ciudades(" +
                            "Nombre varchar(30)," +
                            "Poblacion int," +
                            "Viviendas int," +
                            "Renta int," +
                            "Extension double" +
                            ")ENGINE=InnoDB";
            statement.executeUpdate(createCiudadesQuery);

            System.out.println("Tabla 'Ciudades' creada con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertDatosBBDD() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/DatosDeCiudades", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try (Statement statement = connection.createStatement()) {
            //Los datos se han insertado de manera manual y no por fichero (aunque este fichero se encuentra completamente funcionable)
            String[] ciudadesData = {
                    "INSERT INTO Ciudades VALUES('Las Rozas',95071,35390,50286,58.31)",
                    "INSERT INTO Ciudades VALUES('Colmenar Viejo',48614,18925,31360,182.56)",
                    "INSERT INTO Ciudades VALUES('Tres Cantos',46046,14460,41048,37.93)",
                    "INSERT INTO Ciudades VALUES('Aranjuez',58213,24790,26386,201.11)",
                    "INSERT INTO Ciudades VALUES('Fuenlabrada',194669,70835,22092,39.45)",
            };

            for (String ciudadData : ciudadesData) {
                statement.executeUpdate(ciudadData);
            }

            System.out.println("Datos insertados con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void visualizarBBDD() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/DatosDeCiudades", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Ciudades")) {
            while (resultSet.next()) {
                String nombreCiudad = resultSet.getString(1);
                int poblacionCiudad = resultSet.getInt(2);
                int viviendasCiudad = resultSet.getInt(3);
                int rentaCiudad = resultSet.getInt(4);
                double extensionCiudad = resultSet.getDouble(5);
                System.out.println("Nombre: " + nombreCiudad + ", Población: " + poblacionCiudad + ", Viviendas: " + viviendasCiudad + ", Renta: " + rentaCiudad + ", Extensión: " + extensionCiudad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}