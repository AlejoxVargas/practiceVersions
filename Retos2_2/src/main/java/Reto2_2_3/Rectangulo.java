package Reto2_2_3;

public class Rectangulo {

    double anchoRectangulo, altoRectangulo;

    Rectangulo (double anchoRectangulo, double altoRectangulo) {
        this.anchoRectangulo = anchoRectangulo;
        this.altoRectangulo = altoRectangulo;
    }

    //Metodos
    public double calcularArea() {
        return altoRectangulo * anchoRectangulo;

    }

    public double cacularPerimetro() {
        return 2 * (altoRectangulo + anchoRectangulo);
    }

}
