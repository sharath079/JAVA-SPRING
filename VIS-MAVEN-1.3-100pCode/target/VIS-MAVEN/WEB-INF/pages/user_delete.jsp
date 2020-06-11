<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
      <form:form modelAttribute="DelCmd">
                Enter User-ID  :  <form:input path="id"/><br><br>
                
                <input type="submit" value="Delete"> 
      </form:form>
      
</body>
</html>