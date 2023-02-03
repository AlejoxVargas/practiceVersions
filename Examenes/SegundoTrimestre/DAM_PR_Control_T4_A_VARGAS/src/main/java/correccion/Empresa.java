package correccion;
//15:33 - 16:09

/**
 *
 * @author USUARIO CCC - TARDE
 */
public class Empresa {

    //Methods 
    String nombre;
    int numEmpleados;
    float beneficios;

    public Empresa(String nombre, int numEmpleados, float beneficios) {
        this.nombre = nombre;
        this.numEmpleados = numEmpleados;
        this.beneficios = beneficios;
    }

    @Override
    public String toString() {
        return "Empresa{ nombre " + this.nombre + " , Número empleados = " + this.numEmpleados + ", Beneficios = " + this.beneficios + "}";
    }
}
