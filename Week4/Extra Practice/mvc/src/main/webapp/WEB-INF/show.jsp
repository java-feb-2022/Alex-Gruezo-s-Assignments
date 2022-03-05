<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>One Book</title>
</head>
<body>
	<div class="container-fluid m-3">
		<h1>${book.title}</h1>
		<p>Description: <c:out value="${book.description}"/></p>
		<p>Language: <c:out value="${book.language}"/></p>
		<p>Number of Pages: <c:out value="${book.numberOfPages}"/></p>
		<a href = "/" class="btn btn-primary">Dashboard</a>
	</div>
</body>
	
		
</html>