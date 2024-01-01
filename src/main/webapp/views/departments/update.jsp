<%@page import="com.winter.app.departments.DepartmentDAO"%>
<%@page import="com.winter.app.departments.DepartmentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	DepartmentDTO departmentDTO = new DepartmentDTO();
	DepartmentDAO departmentDAO = new DepartmentDAO();
	String id = request.getParameter("department_id");
	departmentDTO.setDepartment_id(Integer.parseInt(id));
	departmentDTO = departmentDAO.getDetail(departmentDTO);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Department Update Page</h1>
	<form action="./updateProcess.jsp">
		<div>
			부서ID<input type="text" readonly="readonly" name="department_id" value="<%=departmentDTO.getDepartment_id()%>">
		</div>
		<div>
			부서명<input type="text" name="department_name" value="<%=departmentDTO.getDepartment_name()%>">
		</div>
		<button>수정</button>
</form>		
</body>
</html>