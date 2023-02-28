package empresa;

public class Jefes extends Empleado {
	private double prima;

	public Jefes(String nombre, double sueldo, double prima) {
		super(nombre, sueldo);
		this.prima = prima;
	}

	public double getPrima() {
		return prima;
	}

	public void setPrima(double prima) {
		this.prima += super.getSueldo() + prima;
	}

	public double getSueldo() {
		return super.getSueldo();
	}

	@Override
	public String toString() {
		return super.toString() + "Prima: " + getPrima() + "\n";
	}
}
