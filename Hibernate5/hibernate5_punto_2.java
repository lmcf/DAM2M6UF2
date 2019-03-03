import primero.*;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/*
 * Hibernate5 punto 2
 * Visualiza los datos del señor “ARROYO”
 */


public class hibernate5_punto_2 {

	public static void main(String[] args){
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		
		Query q = session.createQuery("from Emple as e where e.apellido = 'ARROYO'");
		List <Emple> lista = q.list();
		Iterator <Emple> iter = lista.iterator();
		
		while (iter.hasNext()){
			Emple emp = (Emple) iter.next();
			System.out.printf(
					"APELIDO: %s%n"
					+ "OFICIO: %s%n"
					+ "DIR: %d%n"
					+ "FECHA ALTA: %s%n"
					+ "SALARIO: %d%n"
					+ "COMISION: %d%n"
					+ "DEP Nº: %d%n",
					emp.getApellido(), emp.getOficio(),
					emp.getDir(),emp.getFechaAlt(),
					emp.getSalario(),emp.getComision(),
					emp.getDepart().getDeptNo());
		}
		
		session.close();
		System.exit(0);
	}
}
