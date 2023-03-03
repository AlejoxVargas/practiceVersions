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
		double sueldo = ((20 / 100) * this.ventas) + 800;
		return sueldo;
	}

	@Override
	public String getNombreCompleto() {
		return "El Empleado representante: " + this.getNombreCompleto();
	}

}
