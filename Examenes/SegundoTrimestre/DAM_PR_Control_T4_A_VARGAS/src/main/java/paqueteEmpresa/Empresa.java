package paqueteEmpresa;

/**
 *
 * @author USUARIO CCC - TARDE
 */
public class Empresa {
    //Attributes

    String nombre;
    int numeroEmpleados;
    float beneficios;

    //Constructor
    public Empresa(String nombre, int numeroEmpleados, float beneficios) {
        this.nombre = nombre;
        this.numeroEmpleados = numeroEmpleados;
        this.beneficios = beneficios;
    }    
    
    //toString
    @Override
    public String toString() {
        return "Nombre Empresa: " + this.nombre
                + "\nNúmero empleados: " + this.numeroEmpleados
                + "\nBeneficios: " + this.beneficios;
    }
}
