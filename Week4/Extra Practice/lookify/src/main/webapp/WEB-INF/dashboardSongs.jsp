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
<title>Songs Dashboard</title>
</head>
<body>

	<div class="container-fluid my-3">
		<div class="d-flex">
			<div class="col-12">
				<ul class="d-flex flex-row justify-content-between list-unstyled">
					<li class="mx-1"><a href="/songs/new">Add new</a></li>
					<li class="mx-1"><a href="/search/topTen">Top Songs</a></li>
					<li class="mx-5">
						<form action="/search" method="post">
							<div class="row g-3">
								<div class="col-7 g-3">
									<input name="artist" class="form-control">
								</div>
								<div class="col-5 g-3">
									<input type="submit" value="Search Artist" class="btn btn-primary form-control">
								</div>
							</div>
						</form>
					</li>
				</ul>
			</div>
			
		</div>
		<div>
			<table class="table table-primary my-3">
				<thead>
					<th>Name</th>
					<th>Rating</th>
					<th>Actions</th>
				</thead>
				<tbody>
					<c:forEach items="${songs}" var="song">
					<tr>
						<td><a href = "/songs/${song.id}">${song.title}</a></td>
						<td>${song.rating}</td>
						<td class="d-flex justify-content-start">
							<form:form action="/songs/delete/${song.id}" method="delete">
    							<input type="submit" value="delete" class="btn btn-danger mx-1">
							</form:form>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>