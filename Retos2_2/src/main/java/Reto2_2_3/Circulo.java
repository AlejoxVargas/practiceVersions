package Reto2_2_3;

public class Circulo {

    double radioCirculo;

    Circulo(double radCirculo) {
        this.radioCirculo = radCirculo;
    }

    public double calcularArea() {
        return Math.PI * Math.pow(radioCirculo, 2);
    }

    public double cacularPerimetro() {
        return 2 * Math.PI * radioCirculo;
    }

}
