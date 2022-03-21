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
<script src="js/app.js" type="text/javascript" ></script>
<title>Dashboard</title>
</head>
<body>

	<div class="container-fluid">
		<div class="d-flex justify-content-between">
			<div class="my-2">
				<h1>Welcome, <c:out value="${loggedInUser.firstName}"/></h1>
				<h4>All projects</h4>
			</div>
			<div class="my-2">
				<p class="text-center">
					<a href="/logout" class="btn btn-danger">Logout</a>
				</p>
				<p>
					<a href="/projects/new" class="btn btn-primary">+ New Project</a>
				</p>
			</div>
		</div>
		<table class="table table-striped table-primary my-3">
			<thead>
				<tr>
					<th>ID</th>
					<th>Project</th>
					<th>Team Lead</th>
					<th>Due Date</th>
					<th>Actions</th>
				</tr>
			<tbody>
				<c:forEach items="${projects}" var="project">
				<tr class="table-light">
					<td>${project.id}</td>
					<td><a href="projects/${project.id}"><c:out value="${project.title}"/></a></td>
					<td>${project.leader.firstName}</td>
					<td>${project.dueDate}</td>
					<td>
						<c:if test="${loggedInUser.id != project.leader.id}">
							<c:choose>
								<c:when test="${project.projectJoiners.contains(userLoggedIn)}">
								</c:when>
								<c:otherwise>
									<a href="/projects/${project.id}/join" class="btn btn-success">Join Team</a>
								</c:otherwise>
							</c:choose>
						</c:if>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<div class="col-6 mx-auto">
		<h4 class="text-center">Your Projects</h4>
		<table class="table table-striped table-primary my-3">
			<thead>
				<tr>
					<th>ID</th>
					<th>Project</th>
					<th>Team Lead</th>
					<th>Due Date</th>
					<th class="text-center">Actions</th>
				</tr>
			<tbody>
				<c:forEach items="${projects}" var="project">
				<tr class="table-light">
					<c:if test="${project.projectJoiners.contains(userLoggedIn) || loggedInUser.id == project.leader.id}">
						<td>${project.id}</td>
						<td><a href="projects/${project.id}"><c:out value="${project.title}"/></a></td>
						<td>${project.leader.firstName}</td>
						<td>${project.dueDate}</td>
						<td class="d-flex justify-content-center">
							<c:choose>
								<c:when test="${loggedInUser.id == project.leader.id}">
									<a href="/projects/${project.id}/edit" class="btn btn-primary mx-1">Edit</a>
									<form:form action="/projects/${project.id}/delete" method="delete">
										<input type="submit" value="Delete" class="btn btn-danger">
									</form:form>
								</c:when>
								<c:otherwise>
									<a href="/projects/${project.id}/leave" class="btn btn-dark">Leave Team</a>
								</c:otherwise>
							</c:choose>
						</td>
					</c:if>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
	</div>

</body>
</html>