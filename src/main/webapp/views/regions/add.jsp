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
		<div> <!-- 테이블 컬럼명, dto멤버변수, 마라미터값 동일하게? , name 자체가 파라미터가 됨?-->
			대륙ID<input type="text" name="region_id" value="0">
		</div>
		<div>
			대륙명<input type="text" name="region_name">
		</div>
		<button>추가</button>
	</form>
</body>
</html>