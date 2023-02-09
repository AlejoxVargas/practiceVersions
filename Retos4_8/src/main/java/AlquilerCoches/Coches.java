package AlquilerCoches;

/**
 *
 * @author USUARIO CCC - TARDE
 */
public class Coches {
    String matricula;
    String marca;
    String modelo;

    public Coches(String matricula, String marca, String modelo) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Matricula: " + this.matricula + "Marca: " + this.marca + "Modelo: " + this.modelo;
    }
}
