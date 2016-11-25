<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 위에꺼 임포트해야 JSTL에서 제공하는 <c:forEach> 태그사용가능 책 310쪽 참고 --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>고객 목록</title>
</head>
<body>
<center>
<h1>고객 목록</h1>
<h3>${c_name}님! 환영합니다...<a href="customerLogOut.do">Log-out</a></h3>
<!-- 검색 시작 -->
<form action="getCustomerList.do" method="post">
<table border="1" cellpadding="0" cellspacing="0" width="700">
<tr>
	<td colspan="4" align="right">
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
	<th>고객 번호</th>
	<th>고객 이름</th>
	<th>전화 번호</th>
	<th>고객 주소</th>
</tr>
<c:forEach items="${customerList}" var="customer">
<tr>
	<td>${customer.customer_num}</td>
	<td align="left"><a href="getCustomer.do?customer_num=${customer.customer_num}">${customer.customer_name}</a></td>
	<td>${customer.customer_phonenum}</td>
	<td>${customer.customer_address}</td>
</tr>
</c:forEach>
<!-- 전체 목록 출력 종료 -->
</table>
</form>
<br>
<a href="insertCustomer.jsp">고객 등록</a>
</center>
</body>
</html>