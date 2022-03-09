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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>New Dojo</title>
</head>
<body>

	<div class="container-fluid">
	
		<h1>New Dojo</h1>
	
		<form:form action="/dojos/create" class="col-4" method="post" modelAttribute="dojo">
			<p>
				<form:label path="name"><strong>Name</strong></form:label>
				<form:errors path="name"/>
				<form:input path="name" class="form-control"/>
			</p>
			<p>
				<input type="submit" value="create" class="btn btn-primary"> 
			</p>

		</form:form>
	</div>

</body>
</html>