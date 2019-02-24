import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import primero.Depart;
import primero.Emple;

/*
 * Hibernate4-1 punto 2:
 * Obt�n los datos del departamento 10 y el APELLIDO y SALARIO de sus
 * empleados. Ayuda: para obtener los empleados usamos el m�todo
 * getEmples() de la clase Depart y usamos un Iterator (java.util.Iterator) para
 * recorrer la lista de empleados.
 * */

public class hibernate4_1_punto2 {
	public static String stringAlignFormat = "| %-15s | %-10s |%n";
	
	public static void main(String[] args) {
		//Inicializa el entorno Hibernate: carga el fichero hibernate.cfg.xml
		Configuration cfg = new Configuration().configure();
				
		//Abrimos sesi�n e iniciamos una transacci�n
		SessionFactory sessionFactory = cfg.buildSessionFactory (
		new StandardServiceRegistryBuilder().configure().build() ) ;
				
		//Abrimos sesi�n e iniciamos una transacci�n
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
				
		Depart dep = (Depart) session.get (Depart.class, 10);
		
		System.out.println(
				"N� depart: " + dep.getDeptNo() + 
				"\nNombre depart: " + dep.getDnombre() +
				"\nLocalidad depart: " + dep.getLoc());
		
		Set<Emple> listaemp = dep.getEmples();
		Iterator<Emple> it = listaemp.iterator();
		
		System.out.format(stringAlignFormat, "APELLIDO" , "SALARIO");
		
		while (it.hasNext()) {
			Emple emp = it.next();
			System.out.format(stringAlignFormat,emp.getApellido(),emp.getSalario()); 
		}
	}
}
