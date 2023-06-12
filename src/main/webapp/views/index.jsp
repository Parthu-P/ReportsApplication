<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Report Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>


	

<div class="container">
    
    <h3>Insurance Report Data</h3>
    
	<form:form action="search" modelAttribute="searchObj" method="POST">

		<table>
			<tr>
				<td>PlanName:</td>
				<td><form:select path="planName">
						<form:option value="">-select-</form:option>
						<form:options items="${names}" />
					</form:select></td>
					
					<td>PlanStatus:</td>
				<td><form:select path="planStatus">
						<form:option value="">-select-</form:option>
						<form:options items="${status}" />
					</form:select></td>
					
				
				<td>Gender:</td>
				<td><form:select path="gender">
						<form:option value="">-select-</form:option>
						<form:option value="Male">Male</form:option>
						<form:option value="Fe-Male">Fe-Male</form:option>
					</form:select></td>

			</tr>
			<tr>
			<td>StartDate:</td>
			<td>
			  <form:input type="Date" path="startDate"/>
			  </td>
			  <td>EndDate:</td>
			  <td>
			  <form:input type="Date" path="endDate"/>
			  </td>
			  </tr>
			  </table>
			  

			
			
			  <tr>
			  <td></td>
			  <td><a href="/" class="btn btn-danger">Reset</a></td>
			  <td></td>
			  <td><input type="submit" value="search" class="btn btn-primary"/></td>
			  
						   
			  </tr>
			  
		</form:form> 
		
		
		<tr>
		<td>Export:</td>
		     <td><a href="excel">Excel</a></td>
		     <td> <a href="pdf">Pdf</a>  
		</td>
		</tr>
		

	
     
     <hr/>

     
     <table class="table table-striped table-hover">
      <thead>
            <tr>
               <th>S.No</th>
               <th>Name</th>
               <th>Gender</th>
               <th>PlanName</th>
               <th>PlanStatus</th>
               <th>PlanStateDate</th>
               <th>PlanEndDate</th>
               <th>BeneficiaryAmount</th>
               <th>DeniedReason</th>
               <th>DeniedDate</th>
               <th>TerminatedDate</th>
               <th>TerminatedReason</th>
            </tr>
          </thead>
          
         <tbody>
            <c:forEach items="${Plans}" var="plan" varStatus="index">
              <tr>
                 <td>${index.count}</td>
                  <td>${plan.citizenName}</td>
                  <td>${plan.citizenGender}</td>
                   <td>${plan.citizenPlan}</td>
                    <td>${plan.citizenStatus}</td>
                     <td>${plan.citizenPlanStartDate}</td>
                      <td>${plan.citizenPlanEndDate}</td>
                       <td>${plan.beneficiaryAmount}</td>
                       <td>${plan.deniedReason}</td>
                        <td>${plan.deniedDate}</td>
                        <td>${plan.terminateDate}</td>
                        <td>${plan.terminateReason}</td>
                       </tr>
           
           </c:forEach>             
               <tr>   
                 <c:if test="${empty Plans}">
                 <td colspan="11" style="text-align: center">
                     No Records Found</td>      
          
                 </c:if>
         </tr>
         
         </tbody>      
     </table>

</div>



</body>
</html>