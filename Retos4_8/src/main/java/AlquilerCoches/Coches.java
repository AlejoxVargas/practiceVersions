package AlquilerCoches;

/**
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

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    @Override
    public String toString() {
        return "Matricula: " + this.matricula + " Marca: " + this.marca + " Modelo: " + this.modelo;
    }
}
