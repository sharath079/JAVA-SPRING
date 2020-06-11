<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
			
<c:if test="${not empty list}">
		
<div class = "row">
	<div class = "col-md-6">
		<div class = "row">
			<div class = "col-md-12">
						
		<table class = "table table-bordered">
						
		<tr class = "headerColor"><td colspan="2"><b>Owner Details</b></td></tr>
		<tr><th>Name </th><td>${list.name}</td></tr>
		<tr><th>Gender </th><td>${list.gender}</td></tr>
		<tr><th>Nationality </th><td>${list.nationality}</td></tr>
		<tr><th>Licence No. </th><td>${list.licence}</td></tr>
		</table>
</div>
       <div class = "col-md-12">
       <table class = "table table-bordered">
       <tr class = "headerColor"><td colspan="2"><b>Insurance Details</b></td></tr>
	   <tr><th>Insurance Provider </th><td>${list.InsuranceBO.provider}</td></tr>
	   <tr><th>Insurance Number </th><td>${list.InsuranceBO.insurance_number}</td></tr>
	   <tr><th>Valid Date </th><td>${list.InsuranceBO.validity_date}</td></tr>
	   </table>
</div>
</div>
</div>
	   <div class = "col-md-6">
	   <table class = "table table-bordered">
						
	  <tr class = "headerColor"><td colspan="2"><b>Vehicle Details</b></td></tr>
	  <tr><th>Source </th><td>${list.VehicleBO.source}</td></tr>
	  <tr><th>Category </th><td>${list.VehicleBO.category}</td></tr>
	  <tr><th>Plate Number </th><td>${list.VehicleBO.plate_number}</td></tr>
	  <tr><th>Manufacture </th><td>${list.VehicleBO.manufacture}</td></tr>
	  <tr><th>Type </th><td>${list.VehicleBO.type}</td></tr>
	  <tr><th>Color </th><td>${list.VehicleBO.color}</td></tr>
	  <tr><th>Registration Date </th><td>${list.VehicleBO.registration_date}</td></tr>
	  <tr><th>Pending Fees </th><td>${list.VehicleBO.pending_fines}</td></tr>
	  </table>
</div>
</div>
</c:if>
