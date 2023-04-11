package Guerra;

public abstract class SANITARIO extends PERSONAJE implements HUIDA {
    //Constants
    private final int MATERIAL_INICIAL = 25;

    //Attributes
    private int material;

    //Constructor
    public SANITARIO(String nombre) {
        super(nombre);
        this.material = MATERIAL_INICIAL;
    }

    //Methods
    public int getMATERIAL_INICIAL() {
        return MATERIAL_INICIAL;
    }

    public int getMaterial() {
        return material;
    }

    public void setMaterial(int material) {
        this.material = material;
    }

    @Override
    public void Huye() {
        /**
         * Huye(): Cuando un sanitario huye tiene un 33% de posibilidades de perder los
         * zapatos. En ese caso, el atributo Calzado pasa al valor false.
         * */
    }

    public abstract void Cura(PERSONAJE personaje);

    @Override
    public String toString() {
        return super.toString() + "\nMaterial: " + getMaterial();
    }
}
