<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VehicleReg Page</title>
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
      <h2 style="color:blue;text-align: center;">Vehicle Details</h2>
      <form:form modelAttribute="VehCmd">
      <br><br>
                      Enter Vehicle ID    :    <form:input path="id"/>&emsp;<form:errors path="id"/><br><br>
                      Enter Source/Dealer :    <form:input path="source"/>&emsp;<form:errors path="source"/><br><br>
                      Enter Category      :    <form:input path="category"/>&emsp;<form:errors path="category"/><br><br>
                      Enter Plate Number  :    <form:input path="plate_number"/>&emsp;<form:errors path="plate_number"/><br><br>
                Enter Manufacture Company :    <form:input path="manufacture"/>&emsp;<form:errors path="manufacture"/><br><br>
                      Enter Vehicle Type  :    <form:input path="type"/>&emsp;<form:errors path="type"/><br><br>
                      Enter Vehicle Color :    <form:input path="color"/>&emsp;<form:errors path="color"/><br><br>
                Enter Registration-Date   :    <form:input path="registration_date"/>&emsp;<form:errors path="registration_date"/><br><br>
                Enter Pending Fine Amount :    <form:input path="pending_fines"/>&emsp;<form:errors path="pending_fines"/><br><br>
                      Enter User-Id       :    <form:input path="user_id"/>&emsp;<form:errors path="user_id"/><br><br>  
                <input type="submit" value="Register">
      </form:form>
      
</body>
</html>