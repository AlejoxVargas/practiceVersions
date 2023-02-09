package com.mycompany.retos4_7;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*2. Crear un programa que use un ArrayList de números float. El programa deberá mostrar un menú donde se pueda agregar un número,
buscar un número, modificar un número, eliminar un número e insertar un número en una posición específica*/
public class Ejercicio2 {

    static Scanner sc = new Scanner(System.in);
    static Random rnd = new Random();
    static DecimalFormat df = new DecimalFormat("##.##");
    static ArrayList<Float> valNumeric = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(FillArrayListByRandom(valNumeric));
        boolean llave = true;       
        do {
            switch (MenuArrayList()) {
                case 1 ->
                    AddNumArrayList(valNumeric);
                case 2 ->
                    FindNumArrayList(valNumeric);
                case 3 ->
                    AlterNumArrayList(valNumeric);
                case 4 ->
                    deleteNumArrayList(valNumeric);
                case 5 ->
                    AddSpecifyingIndex(valNumeric);
                case 0 ->
                    llave = false;
            }
        } while (llave);
    }

    //Main menu for the project, using CRUD as a model
    public static int MenuArrayList() {
        int opcion;
        do {
            System.out.println("""
                          CRUD
                    ----------------
                    1.Create / Add
                    2.Recover
                    3.Update
                    4.Delete
                    5.Add by specifying
                    0.Exit
                    """);
            opcion = sc.nextInt();
            if (opcion < 0 || opcion > 6) {
                System.out.println("Wrong option");
            }
        } while (opcion < 0 || opcion > 6);
        return opcion;
    }

    //Specific method for filling with a several count of random digits into the ArrayList
    public static ArrayList FillArrayListByRandom(ArrayList<Float> arrayList) {
        //pedirle al usuario el tamaño del arrayList (size)
        //pedirle al usuario la longitud de los randoms que vayan de 0 a N num
        //tambien podria pedir la cantidad de decimales
        Float random;
        do {
            random = rnd.nextFloat(10);
            arrayList.add(Float.valueOf(df.format(random)));
        } while (arrayList.size() <= 5);
        return arrayList;
    }

    //Method for adding a new float number into the ArrayList
    public static void AddNumArrayList(ArrayList<Float> arrayList) {
        float addNew;
        System.out.println("Add a new one");
        addNew = sc.nextFloat();
        arrayList.add(addNew);
        System.out.println(arrayList);
    }

    //Using indexOf to find a number in the amount
    public static void FindNumArrayList(ArrayList<Float> arrayList) {
        float findNum;
        System.out.println("Type a number to find");
        findNum = sc.nextFloat();
        System.out.println(findNum + " It's in the position  " + arrayList.indexOf(findNum));
    }

    //Works to pass through the ArrayList a float to modify and as a result established"
    public static void AlterNumArrayList(ArrayList<Float> arrayList) {
        float getNum, setNum;
        System.out.println("Pass a float to get");
        getNum = sc.nextFloat();
        System.out.println("Pass a float to set");
        setNum = sc.nextFloat();
        arrayList.set(arrayList.indexOf(getNum), setNum);
        System.out.println(arrayList);
    }

    //Used to erase a specific figure inside the ArrayList account 
    public static void deleteNumArrayList(ArrayList<Float> arrayList) {
        float delNum;
        System.out.println("Number to eliminate/remove");
        delNum = sc.nextFloat();
        arrayList.remove(delNum);
        System.out.println(arrayList);
    }

    //Working for overwrite an number by specifying an index
    public static void AddSpecifyingIndex(ArrayList<Float> arrayList) {
        int getIndex;
        float setIndex;
        System.out.println("Index to overwrite");
        getIndex = sc.nextInt();
        System.out.println("Number to add");
        setIndex = sc.nextFloat();
        arrayList.set(getIndex, setIndex);
        System.out.println(arrayList);
    }
}
