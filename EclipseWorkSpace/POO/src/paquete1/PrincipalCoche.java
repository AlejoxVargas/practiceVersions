package paquete1;

public class PrincipalCoche {
	public static void main(String[] args) {
		Coche renault = new Coche();	
		System.out.println("Coche con: " + renault.getRuedas() + " ruedas");
		renault.setRuedas(10);
		System.out.println("Coche con: " + renault.getRuedas() + " ruedas");
	}
}
