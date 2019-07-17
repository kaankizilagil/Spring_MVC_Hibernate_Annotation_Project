<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page  import="java.util.ArrayList,Hibernate.Entity.Student"  %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
	
		<h2>STUDENT VIEW AREA</h2>
		
		<p>Total Student : ${data.size()}</p>
		
		<c:forEach items = "${data}"  var = "student">
			<p>
				<c:out value = "Id = ${student.id}, "/>
        		<c:out value = "Name = ${student.firstName}, "/>
        		<c:out value = "Surname = ${student.secondName}, "/>
        		<c:out value = "Email = ${student.email}, "/>
        		<c:out value = "Gender = ${student.gender}, "/>
        		<c:out value = "College = ${student.college}, "/>
        		<c:out value = "Department = ${student.department}"/>
			</p>
     	</c:forEach>
	
	</body>
</html>