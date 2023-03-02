package POO4;

public class Circulo extends FormasGeometricasAbstracto {
	private double radio;

	Circulo(double radio) {
		this.radio = radio;
	}

	@Override
	public double calcularArea() {
		double area = Math.PI * Math.pow(this.radio, 2);
		return area;
	}

	@Override
	public double calcularPerimetro() {
		double perimetro = Math.PI * 2 * this.radio;
		return perimetro;
	}
}
