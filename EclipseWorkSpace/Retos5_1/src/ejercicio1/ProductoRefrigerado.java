package ejercicio1;

import java.time.LocalDate;

public class ProductoRefrigerado extends Producto {
	private int codigoOSA;

	public ProductoRefrigerado(LocalDate fechaCaducidad, int numeroLote, int codigoOSA) {
		super(fechaCaducidad, numeroLote);
		this.codigoOSA = codigoOSA;
	}

	public int getCodigoOSA() {
		return codigoOSA;
	}

	public void setCodigoOSA(int codigoOSA) {
		this.codigoOSA = codigoOSA;
	}

	public String getDatosRefrigerado() {
		return "||" + " Código de supervision alimentaria" + getCodigoOSA();
	}
}
