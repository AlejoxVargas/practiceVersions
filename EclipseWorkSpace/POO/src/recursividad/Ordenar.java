package recursividad;

public class Ordenar {
	static int[] vector = { 280, 24, 377, 1 };

	public static void main(String[] args) {
		ordenar(vector, vector.length);
		for (int i = 0; i < vector.length; i++) {
			System.out.println(vector[i]);
		}
	}

	static void ordenar(int[] v, int cantidad) {
		if (cantidad > 1) {
			for (int i = 0; i < cantidad - 1; i++) {
				if (v[i] > v[i + 1]) {
					int aux = v[i];
					v[i] = v[i + 1];
					v[i + 1] = aux;
				}
				ordenar(v, cantidad - 1);
			}
		}
	}
}
