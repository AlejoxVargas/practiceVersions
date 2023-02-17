package ejercicio1;

public class ProductoRefrigerado extends Producto{
	private int codigoOSA;
	
	public ProductoRefrigerado(int anno, int mes, int dia, int numeroLote, int codigoOSA) {
		super(anno,mes,dia,numeroLote);
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
