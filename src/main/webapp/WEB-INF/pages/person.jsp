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
					required : true,
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
					required : 'Phone number must begin with 08 prefix',
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
	<div class="container" style="padding-top: 50px;">
	<p>Please fill the below form</p>

	<form:form id="myform" class="form-horizontal" method="post" modelAttribute="userForm"
		action="${addPerson}">
				<fieldset>
					<div class="control-group">
						<label class="control-label">Name</label>
						<div class="controls">
							<form:input path="name" />
							<span class="help-inline"><form:errors path="name" /></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">PPS Number</label>
						<div class="controls">
							<form:input path="ppsNumber" />
							<span class="help-inline"><form:errors path="ppsNumber" /></span>
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label">Date Of Birth</label>
						<div class="controls">
							<form:input type="date" path="dobInString" />
							<label class="error"><form:errors path="dobInString" /></label>
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label">Mobile Phone</label>
						<div class="controls">
							<form:input path="mobileNumber" />
							<span class="help-inline"><form:errors path="mobileNumber" /></span>
						</div>
					</div>
					<div class="form-actions">
						<button type="submit" class="btn btn-primary">Submit</button>
						<button type="reset" class="btn">Cancel</button>
					</div>
				</fieldset>
			</form:form>
			
			
			
	<c:if test="${not empty msg}">
		<p>${msg}</p>
	</c:if>
	<a href="welcome.html">Back to home</a>
	</div>
</body>
</html>