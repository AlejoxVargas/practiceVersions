package ejercicio1;

public class testHerencia2 {
	public static void main(String[] args) {

		ProductoFresco productoFresco = new ProductoFresco(2023, 2, 20, 1001, "Francia");
		ProductoRefrigerado productoRefrigerado = new ProductoRefrigerado(2023, 3, 25, 2001, 16578);
		ProductoCongelado productoCongelado = new ProductoCongelado(2023, 5, 15, 3001, -14.5);

		System.out.println("Producto Fresco 1: " + productoFresco.getDatos() + productoFresco.getDatosFresco());
		System.out.println("Producto Refrigerado 1: " + productoRefrigerado.getDatos()
				+ productoRefrigerado.getDatosRefrigerado());
		System.out.println(
				"Producto Congelado 1: " + productoCongelado.getDatos() + productoCongelado.getDatosCongelados());
	}
}
