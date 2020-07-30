<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VehicleReg Page</title>
<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">    
    span {
       color: red;
    }
    </style>
</head>
<body>
      <h2 style="color:blue;text-align: center;">Vehicle Details</h2>
      <div class="container">
      <form:form modelAttribute="VehCmd">
      
       <div class="form-group">
       <label for="vehid">Enter Vehicle ID</label>
       <form:input path="id" id="vehid" class="form-control" placeholder="Enter Vehicle ID"/>
       <form:errors path="id"/>
       </div>
       
       <div class="form-group">
       <label for="vehd">Enter Source/Dealer Name</label>
       <form:input path="source" id="vehd" class="form-control" placeholder="Enter Vehicle Source/Dealer"/>
       <form:errors path="source"/>
       </div>
       
       <div class="form-group">
       <label for="vehcat">Enter Category</label>
       <form:input path="category" id="vehcat" class="form-control" placeholder="Enter Vehicle Category"/>
       <form:errors path="category"/>
       </div>

       <div class="form-group">
       <label for="plate">Enter Plate Number</label>
       <form:input path="plate_number" id="plate" class="form-control" placeholder="Enter Vehicle Plate Number"/>
       <form:errors path="plate_number"/>
       </div>

       <div class="form-group">
       <label for="vehprod">Enter Manufacture Company</label>
       <form:input path="manufacture" id="vehprod" class="form-control" placeholder="Enter Manufacture Company"/>
       <form:errors path="manufacture"/>
       </div>
       
       <div class="form-group">
       <label for="vehtype">Enter Vehicle Type</label>
       <form:input path="type" id="vehtype" class="form-control" placeholder="Enter Vehicle Type"/>
       <form:errors path="type"/>
       </div>
       
       <div class="form-group">
       <label for="vehcolor">Enter Vehicle Color</label>
       <form:input path="color" id="vehcolor" class="form-control" placeholder="Enter Vehicle Color"/>
       <form:errors path="color"/>
       </div>
       
       <div class="form-group">
       <label for="vehreg">Enter Registration Date</label>
       <form:input path="registration_date" id="vehreg" class="form-control" placeholder="Enter Registration Date"/>
       <form:errors path="registration_date"/>
       </div>
       
       <div class="form-group">
       <label for="vehamt">Enter Pending Amount</label>
       <form:input path="pending_fines" id="vehamt" class="form-control" placeholder="Enter Pending Amount"/>
       <form:errors path="pending_fines"/>
       </div>
       
       <div class="form-group">
       <label for="id">Enter User ID</label>
       <form:input path="user_id" id="id" class="form-control" placeholder="Enter User ID"/>
       <form:errors path="user_id"/>
       </div>
       
       <button type="submit" class="btn btn-primary">Register</button>                                   
       
      </form:form>
      </div>
      <script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>