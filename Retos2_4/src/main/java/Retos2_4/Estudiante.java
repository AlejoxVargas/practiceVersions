package Retos2_4;

import java.text.DecimalFormat;

public class Estudiante {

    //Atributos
    String nombreEstudiante;
    double notaIngles, notaFrances, notaAleman, notaMedia;

    //Constructor
    public Estudiante(String nombreEstudiante, double notaIngles, double notaFrances, double notaAleman) {
        this.nombreEstudiante = nombreEstudiante;
        this.notaIngles = notaIngles;
        this.notaFrances = notaFrances;
        this.notaAleman = notaAleman;
    }

    //Constructor 2
    public Estudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    //Metodos
    public double calcularMedia() {
        notaMedia = (notaIngles + notaFrances + notaAleman) / 3;
        return notaMedia;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("##.##");
        return "Nombre de Estudiante: " + nombreEstudiante + "\nNota de Inglés: " + notaIngles + "\nNota Francés: " + notaFrances + "\nNota Aleman: " + notaAleman + "\nNota Media: " + df.format(calcularMedia()) + "\n";
    }
}
