<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<form action="${pageContext.request.contextPath}/add" method="get">
		<table border="1" width="540px">
			<tr>
				<td>이름</td><td><input type="text" name="name"></td>
				<td>비밀번호</td><td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="4"><textarea cols="72" rows="5" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="4"><button type="submit">등록</button></td>
			</tr>
		</table>
	</form>
	<br>

	<c:forEach items="${gbList}" var="gbList">
		<table border="1" width="540px">
			<tr>
				<td>${gbList.no}</td>
				<td>${gbList.name}</td>
				<td>${gbList.regDate}</td>
				<td><a href="${pageContext.request.contextPath}/deleteform?no=${gbList.no}">삭제</a></td>
			</tr>
			<tr>
				<td colspan="4">${gbList.content}</td>
			</tr>
		</table>
		<br>
	</c:forEach>

</body>
</html>