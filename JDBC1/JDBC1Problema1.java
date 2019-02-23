import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Punto 1:
 * Tomando como base el programa que ilustra los pasos del funcionamiento de
 * JDBC obtén el APELLIDO, OFICIO y SALARIO de los empleados del
 * departamento 10
 * */

public class JDBC1Problema1 {
	public static void main(String[] args) {
		String titleAlignFormat = "| %-15s | %-15s | %-10s |%n";	
		String leftAlignFormat = "| %-15s | %-15s | %-10s |%n";	
		
		try{
			//Cargar Driver
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			
			//Establecer conexion
			Connection conexion=DriverManager.getConnection 
			("jdbc:mysql://192.168.56.17/ejemplo","caldeiro","qwert");
			
			//Ejecucion de sentencia SQL
			Statement sentencia =conexion.createStatement();
			String sql = "SELECT apellido, oficio, salario FROM emple WHERE dept_no = 10;";			
			ResultSet result = sentencia.executeQuery(sql);			
			
			//Se devuelve un ResultSet & Recorremos la lista con next()
			System.out.format(titleAlignFormat,"APELLIDO","OFICIO","SALARIO");
			while (result.next()){
				System.out.format(leftAlignFormat, result.getString(1),result.getString(2),result.getInt(3) + " €");
			}
			
			/*
			while (result.next()){
				System.out.printf("%s, %s, %d  %n",
				//getInt getString para devolvernos los valores
				result.getString(1),
				result.getString(2),
				result.getInt(3));
			}*/
			
			//Liberar recursos y cerrar sesion
			result.close();
			sentencia.close();
			conexion.close();
			
		} 
		catch (ClassNotFoundException cn) { cn.printStackTrace();} 
		catch (SQLException e) {e.printStackTrace();}
		}
	}