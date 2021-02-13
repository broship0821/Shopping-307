<%@page import="com.team1.shopping307.controller.Common"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- <script src="jquery-3.1.1.js" /> <!-- import JQuery -->
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- <script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script> -->

<script src="js/shopping307.js?ver=1"></script>
<script>
    $(function() {
	  sp307.getCategory("<%=Common.strCateGetComboAllDo%>", "<%=Common.strCateComboName%>");
    });
</script>

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
                <td align="center">상품ID</td>
                <td><input type="text" name="productId" readonly></td>
            </tr>
            <tr>
                <td align="center">상품명</td>
                <td><input type="text" name="productName" required></td>
            </tr>
            <tr>
                <td align="center">카테고리</td>
                <td><div id="<%=Common.strCateComboName%>">
                    <select name="category">
                        <option value="outer" name="outer">아우터</option>
                        <option value="top" name="top">상의</option>
                        <option value="bottom" name="bottom">상의</option>
                    </select>
                </div></td>
            </tr>
			<tr>
				<td align="center">신상/이월</td>
				<td>
					<select name="isNew">
						<option value="Y" name="Y" selected>신상</option>
						<option value="N" name="N">이월</option>
					</select>
				</td>
			</tr>
			<tr>
				<td align="center">규격</td>
				<td><input type="text" name="standard" required></td>
			</tr>
			<tr>
				<td align="center">가격</td>
				<td><input type="number" name="price" required></td>
			</tr>
			<tr>
				<td align="center">수량</td>
				<td><input type="number" name="stock"></td>
			</tr>
			<tr>
				<td align="center">상품설명</td>
				<td><textarea rows="5" cols="60" name="bigo"></textarea></td>
			</tr>
            <tr>
                <td align="center">판매시작일</td>
                <td><input type="date" name="startDate"></td>
            </tr>
			<tr>
				<td align="center">대표 이미지</td>
				<td><input type="file" name="iamge1"></td>
			</tr>
			<tr>
				<td align="center">상세이미지1</td>
				<td><input type="file" name="iamge2"></td>
			</tr>
			<tr>
				<td align="center">상세이미지2</td>
				<td><input type="file" name="iamge3"></td>
			</tr>

		</table>


		<table border="0">
			<tr>
				<td><input type="submit" value="등록" /> <input type="button"
					value="수정" onClick="#" /> <input type="button" value="삭제"
					onClick="#" /></td>
			</tr>
		</table>

	</form>
</body>
</html>