import java.sql.*;
public class JDBC1Ejemplo {
	public static void main(String[] args) {
		try{
			//Cargar Driver
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			
			//Establecer conexion
			Connection conexion=DriverManager.getConnection 
			("jdbc:mysql://192.168.56.17/ejemplo","caldeiro","qwert");
			
			//Ejecucion de sentencia SQL
			Statement sentencia =conexion.createStatement();
			String sql = "SELECT * from depart";
			ResultSet result = sentencia.executeQuery(sql);
			
			//Se devuelve un ResultSet & Recorremos la lista con next()
			while (result.next()){
				System.out.printf("%d, %s, %s, %n",
						//getInt getString para devolvernos los valores
				result.getInt(1),
				result.getString(2),
				result.getString(3));
			}
			
			//Liberar recursos y cerrar sesion
			result.close();
			sentencia.close();
			conexion.close();
		} 
		catch (ClassNotFoundException cn) { cn.printStackTrace();} 
		catch (SQLException e) {e.printStackTrace();}
		}
	}