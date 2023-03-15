package Gestion;

import java.time.LocalDate;

public class EmpProduccion extends Empleado implements Riesgo {
    private int unidadesProducidas;
    private boolean productoRiesgo;

    public EmpProduccion(String nombre, String apellido, int edad, LocalDate fechaEntrada) {
        super(nombre, apellido, edad, fechaEntrada);
    }

    public int getUnidadesProducidas() {
        return unidadesProducidas;
    }

    public void setUnidadesProducidas(int unidadesProducidas) {
        this.unidadesProducidas = unidadesProducidas;
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
        double sueldo = this.unidadesProducidas * 5;
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
        return "Empleado producción: " + super.getNombreCompleto();
    }

}
