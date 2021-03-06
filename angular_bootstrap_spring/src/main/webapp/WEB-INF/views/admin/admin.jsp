<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

		<body>
			<div class="body">
				<table width="100%">
					<tr>
						<th align="left">User Name</th>
						<th align="left">Status</th>
					</tr>
					<c:forEach items="${users}" var="user">

						<tr>
							<td><c:out value="${user.userName}" />
							<td><c:out value="${user.isEnabled}" />
						</tr>
					</c:forEach>
				</table>
			</div>
		</body>
	</tiles:putAttribute>
</tiles:insertDefinition>

</html>