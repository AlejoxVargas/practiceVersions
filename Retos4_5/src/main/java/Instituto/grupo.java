package Instituto;

import java.time.LocalDate;
import java.util.Arrays;

public class grupo {
    String nombre;
    int planta ;
     alumno[] alumnos;
    //Constructors
    public grupo(String nombre, int planta) {
        this.nombre = nombre;
        this.planta = planta;
        alumnos = new alumno[2];
    }

    public asignarAlumno(alumno alumnox) {
        boolean llave = false;
        for(int i = 0; i < alumn
    }

    @Override
    public String toString() {
        return "Grupo: " + this.nombre + "Planta: " + this.planta + Arrays.toString(alumnos);
    }
}
