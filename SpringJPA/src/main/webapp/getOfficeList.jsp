<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 위에꺼 임포트해야 JSTL에서 제공하는 <c:forEach> 태그사용가능 책 310쪽 참고 --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function Update(form) {
form.action = 'updateOffice.do'; 
form.submit(); 
} 
function Del(form) { 
form.action = 'deleteOffice.do';
form.submit(); 
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>지점 목록</title>
</head>
<body>
<center>
<h1>지점 목록</h1>

<!-- 검색 시작 -->
<table border="1" cellpadding="0" cellspacing="0" width="700">
<tr>
	<td colspan="5" align="right">
		<form action="getOfficeList.do" method="post">
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
	<th>지점 번호</th>
	<th>지점 이름</th>
	<th>지점 주소</th>
	<th>전화 번호</th>
	<th>팩스 번호</th>
</tr>
<c:forEach items="${officeList}" var="office">
<tr>
	<form method="post">
	<td><input type="text" name="office_num" value="${office.office_num}"/></td>
	<td><input type="text" name="office_name" value="${office.office_name}"/></td>
	<td><input type="text" name="office_address" value="${office.office_address}"/></td>
	<td><input type="text" name="office_phonenum" value="${office.office_phonenum}"/></td>
	<td><input type="text" name="office_paxnum" value="${office.office_paxnum}"/></td>
	<td><input type="button" value="수정" onclick="Update(this.form);"/></td>
	<td><input type="button" value="삭제" onclick="Del(this.form);"/></td>
	</form>
</tr>
</c:forEach>
<!-- 전체 목록 출력 종료 -->
<tr>
	<form action="insertOffice.do" method="post">
	<td><input type="text" name="office_num" placeholder="지점 번호"/></td>
	<td><input type="text" name="office_name" placeholder="지점 이름"/></td>
	<td><input type="text" name="office_address" placeholder="지점 주소"/></td>
	<td><input type="text" name="office_phonenum" placeholder="전화 번호"/></td>
	<td><input type="text" name="office_paxnum" placeholder="팩스 번호"/></td>
	<td><input type="submit" value="추가" /></td>
	</form>
</tr>
</table>
</center>
</body>
</html>