package Guerra;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class PERSONAJE {
    //Constants
    private final int VIDA_INICIAL = 10;
    private final int MINUTOS = 5;

    //Attributes
    private String nombre;
    private Boolean calzado;
    private int vida;
    private boolean acuchillado;
    private boolean disparado;
    private LocalTime tiempo;

    //Constructor

    public PERSONAJE(String nombre) {
        this.nombre = nombre;
        this.calzado = true;
        this.vida = VIDA_INICIAL;
        this.acuchillado = false;
        this.disparado = false;
        this.tiempo = null;
    }

    //Methods
    public int getVIDA_INICIAL() {
        return VIDA_INICIAL;
    }

    public int getMINUTOS() {
        return MINUTOS;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getCalzado() {
        return calzado;
    }

    public void setCalzado(Boolean calzado) {
        this.calzado = calzado;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public boolean isAcuchillado() {
        return acuchillado;
    }

    public void setAcuchillado(boolean acuchillado) {
        this.acuchillado = acuchillado;
    }

    public boolean isDisparado() {
        return disparado;
    }

    public void setDisparado(boolean disparado) {
        this.disparado = disparado;
    }

    public LocalTime getTiempo() {
        return tiempo;
    }

    public void setTiempo(LocalTime tiempo) {
        this.tiempo = tiempo;
    }

    //toString
    @Override
    public String toString() {
        return "Nombre: " + getNombre()
                + "\nCalzado: " + getCalzado()
                + "\nVida: " + getVida()
                + "\nAcuchillado: " + isAcuchillado()
                + "\nDisparado: " + isDisparado()
                + "\nTiempo: " + getTiempo();
    }
}
