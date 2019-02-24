import java.sql.*;
import java.util.Scanner;

import com.mysql.cj.util.StringUtils;

/*
 * JDBC2_2 Punto 2:
 * Realiza un programa que cree una vista (de nombre “totales”) que contenga
 * por cada departamento el número de departamento, el nombre, el número
 * de empleados que tiene y el salario medio
 * */

public class JDBC2_2_punto2 {
	
    public static void main (String [] args) {	
        try {
        	String stringAlignFormat = "| %-15s | %-15s | %-15s | %-15s |%n";
        	
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection conexion = DriverManager.getConnection
                    ("jdbc:mysql://192.168.56.17/ejemplo","caldeiro","qwert");
            
            Statement sentencia = conexion.createStatement();
            
            String deleteView = String.format(
            		"DROP VIEW IF EXISTS totales"
            		);
            
            sentencia.executeUpdate(deleteView);
            
            String createView = String.format(
            		"CREATE VIEW totales as ("
            		+ "select emp.dept_no, dep.dnombre,count"
            		+ "(emp.dept_no),avg(emp.salario) "
            		+ "FROM emple emp INNER JOIN depart dep on emp.dept_no = dep.dept_no "
            		+ "GROUP BY emp.dept_no)"            		
            		);
            
            String seeView = String.format(
            		"SELECT * from totales"
            		);
            
            sentencia.executeUpdate(createView);            
            ResultSet result = sentencia.executeQuery(seeView);
            
            System.out.printf(
            		stringAlignFormat + "%n",
            		"Nº DEPART","DEPART","Nº EMPLEADOS","SALARIO MEDIO"
            		);
                
            
            while(result.next()) {
            	System.out.printf(
            		stringAlignFormat,
            		result.getString(1),result.getString(2),
            		result.getString(3),result.getString(4)
            	);
            }
            
            sentencia.close();
            conexion.close();
        } catch (ClassNotFoundException | SQLException cn) {cn.printStackTrace();}
    }
}