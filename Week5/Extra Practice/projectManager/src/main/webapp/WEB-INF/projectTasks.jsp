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
<title>Project Tasks</title>
</head>
<body>

	<div class="container-fluid">
		<div class="d-flex col-12 col-md-8 mx-auto justify-content-between">
			<div class="my-3">
			<h1 class="text-primary">Project: <c:out value="${project.title}"/></h1>
			<h4>Project Lead: <c:out value = "${project.leader.firstName}"/></h4>
			</div>
			<div class="my-2 row align-items-center">
				<p>
					<a href="/logout" class="btn btn-danger">Logout</a>
				</p>
			</div>
		</div>
		<div class="col-12 col-md-8 mx-auto">
        	<form:form action="/projects/${id}/tasks/create" method="post" modelAttribute="newTask" class="p-4 bg-light text-primary">
                <div class="row g-3 my-3">
                	<div class="col-3">
                		<form:label path="ticket" class="py-2">Add a task ticket for the team: </form:label>
                    	<form:errors path="ticket" class="text-danger"/>
                	</div>
                	<div class="col-6">
                		<form:textarea path="ticket" class="form-control"/>
                	</div>
                	<div>
                		<form:errors path="creator" class="error"/>
                		<form:input type="hidden" path="creator" value="${taskCreator.id}" class="form-control"/>
                	</div>
                	<div>
                		<form:errors path="creator" class="error"/>
                		<form:input type="hidden" path="projectTask" value="${project.id}" class="form-control"/>
                	</div>
                </div>
                <p class="col-9 text-end">
                	<a href="/projects" class="btn btn-warning">Cancel</a>
                	<input type="submit" value="Submit" class="btn btn-primary">
              	</p>
          	</form:form>
     	</div>
     	<div class="my-3">
     		<c:forEach items="${tasks}" var="task">
			<p><strong>Added by: <c:out value ="${task.creator.firstName}"/> at <fmt:formatDate type="both" dateStyle="medium" timeStyle="short" value ="${task.createdAt}"/></strong></p>
			<p>${task.ticket}</p>
			<c:if test="${task.creator.id == loggedInUser.id || project.leader.id == loggedInUser.id}">
				<form:form action="/projects/${project.id}/tasks/${task.id}/delete" method="delete">
					<input type="submit" value="Completed" class="btn btn-danger mb-3">
				</form:form>
			</c:if>
			</c:forEach>
     	</div>
     	
     	
	</div>
	
</body>
</html>