package matricesUnidimensionales;

/*3. Realizar un programa que pida al usuario una frase y pase sus caracteres a un array de caracteres. 
Se podrá realizar con o sin métodos de String.*/
import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type a phrase: ");
        String caracteres = sc.nextLine();

        char[] cadenaVersion1 = new char[caracteres.length()];
        char[] cadenaVersion2 = caracteres.toCharArray();

        cambiarVersion1(cadenaVersion1, caracteres);
        System.out.println();
        cambiarVersion2(cadenaVersion2, caracteres);
    }
    //Método donde no se utiliza el método String
    //Ciclo for para leer todos los caracteres de la cadena y asignarlos al array de caracteres uno por uno
    static void cambiarVersion1(char[] arregloX, String phrase) {
        System.out.println("\t***Versión 1 sin método String***");
        for (int i = 0; i < phrase.length(); i++) {
            arregloX[i] = phrase.charAt(i);
            System.out.println("índice: " + i + " contenido: " + arregloX[i]);
        }
    }
    //Método donde sí, se utiliza el método String
    //String en un array de caracteres usando el String toCharArray()
    static void cambiarVersion2(char[] arregloX, String phrase) {
        System.out.println("\t***Versión 2 con método String***");
        for (int i = 0; i < arregloX.length; i++) {
            System.out.println("índice: " + i + " contenido: " + arregloX[i]);
        }
    }
}
