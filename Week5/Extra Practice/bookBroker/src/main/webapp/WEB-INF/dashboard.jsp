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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Dashboard</title>
</head>
<body>

	<div class="container-fluid">
		<div class="d-flex justify-content-between">
			<div class="my-2">
				<h1>Welcome, <c:out value="${loggedInUser.userName}"/></h1>
				<h4>Books from everyone's shelves:</h4>
			</div>
			<div class="my-2">
				<p class="text-center">
					<a href="/logout" class="btn btn-danger">Logout</a>
				</p>
				<p>
					<a href="/books/new" class="btn btn-primary">Add Book</a>
				</p>
			</div>
		</div>
	<table class="table table-striped table-primary my-3">
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author Name</th>
				<th>Posted By</th>
			</tr>
		<tbody>
			<c:forEach items="${books}" var="book">
			<tr class="table-light">
			
				<td>${book.id}</td>
				<td><a href="books/${book.id}"><c:out value="${book.title}"/></a></td>
				<td>${book.author}</td>
				<td>${book.owner.userName}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<p class="text-center"><a href="/bookmarket" class="btn btn-warning">Book Market</a></p>
	</div>
	
	
	

</body>
</html>