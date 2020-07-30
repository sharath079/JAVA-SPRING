<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
    
     span {
         color: red;
     }
</style>
</head>
<body>
       <h2 style="color:blue;text-align: center;">User Registration Page</h2>
       
       <div class="container">
       <form:form modelAttribute="UserCmd">
       
       <div class="form-group">
       <label for="userid">Enter User ID</label>
       <form:input path="id" id="userid" class="form-control" placeholder="Enter User ID"/>
       <form:errors path="id"/>
       </div>
       
       <div class="form-group">
       <label for="username">Enter User Name</label>
       <form:input path="name" id="username" class="form-control" placeholder="Enter User Name"/>
       <form:errors path="name"/>
       </div>
       
       <div class="form-group">
       <label for="pass">Enter Password</label>
       <form:input path="password" id="pass" class="form-control" placeholder="Enter User Password"/>
       <form:errors path="password"/>
       </div>
       
       <div class="form-group">
       <label for="usergender">Enter Gender</label>
       <form:input path="gender" id="usergender" class="form-control" placeholder="Enter User Gender"/>
       <form:errors path="gender"/>
       </div>
       
       <div class="form-group">
       <label for="country">Enter Country</label>
       <form:input path="nationality" id="country" class="form-control" placeholder="Enter User Country"/>
       <form:errors path="nationality"/>
       </div>
       
       <div class="form-group">
       <label for="licno">Enter License Number</label>
       <form:input path="license" id="licno" class="form-control" placeholder="Enter User License Number"/>
       <form:errors path="license"/>
       </div>
       
       <div class="form-group">
       <label for="authid">Enter Authority-ID</label>
       <form:input path="authority_id" id="authid" class="form-control" placeholder="Enter Authority ID"/>
       <form:errors path="authority_id"/>
       </div>
       
      <button type="submit" class="btn btn-primary">Register</button>                 

    </form:form>
    </div>
    <script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>   
</body>  
</html>