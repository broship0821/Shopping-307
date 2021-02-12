<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, th, td {
	border: 1px solid #bcbcbc;
}

th {
	background-color: #BDBDBD;
}

table {
	margin-left: auto;
	margin-right: auto;
}
</style>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<%
		response.setCharacterEncoding("UTF-8");
	%>
	<h1>
		<p align="center">쇼핑 307</p>
	</h1>
	<table border=1>
		<tr>
			<th>구매자명</th>
			<th>상품명</th>
			<th>결제여부 / 승인</th>
			<th>배송처리</th>
			<th>교환 / 환불</th>
		</tr>
		<tr>
			<td><input type="text" name="buyer_name"></td>
			<td><input type="text" name="product_name"></td>
			<td><input type="text" name="payed"></td>
			<td><form>
					<select name="Shipping">
						<option value="none">=== 선택 ===</option>
						<option value="Preparing">배송준비중</option>
						<option value="Shipped">배송중</option>
						<option value="completed">배송완료</option>
					</select>
				</form></td>
			<td><form>
					<select name="ExchangeRefund ">
						<option value="none">=== 선택 ===</option>
						<option value="exchange">교환</option>
						<option value="refund">환불</option>
					</select>
				</form></td>
		</tr>
	</table>
	<table border="0">
		<tr>
			<td><a href="">저장</a></td>
		</tr>
	</table>

</body>
</html>