import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

/*
 * BDOO 1
 * Punto 5: Añade otra clase Java para visualizar los países y los jugadores que hay
 * en la base de datos.
 */

public class leerBBDD {
	public static void main(String[] args) {
		ODB odb = ODBFactory.open("EQUIPOS.db");
		Objects<Jugadores> objects = odb.getObjects(Jugadores.class); //recuperamos todos los objetos
		
		System.out.printf("%d Jugadores: %n", objects.size());
		int i = 1;
		while(objects.hasNext()){ // visualizar los objetos
			Jugadores jug = objects.next();
			System.out.printf("%d: %s, %s, %s ,%d ,%s %d %n",
			i++, jug.getNombre(), jug.getDeporte(),
			jug.getCiudad(), jug.getEdad(), jug.getPais().getNombrePais(),jug.getPais().getId());
		}
	}
}
