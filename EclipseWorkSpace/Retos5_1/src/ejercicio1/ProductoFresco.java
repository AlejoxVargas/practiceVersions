package ejercicio1;

import java.util.Date;
import java.util.GregorianCalendar;

public class ProductoFresco extends Producto {
	private Date fechaEnvasado;
	private String paisOrigen;

	public ProductoFresco(int anno, int mes, int dia, int numeroLote, String paisOrigen) {
		super(anno, mes, dia, numeroLote);
		GregorianCalendar calendario = new GregorianCalendar(anno, mes, dia); // LocalDate
		this.fechaEnvasado = calendario.getTime();
		this.paisOrigen = paisOrigen;
	}

	public Date getFechaEnvasado() {
		return fechaEnvasado;
	}

	public void setFechaEnvasado(Date fechaEnvasado) {
		this.fechaEnvasado = fechaEnvasado;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	public String getDatosFresco() {
		return "||" + " Fecha envasado: " + getFechaEnvasado() + " || "+" País Origen: " + getPaisOrigen();
	}

}
