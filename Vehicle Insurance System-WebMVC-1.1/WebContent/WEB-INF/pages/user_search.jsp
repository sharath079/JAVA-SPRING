<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Search Page</title>
</head>
<body>
      <h2 style="color:blue;text-align: center;">User Details Search</h2>
      
      <form:form modelAttribute="Scmd">
                     Enter User Name    :    <form:input path="username"/><br><br>
                     Enter License NO   :    <form:input path="licenseno"/><br><br>
                     Enter Plate NO     :    <form:input path="plateno"/><br><br>
                                            
        <input type="submit" value="Search User">
    </form:form>
</body>
</html>