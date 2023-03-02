package empresa;

public class Jefes extends Empleado {
    private double prima;

    public Jefes(String nombre, double sueldo, double prima) {
        super(nombre, sueldo);
        this.prima = prima;
    }

    public double getPrima() {
        return prima;
    }

    public void setPrima(double prima) {
        this.prima = prima;
    }

    public double getSueldo() {
        return super.getSueldo() + this.prima;
    }

    @Override
    public String toString() {
        return super.toString() + "Prima: " + getPrima() + "\nSueldo + Prima: " + this.getSueldo() + "\n";
    }
}
