package ejercicio2;

public class Profesor {

	private String nombre;
	private int edad;
	private int añosConsolidados;

	public Profesor(String nombre, int edad, int añosConsolidados) {
		this.nombre = nombre;
		this.edad = edad;
		this.añosConsolidados = añosConsolidados;
	}

	public double obtenerSalarioBase() {
		double salarioBase = 1100 + añosConsolidados * 50;
		return salarioBase;
	}
}
