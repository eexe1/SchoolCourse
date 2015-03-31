package utbm.java.project.SchoolCourse;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
public class SettingPage{

	public List<Course> getCourseList(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Course> courses = session.createQuery("from Course").list();
		session.close();
		return courses;
	}
	
	private List<Course> courseSearchByNameList(String str) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Course> courses = session.createQuery("from Course where title like :searchKey").setParameter("searchKey", "%" + str + "%").list();
		session.close();
		return courses;
	}
	public List<Location> getLocationList(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Location> locations = session.createQuery("from Location").list();
		session.close();
		return locations;
	}
	
	public List<Course> getCourseListByID(int locationID){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		@SuppressWarnings("unchecked")
		List<CourseSession> courseSession = session.createQuery("from CourseSession where location_id like :searchKey").setParameter("searchKey", locationID).list();
		List<Course> courses = new ArrayList<Course>();
		for(int i=0;i<courseSession.size();i++){
			courses.add(courseSession.get(i).getCourse());
		}
		session.close();
		return courses;
	}
}
