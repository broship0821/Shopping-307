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
	  sp307.getCategory("<%=Common.strCateGetComboAllDo%>", 
			  "<%=Common.strCateComboName%>", "${item.category}");
	  sp307.setComboItemText("isNew", "${item.isNew}");
    });
</script>

</head>

<body>
<%request.setCharacterEncoding("UTF-8");%>
<%response.setCharacterEncoding("UTF-8");%>
	<h1>
		<p align="center">쇼핑 307</p>
	</h1>
	<h1>상품수정</h1>
	<br>
	<script>
      console.log("2. [[${item.category}]]");
      console.log("2. [[${item.productName}]]");
    </script>
    
	<form name="prodUpdate" action="<%=Common.strProdUpdateDo%>">
	    <input type="hidden" name="productId" value="${item.productId}" />
		<table border="1">
            <tr>
                <td align="center">상품ID</td>
                <td>${item.productId}</td>
            </tr>
            <tr>
                <td align="center">상품명</td>
                <td><input type="text" name="productName" value="${item.productName}" required /></td>
            </tr>
            <tr>
                <td align="center">카테고리</td>
                <td>
                <div id="<%=Common.strCateComboName%>">
<%--                     <select name="category" id="<%=Common.strCateComboName%>" /> --%>
<!--                     </td> -->
                </div>
            </tr>
			<tr>
				<td align="center">신상/이월</td>
				<td>
					<select name="isNew" id="isNew">
						<option value="Y" name="Y">신상</option>
						<option value="N" name="N">이월</option>
					</select>
				</td>
			</tr>
			<tr>
				<td align="center">규격</td>
				<td><input type="text" name="standard" value="${item.standard} "required></td>
			</tr>
			<tr>
				<td align="center">가격</td>
				<td><input type="number" name="price" value="${item.price}" required></td>
			</tr>
			<tr>
				<td align="center">수량</td>
				<td><input type="number" name="stock" value="${item.stock}" required></td>
			</tr>
			<tr>
				<td align="center">상품설명</td>
				<td><textarea rows="5" cols="60" name="bigo">${item.bigo}</textarea></td>
			</tr>
            <tr>
                <td align="center">판매시작일</td>
                <td><input type="date" name="startDate" value="${item.startDate}"></td>
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

            <tr>
                <td align="center" colspan="2">
                    <input type="submit" value="수정" /> 
                    <input type="button" value="삭제" onClick="location.href='<%=Common.strProdDeleteDo%>?productId=${item.productId}'" />
                </td>
            </tr>
		</table>

	</form>
</body>
</html>