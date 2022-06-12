package utils;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mongodb.MongoClient;

import database.pkg.MongoDBDAO;
import object.pkg.Course;
import object.pkg.Grade;
import object.pkg.Student;
import object.pkg.User;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String phone = request.getParameter("phone");
		String major = request.getParameter("major");
		
		Student s = new Student();
		s.setName(name);
		s.setId(id);
		s.setPhone(phone);
		s.setMajor(major);
		s.setGrade(new Grade());
		
		HttpSession session = request.getSession();
		User u = User.class.cast(session.getAttribute("user"));
		Course c = Course.class.cast(session.getAttribute("course"));
		
		String modifyStudent = (String) session.getAttribute("modifyStudent");
		for(int i = 0; i < u.getListCourse().size(); i++) {
			if(u.getListCourse().get(i).getCourseCode() == c.getCourseCode()) {
				if(modifyStudent == null) {
					c.addStudent(s);
					u.setCourse(i, c);
				}
				else 
				for(int j = 0; j < c.getStudent().size(); j++) {
					if(c.getStudent().get(j).getId() == modifyStudent) {
						c.setStudent(j, s);
						u.setCourse(i, c);
					}
				}
				break;
			}
		}
		session.removeAttribute("modifyStudent");
		MongoClient mongo = (MongoClient) request.getServletContext()
				.getAttribute("MONGO_CLIENT");
		MongoDBDAO userDAO = new MongoDBDAO(mongo);
		session.setAttribute("user", u);
		session.setAttribute("course", c);
		userDAO.modifyUser(u.getUser(), u);
		response.sendRedirect("jsp/course.jsp");
	}
}
