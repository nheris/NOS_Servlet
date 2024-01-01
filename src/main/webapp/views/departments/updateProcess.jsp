<%@page import="com.winter.app.departments.DepartmentDTO"%>
<%@page import="com.winter.app.departments.DepartmentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	DepartmentDAO departmentDAO = new DepartmentDAO();
	DepartmentDTO departmentDTO = new DepartmentDTO();
	String id = request.getParameter("department_id");
	String name = request.getParameter("department_name");
	departmentDTO.setDepartment_id(Integer.parseInt(id));
	departmentDTO.setDepartment_name(name);
	int result = departmentDAO.update(departmentDTO);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Region Update Process</h1>
	<script type="text/javascript">
		let result = <%=result %>;
		if(result>0){
			alert("수정 성공");
		}else {
			alert("수정 실패");
		}
		
		location.href="./detail.jsp?department_id=<%=request.getParameter("department_id")%>"
	</script>
</body>
</html>