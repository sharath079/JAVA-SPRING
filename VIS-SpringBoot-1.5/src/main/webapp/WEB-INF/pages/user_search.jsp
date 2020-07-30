<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
    span {
        color: red;
        text-decoration: none;
    }
   
</style>
<title>User Search Page</title>
<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
      <h2 style="color:blue;text-align: center;">User Details Search</h2>
      
      <div class="container">
      <form:form modelAttribute="Scmd">
      <div class="form-group">
      <label for="username">Enter User Name</label>
      <form:input path="username" id="username" class="form-control" placeholder="Enter Username"/>
      <form:errors path="username"/>
      </div>
      <div class="form-group">
      <label for="licensenum">Enter License NO</label>
      <form:input path="licenseno" id="licensenum" class="form-control" placeholder="Enter License Number"/>
      <form:errors path="licenseno"/>
      </div>
      <div class="form-group">
      <label for="platenum">Enter Plate NO</label>
      <form:input path="plateno" id="platenum" class="form-control" placeholder="Enter Plate Number"/>
      <form:errors path="plateno"/>
      </div>
      <button type="submit" class="btn btn-primary">Search User</button>
      </form:form>
      </div>
                    
      <script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>