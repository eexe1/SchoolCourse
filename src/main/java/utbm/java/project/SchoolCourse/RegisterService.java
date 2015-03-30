package utbm.java.project.SchoolCourse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RegisterService {

	
	public void register(Client client){
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();

		session.save(client);

		session.getTransaction().commit();

		session.close();

		System.out.println("-- Inscription Completed ---");
		
	}
	
	
}
