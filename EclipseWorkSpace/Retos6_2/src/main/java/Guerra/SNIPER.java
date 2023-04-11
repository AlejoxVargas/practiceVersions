package Guerra;

public class SNIPER extends PERSONAJE implements COMBATE{
    //Constants
    private final int NUMERO_BALAS = 4;
    private int numeroBalas;

    //Constructor
    public SNIPER(String nombre) {
        super(nombre);
        this.numeroBalas = NUMERO_BALAS;
    }

    //Methods

    public int getNUMERO_BALAS() {
        return NUMERO_BALAS;
    }

    public int getNumeroBalas() {
        return numeroBalas;
    }

    public void setNumeroBalas(int numeroBalas) {
        this.numeroBalas = numeroBalas;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void Roba(PERSONAJE aquienseRoba) {
    /**
     * Un sniper puede robarle las balas a un sniper del bando contrario si ha
     * fallecido. Entonces las balas robadas se añaden a las balas propias. Ell sniper robado
     * se queda sin balas */
    }

    @Override
    public void Ataca(PERSONAJE aquienseAtaca) {
        /**
         * un sniper dispara. Cada vez que dispara pierde una bala. El impacto sobre el
         * personaje atacado es
         *  la vida del atacado se reduce (vida=vida/2)
         *  el atacado pasa a estar disparado.
         *  Se debe actualizar la hora del ataque a la hora actual*/
    }
}
