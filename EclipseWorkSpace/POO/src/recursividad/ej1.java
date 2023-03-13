package recursividad;

public class ej1 {

	public static void main(String[] args) {
		System.out.println(factorial(4));
	}

	static void repetir(int x) {
		if (x > 0) {
			System.out.println(x);
			repetir(x - 1);
		}
	}
	
	static int factorial(int x) {
		if(x > 0) {
			System.out.println(x + " * " + " factorial (" + (x-1) +")");
			int valor = x * factorial (x-1);
			return valor;
		}else {
			return 1;
		}
	}
}
