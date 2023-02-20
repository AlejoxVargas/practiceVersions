package ejercicio1;

import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

public class ProductoFresco extends Producto {
	private LocalDate fechaEnvasado;
	private String paisOrigen;

	public ProductoFresco(LocalDate fechaCaducidad, int numeroLote, LocalDate fechaEnvasado, String paisOrigen) {
		super(fechaCaducidad, numeroLote);
		this.fechaEnvasado = fechaEnvasado;
		this.paisOrigen = paisOrigen;
	}

	public LocalDate getFechaEnvasado() {
		return fechaEnvasado;
	}

	public void setFechaEnvasado(LocalDate fechaEnvasado) {
		this.fechaEnvasado = fechaEnvasado;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	public String getDatosFresco() {
		return "||" + " Fecha envasado: " + getFechaEnvasado() + "||" + " País Origen: " + getPaisOrigen();
	}

}
