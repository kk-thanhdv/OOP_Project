package utils;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.MongoClient;

import database.pkg.MongoDBDAO;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Register() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String userName = request.getParameter("user");
		String passWord = request.getParameter("pass");
		String passWord1 = request.getParameter("pass1");
		if(!passWord.equals(passWord1)) {
			response.sendRedirect("jsp/register.jsp");
		}
		else {
			MongoClient mongo = (MongoClient) request.getServletContext()
					.getAttribute("MONGO_CLIENT");
			MongoDBDAO userDAO = new MongoDBDAO(mongo);
			if(userDAO.queryUser(userName) != null) {
				System.out.println("User already existed");
				response.sendRedirect("jsp/register.jsp");
			}
			else {
				userDAO.createUser(name, userName, passWord);
				System.out.println("Successfully create an user!");
				request.setAttribute("notification", "Register successfully!");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
			}
		}
	}
}
