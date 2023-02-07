package com.mycompany.retos4_7;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*2. Crear un programa que use un ArrayList de números float. El programa deberá mostrar un menú donde se pueda agregar un número,
buscar un número, modificar un número, eliminar un número e insertar un número en una posición específica*/
public class Ejercicio2 {
    static Scanner sc = new Scanner(System.in);
    static Random rnd = new Random();
    static ArrayList<Float> valNumeric = new ArrayList<>();


    public static void main(String[] args) {
        MenuArray();
    }
    public static int MenuArray() {
        int opcion;
        do {
            System.out.println("""
                    \tCRUD
                    ----------------
                    1.Agregar Número
                    2.Buscar Número
                    3.Modificar Número
                    4.Eliminar Número
                    5.Insertar Número
                    0.Salir
                    """);
            opcion = sc.nextInt();
        } while (opcion < 0 || opcion >6);
        return 0;
    }
    public static ArrayList FillArrayList (ArrayList <Float> arrayList){
        float random;
        for(float iterador : arrayList){
            random = rnd.nextFloat();
            arrayList.add(random);
        }
        return  arrayList;
    }
    public static float AddNumArrayList (ArrayList <Float> arrayList){
        float addNew;
        System.out.println("add new one");
        addNew = sc.nextFloat();
        arrayList.add(addNew);
        return addNew;
    }
}
