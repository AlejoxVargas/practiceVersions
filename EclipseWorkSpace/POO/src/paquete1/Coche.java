package paquete1;

public class Coche {
	private int ruedas;
	private int largo, ancho;
	private int motor;
	private int peso;
	private String color;
	private boolean asientos_cuero;

	public String getDatos() {
		return "Coche con ruedas: " + ruedas
		+ "largo: " + largo 
		+ "ancho: " + ancho 
		+ "motor: " + motor 
		+ "peso: " + peso;
	}
	
	public void setRuedas(int ruedas) {
		this.ruedas = ruedas;
	}
	public int getRuedas(){
		return this.ruedas;
	}
	
	public void setColor (String color) {
		this.color = color;
	}
	
	public String getColor () {
		return this.color;
	}
	
	public void configurarAsientos(String asientosCuero) {
		if (asientosCuero.equalsIgnoreCase("Si")) {
			this.asientos_cuero = true;
		}else {
			this.asientos_cuero = false;
		}
	}
	
	public String getAsientos() {
		if ()
	}
	
}
