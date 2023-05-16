package Principal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio3 {
    /*
     * 3. Realizar un método que reciba por parámetro el nombre
     * de un fichero que almacena una serie de referencias y precios
     * de artículos y actualice los precios de forma que los superiores
     * a 100 euros se decrementen en un 50% y los inferiores se incrementen
     * en un 50%. El método capturará y tratará todas las excepciones que
     *  puedan producirse.
     * */

    static RandomAccessFile raf = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> referencias = new ArrayList<>();
        ArrayList<Double> precios = new ArrayList<>();

        String directorio;
        int opcion;

        do {
            System.out.println("Referencia del articulo: ");
            referencias.add(sc.nextInt());
            System.out.println("Precio del articulo: ");
            precios.add(sc.nextDouble());
            sc.nextLine();
            System.out.println("Directorio: ");
            directorio = sc.nextLine();

            actualizarPrecios(referencias, precios, directorio);

            System.out.println("""
                    ¿Quiere agregar otra referencia?
                    1.Sí
                    0.No""");
            opcion = sc.nextInt();
        } while (opcion != 0);
    }

    public static void actualizarPrecios(ArrayList<Integer> referencias, ArrayList<Double> precios, String directorio) {
        try {

            raf = new RandomAccessFile(directorio, "rw");

            Escribir(referencias, precios, directorio); //Escribe las referencias y precios

            while (raf.getFilePointer() < raf.length()) {
                int referencia = raf.readInt();
                double precio = raf.readDouble();

                // Actualizar precios según criterio establecido
                if (precio > 100) {
                    precio *= 0.5;
                } else {
                    precio *= 1.5;
                }

                // Volver a escribir el precio actualizado en el archivo
                raf.seek(raf.getFilePointer() - 8);
                raf.writeDouble(precio);
            }
            Mostrar(directorio);
        } catch (IOException e) {
            // Capturar y tratar todas las excepciones
            e.printStackTrace();
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    // Ignore exception
                }
            }
        }
    }

    /*actualice los precios de forma que los superiores
     * a 100 euros se decrementen en un 50% y los inferiores se incrementen
     * en un 50%.*/
    public static void Escribir(ArrayList<Integer> referencias, ArrayList<Double> precios, String directorio) {
        try {
            raf = new RandomAccessFile(directorio, "rw");
            for (int i = 0; i < referencias.size(); i++) {
                raf.writeInt(referencias.get(i));
                raf.writeDouble(precios.get(i));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void Mostrar(String directorio) {
        try {
            raf = new RandomAccessFile(directorio, "rw");
            raf.seek(0);

            while (raf.getFilePointer() < raf.length()) {
                int referencia = raf.readInt();
                double precio = raf.readDouble();
                System.out.println("Referencia: " + referencia + ", Precio: " + precio);
            }

        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se ha encontrado.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
