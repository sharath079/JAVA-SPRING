<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User's Details</title>
<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
       <h2 style="color:blue;text-align: center;">User Search By Name</h2>
      <div class="container">
      <form:form modelAttribute="BNcmd">
      <div class="form-group">
           <label for="username">Enter UserName To Search</label>
           <form:input path="name" class="form-control" id="username" placeholder="Enter Password"/>
      </div>
        <!--<form:input path="name"/><br><br>-->
        <button type="submit" class="btn btn-primary">Search</button>                           
        
    </form:form>
    </div>
    <script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>