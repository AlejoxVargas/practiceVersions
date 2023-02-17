package ejercicio1;

public class ProductoCongelado extends Producto{
	private double temperatura;
	
	public ProductoCongelado(int anno, int mes, int dia, int numeroLote, double temperatura) {
		super(anno,mes,dia,numeroLote);
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
