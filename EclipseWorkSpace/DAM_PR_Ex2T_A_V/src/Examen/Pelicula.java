package Examen;

import java.util.Scanner;

public class Pelicula extends Programa {
    static Scanner sc = new Scanner(System.in);
    private String director;
    private boolean estreno;

    public Pelicula(String nombre, String director, boolean estreno) {
        super(nombre);
        this.director = director;
        this.estreno = estreno;
    }

    public boolean programar(Programa[] escaleta, int hora) {
        boolean llave = false;
        int limite = super.getDuracion();
        int horasCount = 0;


        for (int i = 0; i < 2; i++) { /*recorrre 2 veces según las horas de la pelicula*/
            for (int k = 0; k < 2; k++) { /*verifica que existan dos espacios disponibles*/
                if (super.programar(escaleta, hora)) {
                    horasCount++;
                }
            }
            if (horasCount == 2) { /*si es así entra en este if para saber si el boolean de estreno es v o f*/
                if (this.estreno) {
                    if (hora >= 21 && hora <= 24) { /*si el boolean es V entra en este otro bucle para saber si la hora indicada es entre las 21 y 24 del estreno*/
                        for (int j = 0; j < 2; j++) {
                            escaleta[hora] = this;
                            hora++;
                            llave = true;
                        }
                    }
                } else { /*si no se cumple el boolean de estreno, entonce lo asigna al indice segun la hora indicada */
                    for (int j = 0; j < 2; j++) {
                        escaleta[hora] = this;
                        hora++;
                        llave = true;
                    }
                }
            }
        }
        return llave;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public boolean isEstreno() {
        return estreno;
    }

    public void setEstreno(boolean estreno) {
        String opcion;
        System.out.println("¿Este programa es de estreno?: "); /*pregunta si es estreno y si se puede setear*/
        opcion = sc.nextLine();
        if (opcion.equalsIgnoreCase("si")) {
            this.estreno = true;
        } else {
            this.estreno = false;
        }
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + "\nDirector: " + getDirector() + "\nEstreno: " + isEstreno();
    }
}
