package paquete1;

public class Coche {
	private int ruedas;
	private int largo, ancho;
	private int motor;
	private int peso_plataforma;
	private int peso_total;
	private String color;
	private boolean asientos_cuero, climatizador;
	int precioTotal = 10000;

	public Coche() {
		ruedas = 4;
		largo = 2000;
		ancho = 300;
		motor = 1600;
		peso_plataforma = 500;
		color = "rojo";
		asientos_cuero = false;
		climatizador = false;
	}

	public String getDatos() {
		return "Coche con ruedas: " + ruedas + " largo: " + largo + " ancho: " + ancho + " motor: " + motor
				+ " peso plataforma: " + peso_plataforma + " color: " + color + " " + getPesoTotalCoche() + " precio: "
				+ precioCoche();
	}

	public void setRuedas(int ruedas) {
		this.ruedas = ruedas;
	}

	public int getRuedas() {
		return this.ruedas;
	}

	public void setLargo(int largo) {
		this.largo = largo;
	}

	public int getLargo() {
		return this.largo;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAncho() {
		return this.ancho;
	}

	public void setMotor(int motor) {
		this.motor = motor;
	}

	public int getMotor() {
		return this.motor;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return this.color;
	}

	public void setAsientos(String asientosCuero) {
		if (asientosCuero.equalsIgnoreCase("Si")) {
			this.asientos_cuero = true;
		} else {
			this.asientos_cuero = false;
		}
	}

	public String getAsientos() {
		if (asientos_cuero = true) {
			return "Coche con asientos de cuero";
		} else {
			return "Coches sin asientos de cuero";
		}
	}

	public void setClimatizador(String opcionClimatizador) {
		if (opcionClimatizador.equalsIgnoreCase("Si")) {
			this.climatizador = true;
		} else {
			this.climatizador = false;
		}
	}

	public String getClimatizador() {
		if (climatizador) {
			return "Coche con climatizador";
		} else {
			return "Coche sin climatizador";
		}
	}

	public String getPesoTotalCoche() {
		int pesoCarroceria = 500;
		peso_total = pesoCarroceria + peso_plataforma;
		if (asientos_cuero) {
			peso_total += 50;
		}
		if (climatizador) {
			peso_total += 20;
		}
		return "peso: " + peso_total;
	}

	public int precioCoche() {
		int precioTotal = 10000;
		if (asientos_cuero) {
			precioTotal += 1000;
		}
		if (climatizador) {
			precioTotal += 500;
		}
		return precioTotal;
	}
}