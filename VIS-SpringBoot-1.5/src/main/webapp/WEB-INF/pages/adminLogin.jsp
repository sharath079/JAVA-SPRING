<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
        
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
h2 {
   text-align: center;
}
</style>
</head>
<body>
      <h2>VIS Admin Login Page</h2>
      <br>
      <div class="container">
      <form:form modelAttribute="adminCmd">
      <div class="form-group">
        <label for="username">User Name</label>
        <input type="text" class="form-control" name="name" id="username" placeholder="Enter Username">
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" name="password" id="password" placeholder="Enter Password">
      </div>
      <br>
      <button type="submit" class="btn btn-primary">Login</button>
      </form:form>
      </div>
      <script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>