package MatricesUnidimensionales;

import java.util.Scanner;

/*Ejercicio 1:

Versión 1: Escribir un programa que lea un entero por teclado y diga si se encuentra en el array números.
Opcional: parar la búsqueda en cuanto se ha encontrado el número.*/
public class Ejercicio1 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] getArray = {12, 15, 13, 10, 8, 9, 13, 14};       
        System.out.println("Enter a number in the array: ");
        int n = sc.nextInt();
        boolean llave = false;
        
        System.out.println("\tInicio del recorrido");       
        for (int i = 0; i < getArray.length; i++) {
            System.out.println("Recorrido: " + getArray[i]); //Imprime la evidencia del paro del recorrido.           
            /*Para cuando el for recorra y encuentre el numero, este mismo imprime hasta donde se encontró dicho número 
            y para su recorrido de busqueda, incluso si hay más indices por leer, esto debido al 
            break dentro de la condición del recorrido y busqueda*/
            if (getArray[i] == n) {
                llave = true;
                break;
            }
        }
        System.out.println("\tParo del recorrido");
        
        if (llave == true) {
            System.out.println("Result: The number was found.");
        } else {
            System.out.println("Result: The number was not found.");
        }
    }
}
