<%@page import="com.winter.app.regions.RegionDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.winter.app.regions.RegionDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//java 구역 - 스크립틀릿(자바영역 자바코드쓰는곳)
	RegionDAO regionDAO = new RegionDAO();
	List<RegionDTO> ar = regionDAO.getList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Regions List</h1>
	<table>
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
				<td><a href="./detail.jsp?region_id=<%= regionDTO.getRegion_id() %>"><%= regionDTO.getRegion_name()%></a></td>
			</tr>					
		<%}%>
		</tbody>
	</table>
	
	<a href="./add.jsp">대륙 추가</a>
	
</body>
</html>