<%@page import="java.util.List"%>
<%@page import="com.winter.app.departments.DepartmentDAO"%>
<%@page import="com.winter.app.departments.DepartmentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	DepartmentDAO departmentDAO = new DepartmentDAO();
	DepartmentDTO departmentDTO = new DepartmentDTO();
	List<DepartmentDTO> ar = departmentDAO.getList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Departments List</h1>
	<table>
		<thead>
			<tr>
				<th>DEPARTMENT_ID</th>
				<th>DEPARTMENT_NAME</th>
				<th>LOCATION_ID</th>
				<th>MANAGER_ID</th>
			</tr>
		</thead>
		<tbody>
			<% for(DepartmentDTO dapartmentDTO :ar){%>
				<tr>
					<td><%= dapartmentDTO.getDepartment_id()%></td>
					<td><a href="./detail.jsp?department_name=<%= departmentDTO.getDepartment_name() %>"><%= departmentDTO.getDepartment_name()%></a></td>
					<td><%= dapartmentDTO.getLocation_id()%></td>
					<td><%= dapartmentDTO.getManager_id()%></td>
				</tr>
			<% } %>
		
		</tbody>
	</table>
</body>
</html>