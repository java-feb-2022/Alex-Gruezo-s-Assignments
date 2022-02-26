<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Counter 2X</title>
</head>
<body>

	<div class="mx-3 my-5">
		<p>You have visited http://localhost:8080 <c:out value="${currentCount}"/> times.
	</p>
	<p><a href="http://localhost:8080/">Test another visit?</a>
	</div>
	
</body>
</html>