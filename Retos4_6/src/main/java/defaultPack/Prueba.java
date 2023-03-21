package defaultPack;

import java.util.Scanner;

public class Prueba {
    static char[][] tablero;
    static char[][] minas;
    static int[][] solucion;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //mostrarTablero();
        iniciarTablero(5,5,5);
    }

    public static void mostrarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print(tablero[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void iniciarTablero(int filas, int columnas, int totalMinas) {
        tablero = new char[filas][columnas];
        minas = new char[filas][columnas];
        solucion = new int[filas][columnas];

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                tablero[i][j] = '-';
            }
        }

        int contadorMinas = 0;

        while (contadorMinas < totalMinas){
            int x = (int) (Math.random() * filas);
            int y = (int) (Math.random() * columnas);
            if (minas[x][y] == '\u0000'){
                minas[x][y] = 'X';
                contadorMinas++;
            }
        }
    }
}
