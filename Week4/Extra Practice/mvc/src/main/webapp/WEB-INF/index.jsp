<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>All Books</title>
</head>
<body>

	<nav class="d-flex justify-content-end align-items-center col-12 my-3">
    	<div class="d-flex col-4 justify-content-end mx-3">
            <a href = "/books/new" class="btn btn-primary">New Book</a>
        </div>
    </nav>

	<h1 class="mx-2">ALL BOOKS</h1>

	<table class="table table-primary">
		<thead>
			<th>Title</th>
			<th>Language</th>
			<th>Number of Pages</th>
			<th></th>
			<th></th>
		</thead>
		<tbody>
			<c:forEach items="${books}" var = "book">
			<tr>
				<td><a href = "/books/${book.id}">${book.title}</a></td>
				<td>${book.language}</td>
				<td>${book.numberOfPages}</td>
				<td><a href = "/books/${book.id}/edit" class="btn btn-primary">edit</a></td>
				<td>
					<form:form action="/books/${book.id}/delete" method="delete">
    					<%-- <input type="hidden" name="_method" value="delete"> --%>
    					<input type="submit" value="delete" class="btn btn-danger">
					</form:form>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

	




</body>
</html>