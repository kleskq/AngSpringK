<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Default tiles template</title>
<link href="<c:url value="/resources/css/style.css" />"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="//cdn.datatables.net/1.10.0/css/jquery.dataTables.css">
<script type="text/javascript"
	src="//code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript"
	src="//cdn.datatables.net/1.10.0/js/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/datatable.js" />"></script>

</head>
<body>
	<div class="page">
		<tiles:insertAttribute name="header" />
		<div class="content">
			<tiles:insertAttribute name="menu" />
			<tiles:insertAttribute name="body" />
		</div>
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>