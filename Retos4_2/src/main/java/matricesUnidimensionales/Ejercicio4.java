package matricesUnidimensionales;

import java.util.Scanner;

/* Obtener la letra de un DNI, se pedirá el DNI por teclado y se nos devolverá el DNI completo.

Para el cálculo de la letra, se cogerá el resto de dividir el DNI entre 23, el resultado debe estar entre 0 y 22. 
Realizar un método donde reciba el resultado de la anterior fórmula y busque en un array de caracteres la posición que 
corresponde a la letra. Tabla de caracteres:*/
public class Ejercicio4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite número de DNI: ");
        int dni = sc.nextInt();
        int resultado = dni % 23;
        System.out.print(dni);
        idCheck(resultado);
    }

    static void idCheck(int result) {
        char[] charArray = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        for (int i = 0; i < charArray.length; i++) {
            if (result >= 0 && result <= 22) {
                System.out.println(charArray[result]);
                break;
            }
        }
    }
}
