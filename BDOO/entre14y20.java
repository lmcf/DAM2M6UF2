import java.util.Scanner;

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
 * Punto 2: Realiza un programa que devuelva los jugadores cuyas edades estén
 * comprendidas entre 14 y 20 años. Utiliza la interfaz ICriterion.
 */

public class entre14y20 {
	 public static void main (String[] args) {		 
		 ODB odb= ODBFactory.open("EQUIPOS.db");
		 
		 System.out.println("A continucación mostrare los jugadores con las edades comprendidas entre 14 y 20 años");
		 
		 ICriterion criterion = new And()
				.add(Where.gt("edad", 13))
				.add(Where.lt("edad", 21));
		
		 IQuery query = new CriteriaQuery(Jugadores.class, criterion);
		 query.orderByAsc ("edad");
		 Objects<Jugadores> objects = odb.getObjects(query);
		 
		 if (objects.isEmpty()) {
			 System.out.println("No hay jugadores entre esas edades");
			 System.exit(0);
		 }
		 
		 while(objects.hasNext()){ 
				Jugadores jug = objects.next();
				System.out.printf("%s, %s, %s ,%d ,%s %d %n",
				jug.getNombre(), jug.getDeporte(),
				jug.getCiudad(), jug.getEdad(), jug.getPais().getNombrePais(),jug.getPais().getId());
			}
		 
		 }
}
