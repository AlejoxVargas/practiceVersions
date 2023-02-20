package ejercicio1;

import java.time.LocalDate;

public class ProductoCongelado extends Producto {
	private double temperatura;

	public ProductoCongelado(LocalDate fechaCaducidad, int numeroLote, double temperatura) {
		super(fechaCaducidad, numeroLote);
		this.temperatura = temperatura;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public String getDatosCongelados() {
		return "||" + " Temperatura: " + getTemperatura();
	}
}
