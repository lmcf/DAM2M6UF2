import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import primero.Depart;
import primero.Emple;

/*
 * Hibernate4-2 punto 1
 * Para modificar un objeto, igual que para borrarlo, primero hemos de cargarlo,
 * a continuación realizamos la modificaciones y, por último, utilizamos el
 * método update(). Realiza un programa que modifique el salario y el
 * departamento del empleado 7369, sumando 1000 al salario y asignándole el
 * departamento 30.
 * */

public class hibernate4_2_punto_1 {
	public static void main(String[] args) {
		//Inicializa el entorno Hibernate: carga el fichero hibernate.cfg.xml
		Configuration cfg = new Configuration().configure();
				
		//Abrimos sesión e iniciamos una transacción
		SessionFactory sessionFactory = cfg.buildSessionFactory (
		new StandardServiceRegistryBuilder().configure().build() ) ;
				
		//Abrimos sesión e iniciamos una transacción
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Depart dep = new Depart();
		Emple emp = new Emple();
		
		try {
			dep = session.load(Depart.class, 30);
			emp = session.load(Emple.class, 7369);
			System.out.println("Empleado actualizado");
		} catch ( ObjectNotFoundException o ) {
			System.out.println("El departamento o empleado no existe");
		}
		
		emp.setSalario(emp.getSalario() + 1000);
		emp.setDepart(dep);
		
		session.update(emp);
		tx.commit();
		session.close();
		System.exit(0);
		
		
	}
}
