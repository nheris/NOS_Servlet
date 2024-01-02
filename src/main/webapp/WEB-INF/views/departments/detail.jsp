<%@page import="com.winter.app.departments.DepartmentDAO"%>
<%@page import="com.winter.app.departments.DepartmentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	DepartmentDAO departmentDAO = new DepartmentDAO();
	DepartmentDTO departmentDTO = new DepartmentDTO();
	String str = request.getParameter("department_id");
	int num = Integer.parseInt(str);
	departmentDTO.setDepartment_id(num);  
	
	departmentDTO=departmentDAO.getDetail(departmentDTO);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Department Detail</h1>
	<h3><%= departmentDTO.getDepartment_name()%></h3>
	<input id="rId" type="hidden" value="<%=departmentDTO.getDepartment_id()%>">
	<button id="btn">수정</button>
	<a href="./update.jsp?department_id=<%=departmentDTO.getDepartment_id()%>">수정 폼 이동</a>
	<script type="text/javascript">
		let btn = document.getElementById("btn");
		let v = document.getElementById("rId");
		btn.addEventListener("click",()=>{
			alert(v.value);
			location.href="./update.jsp?department_id="+v.value;
		})
	</script>
</body>
</html>