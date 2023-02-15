package paquete1;

public class PrincipalCoche {
	public static void main(String[] args) {
		Coche renault = new Coche();
		System.out.println("Coche con: " + renault.getRuedas() + " ruedas");
		renault.setRuedas(3);
		System.out.println("Coche con: " + renault.getRuedas() + " ruedas" + "color: " + renault.getColor());
		renault.setColor("amarillo");
		System.out.println("Coche con: " + renault.getRuedas() + " ruedas" + " color: " + renault.getColor());
		renault.setClimatizador("si");
		renault.setAsientos("si");
		System.out.println(renault.getDatos());
		System.out.println(renault.getAsientos());
	}
}
