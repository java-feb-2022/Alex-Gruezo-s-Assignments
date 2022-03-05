<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>All Books</title>
</head>
<body>


	<div class="container-fluid">
		<div class="row justify-content-around my-2 gy-3">
			<div class="col-12 col-md-4">
	        	<form:form action="/books/create" method="post" modelAttribute="book" class="p-4 bg-dark text-light">
	            	<h2 class="text-primary">New Book</h2>
	                    <form:label path="title" class="py-2">Title: </form:label>
	                    <form:errors path="title"/>
	                    <form:input path="title" class="form-control"/>
	                    <form:label path="description" class="py-2">Description: </form:label>
	                    <form:errors path="description"/>
	                    <form:textarea path="description" class="form-control rows='3' h-25"/>
	                    <form:label path="language" class="py-2">Language: </form:label>
	                    <form:errors path="language"/>
	                    <form:input path="language" class="form-control"/>
	                    <form:label path="numberOfPages" class="py-2">Pages: </form:label>
	                    <form:errors path="numberOfPages"/>
	                    <form:input type="number" path="numberOfPages" class="form-control"/>
	                    <p class="pt-3">
	                        <input type="submit" value="Submit" class="btn btn-primary">
	                        <a href = "/" class="btn btn-primary">Dashboard</a>
	                    </p>
	          	</form:form>
	      	</div>
	 	</div>
	 </div>
	 
</body>
</html>