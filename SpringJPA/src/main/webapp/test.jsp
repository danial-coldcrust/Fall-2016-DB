<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>고객관리</h1>
		<form action="getCustomerList.do" method="post">
			<input type="submit" value="고객관리" />
		</form>
		<hr>
		<a href="customerLogin.do">고객로그인</a><br><br><br>
		<a href="getCustomerList.do">고객목록</a><br><br><br>
		<a href="staffLogin.do">직원로그인</a><br><br><br>
		<a href="getStaffList.do">직원목록</a><br><br><br>
		<a href="getOfficeList.do">지점 목록</a><br><br><br>
		<a href="getSendList.do">배송 목록</a><br><br><br>
		
	</center>
</body>
</html>