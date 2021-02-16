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

<script src="js/shopping307.js?ver=3"></script>


</head>

<body>
<%request.setCharacterEncoding("UTF-8");%>
<%response.setCharacterEncoding("UTF-8");%>
	<h1>
		<p align="center">쇼핑 307</p>
	</h1>
	<h1>결제등록 </h1> <h2>-테스트용</h2>
	<br>
	<form method="post" action="<%=Common.strPayInsertDo%>">
		<table border="1">
            <tr>
                <td align="center">구매번호</td>
                <td>자동 생성</td>
            </tr>
            <tr>
                <td align="center">판매자 명</td>
                <td><input type="text" name="sellerName" required></td>
            </tr>
            <tr>
                <td align="center">판매자 전화</td>
                <td><input type="text" name="sellerPhone" required></td>
            </tr>
            <tr>
                <td align="center">판매자 우편번호</td>
                <td><input type="text" name="sellerZip" required></td>
            </tr>
            <tr>
                <td align="center">판매자 주소</td>
                <td><input type="text" name="sellerAddress" required></td>
            </tr>
            <tr>
                <td align="center">구매자 아이디</td>
                <td><input type="text" name="buyerId" required></td>
            </tr>
            <tr>
                <td align="center">구매자 명</td>
                <td><input type="text" name="buyerName" required></td>
            </tr>
            <tr>
                <td align="center">구매자 전화</td>
                <td><input type="text" name="buyerPhone" required></td>
            </tr>
            <tr>
                <td align="center">구매자 우편번호</td>
                <td><input type="text" name="buyerZip" required></td>
            </tr>
            <tr>
                <td align="center">구매자 주소</td>
                <td><input type="text" name="buyerAddress" required></td>
            </tr>
            <tr>
                <td align="center">구매상품정보</td>
                <td><textarea name="itemsInfo" rows="5" cols="60" required></textarea></td>
            </tr>
            <tr>
                <td align="center">결제금액</td>
                <td><input type="number" name="amount" required></td>
            </tr>
            <tr>
                <td align="center">결제수단</td>
                <td>
                    <select name="cashOrCard">
                        <option value="C" name="C">카드</option>
                        <option value="S" name="S">현금</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td align="center">카드번호</td>
                <td><input type="text" name="cardNo"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="등록" /> 
                    <input type="button" value="목록" 
                           onClick="location.href='<%=Common.strPaySelectAllDo%>'" />
                </td>
            </tr>
		</table>

	</form>
</body>
</html>