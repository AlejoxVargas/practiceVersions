package poo2;

public class PrincipalEmpleado {

	public static void main(String[] args) {
		Empleado empleado1 = new Empleado("Lorena", 50000, 2022, 1, 14);
		Empleado empleado2 = new Empleado("Alejo", 60000, 2023, 1, 2);
		Empleado empleado3 = new Empleado("Juan Manuel", 40000, 2022, 1, 13);
		empleado1.setSubeSueldo(5);
		empleado2.setSubeSueldo(5);
		empleado3.setSubeSueldo(5);
		System.out.println("Nombre: " + empleado1.getNombre() + " Sueldo: " + empleado1.getSueldo() + " Fecha alta: "
				+ empleado1.getAltaContrato());
		System.out.println("Nombre: " + empleado2.getNombre() + " Sueldo: " + empleado2.getSueldo() + " Fecha alta: "
				+ empleado2.getAltaContrato());
		System.out.println("Nombre: " + empleado3.getNombre() + " Sueldo: " + empleado3.getSueldo() + " Fecha alta: "
				+ empleado3.getAltaContrato());
	}

}
