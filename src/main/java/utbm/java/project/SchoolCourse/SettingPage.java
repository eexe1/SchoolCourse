package utbm.java.project.SchoolCourse;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
public class SettingPage{

	public List<Course> gettingCourseList(){
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Course> courses = session.createQuery("from Course").list();
		session.close();
		return courses;
	}
	public List<Course> gettingLocationList(){
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Course> courses = session.createQuery("from Location").list();
		session.close();
		return courses;
		
	}
	
	private static  List<Course> courseSearchByNameList(String str) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		@SuppressWarnings("unchecked")
		List<Course> courses = session.createQuery("from Course where title like :searchKey").setParameter("searchKey", "%" + str + "%").list();
		session.close();
		return courses;
	}
}
