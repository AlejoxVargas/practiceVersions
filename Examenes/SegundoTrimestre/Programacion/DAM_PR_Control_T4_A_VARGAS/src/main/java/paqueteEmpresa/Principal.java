package paqueteEmpresa;

import java.util.Scanner;

/**
 *
 * @author USUARIO CCC - TARDE
 */
public class Principal {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Cantidad de empresas a registrar: ");
        int CANTIDAD = sc.nextInt();

        int[] empresas = new int[CANTIDAD];
        int[] empleadosMedia = new int[CANTIDAD];
        float[] beneficioArray = new float[CANTIDAD];

        for (int i = 0; i < empresas.length; i++) {
            sc.nextLine();
            System.out.println("Nombre de la empresa: ");
            String nombre = sc.nextLine();

            System.out.println("Numero de empleados de la empresa: ");
            int numeroEmpleados = sc.nextInt();
            empleadosMedia[i] = numeroEmpleados;

            System.out.println("Beneficios de la empresa: ");
            float beneficios = sc.nextFloat();
            beneficioArray[i] = beneficios;

            registrarEmpresa(nombre, numeroEmpleados, beneficios, empresas);
        }

        mediaEmpleados(empleadosMedia);
        mayorBeneficio(beneficioArray);
    }

    static void registrarEmpresa(String nombre, int numeroEmpleados, float beneficios, int[] empresas) {
        for (int i = 0; i < empresas.length; i++) {
            Empresa empresaAux = new Empresa(nombre, numeroEmpleados, beneficios);
            System.out.println(empresaAux.toString());
        }
    }

    static void mediaEmpleados(int[] numeroEmpleados) {
        int media = 0;
        for (int i = 0; i < numeroEmpleados.length; i++) {
            media = media + numeroEmpleados[i];
        }
        System.out.println("La media de empleados es: " + media / numeroEmpleados.length);
    }

    static void mayorBeneficio(float[] beneficio) {
        boolean llave = false;
        float mayor = beneficio[0];
        for (int i = 0; i < beneficio.length; i++) {
            if (beneficio[i] > mayor) {
                mayor = beneficio[i];
            } else if (beneficio[i] == mayor) {
                llave = true;
            }
        }
        if (llave == true) {
            System.out.println("Hay más de una empresa con el beneficio máximo");
        } else {
            System.out.println("El mayor beneficio es: " + mayor);
        }
    }
}
