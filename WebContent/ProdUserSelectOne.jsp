<%@page import="com.team1.shopping307.controller.Common"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세보기</title>

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
	<a href="mainMenu.html">[메인페이지로]</a>
	<h1>
		<p align="center">쇼핑 307</p>
	</h1>
	<h1>상품 상세 페이지</h1>
	<br>
	<script>
      console.log("2. [[${item.category}]]");
      console.log("2. [[${item.productName}]]");
      console.log("2. [[${item.productId}]]");
    </script>
    
	<form name="prodUpdate" method="post" >
		<table border="1">
			<tr>
                <td align="center">상품사진</td>
                <td><img src="<%=Common.strUpload%>/${item.image1}" width="100px"></td>
            </tr>
            <tr>
                <td align="center">상품명</td>
                <td>${item.productName}</td>
            </tr>
            <tr>
                <td align="center">수량</td>
                <td><input type="number" name="prodCnt" value="1"></td>
            </tr>
			<tr>
				<td align="center">가격</td>
				<td>${item.price}</td>
			</tr>
			<tr>
				<td align="center">상품설명</td>
				<td>${item.bigo}</td>
			</tr>
            <tr>
                <td align="center" colspan="2">
                	<input type="hidden" name="image1" value="${item.image1}">
                	<input type="hidden" name="productId" value="${item.productId}">
                	<input type="hidden" name="prodName" value="${item.productName}">
                    <input type="hidden" name="prodPrice" value="${item.price}">
                    <input type="submit" value="장바구니에 담기" formaction="BagInsert.do" /> 
                    <input type="submit" value="후기쓰기" formaction="RevuInsert.do" />
                </td>
            </tr>
		</table>
		<a href="BagSelectAll.do"><input type="button" value="장바구니 보러가기"></a>
	</form>
</body>
</html>