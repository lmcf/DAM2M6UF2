import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import primero.Emple;

/*
 * Hibernate 4-1 punto 1:
 * Visualiza el apellido y el salario del empleado con n�mero: 7369
 * */

public class hibernate4_1_punto_1 {
	public static void main(String[] args) {
		//Inicializa el entorno Hibernate: carga el fichero hibernate.cfg.xml
		Configuration cfg = new Configuration().configure();
				
		//Abrimos sesi�n e iniciamos una transacci�n
		SessionFactory sessionFactory = cfg.buildSessionFactory (
		new StandardServiceRegistryBuilder().configure().build() ) ;
				
		//Abrimos sesi�n e iniciamos una transacci�n
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
			
		Emple emple = (Emple) session.get(Emple.class, 7369);
		if (emple == null) {
			System.out.println("Empleado no existe");
		}
		else {
			System.out.printf("Apellido: %s %nSalario: %d%n", emple.getApellido(),emple.getSalario());
		}
	}
}
