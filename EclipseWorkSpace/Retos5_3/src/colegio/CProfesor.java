package colegio;

import java.time.LocalDate;
import java.util.Date;

public class CProfesor {
private String psNombre;
private String psApellido1;
private LocalDate pdNacimiento;
private int piDni;
private int piSueldo;
private String psTitulo;

    public CProfesor(String psNombre, String psApellido1, LocalDate pdNacimiento, int piDni, int piSueldo, String psTitulo) {
        this.psNombre = psNombre;
        this.psApellido1 = psApellido1;
        this.pdNacimiento = pdNacimiento;
        this.piDni = piDni;
        this.piSueldo = piSueldo;
        this.psTitulo = psTitulo;
    }

    public String getPsNombre() {
        return psNombre;
    }

    public void setPsNombre(String psNombre) {
        this.psNombre = psNombre;
    }

    public String getPsApellido1() {
        return psApellido1;
    }

    public void setPsApellido1(String psApellido1) {
        this.psApellido1 = psApellido1;
    }

    public LocalDate getPdNacimiento() {
        return pdNacimiento;
    }

    public void setPdNacimiento(LocalDate pdNacimiento) {
        this.pdNacimiento = pdNacimiento;
    }

    public int getPiDni() {
        return piDni;
    }

    public void setPiDni(int piDni) {
        this.piDni = piDni;
    }

    public int getPiSueldo() {
        return piSueldo;
    }

    public void setPiSueldo(int piSueldo) {
        this.piSueldo = piSueldo;
    }

    public String getPsTitulo() {
        return psTitulo;
    }

    public void setPsTitulo(String psTitulo) {
        this.psTitulo = psTitulo;
    }
}
