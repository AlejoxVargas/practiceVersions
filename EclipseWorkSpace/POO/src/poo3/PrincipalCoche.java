package poo3;

public class PrincipalCoche {
	public static void main(String[] args) {
		Vehiculo renault = new Vehiculo();
		System.out.println("Coche con: " + renault.getRuedas() + " ruedas");
		renault.setRuedas(3);
		System.out.println("Coche con: " + renault.getRuedas() + " ruedas" + "color: " + renault.getColor());
		renault.setColor("amarillo");
		System.out.println("Coche con: " + renault.getRuedas() + " ruedas" + " color: " + renault.getColor());
		renault.setClimatizador("si");
		renault.setAsientos("si");
		System.out.println(renault.getDatos());
		System.out.println(renault.getAsientos());
		System.out.println("----------------------HERENCIA------------------------");
		Furgoneta miFurgoneta = new Furgoneta(580, 7);
		miFurgoneta.setColor("Rojo");
		miFurgoneta.setRuedas(4);
		miFurgoneta.setClimatizador("no");
		miFurgoneta.setCapacidadCarga(700);
		miFurgoneta.setPlazasExtras(5);
		System.out.println("Mi furgoneta: " + miFurgoneta.getDatos());
		System.out.println("Plazas extra: " + miFurgoneta.getPlazasExtras() + " capacidad de carga: " + miFurgoneta.getCapacidadCarga());
		//seguir la regla de "es un" para saber quien hereda de quien
	}
}
