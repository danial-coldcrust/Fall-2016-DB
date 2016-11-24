<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 위에꺼 임포트해야 <c:forEach> 이거 쓸수있음 책에안나옴 ㅅㅂ --%>
<%@ page import="com.ppp.db.customer.CustomerVO"%>
<%@ page import="java.util.List"%>
<%
	List<CustomerVO> customerList = (List) request.getAttribute("customerList");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
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
<tr>
	<th>고객번호</th>
	<th>고객이름</th>
	<th>전화번호</th>
	<th>고객주소</th>
</tr>
<%
	for (CustomerVO obj : customerList) {
%>
<tr>
	<td><%=obj.getCustomer_num()%></td>
	<td><%=obj.getCustomer_name()%></td>
	<td><%=obj.getCustomer_phonenum()%></td>
	<td><%=obj.getCustomer_address()%></td>
</tr>
<%
	}
%>
</table>
</form>
</body>
</html>