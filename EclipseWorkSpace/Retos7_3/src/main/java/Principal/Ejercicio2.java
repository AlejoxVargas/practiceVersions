package Principal;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.*;

public class Ejercicio2 {
    /*
     * Escribir un programa Java que permita crear secuencialmente
     * un fichero binario que contenga la información de varias personas.
     * Para cada persona se almacenará: nombre, apellido1, apellido2 y
     * año de nacimiento. El nombre y los apellidos tendrán 20 caracteres
     * rellenando con espacios al final para completar la longitud.
     * Leer el fichero
     * */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(in);

        File f;
        FileOutputStream fos = null;
        FileInputStream fis;

        int opcion;

        do {
            PERSONA persona1 = new PERSONA();

            out.println("Nombre: ");
            String nombre = sc.nextLine();
            persona1.setNombre(nombre);
            out.println("Apellido1: ");
            String apellido1 = sc.nextLine();
            persona1.setApellido1(apellido1);
            out.println("Apellido2: ");
            String apellido2 = sc.nextLine();
            persona1.setApellido2(apellido2);
            out.println("Año: ");
            String annio = sc.nextLine();
            persona1.setAnioNacimiento(annio);


            try {
                f = new File("C:\\Users\\ALUMNO CCC - TARDE\\Desktop\\binario.dat");
                fos = new FileOutputStream(f);
                fis = new FileInputStream(f);

                fos.write(nombre.getBytes());
                fos.write(apellido1.getBytes());
                fos.write(apellido2.getBytes());

                ArrayList<Character> contenedor = new ArrayList<>();

                int contenido;

                while ((contenido = fis.read()) != -1) {
                    contenedor.add((char) contenido);
                }
                out.println(contenedor);

                if (contenedor.size() < 20) {
                    for (int i = contenedor.size(); i < 20; i++) {
                        fos.write(" ".getBytes());
                    }
                }
                fos.write(annio.getBytes());

                while ((contenido = fis.read()) != -1) {
                    contenedor.add((char) contenido);
                }
                out.println(contenedor);

                //falta que se puedan crear varias personas en un mismo archivo, ya que lo sobreescribe

            } catch (Exception e) {
                out.println("Error al escribir el archivo");
                throw new RuntimeException(e);
            } finally {
                try {
                    if (fos != null) {
                        fos.close();
                    }
                } catch (Exception e2) {
                    err.println("No se ha podido cerrar");
                }
            }
            out.println("""
                    ¿Quiere agregar a otra persona?
                    1-Sí
                    2-No""");
            opcion = sc.nextInt();
            sc.nextLine();
        } while (opcion != 2);
    }

    public static class PERSONA {

        private String nombre;
        private String apellido1;
        private String apellido2;
        private String AnioNacimiento;

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido1() {
            return apellido1;
        }

        public void setApellido1(String apellido1) {
            this.apellido1 = apellido1;
        }

        public String getApellido2() {
            return apellido2;
        }

        public void setApellido2(String apellido2) {
            this.apellido2 = apellido2;
        }

        public String getAnioNacimiento() {
            return AnioNacimiento;
        }

        public void setAnioNacimiento(String fechaNacimiento) {
            this.AnioNacimiento = fechaNacimiento;
        }

        @Override
        public String toString() {
            return "Nombre: " + getNombre() +
                    "\nApellido1: " + getApellido1() +
                    "\nApellido2: " + getApellido2() +
                    "\nFecha Nacimiento: " + getAnioNacimiento();
        }
    }
}