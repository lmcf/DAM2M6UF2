import java.sql.*;
import java.util.Scanner;

/*
 * JDBC2_2 Punto 1:
 * Realiza un programa en Java que suba el salario a los empleados de un
 * departamento. El programa recibirá el número de departamento y el
 * incremento..
 * */

public class JDBC2_2_punto1 {
	
    public static void main (String [] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection conexion = DriverManager.getConnection
                    ("jdbc:mysql://192.168.56.17/ejemplo","caldeiro","qwert");
            
            System.out.println("Introduce Departamento deseado:");
            Scanner departScanner = new Scanner(System.in);
            String departEscogido = departScanner.nextLine();
            
            System.out.println("Introduce aumento deseado:");
            Scanner aumentoScanner = new Scanner(System.in);
            String aumentoEscogido = aumentoScanner.nextLine();
                    
            String updateSalarioDep = String.format("UPDATE emple SET salario = salario + %s where dept_no = %s", aumentoEscogido, departEscogido);
           
            Statement sentencia = conexion.createStatement();
            int filas = sentencia.executeUpdate(updateSalarioDep);       
            
            System.out.printf("Filas afectadas: %d %n", filas);
            
            conexion.close();
        } catch (ClassNotFoundException | SQLException cn) {cn.printStackTrace();}
    }
}