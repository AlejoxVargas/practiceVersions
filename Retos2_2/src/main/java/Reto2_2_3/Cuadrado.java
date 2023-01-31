package Reto2_2_3;

public class Cuadrado {

    double ladoCuadrado;

    Cuadrado(double ladCuadrado) {
        this.ladoCuadrado = ladCuadrado;
    }

    public double calcularArea() {
        return Math.pow(ladoCuadrado, 2);
    }
    
    public double calcularPerimetro() {
        return 4 * ladoCuadrado;
    }

}
