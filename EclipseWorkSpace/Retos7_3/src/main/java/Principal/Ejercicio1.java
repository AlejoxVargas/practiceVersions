package Principal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("SpellCheckingInspection")
public class Ejercicio1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Copiafichero(LeerFichero());
    }

    static ArrayList<Integer> LeerFichero() {
        File f;
        FileInputStream fis = null;

        ArrayList<Integer> datos = new ArrayList<>();

        System.out.println("Introduce el nombre de un fichero: ");
        String directorio = sc.nextLine();

        try {
            f = new File(directorio);
            fis = new FileInputStream(f);

            boolean finaliza = false;
            while (!finaliza) {
                int byteEntrada = fis.read();
                if (byteEntrada == -1) {
                    finaliza = true;
                } else {
                    datos.add(byteEntrada);
                }
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (Exception e2) {
                System.err.println("No se ha podido cerrar");
            }
        }
        return datos;
    }

    static void Copiafichero(ArrayList<Integer> datos) {
        FileOutputStream fos = null;

        System.out.println("Introduce el nombre del nuevo fichero: ");
        String directorio = sc.nextLine();
        try {
            File f = new File(directorio);
            fos = new FileOutputStream(f);

            for (Integer dato : datos) {
                fos.write(dato);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (Exception e2) {
                System.err.println("No se ha podido cerrar");
            }
        }
    }
}
