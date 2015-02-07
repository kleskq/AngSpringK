<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<script>
	function submitForm() {
		document.getElementById("ratings").submit();
	}
</script>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

		<div class="body">
			<h2>Note title: ${note.noteTitle}</h2>
			Create by: ${note.userName} on ${date} <br> <br>
			<form:textarea class="textarea" path="note.noteText" readonly="true"></form:textarea>
			<sec:authorize ifAnyGranted="ROLE_ADMIN,ROLE_USER">
				<br> Rate note:
			<form:form id="ratings" action="/springAngular/noteRate" method="POST">
					<form:radiobutton path="rating" value="1" onclick="submitForm();" />1
				<form:radiobutton path="rating" value="2" onclick="submitForm();" />2
				<form:radiobutton path="rating" value="3" onclick="submitForm();" />3
				<form:radiobutton path="rating" value="4" onclick="submitForm();" />4
				<form:radiobutton path="rating" value="5" onclick="submitForm();" />5
				
				</form:form>
			</sec:authorize>
		</div>

	</tiles:putAttribute>
</tiles:insertDefinition>

