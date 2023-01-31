package Retos2_3_3;

import java.util.Scanner;

/*
3.- Escribir un programa Java que:

Le pida al usuario una frase
Visualice la frase en mayúsculas
Cambia las ‘A’ por ‘*’
Vuelva a visualizar la frase
Visualiza el carácter 0 de la frase

 */
public class Pedir_Caracter {

    public static void main(String[] args) {
        Pedir_Caracter.fraseString();
    }

    static void fraseString() { //metodo que nos comvierte un caracter en los siguientes usos de la clase String  
        Scanner sc = new Scanner(System.in);
        String frase;
        System.out.println("Escriba una frase: ");
        frase = sc.nextLine();
        System.out.println("\n" + frase.toUpperCase());
        System.out.println(frase.replace('a', '*'));
        System.out.println(frase.charAt(0));
    }
}
