package Gestion;

import java.time.LocalDate;

public class EmpRepresentantes extends Empleado {
    private int ventas;

    public EmpRepresentantes(String nombre, String apellido, int edad, LocalDate fechaEntrada) {
        super(nombre, apellido, edad, fechaEntrada);
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    @Override
    public double calcularSueldo() {
        return (float) (this.ventas * 100 / 20) + 800;
    }

    public double getSueldo() {
        return calcularSueldo();
    }

    @Override
    public String getNombreCompleto() {
        return "Empleado representante:\n " + super.getNombreCompleto() + "\n";
    }

}
