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
		<div> <!-- 테이블 컬럼명 멤버변수, 마라미터값 동일하게? -->
			대륙ID<input type="text" name="region_id" vlaue=>
		</div>
		<div>
			대륙명<input type="text" name="region_name">
		</div>
		<button type ="submit">추가</button>
	</form>
</body>
</html>