<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 위에꺼 임포트해야 JSTL에서 제공하는 <c:forEach> 태그사용가능 책 310쪽 참고 --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function Update(form) {
form.action = 'updateSend.do'; 
form.submit(); 
} 
function Del(form) { 
form.action = 'deleteSend.do';
form.submit(); 
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>배송 목록</title>
</head>
<body>
<center>
<h1> 배송 목록</h1>
<%-- <h3>${s_name}님! 환영합니다...<a href="staffLogOut.do">Log-out</a></h3> --%>
<!-- 검색 시작 -->

<table border="1" cellpadding="0" cellspacing="0" width="700">
<tr>
	<td colspan="8" align="right">
		<form action="getSendList.do" method="post">
		<select name="searchCondition">
		<c:forEach items="${conditionMap}" var="option">
			<option value="${option.value}">${option.key}</option>
		</c:forEach>
		</select>
		<input name="searchKeyword" type="text" />
		<input type="submit"value="검색" />
		</form>
	</td>
</tr>
<!-- 검색 종료 -->
<!-- 전체 목록 출력 시작 -->
<tr>
	<th>처리 순번</th>
	<th>물품 번호</th>
	<th>직원 번호</th>
	<th>날 짜</th>
	<th>시 간</th>
	<th>물품 위치</th>
	<th>처리 내용</th>
	<th>수신자</th>
	<th>고객 번호</th>
</tr>
<c:forEach items= "${sendList}" var="send">
<tr>
	<form method="post">
	<td><input type="text" name="send_num" value="${send.send_num}" /></td>
	<td><input type="text" name="item_num" value="${send.item_num}"/></td>
	<td><input type="text" name="staff_num" value="${send.staff_num}"/></td>
	<td>${send.date}<%-- <input type="text" name="date" value="${send.date}"/> --%></td>
	<td>${send.time}<%-- <input type="text" name="time" value="${send.time}"/> --%></td>
	<td><input type="text" name="item_position" value="${send.item_position}"/></td>
	<td><input type="text" name="handling_state" value="${send.handling_state}"/></td>
	<td><input type="text" name="receiver_name" value="${send.receiver_name}"/></td>
	<td><input type="text" name="customer_num" value="${send.customer_num}"/></td>
	<td><input type="button" value="수정" onclick="Update(this.form);"/></td>
	<td><input type="button" value="삭제" onclick="Del(this.form);"/></td>
	</form>
</tr>
</c:forEach>
<!-- 전체 목록 출력 종료 -->
<tr>
	<form action="insertSend.do" method="post">
	<td><input type="text" name="send_num" placeholder="처리 순번"/></td>
	<td><input type="text" name="item_num" placeholder="물품 번호"/></td>
	<td><input type="text" name="staff_num" placeholder="직원 번호"/></td>
<!-- 	<td><input type="text" name="date" placeholder="날짜"/></td>
	<td><input type="text" name="time" placeholder="시간"/></td> -->
	<td></td>
	<td></td>
	<td><input type="text" name="item_position" placeholder="물품 위치"/></td>
	<td><input type="text" name="handling_state" placeholder="처리 내용"/></td>
	<td><input type="text" name="receiver_name" placeholder="수신자"/></td>
	<td><input type="text" name="customer_num" placeholder="고객 번호"/></td>
	<td><input type="submit" value="추가" /></td>
	</form>
</tr>
</table>
</center>
</body>
</html>