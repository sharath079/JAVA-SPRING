<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insurance  Page</title>
<style type="text/css">
     body {
          text-align: center;     
     }
</style>
</head>
<body>
 <br><br>
       <h2 style="color:blue;text-align: center;">Insurance Details</h2>
      <form:form modelAttribute="InsCmd">
      <br><br>
              Enter Insurance ID :    <form:input path="id"/><br><br>
                  Enter Provider :    <form:input path="provider"/><br><br>
                Enter Ins Number :    <form:input path="insurance_number"/><br><br>
               Enter Time Period :    <form:input path="validity_date"/><br><br>
                   Enter user ID :    <form:input path="user_id"/><br><br> 
      <input type="submit" value="Register">
      </form:form>
</body>
</html>