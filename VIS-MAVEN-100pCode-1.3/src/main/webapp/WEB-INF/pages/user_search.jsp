<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
    span {
        color: red;
        text-decoration: none;
    }
   
</style>
<title>User Search Page</title>
</head>
<body>
      <h2 style="color:blue;text-align: center;">User Details Search</h2>
      
      <form:form modelAttribute="Scmd">
                     Enter User Name    :    <form:input path="username"/>&emsp;<form:errors path="username"/><br><br>
                     Enter License NO   :    <form:input path="licenseno"/>&emsp;<form:errors path="licenseno"/><br><br>
                     Enter Plate NO     :    <form:input path="plateno"/>&emsp;<form:errors path="plateno"/><br><br>
                                            
        <input type="submit" value="Search User">
    </form:form>
</body>
</html>