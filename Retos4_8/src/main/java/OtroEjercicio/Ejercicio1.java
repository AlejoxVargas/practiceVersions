package OtroEjercicio;
import java.util.ArrayList;

/**
 *
 * @author USUARIO CCC - TARDE
 */
public class Ejercicio1 {

    public static void main(String[] args) {
        /*Cree una lista (arrayList) de cadenas de caracteres*/
        ArrayList<String> arrayList = new ArrayList<>();

        System.out.println("Inserte las cadenas PHP, Java, C++, Python y visualice la lista con un for");
        arrayList.add("PHP");
        arrayList.add("Java");
        arrayList.add("C++");
        arrayList.add("Python");
        showArray(arrayList);

        System.out.println("Inserte Pascal en la primera posición y visualice de nuevo la lista (Pascal, PHP, Java, C++, Python)");
        arrayList.add(0, "Pascal");
        showArray(arrayList);

        System.out.println("Recuperar el 3º elemento de la lista : Java");
        System.out.println(arrayList.get(2));

        System.out.println("\nBuscar en qué posición se encuentra el elemento Python.");
        System.out.println(arrayList.indexOf("Python") + "\n");

        System.out.println("Borrar Pascal y visualizar la lista");
        arrayList.remove("Pascal");
        showArray(arrayList);

        System.out.println("Borrar todos los elementos de la lista y visualizarla de nuevo");
        arrayList.clear();
        showArray(arrayList);
    }

    public static void showArray(ArrayList<String> arrayList) {
        for (String iterador : arrayList) {
            System.out.println(iterador);
        }
        System.out.println();
    }
}

