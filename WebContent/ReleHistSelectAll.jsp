<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>상품 출고 기록</h1>
<div>
	<table border="1">
		<tr>
			<th alingh="center">발품 아이디</th>
			<th alingh="center">구매자 아이디</th>
			<th alingh="center">구매 품목</th>
			<th alingh="center">상품명</th>
			<th alingh="center">카테고리</th>
			<th alingh="center">신상</th>
			<th alingh="center">규격</th>
			<th alingh="center">상품 가격</th>
			<th alingh="center">상태</th>
			<th alingh="center">구매 날짜</th>
			<th alingh="center">수정 날짜</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="r" items="${releHistList}">
		<tr>
			<td>${r.releId }</td>
			<td>${r.userId }</td>
			<td>${r.prodId }</td>
			<td>${r.prodName }</td>
			<td>${r.caregory }</td>
			<td>${r.isNew }</td>
			<td>${r.standard }</td>
			<td>${r.price }</td>
			<td>${r.status }</td>
			<td>${r.cDate }</td>
			<td>${r.uDate }</td>
			<td><a href="ReleHistDelete.do?releId=${r.releId }"><input type="button" value="삭제"></a></td>
		</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>