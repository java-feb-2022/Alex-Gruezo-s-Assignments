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
<title>New Ninja</title>
</head>
<body>

	<div class="container-fluid">
	
		<h1>New Ninja</h1>
	
		<form:form action="/ninjas/create" method="post" modelAttribute="ninja" class="col-4">
			<p>
				<form:label path="dojo"><strong>Dojo</strong></form:label>
				<form:select path="dojo" class="form-select">
        			<c:forEach var="dojo" items="${dojos}">
            			<!--- Each option VALUE is the id of the person --->
           				<form:option value="${dojo.id}" path="dojo">
            				<!--- This is what shows to the user as the option --->
                			<c:out value="${dojo.name}"/>
            			</form:option>
        			</c:forEach>
    			</form:select>
			</p>
			<p>
				<form:label path="firstName"><strong>First Name</strong></form:label>
				<form:errors path="firstName"/>
				<form:input path="firstName" class="form-control"/>
			</p>
			<p>
				<form:label path="lastName"><strong>Last Name</strong></form:label>
				<form:errors path="lastName"/>
				<form:input path="lastName" class="form-control"/>
			</p>
			<p>
				<form:label path="age"><strong>Age</strong></form:label>
				<form:errors path="age"/>
				<form:input path="age" type="number" class="form-control"/>
			</p>
			<p>
				<input type="submit" value="create" class="btn btn-primary"> 
			</p>

		</form:form>
	</div>
</body>
</html>