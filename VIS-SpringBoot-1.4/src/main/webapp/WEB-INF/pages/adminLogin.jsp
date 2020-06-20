<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
        
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<style type="text/css">
h2 {
   text-align: center;
   color: blue;   
}

</style>
</head>
<body>
      <h2>Vehicle Insurance System</h2>
      <br>
      <form:form modelAttribute="adminCmd">
      Enter Name :     <input type="text" name="name">
      Enter Password : <input type="password" name="password">
      <br>
      <input type="submit" value="Login">
      
      </form:form>
</body>
</html>