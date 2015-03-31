package utbm.java.project.SchoolCourse;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
@WebServlet(name = "FilterServlet", urlPatterns = {"/FilterServlet"})
public class FilterServlet extends HttpServlet {

	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
			
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

	    	String className = request.getParameter("className");
	    	String selectedValue = request.getParameter("location");
	    	
	    	System.out.println(selectedValue);
	    	
	    	RequestDispatcher rd=request.getRequestDispatcher("/jsps/index.jsp");
            rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
	
	public List<Location> getLocationList(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		@SuppressWarnings("unchecked")
		List<Location> locations = session.createQuery("from Location").list();
		session.close();
		return locations;
	}
	
	
	
}
