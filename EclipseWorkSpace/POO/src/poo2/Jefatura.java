package poo2;

public class Jefatura extends Empleado implements Jefes{
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

	@Override
	public String tomarDecisionees(String decision) {
		return "Un miembro de direccion a tomado la decision: " + decision;
	}

	@Override
	public double estableceBonus(double gratificacion) {
		double prima = 2000;
		return Trabajadores.bonusBase + gratificacion + prima;
	}
	
}
