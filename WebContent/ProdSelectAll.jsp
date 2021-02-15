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

<h1>상품 리스트</h1>
<table border="2">
   <tr>
    <td align="center">대표 이미지</td>
<!--     <td align="center">상세이미지1</td> -->
<!--     <td align="center">상세이미지2</td> -->
    <td align="center">상품아이디</td>
    <td align="center">상품명</td>
    <td align="center">카테고리</td>
    <td align="center">신상/이월</td>
    <td align="-center">규격</td>
    <td align="center">가격</td>
    <td align="center">수량</td>
    <td align="center">상품설명</td>
    <td align="center">판매시작일</td>
  </tr>
  <c:forEach var="i" items="${requestScope.lstAll}">
  <c:set var="param1" value="ProdSelectOne.do?productId=${i.productId}" />
  <tr>
    <td><img src="<%=Common.strUpload%>/${i.image1}" width="100px" onClick="location.href='${param1}'"></td>

    <td><a href="${param1}">${i.productId}</a></td>
    <td><a href="${param1}">${i.productName}</a></td>
    <td><a href="${param1}">${i.category}</a></td>

    <td><a href="${param1}">${i.isNew}</a></td>
    <td><a href="${param1}">${i.standard}</a></td>
    <td><a href="${param1}">${i.price}</a></td>
    <td><a href="${param1}">${i.stock}</a></td>
    <td><a href="${param1}">${i.bigo}</a></td>
    <td><a href="${param1}">${i.startDate}</a></td>
  </tr>
  </c:forEach>
</table>

<input type="button" value="입력" 
       onClick="location.href='<%=Common.strProdInsert%><%=Common.strJsp%>'" />

</body>
</html>