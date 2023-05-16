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
			//Statement miStatement = miConexion.createStatement();

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

			// Lectura de secuencia
			/* while (miResultSet.next()) {
			 * System.out.println(miResultSet.getString("Nombre") + "\t" +
			 * miResultSet.getInt("Edad")); }
			 */
			
			//Nueva secuencia con preparedStatement
			/*PreparedStatement sentencia = miConexion.prepareStatement("SELECT * FROM PRUEBA WHERE CURSO = ? AND EDAD = ?");
			sentencia.setInt(1, 1);
			sentencia.setInt(2, 22);*/
			
			//Conexion mediante el preparedStatement lee los query
			/*ResultSet miResultSet = sentencia.executeQuery();*/
			
			
			/*------USO ESPECIFICO CON LIBRERIA DE RESULTSET-------*/
			
			//Nuevas secuencias de resulSet mejoradas - 16/05/2023
			
			//Modificacion del createStatement para la nueva version explicada 
			//Nuevo constructor desde la libreria de ResultSet
			Statement miStatement = miConexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			/*Ejecuta el query y el while los imprime*/
			ResultSet miResultSet = miStatement.executeQuery("select * from prueba");

			while (miResultSet.next()) {
				System.out.println(miResultSet.getString("NOMBRE") + "\t" + miResultSet.getInt("CURSO") + "\t"
						+ miResultSet.getInt("EDAD"));
				int ident = miResultSet.getInt("id");
				if (ident == 2) {
					miResultSet.updateInt("curso", 2);
					miResultSet.updateRow();
				}
			}
			
			/*Imaginemos que quiero ir a un registro en particular y hacer la crud, como se puede hacer esto?*/
			miResultSet.absolute(2);
			miResultSet.updateString("nombre", "JM");
			miResultSet.updateRow(); //actualiza la tabla luego de tener los datos anteriores
			
			System.out.println();
			
			/*Recorrer la BD a la inversa*/
			miResultSet.afterLast();
			while (miResultSet.previous()) {
				System.out.println(miResultSet.getString("NOMBRE") + "\t" + miResultSet.getInt("CURSO") + "\t"+ miResultSet.getInt("EDAD"));
			}
			
			/*Insertar nuevo registro con ResultSet*/
			miResultSet.moveToInsertRow(); //esto se va a ir al ultimo registro
			miResultSet.updateInt("id", 4); //y en el ultimo registro inserta este nuevo
			miResultSet.updateString("nombre", "Luis Miguel");
			miResultSet.updateInt("curso", 2);
			miResultSet.updateInt("edad", 22);
			//miResultSet.insertRow(); //sirve para insertar los datos anteriores
			
			/*Crear tabla con ResultSet*/ 
			//miStatement.executeUpdate("create table autor(id integer primary key, nombre varchar(50))");
			//Se comentan para que no intente sobreescribir y genere error
			
			/*Borrar tablas con ResultSet*/
			//miStatement.executeUpdate("drop table autor");
			
			/*Crear una nueva base de datos con ResultSet*/
			miStatement.execute("create database DAM2");
			
			/*Esto para cerrar la base de datos*/
			miResultSet.close();
			//Close del PreparedStatement
			//sentencia.close();
			miStatement.close();
			miConexion.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
