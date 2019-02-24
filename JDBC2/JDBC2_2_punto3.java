import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

import com.mysql.cj.util.StringUtils;

/*
 * JDBC2_2 Punto 3:
 * Crea un programa Java que inserte un empleado en la tabla emple, el
 * programa recibe del usuario los valores a insertar. Los argumentos que
 * recibe son: EMP_NO, APELLIDO, OFICIO, DIR, SALARIO, COMISION,
 * DEPT_NO. Antes de insertar se deben realizar una serie de comprobaciones:
 * 
	- Que el departamento exista en la tabla depart, si no existe no se inserta
	+ Que el número del empleado no exista, si existe no se inserta
	+ Que el salario sea mayor que cero, si no lo es, no se inserta
	+ Que el director (dir -> “jefe” del empleado) exista, si no existe no se inserta
	+ El apellido y el oficio no pueden ser nulos
	- La fecha de alta del empleado es la fecha actual.
 * 
 * Cuando se inserte la fila visualizar mensaje y si no se inserta visualizar el motivo.
 * */

public class JDBC2_2_punto3 {
	
    public static void main (String [] args) {	
        try {
        	String stringAlignFormat = "| %-6s | %-12s | %-12s | %-6s | %-12s | %-10s | %-10s | %-10s |%n";
        	
        	//Datos de los argumentos
        	String empNoArg = args[0];
        	String apellidoArg = args[1];
        	String oficioArg = args[2];
        	String dirArg = args[3];
        	String salarioArg = args[4];
        	String comisionArg = args[5];
        	String departNoArg = args[6];
        	
            
            Connection conexion = DriverManager.getConnection
                    ("jdbc:mysql://192.168.56.17/ejemplo","caldeiro","qwert");
            
            Statement sentencia = conexion.createStatement();
            
            //Comprobamos Nº Empleado
            String comprobarEmpNo = String.format(
            		"SELECT emp_no from emple where emp_no = " + empNoArg
            		);
            
            ResultSet empNo = sentencia.executeQuery(comprobarEmpNo);
            
            if (empNo.next()) {
				System.out.println("El empleado Nº " + empNoArg + " existe");
				System.exit(0);
			}
           
            //Comprobamos que apellido no es nulo
           if (apellidoArg.contains("null") || apellidoArg.contains("NULL")) {
        	   System.out.println("El apellido no puede ser nulo");
        	   System.exit(0);
           }
           
           //Comprobar si el directo existe
           String comprobarDirector = String.format(
        		   "SELECT emp_no from emple WHERE emp_no = " + dirArg
        		   );
           
           ResultSet dir = sentencia.executeQuery(comprobarDirector);
           
           if (!dir.next()) {
        	   System.out.println("El director introducido " + dirArg + " no existe");
        	   System.exit(0);
           }
           
           //Comprobamos que el salario no sea 0
           int aux = Integer.parseInt(salarioArg);
           
           if (aux == 0) {
        	   System.out.println("El salario ha de ser superior a 0");
        	   System.exit(0);
           }
           
           //Comprobamos que el departamento exista
           String comprobarDepartamento = String.format(
        		   "SELECT dept_no from depart where dept_no = " + departNoArg
        		   );
           
           ResultSet departNo = sentencia.executeQuery(comprobarDepartamento);
           
           if (!departNo.next()) {
        	   System.out.print("El departamento " + departNoArg + " no existe");
        	   System.exit(0);
           }
           
           //Si hemos llegado hasta aqui realizamos el insert
           String fechaAlt = LocalDate.now().toString();
           
          String insertEmp = String.format(
        		   "INSERT INTO emple VALUES ("
        		   + "%s,'%s','%s',%s,'%s',%s,%s,%s)"
        		   ,empNoArg,apellidoArg,oficioArg,dirArg,fechaAlt,salarioArg,comisionArg,departNoArg);
           
           sentencia.executeUpdate(insertEmp);
           
           //Comprobamos que se ha insertado correctamente
           String verEmp = String.format(
        		   "SELECT * from emple WHERE emp_no = " + empNoArg 
        		   );
           
           ResultSet empleado = sentencia.executeQuery(verEmp);
           
           System.out.printf(
        		   stringAlignFormat,
        		   "Nº EMP","APELLLIDO","OFICIO","DIR","FECHA ALT","SALARIO","COMISION","DEPT Nº"
        		   );
           
           while(empleado.next()) {
        	   System.out.printf(
               		stringAlignFormat,
               		empleado.getString(1),empleado.getString(2),
               		empleado.getString(3),empleado.getString(4),
               		empleado.getString(5),empleado.getString(6),
               		empleado.getString(7),empleado.getString(8)
               	);
           }
            
            sentencia.close();
            conexion.close();
        } catch (SQLException cn) {cn.printStackTrace();}
    }
}