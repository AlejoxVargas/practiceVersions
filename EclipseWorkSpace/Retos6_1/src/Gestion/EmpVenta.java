package Gestion;

import java.time.LocalDate;

public class EmpVenta extends Empleado {

	private int ventas;

	EmpVenta(String nombre, String apellido, int edad, LocalDate fechaEntrada) {
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
		return (float) (this.ventas * 100 / 20) + 400;
	}
	public double getSueldo() {
		return calcularSueldo();
	}

	@Override
	public String getNombreCompleto() {
		return "El Empleado de ventas: " + this.getNombreCompleto();
	}
}
