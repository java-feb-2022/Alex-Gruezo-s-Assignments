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
<title>Edit Language</title>
</head>
<body>

	<div class="container-fluid">
		<div class="row justify-content-around my-2 gy-3">
			<div class="col-12 col-md-8">
				<form:form action="/languages/delete/${id}" method="delete" class="p-4 bg-dark text-light">
					<div class="d-flex justify-content-end">
						<p><input type="submit" value="delete" class="btn btn-danger"></p>
						<p class="mx-1"><a href="/" class="btn btn-primary">dashboard</a></p>		
					</div>
				</form:form>
	        	<form:form action="/languages/udpate/${language.id}" method="put" modelAttribute="language" class="p-4 bg-dark text-light">
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