package com.dam.proyecto.miProyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
	public static void main(String[] args) {
		try {
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost/dam", "root", "");
			Statement miStatement = miConexion.createStatement();

			/* Insertar */
			// String instruccionSql = "INSERT INTO PRUEBA (ID,NOMBRE,CURSO,EDAD) VALUES (3,'Javi',1,22)";
			// miStatement.executeUpdate(instruccionSql);

			/* Modificar */
			//String instruccionSql = "UPDATE PRUEBA SET EDAD= EDAD * 2 WHERE ID = 3";
			//miStatement.executeUpdate(instruccionSql);

			/* Eliminar */
			//miStatement.executeUpdate("DELETE FROM PRUEBA WHERE ID = 3");
			
			ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM PRUEBA");
			
			while (miResultSet.next()) {
				System.out.println(miResultSet.getString("Nombre") + "\t" + miResultSet.getInt("Edad"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}