package Guerra;

public class MEDICO extends SANITARIO{
    //Constructor
    public MEDICO(String nombre) {
        super(nombre);
    }

    //Methods
    @Override
    public void Huye() {
        super.Huye();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void Cura(PERSONAJE personaje) {
    /**
     * Un médico puede curar a un personaje acuchillado si tiene material (que no
     * sea nulo). Cuando cura el médico pierde 1/3 de su material. Al curar a un personaje,
     * éste deja de estar acuchillado, el atributo Tiempo pasa a ser nulo, y la vida se
     * incrementa en 1. */
    }
}
