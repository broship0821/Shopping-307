<%@page import="com.team1.shopping307.controller.Common"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<%
		response.setCharacterEncoding("UTF-8");
	%>
	
		<table border="1">
		<tr>
				<td>구분번호</td>
				<td>구매자아이디</td>
				<td>구매자이름</td>
				<td>구매자전화번호</td>
				<td>구매자주소</td>
				<td>구매상품정보</td>
				<td>상태</td>
			</tr>
		<c:forEach var="p" items="${requestScope.1stAll}">
		<c:set var="param1" value="Payinfo.do?status=${p.payId}" />
			<tr>
				<td><a href="${param1}">${p.payId}</a></td> <!-- 구분번호 -->
				<td><a href="${param1}">${p.buyerId}</a></td> <!-- 구매자아이디 -->
				<td><a href="${param1}">${p.buyerName}</a></td> <!-- 구매자 이름 -->
				<td><a href="${param1}">${p.buyerPhone}</a></td> <!-- 구매자전화번호 -->
				<td><a href="${param1}">${p.buyerAddress}</a></td> <!-- 구매자주소 -->
				<td><a href="${param1}">${p.itemsInfo}</a></td> <!-- 구매상품정보 -->
				<td><a href="${param1}">${p.amount}</a></td> <!-- 결제금액 -->
				<td><a href="${param1}">${p.status}</a></td> <!-- 상태 -->
			</tr>
<!-- pay_id buyer_id, buyer_name, buyer_phone,
 buyer_address, items_info, amount, status, "결제승인"btn -->
		</table>
	</c:forEach>
</body>
</html>