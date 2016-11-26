<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>직원 정보</title>
</head>
<body>
<center>
<h1>직원 정보</h1>
<a href="staffLogOut.do">Log-out</a>
<hr>
<form action="updateStaff.do" method="post">
<input name="staff_num" type="hidden" value="${staff.staff_num}"/>
<table border="1" cellpadding="0" cellspacing="0">
<tr>
	<td bgcolor="orange">직원 번호</td>
	<td align="left"><input name="office_num" type="text" value="${staff.staff_num}"/></td>
</tr>
<tr>
	<td bgcolor="orange">지점 번호</td>
	<td align="left"><input name="office_num" type="text" value="${staff.office_num}"/></td>
</tr>
<tr>
	<td bgcolor="orange" width="70">직책</td>
	<td align="left"><input name="staff_job" type="text" value="${staff.staff_job}"/></td>
</tr>
<tr>
	<td bgcolor="orange">직원 이름</td>
	<td align="left"><input name="staff_name" type="text" value="${staff.staff_name}"/></td>
</tr>
<tr>
	<td bgcolor="orange">전화 번호</td>
	<td align="left"><input name="staff_phonenum" type="text" value="${staff.staff_phonenum}"/></td>
</tr>
<tr>
	<td bgcolor="orange">주민 번호</td>
	<td align="left"><input name="staff_residentnum" type="text" value="${staff.staff_residentnum}"/></td>
</tr>
<tr>
	<td bgcolor="orange">직원 주소</td>
	<td align="left"><input name="staff_address" type="text" value="${staff.staff_address}"/></td>
</tr>
<tr>
	<td colspan="2" align="center"><input type="submit" value="정보 수정"/></td>
</tr>
</table>
</form>
<a href="insertStaff.jsp">직원 등록</a>&nbsp;&nbsp;&nbsp;
<a href="deleteStaff.do?staff_num=${staff.staff_num}">직원 삭제</a>&nbsp;&nbsp;&nbsp;
<a href="getStaffList.do">직원 목록</a>
</center>
</body>
</html>