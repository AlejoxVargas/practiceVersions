package ejercicio1;

import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

public class Producto {
	private LocalDate fechaCaducidad;
	private int numeroLote;

	public Producto(LocalDate fechaCaducidad, int numeroLote) {
		this.fechaCaducidad = fechaCaducidad;
		this.numeroLote = numeroLote;
	}

	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public int getNumeroLote() {
		return numeroLote;
	}

	public void setNumeroLote(int numeroLote) {
		this.numeroLote = numeroLote;
	}

	public String getDatos() {
		return "||" + " Fecha de Caducidad: " + getFechaCaducidad() + "||" + " Numero de lote: " + getNumeroLote();
	}
}
