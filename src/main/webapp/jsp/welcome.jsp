<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="object.pkg.User" %>
<%@ page import="object.pkg.Course" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.css">
<title>Welcome!</title>
</head>
<body>
	<%
		if(session.getAttribute("user")==null) {
			response.sendRedirect("index.jsp");
		}
		User u = User.class.cast(session.getAttribute("user"));
		out.println("Hello " + u.getName());
		Course[] courses = new Course[u.getListCourse().size()];
		u.getListCourse().toArray(courses);
		session.setAttribute("courses", courses);
	%>
	<form action="/../OOP_Project/Logout">
		<button type="submit" value="Logout">Log out</button>
	</form>
	
	<table>
		<tr>
			<th>Course code</th>
			<th>Course name</th>
			<th>Edit</th>
			<th>Details</th>
		</tr>
		<tr>
			<c:forEach items="${courses}" var="course">
				<c:url value="addcourse.jsp" var="modify">
					<c:set var="modifyCourse" value="${course.courseCode}" scope="session" />
				</c:url>
				<c:url value="course.jsp" var="detail">
					<c:set var="course" value="${course}" scope="session" />
				</c:url>
				<tr>
					<td><c:out value="${course.courseCode}"></c:out></td>
					<td><c:out value="${course.courseName}"></c:out></td>
					<td><a href='<c:out value="${modify}" escapeXml="true"></c:out>'>Edit</a></td>
					<td><a href='<c:out value="${detail}" escapeXml="true"></c:out>'>Details</a></td>
				</tr>
			</c:forEach> 
		</tr>
		
	</table>
	
	<br><a href="addcourse.jsp">Add new course</a>
</body>
</html>