package ejercicio2;

public class ProfesorEmerito extends Profesor {
    private int añosEmerito;

    public ProfesorEmerito(String nombre, int edad, int añosConsolidados, int añosEmerito) {
        super(nombre, edad, añosConsolidados);
        this.añosEmerito = añosEmerito;
    }

    public double obtenerSalarioBase() {
        double salarioBase = super.obtenerSalarioBase() + (60 * añosEmerito);
        return salarioBase;
    }

    public int getAñosEmerito() {
        return añosEmerito;
    }

    public void setAñosEmerito(int añosEmerito) {
        this.añosEmerito = añosEmerito;
    }
    public String getDatos() {
        return "Nombre: " + getNombre()
                + "\nEdad: " + getEdad()
                + "\nAños Consolidados: " + getAnnosConsolidados()
                + "\nSalario Base: " + obtenerSalarioBase()
                + "\nAños Emerito: " + getAñosEmerito();
    }
}
