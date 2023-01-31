package Retos2_4;

public class Main {

    public static void main(String[] args) {

        //Declaración de 3 objetos "estudiantes" con nombre y notas
        Estudiante estudiante1 = new Estudiante("Pedro García", 7, 9, 4);
        Estudiante estudiante2 = new Estudiante("Isabel Gonzales", 4, 8, 6);
        Estudiante estudiante3 = new Estudiante("Manuel Martín", 10, 9, 10);

        //Declaración de 3 objetos "estudiante" con solo nombre
        Estudiante estudiante4 = new Estudiante("Javier Jimenez");
        Estudiante estudiante5 = new Estudiante("Alonso Martinez");
        Estudiante estudiante6 = new Estudiante("Pilar López");

        //Declaración de 3 objetos "profesor"
        Profesor profesor1 = new Profesor("Francisco Javier", "Inglés");
        Profesor profesor2 = new Profesor("Ana Flores", "Francés");
        Profesor profesor3 = new Profesor("Teresa Lopez", "Alemán");

        System.out.println("-----------------NOTAS ASIGNADAS-------------------");

        profesor1.ponerNotaIngles(5, estudiante4);
        profesor1.ponerNotaIngles(8, estudiante5);
        profesor1.ponerNotaIngles(10, estudiante6);

        profesor2.ponerNotaFrances(3, estudiante4);
        profesor2.ponerNotaFrances(9, estudiante5);
        profesor2.ponerNotaFrances(7, estudiante6);

        profesor3.ponerNotaAleman(4, estudiante4);
        profesor3.ponerNotaAleman(3.6, estudiante5);
        profesor3.ponerNotaAleman(9.8, estudiante6);

        //Impresion de las nuevas notas asignadas a los estudiantes
        System.out.println(estudiante4.toString());
        System.out.println(estudiante5.toString());
        System.out.println(estudiante6.toString());

        System.out.println("---------------NOTAS MODIFICADAS----------------");

        profesor1.modificarNotaIngles(5, estudiante1);
        profesor2.modificarNotaFrances(10, estudiante2);
        profesor3.modificarNotaAleman(7, estudiante3);

        //Impresion de las notas modificadas, a los estudiantes que fueron creados con notas previamente asignadas
        System.out.println(estudiante1.toString());
        System.out.println(estudiante2.toString());
        System.out.println(estudiante3.toString());

        System.out.println("-------------INFORMACION DE PROFESORES--------------");

        System.out.println(profesor1.toString());
        System.out.println(profesor2.toString());
        System.out.println(profesor3.toString());
    }
}
