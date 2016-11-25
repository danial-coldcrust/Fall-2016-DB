<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 위에꺼 임포트해야 JSTL에서 제공하는 <c:forEach> 태그사용가능 책 310쪽 참고 --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>직원 목록</title>
</head>
<body>
<center>
<h1>직원 목록</h1>
<h3>${s_name}님! 환영합니다...<a href="staffLogOut.do">Log-out</a></h3>
<!-- 검색 시작 -->
<form action="getStaffList.do" method="post">
<table border="1" cellpadding="0" cellspacing="0" width="700">
<tr>
	<td colspan="7" align="right">
		<select name="searchCondition">
		<c:forEach items="${conditionMap}" var="option">
			<option value="${option.value}">${option.key}</option>
		</c:forEach>
		</select>
		<input name="searchKeyword" type="text" />
		<input type="submit"value="검색" />
	</td>
</tr>
<!-- 검색 종료 -->
<!-- 전체 목록 출력 시작 -->
<tr>
	<th>직원 번호</th>
	<th>지점 번호</th>
	<th>직책 </th>
	<th>직원 이름</th>
	<th>전화 번호</th>
	<th>주민 번호</th>
	<th>직원 주소</th>
</tr>
<c:forEach items="${staffList}" var="staff">
<tr>
	<td>${staff.staff_num}</td>
	<td>${staff.office_num}</td>
	<td>${staff.staff_job}</td>
	<td align="left"><a href="getStaff.do?staff_num=${staff.staff_num}">${staff.staff_name}</a></td>
	<td>${staff.staff_phonenum}</td>
	<td>${staff.staff_residentnum}</td>
	<td>${staff.staff_address}</td>
</tr>
</c:forEach>
<!-- 전체 목록 출력 종료 -->
</table>
</form>
<br>
<a href="insertStaff.jsp">직원 등록</a>
</center>
</body>
</html>