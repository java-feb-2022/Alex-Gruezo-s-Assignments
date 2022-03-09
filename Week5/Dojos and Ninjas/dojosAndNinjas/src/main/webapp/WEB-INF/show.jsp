<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Show</title>
</head>
<body>

	<div class="container-fluid">
		<div>
			<h1><c:out value="${dojo.name}"/> Location Ninjas</h1>
		</div>
		<div>
			<table class="table table-primary my-3 table-striped">
				<thead>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
				</thead>
				<tbody>
					<c:forEach items="${dojo.ninjas}" var="ninja">
						<tr>
							<td>${ninja.firstName}</td>
							<td>${ninja.lastName}</td>
							<td>${ninja.age}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>	
	</div>

</body>
</html>