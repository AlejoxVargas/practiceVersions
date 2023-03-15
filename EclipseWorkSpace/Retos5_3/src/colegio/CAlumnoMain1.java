package colegio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class CAlumnoMain1 {
    public static void main(String[] args) {
        ArrayList<CAsignatura> grupoAsignaturas = new ArrayList<CAsignatura>();
        CAlumno[] grupoAlumnos = new CAlumno[3];
        int [] nota = {0,0};

        CProfesor Manuel = new CProfesor("Manuel", "Santana", LocalDate.of(1980, 1, 1), 4767, 1000, "Informatica");
        CProfesor Carolina = new CProfesor("Carolina", "Ruiz", LocalDate.of(1981, 2, 2), 5678, 2000, "Informatica");
        CProfesor Javier = new CProfesor("Javier", "Rodríguez", LocalDate.of(1982, 3, 3), 6789, 3000, "CiberSeguridad");

        grupoAsignaturas.add(new CAsignatura(11, "Java", Manuel, 8));
        grupoAsignaturas.add(new CAsignatura(22, "Marcas", Carolina, 4));
        grupoAsignaturas.add(new CAsignatura(33, "Entornos", Javier, 3));

        grupoAlumnos[0] = new CAlumno("Pedro", "Santana", LocalDate.of(2001, 12, 3), 1234, grupoAsignaturas, nota);
        grupoAlumnos[1] = new CAlumno("María", "Ruiz",LocalDate.of(2011,11,4),1234);
        grupoAlumnos[2] = new CAlumno("Esther","Rodríguez", LocalDate.of(1999,10,5),3456);
    }
}
