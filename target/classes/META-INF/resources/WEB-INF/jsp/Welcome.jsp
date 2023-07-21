<html>
<head>
<link href="webjars/bootstrap/5.3.0/css/bootstrap.min.css"
	rel="stylesheet">

<title>Welcome</title>
</head>
<body>
<%@ include file="Common/navigation.jsp" %>
	<div class="Container">
		<h2>Welcome ${name}</h2>
		Your Password is ${Pass} <br>
		<a href="list-todo"> Manage Your Todo Here</a>

	</div>


</body>

</html>