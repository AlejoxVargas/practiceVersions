package com.mycompany.retos3_2;

import java.util.Scanner;

/*4. Escribir un método que reciba una hora, unos minutos y unos segundos; y devuelva el resultado de sumarle un segundo.*/
public class Retos3_2_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("hora: ");
        int hora = sc.nextInt();
        System.out.println("minutos: ");
        int minutos = sc.nextInt();
        System.out.println("segundos: ");
        int segundos = sc.nextInt();
        Retos3_2_4.sumarSegundo(hora, minutos, segundos);

    }

    public static void sumarSegundo(int hora, int minutos, int segundos) {
        if (segundos >59) {
            segundos = 0;
            minutos++;
        }
        if(minutos>59){
            minutos=0;
            hora++;
        }
        if (hora>23){
            hora=0;
        } 
        System.out.println("resultado: " + hora + " " + minutos+ " " + segundos);
    }
}
