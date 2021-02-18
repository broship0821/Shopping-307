<%@page import="com.team1.shopping307.controller.Common"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>장바구니</title>
    <link rel="stylesheet" href="css/BagSelectAll.css" />
    <style>
    #orderInfoTable{
    width: 100%;
    border-collapse:collapse;
	}
	
	#orderInfoTable td{
	    height: 50px;
	    border-top: 1px solid gray;
	    border-bottom: 1px solid gray;
	}
    </style>
</head>
<body>
    <h1 id="title">쇼핑 307 결제하기</h1>
    
    <form method="post">
	    <table id="bagTable">
	        <tr>
	            <td><!-- <input type="checkbox" name="" id="selectAllBox"> --></td>
	            <td>이미지</td>
	            <td>상품명</td>
	            <td>수량</td>
	            <td>상품금액</td>
	        </tr>
	        <c:forEach var="bagVO" items="${bagList}">
	        	<tr>
		            <td>
		            	<%-- <input type="checkbox" name="prodNo" class="box" value="${bagVO.getBagNo()}"> --%>
		            	<!-- hidden으로 상품아이디,개수 보냄 -->
		            	<input type="hidden" name="ProductID" value="${bagVO.getProductID()}">
		            	<input type="hidden" name="cnt" value="${bagVO.getProdCnt()}">
		            </td>
		            <td><img src="<%=Common.strUpload%>/${bagVO.getImage1()}" alt="상품사진들어갈곳" height="100"></td>
		            <td>${bagVO.getProdName()}</td>
		            <td>${bagVO.getProdCnt()}</td>
		            <td>
		            	<span class="price">
				            ${bagVO.getProdCnt()*bagVO.getProdPrice()}
		            	</span>
		            	원
		            </td>
	        	</tr>
	        </c:forEach>
	    </table><br><br>
	    
	    <h2>배송 정보</h2>
	    <table id="orderInfoTable">
	        <tr>
	            <td style="width: 10%;">받으시는 분</td>
	            <td><input type="text" name="name" id="" value="${u.getName() }"></td>
	        </tr>
	        <tr>
	            <td style="width: 10%;">우편번호</td>
	            <td><input type="text" name="zip" id="" value="${u.getZip() }"></td>
	        </tr>
	        <tr>
	            <td style="width: 10%;">주소</td>
	            <td>
	                <input type="text" name="address" id="" value="${u.getAddress() }">
	            </td>
	        </tr>
	        <tr>
	            <td style="width: 10%;">휴대전화</td>
	            <td><input type="tel" name="tel" id="" value="${u.getPhonenumber() }"></td>
	        </tr>
	        <tr>
	            <td style="width: 10%;">결제수단</td>
	            <td>
	                <input type="radio" name="cashOrCard" id="" value="C" checked="checked" >카드&nbsp;&nbsp;&nbsp;
	                <input type="radio" name="cashOrCard" id="" value="S" >현금
	            </td>
	        </tr>
	        <tr>
	        	<td style="width: 10%;">카드번호</td>
	        	<td><input type="text" name="cardNO" id="" value="44444"></td><!-- 임시로 해둠, 나중에 지우기 -->
	        </tr>
	    </table>
	    
	    <br><br>
	    <div id="allPrice">
	        총 주문 금액: 0원
	    </div>
	    
	    <div id="btns"><input type="submit" value="결제하기" class="btn" formaction="RelePayInsert.do">
	    </div>
    </form>
</body>
<script src="js/selectAllBox.js"></script>
<script src="js/getAllPrice.js"></script>
</html>