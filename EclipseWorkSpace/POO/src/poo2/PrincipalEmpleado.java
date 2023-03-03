package poo2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PrincipalEmpleado {

	public static void main(String[] args) {

//		Empleado empleado1 = new Empleado("Lorena", 50000, 2022, 1, 14);
//		Empleado empleado2 = new Empleado("Alejo", 60000, 2023, 1, 2);
//		Empleado empleado3 = new Empleado("Juan Manuel", 40000, 2022, 1, 13);
//		empleado1.setSubeSueldo(5);
//		empleado2.setSubeSueldo(5);
//		empleado3.setSubeSueldo(5);

		Empleado[] misEmpleados = new Empleado[6];

		misEmpleados[0] = new Empleado("Lorena");
		misEmpleados[1] = new Empleado("Alejo");
		misEmpleados[2] = new Empleado("Juan Manuel");

//		System.out.println("Nombre: " + empleado1.getNombre() + " Sueldo: " + empleado1.getSueldo() + " Fecha alta: "
//				+ empleado1.getAltaContrato());
//		System.out.println("Nombre: " + empleado2.getNombre() + " Sueldo: " + empleado2.getSueldo() + " Fecha alta: "
//				+ empleado2.getAltaContrato());
//		System.out.println("Nombre: " + empleado3.getNombre() + " Sueldo: " + empleado3.getSueldo() + " Fecha alta: "
//				+ empleado3.getAltaContrato());

		System.out.println("Nombre: " + misEmpleados[0].getNombre() + " Id: " + misEmpleados[0].getId());
		System.out.println("Nombre: " + misEmpleados[1].getNombre() + " Id: " + misEmpleados[1].getId());
		System.out.println("Nombre: " + misEmpleados[2].getNombre() + " Id: " + misEmpleados[2].getId());

		Jefatura jefeRRHH = new Jefatura("Mónica", 10000, 2022, 1, 3);
		jefeRRHH.setIncentivo(1000);
		misEmpleados[3] = jefeRRHH;
		System.out.println("Jefe: " + misEmpleados[3].getDatos() + " Incentivo "
				+ ((Jefatura) misEmpleados[3]).getIncentivo() + " o " + jefeRRHH.getIncentivo());

		misEmpleados[4] = new Jefatura("Guadalupe", 13000, 2015, 2, 2);
		misEmpleados[5] = new Jefatura("Adrian", 13000, 2015, 2, 2);


		for (Empleado e : misEmpleados) {
			System.out.println("Nombre: " + e.getNombre() 
			+ " id: " + e.getId()
			+ " Sueldo " + e.getSueldo() 
			+ " seccion " + e.getSeccion());
		}
		
		//refundición de clases 
		Arrays.sort(misEmpleados);
		System.out.println("---------------");
		
		System.out.println(jefeRRHH.tomarDecisionees("Dar mas dias de descanso"));
		System.out.println("El jefe: " + jefeRRHH.getNombre() + " Tiene un bonus de : " + jefeRRHH.estableceBonus(500));
		System.out.println("El empleado: " + misEmpleados[1].getNombre() + " Tiene un bonus de : " +  misEmpleados[1].estableceBonus(1000));
	}

}
