import primero.*;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/*
 * Hibernate5 punto 1
 * Visualiza el apellido y salario de los empleados del departamento 20. (Ayuda:
 * la consulta HQL necesaria es: “from Emple as e where e.depart.deptNo=20”)
 */

public class hibernate5_punto_1 {
	public static String stringAlignFormat = "| %-15s | %-10s |%n";
	
	public static void main(String[] args){
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		
		Query q = session.createQuery("from Emple as e where e.depart.deptNo=20");
		List <Emple> lista = q.list();
		Iterator <Emple> iter = lista.iterator();
		
		System.out.printf(stringAlignFormat,"APELLIDO","SALARIO");
		while (iter.hasNext()){
			Emple emp = (Emple) iter.next();
			System.out.printf(stringAlignFormat, emp.getApellido(), emp.getSalario());
		}
		
		session.close();
		System.exit(0);
	}
}
