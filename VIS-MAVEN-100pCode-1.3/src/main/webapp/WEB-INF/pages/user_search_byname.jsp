<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User's Details</title>
</head>
<body>
       <h2 style="color:blue;text-align: center;">User Search By Name</h2>
      
      <form:form modelAttribute="BNcmd">
                     Enter User Name    :    <form:input path="name"/><br><br>                           
        <input type="submit" value="Search User By Name">
    </form:form>
</body>
</html>