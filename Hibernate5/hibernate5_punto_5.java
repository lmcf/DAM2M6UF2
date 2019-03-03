import primero.*;
import java.util.Iterator;
import java.util.List;

import javax.print.attribute.standard.Media;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/*
 * Hibernate5 punto 5
 * Muestra el salario medio y el número de empleados por departamento
 */

public class hibernate5_punto_5 {
	public static String stringAlignFormat = "| %-15s | %-15s | %-15s |%n";

	public static void main(String[] args){
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		
		String consulta = "select e.depart.dnombre, avg(salario), count(apellido) from Emple as e group by e.depart.deptNo";
		Query q = session.createQuery(consulta);
		List <?> lista = q.list();
		Iterator <?> filasIter = lista.iterator();
		
		System.out.printf(stringAlignFormat,"DEPARTAMENTO","MEDIA SALARIO","Nª Empleados");
		
		while (filasIter.hasNext()){
			Object [] fila = (Object []) filasIter.next();			
			System.out.printf(stringAlignFormat, fila[0],fila[1],fila[2]);
		}
		
		session.close();
		System.exit(0);
	}
}
