<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<link href="webjars/bootstrap/5.3.0/css/bootstrap.min.css"
	rel="stylesheet">
<title>Welcome to Todo App</title>

</head>
<body>
	<%@ include file="Common/navigation.jsp" %>

	<h2>Welcome to TODO App</h2>
	<hr>

	<br>
	<div Class="Container">
		Your Todo is Here
		<hr>
		<table class="table">
			<thead>
				<tr>
					
					<th>Description</th>
					<th>Date</th>
					<th>Status</th>
					<th>DELETE</th>
					<th>UPDATE</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todo}" var="todo" >

					<tr>
						
						<td>${todo.description}</td>
						<td>${todo.date}</td>
						<td>${todo.done}</td>
						<td><a href="delete-todo?id=${todo.id}"
							class="btn btn-primary">Delete </a></td>
						<td><a href="update-todo?id=${todo.id}"
							class="btn btn-warning">Update </a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>

		<a href="add-todo" class="btn btn-success">Add Todo</a>
	</div>

	<script src="webjars/bootstrap/5.3.0/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.4/jquery.min.js"></script>

</body>

</html>