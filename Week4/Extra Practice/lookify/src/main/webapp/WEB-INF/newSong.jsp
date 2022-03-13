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
<title>New Song</title>
</head>
<body>

	<div class="container-fluid">
		<a href="/dashboard">Dashboard</a>
		<div class="row justify-content-around my-2">
			<div class="col-12 col-md-9">
	        	<form:form action="/songs/create" method="post" modelAttribute="song" class="p-4 bg-dark text-light">
	            	<h2 class="text-primary">Add a Song</h2>
	            		<div class="row g-3 my-3">
	            			<div class="col-6">
	            				<form:label path="title" class="py-2">Title </form:label>
	            				<form:errors path="title"/>
	            			</div>
	            			<div class="col-6">
	                    		<form:input path="title" class="form-control"/>
	            			</div>
	            		</div>
	            		<div class="row g-3 my-3">
	            			<div class="col-6">
	            				<form:label path="artist" class="py-2">Artist </form:label>
	            				<form:errors path="artist"/>
	            			</div>
	            			<div class="col-6">
	            				<form:input path="artist" class="form-control"/>
	            			</div>
	            		</div>
	            		<div class="row g-3 my-3">
	            			<div class="col-6">
	            				<form:label path="rating" class="py-2">Rating (1-10) </form:label>
	                    		<form:errors path="rating"/>
	            			</div>
	            			<div class="col-6">
	            				<form:input type="number" path="rating" class="form-control"/>
	            			</div>
	            		</div>
	            		<p class="pt-3 text-end">
	                    <input type="submit" value="Add Song" class="btn btn-primary">
	                    </p>   
	          	</form:form>
	      	</div>
	 	</div>
	 </div>

</body>
</html>