<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Form</title>
</head>
<body>
	<div class="container-fluid">
        <div class="row justify-content-around gy-3">
            <div class="col-12 col-md-4">
            	<h1 class="text-primary text-center">Send an Omikuji!</h1>
                <form action="/submit" method="post" class="px-4 py-2 bg-dark text-light">
                    <label for="number" class="py-2">Pick any number from 5 to 25:</label>
                    <input type="number" name="number" class="form-control" required>
                    <label for="city" class="py-2">Enter the name of any city:</label>
                    <input type="text" name="city" class="form-control" required>
                    <label for="name" class="py-2">Enter the name of any real person:</label>
                    <input type="text" name="name" class="form-control" required>
                    <label for="hobby" class="py-2">Enter professional endeavor or hobby:</label>
                    <input type="text" name="hobby" class="form-control" required>
                    <label for="livingThing" class="py-2">Enter any type of living thing:</label>
                    <input type="text" name="livingThing" class="form-control">
                    <label for="quote" class="py-2">Say something nice to someone:</label>
                    <textarea name="quote" class="form-control" rows="3" required></textarea>
                    <p class="fst-italic my-3">Send and show a friend</p>
                    <p class=" text-end">
                        <input type="submit" value="Send" class="btn btn-primary">
                    </p>
                </form>
            </div>
</body>
</html>