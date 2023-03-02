package POO4;

public class Triangulo extends FormasGeometricasAbstracto { //Aquí tambien se puede usar implement (interfaces) con distintos metodos
	private double altura;
	private double base;

	Triangulo(double base) {
		this.base = base;
	}

	Triangulo(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}

	@Override
	public double calcularArea() {
		double area = (this.base * this.altura) / 2;
		return area;
	}

	@Override
	public double calcularPerimetro() {
		double perimetro = this.base * 3;
		return perimetro;
	}
}
