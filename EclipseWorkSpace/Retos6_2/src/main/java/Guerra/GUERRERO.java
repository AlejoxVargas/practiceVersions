package Guerra;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class GUERRERO extends PERSONAJE implements COMBATE {
    Scanner sc = new Scanner(System.in);
    //Constants
    private final int FUERZA_ATAQUE = 4;
    private int fuerzaAtaque;

    public GUERRERO(String nombre) {
        super(nombre);
        this.fuerzaAtaque = this.FUERZA_ATAQUE;
    }
    //Methods

    public int getFUERZA_ATAQUE() {
        return FUERZA_ATAQUE;
    }

    public int getFuerzaAtaque() {
        return fuerzaAtaque;
    }

    public void setFuerzaAtaque(int fuerzaAtaque) {
        this.fuerzaAtaque = fuerzaAtaque;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void Roba(PERSONAJE aquienseRoba) {
        /**
         * Un guerrero roba material sanitario a un sanitario del equipo contrario o del
         * propio ( si éste estuviera muerto) para dárselo a uno de su propio equipo que esté
         * vivo y que tenga la menor cantidad de material sanitario. El sanitario robado se
         * queda sin material (material=0). El sanitario que recibe el material debe actualizar su
         * cantidad de material */
    }

    @Override
    public void Ataca(PERSONAJE aquienseAtaca) {

        aquienseAtaca.setAcuchillado(true);
        int vida = aquienseAtaca.getVida();
        vida -= this.fuerzaAtaque;
        aquienseAtaca.setVida(vida);
        super.setTiempo(LocalTime.now());
    }
}
