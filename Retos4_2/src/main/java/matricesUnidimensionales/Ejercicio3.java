package matricesUnidimensionales;

/*3. Realizar un programa que pida al usuario una frase y pase sus caracteres a un array de caracteres. Se podrá realizar con o sin métodos de String.*/
import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {
        /*Versión 1: Se utiliza el método String*/
        Scanner sc = new Scanner(System.in);
        System.out.println("Type a phrase: ");
        String getPhrase = sc.nextLine();
        char[] changePhrase = new char[0];
//        char[] changePhrase = getPhrase.toCharArray();
//
//        for (int i = 0; i < changePhrase.length; i++) {
//            System.out.println("indice: " + i + " contenido: " + changePhrase[i]);
//        }
        cambiarArray(changePhrase, getPhrase);
    }

    /*Versión 2: No se utiliza el método String y creación de un método*/
    static void cambiarArray(char[] changePhrase, String getPhrase) {
        //aqui usar un bucle que me lea todo con charAt y luego me lo pase al array
        System.out.println(getPhrase);
        String contenedor = "";
        for (int i = 0; i < getPhrase.length(); i++) {
            System.out.println(changePhrase[getPhrase.charAt(i)]);
            contenedor += getPhrase.charAt(i);
        }
    }
}
