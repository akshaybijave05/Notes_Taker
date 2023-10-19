<%@page import="com.entities.Note_01"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.helper.FactoryProvider"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update notes</title>
</head>
<body style="background-color: #eeeee4;">
	<%@include file="navbar.jsp"%>
	<%
	int noteId = Integer.parseInt(request.getParameter("note_id").trim());
	Session s = FactoryProvider.getFactory().openSession();
	Note_01 note = (Note_01) s.get(Note_01.class, noteId);
	%>

	<div class="container d-flex">
		<form class="w-50 mx-auto shadow-lg p-3 mt-1" action="UpdateServlet"
			method="post">
			<h4 class="text-center">You can Update notes</h4>
			<input type="hidden"
					class="form-control" name="noteId" value="<%=note.getId()%>">
			<div class="mb-3">
				<label class="form-label">Edit Name</label> <input type="text"
					class="form-control" name="name" required="required" value="<%= note.getName()%>">
			</div>
			<div class="mb-3">
				<label class="form-label">Edit Title</label> <input type="text"
					class="form-control" name="title" required="required" value="<%= note.getTitle()%>">
			</div>
			<div class="mb-3">
				<label class="form-label">Edit Mobile Number</label> <input type="number"
					class="form-control" name="mobile" required="required" value="<%= note.getMobile() %>">
			</div>
			<div class="row">
				<div class="col-md-6 mb-3">
					<label for="date" class="form-label">Edit Date</label> <input
						type="date" class="form-control" id="date" name="date" required value="<%= note.getDate() %>">
				</div>
				<div class="col-md-6">
					<label for="selectOption" class="form-label">Edit Notes
						Type</label> 
						<select class="form-select" id="" name="note_type">
							<option selected value="Personal_Notes" name="">Personal Notes</option>
							<option value="Business_Notes">Business Notes</option>
							<option value="Other_Notes">Other Notes</option>
					   </select>
				</div>
			</div>
			<div class="mb-3">
				<label class="form-label">Edit Image/File</label> <input type="file"
					class="form-control" name="file01" value="<%= note.getImage() %>">
			</div>

			<div class="mb-3">
				<label class="form-label">Edit Content</label>
				<textarea class="form-control" id="" rows="3" name="content"
					required="required" style="height: 100px;"><%= note.getContent() %></textarea>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="1"
					name="checkbox01"> <label class="form-check-label"> Important
					Notes </label>
			</div>
			<div class="d-flex justify-content-center my-3">
				<button type="submit" class="btn btn-success ">Update Notes</button>
			</div>
		</form>
	</div>
</body>
</html>