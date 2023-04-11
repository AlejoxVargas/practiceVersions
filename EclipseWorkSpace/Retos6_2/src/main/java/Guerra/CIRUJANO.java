package Guerra;

public class CIRUJANO extends SANITARIO{
    public CIRUJANO(String nombre) {
        super(nombre);
    }

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
     * Un cirujano puede curar a un personaje disparado o acuchillado si tiene
     * material (que no sea nulo). Cuando cura el médico pierde 1/3 de su material. Al curar
     * a un personaje, éste deja de estar acuchillado o , el atributo Tiempo pasa a ser nulo, y
     * la vida se incrementa en 1*/
    }
}
