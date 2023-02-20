package ejercicio2;

public class ProfesorEmerito extends Profesor {
	private int añosEmerito;

	public ProfesorEmerito(String nombre, int edad, int añosConsolidados, int añosEmerito) {
		super(nombre, edad, añosConsolidados);
		this.añosEmerito = añosEmerito;
	}
	
	public double obtenerSalarioBase() {
		double salarioBase = super.obtenerSalarioBase() + (60*añosEmerito);
		return salarioBase;
	}
}
