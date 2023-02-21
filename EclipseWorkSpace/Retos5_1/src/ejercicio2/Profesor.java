package ejercicio2;

public class Profesor {

    private String nombre;
    private int edad;
    private int annosConsolidados;

    public Profesor(String nombre, int edad, int añosConsolidados) {
        this.nombre = nombre;
        this.edad = edad;
        this.annosConsolidados = añosConsolidados;
    }

    public double obtenerSalarioBase() {
        double salarioBase = 1100 + annosConsolidados * 50;
        return salarioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getAnnosConsolidados() {
        return annosConsolidados;
    }

    public void setAnnosConsolidados(int annosConsolidados) {
        this.annosConsolidados = annosConsolidados;
    }

    public String getDatos() {
        return "Nombre: " + getNombre()
                + "\nEdad: " + getEdad()
                + "\nAños Consolidados: " + getAnnosConsolidados()
                + "\nSalario Base: " + obtenerSalarioBase();
    }
}
