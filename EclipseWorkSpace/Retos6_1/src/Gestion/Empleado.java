package Gestion;

import java.time.LocalDate;

public abstract class Empleado {
    private String nombre;
    private String apellido;
    private int edad;
    private LocalDate fechaEntrada;

    public Empleado(String nombre, String apellido, int edad, LocalDate fechaEntrada) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fechaEntrada = fechaEntrada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public abstract double calcularSueldo();

    public String getNombreCompleto() {
        return "\nNombre: " + this.nombre + "\nApellido: " + this.apellido;
    }
}
