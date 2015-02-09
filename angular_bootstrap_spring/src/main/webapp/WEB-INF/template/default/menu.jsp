<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="menu">
	Menu
	<ul>
		<li><spring:url value="/admin/users" var="usersUrl" htmlEscape="true" />
			<a href="${usersUrl}">Users List</a></li>
		<li><spring:url value="/admin/newsStatus" var="newsStatusUrl" htmlEscape="true" />
			<a href="${newsStatusUrl}">News Status</a></li>
	</ul>
</div>