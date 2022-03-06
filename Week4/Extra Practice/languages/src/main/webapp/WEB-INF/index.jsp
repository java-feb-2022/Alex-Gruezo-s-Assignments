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
<title>Insert title here</title>
</head>
<body>

	<h1 class="text-primary mx-2"><a href="/" class="text-decoration-none">Save Travels</a></h1>

	<table class="table table-primary my-3">
		<thead>
			<th>Name</th>
			<th>Creator</th>
			<th>Version</th>
			<th>Actions</th>
		</thead>
		<tbody>
			<c:forEach items="${languages}" var="language">
			<tr>
				<td><a href = "/languages/${language.id}">${language.name}</a></td>
				<td>${language.creator}</td>
				<td><fmt:formatNumber value="${language.currentVersion}" minFractionDigits="2"/></td>
				<td class="d-flex justify-content-start">
					<form:form action="/languages/delete/${expense.id}" method="delete">
    					<input type="submit" value="delete" class="btn btn-danger mx-1">
					</form:form>
					<a href = "/languages/edit/${language.id}" class="btn btn-primary mx-1">edit</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div class="container-fluid">
		<div class="row justify-content-around my-2">
			<div class="col-12 col-md-9">
	        	<form:form action="/languages/create" method="post" modelAttribute="language" class="p-4 bg-dark text-light">
	            	<h2 class="text-primary">Add a Language</h2>
	            		<div class="row g-3 my-3">
	            			<div class="col-6">
	            				<form:label path="name" class="py-2">Name </form:label>
	            				<form:errors path="name"/>
	            			</div>
	            			<div class="col-6">
	                    		<form:input path="name" class="form-control"/>
	            			</div>
	            		</div>
	            		<div class="row g-3 my-3">
	            			<div class="col-6">
	            				<form:label path="creator" class="py-2">Creator </form:label>
	            				<form:errors path="creator"/>
	            			</div>
	            			<div class="col-6">
	            				<form:input path="creator" class="form-control"/>
	            			</div>
	            		</div>
	            		<div class="row g-3 my-3">
	            			<div class="col-6">
	            				<form:label path="currentVersion" class="py-2">Version </form:label>
	                    		<form:errors path="currentVersion"/>
	            			</div>
	            			<div class="col-6">
	            				<form:input type="number" step=".001" path="currentVersion" class="form-control"/>
	            			</div>
	            		</div>
	            		<p class="pt-3 text-end">
	                    <input type="submit" value="Submit" class="btn btn-primary">
	                    </p>   
	          	</form:form>
	      	</div>
	 	</div>
	 </div>

</body>
</html>