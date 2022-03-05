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
<title>Dashboard</title>
</head>
<body>

	<h1 class="text-primary mx-2">Save Travels</h1>

	<table class="table table-primary my-3">
		<thead>
			<th>Expense</th>
			<th>Vendor</th>
			<th>Amount</th>
			<th>Actions</th>
			<th></th>
		</thead>
		<tbody>
			<c:forEach items="${expenses}" var="expense">
			<tr>
				<td><a href = "/expenses/${expense.id}">${expense.name}</a></td>
				<td>${expense.vendor}</td>
				<td><fmt:formatNumber value="${expense.amount}" type="currency"/></td>
				<td><a href = "/expenses/${expense.id}/edit" class="btn btn-primary">edit</a></td>
				<td>
					<form:form action="/expenses/${expense.id}/delete" method="delete">
    					<input type="submit" value="delete" class="btn btn-danger">
					</form:form>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div class="container-fluid">
		<div class="row justify-content-around my-2">
			<div class="col-12 col-md-9">
	        	<form:form action="/expenses/create" method="post" modelAttribute="expense" class="p-4 bg-dark text-light">
	            	<h2 class="text-primary">Add an Expense</h2>
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
	            				<form:input type="number" step="0.01" value="0.00" path="amount" class="form-control"/>
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
	                    <input type="submit" value="Submit" class="btn btn-primary">
	                    </p>   
	          	</form:form>
	      	</div>
	 	</div>
	 </div>

</body>
</html>