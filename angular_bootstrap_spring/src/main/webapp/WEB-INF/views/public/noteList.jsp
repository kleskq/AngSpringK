<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
	<h1>Note List</h1>
	<form:form action="" method="GET">
		<table id="table" width="70%"
			style="border: 3px; background: rgb(243, 244, 248);">
			<tr>
				<td>
					<table id="example" class="display" cellspacing="0" width="100%">
						<thead>
							<tr>
								<th>Note title</th>
								<th>Category</th>
								<th>Author</th>
								<th>Create Date</th>
								<th>Average rating</th>
							</tr>
						</thead>
					</table>
				</td>
			</tr>
		</table>
	</form:form>

	</tiles:putAttribute>
</tiles:insertDefinition>

