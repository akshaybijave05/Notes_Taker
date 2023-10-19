<%@page import="java.util.Base64"%>
<%@page import="java.util.List"%>
<%@page import="com.entities.*"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>all-persons</title>
</head>
<body>
	<%@include file="navbar.jsp"%>

	<h5 class="text-center my-3">All person are here</h5>
	<div class="container-fluid">
		<div class="row">
			<%
			Session s = FactoryProvider.getFactory().openSession();
			Query q = s.createQuery("from Note_01");
			List<Note_01> list = q.list();
			for (Note_01 note : list) {
			%>

			<div class="col-4">
				<div class="card shadow-lg p-1 m-1">
				<img src="data:image/png;base64, <%=new String(Base64.getEncoder().encode(note.getImage())) %>" class="card-img-top w-25 mx-auto" alt="...">
					<div class="card-body">
						<p class="card-title"> <span class="fw-bold">Id : </span> <%=note.getId() %></p>
						<p class="card-text"><span class="fw-bold">Name : </span><%=note.getName() %></p>
						<p class="card-text"><span class="fw-bold">Title : </span><%=note.getTitle()%></p>
						<p class="card-text"><span class="fw-bold">Mob Number : </span><%=note.getMobile()%></p>
						<p class="card-text"><span class="fw-bold">Notes Type : </span><%=note.getNote_type() %></p>
						<p class="card-text"></p>
						<p class="card-text"><span class="fw-bold">Content : </span><%=note.getContent()%></p>
						<p class="mt-4 text-success fw-bold"><i>Last Updated : <%=note.getDate()%></i></p>
						<div class="container text-center">
							<a href="update.jsp?note_id=<%= note.getId() %>" class="btn btn-primary">Update</a> 
							<a href="DeleteServlet?note_id=<%= note.getId() %>" class="btn btn-danger">Delete</a>
						</div>
					</div>
				</div>
			</div>


			<%
			}
			%>
		</div>
	</div>
</body>
</html>