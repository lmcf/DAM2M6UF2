import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Punto2:
 * Realiza otro programa Java utilizando la base de datos “ejemplo” que
 * visualice el APELLIDO del empleado con máximo salario, visualiza también
 * su SALARIO y el nombre del departamento.
 * */

public class JDBC1Problema2 {
	public static void main(String[] args) {
			
		try{
			//Cargar Driver
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			
			//Establecer conexion
			Connection conexion=DriverManager.getConnection 
			("jdbc:mysql://192.168.56.17/ejemplo","caldeiro","qwert");
			
			//Ejecucion de sentencia SQL
			Statement sentencia =conexion.createStatement();
			String sql = "SELECT apellido, salario, dept_no FROM emple ORDER BY salario DESC LIMIT 1";
			ResultSet result = sentencia.executeQuery(sql);
			
			result.next();
			System.out.print(
					"APELLIDO: " + result.getString(1) + "\n" +
					"SALARIO: " + result.getInt(2) + "\n" +
					"DEPARTAMENTO: " + result.getInt(3)
					);

			//Liberar recursos y cerrar sesion
			result.close();
			sentencia.close();
			conexion.close();
		} 
		catch (ClassNotFoundException cn) { cn.printStackTrace();} 
		catch (SQLException e) {e.printStackTrace();}
		}
	}