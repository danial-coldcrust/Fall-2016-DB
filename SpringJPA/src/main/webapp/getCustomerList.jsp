<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 위에꺼 임포트해야 JSTL에서 제공하는 <c:forEach> 태그사용가능 책 310쪽 참고 --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function Update(form) {
//alert("실행");
//var form = document.forms[seq];
//var form = document.forms.namedItem(seq);
//alert(form.elements[0].value);
//alert(form.elements[1].value);
//alert(form.elements[2].value);
//alert(form.elements[3].value);
//alert(form.elements[4].value);
//alert(form.elements[5].value);
form.action = 'updateCustomer.do'; 
form.submit(); 
} 
function Del(form) { 
form.action = 'deleteCustomer.do';
form.submit(); 
}
/* function Del(seq) { 
var form = document.forms[seq]; 
form.action = 'deleteCustomer.do';
form.submit(); 
}
function Select() { 
var form = document.forms['mult_form']; 
form.action = 'getCustomerList.do';
form.submit(); 
}  */
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>고객 목록</title>
</head>
<body>
<center>
<h1>고객 목록</h1>
<h3>${c_name}님! 환영합니다...<a href="customerLogOut.do">Log-out</a></h3>
<!-- 검색 시작 -->
<table border="1" cellpadding="0" cellspacing="0" width="700">

<tr>
	<td colspan="4" align="right">
	<form action="getCustomerList.do" method="post">
		<select name="searchCondition">
		<c:forEach items="${conditionMap}" var="option">
			<option value="${option.value}">${option.key}</option>
		</c:forEach>
		</select>
		<input name="searchKeyword" type="text" />
		<input type="submit" value="검색"/>
	</form>
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
	<form method="post">
	<td><input type="text" name="customer_num" value="${customer.customer_num}"/></td>
	<%-- <a href="getCustomer.do?customer_num=${customer.customer_num}"></a> --%>
	<td align="left"><input type="text" name="customer_name" value="${customer.customer_name}"/></td>
	<td><input type="text" name="customer_phonenum" value="${customer.customer_phonenum}"/></td>
	<td><input type="text" name="customer_address" value="${customer.customer_address}"/></td>
	<td><input type="button" value="수정" onclick="Update(this.form);"/></td>
	<td><input type="button" value="삭제" onclick="Del(this.form);"/></td>
	</form>
</tr>
</c:forEach>
<!-- 전체 목록 출력 종료 -->
<tr>
	<form action="insertCustomer.do" method="post">
	<!-- <td><input type="text" name="customer_num"/></td> -->
	<%-- <a href="getCustomer.do?customer_num=${customer.customer_num}"></a> --%>
	<td></td>
	<td align="left"><input type="text" name="customer_name" placeholder="이름"/></td>
	<td><input type="text" name="customer_phonenum" placeholder="번호"/></td>
	<td><input type="text" name="customer_address"placeholder="주소"/></td>
	<td><input type="submit" value="추가" /></td>
	</form>
</tr>
</table>
</center>
</body>
</html>