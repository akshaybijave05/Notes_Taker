<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add person</title>
</head>
<body style="background-color: #eeeee4;">
	<%@include file="navbar.jsp"%>

	<div class="container d-flex">
		<form class="w-50 mx-auto shadow-lg p-3 mt-1" action="saveServlet"
			method="post">
			<h4 class="text-center">You can add personal details</h4>
			<div class="mb-3">
				<label class="form-label">Enter Name</label> <input type="text"
					class="form-control" name="name" required="required">
			</div>
			<div class="mb-3">
				<label class="form-label">Add Title</label> <input type="text"
					class="form-control" name="title" required="required">
			</div>
			<div class="mb-3">
				<label class="form-label">Mobile Number</label> <input type="number"
					class="form-control" name="mobile" required="required">
			</div>
			<div class="row">
				<div class="col-md-6 mb-3">
					<label for="date" class="form-label">Date</label> <input
						type="date" class="form-control" id="date" name="date" required>
				</div>
				<div class="col-md-6">
					<label for="selectOption" class="form-label">Select Gender
						Type</label> 
						<select class="form-select" id="" name="note_type">
							<option selected value="Personal_Notes" name="">Male</option>
							<option value="Business_Notes">Female</option>
							<option value="Other_Notes">Others</option>
					   </select>
				</div>
			</div>
			<div class="mb-3">
				<label class="form-label">Image/File</label> <input type="file"
					class="form-control" name="file01" >
			</div>
			<div class="mb-3">
				<label class="form-label">Add Content</label>
				<textarea class="form-control" id="" rows="3" name="content"
					required="required" style="height: 100px;"></textarea>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="1"
					name="checkbox01"> <label class="form-check-label"> Important
					Person </label>
			</div>
			<div class="d-flex justify-content-center my-3">
				<button type="submit" class="btn btn-primary " onclick="sub()">Add Person</button>
			</div>
		</form>
	</div>
	
<script>
function sub() {
	location.reload();
}

</script>
	
</body>
</html>