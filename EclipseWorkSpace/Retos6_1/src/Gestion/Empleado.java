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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public abstract double calcularSueldo();

    public String getDatos() {
        return this.nombre + "--" + this.apellido + "--" + this.edad + "--" + this.fechaEntrada;
    }
}
