import primero.*;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/*
 * Hibernate5 punto 3
 * Visualiza los nombres de los empleados junto con el departamento al que
 * pertenecen. (Ayuda: consulta en el manual de HQL cómo realizar un JOIN.
 * Observarás que es muy parecido a SQL)
 */

public class hibernate5_punto_3 {
	public static String stringAlignFormat = "| %-15s | %-15s |%n";

	public static void main(String[] args){
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		
		Query q = session.createQuery("from Emple as e join Depart as d on e.depart.deptNo = d.deptNo");
		List <?> lista = q.list();
		Iterator <?> filasIter = lista.iterator();
		
		Emple emple;
		Depart depart;
		
		System.out.printf(stringAlignFormat, "APELLIDO","DEPARTAMENTO");
		
		while (filasIter.hasNext()){
			Object [] fila = (Object []) filasIter.next();
			emple = (Emple)fila[0];
			depart = (Depart)fila[1];
			
			System.out.printf(stringAlignFormat, emple.getApellido(),depart.getDnombre());
		}
		
		session.close();
		System.exit(0);
	}
}
