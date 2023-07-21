<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<link href="webjars/bootstrap/5.3.0/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css"
	rel="stylesheet">
<title>Add Your Todo Here</title>
</head>

<body>

	<%@ include file="Common/navigation.jsp" %>
	<div class="Container">

		<h3>Add Your Todo List Here</h3>
		<form:form method="post" modelAttribute="todo">
			<div>
				<fieldset class="mb-3">
					<form:label path="description">Description: </form:label>
					<form:input type="text" path="description" />
					<form:errors cssClass="text-warning" path="description" />
				</fieldset>

				<fieldset class="mb-3">
					<form:label path="date" >TargetDate: </form:label>
					<form:input type="text" path="date" />

				</fieldset>

				<form:input type="hidden" path="id" />
				<fieldset class="mb-3">  
				<form:label path="done">Done ?: </form:label>
				<form:input type="Boolean" path="done" />
				<form:errors cssClass="text-warning" path="done"/>
				 </fieldset>
				
				<input type="submit" class="btn btn-success"/>
		</form:form>

	</div>


	<script src="webjars/bootstrap/5.3.0/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.4/jquery.min.js"></script>
	<script
		src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
	<script type="text/javascript">
		$('#date').datepicker({
			format : 'yyyy-mm-dd'
		});
	</script>
</body>

</html>