package Principal;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Ejercicio2 {
    /*
     * Escribir un programa Java que permita crear secuencialmente
     * un fichero binario que contenga la información de varias personas.
     * Para cada persona se almacenará: nombre, apellido1, apellido2 y
     * año de nacimiento. El nombre y los apellidos tendrán 20 caracteres
     * rellenando con espacios al final para completar la longitud.
     * Leer el fichero
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File f;
        FileOutputStream fos = null;
        ObjectOutputStream salida = null;

        int opcion = 0;
        do {
            PERSONA persona1 = new PERSONA();
            System.out.println("Nombre: ");
            String nombre = sc.nextLine();
            persona1.setNombre(nombre);
            System.out.println("Apellido 1: ");
            String apellido1 = sc.nextLine();
            persona1.setApellido1(apellido1);
            System.out.println("Apellido 2: ");
            String apellido2 = sc.nextLine();
            persona1.setApellido2(apellido2);
            System.out.println("Año: ");
            int annio = sc.nextInt();
            System.out.println("Mes: ");
            int mes = sc.nextInt();
            System.out.println("Día");
            int dia = sc.nextInt();
            LocalDate fechaNacimiento = LocalDate.of(annio,mes,dia);
                persona1.setFechaNacimiento(fechaNacimiento);


            try {
                f = new File("C:\\Users\\ALUMNO CCC - TARDE\\Desktop\\binario.dat");
                fos = new FileOutputStream(f);
                salida = new ObjectOutputStream(fos);
                System.out.println(persona1.toString());
                salida.writeObject(persona1);

            } catch (Exception e) {
                System.out.println("Error al escribir el archivo");
                throw new RuntimeException(e);
            } finally {
                try {
                    if (salida != null) {
                        salida.close();
                    }
                    if (fos != null) {
                        fos.close();
                    }
                } catch (Exception e2) {
                    System.err.println("No se ha podido cerrar");
                }
            }
            System.out.println("""
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
        private LocalDate fechaNacimiento;

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

        public LocalDate getFechaNacimiento() {
            return fechaNacimiento;
        }

        public void setFechaNacimiento(LocalDate fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
        }

        @Override
        public String toString() {
            return "Nombre: " + getNombre() +
                    "\nApellido1: " + getApellido1() +
                    "\nApellido2: " + getApellido2() +
                    "\nFecha Nacimiento: " + getFechaNacimiento();
        }
    }
}