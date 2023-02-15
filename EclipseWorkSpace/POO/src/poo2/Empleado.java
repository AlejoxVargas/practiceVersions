package poo2;

import java.util.Date;
import java.util.GregorianCalendar;

public class Empleado {
	private String nombre;
	private double sueldo;
	private Date altaContrato;

	public Empleado(String nombre, double sueldo, int anno, int mes, int dia) {
		super();
		this.nombre = nombre;
		this.sueldo = sueldo;
		GregorianCalendar calendario = new GregorianCalendar(anno, mes - 1, dia);
		altaContrato = calendario.getTime();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public Date getAltaContrato() {
		return altaContrato;
	}

	public void setAltaContrato(int anno, int mes, int dia) {
		GregorianCalendar calendario = new GregorianCalendar(anno, mes - 1, dia);
		altaContrato = calendario.getTime();
	}
	
	public void setSubeSueldo (double porcentage) {
		double aumento = sueldo * porcentage/100;
		sueldo += aumento;
	}

}
