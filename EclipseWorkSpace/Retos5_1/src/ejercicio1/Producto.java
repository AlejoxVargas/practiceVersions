package ejercicio1;

import java.util.Date;
import java.util.GregorianCalendar;

public class Producto {
	private Date fechaCaducidad;
	private int numeroLote;
	
	public Producto(int año, int mes, int dia, int numeroLote) {
		GregorianCalendar calendario = new GregorianCalendar(año,mes,dia);
		this.fechaCaducidad = calendario.getTime();
		this.numeroLote = numeroLote;
	}

	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public int getNumeroLote() {
		return numeroLote;
	}

	public void setNumeroLote(int numeroLote) {
		this.numeroLote = numeroLote;
	}
	
	public String getDatos() {
		return "Fecha de Caducidad: " + getFechaCaducidad() +" || "+ " Numero de lote: " + getNumeroLote();
	}
}
