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
<title>Home Page</title>
</head>
<body>

	<div class="container-fluid">
		<div class="d-flex justify-content-start align-items-center">
			<h1>Dojos</h1>
			<a href="/dojos/new" class="btn btn-primary mx-2">New Dojo</a>
			<a href="/ninjas/new" class="btn btn-primary mx-2">New Ninja</a>
		</div>
		<div>
			<table class="table table-primary my-3 table-striped">
				<thead>
					<th>Name</th>
				</thead>
				<tbody>
					<c:forEach items="${dojos}" var="dojo">
					<tr>
						<td><a href = "/dojos/${dojo.id}">
								<c:out value="${dojo.name}"/>
							</a>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>	
	</div>

</body>
</html>