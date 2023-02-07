package defaultPack;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int fila, columna, randonFila, randomColumna;
        int[][] buscaMinas = new int[5][5];

        for (int i = 0; i < buscaMinas.length; i++) {
            //Arrays.fill(buscaMinas[i],random);

            for (int j = 0; j < buscaMinas[i].length; j++) {
                random.nextInt(6);
                buscaMinas[i][j] = random.nextInt(6);
            }

        }
        for (int i = 0; i < buscaMinas.length; i++) {
            for (int j = 0; j < buscaMinas[i].length; j++) {
                System.out.print(buscaMinas[i][j]);
            }
            System.out.println();
        }
        do {
            System.out.println("Ingrese número de fila entre 0-5 ");
            fila = sc.nextInt();
        }while (fila < 0 || fila > 5);

        do {
            System.out.println("Ingrese número de columna entre 0-5 ");
            columna = sc.nextInt();
        }while (columna < 0 || columna > 5);
    }
}
