import primero.*;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class hibernate2_punto_2 {
	public static int randomNumberRange(int min, int max) {
	    int n = (max + 1 - min) + min;
	    return (int) (Math.random() * n);
	}
	
	public static void main(String[] args){
		/*
		 * Hibernate II - Punto II
		 * Realiza un programa Java (puedes modificar el Main anterior) que a�ada una
		 * nueva fila en la tabla emple. El nuevo empleado estar� asignado al
		 * departamento 10. Para asignarle el departamento ser� necesario crear un
		 * objeto de tipo Depart y asignar como n�mero de departamento el valor 10
		 * con el m�todo setDeptNo().
		 * */
		
		//En primer lugar se obtiene la sesi�n creada por el Singleton. 
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		
		//Abrimos sesi�n e iniciamos una transacci�n
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Inserto una fila en depart");
		
		//Creamos un nuevo objeto Depart y damos valor a sus atributos
		Date date = new Date();
		Emple emp = new Emple();
		Depart dep = new Depart();
		
		dep.setDeptNo(10);
		emp.setApellido("CALDEIRO");
		emp.setOficio("PROGRAMADOR");
		emp.setSalario(randomNumberRange(5555, 9999));
		emp.setEmpNo(randomNumberRange(7777, 9999));
		emp.setDir(7902);
		emp.setComision(randomNumberRange(100, 1000));
		emp.setFechaAlt(date);
		
		//Guardamos en la base de datos y comprometemos la informaci�n
		session.save(emp);
		tx.commit();
		session.close();
		System.exit(0);
	}
}