package utbm.java.project.SchoolCourse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {

	private static Scanner scan;
	
	public static void main(String[] args) {
		System.out.println("--------- OPTIONS ---------");
		System.out.println("----1.List Classes-------------");
		System.out.println("----2.Search Classes By Name---");
		scan = new Scanner(System.in);
		
		int option = scan.nextInt();
		String input;
		int sessionID;
		switch(option){
		case 1:	
			List<Course> courses1 = courseListAll();
			for(Course course:courses1){
				System.out.println(course.getCode()+" : "+course.getTitle());
			}
			System.out.println("---------Input Code---------");
			input = scan.next();
			sessionID = searchIndex(input);
			inscript(sessionID);
			break;
		case 2:
			System.out.println("-------Search By Name-------");
			input = scan.next();
			List<Course> courses2 = courseSearchByNameList(input);
			for(Course course:courses2){
				System.out.println(course.getCode()+" : "+course.getTitle());
			}
			System.out.println("---------Input Code---------");
			input = scan.next();
			sessionID = searchIndex(input);
			inscript(sessionID);
			break;
		case 3:
			List<Course> courses3 = getCourseList(1);
			for(Course course:courses3){
				System.out.println(course.getCode()+" : "+course.getTitle());
			}
			break;
		}
		scan.close();
	}
	public static List<Course> getCourseList(int locationID){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		@SuppressWarnings("unchecked")
		List<CourseSession> courseSession = session.createQuery("from CourseSession where location_id like :searchKey").setParameter("searchKey", locationID).list();
		List<Course> courses = new ArrayList<Course>();
		for(CourseSession cs:courseSession){
			courses.add(cs.getCourse());
			System.out.println(cs.getCourse().getTitle());
		}
		session.close();
		return courses;
	}
	
	
	private static  List<Client> clientList() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		@SuppressWarnings("unchecked")
		List<Client> clients = session.createQuery("from Client").list();
		session.close();
		return clients;
	}
	
	private static  List<Course> courseListAll() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		@SuppressWarnings("unchecked")
		List<Course> courses = session.createQuery("from Course").list();
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
	
	
	private static void save(Client client) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();

		session.save(client);
		
		session.getTransaction().commit();
		
		session.close();

	}
	
	private static boolean checkValidated(String input){
		if(input.isEmpty()){
			System.out.println("--------Cannot be blank---------");
			return true;
		}
		return false;
	}
	
	private static int searchIndex(String input){
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		@SuppressWarnings("unchecked")
		List<CourseSession> courseSessions = session.createQuery("from CourseSession").list();
		session.close();
		
		Iterator<CourseSession> iterator = courseSessions.iterator();
		while (iterator.hasNext()) {
			CourseSession courseSession = iterator.next();
			if(input.equals(courseSession.getCourse_code())){
				return courseSession.getId();
			}
		}
		return -1;
	}
	
	private static void inscript(int sessionID){
		
		///FIXME Need to find how to implement course_sessionID 
		System.out.println("--------- FIRST NAME -------");
		String firstname = scan.next();
		if(checkValidated(firstname)){
			return;
		}
		System.out.println("--------- LAST NAME --------");
		String lastname = scan.next();
		if(checkValidated(lastname)){
			return;
		}
		System.out.println("---------  PHONE  ----------");
		String phone = scan.next();
		if(checkValidated(phone)){
			return;
		}
		System.out.println("--------- ADDRESS ----------");
		String address = scan.next();
		if(checkValidated(address)){
			return;
		}
		System.out.println("---------  EMAIL  ----------");
		String email = scan.next();
		if(checkValidated(email)){
			return;
		}

		Client client = new Client(firstname,lastname, phone,address,email, sessionID);
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();

		session.save(client);

		session.getTransaction().commit();

		session.close();

		System.out.println("-- Inscription Completed ---");
		
	}
}
