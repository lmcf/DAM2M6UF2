import java.sql.*;

/*
 * JDBC2_1 Punto 2:
 * Genera un programa en Java que muestre el nombre, el tipo, el tamaño y si
 * puede ser nulo o no, de las columnas de la tabla departamentos.
 * */

public class JDBC2_1_punto2 {
	
    public static void main (String [] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection conexion = DriverManager.getConnection
                    ("jdbc:mysql://192.168.56.17/ejemplo","caldeiro","qwert");
            
            DatabaseMetaData dbmd = conexion.getMetaData();
            ResultSet result = null;
            
            result = dbmd.getColumns(null,"ejemplo","depart",null);
            
            //getColumns -> https://docs.oracle.com/javase/7/docs/api/java/sql/DatabaseMetaData.html#getColumns(java.lang.String,%20java.lang.String,%20java.lang.String,%20java.lang.String)
            
            while(result.next()) {
            	
                String name = result.getString(4);
                String type = result.getString(6);
                String length = result.getString(7);
                boolean nullable = result.getBoolean(11);
                System.out.printf("Field Name: %s,%nField Type: %s,%nField Length: %s,%nNullable: %b%n" +
                        "%n", name, type, length, nullable);
            }
            
            
            conexion.close();
        } catch (ClassNotFoundException | SQLException cn) {cn.printStackTrace();}
    }
}