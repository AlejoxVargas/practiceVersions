package Retos2_4;

public class Profesor {

    //Atributos
    String nombreProfesor, especialidad;

    //Constructor
    public Profesor(String nombreProfesor, String especialidad) {
        this.nombreProfesor = nombreProfesor;
        this.especialidad = especialidad;
    }

    //Metodos para asignar notas
    public void ponerNotaIngles(double notaIngl, Estudiante estudiantex) {
        estudiantex.notaIngles = notaIngl;
    }

    public void ponerNotaFrances(double notaFran, Estudiante estudiantex) {
        estudiantex.notaFrances = notaFran;
    }

    public void ponerNotaAleman(double notaAle, Estudiante estudiantex) {
        estudiantex.notaAleman = notaAle;
    }

    //Metodos para modificar notas
    public void modificarNotaIngles(double notaIngl, Estudiante estudiantex) {
        estudiantex.notaIngles = notaIngl;
    }

    public void modificarNotaFrances(double notaFran, Estudiante estudiantex) {
        estudiantex.notaFrances = notaFran;
    }

    public void modificarNotaAleman(double notaAle, Estudiante estudiantex) {
        estudiantex.notaAleman = notaAle;
    }

    //Metodo para imprimir resultados de los estudiantes
    @Override
    public String toString() {
        return "Nombre Profesor: " + nombreProfesor + "\nEspecialidad: " + especialidad + "\n";
    }

}
