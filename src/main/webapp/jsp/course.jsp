<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="object.pkg.User" %>
<%@ page import="object.pkg.Course" %>
<%@ page import="object.pkg.Student" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course</title>
</head>
<body>
Course code: ${course.courseCode }<br>
Course name: ${course.courseName }<br>
Course description: ${course.description }<br>
<br><a href="addstudent.jsp">Add new student</a>

<%
	Course c = Course.class.cast(session.getAttribute("course"));
	Student[] students = new Student[c.getStudent().size()];
	c.getStudent().toArray(students);
	session.setAttribute("students", students);
%>

<table>
		<tr>
			<th scope="col">Student name</th>
			<th scope="col">Student ID</th>
			<th scope="col">Student phone</th>
			<th scope="col">Student major</th>
			<th scope="col">Edit</th>
			<th scope="col">Grade</th>
		</tr>
		<tr>
			<c:forEach items="${students}" var="student">
				<c:url value="addstudent.jsp" var="modify">
					<c:set var="modifyStudent" value="${student.id}" scope="session" />
				</c:url>
				<c:url value="student.jsp" var="detail">
					<c:set var="student" value="${student}" scope="session" />
				</c:url>
				<tr>
					<td><c:out value="${student.name}"></c:out></td>
					<td><c:out value="${student.id}"></c:out></td>
					<td><c:out value="${student.phone}"></c:out></td>
					<td><c:out value="${student.major}"></c:out></td>
					<td><a href='<c:out value="${modify}" escapeXml="true"></c:out>'>Edit</a></td>
					<td><a href='<c:out value="${detail}" escapeXml="true"></c:out>'>Grade</a></td>
				</tr>
			</c:forEach> 
		</tr>
		
	</table>

</body>
</html>