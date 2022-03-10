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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Dashboard</title>
</head>
<body>

	<div class="container-fluid">
		<h1>Welcome <c:out value="${loggedInUser.firstName}"/>!</h1>
	<table class="table table-striped table-primary my-3">
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
			</tr>
		<tbody>
			<tr class="table-light">
				<td>${loggedInUser.firstName}</td>
				<td>${loggedInUser.lastName}</td>
				<td>${loggedInUser.email}</td>
			</tr>
		</tbody>
	</table>
	<p>
		<a href="/logout" class="btn btn-primary">Logout</a>
	</p>
	</div>

</body>
</html>