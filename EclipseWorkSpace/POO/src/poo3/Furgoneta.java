package poo3;

public class Furgoneta extends Vehiculo {
	private int capacidadCarga;
	private int plazasExtras;

	public Furgoneta(int capacidadCarga, int plazasExtras) {
		super();
		this.capacidadCarga = capacidadCarga;
		this.plazasExtras = plazasExtras;
	}

	public int getCapacidadCarga() {
		return capacidadCarga;
	}

	public void setCapacidadCarga(int capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}

	public void setPlazasExtras(int plazasExtras) {
		this.plazasExtras = plazasExtras;
	}
	
	public int getPlazasExtras() {
		return plazasExtras;
	}

	
}
