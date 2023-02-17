package poo2;

public class Jefatura extends Empleado {
	private double incentivo;

	public Jefatura(String nombre, double sueldo, int anno, int mes, int dia) {
		super(nombre, sueldo, anno, mes, dia);
	}

	public void setIncentivo(double incentivo) {
		this.incentivo = incentivo;
	}

	public double getIncentivo() {
		return incentivo;
	}
	
	public double getSueldo() {
		double sueldoJefe = super.getSueldo();
		return sueldoJefe + incentivo;
	}
	
}
