package Retos2_3_1_y_2_3_2;

import java.util.Scanner;

/*1.- Añadir el método Transferir a la clase Cuenta. El método Transferir recibe como parámetros:

Un objeto Cuenta destinataria de la transferencia
Una cantidad de dinero a transferir
El método saca de la cuenta origen (objeto sobre el que se está aplicando el método) la cantidad a transferir y se la añade a la cuenta destino.
Se desarrollarán dos versiones de este método (hay que comentar uno de ellos para que no aparezcan bombas rojas, errores en el código):

Versión 1: no utiliza otros métodos de la clase
Versión 2: utiliza otros métodos de la clase Cuenta.
Llamar a este método desde el main.
 */

 /*
2.- Añadir a la clase Cuenta , el nombre del titular de la cuenta.
Modificar el método toString() para que visualice también este atributo.
Añadir un método que permita cambiar el titular de una cuenta .
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double valorTransferencia; //Recolecta valor de la transferencia del usuario desde scanner y lo manda al metodo como parametro
        String nombreTitular; //recolecta el nuevo nombre del titular desde el main

        //Objetos
        Cuenta CuentaPrincipal = new Cuenta("Alejandro Vargas", 784657892, 1825);
        Cuenta CuentaDestino1 = new Cuenta("Javier Fernández", 458986589, 975);

        System.out.println("Sus datos de cuenta son:\n" + CuentaPrincipal.toString());
        System.out.println("\nDatos de cuenta destino:\n" + CuentaDestino1.toString());
        System.out.println("\nEscriba valor a transferir: ");
        valorTransferencia = sc.nextDouble();

        //Resultado Final
        System.out.println("Su saldo ahora es de: " + CuentaPrincipal.retirar2(valorTransferencia) + "$");
        /*System.out.println("Saldo en cuenta destino ahora: " + CuentaPrincipal.transferir1(valorTransferencia, CuentaDestino1));*/ //utilización de metodo que utiliza otros metodos de la clase, puesto en comentario para que no aparezcan bombas de error
        System.out.println("Saldo en cuenta destino ahora: " + CuentaPrincipal.transferir2(valorTransferencia, CuentaDestino1) + "$"); //utilización de Metodo que no utiliza otros metodos

        //Utilización de metodos para cambio de nombre de titular
        System.out.println("\nIntroduzca el nuevo nombre del titular: ");
        sc.nextLine();
        nombreTitular = sc.nextLine();
        CuentaPrincipal.cambiarTitular(nombreTitular);
        System.out.println("\nLos nuevos datos son:\n" + CuentaPrincipal.toString());
    }
}
