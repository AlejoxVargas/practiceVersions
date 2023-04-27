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
        BufferedReader br;

        int opcion;
        int contador = 0;
        String linea;
        int finalLinea = 0;

        ArrayList<PERSONA> personas = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        do {
            try {

                f = new File("C:\\Users\\Alejandro Vargas\\Desktop\\binario.dat");
                fos = new FileOutputStream(f);
                fis = new FileInputStream(f);
                br = new BufferedReader(new InputStreamReader(fis));

                //ESCRIBIR --> Llama al método 'agregarPersona' para ser almacenado en un ArrayList y escribe con FileOutPutStream la información del objeto
                personas.add(contador, agregarPersona());

                for (PERSONA persona : personas) {
                    fos.write(persona.getNombre().getBytes());
                    fos.write(persona.getApellido1().getBytes());
                    fos.write(persona.getApellido2().getBytes());
                    int total = persona.getNombre().length() + persona.getApellido1().length() + persona.getApellido2().length();
                    // Sí la variable 'total' que contiene la longitud de los campos es menor que 20, entonces agrega un espacio hasta == 20
                    if (total < 20) {
                        for (int i = total; i < 20; i++) {
                            fos.write(" ".getBytes());
                        }
                    }
                    // Luego agregamos el campo de año
                    fos.write(persona.getAnioNacimiento().getBytes());
                    // Salto de linea
                    fos.write("\n".getBytes());
                }

                //Lectura con StringBuilder que almacena en las líneas que haya leído el buffer

                while ((linea = br.readLine()) != null) {
                    //sb.append(linea);
                    //finalLinea = linea.length();
                    //sb.append("\n");*/
                    if (!linea.isEmpty() && !sb.toString().contains(linea)) {
                        out.println(sb.toString());
                    }
                }
                out.println(sb.toString());

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