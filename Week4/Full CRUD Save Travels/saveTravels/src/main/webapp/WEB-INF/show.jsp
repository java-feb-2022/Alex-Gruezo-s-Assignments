<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>Show Expense</title>
</head>
<body>

	<div class="container-fluid m-3">
		<div class="col-12 col-md-6 d-flex justify-content-between align-items-center mx-5">
	    	<h2 class="text-primary">Expense Details</h2>
	        <p><a href="/">Go back</a></p>
	   	</div>
	   	<div class="col-12 col-md-6 d-flex flex-column mx-5 my-4">
	   		<p><strong>Expense Name: </strong><c:out value="${expense.name}"/></p>
			<p><strong>Expense Description: </strong><c:out value="${expense.description}"/></p>
			<p><strong>Vendor: </strong><c:out value="${expense.vendor}"/></p>
			<p><strong>Amount Spent: </strong><c:out value="${expense.amount}"/></p>	
	   	</div>
	</div>

</body>
</html>