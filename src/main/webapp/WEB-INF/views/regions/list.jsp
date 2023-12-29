<%@page import="com.winter.app.regions.RegionDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.winter.app.regions.RegionDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//java 구역 - 스크립틀릿(자바영역 자바코드쓰는곳)
//	RegionDAO regionDAO = new RegionDAO(); 이제 안써도됨 매개변수로 받릉거임
//	List<RegionDTO> ar = regionDAO.getList();
	
	//request 변수명. 이미 만들어져있다?? 잘 못들음
			//localhost/regions/list 주소창 치면 이파일로 이동
	List<RegionDTO> ar = (List<RegionDTO>)request.getAttribute("list"); //모든 객체가 list타입아니라 형변환 필요
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Regions List</h1>
	<table border="1">
		<thead>
			<tr>
				<th>REGION_ID</th>
				<th>REGION_NAME</th>
			</tr>
		<thead>
		<tbody>
		<% for(RegionDTO regionDTO : ar){ %> 
			<tr>    <!-- //표현식%= % ;안붙임-->
				<td><%= regionDTO.getRegion_id()%></td>
				<!-- .jsp -->
				<td><a href="./detail?region_id=<%= regionDTO.getRegion_id() %>"><%= regionDTO.getRegion_name()%></a></td>
			</tr>					
		<%}%>
		</tbody>
	</table>
	
	<a href="./add.jsp">대륙 추가</a>
	
</body>
</html>