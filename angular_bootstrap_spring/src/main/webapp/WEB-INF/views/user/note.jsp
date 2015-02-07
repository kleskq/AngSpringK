<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<body>
			<div class="body">
			<h1>Create new Note</h1>
				<form:form action="/springAngular/user/addNote" method="post">
				Note title: <br>
					<form:input class="input" type="text" path="noteTitle" />
					<br>
				Note text: <br>
					<form:textarea class="textarea" path="noteText" />
					<br>
					Category: <br>
					<form:select path="category" items="${categoryList}" />
					<br>
					<br>
					<input type="submit" value="Submit">
				</form:form>
			</div>
		</body>
	</tiles:putAttribute>
</tiles:insertDefinition>

</html>