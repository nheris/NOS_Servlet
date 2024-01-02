<%@page import="com.winter.app.regions.RegionDTO"%>
<%@page import="com.winter.app.departments.DepartmentDTO"%>
<%@page import="com.winter.app.departments.DepartmentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	DepartmentDTO departmentDTO = new DepartmentDTO();
	DepartmentDAO departmentDAO = new DepartmentDAO();
	String dId = request.getParameter("department_id");
	String name = request.getParameter("department_name");
	String lId = request.getParameter("location_id");
	String mId = request.getParameter("manager_id");
	departmentDTO.setDepartment_id(Integer.parseInt(dId));
	departmentDTO.setDepartment_name(name);
	departmentDTO.setLocation_id(Integer.parseInt(lId));
	departmentDTO.setManager_id(Integer.parseInt(mId));
	int result = departmentDAO.insert(departmentDTO);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Process</h1>
	<script type="text/javascript">
		let result = <%= result%>;
		if(result>0){
			alert('등록 성공')
		}else{
			alert('등록 실패')
		}
		location.href="./list.jsp";
	</script>
</body>
</html>