package ejercicio1;

import java.time.LocalDate;

public class testHerencia2 {
	public static void main(String[] args) {

		ProductoFresco productoFresco = new ProductoFresco(LocalDate.of(2023, 2, 20), 1001, LocalDate.of(2023, 1, 25), "Francia");
		ProductoRefrigerado productoRefrigerado = new ProductoRefrigerado(LocalDate.of(2023, 2, 20), 2001, 16578);
		ProductoCongelado productoCongelado = new ProductoCongelado(LocalDate.of(2023, 5, 15), 3001, -14.5);

		System.out.println("Producto Fresco " + productoFresco.getDatos() + productoFresco.getDatosFresco());
		System.out.println("Producto Refrigerado " + productoRefrigerado.getDatos()
				+ productoRefrigerado.getDatosRefrigerado());
		System.out.println(
				"Producto Congelado " + productoCongelado.getDatos() + productoCongelado.getDatosCongelados());
	}
}
