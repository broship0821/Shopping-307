<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
input {
	width: 500px;
	height: 50px;
	font-size: 20px;
	display: table;
	margin-left: auto;
	margin-right: auto;
}

table {
	width: 500px;
	height: 50px;
	font-size: 20px;
	display: table;
	margin-left: auto;
	margin-right: auto;
}

div {
	text-align: center;
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
	<h1>
		<p align="center">구매후기</p>
	</h1>
	<hr width=40%>

	<input type="text" value="상품명" name="product_name" onclick="" />
	<br>
	<div>
		<td><a href=""><font size="5px" color="blue"> 검색</a></td> <br>
		</font>
	</div>
	<hr width=40%>
	<h1>
		<p align="center">상품검색 결과</p>
	</h1>
	<input type="text" value="상품명" name="product_name" onclick="" />
	<br>
	<div>
		<td><a href=""><font size="5px" color="blue"> 조회</a></td> <br>
		</font>
	</div>
</body>
</html>