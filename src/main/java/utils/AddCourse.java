package utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mongodb.MongoClient;

import database.pkg.MongoDBDAO;
import object.pkg.Course;
import object.pkg.Student;
import object.pkg.User;
import object.pkg.Time;

/**
 * Servlet implementation class AddCourse
 */
@WebServlet("/AddCourse")
public class AddCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCourse() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		float credit = Float.parseFloat(request.getParameter("credit"));
		String courseName = request.getParameter("courseName");
		String courseCode = request.getParameter("courseCode");
		String description = request.getParameter("description");
		String[] dayString = request.getParameterValues("day");
		List<Integer> day = new ArrayList<Integer>();
		for(String s : dayString) {
			day.add(Integer.valueOf(s));
		}
		int startHour = Integer.parseInt(request.getParameter("startHour"));
		int startMin = Integer.parseInt(request.getParameter("startMin"));
		int endHour = Integer.parseInt(request.getParameter("endHour"));
		int endMin = Integer.parseInt(request.getParameter("endMin"));
		Course c = new Course();
		Time time = new Time();
		c.setCredit(credit);
		c.setCourseCode(courseCode);
		c.setCourseName(courseName);
		c.setDescription(description);
		List<Student> emptyList = new ArrayList<Student>();
		c.setStudent(emptyList);
		
		time.setDay(day);
		time.setStartHour(startHour);
		time.setEndHour(endHour);
		time.setStartMin(startMin);
		time.setEndMin(endMin);
		
		c.setTime(time);

		HttpSession session = request.getSession();
		User u = User.class.cast(session.getAttribute("user"));
		String modifyCourse = (String) session.getAttribute("modifyCourse");
		if(modifyCourse == null) {	
			u.addCourse(c);
			System.out.println(u.getListCourse().size());
		}
		else {
			for(int i = 0; i < u.getListCourse().size(); i++) {
				if(u.getListCourse().get(i).getCourseCode() == modifyCourse) {
					System.out.print(u.getListCourse().size());
					u.setCourse(i, c);
					System.out.println(u.getListCourse().size());
					break;
				}
			}
			session.removeAttribute("modifyCourse");
		}
		MongoClient mongo = (MongoClient) request.getServletContext()
				.getAttribute("MONGO_CLIENT");
		MongoDBDAO userDAO = new MongoDBDAO(mongo);
		userDAO.modifyUser(u.getUser(), u);
		session.setAttribute("user", u);
		response.sendRedirect("jsp/welcome.jsp");
	}
}
