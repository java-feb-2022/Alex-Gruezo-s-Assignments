<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>All Books</title>
</head>
<body>

<h1>ALL BOOKS</h1>

<table class="table table-primary">
	<thead>
		<th>Title</th>
		<th>Language</th>
		<th>Number of Pages</th>
	</thead>
	<tbody>
		<c:forEach items="${books}" var = "book">
		<tr>
			<td><a href = "/books/${book.id}">${book.title}</a></td>
			<td>${book.language}</td>
			<td>${book.numberOfPages}</td>
		</tr>
		</c:forEach>
	</tbody>


</table>






</body>
</html>