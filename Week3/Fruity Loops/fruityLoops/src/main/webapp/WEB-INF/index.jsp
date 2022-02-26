<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Fruity Loops</title>
</head>
<body>
	<h1 class="text-danger my-3">Fruit Store</h1>

	<table class="table border border-danger border-5 my-5">
		<thead>
			<tr>
				<th>Name</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="fruit" items="${fruits}">
			<tr>
				<td class=""><c:out value="${fruit.name}"/></td>
				<td><c:out value="${fruit.price}"/></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>