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
<title>Edit Project</title>
</head>
<body>

<div class="container-fluid">
		<div class="d-flex col-12 col-md-8 mx-auto justify-content-between">
			<div class="my-3">
			<h1 class="text-primary">Edit Project</h1>
			</div>
			<div class="my-2 row align-items-center">
				<p>
					<a href="/logout" class="btn btn-danger">Logout</a>
				</p>
			</div>
		</div>
		<div class="col-12 col-md-8 mx-auto">
        	<form:form action="/projects/${id}/update" method="put" modelAttribute="editProject" class="p-4 bg-light text-primary">
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
                		<form:label path="description" class="py-2">Description </form:label>
                    	<form:errors path="description" class="text-danger"/>
                	</div>
                	<div class="col-6">
                		<form:textarea path="description" class="form-control h-25" rows="5"/>
                	</div>
                </div>
                <div class="row g-3 my-3">
                	<div class="col-3">
                		<form:label path="dueDate" class="py-2">Due Date </form:label>
                    	<form:errors path="dueDate" class="text-danger"/>
                	</div>
                	<div class="col-6">
                		<form:input type="text" path="dueDate" id="datefield" class="date form-control"/>
                	</div>
                	<div>
                		<form:errors path="leader" class="error"/>
                		<form:input type="hidden" path="leader" value="${loggedInUser.id}" class="form-control"/>
                	</div>
                </div>
                <p class="col-9 text-end">
                	<a href="/projects" class="btn btn-warning">Cancel</a>
                	<input type="submit" value="Submit" class="btn btn-primary">
              	</p>
          	</form:form>
          	
          	
     	</div>
	</div>

</body>
<script type="text/javascript">
	$(".date").datepicker({
		format: "MM d yyyy",
	});
	
	
</script>

</html>