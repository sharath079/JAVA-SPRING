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
     span {
          color: red;
     }
</style>
</head>
<body>
 <br><br>
       <h2 style="color:blue;text-align: center;">Insurance Details</h2>
      <form:form modelAttribute="InsCmd">
      <br><br>
              Enter Insurance ID :    <form:input path="id"/>&emsp;<form:errors path="id"/><br><br>
                  Enter Provider :    <form:input path="provider"/>&emsp;<form:errors path="provider"/><br><br>
                Enter Ins Number :    <form:input path="insurance_number"/>&emsp;<form:errors path="insurance_number"/><br><br>
               Enter Time Period :    <form:input path="validity_date"/>&emsp;<form:errors path="validity_date"/><br><br>
                   Enter user ID :    <form:input path="user_id"/>&emsp;<form:errors path="user_id"/><br><br> 
      <input type="submit" value="Register">
      </form:form>
</body>
</html>