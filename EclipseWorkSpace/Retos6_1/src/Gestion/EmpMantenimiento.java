package Gestion;

import java.time.LocalDate;

public class EmpMantenimiento extends Empleado implements Riesgo {
    private int horasTrabajadas;
    private boolean productoRiesgo;

    public EmpMantenimiento(String nombre, String apellido, int edad, LocalDate fechaEntrada) {
        super(nombre, apellido, edad, fechaEntrada);
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public boolean getProductoRiesgo() {
        return this.productoRiesgo;
    }

    public void setProductoRiesgo(String productoRiesgo) {
        if (productoRiesgo.equalsIgnoreCase("si")) {
            this.productoRiesgo = true;
        } else {
            this.productoRiesgo = false;
        }
    }

    @Override
    public double calcularSueldo() {
        double sueldo = this.horasTrabajadas * 5;
        if (this.productoRiesgo) {
            sueldo += Riesgo.prima;
        }
        return sueldo;
    }

    public double getSueldo() {
        return calcularSueldo();
    }

    @Override
    public String getNombreCompleto() {
        return "Empleado mantenimiento:\n " + super.getNombreCompleto() + "\n";
    }

}
