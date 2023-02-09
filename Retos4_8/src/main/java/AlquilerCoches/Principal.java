package AlquilerCoches;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author USUARIO CCC - TARDE
 */
public class Principal {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Coches> alquilados = new ArrayList<>();
        ArrayList<Coches> libres = new ArrayList<>();

        System.out.println("Matricula: ");
        System.out.println("Marca: ");
        System.out.println("Modelo: ");
    }
    public static void Menu() {
        int opcion;
        do {
            System.out.println("""
                    1. Dar de alta
                    2. Alquilar
                    3. Devolver
                    0. Salir                     
                    """);
            opcion = sc.nextInt();
        }while(opcion <0 || opcion > 3);
    }

    public static void insertarCocheArrayList(ArrayList <Coches> miArrayList){
        //miArrayList.add(Coches coche = new Coches("3357 NXX", "Kia","ZK400"));
    }
}
