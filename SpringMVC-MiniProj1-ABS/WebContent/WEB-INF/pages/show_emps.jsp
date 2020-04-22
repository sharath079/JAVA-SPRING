<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
    <c:when test="${!empty listdto}">
    
    <table align="center" border="1" bgcolor="cyan">
    <tr bordercolor="red">
      <th>EMPNO</th> <th>ENAME</th> <th>JOB</th> <th>SAL</th>
    </tr>
    <c:forEach var="dto" items="${listdto}">
       <tr style="background-color: yellow;">
           <td><c:out value="${dto.empno}"></c:out></td>
           <td><c:out value="${dto.ename}"></c:out></td>
           <td><c:out value="${dto.job}"></c:out></td>
           <td><c:out value="${dto.sal}"></c:out></td>
       </tr>
    
    </c:forEach>
    </table> 
    
    </c:when>
    <c:otherwise>
       <h1 style="text-align: center;color: red;">Records Not Found....</h1>
    </c:otherwise>

</c:choose>


 <br><br>
   <a href="welcome.htm">HOME</a>