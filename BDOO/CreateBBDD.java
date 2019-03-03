import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

/*
 * BDOO 1:
 * Punto 4: Crea una clase Java (con el m�todo main()) que cree una base de datos de
 * nombre EQUIPOS.DB e inserte pa�ses y los jugadores de esos pa�ses.
 * */

public class CreateBBDD {
	public static void main(String[] args) {
		//Abrimos BBDD 
		ODB odb = ODBFactory.open("EQUIPOS.db"); 
		 
		//Creamos Paises
		Paises espa�a = new Paises(34,"Espa�a");
		Paises francia = new Paises(33,"Francia" );
		Paises alemania = new Paises(49, "ALemania");
		
		//Creamos Jugadores
		Jugadores j1 = new Jugadores("Jowi", "Futbol", "Toulose",14,francia); 
		//Jugadores j2 = new Jugadores("Benzema","Futbol","Lyon",30,francia);
		//Jugadores j3 = new Jugadores("Marco Reus","Futbol","Dortmund",28,alemania);
		 
		//Alamecenamos Objetos
		odb.store(j1); 
		//odb.store(j2);
	//	odb.store(j3);
		odb.store(espa�a);
		odb.store(alemania);
		odb.store(francia);
		
		odb.close(); // Cerrar BD
		
	}
}
