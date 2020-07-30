<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insurance  Page</title>
<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">

<style type="text/css">
   
     span {
          color: red;
     }
</style>
</head>
<body>
 <br><br>
       <h2 style="color:blue;text-align: center;">Insurance Details</h2>
      
      <form:form modelAttribute="InsCmd">
      
       <div class="form-group">
       <label for="insid">Enter Insurance ID</label>
       <form:input path="id" id="insid" class="form-control" placeholder="Enter Insurance ID"/>
       <form:errors path="id"/>
       </div>
      
       <div class="form-group">
       <label for="insprovider">Enter Provider Name</label>
       <form:input path="provider" id="insprovider" class="form-control" placeholder="Enter Insuarnce Provider Name"/>
       <form:errors path="provider"/>
       </div>         
       
       <div class="form-group">
       <label for="insno">Enter Insurance Number</label>
       <form:input path="insurance_number" id="insno" class="form-control" placeholder="Enter Insurance Number"/>
       <form:errors path="insurance_number"/>
       </div>
       
       <div class="form-group">
       <label for="time">Enter Time Period</label>
       <form:input path="validity_date" id="time" class="form-control" placeholder="Enter Insurance Time Period"/>
       <form:errors path="validity_date"/>
       </div>
       
       <div class="form-group">
       <label for="userid">Enter User ID</label>
       <form:input path="user_id" id="userid" class="form-control" placeholder="Enter User ID"/>
       <form:errors path="user_id"/>
       </div>
      
       <button type="submit" class="btn btn-primary">Register</button>  
            
      </form:form>
      <script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>      
</body>
</html>