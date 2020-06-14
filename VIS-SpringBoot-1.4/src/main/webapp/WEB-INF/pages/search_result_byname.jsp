<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%@page import="kun.bo.UserBO,kun.bo.InsuranceBO" %>
  
    
  <h2 style="color:blue;text-align: center;">User Name Search Result Page</h2>
   
     <br>
     <c:choose>
    <c:when test="${!empty list}">
    <table align="center" border="1" bgcolor="cyan">
    <tr bgcolor="yellow"><th>ID<th>Name</th><th>Password<th>Gender</th><th>Nationality</th><th>License</th>
        <th>Authority-Id</tr>
        
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
   <a href="homepage.htm">Home Page</a>