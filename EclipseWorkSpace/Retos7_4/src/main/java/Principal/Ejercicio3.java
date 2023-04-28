package Principal;

import java.io.File;
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

            escribirArchivo(referencias, precios, directorio);

            System.out.println("""
                    ¿Quiere agregar otra referencia?
                    1.Sí
                    0.No""");
            opcion = sc.nextInt();
        } while (opcion != 0);
    }

    /*
     * Actualice los precios de forma que los superiores
     * a 100 euros se decrementen en un 50% y los inferiores se incrementen
     * en un 50%.
     * */
    public static void escribirArchivo(ArrayList<Integer> referencias, ArrayList<Double> precios, String directorio) {
        long posicion = 0;
        String linea;
        int indice = 0;
        long size;

        //Escribir las referencias y precios al archivo desde los Arrays de referencias y precios
        try {
            raf = new RandomAccessFile(directorio, "rw");

            for (int i = 0; i < referencias.size(); i++) {
                raf.writeInt(referencias.get(i));
                raf.writeDouble(precios.get(i));
            }
            mostrar(directorio);
            /*C:\\Users\\Alejandro Vargas\\Desktop\\referencias.txt*/
            size = raf.length();
            size = raf.length() / 8;
            linea = String.valueOf(raf.readDouble());
            raf.seek(0);

            while (raf.getFilePointer() < raf.length()) {
                for (Double i : precios) {
                    if (i > 100) {
                        double mayorque = i;
                        indice = linea.indexOf((int) mayorque);
                        raf.seek(indice * 4L);
                        System.out.println("Valor actual: " + raf.readDouble());
                        raf.seek(indice * 4L);
                        mayorque = i * 0.5;
                        raf.writeDouble(mayorque);
                    } else {
                        double menorque = i;
                        indice = linea.indexOf(5);
                        raf.seek(indice * 4L);
                        System.out.println("Valor actual: " + raf.readDouble());
                        raf.seek(indice * 4L);
                        menorque = i * 1.5;
                        raf.writeDouble(menorque);
                    }
                }
            }
            mostrar(directorio);
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se ha encontrado.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*actualice los precios de forma que los superiores
     * a 100 euros se decrementen en un 50% y los inferiores se incrementen
     * en un 50%.*/
    public static void mostrar(String directorio) {
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
