package Retos2_2_5;

public class Circulo {

    double radioCirculo;

    Circulo(double radio) {
        this.radioCirculo = radio;
    }

    public double calcularaArea() {
        return Math.PI * Math.pow(radioCirculo, 2);

    }

    public double calcularPerimetro() {
        return 2 * Math.PI * radioCirculo;
    }
}
