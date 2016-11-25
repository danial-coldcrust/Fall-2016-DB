<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>고객 정보</title>
</head>
<body>
<center>
<h1>고객 정보</h1>
<a href="customerLogOut.do">Log-out</a>
<hr>
<form action="updateCustomer.do" method="post">
<input name="customer_num" type="hidden" value="${customer.customer_num}"/>
<table border="1" cellpadding="0" cellspacing="0">
<tr>
	<td bgcolor="orange">고객 번호</td>
	<td align="left">${customer.customer_num}</td>
</tr>
<tr>
	<td bgcolor="orange" width="70">고객 이름</td>
	<td align="left"><input name="customer_name" type="text" value="${customer.customer_name}"/></td>
</tr>
<tr>
	<td bgcolor="orange">전화 번호</td>
	<td align="left"><input name="customer_name" type="text" value="${customer.customer_phonenum}"/></td>
</tr>
<tr>
	<td bgcolor="orange">고객 주소</td>
	<td align="left"><input name="customer_name" type="text" value="${customer.customer_address}"/></td>
</tr>
<tr>
	<td colspan="2" align="center"><input type="submit" value="정보 수정"/></td>
</tr>
</table>
</form>
<a href="insertCustomer.jsp">고객 등록</a>&nbsp;&nbsp;&nbsp;
<a href="deleteCustomer.do?customer_num=${customer.customer_num}">고객 삭제</a>&nbsp;&nbsp;&nbsp;
<a href="getCustomerList.do">고객 목록</a>
</center>
</body>
</html>