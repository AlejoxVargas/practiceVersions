package empresa;

public class Becarios extends Empleados {
	private String contrato;

	public Becarios(String nombre, double sueldo, String contrato) {
		super(nombre, sueldo);
		this.contrato = contrato;
	}

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}
	@Override
	public String toString() {
		return "\nNombre: " + getNombre() + "\nSueldo: " + getSueldo() + "\nContrato: " + getContrato();
	}
}
