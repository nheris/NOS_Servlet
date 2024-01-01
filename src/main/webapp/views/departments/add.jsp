<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Regions Add</h1>
	<form action="./addProcess.jsp">
	<div>
		부서ID<input type="text" name="department_id">
	</div>
	<div>
		부서명<input type="text" name="department_name">
	</div>
	<div>
		지역ID<input type="text" name="location_id">
	</div>
	<div>
		상사ID<input type="text" name="manager_id">
	</div>
	<button>추가</button>
	</form>
</body>
</html>