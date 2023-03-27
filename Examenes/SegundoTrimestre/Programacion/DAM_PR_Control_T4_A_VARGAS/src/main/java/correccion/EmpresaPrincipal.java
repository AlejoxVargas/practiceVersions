package correccion;

import java.util.Scanner;

/**
 *
 * @author USUARIO CCC - TARDE
 */
public class EmpresaPrincipal {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int numEmpresas;
        System.out.println("Número de empresas: ");
        numEmpresas = sc.nextInt();
        int suma = 0;
        float media;
        float benMax = 0;
        int indiceEmpMaxBeneficio = 0;

        Empresa[] empresas = new Empresa[numEmpresas];
        int[] empresaMaxBeneficio = new int[numEmpresas];

        for (int i = 0; i < empresas.length; i++) {
            String nombre;
            int numEmpleados;
            float beneficios;

            System.out.println("Nombre Empresa " + (i + 1));
            nombre = sc.nextLine();
            System.out.println("Número de empleados " + (i + 1));
            numEmpleados = sc.nextInt();
            System.out.println("Beneficio de la empresa " + (i + 1));
            beneficios = sc.nextFloat();
            empresas[i] = new Empresa(nombre, numEmpleados, beneficios);
            System.out.println(empresas[i]);

            suma = suma + empresas[i].numEmpleados;

            if (benMax < empresas[i].beneficios) {
                benMax = empresas[i].beneficios;
                indiceEmpMaxBeneficio = 0;
                empresaMaxBeneficio[indiceEmpMaxBeneficio] = i;
                indiceEmpMaxBeneficio++;
            }
        }
        media = (float) suma / empresas.length;
        System.out.println("Media de empleados: " + media);

        System.out.println("El mayor beneficio es " + benMax + " euros de: " + empresas[indiceEmpMaxBeneficio].nombre);
        while (indiceEmpMaxBeneficio>=0){
            System.out.print((indiceEmpMaxBeneficio==0)? "y":"");
            System.out.print(empresas[empresaMaxBeneficio[indiceEmpMaxBeneficio]].nombre + " ");
            indiceEmpMaxBeneficio--;
        }       
    }
}
