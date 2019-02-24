import java.sql.*;

/*
 * JDBC2_1 Punto 3:
 * Genera un programa que devuelva la clave primaria de la tabla
 * departamentos y la clave ajena que apunta a la tabla departamentos. NOTA:
 * revisa que estén creadas las claves; tanto la primaria como la foránea.
 * */

public class JDBC2_1_punto3 {
	
    public static void main (String [] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection conexion = DriverManager.getConnection
                    ("jdbc:mysql://192.168.56.17/ejemplo","caldeiro","qwert");
            
            DatabaseMetaData dbmd = conexion.getMetaData();
            ResultSet result = null;
            ResultSet result2 = null;
            
            result = dbmd.getPrimaryKeys("ejemplo",null, "depart");
            result2 = dbmd.getExportedKeys("ejemplo",null, "depart");
            
            while (result.next()) {
            	String primaryKey = result.getString("COLUMN_NAME");
            	System.out.printf("Primary Key - %s%n", primaryKey);
            }
            
            while (result2.next()) {
            	String foreignKey = result2.getString("FKCOLUMN_NAME");
            	System.out.printf("Foreign Key - %s%n", foreignKey);
            }
           
            conexion.close();
        } catch (ClassNotFoundException | SQLException cn) {cn.printStackTrace();}
    }
}