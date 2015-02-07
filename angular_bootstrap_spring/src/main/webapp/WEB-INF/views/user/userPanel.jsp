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
						<th align="left">Note title</th>
						<th align="left">Category</th>
						<th align="left">Create date</th>
						<th align="left">Link</th>
					</tr>
					<c:forEach items="${notes}" var="note">

						<tr>
							<td><c:out value="${note.noteTitle}" />
							<td><c:out value="${note.categoryName}" />
							<td><c:out value="${note.createDate}" />
							<td><a href="<c:url value="/note/+${note.code}" />">Read
									note</a>
						</tr>


					</c:forEach>
				</table>
			</div>
		</body>
	</tiles:putAttribute>
</tiles:insertDefinition>

</html>