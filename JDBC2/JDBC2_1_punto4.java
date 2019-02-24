import java.sql.*;

/*
 * JDBC1_1 Punto 4:
 * Busca información sobre la interfaz ResultSetMetaData y realiza un
 * programa utilizando dicha interfaz que obtenga el número de columnas y el
 * tipo de columnas devueltos por la consulta “SELECT * FROM DEPARTAMENTOS”.
 * */

public class JDBC2_1_punto4 {
	
    public static void main (String [] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection conexion = DriverManager.getConnection
                    ("jdbc:mysql://192.168.56.17/ejemplo","caldeiro","qwert");
            
            String consulta = "SELECT * FROM depart";
            
            Statement sentencia =conexion.createStatement();
            ResultSet result = sentencia.executeQuery(consulta);        
            ResultSetMetaData rsmd = result.getMetaData();
            
            int numberOfColumns = rsmd.getColumnCount();
            
            DatabaseMetaData dbmd = conexion.getMetaData();
            result = dbmd.getColumns(null, "ejemplo", "depart", null);
            
            System.out.printf("Cantidad columnas de la tabla = %d%n",numberOfColumns);
            
            while(result.next()) {
            	String typeName = result.getString(6);
            	System.out.printf("Type: %s %n",typeName);
            }
           
            conexion.close();
        } catch (ClassNotFoundException | SQLException cn) {cn.printStackTrace();}
    }
}