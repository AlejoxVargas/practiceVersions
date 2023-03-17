package Examen;

import java.util.Scanner;

public class Documental extends Programa {
    static Scanner sc = new Scanner(System.in);
    private String tema;
    private boolean redifusion;

    public Documental(String nombre, int duracion, String tema, boolean redifusion) {
        super(nombre, duracion);
        this.tema = tema;
        this.redifusion = redifusion;
    }

    public boolean programar(Programa[] escaleta, int hora) {
        boolean llave = false; /*para mas información, este mismo se encuentra explicado pero en la parte de pelicula*/
        int limite = super.getDuracion();
        int horas = 0;

        for (int i = hora; i <= limite; i++, horas++) {
            if (super.programar(escaleta, hora)) {
                if (horas == limite) {
                    if (this.redifusion) {
                        escaleta[hora] = this;
                        llave = true;
                    } else {
                        if (hora >= 10 && hora <= 18) {
                            for (int j = hora; j <= limite; j++) {
                                escaleta[j] = this;
                                llave = true;
                            }
                        } else {
                            llave = false;
                        }
                    }
                    if (getTema().equalsIgnoreCase("violencia")) {
                        if (hora >= 0 && hora <= 5) {
                            for (int j = hora; j <= limite; j++) {
                                escaleta[j] = this;
                                llave = true;
                            }
                        } else {
                            llave = false;
                        }
                    }
                } else {
                    llave = false;
                }
            } else {
                llave = false;
            }
        }
        return llave;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public boolean isRedifusion() {
        return redifusion;
    }

    public void setRedifusion(boolean redifusion) {
        String opcion;
        System.out.println("¿Este programa es de redifusión?: ");
        opcion = sc.nextLine();
        if (opcion.equalsIgnoreCase("si")) {
            this.redifusion = true;
        } else {
            this.redifusion = false;
        }
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + "\nDuración: " + getDuracion() + "\nTema: " + getTema() + "\nRedifusion: " + isRedifusion();
    }
}
