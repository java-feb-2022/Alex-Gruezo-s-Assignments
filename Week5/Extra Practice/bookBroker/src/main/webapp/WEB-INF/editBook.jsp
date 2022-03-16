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
<title>Add Book</title>
</head>
<body>

	<div class="container-fluid">
		<div class="d-flex col-12 col-md-8 mx-auto justify-content-between">
			<div class="my-3">
			<h1 class="text-primary">Change Your Entry!</h1>
			</div>
			<div class="my-2 row align-items-center">
				<p>
					<a href="/books" class="btn btn-dark">Shelf</a>
	        		<a href="/bookmarket" class="btn btn-warning">Book Market</a>
				</p>
			</div>
		</div>
		<div class="col-12 col-md-8 mx-auto">
        	<form:form action="/books/${id}/update" method="put" modelAttribute="editBook" class="p-4 bg-light text-primary">
                <div class="row g-3 my-3">
                	<div class="col-3">
                		<form:label path="title" class="py-2">Title </form:label>
                    	<form:errors path="title" class="text-danger"/>
                	</div>
                	<div class="col-6">
                		<form:input path="title" class="form-control"/>
                	</div>
                </div>
                <div class="row g-3 my-3">
                	<div class="col-3">
                		<form:label path="author" class="py-2">Author </form:label>
                    	<form:errors path="author" class="text-danger"/>
                	</div>
                	<div class="col-6">
                		<form:input path="author" class="form-control"/>
                	</div>
                </div>
                <div class="row g-3 my-3">
                	<div class="col-3">
                		<form:label path="thoughts" class="py-2">Thoughts </form:label>
                    	<form:errors path="thoughts" class="text-danger"/>
                	</div>
                	<div class="col-6">
                		<form:textarea path="thoughts" class="form-control h-25" rows="5"/>
                		<p class="text-end my-3">
                			<input type="submit" value="Submit" class="btn btn-primary">
                		</p>
                	</div>
                	<div>
                		<form:errors path="owner" class="error"/>
                		<form:input type="hidden" path="owner" value="${loggedInUser.id}" class="form-control"/>
                	</div>	
                </div>   
          	</form:form>
          	<form:form action="/books/${id}/delete" method="delete">
          		<p class="text-center my-3">
					<input type="submit" value="Delete" class="btn btn-danger">
				</p>
			</form:form>
     	</div>
	</div>

</body>
</html>