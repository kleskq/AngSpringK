<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

		<body>
			<div class="body">
				News on the server: <c:out value="${newsCount}" />
			</div>
		</body>
	</tiles:putAttribute>
</tiles:insertDefinition>

</html>