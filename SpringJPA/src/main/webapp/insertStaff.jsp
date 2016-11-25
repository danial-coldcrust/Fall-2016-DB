<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>직원 등록</title>
</head>
<body>
<center>
<h1>직원 등록</h1>
<a href="staffLogOut.do">Log-out</a>
<hr>
<form action="insertStaff.do" method="post">
<table border="1" cellpadding="0" cellspacing="0">
<tr>
	<td bgcolor="orange">지점 번호</td>
	<td align="left"><input type="text" name="office_num"/></td>
	<!-- name값을 StaffVO의 변수명과 동일하게하면 get/setters에 의해 자동 맵핑 -->
</tr>
<tr>
	<td bgcolor="orange">직책</td>
	<td align="left"><input type="text" name="staff_job"/></td>
</tr>
<tr>
	<td bgcolor="orange">직원 이름</td>
	<td align="left"><input type="text" name="staff_name"/></td>
</tr>
<tr>
	<td bgcolor="orange">전화 번호</td>
	<td align="left"><input type="text" name="staff_phonenum"/></td>
</tr>
<tr>
	<td bgcolor="orange">주민 번호</td>
	<td align="left"><input type="text" name="staff_residentnum"/></td>
</tr>
<tr>
	<td bgcolor="orange">직원 주소</td>
	<td align="left"><input type="text" name="staff_address"/></td>
</tr>
<tr>
	<td colspan="2" align="center"><input type="submit" value="고객 등록"/></td>
</tr>
</table>
</form>
<hr>
<a href="getStaffList.do">고객 목록</a>
</center>
</body>
</html>