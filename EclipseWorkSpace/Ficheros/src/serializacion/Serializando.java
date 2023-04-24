package serializacion;

import java.util.*;
import java.io.*;

public class Serializando {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Administrador jefe = new Administrador("Jose", 40000, 2012, 3, 15 );
        jefe.setIncentivo(5000);
        
        Empleado[] personal = new Empleado[3];
        personal[0] = jefe;
        personal[1] = new Empleado("Elena", 27000, 2007, 11, 2);
        personal[2] = new Empleado("Pedro", 25000, 2009, 2, 7);
        
        ObjectOutputStream escribiendo = new ObjectOutputStream(new FileOutputStream("C:\\Users\\ALUMNO CCC - TARDE\\Desktop\\serializar.dat"));
        escribiendo.writeObject(personal);
        escribiendo.close();
        
        ObjectInputStream leyendo = new ObjectInputStream(new FileInputStream("C:\\Users\\ALUMNO CCC - TARDE\\Desktop\\serializar.dat"));
        Empleado [] personal_recuperado = (Empleado[]) leyendo.readObject(); //tambien lo podriamos volver a meter en el array de personal, no hay problema
        leyendo.close();
        for (Empleado  emp : personal_recuperado) {
        	System.out.println(emp);
        }
    }
}

class Empleado implements Serializable{
    private String nombre;
    private double sueldo;
    private Date fechaContrato;
    public Empleado(String n, double s, int anho, int mes, int dia) {
        nombre = n;
        sueldo = s;
        GregorianCalendar calendario = new GregorianCalendar( anho, mes-1, dia);
        fechaContrato = calendario.getTime();
    }
    public String getNombre() {
        return nombre;
    }
    public double getSueldo() {
        return sueldo;
    }
    public Date getFechaContrato() {
        return fechaContrato;
    }
    public void subirSueldo(double porcentaje) {
        double aumento = sueldo * porcentaje/100;
        sueldo += aumento;
    }
        @Override
    public String toString() {
        return "Nombre: " + nombre + ". Sueldo: " + sueldo + ". Fecha Contrato: " + fechaContrato;
    }
}

class Administrador extends Empleado{
    private double incentivo;
    public Administrador(String n, double s, int anho, int mes, int dia) {
        super(n,s,anho,mes,dia);
        incentivo=0;
    }
    public double getSueldo() {
        double sueldoBase = super.getSueldo();
        return sueldoBase + incentivo;
    }
    public void setIncentivo(double b) {
        incentivo=b;
    }
        @Override
    public String toString() {
        return super.toString() + ". Incentivo: " + incentivo;
    }
}
