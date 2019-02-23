import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * Punto3:
 * Realiza un programa que busque los departamentos de una localidad. El
 * programa solicitará el nombre de una localidad al usuario y devolverá los
 * departamentos asociados a dicha localidad y los empleados de dicho departamentos.
 * */

public class JDBC1Problema3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	    System.out.print("INTRODUCE UNA CIUDAD: ");
	    String localidad = scan.nextLine();    
			
		try{
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			
			Connection conexion=DriverManager.getConnection 
			("jdbc:mysql://192.168.56.17/ejemplo","caldeiro","qwert");
			
			Statement sentencia = conexion.createStatement();
			String departamento = "SELECT dept_no FROM depart WHERE loc = '" + localidad + "';";
			ResultSet result = sentencia.executeQuery(departamento);
						
			if(!result.next()) {
				System.out.println("No existe ningun departamento en esa ciudad");
				System.exit(0);
			}
			
			int dept_no = result.getInt(1);
			System.out.println("DEPARTAMENTO ESCOGIDO: " + dept_no );
			
			System.out.println("EMPLEADOS");
			String empleados = "SELECT apellido FROM emple WHERE dept_no='" + dept_no + "';";
			ResultSet result2 = sentencia.executeQuery(empleados);
			
			if(!result2.next()) {
				System.out.println("No existen empleados en ese departamento");
				System.exit(0);
			}
			
			while (result2.next()){
				System.out.println(result2.getString(1));
			}

			result.close();
			result2.close();
			sentencia.close();
			conexion.close();
		} 
		catch (ClassNotFoundException cn) { cn.printStackTrace();} 
		catch (SQLException e) {e.printStackTrace();}
		finally {
			if(scan!=null) {
				scan.close();
			}
		}
		}
	}