package com.mycompany.tema1;
/*
El lunes un granjero recoge 100 huevos, el martes 121 huevos y el miércoles 117 huevos.
Calcular la media diaria
¿Cuántos huevos se estima que puede recoger en un mes de 30 días?
Si obtiene unos beneficios de 0,18€ por huevo, ¿cuál será el beneficio en un mes?
*/

public class RETO1_4 {
    public static void main(String[] args) {
        int lunes=100, martes=121, miercoles= 117;
        int mediaDiaria = (lunes + martes + miercoles)/3;
        int mediaMensual = mediaDiaria*30;
        double beneficio = mediaDiaria*0.18;
        double beneficio2 = beneficio*30;
        /*
        double beneficio = mediaDiaria/0.18;
        double beneficio2 = beneficio*30;
        */
        System.out.println("La media diaría es de: " + mediaDiaria + " huevos ");
        System.out.println("La media mensual es de: " + mediaMensual + " huevos " );
        System.out.println("El beneficio en un mes es de: " + beneficio2 + "€");  
    }
}
