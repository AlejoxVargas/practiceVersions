package POO4;

public class Rectangulo extends FormasGeometricasAbstracto {
	private double altura;
	private double base;

	Rectangulo(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}

	@Override
	public double calcularArea() {
		double area = this.altura * this.base;
		return area;
	}

	@Override
	public double calcularPerimetro() {
		double perimetro = (this.altura * 2) + (this.base * 2);
		return perimetro;
	}
}
