<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%@page import="kun.bo.UserBO,kun.bo.InsuranceBO" %>
  
    
  <h2 style="color:blue;text-align: center;">User Search Result Page</h2>
   
     <br>
     <c:choose>
    <c:when test="${!empty list}">
    <table align="center" border="1" bgcolor="cyan">
    <tr bgcolor="yellow"><th>Name</th><th>Gender</th><th>Nationality</th><th>License</th>
        <th>Ins-Provider</th><th>Ins-Number</th><th>Ins-Validity</th>
        <th>Source</th><th>Category</th><th>Plate-Number</th><th>Manufature</th><th>Type</th>
        <th>Color</th><th>Registration-Date</th><th>Pending-Fines</th></tr>
        
        <c:forEach var="user" items="${list}">
        <tr bgcolor="orange">
                 <td>${user.name}</td>
                 <td>${user.gender}</td>
                 <td>${user.nationality}</td>
                 <td>${user.license}</td>                 
                 <td>${user.ibo.provider}</td>
                 <td>${user.ibo.insurance_number}</td>
                 <td>${user.ibo.validity_date}</td>        
                 <td>${user.vbo.source}</td>
                 <td>${user.vbo.category}</td>
                 <td>${user.vbo.plate_number}</td>
                 <td>${user.vbo.manufacture}</td>
                 <td>${user.vbo.type}</td>
                 <td>${user.vbo.color}</td>
                 <td>${user.vbo.registration_date}</td>
                 <td>${user.vbo.pending_fines}</td>
          </tr>                
        </c:forEach>
        </table>
    </c:when>
    </c:choose>
<br><br>
   <a href="homepage.htm">Home Page</a>
  
