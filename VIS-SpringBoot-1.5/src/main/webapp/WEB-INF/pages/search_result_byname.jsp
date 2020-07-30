<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%@page import="kun.bo.UserBO,kun.bo.InsuranceBO" %>
  
  <html>
       <head>
             <title>Result Page</title>
             <link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
       </head>
       <body>
        <h2 style="color:blue;text-align: center;">User Name Search Result Page</h2>
     <br>
     <c:choose>
    <c:when test="${!empty list}">
    <table align="center" border="1" class="table">
    <thead class="thead-dark">
    <tr>
            <th>ID<th>Name</th>
            <th>Password<th>Gender</th>
            <th>Nationality</th>
            <th>License</th>
            <th>Authority-Id</th>
     </tr>
     </thead>   
        <c:forEach var="user" items="${list}">
        <tr bgcolor="orange">
                 <td>${user.id}</td>
                 <td>${user.name}</td>
                 <td>${user.password}</td>
                 <td>${user.gender}</td>
                 <td>${user.nationality}</td>
                 <td>${user.license}</td>
                 <td>${user.authority_id}</td>                 
                
          </tr>                
        </c:forEach>
        </table>
    </c:when>
    <c:otherwise><h3><c:out value="Username Not Found...."></h3></c:out></c:otherwise>
    </c:choose>
<br><br>
   <a href="homepage.htm" class="btn btn-success btn-lg active" role="button" aria-pressed="true">Home Page</a>
   <script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
       </body>
  </html>  
 