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
<title>Edit Expense</title>
</head>
<body>

	<div class="container-fluid">
		<div class="row justify-content-around my-2 gy-3">
			<div class="col-12 col-md-8">
	        	<form:form action="/expenses/${expense.id}/update" method="put" modelAttribute="expense" class="p-4 bg-dark text-light">
	            	<div class="d-flex justify-content-between align-items-center">
	            		<h2 class="text-success">Edit Expense</h2>
	            		<p><a href="/" class="text-success">Go back</a></p>
	            	</div>
	            	<div class="row g-3 my-3">
	            		<div class="col-4">
	            			<form:label path="name" class="py-2">Expense Name: </form:label>
	            			<form:errors path="name"/>
	            		</div>
	            		<div class="col-8">
	                    	<form:input path="name" class="form-control"/>
	            		</div>
	            	</div>
	            	<div class="row g-3 my-3">
	            		<div class="col-4">
	            			<form:label path="vendor" class="py-2">Vendor: </form:label>
	            			<form:errors path="vendor"/>
	            		</div>
	            		<div class="col-8">
	            			<form:input path="vendor" class="form-control"/>
	            		</div>
	            	</div>
	            	<div class="row g-3 my-3">
	            		<div class="col-4">
	            			<form:label path="amount" class="py-2">Amount: </form:label>
	                    	<form:errors path="amount"/>
	            		</div>
	            		<div class="col-8">
	            			<form:input type="number" step="0.01" path="amount" class="form-control"/>
	            		</div>
	            	</div>
	            	<div class="row g-3 align-items-start my-3">
	            		<div class="col-4">
							<form:label path="description" class="py-2">Description: </form:label>
	                    	<form:errors path="description"/>	            			
	            		</div>
	            		<div class="col-8">
	            			<form:textarea path="description" class="form-control h-25" rows="5"/>
	            		</div>
	            	</div>
	            	<p class="pt-3 text-end">
	                    <input type="submit" value="Submit" class="btn btn-success">
	               	</p>
	          	</form:form>
	      	</div>
	 	</div>
	 </div>

</body>
</html>