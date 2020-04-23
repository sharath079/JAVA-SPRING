<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

    <h1 style="color:red;text-align:center">Search Employee details </h1>
    
    <form action="search_emps.htm"  method="POST">
          Employee no::  <input type="text" name="empno" value="0"/> <br><br>
          Employee name::  <input type="text" name="ename"/> <br><br>
          Employee desg :: <input type="text" name="job"/><br><br>
          Employee salary :: <input type="text" name="sal" value="2000"/> <br><br>
         <input type="submit"  value="search Employess">
        </form>