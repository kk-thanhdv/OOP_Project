package utils;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mongodb.MongoClient;

import database.pkg.MongoDBDAO;
import object.pkg.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("user");
		String passWord = request.getParameter("pass");
		MongoClient mongo = (MongoClient) request.getServletContext()
				.getAttribute("MONGO_CLIENT");
		MongoDBDAO userDAO = new MongoDBDAO(mongo);
		User u = userDAO.queryUser(userName);
		if(u != null && u.getPass().equals(passWord)) {
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
			session.setAttribute("listCourse", u);
			response.sendRedirect("jsp/welcome.jsp");
		}
		else {
			request.setAttribute("notification", "Invalid username or password");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}
}
