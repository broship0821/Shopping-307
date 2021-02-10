<%@page import="com.team1.shopping307.controller.Common"%>
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
<%request.setCharacterEncoding("UTF-8");%>
<%response.setCharacterEncoding("UTF-8");%>
<!-- 카테고리, 상품명, 가격 사이즈(규격으로), 입고수령, 재고수량, 상품설명, 대표사진, 상세사진1, 상세사진2, 판매시작일 -->
	<h1>
		<p align="center">쇼핑 307</p>
	</h1>
	<h1>상품등록</h1>
	<br>
		 <form name="prodInsert" action="<%=Common.strProdInsertDo%>">
	<table border="1">
		<tr>
			<td>판매시작일</td>
			<td><input type="date" name="startDate"></td>
		</tr>
		<tr>
			<td>상품명 :</td>
			<td><input type="text" name="product_name" required></td>
		</tr>
		<tr>
			<td>카테고리 :</td>
			<td><input type="checkbox" name="clothes" value="outer">아우터
				<input type="checkbox" name="clothes" value="top">상의 
				<input type="checkbox" name="clothes" value="bottom">하의</td>
		</tr>
		<tr>
			<td>가격 :</td>
			<td><input type="number" name="price" required></td>
		</tr>
		<tr>
			<td>입고수량 :</td>
			<td><input type="number" name="warehousing"></td>
		</tr>
		<tr>
			<td>재고수량 :</td>
			<td><input type="number" name="stock"></td>
		</tr>
		<tr>
			<td>상품설명</td>
			<td><textarea rows="5" cols="60" name="info"></textarea></td>
		</tr>
		<tr>
			<td>대표 이미지 등록 :</td>
			<td><input type="file" name="iamge1"></td>
		</tr>
		<tr>
			<td>상세이미지1 :</td>
			<td><input type="file" name="iamge2"></td>
		</tr>
		<tr>
			<td>상세이미지2 :</td>
			<td><input type="file" name="iamge3"></td>
		</tr>
		
	 
	</table>


		<table border="0">
			<tr>
				<td>
                    <input type="submit" value="등록" />
                    <input type="button" value="수정" onClick="#" />
                    <input type="button" value="삭제" onClick="#" />
                </td>                    
			</tr>
		</table>
		
</form>
</body>
</html>