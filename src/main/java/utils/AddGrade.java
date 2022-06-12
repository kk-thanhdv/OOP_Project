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
 * Servlet implementation class AddGrade
 */
@WebServlet("/AddGrade")
public class AddGrade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGrade() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	String title = request.getParameter("title");
		double grade = Double.parseDouble(request.getParameter("grade"));
		double maxGrade = Double.parseDouble(request.getParameter("maxGrade"));
		double scale = Double.parseDouble(request.getParameter("scale"));
		
		Grade.GradeComponent gc = new Grade(). new GradeComponent();
		gc.setTitle(title);
		gc.setGrade(grade);
		gc.setMaxGrade(maxGrade);
		gc.setScale(scale);
		
		HttpSession session = request.getSession();
		User u = User.class.cast(session.getAttribute("user"));
		Course c = Course.class.cast(session.getAttribute("course"));
		Student s = Student.class.cast(session.getAttribute("student"));
		
		int modifyGrade;
		if(request.getParameter("modifyGrade") == null) {
			modifyGrade = -1;
		}
		else {
			modifyGrade = Integer.parseInt(request.getParameter("modifyGrade"));
			if(modifyGrade < 1) modifyGrade = -1;
		}
		for(int i = 0; i < u.getListCourse().size(); i++) {
			if(u.getListCourse().get(i).getCourseCode() == c.getCourseCode()) {
				for(int j = 0; j < c.getStudent().size(); j++) {
					if(c.getStudent().get(j).getId() == s.getId()) {
						if(modifyGrade == -1) {
							Grade grade2 = s.getGrade();
							gc.setId(grade2.getGrade().size() + 1);
							grade2.addGrade(gc);
							s.setGrade(grade2);
							c.setStudent(j, s);
							u.setCourse(i, c);
						}
						else {
							Grade grade2 = s.getGrade();
							gc.setId(modifyGrade);
							grade2.setGrade(modifyGrade - 1, gc);
							s.setGrade(grade2);
							c.setStudent(j, s);
							u.setCourse(i, c);
						}
						break;
					}
				}
			}
		}
		MongoClient mongo = (MongoClient) request.getServletContext()
				.getAttribute("MONGO_CLIENT");
		MongoDBDAO userDAO = new MongoDBDAO(mongo);
		session.setAttribute("user", u);
		session.setAttribute("course", c);
		session.setAttribute("student", s);
		userDAO.modifyUser(u.getUser(), u);
		response.sendRedirect("jsp/student.jsp");
	}

}
