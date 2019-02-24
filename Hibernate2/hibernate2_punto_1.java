import primero.*;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class hibernate2_punto_1 {
		public static void main(String[] args){
			//En primer lugar se obtiene la sesi�n creada por el Singleton.
			SessionFactory sesion = HibernateUtil.getSessionFactory();
			
			//Abrimos sesi�n e iniciamos una transacci�n
			Session session = sesion.openSession();
			Transaction tx = session.beginTransaction();
			System.out.println("Inserto una fila en depart");
			
			//Creamos un nuevo objeto Depart y damos valor a sus atributos
			Depart dep = new Depart();
			dep.setDeptNo((byte) 62);
			dep.setDnombre("MARKETING");
			dep.setLoc("GUADALAJARA");
			
			//Guardamos en la base de datos y comprometemos la informaci�n
			session.save(dep);
			tx.commit();
			session.close();
			System.exit(0);
		}
}

