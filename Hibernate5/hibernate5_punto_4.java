import primero.*;
import java.util.Iterator;
import java.util.List;

import javax.print.attribute.standard.Media;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/*
 * Hibernate5 punto 4
 * Calcula el salario medio de todos los empleados. (Ayuda: busca en el manual
 * de HQL cómo utilizar las funciones de agregación. Verás que es lo mismo
 * que en SQL)
 */

public class hibernate5_punto_4 {
	public static String stringAlignFormat = "| %-15s | %-15s |%n";

	public static void main(String[] args){
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		
		Query q = session.createQuery("select avg(salario) from Emple");
		List <Double> media = q.list();
		Iterator <Double> iter = media.iterator();
		
		//Entiendo que solo debe haber un valor
		if(iter.hasNext()) {
			Double mediaSalario = iter.next();
			System.out.println("Salario Medio -> " + mediaSalario);
		}
		
		session.close();
		System.exit(0);
	}
}
