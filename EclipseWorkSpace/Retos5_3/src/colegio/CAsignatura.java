package colegio;

public class CAsignatura {
private int piCodigo;
private String psNombre;
private CProfesor poProfesor;
private int pihorasSemanales;

    public CAsignatura(int piCodigo, String psNombre, CProfesor poProfesor, int pihorasSemanales) {
        this.piCodigo = piCodigo;
        this.psNombre = psNombre;
        this.poProfesor = poProfesor;
        this.pihorasSemanales = pihorasSemanales;
    }

    public int getPiCodigo() {
        return piCodigo;
    }

    public void setPiCodigo(int piCodigo) {
        this.piCodigo = piCodigo;
    }

    public String getPsNombre() {
        return psNombre;
    }

    public void setPsNombre(String psNombre) {
        this.psNombre = psNombre;
    }

    public CProfesor getPoProfesor() {
        return poProfesor;
    }

    public void setPoProfesor(CProfesor poProfesor) {
        this.poProfesor = poProfesor;
    }

    public int getPihorasSemanales() {
        return pihorasSemanales;
    }

    public void setPihorasSemanales(int pihorasSemanales) {
        this.pihorasSemanales = pihorasSemanales;
    }
}
