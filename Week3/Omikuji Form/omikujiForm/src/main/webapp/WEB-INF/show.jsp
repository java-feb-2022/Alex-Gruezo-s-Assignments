<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Show</title>
</head>
<body>

	<h1 class="text-center my-3">Here's Your Omikuji!</h1>
	<div class="card text-dark bg-primary mx-auto mb-3" style="max-width: 18rem;">
  		<div class="card-body">
    			<h5 class="card-text">In <c:out value="${number}"/> years, you will live in <c:out value="${city}"/> with <c:out value="${name}"/> as your roommate, <c:out value="${hobby}"/> for a living. The next time you see a <c:out value="${livingThing}"/> you will have good luck. <c:out value="${quote}"/>.</h5>
  		</div>
	</div>
	<p class="text-center my-3"><a href="/">Go Back</a></p>

</body>
</html>