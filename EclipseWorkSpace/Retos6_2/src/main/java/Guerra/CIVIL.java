package Guerra;

public class CIVIL extends PERSONAJE implements HUIDA {
    //Constructor
    public CIVIL(String nombre) {
        super(nombre);
    }

    //Methods
    @Override
    public void Huye() {
        /**Cuando un civil huye tiene un 50% de posibilidades de perder los zapatos.
         En ese caso, el atributo Calzado pasa al valor false*/
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
