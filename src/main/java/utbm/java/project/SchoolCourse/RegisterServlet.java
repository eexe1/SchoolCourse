package utbm.java.project.SchoolCourse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String fName = request.getParameter("firstName");
        String lName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("lastName");
        String input = request.getParameter("course");
        try {        
        	int sessionID = searchIndex(input);
        	Client client = new Client(fName,lName, address,phone, email, sessionID);	
            RegisterService registerService = new RegisterService();
            registerService.register(client);            
            out.println("<html>");
            out.println("<head>");            
            out.println("<title>Registration Successful</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
//            if(result){
                out.println("<h1>Registration Successful</h1>");
//            }else{
//                out.println("<h1>Registration Unsuccessful</h1>");
//                out.println("To try again<a href=register.jsp>Click here</a>");
//            }
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
	private int searchIndex(String input){
		
		System.out.println("Input is " + input);
		
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
}
