package Examen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Programa {
    private String nombre;
    private int duracion;

    public Programa(String nombre, int duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public Programa(String nombre) {
        this.nombre = nombre;
        this.duracion = 2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public boolean programar(Programa[] escaleta, int hora) {
        boolean huecoDisponible = false;
        if (escaleta[hora] == null) {
            huecoDisponible = true;
        } else {
            huecoDisponible = false;
        }
        return huecoDisponible;
    }

    @Override
    public String toString() {
        return "\nNombre: " + getNombre() + "\nDuración: " + getDuracion();
    }
}
