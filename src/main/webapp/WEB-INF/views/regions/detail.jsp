<%@page import="com.winter.app.regions.RegionDTO"%>
<%@page import="com.winter.app.regions.RegionDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% //안씀 주로 EL씀
/* 	RegionDAO regionDAO = new RegionDAO();
	RegionDTO regionDTO = new RegionDTO();
	
	String n = request.getParameter("region_id");//꺼내고 싶은 파라미터 키.값은 항상 String
	int num = Integer.parseInt(n); //NumberFormat
	regionDTO.setRegion_id(num);
	
	regionDTO = regionDAO.getDetail(regionDTO); */
	
	//RegionDTO regionDTO = (RegionDTO)request.getAttribute("dto");
	
	//request.getSession().getServletContext(); 걍 꺼낼수 있다 개념만 
	//application.getSes 못적
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Region Detail</h1>
	<h3>${requestScope.dto.region_id}</h3> <!-- =(RegionDTO)request.getAttribute("dto").getter이름? / 원래타입 자동 형변환??-->
	<h3>${requestScope.dto.region_name}</h3>
	<input id="rId" type="hidden" value="">
	<button id="btn" >수정</button>
	<a href="./update.jsp?region_id=${requestScope.dto.region_id}">수정폼 이동</a>
	
	<script type="text/javascript">
		let btn = document.getElementById("btn");
		let v = document.getElementById("rId");
		
		btn.addEventListener("click", function() {
			alert(v.value);
			//window. 생략가능 , 이동a태그아니면location 
			location.href="./update.jsp?region_id="+v.value;
		});
	</script>
</body>
</html>