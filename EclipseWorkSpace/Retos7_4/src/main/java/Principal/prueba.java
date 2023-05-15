package Principal;

import java.lang.reflect.Array;

public class prueba {
    public static void main(String[] args) {
        int[] n = new int[9];
        n = new int[]{1, 2, 3, 0, 0, 0};
        int m = n.length;
        for (int i = 0; i < n.length; i++) {
            System.out.println("indice: " + i + " contenido; " + n[i]);
        }
        System.out.println(m);
        System.out.println(n.length);
    }
}
