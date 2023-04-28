package Principal;

import java.io.*;
import java.util.ArrayList;

public class Ejercicio1 {
    public static void main(String[] args) {
        ArrayList<Casa> casas = new ArrayList<>();
        casas.add(new Casa("Calle Mayor", "2A", 3, "Madrid", 28001, 100, 3));
        casas.add(new Casa("Plaza del Sol", "5B", 2, "Madrid", 28013, 80, 2));
        casas.add(new Casa("Calle del Carmen", "3C", 1, "Barcelona", 8001, 70, 2));
        casas.add(new Casa("Calle de la Princesa", "4D", 2, "Madrid", 28008, 90, 2));
        casas.add(new Casa("Rambla de Cataluña", "6E", 4, "Barcelona", 8007, 120, 4));

        // Escribir los datos de las casas en un fichero
        try (ObjectOutputStream escribiendo = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Alejandro Vargas\\Desktop\\serializar.dat"))) {
            escribiendo.writeObject(casas);
        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero: " + e.getMessage());
        }

        // Leer los datos de las casas desde el fichero
        try (ObjectInputStream leyendo = new ObjectInputStream(new FileInputStream("C:\\Users\\Alejandro Vargas\\Desktop\\serializar.dat"))) {
            ArrayList<Casa> casasLeidas = (ArrayList<Casa>) leyendo.readObject();
            for (Casa i : casasLeidas) {
                System.out.println(i.toString());
            }
        } catch (IOException | ClassNotFoundException e) {
            // Fin de fichero alcanzado, no hay más objetos
            System.err.println("Error al leer del fichero: " + e.getMessage());
        }
    }

    public static class Casa implements Serializable {
        private String direccion;
        private String portal;
        private int piso;
        private String localidad;
        private int codigoPostal;
        private double metrosCuadrados;
        private int numeroHabitaciones;

        public Casa(String direccion, String portal, int piso, String localidad, int codigoPostal, double metrosCuadrados, int numeroHabitaciones) {
            this.direccion = direccion;
            this.portal = portal;
            this.piso = piso;
            this.localidad = localidad;
            this.codigoPostal = codigoPostal;
            this.metrosCuadrados = metrosCuadrados;
            this.numeroHabitaciones = numeroHabitaciones;
        }
        @Override
        public String toString() {
            return "Direction: " + direccion + " Portal: " + portal + " Piso: " + piso + " Localidad: " + localidad + " Código Postal: " + codigoPostal + " Metros Cuadrados: " + metrosCuadrados + " Número de Habitaciones: " + numeroHabitaciones;
        }
    }
}
