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
<title>Show Project</title>
</head>
<body>

	<div class="container-fluid m-3">
		<div class="col-12 col-md-6 d-flex justify-content-between align-items-center mx-5">
	    	<h1 class="text-dark">Project Details</h1>
	        <p>
	        	<a href="/projects" class="btn btn-warning">Projects</a>
	        	<a href="/projects/new" class="btn btn-primary">New Project</a>
	        </p>
	   	</div>
	   	<div class="col-12 col-md-8 mx-auto">
        	
                <div class="row g-3 my-3">
                	<div class="col-3">
                		<h5>Project</h5>
                	</div>
                	<div class="col-6">
                		${project.title}
                	</div>
                </div>
                <div class="row g-3 my-3">
                	<div class="col-3">
                		<h5>Description</h5>
                	</div>
                	<div class="col-6">
                		${project.description}
                	</div>
                </div>
                <div class="row g-3 my-3">
                	<div class="col-3">
                		<h5>Due Date</h5>
                	</div>
                	<div class="col-6">
                		${project.dueDate}
                	</div>
                	<div>
                		
                	</div>
                </div>
                <p class="col-9">
                	<c:if test="${project.projectJoiners.contains(userLoggedIn) || project.leader.id == userLoggedIn.id }">
                	<a href="/projects/${id}/tasks" class="btn btn-info">See tasks</a>
                	</c:if>
              	</p>
     	</div>
	</div>
	

</body>
</html>