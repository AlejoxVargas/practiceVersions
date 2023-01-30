package Instituto;

import java.time.LocalDate;

public class grupo {
    //Attributes
    String nombre;
    int planta ;
    alumno[] alumno = new alumno[5];

    //Constructors
    public grupo(String nombre, int planta) {
        this.nombre = nombre;
        this.planta = planta;
    }

    public grupo() {
    }
}
