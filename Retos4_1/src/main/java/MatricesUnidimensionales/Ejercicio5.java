package MatricesUnidimensionales;

/*Ejercicio 5

Escribir un método longitudMax() al que se le pase un array de cadenas de caracteres y devuelva la cadena que tiene la longitud más larga.*/
public class Ejercicio5 {

    public static void main(String[] args) {
        String[] getString = {"Hola", "estoy", "aprendiendo", "matrices", "y", "necesito", "estudiar"};
        System.out.println("La cadena más larga es: " + "\"" + longitudMax(getString) + "\"");
    }

    static String longitudMax(String[] getString) {
        String maxCarTer = "";
        for (String j : getString) {
            if (j.length() > maxCarTer.length()) {
                maxCarTer = j;
            }
        }
        return maxCarTer;
    }
}
