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
<title>Show Book</title>
</head>
<body>

	<div class="container-fluid m-3">
		<div class="col-12 col-md-6 d-flex justify-content-between align-items-center mx-5">
	    	<h1 class="text-dark">${book.title}</h1>
	        <p>
	        	<a href="/books" class="btn btn-dark">Shelf</a>
	        	<a href="/bookmarket" class="btn btn-warning">Book Market</a>
	        </p>
	   	</div>
	   	<div class="col-12 col-md-6 d-flex flex-column mx-5 my-4">
	   	
	   	<c:choose>
	   		<c:when test="${loggedInUser.id != book.owner.id}">	
	   			<p><strong><c:out value="${book.owner.userName}"/></strong> read <strong><c:out value="${book.title}"/></strong> by <c:out value="${book.author}"/></p>
				<h3>Here are their thoughts: </h3>
				<hr/>
				<p><c:out value="${book.thoughts}"/></p>
				<hr/>
			</c:when>
			<c:otherwise>
				<p><strong>You</strong> read <strong><c:out value="${book.title}"/></strong> by <c:out value="${book.author}"/></p>
				<h3>Here are your thoughts: </h3>
				<hr/>
				<p><c:out value="${book.thoughts}"/></p>
				<hr/>
				<p>
					<a href="/books/${book.id}/edit" class="btn btn-info">Edit</a>
				</p>
			</c:otherwise>
		</c:choose>
	   	</div>
	</div>

</body>
</html>