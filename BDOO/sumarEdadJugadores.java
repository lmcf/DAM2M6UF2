import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/*
 * BDOO 2
 * Punto 3: Realiza un programa que añada un año a la edad de todos los jugadores. 
 */

public class sumarEdadJugadores {
	 public static void main (String[] args) {		 
		 ODB odb= ODBFactory.open("EQUIPOS.db");
		 
		 System.out.println("A continucación mostrare los jugadores con las edades comprendidas entre 14 y 20 años");
		 		
		 IQuery query = new CriteriaQuery(Jugadores.class);
		 query.orderByAsc ("edad");
		 Objects<Jugadores> objects = odb.getObjects(query);
		 
		 while(objects.hasNext()){ 
				Jugadores jug = objects.next();
				jug.setEdad(jug.getEdad()+1);
				System.out.printf("%s, %s, %s ,%d ,%s %d %n",
				jug.getNombre(), jug.getDeporte(),
				jug.getCiudad(), jug.getEdad(), jug.getPais().getNombrePais(),jug.getPais().getId());
			}
		 
		 }
}
