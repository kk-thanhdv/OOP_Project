<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="object.pkg.User" %>
<%@ page import="object.pkg.Course" %>
<%@ page import="object.pkg.Student" %>
<%@ page import="object.pkg.Grade" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student</title>
</head>
<body>
Student name: ${student.name }<br>
Student id: ${student.id }<br>
Student phone: ${student.phone }<br>
<br><a href="addgrade.jsp">Add grade component</a>

<%
	Student s = Student.class.cast(session.getAttribute("student"));
	Grade g = s.getGrade();
	List<Grade.GradeComponent> gc = g.getGrade();
	Grade.GradeComponent[] gcList = new Grade.GradeComponent[gc.size()];
	gc.toArray(gcList);
	session.setAttribute("gradecomponents", gcList);
	session.setAttribute("totalGrade", g.calculateGrade());
	session.setAttribute("totalLetter", g.calculateLetter());
%>

<table>
		<tr>
			<th scope="col">Title</th>
			<th scope="col">Grade</th>
			<th scope="col">Max grade</th>
			<th scope="col">Scale</th>
			<th scope="col">Edit</th>
		</tr>
		<tr>
			<c:forEach items="${gradecomponents}" var="gradecomponent">
				<c:url value="addgrade.jsp" var="modify">
					<c:param name="modifyGrade" value="${gradecomponent.id}" />
				</c:url>
				<tr>
					<td><c:out value="${gradecomponent.title}"></c:out></td>
					<td><c:out value="${gradecomponent.grade}"></c:out></td>
					<td><c:out value="${gradecomponent.maxGrade}"></c:out></td>
					<td><c:out value="${gradecomponent.scale}"></c:out></td>
					<td><a href='<c:out value="${modify}" escapeXml="true"></c:out>'>Edit</a></td>
				</tr>
			</c:forEach> 
		</tr>
		
	</table>
	Grade: <c:out value="${totalGrade}"></c:out><br>
	Grade letter: <c:out value="${totalLetter}"></c:out>
</body>
</html>