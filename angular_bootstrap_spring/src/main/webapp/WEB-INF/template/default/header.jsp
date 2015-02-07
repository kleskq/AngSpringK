<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@page session="true"%>

<div class="header">
	<sec:authorize ifAnyGranted="ROLE_ADMIN">
		<a href="<c:url value="/admin" />">Admin Panel</a>
	</sec:authorize>
	<c:choose>
		<c:when test="${pageContext.request.userPrincipal.name != null}">
		
		Logged in As : <a href="<c:url value="/user/panel"/>">${pageContext.request.userPrincipal.name}</a>
                 | <a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
		</c:when>
		<c:otherwise>
			<a href="<c:url value="/auth/login"/>">Log in</a>
		</c:otherwise>
	</c:choose>


</div>
