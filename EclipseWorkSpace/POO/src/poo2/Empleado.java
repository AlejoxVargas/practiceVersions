package poo2;

import java.util.Date;
import java.util.GregorianCalendar;

public class Empleado {
	private final String nombre;
	private double sueldo;
	private Date altaContrato;
	private String seccion;
	public static int IdSiguiente = 1;
	private int Id;

	public Empleado(String nombre, double sueldo, int anno, int mes, int dia) {
		this.nombre = nombre;
		this.sueldo = sueldo;
		GregorianCalendar calendario = new GregorianCalendar(anno, mes - 1, dia);
		altaContrato = calendario.getTime();
		seccion = "Administración";
		this.Id = IdSiguiente;
		IdSiguiente++;
	}

	public Empleado(String nombre) {
		this(nombre,1000,2000,1,1);
		this.seccion = "Administración";
	}

	public String getNombre() {
		return nombre;
	}

//	public void setNombre(String nombre) {
//		this.nombre = nombre;
//	}

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

	public void setSubeSueldo(double porcentage) {
		double aumento = sueldo * porcentage / 100;
		sueldo += aumento;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getSeccion() {
		return seccion;
	}

	public int getId() {
		return Id;
	}

	public String getDatos() {
		return "Nombre " + getNombre() + " Sueldo " + getSueldo() + " fecha alta" + " Seccion " + getSeccion() + " Identificativo " + getId();
	}

}
