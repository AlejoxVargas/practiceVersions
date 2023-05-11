package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Conexion {
	public static void main(String[] args) {

		try {
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost/dam", "root", "");
			Statement miStatement = miConexion.createStatement();

			/* Insertar */
			// String instruccionSql = "INSERT INTO PRUEBA (ID,NOMBRE,CURSO,EDAD) VALUES
			// (3,'Javi',1,22)";
			// miStatement.executeUpdate(instruccionSql);

			/* Modificar */
			// String instruccionSql = "UPDATE PRUEBA SET EDAD= EDAD * 2 WHERE ID = 3";
			// miStatement.executeUpdate(instruccionSql);

			/* Eliminar */
			// miStatement.executeUpdate("DELETE FROM PRUEBA WHERE ID = 3");

			/* Consultar */
			// ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM PRUEBA");

			/*
			 * while (miResultSet.next()) {
			 * System.out.println(miResultSet.getString("Nombre") + "\t" +
			 * miResultSet.getInt("Edad")); }
			 */

			PreparedStatement sentencia = miConexion
					.prepareStatement("SELECT * FROM PRUEBA WHERE CURSO = ? AND EDAD = ?");
			sentencia.setInt(1, 1);
			sentencia.setInt(2, 22);
			
			ResultSet miResultSet = sentencia.executeQuery();

			while (miResultSet.next()) {
				System.out.println(miResultSet.getString("NOMBRE") + "\t" + miResultSet.getInt("CURSO") + "\t"
						+ miResultSet.getInt("EDAD"));
			}
			miResultSet.close();
			sentencia.close();
			miConexion.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
