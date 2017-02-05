<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quest</title>
<link href="bootstrap.min.css" rel="stylesheet">

<script src="jquery.min.js" type="text/javascript"></script>
<script src="jquery.form.js" type="text/javascript"></script>
<script src="jquery.validate.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//alert("jquery");
		$('#myform').validate({ 
			rules : {
				name : {
					required : true,
					maxlength : 25
				},
				ppsNumber : {
					required : true
				},
				mobileNumber : {
					
					number : true
				}
			},
			messages : {
				name : {
					required : 'Name is required',
					maxlength : 'Name should not exceed 25 character'
				},
				ppsNumber : {
					required : 'PPS number is required'
				},
				mobileNumber : {
					
					number : 'Phone number can contain only numbers'
				}
			},
			submitHandler: function (form) { // for demo
	           // alert('valid form submitted'); // for demo
	            return true; // for demo
	        }
		});
	});
</script>
</head>
<body>
	
	
<a href="welcome.html"><img border="0" alt="Back to home" src="home.png" style="width: 10%;height: 0%;padding-left: 36px;padding-top: 20px;"></a>
	<form:form id="myform" style="padding-left: 210px;" method="post" modelAttribute="userForm"
		action="${addPerson}">
		<p style="padding-left: 100px;padding-top: 50px;color: darkgrey;">Please fill the below form</p>
				<table>
					<tr>
						<td>Name</td>
						<td>
							
							<form:input path="name" />
							<form:errors path="name" />
						
						</td>
					</tr>
					
					<tr>
						<td>PPS Number</td>
						<td>
							
							<form:input path="ppsNumber" />
							<form:errors path="ppsNumber" />
						
						
						</td>
					</tr>
					
					<tr>
						<td>Date Of Birth</td>
						<td>
							
							<form:input style="width: 200px;" type="date" path="dobInString" />
							<form:errors path="dobInString" />
						
						
						</td>
					</tr>
					
					<tr>
						<td>Mobile Phone</td>
						<td>
							
							<form:input path="mobileNumber" />
							<form:errors path="mobileNumber" />
						
						
						</td>
					</tr>
					
					
				</table>
				
						<div style="padding-left: 105px;padding-top: 12px;">
						<button type="submit" class="btn btn-primary">Submit</button>
						<button type="reset" class="btn">Cancel</button>
					</div>
					
				
			</form:form>
			
	<c:if test="${not empty msg}">
		<p>${msg}</p>
	</c:if>
	
	
	
</body>
</html>