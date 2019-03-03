import java.util.Scanner;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.OID;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/*
 * BDOO 2
 * Punto 1: Realiza un programa que realice una búsqueda por nombre en la base de
 * datos “EQUIPOS.DB”. Pedirá un nombre al usuario y devolverá los datos del
 * jugador que responda a dicho nombre o un mensaje del estilo “no hay ningún
 * jugador que tenga ese nombre en la base de datos”
 */

public class busquedaJugador {
	 public static void main (String[] args) {
		 System.out.println("Hay que tener en cuenta las mayúsculas de cada nombre");
		 System.out.println("Introduce Departamento deseado:");		 
         Scanner nombreScanner = new Scanner(System.in);
         String nombreEscogido = nombreScanner.nextLine();
		 
		 ODB odb= ODBFactory.open("EQUIPOS.db");
		 
		 IQuery query = new CriteriaQuery(Jugadores.class, Where.equal("nombre",nombreEscogido));
		 //query.orderByAsc ("nombre,edad");
		 Objects<Jugadores> objects = odb.getObjects(query);
		 
		 if (objects.isEmpty()) {
			 System.out.println("El jugador buscado no existe");
			 System.exit(0);
		 }
		 
		 if (objects.size() <=2) {
			 System.out.println("Cuidado, hay mas de un jugador con ese nombre!! \n");
		 }
		 
		 while(objects.hasNext()){ 
				Jugadores jug = objects.next();
				System.out.printf("%s, %s, %s ,%d ,%s %d %n",
				jug.getNombre(), jug.getDeporte(),
				jug.getCiudad(), jug.getEdad(), jug.getPais().getNombrePais(),jug.getPais().getId());
			}
		 
		 }
}
