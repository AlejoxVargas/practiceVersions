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
    static Scanner sc = new Scanner(in);

    public static void main(String[] args) {

        File f;
        FileOutputStream fos = null;
        FileInputStream fis;

        int opcion;
        int contador = 0;
        ArrayList<PERSONA> personas = new ArrayList<>();

        do {
            try {

                f = new File("C:\\Users\\ALUMNO CCC - TARDE\\Desktop\\binario.dat");
                fos = new FileOutputStream(f);
                fis = new FileInputStream(f);

                //ESCRIBIR --> Llama al método 'agregarPersona' para ser almacenado en un ArrayList y escribe con FileOutPutStream la información del objeto
                personas.add(contador, agregarPersona());

                for (PERSONA persona : personas) {
                    fos.write(persona.getNombre().getBytes());
                    fos.write(persona.getApellido1().getBytes());
                    fos.write(persona.getApellido2().getBytes());
                }

                //LEER --> Dentro del ArrayList 'contenedor' almacena en caracteres el contenido que haya leído del fichero el fis(FileInputStream)
                ArrayList<Character> contenedor = new ArrayList<>();
                int contenido;

                while ((contenido = fis.read()) != -1) {
                    contenedor.add((char) contenido);
                }
                out.println(contenedor);

                //Sí el contenido del ArrayList que contiene char es menor que 20, llamará a FileOutputStream y agrega un espacio hasta rellenar el nombre y apellidos hasta 20
                if (contenedor.size() < 20) {
                    for (int i = contenedor.size(); i < 20; i++) {
                        fos.write(" ".getBytes());
                    }
                }
                /*
                * Ahora necesito que el array contenedor me separe los caracteres del segundo objeto ya que los pone todos como si fuera una sola linea
                * */

                //Luego agregamos el dato del año de nacimiento y así no se verá afectado por la regla anterior
                fos.write(personas.get(0).getAnioNacimiento().getBytes());

                while ((contenido = fis.read()) != -1) {
                    contenedor.add((char) contenido);
                }
                out.println(contenedor);

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
            contador++;
        } while (opcion != 2);
    }

    public static class PERSONA {

        private final String nombre;
        private final String apellido1;
        private final String apellido2;
        private final String AnioNacimiento;

        public PERSONA(String nombre, String apellido1, String apellido2, String anioNacimiento) {
            this.nombre = nombre;
            this.apellido1 = apellido1;
            this.apellido2 = apellido2;
            AnioNacimiento = anioNacimiento;
        }

        public String getNombre() {
            return nombre;
        }

        public String getApellido1() {
            return apellido1;
        }

        public String getApellido2() {
            return apellido2;
        }

        public String getAnioNacimiento() {
            return AnioNacimiento;
        }


        @Override
        public String toString() {
            return "Nombre: " + getNombre() +
                    "\nApellido1: " + getApellido1() +
                    "\nApellido2: " + getApellido2() +
                    "\nFecha Nacimiento: " + getAnioNacimiento();
        }
    }

    public static PERSONA agregarPersona() {
        out.println("Nombre: ");
        String nombre = sc.nextLine();
        out.println("Apellido1: ");
        String apellido1 = sc.nextLine();
        out.println("Apellido2: ");
        String apellido2 = sc.nextLine();
        out.println("Año: ");
        String annio = sc.nextLine();
        return new PERSONA(nombre, apellido1, apellido2, annio);
    }
}