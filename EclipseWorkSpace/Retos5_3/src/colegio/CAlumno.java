package colegio;

import java.time.LocalDate;
import java.util.Date;

public class CAlumno {
private String psNombre;
private String psApellido1;
private LocalDate pdNacimiento;
private String piDni;
private CAsignatura[] paoAsignatura;
private int [] paiNota;

    public CAlumno(String psNombre, String psApellido1, LocalDate pdNacimiento, String piDni, CAsignatura[] paoAsignatura, int[] paiNota) {
        this.psNombre = psNombre;
        this.psApellido1 = psApellido1;
        this.pdNacimiento = pdNacimiento;
        this.piDni = piDni;
        this.paoAsignatura = paoAsignatura;
        this.paiNota = paiNota;
    }

    public String getPsNombre() {
        return psNombre;
    }

    public void setPsNombre(String psNombre) {
        this.psNombre = psNombre;
    }

    public String getPsApellido() {
        return psApellido1;
    }

    public void setPsApellido(String psApellido) {
        this.psApellido1 = psApellido;
    }

    public LocalDate getPdNacimiento() {
        return pdNacimiento;
    }

    public void setPdNacimiento(LocalDate pdNacimiento) {
        this.pdNacimiento = pdNacimiento;
    }

    public String getPiDni() {
        return piDni;
    }

    public void setPiDni(String piDni) {
        this.piDni = piDni;
    }

    public CAsignatura[] getPaoAsignatura() {
        return paoAsignatura;
    }

    public void setPaoAsignatura(CAsignatura[] paoAsignatura) {
        this.paoAsignatura = paoAsignatura;
    }

    public int[] getPaiNota() {
        return paiNota;
    }

    public void setPaiNota(int[] paiNota) {
        this.paiNota = paiNota;
    }
}
