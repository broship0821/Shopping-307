<%@page import="com.team1.shopping307.controller.Common"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑페이지</title>
<!-- 일반유저에게 보이는 쇼핑 페이지 -->
<!-- <script src="jquery-3.1.1.js" /> <!-- import JQuery -->
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- <script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script> -->

<script src="js/shopping307.js?ver=1"></script>

<%--
<script>
    $(function() {
	  sp307.getCategory("<%=Common.strCateGetComboAllDo%>", "<%=Common.strCateComboName%>");
    });
</script>
--%>

</head>

<body>
<%request.setCharacterEncoding("UTF-8");%>
<%response.setCharacterEncoding("UTF-8");%>
<!-- 카테고리, 상품명, 가격 사이즈(규격으로), 입고수령, 재고수량, 상품설명, 대표사진, 상세사진1, 상세사진2, 판매시작일 -->
	<h1>
		<p align="center">쇼핑 307</p>
	</h1>

<h1>쇼핑 307에 오신걸 환영합니다</h1>
<table border="2">
   <tr>
    <td align="center">대표 이미지</td>
    <td align="center">상품명</td>
  </tr>
  <c:forEach var="i" items="${requestScope.lstAll}">
  <c:set var="param1" value="ProdUserSelectOne.do?productId=${i.productId}" />
  <tr>
    <td><img src="<%=Common.strUpload%>/${i.image1}" width="100px" onClick="location.href='${param1}'"></td>

    <td><a href="${param1}">${i.productName}</a></td>
  </tr>
  </c:forEach>
</table>



</body>
</html>