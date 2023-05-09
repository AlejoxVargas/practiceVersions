package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Conexion {
	public static void main(String[] args) {
		try {
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost/dam", "root", "");
			Statement miStatement = miConexion.createStatement();
			String instruccionSql = "INSERT INTO PRUEBA (ID,NOMBRE,CURSO,EDAD) VALUES (3,'Javi',1,22)";
			miStatement.executeUpdate(instruccionSql);
			ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM PRUEBA");
			while (miResultSet.next()) {
				System.out.println(miResultSet.getString("Nombre") + "\t" + miResultSet.getInt("Edad"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
