<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<style type="text/css">
     body {
          text-align: center;     
     }
</style>
</head>
<body>
       <h2 style="color:blue;text-align: center;">Vehicle Registration Page</h2>
    
       <form:form modelAttribute="UserCmd">
                     Enter user ID      :    <form:input path="id"/><br><br>
                     Enter Name         :    <form:input path="name"/><br><br>
                     Enter password     :    <form:input path="password"/><br><br>
                     Enter Gender       :    <form:input path="gender"/><br><br>
                     Enter Country      :    <form:input path="nationality"/><br><br>
                     Enter License      :    <form:input path="license"/><br><br>
                     Enter Authority-ID :    <form:input path="authority_id"/><br><br>
                        
        <input type="submit" value="Register">
    </form:form>   
</body>  
</html>