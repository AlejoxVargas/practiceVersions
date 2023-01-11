package MatricesUnidimensionales;

/*Ejercicio 4:

Escribir un método max() al que se le pase como argumento el array números y devuelva el valor máximo.*/
public class Ejercicio4 {

    public static void main(String[] args) {
        int[] getArray = {12, 15, 13, 10, 8, 9, 13, 14};
        System.out.println(max(getArray));
    }

    static int max(int[] getArray) {
        int maxNum = 0;
        for (int j : getArray) {
            if(j>maxNum){
            maxNum = j;
            }
        }
        return maxNum;
    }
}
